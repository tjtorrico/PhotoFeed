package net.tjtorrico.photofeed.main;

/**
 * Created by TJT on 04/07/2016.
 */
public class SessionInteractorImpl implements SessionInteractor{

    private MainRepository repository;

    public SessionInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logout() {
        repository.logout();
    }
}
