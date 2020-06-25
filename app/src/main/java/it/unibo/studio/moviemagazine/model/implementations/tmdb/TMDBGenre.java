package it.unibo.studio.moviemagazine.model.implementations.tmdb;


import java.util.ArrayList;
import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Genre;

/**
 * Models a genre
 */
public class TMDBGenre implements Genre{

    private int id;
    private String name;
    private static List<TMDBGenre> genresList;
    private List<TMDBGenre> genres;

    private TMDBGenre(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMDBGenre genre = (TMDBGenre) o;

        return id == genre.id;

    }

    public void initGenres(){
        if(genresList == null){
            genresList = new ArrayList<>(genres);
            genres = null;
        }
    }

    @Override
    public int hashCode() {
        return id;
    }

    public static TMDBGenre genreById(int id){
        TMDBGenre dummy = new TMDBGenre();
        dummy.id = id;
        int index = genresList.indexOf(dummy);
        return index != -1? genresList.get(index) : null;
    }



    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        if(name == null){
            name = genreById(this.id).getName();
        }
        return this.name;
    }

    public static List<Genre> getAllGenres(){
        return new ArrayList<Genre>(genresList);
    }

}
