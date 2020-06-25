package it.unibo.studio.moviemagazine.model.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Models a Movie
 */
public interface Movie {

    /**
     * @return average of all the votes for this movie
     */
    double getVoteAverage();

    int getVoteCount();

    int getBudget();

    List<Genre> getGenres();


    int getId();


    Locale getOriginalLanguage();



    String getOverview();


    double getPopularity();


    boolean belongsToCollection();


    String getTitle();

    String getOriginalTitle();

    String getStatus();


    List<Company> getCompanies();


    MovieCollection getCollection();


    List<Locale> getProductionCountries();


    Date getReleaseDate();


    int getRevenue();


    int getRuntime();


    String getTagline();


    List<Poster> getPosters();


    List<Backdrop> getBackdrops();


    List<String> getTags();


    Poster getMainPoster();


    Backdrop getMainBackdrop();

}