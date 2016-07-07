package net.tjtorrico.photofeed.photolist.ui;

import net.tjtorrico.photofeed.entities.Photo;

/**
 * Created by TJT on 07/07/2016.
 */
public interface PhotoListView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
