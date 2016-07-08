package net.tjtorrico.photofeed.photomap.di;

import net.tjtorrico.photofeed.domain.FirebaseAPI;
import net.tjtorrico.photofeed.libs.base.EventBus;
import net.tjtorrico.photofeed.photomap.PhotoMapInteractor;
import net.tjtorrico.photofeed.photomap.PhotoMapInteractorImpl;
import net.tjtorrico.photofeed.photomap.PhotoMapPresenter;
import net.tjtorrico.photofeed.photomap.PhotoMapPresenterImpl;
import net.tjtorrico.photofeed.photomap.PhotoMapRepository;
import net.tjtorrico.photofeed.photomap.PhotoMapRepositoryImpl;
import net.tjtorrico.photofeed.photomap.ui.PhotoMapView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 08/07/2016.
 */
@Module
public class PhotoMapModule {
    PhotoMapView view;

    public PhotoMapModule(PhotoMapView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    PhotoMapView providesPhotoMapView() {
        return this.view;
    }

    @Provides
    @Singleton
    PhotoMapPresenter providesPhotoMapPresenter(EventBus eventBus, PhotoMapView view, PhotoMapInteractor listInteractor) {
        return new PhotoMapPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides
    @Singleton
    PhotoMapInteractor providesPhotoMapInteractor(PhotoMapRepository repository) {
        return new PhotoMapInteractorImpl(repository);
    }

    @Provides
    @Singleton
    PhotoMapRepository providesPhotoMapRepository(EventBus eventBus, FirebaseAPI firebaseAPI) {
        return new PhotoMapRepositoryImpl(eventBus, firebaseAPI);
    }
}
