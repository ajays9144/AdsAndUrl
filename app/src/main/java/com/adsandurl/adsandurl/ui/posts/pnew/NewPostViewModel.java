package com.adsandurl.adsandurl.ui.posts.pnew;

import com.adsandurl.adsandurl.db.PostDatabase;
import com.adsandurl.adsandurl.model.NewChild;
import com.adsandurl.adsandurl.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

public class NewPostViewModel extends BaseViewModel<NewPostsView> {

    private final PostDatabase postDatabase;

    @Inject
    public NewPostViewModel(PostDatabase postDatabase) {
        this.postDatabase = postDatabase;
    }

    public List<NewChild> getNewPost(String query) {
        return postDatabase.getPostDao().getNewPostsData(query);
    }
}
