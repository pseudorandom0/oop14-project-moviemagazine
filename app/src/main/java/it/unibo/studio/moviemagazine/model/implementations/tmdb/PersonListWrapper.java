package it.unibo.studio.moviemagazine.model.implementations.tmdb;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import it.unibo.studio.moviemagazine.constants.Constants;

/**
 * Wraps a list of people
 */
public class PersonListWrapper extends PagedResultWrapper{

    @SerializedName(Constants.Parsing.PERSON_LIST_RESULTS_MEMBER_NAME)
    private List<TMDBPerson> people;

    public List<TMDBPerson> getPeople() {
        return people;
    }

    private PersonListWrapper(){}

    @Override
    public int getPageSize() {
        return people.size();
    }
}
