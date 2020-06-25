package it.unibo.studio.moviemagazine.controllers.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.controllers.CollectionsListController;
import it.unibo.studio.moviemagazine.controllers.ISearchController;
import it.unibo.studio.moviemagazine.controllers.MovieListController;
import it.unibo.studio.moviemagazine.controllers.PeopleListController;
import it.unibo.studio.moviemagazine.controllers.UserMovieListsController;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.CollectionListWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListsWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.PagedResultWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.PersonListWrapper;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.model.interfaces.MovieCollection;
import it.unibo.studio.moviemagazine.model.interfaces.MovieList;
import it.unibo.studio.moviemagazine.model.interfaces.Person;
import it.unibo.studio.moviemagazine.view.ListView;
import it.unibo.studio.moviemagazine.view.MovieCollectionsListView;
import it.unibo.studio.moviemagazine.view.MovieListView;
import it.unibo.studio.moviemagazine.view.PeopleListView;
import it.unibo.studio.moviemagazine.view.SearchView;
import it.unibo.studio.moviemagazine.view.UserMovieListsView;
import it.unibo.studio.moviemagazine.webservice.facade.Search;
import it.unibo.studio.moviemagazine.webservice.facade.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Controller for searching data with {@link it.unibo.studio.moviemagazine.webservice.facade.Search}
 */
class SearchController extends BaseListController implements ISearchController, MovieListController, PeopleListController, UserMovieListsController, CollectionsListController{

    private final Search service;
    private SearchStrategy searchCommand;

    private MovieListView movieListView;
    private MovieCollectionsListView collectionsListView;
    private UserMovieListsView listsView;
    private PeopleListView peopleListView;

    private SearchView searchView;


    SearchController(int searchType) {
        this.service = ServiceFactory.createService(Search.class);
        switch (searchType){
            case ListControllerFactory.SEARCH_PEOPLE:
                this.searchCommand = createPeopleSearchStrategy();
                break;
            case ListControllerFactory.SEARCH_COLLECTIONS:
                this.searchCommand = createCollectionsSearchStrategy();
                break;
            case ListControllerFactory.SEARCH_LISTS:
                this.searchCommand = createListsSearchStrategy();
                break;
            case ListControllerFactory.SEARCH_MOVIES:
                this.searchCommand = createMoviesSearchStrategy();
                break;
            default:
                throw new IllegalArgumentException("The type of the controller must be one of SEARCH_*");
        }
    }

    @Override
    public void commandLoadMore() {
        searchCommand.commandLoadMore();
    }

    @Override
    public void addMovieListView(MovieListView view) {
        this.movieListView = view;
        ((AbstractSearchStrategy)searchCommand).listView = movieListView;
    }

    @Override
    public void addPeopleListView(PeopleListView view) {
        this.peopleListView = view;
        ((AbstractSearchStrategy)searchCommand).listView = peopleListView;
    }

    @Override
    public void addCollectionsListView(MovieCollectionsListView view) {
        this.collectionsListView = view;
        ((AbstractSearchStrategy)searchCommand).listView = collectionsListView;
    }

    @Override
    public void addUserMovieListsView(UserMovieListsView view) {
        this.listsView = view;
        ((AbstractSearchStrategy)searchCommand).listView = listsView;
    }

    @Override
    public void addSearchView(SearchView view) {
        this.searchView = view;
    }

    @Override
    public void commandLoad() {

    }

    private SearchStrategy createListsSearchStrategy(){
        return new AbstractSearchStrategy() {

            private final Callback<MovieListsWrapper> callback = new Callback<MovieListsWrapper>() {
                @Override
                public void onResponse(Call<MovieListsWrapper> call, Response<MovieListsWrapper> response) {
                    currentPage = response.body();
                    if(currentPage != null){
                        if(currentPage.getTotalResults() > 0){
                            listsFound.addAll(currentPage.getLists());
                            if(currentPage.getCurrentPage() == 1){
                                listsView.setMovieLists(listsFound);
                                if(currentPage.getTotalPages() > 1){
                                    listsView.registerOnScrollListener();
                                }
                            }
                            listsView.notifyAdded(currentPage.getPageSize());
                        } else {
                            listsView.displayLocalizedMessage(R.string.nothing_found);
                        }
                    } else {
                        listsView.displayError("Something went wrong");
                    }
                }

                @Override
                public void onFailure(Call<MovieListsWrapper> call, Throwable t) {
                    listsView.displayError(t.getMessage());
                }
            };

            private Call<MovieListsWrapper> currentCall;
            private final List<MovieList> listsFound = new ArrayList<>();
            private MovieListsWrapper currentPage;

            @Override
            protected int getNoMoreItemsMessage() {
                return R.string.lists_list_no_more_items;
            }

            @Override
            protected PagedResultWrapper getCurrentPage() {
                return currentPage;
            }

            @Override
            protected Callback getCallBack() {
                return callback;
            }

            @Override
            protected int clearLoaded() {
                int removed = listsFound.size();
                listsFound.clear();
                return removed;
            }

            @Override
            protected Call createCall(int page, String query) {
                currentCall = service.searchList(page, query);
                return currentCall;
            }

            @Override
            public Call getCurrentCall() {
                return currentCall;
            }
        };
    }

