package com.adsandurl.adsandurl.ui.posts;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.adsandurl.adsandurl.R;
import com.adsandurl.adsandurl.di.ManagerComponent;
import com.adsandurl.adsandurl.ui.adapter.PostPagerAdapter;
import com.adsandurl.adsandurl.ui.base.BaseActivityViewModel;
import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsActivity extends BaseActivityViewModel<PostsContract.Presenter> implements PostsContract.View {

    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @Inject
    PostsContract.Presenter presenter;

    @Override
    public PostsContract.Presenter injectPresenter(ManagerComponent managerComponent) {
        managerComponent.inject(this);
        return presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initViewPager();
    }

    private void initViewPager() {
        PostPagerAdapter postPagerAdapter = new PostPagerAdapter(PostsActivity.this, getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(postPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void onResume() {
        getPresenter().getHotPosts();
        getPresenter().getNewPosts();
        super.onResume();
    }

    @Override
    public void showErrors(@Nullable String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingIndicator(boolean state) {

    }

    @Override
    public void showFailure() {
        Toast.makeText(this, R.string.try_again_later, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessHotPosts() {

    }

    @Override
    public void showSuccessNewPosts() {

    }
}
