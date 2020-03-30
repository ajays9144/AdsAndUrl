package com.adsandurl.adsandurl;

import android.app.Application;

import androidx.lifecycle.LifecycleObserver;

import com.adsandurl.adsandurl.di.AppModule;
import com.adsandurl.adsandurl.di.DaggerManagerComponent;
import com.adsandurl.adsandurl.di.ManagerComponent;
import com.adsandurl.adsandurl.di.ManagerModule;

public class AppController extends Application implements LifecycleObserver {

    private ManagerComponent managerComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        managerComponent = createManagerComponent();
        managerComponent.inject(this);
    }

    public ManagerComponent getManagerComponent() {
        return managerComponent;
    }

    private ManagerComponent createManagerComponent() {
        return DaggerManagerComponent.builder()
                .appModule(new AppModule(this))
                .managerModule(new ManagerModule()).build();
    }
}
