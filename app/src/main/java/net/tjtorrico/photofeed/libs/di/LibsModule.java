package net.tjtorrico.photofeed.libs.di;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.cloudinary.Cloudinary;
import com.cloudinary.android.Utils;

import net.tjtorrico.photofeed.domain.Util;
import net.tjtorrico.photofeed.libs.CloudinaryImageStorage;
import net.tjtorrico.photofeed.libs.GlideImageLoader;
import net.tjtorrico.photofeed.libs.GreenRobotEventBus;
import net.tjtorrico.photofeed.libs.base.EventBus;
import net.tjtorrico.photofeed.libs.base.ImageLoader;
import net.tjtorrico.photofeed.libs.base.ImageStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 27/06/2016.
 */
@Module
public class LibsModule {
    private Fragment fragment;

    public LibsModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(Fragment fragment) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (fragment != null) {
            imageLoader.setLoaderContext(fragment);
        }
        return imageLoader;
    }

    @Provides
    @Singleton
    RequestManager providesRequestManager (Fragment fragment){
        return Glide.with(fragment);
    }

    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }

    @Provides
    @Singleton
    EventBus provideEventBus(org.greenrobot.eventbus.EventBus eventBus) {
        return new GreenRobotEventBus(eventBus);
    }

    @Provides
    @Singleton
    org.greenrobot.eventbus.EventBus providesLibraryEventBus(){
        return org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Provides
    @Singleton
    ImageStorage provideImageStorage(Cloudinary cloudinary) {
        return new CloudinaryImageStorage(cloudinary);
    }

    @Provides
    @Singleton
    Cloudinary providesCloudinary(Context context){
        return new Cloudinary(Utils.cloudinaryUrlFromContext(context));
    }
}
