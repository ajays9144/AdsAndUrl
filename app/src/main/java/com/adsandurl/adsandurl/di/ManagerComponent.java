package com.adsandurl.adsandurl.di;

import com.adsandurl.adsandurl.AppController;
import com.adsandurl.adsandurl.ui.posts.PostsActivity;
import com.adsandurl.adsandurl.ui.posts.phot.HotPostsPostFragment;
import com.adsandurl.adsandurl.ui.posts.pnew.NewPostsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ManagerModule.class, PresenterModule.class, ViewModelFactoryModule.class, ViewModelModule.class})
public interface ManagerComponent {

    void inject(AppController appController);

    void inject(PostsActivity postsActivity);

    void inject(HotPostsPostFragment hotPostFragment);

    void inject(NewPostsFragment newPostFragment);
}
