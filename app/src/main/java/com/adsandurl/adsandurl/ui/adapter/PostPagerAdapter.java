package com.adsandurl.adsandurl.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.adsandurl.adsandurl.ui.posts.phot.HotPostsFragment;
import com.adsandurl.adsandurl.ui.posts.pnew.NewPostsFragment;

public class PostPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_OF_PAGES = 2;

    private Context context;
    private String[] pages = new String[]{"Hot Posts", "New Posts"};

    public PostPagerAdapter(Context context, @NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HotPostsFragment.newInstance();
            case 1:
                return NewPostsFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_OF_PAGES;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pages[position];
    }
}
