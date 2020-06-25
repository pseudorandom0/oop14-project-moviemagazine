package it.unibo.studio.moviemagazine.controllers.implementations;

import it.unibo.studio.moviemagazine.controllers.ICollectionDetailController;
import it.unibo.studio.moviemagazine.controllers.MovieListController;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBMovieCollection;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBMovieList;
import it.unibo.studio.moviemagazine.model.interfaces.MovieList;
import it.unibo.studio.moviemagazine.view.CollectionDetailView;
import it.unibo.studio.moviemagazine.view.MovieListView;
import it.unibo.studio.moviemagazine.view.View;
import it.unibo.studio.moviemagazine.webservice.facade.Lists;
import it.unibo.studio.moviemagazine.webservice.facade.MovieCollections;
import it.unibo.studio.moviemagazine.webservice.facade.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Controller that loads data of a {@link it.unibo.studio.moviemagazine.model.interfaces.MovieCollection} or a {@link MovieList}.
 * This is the case of a controller that commands two views, a {@link CollectionDetailView} for the details and a {@link MovieListView}
 * for the associated list of movies
 */
class CollectionController extends BaseListController implements ICollectionDetailController, MovieListController {

    private MovieCollections collectionService;
    private Lists listService;

    private TMDBMovieCollection collection;
    private MovieList list;

    private int collectionId;
    private String listId;

    private Call<TMDBMovieCollection> collectionCall;
    private Call<TMDBMovieList> listCall;

    private CollectionDetailView detailView;
    private MovieListView partsView;

    private final CollectionLoadingStrategy loadCommand;

    /**
     * This constructor is used when the collection that should be loaded is a {@link it.unibo.studio.moviemagazine.model.interfaces.MovieCollection}
     * @param collectionId the id of the collection that should be loaded
     */
    CollectionController(int collectionId) {
        this.collectionId = collectionId;
        this.collectionService = ServiceFactory.createService(MovieCollections.class);
        //strategy that loads a MovieCollection
        this.loadCommand = new CollectionLoadingStrategy() {

            private void commandDisplay() {
                if(detailView.isInForeground()){
                    detailView.displayCollection(collection);
                }
                if(partsView.isInForeground()){
                    partsView.setMovieList(collection.getParts());
                    partsView.notifyAdded(collection.getParts().size());
                }
            }

            @Override
            public Call getCall() {
                return CollectionController.this.collectionCall;
            }

            @Override
            public void commandLoad() {

                if(collection != null){
                    commandDisplay();
                } else if(collectionCall == null){
                    collectionCall = collectionService.getCollectionById(CollectionController.this.collectionId);
                    collectionCall.enqueue(new Callback<TMDBMovieCollection>() {
                        @Override
                        public void onResponse(Call<TMDBMovieCollection> call, Response<TMDBMovieCollection> response) {
                            collection = response.body();
                            if(collection != null){
                                commandDisplay();
                            } else {
                                commandDisplayError("Something went wrong");
                            }
                        }

                        @Override
                        public void onFailure(Call<TMDBMovieCollection> call, Throwable t) {
                            commandDisplayError(t.getMessage());
                        }
                    });
                }
            }
        };
    }
    /**
     * This constructor is used when the collection that should be loaded is a {@link it.unibo.studio.moviemagazine.model.interfaces.MovieList}
     * @param listId the id of the movie list that should be loaded
     */
    CollectionController(String listId){
        this.listId = listId;
        this.listService = ServiceFactory.createService(Lists.class);
        //strategy that loads a MovieList
        this.loadCommand = new CollectionLoadingStrategy() {

            private void commandDisplay() {
                if(detailView.isInForeground()){
                    detailView.displayList(list);
                }
                if(partsView.isInForeground()){
                    partsView.setMovieList(list.getMovies());
                    partsView.notifyAdded(list.getMoviesCount());
                }
            }

            @Override
            public Call getCall() {
                return CollectionController.this.listCall;
            }

            @Override
            public void commandLoad() {
                if(list != null){
                    commandDisplay();
                } else if(listCall == null){
                    listCall = listService.getListById(CollectionController.this.listId);
                    listCall.enqueue(new Callback<TMDBMovieList>() {
                        @Override
                        public void onResponse(Call<TMDBMovieList> call, Response<TMDBMovieList> response) {
                            list = response.body();
                            if(list != null){
                                commandDisplay();
                            } else {
                                commandDisplayError("Something went wrong");
                            }
                        }

                        @Override
                        public void onFailure(Call<TMDBMovieList> call, Throwable t) {
                            commandDisplayError(t.getMessage());
                        }
                    });
                }
            }
        };
    }

    @Override
    public void commandLoadMore() {
        //not implemented because the parts are loaded all together
    }

    @Override
    public void addMovieListView(MovieListView view) {
        this.partsView = view;
    }

    @Override
    public void addCollectionDetailView(CollectionDetailView view) {
        this.detailView = view;
    }

    @Override
    public void commandLoad() {
        loadCommand.commandLoad();
    }

    private void commandDisplayError(String message){
        View view = detailView.isInForeground()? detailView : partsView;
        view.displayError(message);
    }

    @Override
    protected Call getCall() {
        return loadCommand.getCall();
    }

    /**
     * This interface is used as a strategy for loading the MovieCollection or the MovieList
     */
    private interface CollectionLoadingStrategy {
        void commandLoad();
        Call getCall();
    }

}
