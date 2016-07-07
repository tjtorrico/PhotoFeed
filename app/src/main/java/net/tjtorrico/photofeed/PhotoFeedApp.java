package net.tjtorrico.photofeed;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.firebase.client.Firebase;

import net.tjtorrico.photofeed.domain.di.DomainModule;
import net.tjtorrico.photofeed.libs.di.LibsModule;
import net.tjtorrico.photofeed.login.di.DaggerLoginComponent;
import net.tjtorrico.photofeed.login.di.LoginComponent;
import net.tjtorrico.photofeed.login.di.LoginModule;
import net.tjtorrico.photofeed.login.ui.LoginView;
import net.tjtorrico.photofeed.main.di.DaggerMainComponent;
import net.tjtorrico.photofeed.main.di.MainComponent;
import net.tjtorrico.photofeed.main.di.MainModule;
import net.tjtorrico.photofeed.main.ui.MainView;

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

    public LoginComponent getLoginComponent(LoginView view) {
        return DaggerLoginComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(null))
                .loginModule(new LoginModule(view))
                .build();
    }

    public MainComponent getMainComponent(MainView view, FragmentManager manager, Fragment[] fragments, String[] titles) {
        return DaggerMainComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(null))
                .mainModule(new MainModule(view, titles, fragments, manager))
                .build();
    }
}
