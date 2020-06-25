package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.SearchView;


/**
 * Interface for a controller that uses {@link it.unibo.studio.moviemagazine.webservice.facade.Search}
 */
public interface ISearchController extends ListController{

    /**
     * This command launches a search query with the text provided by a {@link SearchView}
     */
    void commandSearch();

    /**
     * Adds the view where the search results should be displayed and from which the controller will retrieve the user input text
     * @param view the view to use
     */
    void addSearchView(SearchView view);

}
