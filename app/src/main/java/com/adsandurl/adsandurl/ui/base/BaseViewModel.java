package com.adsandurl.adsandurl.ui.base;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<V extends Contract.View> extends ViewModel {

    public CompositeDisposable compositeDisposable;

    private V view;

    public final V getView() {
        return this.view;
    }

    public void setView(V view) {
        this.view = view;
    }

    public final CompositeDisposable getCompositeDisposable() {
        CompositeDisposable compositeDisposable2 = this.compositeDisposable;
        if (compositeDisposable2 == null) {
            Log.e(BaseViewModel.class.getSimpleName(), "missing");
        }
        return compositeDisposable2;
    }

    public void setCompositeDisposable(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
    }

    public final void attachView(@NonNull V v) {
        this.view = v;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        CompositeDisposable compositeDisposable2 = this.compositeDisposable;
        if (compositeDisposable2 == null) {
            Log.e(BaseViewModel.class.getSimpleName(), "missing");
        }
        compositeDisposable2.clear();
        this.view = null;
    }
}
