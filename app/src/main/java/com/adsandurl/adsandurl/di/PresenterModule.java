package com.adsandurl.adsandurl.di;

import com.adsandurl.adsandurl.db.PostDatabase;
import com.adsandurl.adsandurl.manager.PostsManager;
import com.adsandurl.adsandurl.repository.PostsRepository;
import com.adsandurl.adsandurl.ui.posts.PostsContract;
import com.adsandurl.adsandurl.ui.posts.PostsViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    PostsContract.Presenter providerPostsPresenter(PostsRepository postsRepository, PostsManager postsManager, PostDatabase postDatabase) {
        return new PostsViewModel(postsRepository, postsManager, postDatabase);
    }
}
