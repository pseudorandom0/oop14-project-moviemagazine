package it.unibo.studio.moviemagazine.activities;

import android.support.v4.app.FragmentTransaction;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.fragments.DiscoverSectionFragment;

/**
 * Discover section activity
 */
public class DiscoverSectionActivity extends BaseActivity implements StickyBackStack{

    private boolean sticky = false;

    @Override
    public void displayContent() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, DiscoverSectionFragment.newInstance());
        transaction.addToBackStack(null).commit();
    }

    @Override
    public void setSticky(boolean sticky){
        this.sticky = sticky;
    }

    @Override
    public void onBackPressed() {
        if(!sticky){
            super.onBackPressed();
        }
    }
}
