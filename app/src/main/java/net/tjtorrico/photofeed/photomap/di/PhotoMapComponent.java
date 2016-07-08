package net.tjtorrico.photofeed.photomap.di;

import net.tjtorrico.photofeed.PhotoFeedAppModule;
import net.tjtorrico.photofeed.domain.di.DomainModule;
import net.tjtorrico.photofeed.libs.di.LibsModule;
import net.tjtorrico.photofeed.photomap.ui.PhotoMapFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TJT on 08/07/2016.
 */
@Singleton
@Component(modules = {PhotoMapModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoMapComponent {
    void inject(PhotoMapFragment fragment);
}