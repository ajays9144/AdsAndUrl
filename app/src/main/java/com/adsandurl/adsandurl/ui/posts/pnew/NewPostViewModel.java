package com.adsandurl.adsandurl.ui.posts.pnew;

import com.adsandurl.adsandurl.db.PostDatabase;
import com.adsandurl.adsandurl.model.NewPosts;
import com.adsandurl.adsandurl.repository.PostsRepository;
import com.adsandurl.adsandurl.ui.base.BaseViewModel;

import javax.inject.Inject;

public class NewPostViewModel extends BaseViewModel<NewPostsView> {

    private final PostDatabase postDatabase;

    @Inject
    public NewPostViewModel(PostDatabase postDatabase) {
        this.postDatabase = postDatabase;
    }

    public NewPosts getNewPost() {
        return postDatabase.getPostDao().getNewPostsData();
    }
}
