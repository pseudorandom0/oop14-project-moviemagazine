package it.unibo.studio.moviemagazine.controllers.implementations;

import it.unibo.studio.moviemagazine.controllers.IPersonDetailController;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBPerson;
import it.unibo.studio.moviemagazine.view.PersonView;
import it.unibo.studio.moviemagazine.webservice.facade.People;
import it.unibo.studio.moviemagazine.webservice.facade.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Loads the details of a person
 */
class PersonController extends BaseController implements IPersonDetailController {

    private final int personId;
    private PersonView view;
    private Call<TMDBPerson> call;
    private TMDBPerson loaded;

    /**
     * Constructs a {@code PersonController} that loads the details of the person for the given id
     * @param personId the id of the person
     */
    PersonController(int personId) {
        this.personId = personId;
    }

    @Override
    public void commandLoad() {
        if(loaded != null){
            view.displayPerson(loaded);
        } else {
            People service = ServiceFactory.createService(People.class);
            call = service.getPersonById(personId);
            call.enqueue(new Callback<TMDBPerson>() {
                @Override
                public void onResponse(Call<TMDBPerson> call, Response<TMDBPerson> response) {
                    loaded = response.body();
                    if(loaded != null){
                        view.displayPerson(loaded);
                    } else {
                        view.displayError("Something went wrong");
                    }
                }

                @Override
                public void onFailure(Call<TMDBPerson> call, Throwable t) {
                    view.displayError(t.getMessage());
                }
            });
        }
    }

    @Override
    protected Call getCall() {
        return this.call;
    }

    @Override
    public void addPersonView(PersonView view) {
        this.view = view;
    }
}
