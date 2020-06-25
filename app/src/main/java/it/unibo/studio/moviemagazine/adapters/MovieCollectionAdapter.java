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
import it.unibo.studio.moviemagazine.model.interfaces.MovieCollection;
import it.unibo.studio.moviemagazine.view.listeners.OnCollectionClickListener;

/**
 * Adapter for a {@code List<MovieCollection>}
 */
public class MovieCollectionAdapter extends AbstractListAdapter<MovieCollectionAdapter.ViewHolder> {


    private List<MovieCollection> collections;
    private final OnCollectionClickListener listener;

    public MovieCollectionAdapter(OnCollectionClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_collection_list_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    /**
     * Sets the model list to display
     * @param collections the list to display
     */
    public void setCollections(List<MovieCollection> collections) {
        this.collections = collections;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(collections.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return collections != null? collections.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        final View container;
        final ImageView collectionPoster;
        final TextView collectionName;

        public ViewHolder(View itemView) {
            super(itemView);
            container = itemView;
            collectionPoster = (ImageView) itemView.findViewById(R.id.collectionPoster);
            collectionName = (TextView) itemView.findViewById(R.id.collectionName);
        }

        /**
         * Binds a {@code MovieCollection} to a listener to notify on container click
         * @param collection the collection to bind
         * @param listener the listener to notify
         */
        public void bind(final MovieCollection collection, final OnCollectionClickListener listener){
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onCollectionClick(collection);
                }
            });
            Picasso.with(container.getContext()).load(collection.getMainPoster().getUrl(92,0)).error(R.drawable.ic_error_black_24dp).into(collectionPoster);
            collectionName.setText(collection.getName());
        }
    }
}
