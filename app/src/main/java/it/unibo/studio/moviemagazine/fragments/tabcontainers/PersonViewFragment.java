package it.unibo.studio.moviemagazine.fragments.tabcontainers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.controllers.implementations.ControllerFactory;
import it.unibo.studio.moviemagazine.fragments.CreditsFragment;
import it.unibo.studio.moviemagazine.fragments.PersonDetailFragment;

/**
 *
 */

public class PersonViewFragment extends Fragment{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;
    private static final String PERSON_ID_KEY = "person_id";
    private int personId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        personId = args.getInt(PERSON_ID_KEY);
    }

    public static PersonViewFragment newInstance(int personId){
        PersonViewFragment fragment = new PersonViewFragment();
        Bundle args = new Bundle();
        args.putInt(PERSON_ID_KEY, personId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.person_view, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.person_view_tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.person_tabs_pager);

        adapter = new PersonViewPagerAdapter(getChildFragmentManager(), this.personId);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private class PersonViewPagerAdapter extends FragmentPagerAdapter{

        private final PersonDetailFragment personDetail;
        private final CreditsFragment personCredits;

        public PersonViewPagerAdapter(FragmentManager fm, int personId) {
            super(fm);
            personDetail = PersonDetailFragment.newInstance(personId);
            personCredits = CreditsFragment.createWithController(ControllerFactory.PERSON_CREDITS_CONTROLLER, personId);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return getResources().getString(R.string.movie_detail_tab_label); //can reuse the same labels..
            } else {
                return getResources().getString(R.string.movie_credit_tab_label);
            }
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return personDetail;
            } else {
                return personCredits;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
