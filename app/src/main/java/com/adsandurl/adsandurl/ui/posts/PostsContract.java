package com.adsandurl.adsandurl.ui.posts;

import com.adsandurl.adsandurl.ui.base.Contract;

public abstract class PostsContract {

    public interface Presenter extends Contract.Presenter<View> {

        void getHotPosts();

        void getNewPosts();
    }

    public interface View extends Contract.View {

        void showSuccessHotPosts();

        void showSuccessNewPosts();
    }
}
