package it.unibo.studio.moviemagazine.constants.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.constants.FilterMapper;

/**
 * This enum models a with_* filter present in <a href="http://docs.themoviedb.apiary.io/#reference/discover/discovermovie">discover</a>
 * method of tmdb. The documentation says that when the values of this filters are comma separated, they are put in an and query,
 * otherwise if the values are pipe separated, it is an or query.
 */
public enum With implements FilterMapper {
    CAST(Constants.APIParameters.WITH_CAST), CREW(Constants.APIParameters.WITH_CREW),
    GENRES(Constants.APIParameters.WITH_GENRES), PEOPLE(Constants.APIParameters.WITH_PEOPLE);

    private List<Integer> ids = new ArrayList<>();
    private boolean andQuery;
    private final String filterKey;

    /**
     * Adds a with filter to an and query.
     * @param id the id of the filter
     * @throws IllegalStateException when the query is not an and query
     */
    public void and(int id) throws IllegalStateException{
        if(this.ids.isEmpty()){
            andQuery = true;
        }
        if(andQuery){
            this.ids.add(id);
        } else{
            throw new IllegalStateException("This filter is an and query, or filters are not allowed");
        }
    }

    /**
     * Adds a with filter to an or query.
     * @param id the id of the filter
     * @throws IllegalStateException when the query is not an or query
     */
    public void or(int id) throws IllegalStateException{
        if(this.ids.isEmpty()){
            andQuery = false;
        } else if(!andQuery){
            this.ids.add(id);
        } else{
            throw new IllegalStateException("This filter is an and query, or filters are not allowed");
        }
    }

    /**
     * Removes the filter from the query
     * @param id the id of the filter do remove
     */
    public void remove(int id){
        if(ids.contains(id)){
            ids.remove(ids.indexOf(id));
        }
    }

    /**
     * Resets the filter and removes all the filters that were added
     */
    public void clear(){
        ids = new ArrayList<>();
    }

    With(String filterKey) {
        this.filterKey = filterKey;
    }

    @Override
    public Map<String, String> getFiltersMap() throws IllegalStateException{
        if(ids.isEmpty()){
            //throw new IllegalStateException("Cannot create map because the id list is empty");
            return new HashMap<>();
        }
        StringBuilder parametersAppender = new StringBuilder();
        Map<String,String> mappedFilters = new HashMap<>(1);
        String separator = andQuery? Constants.APIParameters.AND_PARAMETER_SEPARATOR : Constants.APIParameters.OR_PARAMETER_SEPARATOR;
        int last = ids.size() - 1;
        for (int i = 0; i < ids.size(); i++){
            parametersAppender.append(ids.get(i));
            if(i != last){
                parametersAppender.append(separator);
            }
        }
        mappedFilters.put(this.filterKey, parametersAppender.toString());
        return mappedFilters;
    }
}
