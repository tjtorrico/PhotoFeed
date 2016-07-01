package net.tjtorrico.photofeed.domain;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;

/**
 * Created by TJT on 01/07/2016.
 */
public interface FirebaseEventListenerCallback {
    void onChildAdded(DataSnapshot dataSnapshot);
    void onChildRemoved(DataSnapshot dataSnapshot);
    void onCancelled(FirebaseError error);
}
