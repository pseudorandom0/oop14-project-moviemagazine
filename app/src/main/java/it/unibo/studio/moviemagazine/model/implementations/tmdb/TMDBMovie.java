package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.interfaces.Backdrop;
import it.unibo.studio.moviemagazine.model.interfaces.Company;
import it.unibo.studio.moviemagazine.model.interfaces.Genre;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.model.interfaces.MovieCollection;
import it.unibo.studio.moviemagazine.model.interfaces.Poster;

/**
 * Models a movie
 */
public class TMDBMovie implements Movie{

    private TMDBBackdrop mainBackdrop;
    private String backdrop_path;
    private TMDBPoster mainPoster;
    private String poster_path;
    @SerializedName("belongs_to_collection")
    private TMDBMovieCollection collection;
    private int budget;
    private List<TMDBGenre> genres;
    /**
     * This list is required in order to deserialize the genres of a movie when only basic info is received, the integers are the ids so the names can be retrieved with
     * {@code TMDBGenre.genreById(int genreId)}
     */
    private List<Integer> genre_ids;
    private int id;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    private String title;
    private String overview;
    private double popularity;
    @SerializedName("production_companies")
    private List<TMDBCompany> productionCompanies;
    @SerializedName("production_countries")
    private List<ProductionCountryWrapper> productionCountries;
    private String release_date;
    private Date actualReleaseDate;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("vote_count")
    private int voteCount;
    private ImagesWrapper images;
    @SerializedName("keywords")
    private List<String> tags;


    TMDBMovie(){

    }


    @Override
    public int getBudget() {
        return 0;
    }

    @Override
    public List<Genre> getGenres() {
        if(genres == null){
            genres = new ArrayList<>(genre_ids.size());
            for(int genreId : genre_ids){
                genres.add(TMDBGenre.genreById(genreId));
            }
        }
        return new ArrayList<Genre>(genres);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Locale getOriginalLanguage() {
        return new Locale(this.originalLanguage);
    }

    @Override
    public String getOverview() {
        return this.overview;
    }

    @Override
    public double getPopularity() {
        return this.popularity;
    }

    @Override
    public boolean belongsToCollection() {
        return this.collection != null;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getOriginalTitle() {
        return this.originalTitle;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public List<Company> getCompanies() {
        return new ArrayList<Company>(this.productionCompanies);
    }

    @Override
    public MovieCollection getCollection() {
        return this.collection;
    }

    @Override
    public List<Locale> getProductionCountries() {
        List<Locale> countries = new ArrayList<>(this.productionCountries.size());
        for (ProductionCountryWrapper wrapper : this.productionCountries) {
            countries.add(new Locale(wrapper.countryCode));
        }
        return countries;
    }

    @Override
    public Date getReleaseDate() {
        if(release_date == null || release_date.isEmpty()){
            return null;
        } else {
            SimpleDateFormat parser = new SimpleDateFormat(Constants.DATE_STYLE_PATTERN);
            try {
                actualReleaseDate = parser.parse(release_date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return actualReleaseDate;
    }


    @Override
    public int getRevenue() {
        return this.revenue;
    }

    @Override
    public int getRuntime() {
        return this.runtime;
    }

    @Override
    public String getTagline() {
        return this.tagline;
    }

    @Override
    public List<Poster> getPosters() {
        return new ArrayList<Poster>(this.images.posters);
    }

    @Override
    public double getVoteAverage() {
        return voteAverage;
    }

    @Override
    public int getVoteCount() {
        return voteCount;
    }

    @Override
    public List<Backdrop> getBackdrops() {
       return  new ArrayList<Backdrop>(this.images.backdrops);
    }


    @Override
    public List<String> getTags() {
        return new ArrayList<>(this.tags);
    }

    @Override
    public Poster getMainPoster() {
        if(mainPoster == null){
            mainPoster = new TMDBPoster();
            mainPoster.path = poster_path;
        }
        return mainPoster;
    }

    @Override
    public Backdrop getMainBackdrop() {
        if(mainBackdrop == null){
            mainBackdrop = new TMDBBackdrop();
            mainBackdrop.path = backdrop_path;
        }
        return this.mainBackdrop;
    }


    /**
     * Wrapper for country codes
     */
    private class ProductionCountryWrapper{
        @SerializedName(Constants.Parsing.COUNTRY_CODE_MEMBER_NAME)
        String countryCode;
    }
}
