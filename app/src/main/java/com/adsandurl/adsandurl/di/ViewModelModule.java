package com.adsandurl.adsandurl.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.adsandurl.adsandurl.ui.posts.phot.HotPostViewModel;
import com.adsandurl.adsandurl.ui.posts.pnew.NewPostViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule
{
    @ViewModelKey(HotPostViewModel.class)
    @Binds
    @IntoMap
    @NonNull
    public abstract ViewModel bindHotViewModel(@NonNull HotPostViewModel hotPostViewModel);

    @ViewModelKey(NewPostViewModel.class)
    @Binds
    @IntoMap
    @NonNull
    public abstract ViewModel bindNewPostViewModel(@NonNull NewPostViewModel hostman);
}
