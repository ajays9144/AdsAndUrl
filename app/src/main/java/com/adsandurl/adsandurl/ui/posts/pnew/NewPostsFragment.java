package com.adsandurl.adsandurl.ui.posts.pnew;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.adsandurl.adsandurl.R;
import com.adsandurl.adsandurl.di.ManagerComponent;
import com.adsandurl.adsandurl.model.NewChild;
import com.adsandurl.adsandurl.ui.adapter.NewPostsAdapter;
import com.adsandurl.adsandurl.ui.base.BaseViewModel;
import com.adsandurl.adsandurl.ui.base.BaseViewModelFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewPostsFragment extends BaseViewModelFragment<NewPostsView> implements NewPostsView {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    NewPostViewModel viewModel;

    @BindView(R.id.view_switcher)
    ViewSwitcher mViewSwitcher;
    @BindView(R.id.edt_search)
    EditText mSearch;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private NewPostsAdapter newPostsAdapter;
    private ArrayList<NewChild> newPostsList = new ArrayList<>();

    private Unbinder unbinder;

    public static NewPostsFragment newInstance() {
        return new NewPostsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_any_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        unbinder = ButterKnife.bind(this, view);

        initRecyclerView();

        mSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() != 0) {
                    newPostsList.clear();
                    mViewSwitcher.setDisplayedChild(1);
                    String search = "%" + s.toString() + "%";
                    newPostsList.addAll(viewModel.getNewPost(search));
                    newPostsAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @NonNull
    @Override
    public BaseViewModel<NewPostsView> initializeViewModel(@NonNull ManagerComponent managerComponent) {
        managerComponent.inject(this);
        ViewModel viewModel1 = ViewModelProviders.of(this, viewModelFactory).get(NewPostViewModel.class);
        viewModel = (NewPostViewModel) viewModel1;
        return viewModel;
    }

    private void initRecyclerView() {
        newPostsAdapter = new NewPostsAdapter(getContext(), newPostsList);
        mRecyclerView.setAdapter(newPostsAdapter);
    }

    @Override
    public void showErrors(@Nullable String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingIndicator(boolean state) {

    }

    @Override
    public void showFailure() {
        Toast.makeText(getContext(), R.string.try_again_later, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
