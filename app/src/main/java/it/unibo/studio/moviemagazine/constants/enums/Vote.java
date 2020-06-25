package it.unibo.studio.moviemagazine.constants.enums;

import java.util.HashMap;
import java.util.Map;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.constants.FilterMapper;

/**
 * This enum uses the same approach of {@link ReleaseTime} but in this version is not used
 */
public enum Vote implements FilterMapper {
    VOTE_COUNT_GTE(false, Constants.APIParameters.VOTE_COUNT_GTE), VOTE_COUNT_LTE(false, Constants.APIParameters.VOTE_COUNT_LTE),
    VOTE_AVERAGE_GTE(true, Constants.APIParameters.VOTE_AVERAGE_GTE), VOTE_AVERAGE_LTE(true, Constants.APIParameters.VOTE_AVERAGE_LTE);


    private float voteAverage;
    private int voteCount;
    private final boolean isVoteAverage;
    private boolean valueIsSet = false;
    private final String filterKey;

    Vote(boolean isVoteAverage, String filterKey) {
        this.isVoteAverage = isVoteAverage;
        this.filterKey = filterKey;
    }

    public void setVoteCount(int voteCount) throws UnsupportedOperationException, IllegalArgumentException{
        if(isVoteAverage){
            throw new UnsupportedOperationException("This filter is for vote average");
        } else if(voteCount < 0 ){
            throw new IllegalArgumentException("Vote count cannot be negative");
        } else {
            valueIsSet = true;
            this.voteCount = voteCount;
        }
    }

    public void setVoteAverage(float voteAverage) throws UnsupportedOperationException, IllegalArgumentException{
        if(!isVoteAverage){
            throw new UnsupportedOperationException("This filter is for vote count");
        } else if(voteAverage < 0){
            throw new IllegalArgumentException("Vote average cannot be negative");
        } else if(voteAverage > 10){
            throw new IllegalArgumentException("Vote average cannot be greater than 10");
        } else {
            valueIsSet = true;
            this.voteAverage = voteAverage;
        }
    }

    @Override
    public Map<String, String> getFiltersMap() throws IllegalStateException{
        Map<String,String> mappedFilter = new HashMap<>();
        if(!valueIsSet){
            String valueType = isVoteAverage? "vote average" : "vote count";
            throw new IllegalStateException("Cannot create the filter map because the value of " + valueType + " is not set");
        }
        mappedFilter.put(filterKey, isVoteAverage? Float.toString(voteAverage) : Integer.toString(voteCount));
        return mappedFilter;
    }
}
