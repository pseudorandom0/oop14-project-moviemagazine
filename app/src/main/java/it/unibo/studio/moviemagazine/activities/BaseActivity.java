package it.unibo.studio.moviemagazine.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.view.MainView;

public abstract class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {


    private DrawerLayout menuView;
    private int exitClicksCount;
    private static final int EXIT_CLICK_TIMEOUT = 2000;
    protected boolean contentDisplayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        exitClicksCount = 1;
        contentDisplayed = false;
        menuView = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!contentDisplayed){
            displayContent();
        }
    }

    /**
     * When the user presses back and he's in the home view of the section, the first time a message is displayed,
     * the second time the application will be closed
     */
    @Override
    public void onBackPressed() {
        if (menuView.isDrawerOpen(GravityCompat.START)) {
            menuView.closeDrawer(GravityCompat.START);
        }
        if(canGoBack()){
            getSupportFragmentManager().popBackStack();
        } else if (exitClicksCount > 0){
            displayLocalizedMessage(R.string.press_again_to_exit);
            exitClicksCount--;
            /*Handler usage to reset the counter on 2 seconds timeout was suggested
            * by my roommate Federico Giannoni and credits goes to him*/
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    exitClicksCount = 1;
                }
            }, EXIT_CLICK_TIMEOUT);
        } else {
            finish();
        }
    }

    /**
     * The user cannot go back if there's only one fragment in the back stack
     * @return {@code true} when there are more than one views in the stack
     */
    protected boolean canGoBack(){
        return getSupportFragmentManager().getBackStackEntryCount() > 1;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        menuView.closeDrawer(GravityCompat.START);
        Intent intent;
        /*to prevent the actual section activity remaining in the activity back stack
        * whenever another section is going to be launched, the actual is finished*/
        switch (id){
            case R.id.nav_movies:
                intent = new Intent(this, MoviesSectionActivity.class);
                startActivity(intent);
                finish();
               break;
            case R.id.nav_discover:
                intent = new Intent(this, DiscoverSectionActivity.class);
                startActivity(intent);
                finish();
               break;
            case R.id.nav_search:
                intent = new Intent(this, SearchSectionActivity.class);
                startActivity(intent);
                finish();
            default:
               Log.d("NAV/DRAWER", "WENT IN DEFAULT CASE IN ABSTRACT BASE ACTIVITY!");
               break;
        }
        return true;
    }

    @Override
    public boolean isInForeground() {
        return true;
    }

    @Override
    public void displayMessage(String message) {
        makeToast(message);
    }

    @Override
    public void displayLocalizedMessage(int resId) {
        if(isInForeground()){
            makeToast(getString(resId));
        }
    }

    private void makeToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayError(String message) {
        makeToast(message);
    }
}
