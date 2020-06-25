package it.unibo.studio.moviemagazine.model.interfaces;

/**
 * One of the two types of credits
 */
public interface CrewCredit extends Credit{
    /**
     * @return the department associated to the job
     */
    String getDepartment();

    /**
     * @return the job of the {@code Person} in the {@code Movie}
     */
    String getJob();
}
