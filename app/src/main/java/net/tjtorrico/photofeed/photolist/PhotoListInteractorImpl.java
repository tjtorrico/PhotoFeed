package net.tjtorrico.photofeed.photolist;

import net.tjtorrico.photofeed.entities.Photo;

/**
 * Created by TJT on 07/07/2016.
 */
public class PhotoListInteractorImpl implements PhotoListInteractor{
    private PhotoListRepository repository;

    public PhotoListInteractorImpl(PhotoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void subscribe() {
        repository.subscribe();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribe();
    }

    @Override
    public void removePhoto(Photo photo) {
        repository.remove(photo);
    }
}
