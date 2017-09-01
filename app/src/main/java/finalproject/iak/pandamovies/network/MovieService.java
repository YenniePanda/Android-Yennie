package finalproject.iak.pandamovies.network;

import finalproject.iak.pandamovies.model.MovieResponse;
import finalproject.iak.pandamovies.utils.ServiceUtils;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yennie.rossia on 8/30/2017.
 */

public interface MovieService {
    @GET(ServiceUtils.POP_MOVIE_URL)
    Call<MovieResponse> getPopularMovie(
            @Query("api_key") String apiKey,
            @Query("page") int page);

    @GET(ServiceUtils.TOP_MOVIE_URL)
    Call<MovieResponse> getTopRatedMovie(
            @Query("api_key") String apiKey,
            @Query("page") int page);
}
