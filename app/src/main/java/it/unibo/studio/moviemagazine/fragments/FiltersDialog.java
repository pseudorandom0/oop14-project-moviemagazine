package it.unibo.studio.moviemagazine.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.text.ParseException;


import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.adapters.GenreAdapter;
import it.unibo.studio.moviemagazine.constants.FilterMapper;
import it.unibo.studio.moviemagazine.constants.enums.MovieSortOrder;
import it.unibo.studio.moviemagazine.controllers.FilterController;
import it.unibo.studio.moviemagazine.model.interfaces.Genre;
import it.unibo.studio.moviemagazine.utils.Utils;
import it.unibo.studio.moviemagazine.view.listeners.OnFilterListener;
import it.unibo.studio.moviemagazine.view.listeners.OnGenreSelected;
import it.unibo.studio.moviemagazine.view.listeners.OnSortListener;

/**
 *
 */
public class FiltersDialog extends DialogFragment implements OnGenreSelected{


    private Spinner releaseYear;
    private Spinner sort;
    private RecyclerView genres;
    private Button ok;
    private GenreAdapter adapter;
    private FilterController controller;
    private OnFilterListener listener;
    private OnSortListener listenerSort;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(it.unibo.studio.moviemagazine.R.layout.filter_view, container, false);
        releaseYear = (Spinner) view.findViewById(R.id.releaseYearSpinner);
        sort = (Spinner) view.findViewById(R.id.sortSpinner);
        genres = (RecyclerView) view.findViewById(R.id.genresList);
        ok = (Button) view.findViewById(R.id.okButtton);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new GenreAdapter(this);

        final ArrayAdapter<Integer> yearsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, controller.getReleaseYearValues());
        yearsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        releaseYear.setAdapter(yearsAdapter);

        releaseYear.setSelection(1);
        releaseYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String year = Integer.toString(yearsAdapter.getItem(position));
                try {
                    controller.setReleaseYear(Utils.getDateFromYear(year));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sort.setSelection(controller.getDefaultMovieSortOrder().ordinal());
        sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                controller.setMovieSortOrder(MovieSortOrder.fromOrdinal(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFilterAndSortSet(((FilterMapper)controller).getFiltersMap(), controller.getDefaultMovieSortOrder());
                dismiss();
            }
        });

        genres.setLayoutManager(manager);
        genres.setAdapter(adapter);
        genres.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    public void setController(FilterController controller){
        this.controller = controller;
    }

    public void setOnFilterListener(OnFilterListener listener){
        this.listener = listener;
    }

    public void setOnSortListener(OnSortListener listener){
        this.listenerSort = listener;
    }


    @Override
    public void genreSelected(Genre genre, boolean checked) {
        if(checked){
            controller.addWithGenre(genre);
        } else {
            controller.removeWithGenre(genre);
        }
    }
}