    private SearchStrategy createMoviesSearchStrategy(){
        return new AbstractSearchStrategy() {

            private final Callback<MovieListWrapper> callback = new Callback<MovieListWrapper>() {
                @Override
                public void onResponse(Call<MovieListWrapper> call, Response<MovieListWrapper> response) {
                    currentPage = response.body();
                    if(currentPage != null){
                        if(currentPage.getTotalResults() > 0){
                            moviesFound.addAll(currentPage.getMovies());
                            if(currentPage.getCurrentPage() == 1){
                                movieListView.setMovieList(moviesFound);
                                if(currentPage.getTotalPages() > 1){
                                    movieListView.registerOnScrollListener();
                                }
                            }
                            movieListView.notifyAdded(currentPage.getPageSize());
                        } else {
                            movieListView.displayLocalizedMessage(R.string.nothing_found);
                        }
                    } else {
                        movieListView.displayError("Something went wrong");
                    }
                }

                @Override
                public void onFailure(Call<MovieListWrapper> call, Throwable t) {
                    movieListView.displayError(t.getMessage());
                }
            };

            private Call<MovieListWrapper> currentCall;
            private final List<Movie> moviesFound = new ArrayList<>();
            private MovieListWrapper currentPage;

            @Override
            protected int getNoMoreItemsMessage() {
                return R.string.movie_list_no_more_items;
            }

            @Override
            protected PagedResultWrapper getCurrentPage() {
                return currentPage;
            }

            @Override
            protected Callback getCallBack() {
                return callback;
            }

            @Override
            protected int clearLoaded() {
                int removed = moviesFound.size();
                moviesFound.clear();
                return removed;
            }

            @Override
            protected Call createCall(int page, String query) {
                currentCall = service.searchMovie(page, query, new HashMap<String, String>());
                return currentCall;
            }

            @Override
            public Call getCurrentCall() {
                return currentCall;
            }
        };
    }

    private SearchStrategy createCollectionsSearchStrategy(){
        return new AbstractSearchStrategy() {

            private final Callback<CollectionListWrapper> callback = new Callback<CollectionListWrapper>() {
                @Override
                public void onResponse(Call<CollectionListWrapper> call, Response<CollectionListWrapper> response) {
                    currentPage = response.body();
                    if(currentPage != null){
                        if(currentPage.getTotalResults() > 0){
                            collectionsFound.addAll(currentPage.getCollections());
                            if(currentPage.getCurrentPage() == 1){
                                collectionsListView.setCollectionsList(collectionsFound);
                                if(currentPage.getTotalPages() > 1){
                                    collectionsListView.registerOnScrollListener();
                                }
                            }
                            collectionsListView.notifyAdded(currentPage.getPageSize());
                        } else {
                            collectionsListView.displayLocalizedMessage(R.string.nothing_found);
                        }
                    } else {
                        collectionsListView.displayError("Something went wrong");
                    }
                }

                @Override
                public void onFailure(Call<CollectionListWrapper> call, Throwable t) {
                    collectionsListView.displayError(t.getMessage());
                }
            };

            private Call<CollectionListWrapper> currentCall;
            private final List<MovieCollection> collectionsFound = new ArrayList<>();
            private CollectionListWrapper currentPage;

            @Override
            protected int getNoMoreItemsMessage() {
                return R.string.collections_list_no_more_items;
            }

            @Override
            protected PagedResultWrapper getCurrentPage() {
                return currentPage;
            }

            @Override
            protected Callback getCallBack() {
                return callback;
            }

            @Override
            protected int clearLoaded() {
                int removed = collectionsFound.size();
                collectionsFound.clear();
                return removed;
            }

            @Override
            protected Call createCall(int page, String query) {
                currentCall = service.searchCollection(page, query);
                return currentCall;
            }

            @Override
            public Call getCurrentCall() {
                return currentCall;
            }
        };
    }

