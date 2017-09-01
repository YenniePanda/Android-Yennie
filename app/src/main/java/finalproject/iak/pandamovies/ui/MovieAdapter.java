package finalproject.iak.pandamovies.ui;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import finalproject.iak.pandamovies.R;
import finalproject.iak.pandamovies.model.MovieEntity;
import finalproject.iak.pandamovies.utils.ImageUtils;

/**
 * Created by yennie.rossia on 8/29/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private List<MovieEntity> items = new ArrayList<>();
    private Context context;

    public void setItems(List<MovieEntity> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewMovie = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent,false);
        context = parent.getContext();
        return new MovieHolder(viewMovie);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Picasso.with(context)
                .load(ImageUtils.generateImageUrl(items.get(position).getPosterPath()))
                .fit()
                .centerCrop()
                .into(holder.movie);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        ImageView movie;

        public MovieHolder(View viewItem) {
            super(viewItem);
            movie = (ImageView) viewItem.findViewById(R.id.movie);
        }

    }

}