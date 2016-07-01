package net.tjtorrico.photofeed;

import android.app.Application;

import com.firebase.client.Firebase;

import net.tjtorrico.photofeed.domain.di.DomainModule;

/**
 * Created by TJT on 01/07/2016.
 */
public class PhotoFeedApp extends Application {
    private final static String EMAIL_KEY = "email";
    private final static String SHARED_PREFERENCES_NAME = "UserPrefs";
    private final static String FIREBASE_URL = "https://photofeed-tjt.firebaseio.com/";

    private DomainModule domainModule;
    private PhotoFeedAppModule photoFeedAppModule;


    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        photoFeedAppModule = new PhotoFeedAppModule(this);
        domainModule = new DomainModule(FIREBASE_URL);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);

    }

    public String getEmailKey() {
        return EMAIL_KEY;
    }

    public String getSharedPreferencesName() {
        return SHARED_PREFERENCES_NAME;
    }

    public String getFirebaseUrl() {
        return FIREBASE_URL;
    }
}
