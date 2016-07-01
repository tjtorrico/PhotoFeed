package net.tjtorrico.photofeed.libs.di;

import net.tjtorrico.photofeed.PhotoFeedAppModule;
import net.tjtorrico.photofeed.domain.di.DomainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TJT on 01/07/2016.
 */
@Singleton
@Component(modules = {LibsComponent.class, PhotoFeedAppModule.class})
public interface LibsComponent {
}
