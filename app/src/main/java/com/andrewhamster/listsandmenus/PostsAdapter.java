package com.andrewhamster.listsandmenus;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Andre on 06-Aug-17.
 */

public class PostsAdapter extends RecyclerView.Adapter {
    private String[] posts;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView titleText = (TextView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        PostViewHolder vh = new PostViewHolder(titleText);
        return vh;
    }

    public PostsAdapter(String[] items)
    {
        this.posts = items;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PostViewHolder)holder).titleTextView.setText(posts[position]);
    }

    @Override
    public int getItemCount() {
        return posts.length;
    }



    public static class PostViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTextView;
        public PostViewHolder(TextView tv)
        {
            super(tv);
            titleTextView = tv;
        }
    }
}
