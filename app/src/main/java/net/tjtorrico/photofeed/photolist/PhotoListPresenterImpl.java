package net.tjtorrico.photofeed.photolist;

import net.tjtorrico.photofeed.entities.Photo;
import net.tjtorrico.photofeed.libs.base.EventBus;
import net.tjtorrico.photofeed.photolist.events.PhotoListEvent;
import net.tjtorrico.photofeed.photolist.ui.PhotoListView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by TJT on 07/07/2016.
 */
public class PhotoListPresenterImpl implements PhotoListPresenter{
    private EventBus eventBus;
    private PhotoListView view;
    private PhotoListInteractor interactor;
    private static final String EMPTY_LIST = "Listado vacío";

    public PhotoListPresenterImpl(EventBus eventBus, PhotoListView view, PhotoListInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        eventBus.unregister(this);
    }

    @Override
    public void subscribe() {
        if(view != null){
            view.hideList();
            view.showProgress();
        }
        interactor.subscribe();
    }

    @Override
    public void unsubscribe() {
        interactor.unsubscribe();
    }

    @Override
    public void removePhoto(Photo photo) {
        interactor.removePhoto(photo);
    }

    @Override
    @Subscribe
    public void onEventMainThread(PhotoListEvent event) {
        if(view != null){
            view.hideProgress();
            view.showList();
        }
        String error = event.getError();
        if(error != null){
            if(error.isEmpty()){
                view.onPhotosError(EMPTY_LIST);
            } else {
                view.onPhotosError(error);
            }
        } else {
            if(event.getType() == PhotoListEvent.READ_EVENT){
                view.addPhoto(event.getPhoto());
            } else if(event.getType() == PhotoListEvent.DELETE_EVENT){
                view.removePhoto(event.getPhoto());
            }
        }
    }
}
