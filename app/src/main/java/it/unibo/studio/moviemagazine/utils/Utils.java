package it.unibo.studio.moviemagazine.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Genre;

/**
 * Class that holds methods used in multiple places
 */
public class Utils {

    private static final DecimalFormat format = new DecimalFormat("#.#");
    private static final String BIRTH_DEATH_SEPARATOR = " - ";

    /**
     * Utility method for preparing a comma separated string from a list of genres
     * @param genres to comma separate and concatenate to the result
     * @return a string with comma separated names of the genres
     */
    public static String printableGenresFromList(final List<Genre> genres){
        if(genres == null || genres.isEmpty()){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int last = genres.size() - 1;
        for(int i=0; i < genres.size(); i++){
            builder.append(genres.get(i).getName());
            if(i != last){
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    /**
     * Utility method for extracting the year from a {@code Date}
     * @param date from which the year should be extracted
     * @return the year extracted in String form
     */
    public static String getYearFromDate(Date date){
        if(date != null){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            return formatter.format(date);
        } else {
            return "";
        }
    }

    /**
     * Formats for printing a double representing an average of votes
     * @param voteAverage to format
     * @return the vote average rounded and formatted to one decimal place
     */
    public static String formatVoteAverage(final double voteAverage){
        return format.format(voteAverage);
    }

    /**
     * Formats the birthday date and the eventual deathday date for in a printable format
     * @param birth date to format
     * @param death date to format
     * @return printable representation of the two dates
     */
    public static String formatPersonBirthDeath(final Date birth, final Date death){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder builder = new StringBuilder();
        if(birth != null){
            builder.append(formatter.format(birth));
            if(death != null){
                builder.append(BIRTH_DEATH_SEPARATOR);
                builder.append(formatter.format(death));
            }
        }
        return builder.toString();
    }

    /**
     * @param year to put in Date
     * @return the {@code Date} with the given year set
     * @throws ParseException
     */
    public static Date getDateFromYear(String year) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        return formatter.parse(year);
    }

}
