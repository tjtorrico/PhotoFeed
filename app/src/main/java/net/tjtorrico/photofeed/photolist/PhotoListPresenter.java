package net.tjtorrico.photofeed.photolist;

import net.tjtorrico.photofeed.entities.Photo;
import net.tjtorrico.photofeed.photolist.events.PhotoListEvent;

/**
 * Created by TJT on 07/07/2016.
 */
public interface PhotoListPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void removePhoto(Photo photo);
    void onEventMainThread(PhotoListEvent event);
}
