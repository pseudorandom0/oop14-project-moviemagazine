package it.unibo.studio.moviemagazine.adapters;

import android.support.v7.widget.RecyclerView;

/**
 * Abstract base class for {@link PersonCreditAdapter}, {@link UserMovieListAdapter}, {@link MovieAdapter}, {@link MovieCollectionAdapter}.
 * This class just renames the base class for adapters to make the code clearer in {@link it.unibo.studio.moviemagazine.fragments.SearchFragment}
 */
public abstract class AbstractListAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {


}
