package net.tjtorrico.photofeed.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by TJT on 01/07/2016.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
