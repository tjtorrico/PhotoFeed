package net.tjtorrico.photofeed.main;

import android.location.Location;

import net.tjtorrico.photofeed.domain.FirebaseAPI;
import net.tjtorrico.photofeed.entities.Photo;
import net.tjtorrico.photofeed.libs.base.EventBus;
import net.tjtorrico.photofeed.libs.base.ImageStorage;
import net.tjtorrico.photofeed.libs.base.ImageStorageFinishedListener;
import net.tjtorrico.photofeed.main.events.MainEvent;

import java.io.File;

/**
 * Created by TJT on 04/07/2016.
 */
public class MainRepositoryImpl implements MainRepository{
    private EventBus eventBus;
    private FirebaseAPI firebaseAPI;
    private ImageStorage imageStorage;

    public MainRepositoryImpl(EventBus eventBus, FirebaseAPI firebaseAPI, ImageStorage imageStorage) {
        this.eventBus = eventBus;
        this.firebaseAPI = firebaseAPI;
        this.imageStorage = imageStorage;
    }

    @Override
    public void logout() {
        firebaseAPI.logout();
    }

    @Override
    public void uploadPhoto(Location location, String path) {
        final String newPhotoId = firebaseAPI.create();
        final Photo photo = new Photo();
        photo.setId(newPhotoId);
        photo.setEmail(firebaseAPI.getAuthEmail());
        if(location != null){
            photo.setLatitutde(location.getLatitude());
            photo.setLongitude(location.getLongitude());
        }
        post(MainEvent.UPLOAD_INIT);

        ImageStorageFinishedListener listener = new ImageStorageFinishedListener() {
            @Override
            public void onSuccess() {
                String url = imageStorage.getImageUrl(newPhotoId);
                photo.setUrl(url);
                firebaseAPI.update(photo);
                post(MainEvent.UPLOAD_COMPLETE);
            }

            @Override
            public void onError(String error) {
                post(MainEvent.UPLOAD_ERROR, error);
            }
        };

        imageStorage.upload(new File(path), newPhotoId, listener);
    }

    private void post(int type) {
        post(type, null);
    }

    private void post(int type, String error) {
        MainEvent event = new MainEvent();
        event.setType(type);
        event.setError(error);
        eventBus.post(event);
    }
}
