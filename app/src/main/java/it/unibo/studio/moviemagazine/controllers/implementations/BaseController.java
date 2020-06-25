package it.unibo.studio.moviemagazine.controllers.implementations;

import it.unibo.studio.moviemagazine.controllers.Controller;
import retrofit2.Call;

/**
 * Base class for controllers
 */
abstract class BaseController implements Controller{
    /**
     * If a view is going to be hidden this method stops the current request if it has not been already executed
     */
    public void cancelLoad(){
        if(getCall() != null && !getCall().isExecuted()){
            getCall().cancel();
        }
    }

    /**
     * Getter for template method that must return the current call that is going to be executed or has been enqueued
     * @return the current call
     */
    protected abstract Call getCall();
}
