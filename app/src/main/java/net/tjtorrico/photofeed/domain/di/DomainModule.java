package net.tjtorrico.photofeed.domain.di;

import android.content.Context;
import android.location.Geocoder;

import com.firebase.client.Firebase;

import net.tjtorrico.photofeed.domain.FirebaseAPI;
import net.tjtorrico.photofeed.domain.Util;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 01/07/2016.
 */
@Module
public class DomainModule {
    String firebaseURL;

    public DomainModule(String firebaseURL) {
        this.firebaseURL = firebaseURL;
    }

    @Provides
    @Singleton
    FirebaseAPI providesFirebaseAPI(Firebase firebase){
        return new FirebaseAPI(firebase);
    }

    @Provides
    @Singleton
    Firebase providesFirebase(String firebaseURL){
        return new Firebase(firebaseURL);
    }

    @Provides
    @Singleton
    String providesFirebaseURL(){
        return this.firebaseURL;
    }

    @Provides
    @Singleton
    Util providesUtil(Geocoder geocoder){
        return new Util(geocoder);
    }

    @Provides
    @Singleton
    Geocoder providesGeocoder(Context context){
        return new Geocoder(context);
    }
}
