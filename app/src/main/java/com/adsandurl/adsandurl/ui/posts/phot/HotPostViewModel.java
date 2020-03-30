package com.adsandurl.adsandurl.ui.posts.phot;

import com.adsandurl.adsandurl.db.PostDatabase;
import com.adsandurl.adsandurl.model.HotChild;
import com.adsandurl.adsandurl.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

public class HotPostViewModel extends BaseViewModel<HotPostsView> {

    private final PostDatabase postDatabase;

    @Inject
    public HotPostViewModel(PostDatabase postDatabase) {
        this.postDatabase = postDatabase;
    }

    public List<HotChild> getHotPost(String query) {
        return postDatabase.getPostDao().getHotPostsData(query);
    }
}
