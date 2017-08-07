package com.andrewhamster.listsandmenus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

public class ListOfPosts extends AppCompatActivity {

    private RecyclerView postsRecyclerView;
    private RecyclerView.Adapter postsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwitchCompat postsSwitch;
    private String[] dataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_posts);

        postsRecyclerView = findViewById(R.id.list_of_posts);
        layoutManager = new LinearLayoutManager(this);
        postsRecyclerView.setLayoutManager(layoutManager);

        postsSwitch = findViewById(R.id.switch_list);

        postsSwitch.setOnCheckedChangeListener(new OnSwitchListener());

        dataset = new String[]{
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
                "Lorem",
                "Ipsum",
                "dolor",
                "sit",
                "amet",
        };

        postsAdapter = new PostsAdapter(dataset);
        postsRecyclerView.setAdapter(postsAdapter);
    }

    protected class OnSwitchListener implements SwitchCompat.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b)
                postsRecyclerView.setVisibility(View.VISIBLE);
            else
                postsRecyclerView.setVisibility(View.GONE);
        }
    }
}