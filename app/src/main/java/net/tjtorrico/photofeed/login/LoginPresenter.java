package net.tjtorrico.photofeed.login;


import net.tjtorrico.photofeed.login.events.LoginEvent;

/**
 * Created by TJT on 13/06/2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
