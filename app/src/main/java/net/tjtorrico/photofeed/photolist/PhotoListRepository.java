package net.tjtorrico.photofeed.photolist;

import net.tjtorrico.photofeed.entities.Photo;

/**
 * Created by TJT on 07/07/2016.
 */
public interface PhotoListRepository {
    void subscribe();
    void unsubscribe();
    void remove(Photo photo);
}
