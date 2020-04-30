package patan.popularmovies2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class DetailsActivityViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    public DetailsActivityViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
    }
    public boolean isFavorite(int movieId) {
        return movieRepository.isFavorite(movieId);
    }

    public void addMovieToFavorites(Movie movie) {
        movieRepository.addMovieToFavorites(movie);
    }

    public void removeMovieFromFavorites(Movie movie) {
        movieRepository.deleteFavoriteMovie(movie);
    }

    public void updatFavoriteMovie(int movieId, boolean isFavorite) {
        movieRepository.updateFavoriteMovie(movieId, isFavorite);
    }
}
