package net.tjtorrico.photofeed.photolist.ui.adapters;

import android.widget.ImageView;

import net.tjtorrico.photofeed.entities.Photo;

/**
 * Created by TJT on 07/07/2016.
 */
public interface OnItemClickListener {
    void onPlaceClick(Photo photo);
    void onShareClick(Photo photo, ImageView img);
    void onDeleteClick(Photo photo);
}
