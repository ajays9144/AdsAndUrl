package com.adsandurl.adsandurl.repository;

import android.content.Context;

import com.adsandurl.adsandurl.model.BaseResponse;
import com.adsandurl.adsandurl.model.HotData;
import com.adsandurl.adsandurl.model.NewData;
import com.adsandurl.adsandurl.network.ApiCallInterface;

import io.reactivex.Observable;

public class PostsRepository extends BaseRepository {

    private final ApiCallInterface apiCallInterface;

    public PostsRepository(Context context, ApiCallInterface apiCallInterface) {
        super(context);
        this.apiCallInterface = apiCallInterface;
    }

    public Observable<BaseResponse<HotData>> getHotData() {
        return apiCallInterface.getHotPosts();
    }

    public Observable<BaseResponse<NewData>> getNewData() {
        return apiCallInterface.getNewPosts();
    }
}
