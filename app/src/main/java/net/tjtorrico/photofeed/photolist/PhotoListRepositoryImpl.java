package net.tjtorrico.photofeed.photolist;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;

import net.tjtorrico.photofeed.domain.FirebaseAPI;
import net.tjtorrico.photofeed.domain.FirebaseActionListenerCallback;
import net.tjtorrico.photofeed.domain.FirebaseEventListenerCallback;
import net.tjtorrico.photofeed.entities.Photo;
import net.tjtorrico.photofeed.libs.base.EventBus;
import net.tjtorrico.photofeed.photolist.events.PhotoListEvent;

/**
 * Created by TJT on 07/07/2016.
 */
public class PhotoListRepositoryImpl implements PhotoListRepository{
    private EventBus eventBus;
    private FirebaseAPI firebaseAPI;

    public PhotoListRepositoryImpl(EventBus eventBus, FirebaseAPI firebaseAPI) {
        this.eventBus = eventBus;
        this.firebaseAPI = firebaseAPI;
    }

    @Override
    public void subscribe() {
        firebaseAPI.checkForData(new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(FirebaseError error) {
                if(error != null){
                    post(PhotoListEvent.READ_EVENT, error.getMessage());
                } else {
                    post(PhotoListEvent.READ_EVENT, "");
                }
            }
        });

        firebaseAPI.subscribe(new FirebaseEventListenerCallback() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());

                String email = firebaseAPI.getAuthEmail();
                boolean publishedByMy = photo.getEmail().equals(email);
                photo.setPublishedByMe(publishedByMy);

                post(PhotoListEvent.READ_EVENT, photo);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());
                post(PhotoListEvent.DELETE_EVENT, photo);
            }

            @Override
            public void onCancelled(FirebaseError error) {
                post(PhotoListEvent.READ_EVENT, error.getMessage());
            }
        });
    }

    @Override
    public void unsubscribe() {
        firebaseAPI.unsubscribe();
    }

    @Override
    public void remove(final Photo photo) {
        firebaseAPI.remove(photo, new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {
                post(PhotoListEvent.DELETE_EVENT, photo);
            }

            @Override
            public void onError(FirebaseError error) {
                post(PhotoListEvent.READ_EVENT, error.getMessage());
            }
        });
    }

    private void post(int type, Photo photo) {
        post(type, null, photo);
    }

    private void post(int type, String error) {
        post(type, error, null);
    }

    private void post(int type, String error, Photo photo) {
        PhotoListEvent event = new PhotoListEvent();
        event.setType(type);
        event.setError(error);
        event.setPhoto(photo);
        eventBus.post(event);
    }
}
