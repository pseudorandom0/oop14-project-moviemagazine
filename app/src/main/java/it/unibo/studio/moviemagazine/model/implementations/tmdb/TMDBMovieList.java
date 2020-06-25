package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.model.interfaces.MovieList;
import it.unibo.studio.moviemagazine.model.interfaces.Poster;

/**
 * Users of tmdb can create lists of movies
 */
public class TMDBMovieList implements MovieList {

    @SerializedName(Constants.Parsing.ITEM_COUNT_MEMBER_NAME)
    private int itemCount;
    @SerializedName(Constants.Parsing.MOVIE_LIST_NAME_MEMBER_NAME)
    private String name;
    private String poster_path;
    private TMDBPoster poster;
    private List<TMDBMovie> items;
    private String created_by;
    private String description;
    private String id;
    private int favorite_count;
    @SerializedName(Constants.Parsing.LANGUAGE_CODE_MEMBER_NAME)
    private String language;

    @Override
    public List<Movie> getMovies() {
        return new ArrayList<Movie>(items);
    }

    @Override
    public int getFavouriteCount() {
        return favorite_count;
    }

    @Override
    public String getAuthor() {
        return created_by;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getMoviesCount() {
        return itemCount;
    }

    @Override
    public Locale getLanguage() {
        return new Locale(language);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Poster getPoster() {
        if(poster == null){
            poster = new TMDBPoster();
            poster.path = poster_path;
        }
        return poster;
    }
}
