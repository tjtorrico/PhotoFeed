package net.tjtorrico.photofeed.photomap.ui;

import net.tjtorrico.photofeed.entities.Photo;

/**
 * Created by TJT on 08/07/2016.
 */
public interface PhotoMapView {
    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