    private SearchStrategy createPeopleSearchStrategy(){
        return new AbstractSearchStrategy() {

            private final Callback<PersonListWrapper> callback = new Callback<PersonListWrapper>() {
                @Override
                public void onResponse(Call<PersonListWrapper> call, Response<PersonListWrapper> response) {
                    currentPage = response.body();
                    if(currentPage != null){
                        if(currentPage.getTotalResults() > 0){
                            peopleFound.addAll(currentPage.getPeople());
                            if(currentPage.getCurrentPage() == 1){
                                peopleListView.setPeopleList(peopleFound);
                                if(currentPage.getTotalPages() > 1){
                                    peopleListView.registerOnScrollListener();
                                }
                            }
                            peopleListView.notifyAdded(currentPage.getPageSize());
                        } else {
                            peopleListView.displayLocalizedMessage(R.string.nothing_found);
                        }
                    } else {
                        peopleListView.displayError("Something went wrong");
                    }
                }

                @Override
                public void onFailure(Call<PersonListWrapper> call, Throwable t) {
                    peopleListView.displayError(t.getMessage());
                }
            };

            private Call<PersonListWrapper> currentCall;
            private final List<Person> peopleFound = new ArrayList<>();
            private PersonListWrapper currentPage;

            @Override
            protected int getNoMoreItemsMessage() {
                return R.string.people_list_no_more_items;
            }

            @Override
            protected PagedResultWrapper getCurrentPage() {
                return currentPage;
            }

            @Override
            protected Callback getCallBack() {
                return callback;
            }

            @Override
            protected int clearLoaded() {
                int removed = peopleFound.size();
                peopleFound.clear();
                return removed;
            }

            @Override
            protected Call createCall(int page, String query) {
                currentCall = service.searchPerson(page, query, Constants.APIParameters.Values.PersonSearch.PHRASE);
                return currentCall;
            }

            @Override
            public Call getCurrentCall() {
                return currentCall;
            }
        };
    }


    @Override
    protected Call getCall() {
        return searchCommand.getCurrentCall();
    }

    @Override
    public void commandSearch() {
        searchCommand.commandSearch();
    }

    private boolean checkQuery(String query){
        if(query == null || query.isEmpty()){
            searchView.displayLocalizedMessage(R.string.search_message_insert_text);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Interface for a search strategy where the strategy represents what to search
     */
    private interface SearchStrategy {
        void commandSearch();
        void commandLoadMore();
        Call getCurrentCall();
    }

    /**
     * Abstract search strategy that implements the base logic that each search type must have
     */
    abstract class AbstractSearchStrategy implements SearchStrategy {

        ListView listView;


        /**
         * Template method for implementing the base logic of searching
         */
        @Override
        public void commandSearch() {
            if(checkQuery(searchView.getQuery())){
                if(getCurrentPage() != null){
                    int removed = clearLoaded();
                    listView.notifyRemoved(removed);
                }
                Call call = createCall(1, searchView.getQuery());
                call.enqueue(getCallBack());
            } else {
                listView.displayLocalizedMessage(R.string.search_message_insert_text);
            }
        }

        /**
         * Template method for implementing the pagination logic
         */
        @Override
        public void commandLoadMore() {
            PagedResultWrapper currentPage = getCurrentPage();
            if(currentPage != null && currentPage.getTotalPages() > currentPage.getCurrentPage()){
                Call call = createCall(currentPage.getCurrentPage() + 1, searchView.getQuery());
                call.enqueue(getCallBack());
            } else {
                listView.unregisterOnScrollListener();
                listView.displayLocalizedMessage(getNoMoreItemsMessage());
            }
        }

        /**
         * Getter of a resource id of the message to display when there are no more items to load
         * @return the resource id of the message to display
         */
        protected abstract int getNoMoreItemsMessage();

        /**
         * Getter used for implementing pagination logic in commandLoadMore
         * @return
         */
        protected abstract PagedResultWrapper getCurrentPage();

        /**
         * Getter for the callback to use when enqueueing calls
         * @return
         */
        protected abstract Callback getCallBack();

        /**
         * Clears the currently loaded results
         * @return count of the removed results, needed to notify the view
         */
        protected abstract int clearLoaded();

        /**
         * Factory method used to create the call to enqueue
         * @param page the page number that will be requested
         * @param query the query to use for searching
         * @return the call to enqueue
         */
        protected abstract Call createCall(int page, String query);

    }

}
