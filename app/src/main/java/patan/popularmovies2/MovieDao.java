package patan.popularmovies2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import java.util.List;
import retrofit2.http.Query;

@Dao
public interface MovieDao {


    @androidx.room.Query("SELECT * FROM movie ORDER BY vote_average DESC")
    LiveData<List<Movie>> loadAllFavoriteMovies();

    @androidx.room.Query("SELECT is_favorite FROM movie WHERE movie_id = :movieId")
    boolean isFavorite(int movieId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavoriteMovie(Movie movie);

    @androidx.room.Query("UPDATE movie SET is_favorite = :isFavorite WHERE movie_id = :movieId")
    void updateFavoriteMovie(int movieId, boolean isFavorite);

    @Delete
    void deleteFavoriteMovie(Movie movie);

    @androidx.room.Query("SELECT * FROM movie WHERE movie_id = :movieId")
    Movie getMovie(int movieId);
}
