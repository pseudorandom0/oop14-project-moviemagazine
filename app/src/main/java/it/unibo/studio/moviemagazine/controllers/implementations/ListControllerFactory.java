package it.unibo.studio.moviemagazine.controllers.implementations;

import it.unibo.studio.moviemagazine.controllers.CollectionsListController;
import it.unibo.studio.moviemagazine.controllers.ICollectionDetailController;
import it.unibo.studio.moviemagazine.controllers.IDiscoverController;
import it.unibo.studio.moviemagazine.controllers.ISearchController;
import it.unibo.studio.moviemagazine.controllers.MovieListController;
import it.unibo.studio.moviemagazine.controllers.ReviewsListController;
import it.unibo.studio.moviemagazine.controllers.UserMovieListsController;

/**
 * Factory that creates the {@code ListController}s used in the application
 */
public abstract class ListControllerFactory {

    public static final int MOVIES_POPULAR = 1;
    public static final int MOVIES_TOP_RATED = 2;
    public static final int MOVIES_UPCOMING = 3;
    public static final int MOVIES_NOW_PLAYING = 4;

    public static final int SEARCH_PEOPLE = 1;
    public static final int SEARCH_LISTS = 2;
    public static final int SEARCH_COLLECTIONS = 3;
    public static final int SEARCH_MOVIES = 4;


    /**
     * Method used to create a {@code MovieListController} that uses one of "trending movies" loader method from {@link it.unibo.studio.moviemagazine.webservice.facade.Movies}
     * @param type must be one of the {@code MOVIES_*} constants
     * @return
     * @throws IllegalArgumentException when the type passed doesn't match to any of the {@code MOVIES_*} constants
     */
    public static MovieListController createMovieListController(int type) throws IllegalArgumentException{
        if(type < 1 || type > 8){
            throw new IllegalArgumentException("No such controller type: " + type);
        } else if (type >= 1 && type <= 4){
            return new MoviesServiceController(type);
        }
        return null;
    }

    /**
     * Factory method to use when the desired {@code ICollectionController} should load a {@link it.unibo.studio.moviemagazine.model.interfaces.MovieCollection}
     * @param collectionId the id of the collection to load
     * @return
     */
    public static ICollectionDetailController createCollectionController(int collectionId){
        return new CollectionController(collectionId);
    }

    /**
     * Factory method to use when the desired {@code ICollectionController} should load a {@link it.unibo.studio.moviemagazine.model.interfaces.MovieList}
     * @param listId the id of the list to load
     * @return
     */
    public static ICollectionDetailController createCollectionController(String listId){
        return new CollectionController(listId);
    }

    /**
     * Creates a discover section controller
     * @return
     */
    public static IDiscoverController createDiscoverController(){
        return new DiscoverController();
    }

    /**
     * Creates a search controller that searches through one of the following:
     * <ul>
     *     <li>{@code Movie}s</li>
     *     <li>{@code MovieCollection}s</li>
     *     <li>{@code MovieList}s</li>
     *     <li>{@code Person}s</li>
     * </ul>
     * @param searchType must be one of the {@code SEARCH_*} constants
     * @return
     * @throws IllegalArgumentException when searchType doesn't match to any of the SEARCH_* constants
     */
    public static ISearchController createSearchController(int searchType) throws IllegalArgumentException{
        if(searchType < 1 || searchType >4){
            throw new IllegalArgumentException("The searchType parameter must be one of the SEARCH_* constants, but was: " + searchType);
        }
        return new SearchController(searchType);
    }

    /**
     * Creates a {@code ReviewsListController} that loads the reviews of the given movie id
     * @param movieId the id of the {@link it.unibo.studio.moviemagazine.model.interfaces.Movie}
     * @return
     */
    public static ReviewsListController createReviewsListController(int movieId){
        return new ReviewsController(movieId);
    }


    //TODO these two controllers at the moment are implemented only in SearchController, but when the loading of the lists of a Movie will be implemented, this will be used
    public static UserMovieListsController createUserMovieListsController(int type){
        return null;
    }

    //TODO
    public static CollectionsListController createCollectionsListController(int type){
        return null;
    }

}
