package net.tjtorrico.photofeed.photolist.di;

import net.tjtorrico.photofeed.PhotoFeedAppModule;
import net.tjtorrico.photofeed.domain.di.DomainModule;
import net.tjtorrico.photofeed.libs.di.LibsModule;
import net.tjtorrico.photofeed.photolist.ui.PhotoListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TJT on 07/07/2016.
 */
@Singleton
@Component(modules = {PhotoListModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoListComponent {
    void inject(PhotoListFragment fragment);
}
