package com.andrewhamster.listsandmenus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOfPosts extends AppCompatActivity {

    private RecyclerView postsRecyclerView;
    private RecyclerView.Adapter postsAdapter;
    private SwitchCompat postsSwitch;
    private List<Post> dataset;
    private RequestQueue queue;
    private static final String FETCH = "fetch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_posts);

        queue = Volley.newRequestQueue(this);

        postsRecyclerView = findViewById(R.id.list_of_posts);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        postsRecyclerView.setLayoutManager(layoutManager);

        postsSwitch = findViewById(R.id.switch_list);

//        postsSwitch.setOnCheckedChangeListener(new OnSwitchListener());

        Post post = new Post();

        post.body = "Lorem ipsum";
        post.title = "Title";

        dataset = new ArrayList<Post>(){};
        dataset.add(post);
//        postsSwitch.setChecked(!dataset.isEmpty());

        postsAdapter = new PostsAdapter(dataset);
        postsRecyclerView.setAdapter(postsAdapter);


        loadPosts();
    }

    public void loadPosts()
    {
        String uri = "https://jsonplaceholder.typicode.com/posts";
        StringRequest request = new StringRequest(Request.Method.GET, uri,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ObjectMapper mapper = new ObjectMapper();
                CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Post.class);
                try {
                    List<Post> data = mapper.readValue(response, type);
                    dataset.addAll(data);
                    postsAdapter.notifyItemRangeInserted(dataset.size() - data.size(), data.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
        );
        request.addMarker(FETCH);
        queue.add(request);
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
