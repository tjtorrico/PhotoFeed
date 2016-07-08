package net.tjtorrico.photofeed.photomap;

import net.tjtorrico.photofeed.photomap.events.PhotoMapEvent;

/**
 * Created by TJT on 08/07/2016.
 */
public interface PhotoMapPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void onEventMainThread(PhotoMapEvent event);
}
