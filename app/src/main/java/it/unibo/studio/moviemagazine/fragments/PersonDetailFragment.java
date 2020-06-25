package it.unibo.studio.moviemagazine.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.controllers.IPersonDetailController;
import it.unibo.studio.moviemagazine.controllers.implementations.ControllerFactory;
import it.unibo.studio.moviemagazine.model.interfaces.Person;
import it.unibo.studio.moviemagazine.utils.Utils;
import it.unibo.studio.moviemagazine.view.PersonView;

/**
 * Fragment that displays the details of a person
 */
public class PersonDetailFragment extends BaseFragment implements PersonView{


    private static final String PERSON_ID_KEY = "person_id";

    private IPersonDetailController controller;

    private ImageView personProfile;
    private TextView personName, personBirthDeath, personPlaceBirth, personBiography;


    public static PersonDetailFragment newInstance(int personId){
        PersonDetailFragment fragment = new PersonDetailFragment();
        Bundle args = new Bundle();
        args.putInt(PERSON_ID_KEY, personId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.commandLoad();
    }

    @Override
    public void onStop() {
        super.onStop();
        controller.cancelLoad();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        controller = ControllerFactory.createPersonDetailController(args.getInt(PERSON_ID_KEY));
        controller.addPersonView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.person_detail, container, false);

        personProfile = (ImageView) view.findViewById(R.id.detailPersonProfile);
        personName = (TextView) view.findViewById(R.id.detailPersonName);
        personBirthDeath = (TextView) view.findViewById(R.id.detailPersonBirthDeath);
        personPlaceBirth = (TextView) view.findViewById(R.id.detailPersonPlaceBirth);
        personBiography = (TextView) view.findViewById(R.id.detailPersonBiography);

        return view;
    }

    @Override
    public void displayPerson(Person person) {
        Picasso.with(getContext()).load(person.getProfileImage().getUrl(185, 0)).error(R.drawable.ic_error_black_24dp).into(personProfile);
        personName.setText(person.getName());
        personBirthDeath.setText(Utils.formatPersonBirthDeath(person.getBirthday(), person.getDeathday()));
        personPlaceBirth.setText(person.getPlaceOfBirth());
        personBiography.setText(person.getBiography());
    }

}
