package net.tjtorrico.photofeed.libs.base;

/**
 * Created by TJT on 01/07/2016.
 */
public interface ImageStorageFinishedListener {
    void onSuccess();

    void onError(String error);
}
