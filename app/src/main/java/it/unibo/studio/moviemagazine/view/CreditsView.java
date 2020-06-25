package it.unibo.studio.moviemagazine.view;

import java.util.List;

import it.unibo.studio.moviemagazine.adapters.AbstractCreditAdapter;
import it.unibo.studio.moviemagazine.model.interfaces.Credit;

/**
 * Interface for a view that displays credits of a movie or a person
 */
public interface CreditsView extends View{

    /**
     * Setter for the adapters of the view. It is required because the controller knows which concrete adapters must be used
     * @param castAdapter adapter to use for displaying cast credits
     * @param crewAdapter adapter to use for displaying crew credits
     */
    void setAdapters(AbstractCreditAdapter castAdapter, AbstractCreditAdapter crewAdapter);

    /**
     * Sets the model list to display
     * @param castCredits the credits to display
     */
    void setCast(List<Credit> castCredits);
    /**
     * Sets the model list to display
     * @param crewCredits the credits to display
     */
    void setCrew(List<Credit> crewCredits);

    /**
     * Notifies the view that cast credits were added to the model list so the view can be refreshed
     * @param count of the credits added
     */
    void notifyCastAdded(int count);

    /**
     * Notifies the view that crew credits were added to the model list so the view can be refreshed
     * @param count of the credits added
     */
    void notifyCrewAdded(int count);
}
