package net.tjtorrico.photofeed.main;

import android.location.Location;

import net.tjtorrico.photofeed.main.events.MainEvent;

/**
 * Created by TJT on 04/07/2016.
 */
public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void logout();
    void uploadPhoto(Location location, String path);
    void onEventMainThread(MainEvent event);
}
