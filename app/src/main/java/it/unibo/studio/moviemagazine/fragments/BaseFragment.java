package it.unibo.studio.moviemagazine.fragments;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import it.unibo.studio.moviemagazine.view.View;

/**
 * Base fragment
 */
public class BaseFragment extends Fragment implements View{


    @Override
    public boolean isInForeground() {
        return isVisible();
    }


    @Override
    public void displayError(String message) {
        makeToast(message);
    }

    @Override
    public void displayMessage(String message) {
        makeToast(message);
    }

    /**
     * When getting a resource like {@code getString(int id)} we need to check if the fragment is in foreground because if not,
     * methods that work with context like resource getters will fail and will throw an exception that will cause application crash
     * @param resId the id of the message to display
     */
    @Override
    public void displayLocalizedMessage(int resId) {
        if(isInForeground()){
            makeToast(getString(resId));
        }
    }

    private void makeToast(String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
