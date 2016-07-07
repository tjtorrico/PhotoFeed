package net.tjtorrico.photofeed.main;

import android.location.Location;

/**
 * Created by TJT on 04/07/2016.
 */
public class UploadInteractorImpl implements UploadInteractor{

    private MainRepository repository;

    public UploadInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Location location, String path) {
        repository.uploadPhoto(location, path);
    }
}
