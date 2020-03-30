package com.adsandurl.adsandurl.manager;

import android.content.Context;

public class BaseManager
{
    Context applicationContext;

    /**
     * Instantiates a new Base repository.
     *
     * @param context the context
     */
    BaseManager(Context context) {
        this.applicationContext = context;
    }

    /**
     * Gets application context.
     *
     * @return the application context
     */
    public Context getApplicationContext() {
        return this.applicationContext;
    }
}
