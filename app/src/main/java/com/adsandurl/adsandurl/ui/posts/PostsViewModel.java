package com.adsandurl.adsandurl.ui.posts;

import com.adsandurl.adsandurl.db.PostDatabase;
import com.adsandurl.adsandurl.manager.PostsManager;
import com.adsandurl.adsandurl.model.BaseResponse;
import com.adsandurl.adsandurl.model.Data;
import com.adsandurl.adsandurl.model.NewPosts;
import com.adsandurl.adsandurl.repository.PostsRepository;
import com.adsandurl.adsandurl.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PostsViewModel extends BaseViewModel<PostsContract.View> implements PostsContract.Presenter {

    private final PostsRepository postsRepository;
    private final PostsManager postsManager;
    private final PostDatabase postDatabase;

    @Inject
    public PostsViewModel(PostsRepository postsRepository, PostsManager postsManager, PostDatabase postDatabase) {
        this.postsRepository = postsRepository;
        this.postsManager = postsManager;
        this.postDatabase = postDatabase;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void start() {

    }

    @Override
    public void getHotPosts() {
        getCompositeDisposable().add(postsRepository.getHotData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<BaseResponse<Data>>() {
                    @Override
                    public void onNext(BaseResponse<Data> dataBaseResponse) {
                        if (getView() != null) {
                            postDatabase.getPostDao().insertHotPosts(dataBaseResponse.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() != null) {
                            getView().showLoadingIndicator(false);
                            getView().showErrors(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    protected void onStart() {
                        super.onStart();
                        if (getView() != null)
                            getView().showLoadingIndicator(true);
                    }
                }));
    }

    @Override
    public void getNewPosts() {
        getCompositeDisposable().add(postsRepository.getNewData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<BaseResponse<NewPosts>>() {
                    @Override
                    public void onNext(BaseResponse<NewPosts> dataBaseResponse) {
                        if (getView() != null) {
                            postDatabase.getPostDao().insertNewPosts(dataBaseResponse.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() != null) {
                            getView().showLoadingIndicator(false);
                            getView().showErrors(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    protected void onStart() {
                        super.onStart();
                        if (getView() != null)
                            getView().showLoadingIndicator(true);
                    }
                }));
    }
}
