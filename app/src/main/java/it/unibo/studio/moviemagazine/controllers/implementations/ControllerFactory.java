package it.unibo.studio.moviemagazine.controllers.implementations;

import it.unibo.studio.moviemagazine.controllers.ICreditsController;
import it.unibo.studio.moviemagazine.controllers.IMovieDetailController;
import it.unibo.studio.moviemagazine.controllers.IPersonDetailController;

/**
 * Controller factory for simple controllers
 */
public abstract class ControllerFactory {

    public static final int MOVIE_CREDITS_CONTROLLER = 1;
    public static final int PERSON_CREDITS_CONTROLLER = 2;

    /**
     * Factory method that creates a controller that loads {@link it.unibo.studio.moviemagazine.model.interfaces.Credit}s.
     * When the id parameter is a movie id, the type parameter must be {@code ControllerFactory.MOVIE_CREDITS_CONTROLLER}, same
     * logic applies when the id parameter is a person id, in this case the type parameter must be {@code ControllerFactory.PERSON_CREDITS_CONTROLLER}.
     * @param type should be either {@code ControllerFactory.MOVIE_CREDITS_CONTROLLER} or {@code ControllerFactory.PERSON_CREDITS_CONTROLLER}
     * @param id the id of a {@code Movie} or a {@code Person}
     * @return a {@code ICreditsController} that loads the credits for the given id
     */
    public static ICreditsController createCreditsController(int type, int id){
        return CreditsController.createController(type, id);
    }

    /**
     * Factory method that creates a {@code IMovieDetailController} that loads the details of a {@link it.unibo.studio.moviemagazine.model.interfaces.Movie}
     * with the given movie id.
     * @param movieId the id of the movie
     * @return a {@link IMovieDetailController} that loads the details for the given movie id
     */
    public static IMovieDetailController createMovieDetailController(int movieId){
        return new MovieDetailController(movieId);
    }

    /**
     * Factory method that creates a {@code IPersonDetailController} that loads the details of a person for a given person id
     * @param personId the id of the person
     * @return a  {@link IPersonDetailController} that loads the details for the given person id
     */
    public static IPersonDetailController createPersonDetailController(int personId){
        return new PersonController(personId);
    }

}
