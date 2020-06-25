package it.unibo.studio.moviemagazine.activities;

import android.support.v4.app.FragmentTransaction;


import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.fragments.tabcontainers.MoviesSectionFragment;


public class MoviesSectionActivity extends BaseActivity {


    @Override
    public void displayContent() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, MoviesSectionFragment.newInstance());
        transaction.addToBackStack(null).commit();
        contentDisplayed = true;

    }

}
