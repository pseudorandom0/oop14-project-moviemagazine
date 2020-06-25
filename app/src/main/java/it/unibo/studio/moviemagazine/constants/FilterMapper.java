package it.unibo.studio.moviemagazine.constants;

import java.util.Map;

/**
 * Interface implemented by classes that manage filtering of movies
 */
public interface FilterMapper {
    /**
     * Creates a map with the filters that were set
     * @return the map with the filters mapped
     * @throws IllegalStateException
     */
    Map<String,String> getFiltersMap() throws IllegalStateException;
}
