package net.tjtorrico.photofeed.login;

/**
 * Created by TJT on 13/06/2016.
 */
public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
}
