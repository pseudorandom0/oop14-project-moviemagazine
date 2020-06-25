package it.unibo.studio.moviemagazine.constants.enums;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.constants.FilterMapper;

/**
 * Enumerates the filters by dates and years.
 */
public enum ReleaseTime implements FilterMapper {
    PRIMARY_RELEASE_YEAR(true, Constants.APIParameters.PRIMARY_RELEASE_YEAR),
    RELEASE_YEAR(true, Constants.APIParameters.RELEASE_YEAR),
    PRIMARY_RELEASE_DATE_GTE(false, Constants.APIParameters.PRIMARY_RELEASE_DATE_GTE),
    PRIMARY_RELEASE_DATE_LTE(false, Constants.APIParameters.PRIMARY_RELEASE_DATE_LTE),
    RELEASE_DATE_LTE(false, Constants.APIParameters.RELEASE_DATE_LTE),
    RELEASE_DATE_GTE(false, Constants.APIParameters.RELEASE_DATE_GTE);

    private Date date;
    private final boolean yearOnly;
    private final String filterKey;

    ReleaseTime(boolean yearOnly, String filterKey) {
        this.yearOnly = yearOnly;
        this.filterKey = filterKey;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    @Override
    public Map<String, String> getFiltersMap() throws IllegalStateException{
        if(date == null){
            throw new IllegalStateException("Cannot create map because the date is not set");
        }
        Map<String,String> mappedFilters = new HashMap<>();
        SimpleDateFormat formatter;
        if (yearOnly){
            formatter = new SimpleDateFormat("yyyy");
        } else {
            formatter = new SimpleDateFormat(Constants.DATE_STYLE_PATTERN);
        }
        mappedFilters.put(this.filterKey, formatter.format(date));
        return mappedFilters;
    }
}
