package net.tjtorrico.photofeed.main.di;

import net.tjtorrico.photofeed.PhotoFeedAppModule;
import net.tjtorrico.photofeed.domain.di.DomainModule;
import net.tjtorrico.photofeed.libs.di.LibsModule;
import net.tjtorrico.photofeed.main.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TJT on 07/07/2016.
 */
@Singleton
@Component(modules = {MainModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
