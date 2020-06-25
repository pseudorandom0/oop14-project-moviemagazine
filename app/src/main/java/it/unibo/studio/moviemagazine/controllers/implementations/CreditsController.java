package it.unibo.studio.moviemagazine.controllers.implementations;

import java.util.ArrayList;
import java.util.List;

import it.unibo.studio.moviemagazine.adapters.AbstractCreditAdapter;
import it.unibo.studio.moviemagazine.controllers.ICreditsController;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.CreditsWrapper;
import it.unibo.studio.moviemagazine.model.interfaces.Credit;
import it.unibo.studio.moviemagazine.view.CreditsView;
import it.unibo.studio.moviemagazine.view.listeners.OnMovieClickListener;
import it.unibo.studio.moviemagazine.view.listeners.OnPersonClickListener;
import it.unibo.studio.moviemagazine.webservice.facade.Movie;
import it.unibo.studio.moviemagazine.webservice.facade.People;
import it.unibo.studio.moviemagazine.webservice.facade.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Controller that loads credits and displays them in a {@link it.unibo.studio.moviemagazine.view.CreditsView}
 */
class CreditsController extends BaseController implements ICreditsController{

    private CreditsView view;
    private final CreditsLoadingStrategy strategy;
    private final int runtimeType;
    private Call<CreditsWrapper> call;
    private final Callback<CreditsWrapper> callback;
    /**
     * The id will be either a movie id or a person id
     */
    private final int id;
    private final List<Credit> loadedCast;
    private final List<Credit> loadedCrew;

    private boolean loaded;

    private CreditsController(int runtimeType, int id, CreditsLoadingStrategy strategy) {
        this.runtimeType = runtimeType;
        this.strategy = strategy;
        this.id = id;
        this.loadedCrew = new ArrayList<>();
        this.loadedCast = new ArrayList<>();
        this.loaded = false;
        this.callback = new Callback<CreditsWrapper>() {
            @Override
            public void onResponse(Call<CreditsWrapper> call, Response<CreditsWrapper> response) {
                CreditsWrapper wrapper = response.body();
                if(wrapper != null){
                    loadedCast.addAll(wrapper.getCast());
                    loadedCrew.addAll(wrapper.getCrew());
                    if(!loadedCast.isEmpty()){
                        view.setCast(loadedCast);
                        view.notifyCastAdded(loadedCast.size());
                    }
                    if(!loadedCrew.isEmpty()){
                        view.setCrew(loadedCrew);
                        view.notifyCrewAdded(loadedCrew.size());
                    }
                    loaded = true;
                }
            }

            @Override
            public void onFailure(Call<CreditsWrapper> call, Throwable t) {
                view.displayError(t.getMessage());
            }
        };
    }

    /**
     * Factory method used by {@link ControllerFactory} for creating a {@code ICreditsController}.
     * The parameters used here are the same described in {@code ControllerFactory}
     * @param type
     * @param id
     * @return
     * @throws IllegalArgumentException when the type passed doesn't match any type
     */
    static ICreditsController createController(int type, int id) throws IllegalArgumentException{
        if(type != ControllerFactory.MOVIE_CREDITS_CONTROLLER && type != ControllerFactory.PERSON_CREDITS_CONTROLLER){
            throw new IllegalArgumentException("Type must be either MOVIE_CREDITS_CONTROLLER or PERSON_CREDITS_CONTROLLER");
        }

        if(type == ControllerFactory.MOVIE_CREDITS_CONTROLLER){
            return new CreditsController(type, id, new CreditsLoadingStrategy() {

                final Movie service = ServiceFactory.createService(Movie.class);

                @Override
                public Call<CreditsWrapper> createCall(int id) {
                    return service.getCredits(id);
                }
            });
        } else {
            return new CreditsController(type, id, new CreditsLoadingStrategy() {

                final People service = ServiceFactory.createService(People.class);

                @Override
                public Call<CreditsWrapper> createCall(int id) {
                    return service.getPersonMovieCredits(id);
                }
            });
        }
    }

    @Override
    public void addCreditsView(CreditsView view) {
        this.view = view;
    }

    @Override
    public void commandLoad() {
        //based on the strategy used, a specific adapter is required
        if(this.runtimeType == ControllerFactory.MOVIE_CREDITS_CONTROLLER){
            view.setAdapters(AbstractCreditAdapter.createAdapter((OnPersonClickListener)this.view), AbstractCreditAdapter.createAdapter((OnPersonClickListener)this.view));
        } else {
            view.setAdapters(AbstractCreditAdapter.createAdapter((OnMovieClickListener)this.view), AbstractCreditAdapter.createAdapter((OnMovieClickListener)this.view));
        }

        if(!loaded && loadedCast.isEmpty() && loadedCrew.isEmpty()){
            call = strategy.createCall(this.id);
            call.enqueue(callback);
        } else {
            if(view.isInForeground()){
                if(!loadedCast.isEmpty()){
                    view.setCast(loadedCast);
                    view.notifyCastAdded(loadedCast.size());
                }
                if(!loadedCrew.isEmpty()){
                    view.setCrew(loadedCrew);
                    view.notifyCrewAdded(loadedCrew.size());
                }
            }
        }
    }

    @Override
    protected Call getCall() {
        return call;
    }

    /**
     * Interface for a strategy of call creation
     */
    private interface CreditsLoadingStrategy {
        /**
         * Factory method to use for creating the call to enqueue
         * @param id of the entity that has credits
         * @return the call to enqueue for loading the credits
         */
        Call<CreditsWrapper> createCall(int id);
    }
}
