package it.unibo.studio.moviemagazine.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import it.unibo.studio.moviemagazine.R;


import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.utils.Utils;
import it.unibo.studio.moviemagazine.view.listeners.OnMovieClickListener;

/**
 * Adapter for a list of movies.
 */
public class MovieAdapter extends AbstractListAdapter<MovieAdapter.ViewHolder> {

    private List<Movie> movies;
    private final OnMovieClickListener listener;


    /**
     * Creates a movie adapter with a listener to notify on click on a movie
     * @param listener the listener to notify
     */
    public MovieAdapter(OnMovieClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        MovieAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    /**
     * Sets the model list to display
     * @param movies the list of movies to display
     */
    public void setMovies(List<Movie> movies){
        this.movies = movies;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.bind(movie,listener);
    }

    /**
     * Sometimes this method gets called when the list model list is still not set. So a simple check will avoid a {@code NullPointerException}
     * @return
     */
    @Override
    public int getItemCount() {
        return movies != null? movies.size() : 0;
    }

    /**
     * Holds the views of a single row
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView poster;
        final TextView title;
        final TextView genres;
        final TextView voteAverage;
        final TextView releaseYear;
        final TextView overview;
        final View container;

        public ViewHolder(View itemView) {
            super(itemView);
            genres = (TextView)itemView.findViewById(R.id.genres);
            overview = (TextView)itemView.findViewById(R.id.overview);
            voteAverage = (TextView)itemView.findViewById(R.id.voteAverage);
            poster = (ImageView)itemView.findViewById(R.id.poster);
            title = (TextView)itemView.findViewById(R.id.title);
            releaseYear = (TextView)itemView.findViewById(R.id.release_year);
            container = itemView;

        }

        /**
         * This method binds the click on the container to the movie that is displayed in the container.
         * Took from <a href="http://antonioleiva.com/recyclerview-listener/">Antonio's Leiva "Set a click listener to a RecyclerView"</a>
         * @param movie the movie to bind to a listener
         * @param listener the listener to bind to the movie
         */
        public void bind(final Movie movie, final OnMovieClickListener listener){
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onMovieClick(movie);
                }
            });

            genres.setText(Utils.printableGenresFromList(movie.getGenres()));
            overview.setText(movie.getOverview());
            voteAverage.setText(Utils.formatVoteAverage(movie.getVoteAverage()));
            releaseYear.setText(Utils.getYearFromDate(movie.getReleaseDate()));
            title.setText(movie.getTitle());
            Picasso.with(container.getContext()).load(movie.getMainPoster().getUrl(92,0)).error(R.drawable.ic_error_black_24dp).into(poster);
        }
    }

}
