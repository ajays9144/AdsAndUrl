package com.adsandurl.adsandurl.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.adsandurl.adsandurl.AppController;
import com.adsandurl.adsandurl.di.ManagerComponent;

public abstract class BaseViewModelFragment<V extends Contract.View> extends Fragment {

    private ProgressDialog mProgressDialog;

    @NonNull
    public abstract BaseViewModel<V> initializeViewModel(@NonNull ManagerComponent managerComponent);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        if (applicationContext != null) {
            ManagerComponent managerComponent = ((AppController) applicationContext).getManagerComponent();
            BaseViewModel initializeViewModel = initializeViewModel(managerComponent);
            try {
                initializeViewModel.attachView((Contract.View) this);
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" must implement View subclass as declared in ");
                sb.append(initializeViewModel.getClass().getSimpleName());
                throw new IllegalStateException(sb.toString());
            }
        } else {
            throw new ClassCastException("null cannot be cast to non-null type com.ratted.sitter.ui.feature.base.BaseApplication");
        }
    }

    public void onViewCreated(@NonNull android.view.View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
