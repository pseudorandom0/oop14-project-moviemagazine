package it.unibo.studio.moviemagazine.webservice.facade;


import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.CreditsWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBPerson;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Interface for requesting person details
 */
public interface People{

    @GET(Constants.APIMethods.PERSON_BY_ID)
    Call<TMDBPerson> getPersonById(@Path(Constants.APIParameters.ID) int id);

    @GET(Constants.APIMethods.PERSON_MOVIE_CREDITS)
    Call<CreditsWrapper> getPersonMovieCredits(@Path(Constants.APIParameters.ID) int id);

    /*@GET(Constants.APIMethods.PERSON_IMAGES)
    Call<List<TMDBImage>> getPersonImages(@Path(Constants.APIParameters.ID) int id);*/
}
