package com.adsandurl.adsandurl.di;

import android.app.Application;

import androidx.room.Room;

import com.adsandurl.adsandurl.db.PostDatabase;
import com.adsandurl.adsandurl.manager.PostsManager;
import com.adsandurl.adsandurl.network.ApiCallInterface;
import com.adsandurl.adsandurl.repository.PostsRepository;
import com.adsandurl.adsandurl.utils.AppConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ManagerModule {

    @Provides
    @Singleton
    public Gson provideGson() {
        GsonBuilder builder =
                new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.setLenient().create();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient getRequestHeader() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder().build();
            return chain.proceed(request);
        }).connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS);
        return httpClient.build();
    }

    @Provides
    @Singleton
    ApiCallInterface getApiCallInterface(Retrofit retrofit) {
        return retrofit.create(ApiCallInterface.class);
    }

    @Provides
    @Singleton
    PostsRepository providerPostsRepository(Application application, ApiCallInterface apiCallInterface) {
        return new PostsRepository(application.getApplicationContext(), apiCallInterface);
    }


    @Provides
    @Singleton
    PostsManager providerPostManager(Application application) {
        return new PostsManager(application.getApplicationContext());
    }

    @Provides
    @Singleton
    PostDatabase getPostsProvider(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(), PostDatabase.class, PostDatabase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }
}
