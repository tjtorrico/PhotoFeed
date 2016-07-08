package net.tjtorrico.photofeed.photomap;

/**
 * Created by TJT on 08/07/2016.
 */
public class PhotoMapInteractorImpl implements PhotoMapInteractor{
    private PhotoMapRepository repository;

    public PhotoMapInteractorImpl(PhotoMapRepository repository) {
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
}
