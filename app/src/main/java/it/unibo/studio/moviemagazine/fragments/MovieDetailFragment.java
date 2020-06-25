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
import it.unibo.studio.moviemagazine.controllers.IMovieDetailController;
import it.unibo.studio.moviemagazine.controllers.implementations.ControllerFactory;
import it.unibo.studio.moviemagazine.fragments.tabcontainers.MovieViewFragment;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.utils.Utils;
import it.unibo.studio.moviemagazine.view.MovieDetailView;

/**
 * Displays the detail of a movie
 */
public class MovieDetailFragment extends BaseFragment implements MovieDetailView{


    private ImageView moviePoster, movieBackdrop;
    private TextView movieTitle, movieReleaseDate, movieRating, voteCount, movieGenres, movieOverview,
    movieRuntime;

    private IMovieDetailController controller;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        controller = ControllerFactory.createMovieDetailController(args.getInt(MovieViewFragment.MOVIE_ID_KEY));
        controller.addMovieDetailView(this);
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_detail, container, false);

        moviePoster = (ImageView)view.findViewById(R.id.moviePoster);
        movieBackdrop = (ImageView)view.findViewById(R.id.movieBackdrop);
        movieTitle = (TextView)view.findViewById(R.id.movieTitle);
        movieReleaseDate = (TextView)view.findViewById(R.id.movieReleaseDate);
        movieRating = (TextView)view.findViewById(R.id.movieRating);
        voteCount = (TextView)view.findViewById(R.id.voteCount);
        movieGenres = (TextView)view.findViewById(R.id.movieGenres);
        movieOverview = (TextView)view.findViewById(R.id.movieOverview);
        movieRuntime = (TextView)view.findViewById(R.id.movieRuntime);

        return view;
    }

    public static MovieDetailFragment newInstance(int movieId){
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putInt(MovieViewFragment.MOVIE_ID_KEY, movieId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void displayMovie(Movie movie){
        Picasso.with(getContext()).load(movie.getMainPoster().getUrl(154,0)).error(R.drawable.ic_error_black_24dp).into(moviePoster);
        Picasso.with(getContext()).load(movie.getMainBackdrop().getUrl(300,0)).error(R.drawable.ic_error_black_24dp).into(movieBackdrop);
        movieTitle.setText(movie.getTitle());
        movieReleaseDate.setText(Utils.getYearFromDate(movie.getReleaseDate()));
        movieRating.setText(getResources().getString(R.string.movie_rate_label) + ": " + Utils.formatVoteAverage(movie.getVoteAverage()));
        voteCount.setText(getResources().getString(R.string.movie_vote_count_label) + ": " + Integer.toString(movie.getVoteCount()));
        movieGenres.setText(Utils.printableGenresFromList(movie.getGenres()));
        movieOverview.setText(movie.getOverview());
        movieRuntime.setText(movie.getRuntime() + " m");
    }

}
