package net.tjtorrico.photofeed.photolist.di;

import net.tjtorrico.photofeed.domain.FirebaseAPI;
import net.tjtorrico.photofeed.domain.Util;
import net.tjtorrico.photofeed.entities.Photo;
import net.tjtorrico.photofeed.libs.base.EventBus;
import net.tjtorrico.photofeed.libs.base.ImageLoader;
import net.tjtorrico.photofeed.photolist.PhotoListInteractor;
import net.tjtorrico.photofeed.photolist.PhotoListInteractorImpl;
import net.tjtorrico.photofeed.photolist.PhotoListPresenter;
import net.tjtorrico.photofeed.photolist.PhotoListPresenterImpl;
import net.tjtorrico.photofeed.photolist.PhotoListRepository;
import net.tjtorrico.photofeed.photolist.PhotoListRepositoryImpl;
import net.tjtorrico.photofeed.photolist.ui.PhotoListView;
import net.tjtorrico.photofeed.photolist.ui.adapters.OnItemClickListener;
import net.tjtorrico.photofeed.photolist.ui.adapters.PhotoListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 07/07/2016.
 */
@Module
public class PhotoListModule {
    private PhotoListView view;
    private OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides
    @Singleton
    PhotoListView providesPhotoListView() {
        return this.view;
    }

    @Provides
    @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListView view, PhotoListInteractor listInteractor) {
        return new PhotoListPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides
    @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository) {
        return new PhotoListInteractorImpl(repository);
    }

    @Provides
    @Singleton
    PhotoListRepository providesPhotoListRepository(EventBus eventBus, FirebaseAPI firebaseAPI) {
        return new PhotoListRepositoryImpl(eventBus, firebaseAPI);
    }

    @Provides
    @Singleton
    PhotoListAdapter providesPhotoListAdapter(Util utils, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new PhotoListAdapter(utils, photoList, imageLoader, onItemClickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides
    @Singleton
    List<Photo> providesPhotosList() {
        return new ArrayList<Photo>();
    }
}
