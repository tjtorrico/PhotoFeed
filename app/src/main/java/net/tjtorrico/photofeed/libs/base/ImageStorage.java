package net.tjtorrico.photofeed.libs.base;

import java.io.File;

/**
 * Created by TJT on 01/07/2016.
 */
public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
