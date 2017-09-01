package finalproject.iak.pandamovies.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import finalproject.iak.pandamovies.R;
import finalproject.iak.pandamovies.model.MovieResponse;
import finalproject.iak.pandamovies.network.NetworkManager;

public class ListMovieActivity extends AppCompatActivity implements NetworkManager.NetworkCallBack {

    public static final  String TAG = "ListMovieActivity";

    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);

        setupRecyclerView();
        NetworkManager.getPopularMovie(1, this);
    }

    private void setupRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFailure(Throwable throwable) {
        Log.e(TAG, "onFailure: ", throwable);
    }

    @Override
    public void onSuccess(MovieResponse movieResponse) {
        adapter.setItems(movieResponse.getResults());
        System.out.println(new Gson().toJson(movieResponse));
    }
}
