package finalproject.iak.pandamovies.network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import finalproject.iak.pandamovies.model.MovieResponse;
import finalproject.iak.pandamovies.utils.ServiceUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yennie.rossia on 8/29/2017.
 */

public class NetworkManager {

    public static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    public static Retrofit INSTANCE;

    public static Retrofit getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(ServiceUtils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(GSON))
                    .build();
        }
        return INSTANCE;
    }

    public static void getPopularMovie(int page, final NetworkCallBack callback) {
        MovieService movieService = getInstance().create(MovieService.class);

        Call<MovieResponse> call = movieService.getPopularMovie(ServiceUtils.API_KEY, page);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable throwable) {
                callback.onFailure(throwable);
            }
        });
    }

    public interface NetworkCallBack {
        void onFailure(Throwable throwable);

        void onSuccess(MovieResponse movieResponse);
    }
}