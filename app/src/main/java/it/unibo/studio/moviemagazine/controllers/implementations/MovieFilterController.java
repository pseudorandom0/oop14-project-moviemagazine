package it.unibo.studio.moviemagazine.controllers.implementations;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibo.studio.moviemagazine.constants.FilterMapper;
import it.unibo.studio.moviemagazine.constants.enums.MovieSortOrder;
import it.unibo.studio.moviemagazine.constants.enums.ReleaseTime;
import it.unibo.studio.moviemagazine.constants.enums.With;
import it.unibo.studio.moviemagazine.controllers.FilterController;
import it.unibo.studio.moviemagazine.model.interfaces.Genre;
import it.unibo.studio.moviemagazine.utils.Utils;

/**
 * This controller holds the filters and maps them so they can be placed in the discover method request
 */
public class MovieFilterController implements FilterMapper, FilterController {


    public static final MovieSortOrder defaultSortOrder = MovieSortOrder.POPULARITY_DESC;
    public static final Map<String,String> defaultFilters = new HashMap<>();
    public static final ReleaseTime defaultReleaseTime = ReleaseTime.PRIMARY_RELEASE_YEAR;
    public static final int releaseYearFiltersCount = 40;

    private ReleaseTime releaseTime;
    private MovieSortOrder order;
    private With genres;

    public MovieFilterController() {
        order = defaultSortOrder;
        genres = With.GENRES;
        try {
            defaultReleaseTime.setDate(Utils.getDateFromYear(Integer.toString(Calendar.getInstance().get(Calendar.YEAR) - 1)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        releaseTime = defaultReleaseTime;
        genres.clear();
    }

    @Override
    public Map<String, String> getFiltersMap() {
        Map<String,String> filters = new HashMap<>();
        filters.putAll(releaseTime.getFiltersMap());
        filters.putAll(genres.getFiltersMap());
        return filters;
    }

    @Override
    public void setReleaseYear(Date year) {
        releaseTime.setDate(year);
    }

    /**
     * At the moment only and queries are supported.
     * @param genre the genre filter to add to the and query
     */
    @Override
    public void addWithGenre(Genre genre) {
        genres.and(genre.getId());
    }

    @Override
    public void removeWithGenre(Genre genre){
        genres.remove(genre.getId());
    }

    @Override
    public void setMovieSortOrder(MovieSortOrder order) {
        this.order = order;
    }

    @Override
    public MovieSortOrder getDefaultMovieSortOrder() {
        return this.order;
    }

    @Override
    public List<Integer> getReleaseYearValues() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Integer> years = new ArrayList<>(releaseYearFiltersCount);
        for (int i = 0; i < releaseYearFiltersCount; i++){
            years.add(i,currentYear);
            currentYear--;
        }
        return years;
    }
}



