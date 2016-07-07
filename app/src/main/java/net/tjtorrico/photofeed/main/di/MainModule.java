package net.tjtorrico.photofeed.main.di;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import net.tjtorrico.photofeed.domain.FirebaseAPI;
import net.tjtorrico.photofeed.libs.base.EventBus;
import net.tjtorrico.photofeed.libs.base.ImageStorage;
import net.tjtorrico.photofeed.main.MainPresenter;
import net.tjtorrico.photofeed.main.MainPresenterImpl;
import net.tjtorrico.photofeed.main.MainRepository;
import net.tjtorrico.photofeed.main.MainRepositoryImpl;
import net.tjtorrico.photofeed.main.SessionInteractor;
import net.tjtorrico.photofeed.main.SessionInteractorImpl;
import net.tjtorrico.photofeed.main.UploadInteractor;
import net.tjtorrico.photofeed.main.UploadInteractorImpl;
import net.tjtorrico.photofeed.main.ui.MainView;
import net.tjtorrico.photofeed.main.ui.adapter.MainSectionsPagerAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 07/07/2016.
 */
@Module
public class MainModule {
    private MainView view;
    private String[] titles;
    private Fragment[] fragments;
    private FragmentManager fragmentManager;

    public MainModule(MainView view, String[] titles, Fragment[] fragments, FragmentManager fragmentManager) {
        this.view = view;
        this.titles = titles;
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
    }

    @Provides
    @Singleton
    MainView providesMainView() {
        return this.view;
    }

    @Provides @Singleton
    MainPresenter providesMainPresenter(MainView view, EventBus eventBus, UploadInteractor uploadInteractor, SessionInteractor sessionInteractor) {
        return new MainPresenterImpl(view, eventBus, uploadInteractor, sessionInteractor);
    }

    @Provides @Singleton
    UploadInteractor providesUploadInteractor(MainRepository repository) {
        return new UploadInteractorImpl(repository);
    }

    @Provides @Singleton
    SessionInteractor providesSessionInteractor(MainRepository repository) {
        return new SessionInteractorImpl(repository);
    }

    @Provides @Singleton
    MainRepository providesMainRepository(EventBus eventBus, FirebaseAPI firebase, ImageStorage imageStorage) {
        return new MainRepositoryImpl(eventBus, firebase, imageStorage);
    }

    @Provides @Singleton
    MainSectionsPagerAdapter providesAdapter(FragmentManager fm, Fragment[] fragments, String[] titles){
        return new MainSectionsPagerAdapter(fm, fragments, titles);
    }

    @Provides @Singleton
    FragmentManager providesAdapterFragmentManager(){
        return this.fragmentManager;
    }

    @Provides @Singleton
    Fragment[] providesFragmentArrayForAdapter(){
        return this.fragments;
    }

    @Provides @Singleton
    String[] providesStringArrayForAdapter(){
        return this.titles;
    }
}
