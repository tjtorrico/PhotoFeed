package net.tjtorrico.photofeed.main;

import android.location.Location;

/**
 * Created by TJT on 04/07/2016.
 */
public interface MainRepository {
    void logout();
    void uploadPhoto(Location location, String path);
}
