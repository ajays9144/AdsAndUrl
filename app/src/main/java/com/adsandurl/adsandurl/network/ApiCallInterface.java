package com.adsandurl.adsandurl.network;

import com.adsandurl.adsandurl.model.BaseResponse;
import com.adsandurl.adsandurl.model.Data;
import com.adsandurl.adsandurl.model.NewPosts;
import com.adsandurl.adsandurl.utils.AppConstants;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * The interface Api call interface.
 */
public interface ApiCallInterface {

    @GET(AppConstants.HOT_POSTS_URL)
    Observable<BaseResponse<Data>> getHotPosts();

    @GET(AppConstants.NEW_POSTS_URL)
    Observable<BaseResponse<NewPosts>> getNewPosts();
}
