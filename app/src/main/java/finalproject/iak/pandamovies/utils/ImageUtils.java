package finalproject.iak.pandamovies.utils;

/**
 * Created by yennie.rossia on 8/30/2017.
 */

public class ImageUtils {

    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/";

    public static String generateImageUrl(String imagePath){
        return BASE_IMAGE_URL + "w185" + imagePath;
    }

}
