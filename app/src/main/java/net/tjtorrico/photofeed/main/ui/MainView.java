package net.tjtorrico.photofeed.main.ui;

/**
 * Created by TJT on 04/07/2016.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
