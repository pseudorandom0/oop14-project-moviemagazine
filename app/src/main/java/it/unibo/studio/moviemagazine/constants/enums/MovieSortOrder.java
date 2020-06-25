package it.unibo.studio.moviemagazine.constants.enums;


import it.unibo.studio.moviemagazine.constants.Constants;

/**
 * The many ways of ordering a list of movies. Only a subset of these are used in this first version of the application.
 */
public enum MovieSortOrder{
    POPULARITY_DESC(Constants.APIParameters.Values.Popularity.DESC), POPULARITY_ASC(Constants.APIParameters.Values.Popularity.ASC),
    VOTE_AVERAGE_DESC(Constants.APIParameters.Values.VoteAverage.DESC), VOTE_AVERAGE_ASC(Constants.APIParameters.Values.VoteAverage.ASC),
    PRIMARY_RELEASE_DATE_DESC(Constants.APIParameters.Values.PrimaryReleaseDate.DESC), PRIMARY_RELEASE_DATE_ASC(Constants.APIParameters.Values.PrimaryReleaseDate.ASC),
    ORIGINAL_TITLE_ASC(Constants.APIParameters.Values.OriginalTitle.ASC), ORIGINAL_TITLE_DESC(Constants.APIParameters.Values.OriginalTitle.DESC),
    RELEASE_DATE_DESC(Constants.APIParameters.Values.ReleaseDate.ASC), RELEASE_DATE_ASC(Constants.APIParameters.Values.ReleaseDate.DESC),
    REVENUE_ASC(Constants.APIParameters.Values.Revenue.ASC), REVENUE_DESC(Constants.APIParameters.Values.Revenue.DESC),
    VOTE_COUNT_ASC(Constants.APIParameters.Values.VoteCount.ASC), VOTE_COUNT_DESC(Constants.APIParameters.Values.VoteCount.DESC);


    private final String value;

    MovieSortOrder(String value) {
        this.value = value;
    }

    public String getParameterValue(){
        return this.value;
    }

    /**
     * There is no way to construct an instance of an enum from it's ordinal, but this is needed.
     * @param ordinal the ordinal position of the enum constant
     * @return the enum constant corresponding to the ordinal
     */
    public static MovieSortOrder fromOrdinal(int ordinal){
        switch (ordinal){
            case 0:
                return MovieSortOrder.POPULARITY_DESC;
            case 1:
                return MovieSortOrder.POPULARITY_ASC;
            case 2:
                return MovieSortOrder.VOTE_AVERAGE_DESC;
            case 3:
                return MovieSortOrder.VOTE_AVERAGE_ASC;
            case 4:
                return MovieSortOrder.PRIMARY_RELEASE_DATE_DESC;
            case 5:
                return MovieSortOrder.PRIMARY_RELEASE_DATE_ASC;
            case 6:
                return MovieSortOrder.ORIGINAL_TITLE_ASC;
            case 7:
                return MovieSortOrder.ORIGINAL_TITLE_DESC;
            default:
                return MovieSortOrder.POPULARITY_DESC;
        }
    }
}
