package it.unibo.studio.moviemagazine.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.adapters.AbstractCreditAdapter;
import it.unibo.studio.moviemagazine.controllers.ICreditsController;
import it.unibo.studio.moviemagazine.controllers.implementations.ControllerFactory;
import it.unibo.studio.moviemagazine.fragments.tabcontainers.MovieViewFragment;
import it.unibo.studio.moviemagazine.fragments.tabcontainers.PersonViewFragment;
import it.unibo.studio.moviemagazine.model.interfaces.Credit;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.model.interfaces.Person;
import it.unibo.studio.moviemagazine.view.CreditsView;
import it.unibo.studio.moviemagazine.view.MainView;
import it.unibo.studio.moviemagazine.view.listeners.OnMovieClickListener;
import it.unibo.studio.moviemagazine.view.listeners.OnPersonClickListener;

/**
 * Fragment that displays the credits of a movie or a person
 */
public class CreditsFragment extends BaseFragment implements CreditsView, OnMovieClickListener, OnPersonClickListener{


    private static final String CONTROLLER_TYPE_KEY = "credit_controller_type";
    private static final String CREDITS_ITEM_ID_KEY = "credit_item_id";

    private ICreditsController controller;

    private RecyclerView castList;
    private RecyclerView crewList;

    private AbstractCreditAdapter castAdapter;
    private AbstractCreditAdapter crewAdapter;


    public static CreditsFragment createWithController(int type, int id){
        CreditsFragment fragment = new CreditsFragment();
        Bundle args = new Bundle();
        args.putInt(CONTROLLER_TYPE_KEY, type);
        args.putInt(CREDITS_ITEM_ID_KEY, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStop() {
        super.onStop();
        controller.cancelLoad();
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.commandLoad();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        controller = ControllerFactory.createCreditsController(args.getInt(CONTROLLER_TYPE_KEY), args.getInt(CREDITS_ITEM_ID_KEY));
        controller.addCreditsView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.credits, container, false);
        setUpLayout(view);
        return view;
    }

    protected void setUpLayout(View view){
        castList = (RecyclerView) view.findViewById(R.id.CastList);
        crewList = (RecyclerView) view.findViewById(R.id.CrewList);

        castList.setLayoutManager(createLayoutManager());
        crewList.setLayoutManager(createLayoutManager());
    }

    private RecyclerView.LayoutManager createLayoutManager(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return layoutManager;
    }

    @Override
    public void setAdapters(AbstractCreditAdapter castAdapter, AbstractCreditAdapter crewAdapter) {
        this.castAdapter = castAdapter;
        this.crewAdapter = crewAdapter;
        castList.setAdapter(castAdapter);
        crewList.setAdapter(crewAdapter);
    }

    @Override
    public void setCast(List<Credit> castCredits) {
        setCredits(castAdapter, castCredits);
    }

    @Override
    public void notifyCastAdded(int count) {
        creditsAdded(castAdapter, count);
    }

    @Override
    public void setCrew(List<Credit> crewCredits) {
        setCredits(crewAdapter, crewCredits);
    }

    @Override
    public void notifyCrewAdded(int count) {
        creditsAdded(crewAdapter, count);
    }

    private void setCredits(AbstractCreditAdapter adapter, List<Credit> credits){
        adapter.setCredits(credits);
    }

    private void creditsAdded(AbstractCreditAdapter adapter, int count){
        if(adapter.getItemCount() == -1){
            return;
        }
        adapter.notifyItemRangeInserted(adapter.getItemCount() - count, adapter.getItemCount());
    }

    @Override
    public void onMovieClick(Movie clicked) {
        ((MainView)getActivity()).replaceFragment(MovieViewFragment.newInstance(clicked.getId()));
    }

    @Override
    public void onPersonClick(Person clicked) {
        ((MainView)getActivity()).replaceFragment(PersonViewFragment.newInstance(clicked.getId()));
    }

}
