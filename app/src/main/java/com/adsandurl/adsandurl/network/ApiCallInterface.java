package com.adsandurl.adsandurl.network;

import com.adsandurl.adsandurl.model.BaseResponse;
import com.adsandurl.adsandurl.model.HotData;
import com.adsandurl.adsandurl.model.NewData;
import com.adsandurl.adsandurl.utils.AppConstants;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * The interface Api call interface.
 */
public interface ApiCallInterface {

    @GET(AppConstants.HOT_POSTS_URL)
    Observable<BaseResponse<HotData>> getHotPosts();

    @GET(AppConstants.NEW_POSTS_URL)
    Observable<BaseResponse<NewData>> getNewPosts();
}
