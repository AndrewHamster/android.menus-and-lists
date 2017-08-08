package com.andrewhamster.listsandmenus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter {
    private List<Post> posts;
    private Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);

        context = parent.getContext();

        return new PostViewHolder(root);
    }

    public PostsAdapter(List<Post> posts)
    {
        this.posts = posts;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final PostViewHolder post = (PostViewHolder)holder;
        post.titleTextView.setText(posts.get(position).title);
        post.bodyTextView.setText(posts.get(position).body);
        post.moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, new StringBuilder().append("[").append(position).append("] post is clicked").toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }



    public static class PostViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout root;
        TextView titleTextView;
        TextView bodyTextView;
        ImageButton moreBtn;
        PostViewHolder(View root)
        {
            super(root);
            titleTextView = root.findViewById(R.id.post_title);
            bodyTextView = root.findViewById(R.id.post_body);
            moreBtn = root.findViewById(R.id.post_menu);
        }
    }
}
