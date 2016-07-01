package net.tjtorrico.photofeed;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 01/07/2016.
 */
@Module
public class PhotoFeedAppModule {
    PhotoFeedApp app;

    public PhotoFeedAppModule(PhotoFeedApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context providesApplicationContext(){
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application){
        return application.getSharedPreferences(app.getSharedPreferencesName(), Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Application providesApplicaction(){
        return this.app;
    }
}
