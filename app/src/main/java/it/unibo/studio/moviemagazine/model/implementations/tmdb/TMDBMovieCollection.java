package it.unibo.studio.moviemagazine.model.implementations.tmdb;


import java.util.ArrayList;
import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Backdrop;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.model.interfaces.MovieCollection;
import it.unibo.studio.moviemagazine.model.interfaces.Poster;

/**
 * A movie collection is a set of movies that are connected together by a series, like star wars saga.
 */
public class TMDBMovieCollection implements MovieCollection {

    private String backdrop_path;
    private TMDBBackdrop backdrop;
    private String poster_path;
    private TMDBPoster poster;
    private int id;
    private String name;
    private String overview;
    private List<TMDBMovie> parts;
    private ImagesWrapper images;
    private List<TMDBBackdrop> backdrops;
    private List<TMDBPoster> posters;

    @Override
    public Poster getMainPoster() {
        if(poster == null){
            poster = new TMDBPoster();
            poster.path = poster_path;
        }
        return this.poster;
    }

    @Override
    public Backdrop getMainBackdrop() {
        if(backdrop == null){
            backdrop = new TMDBBackdrop();
            backdrop.path = backdrop_path;
        }
        return this.backdrop;
    }

    @Override
    public List<Backdrop> getBackdrops() {
        if(backdrops == null){
            backdrops = images.backdrops;
        }
        return new ArrayList<Backdrop>(this.backdrops);
    }

    @Override
    public List<Poster> getPosters() {
        if(posters == null){
            posters = images.posters;
        }
        return new ArrayList<Poster>(this.posters);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getOverview() {
        return this.overview;
    }

    @Override
    public List<Movie> getParts() {
        return new ArrayList<Movie>(this.parts);
    }
}
