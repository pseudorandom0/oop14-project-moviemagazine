package it.unibo.studio.moviemagazine.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBGenre;
import it.unibo.studio.moviemagazine.model.interfaces.Genre;
import it.unibo.studio.moviemagazine.view.listeners.OnGenreSelected;

/**
 * Adapter for genres list displayed in the filters dialog
 */
public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {

    private final List<Genre> genres;
    private static List<Boolean> selected;
    private final OnGenreSelected listener;

    /**
     * Creates a new adapter with a listener to notify when a genre has been selected.
     * How the boolean list is initialized is from <a href="http://stackoverflow.com/questions/20615448/set-all-values-of-arraylistboolean-to-false-on-instatiation">StackOverflow</a>
     * @param listener the listener to notify on selection/unselection of a genre
     */
    public GenreAdapter(OnGenreSelected listener) {
        genres = TMDBGenre.getAllGenres();
        selected = new ArrayList<>(Arrays.asList(new Boolean[genres.size()]));
        Collections.fill(selected, Boolean.FALSE);
        this.listener = listener;
    }

    @Override
    public GenreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_genres_list_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(GenreAdapter.ViewHolder holder, int position) {
        holder.bind(genres.get(position), listener, position);
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        final View container;
        final TextView genreName;
        final CheckBox checkbox;

        public ViewHolder(View itemView) {
            super(itemView);
            container = itemView;
            genreName = (TextView) itemView.findViewById(R.id.genreName);
            checkbox = (CheckBox) itemView.findViewById(R.id.genreCheckbox);
        }

        /**
         * Binds the click on the container to a listener
         * @param genre genre to bind
         * @param listener listener to notify on click
         * @param position position in the list of the actual state of selection of the genre
         */
        public void bind(final Genre genre, final OnGenreSelected listener, final int position){
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkbox.isChecked()){
                        checkbox.setChecked(false);
                        listener.genreSelected(genre, false);
                        selected.set(position, false);
                    } else {
                        checkbox.setChecked(true);
                        listener.genreSelected(genre, true);
                        selected.set(position, true);
                    }

                }
            });
            checkbox.setChecked(selected.get(position));
            genreName.setText(genre.getName());
        }
    }
}
