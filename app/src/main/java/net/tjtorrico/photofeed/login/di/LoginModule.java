package net.tjtorrico.photofeed.login.di;

import net.tjtorrico.photofeed.domain.FirebaseAPI;
import net.tjtorrico.photofeed.libs.base.EventBus;
import net.tjtorrico.photofeed.login.LoginInteractor;
import net.tjtorrico.photofeed.login.LoginInteractorImpl;
import net.tjtorrico.photofeed.login.LoginPresenter;
import net.tjtorrico.photofeed.login.LoginPresenterImpl;
import net.tjtorrico.photofeed.login.LoginRepository;
import net.tjtorrico.photofeed.login.LoginRepositoryImpl;
import net.tjtorrico.photofeed.login.ui.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 04/07/2016.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LoginView providesLoginView() {
        return this.view;
    }

    @Provides
    @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor);
    }

    @Provides
    @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository) {
        return new LoginInteractorImpl(repository);
    }

    @Provides
    @Singleton
    LoginRepository providesLoginRepository(EventBus eventBus, FirebaseAPI firebase) {
        return new LoginRepositoryImpl(eventBus, firebase);
    }
}
