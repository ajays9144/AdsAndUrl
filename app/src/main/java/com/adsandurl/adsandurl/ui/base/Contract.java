package com.adsandurl.adsandurl.ui.base;

import androidx.annotation.Nullable;

public abstract class Contract {

    public interface Presenter<V extends View> {
        void attachView(V v);

        void detachView();

        void start();
    }

    public interface PresenterView extends View {
        void clearPresenter();
    }

    public interface View {
        void showErrors(@Nullable String error);

        void showLoadingIndicator(boolean state);

        void showFailure();
    }
}