package com.adsandurl.adsandurl.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adsandurl.adsandurl.R;
import com.adsandurl.adsandurl.model.Child;
import com.adsandurl.adsandurl.model.HotChild;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotPostsAdapter extends RecyclerView.Adapter<HotPostsAdapter.PostViewHolder> {

    private Context context;
    private List<HotChild> children;

    public HotPostsAdapter(Context context, List<HotChild> children) {
        this.context = context;
        this.children = children;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(context).inflate(R.layout.item_posts_dapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        try {
            HotChild child = children.get(position);

            holder.mTitle.setText(child.getData().getTitle());
            if (child.getData().getAllAwardings() != null && !child.getData().getAllAwardings().isEmpty()) {
                Glide.with(context).load(child.getData().getAllAwardings().get(0).getIconUrl()).apply(new RequestOptions()
                        .error(R.drawable.ic_launcher_foreground).placeholder(R.drawable.ic_launcher_foreground)).into(holder.mIcon);
            }
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return children.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_icon)
        ImageView mIcon;
        @BindView(R.id.txt_title)
        TextView mTitle;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
