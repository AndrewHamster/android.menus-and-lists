package com.andrewhamster.listsandmenus;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 06-Aug-17.
 */

public class PostsAdapter extends RecyclerView.Adapter {
    private List<Post> posts;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);

        PostViewHolder vh = new PostViewHolder(root);
        return vh;
    }

    public PostsAdapter(List<Post> posts)
    {
        this.posts = posts;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PostViewHolder)holder).titleTextView.setText(posts.get(position).title);
        ((PostViewHolder)holder).bodyTextView.setText(posts.get(position).body);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }



    public static class PostViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout root;
        public TextView titleTextView;
        public TextView bodyTextView;
        public PostViewHolder(View root)
        {
            super(root);
            titleTextView = root.findViewById(R.id.post_title);
            bodyTextView = root.findViewById(R.id.post_body);
        }
    }
}
