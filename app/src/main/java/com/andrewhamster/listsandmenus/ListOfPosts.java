package com.andrewhamster.listsandmenus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

public class ListOfPosts extends AppCompatActivity {

    private RecyclerView postsRecyclerView;
    private RecyclerView.Adapter postsAdapter;
    private SwitchCompat postsSwitch;
    private List<Post> dataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_posts);

        postsRecyclerView = findViewById(R.id.list_of_posts);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        postsRecyclerView.setLayoutManager(layoutManager);

        postsSwitch = findViewById(R.id.switch_list);

        postsSwitch.setOnCheckedChangeListener(new OnSwitchListener());

        Post post = new Post();

        post.body = "Lorem ipsum";
        post.title = "Title";

        dataset = new ArrayList<Post>(){};
        dataset.add(post);
        postsSwitch.setChecked(!dataset.isEmpty());

        postsAdapter = new PostsAdapter(dataset);
        postsRecyclerView.setAdapter(postsAdapter);
    }

    protected class OnSwitchListener implements SwitchCompat.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b)
                postsRecyclerView.setVisibility(View.VISIBLE);
            else
            {
                Post post = new Post();
                post.title = "Magic";
                post.body = "Lorem ipsum dolor sit amet";
                postsRecyclerView.setVisibility(View.GONE);
                dataset.add(post);
                postsAdapter.notifyItemInserted(dataset.size());
            }
        }
    }
}
