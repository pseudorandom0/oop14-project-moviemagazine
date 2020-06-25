package it.unibo.studio.moviemagazine.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;


import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.controllers.ConfigurationController;

import it.unibo.studio.moviemagazine.view.ConfigurationView;
import it.unibo.studio.moviemagazine.webservice.facade.ConfigurationManager;


public class SplashActivity extends AppCompatActivity implements ConfigurationView {

    private ProgressBar progressBar;
    private ConfigurationController controller;
    private boolean isInForeground = false;

    @Override
    public void displayHome() {
        Intent intent = new Intent(this, MoviesSectionActivity.class);
        startActivity(intent);
    }

    @Override
    public void attachViewObserver(ConfigurationController controller) {
        this.controller = controller;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        ConfigurationController controller = new ConfigurationManager();
        controller.addConfigurationView(this);
        attachViewObserver(controller);

    }

    //the view is created and visible
    @Override
    protected void onStart() {
        super.onStart();
        controller.commandConfigure();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isInForeground = true;
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        //if something goes wrong on configuration means there's no internet connection
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isInForeground = false;
    }

    @Override
    public boolean isInForeground() {
        return isInForeground;
    }

    @Override
    public void displayMessage(String message) {
        makeToast(message);
    }

    @Override
    public void displayLocalizedMessage(int resId) {
        if(isInForeground){
            makeToast(getString(resId));
        }
    }

    private void makeToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayLoading() {
        progressBar.setIndeterminate(true);
    }

    @Override
    public void finishLoading() {
        progressBar.setIndeterminate(false);
    }
}
