package it.unibo.studio.moviemagazine.model.interfaces;

/**
 * Represents a cast credit
 */
public interface CastCredit extends Credit {

    /**
     * @return character played by the {@code Person} in this credit
     */
    String getCharacter();

    /**
     * @return "relevance" order in the whole cast of the {@code Movie}
     */
    int getOrder();
}
