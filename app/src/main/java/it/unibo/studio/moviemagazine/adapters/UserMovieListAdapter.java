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
import it.unibo.studio.moviemagazine.model.interfaces.MovieList;
import it.unibo.studio.moviemagazine.view.listeners.OnListClickListener;

/**
 * Adapter for a {@code List<MovieList>}.
 */
public class UserMovieListAdapter extends AbstractListAdapter<UserMovieListAdapter.ViewHolder> {

    private List<MovieList> lists;
    private final OnListClickListener listener;

    /**
     * Creates a new adapter with a listener to notify on click on a {@link MovieList}
     * @param listener the listener to notify
     */
    public UserMovieListAdapter(OnListClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_movie_list_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(lists.get(position), listener);
    }

    /**
     * Sets the model list to display
     * @param lists the {@code MovieList}s to display
     */
    public void setMovieLists(List<MovieList> lists){
        this.lists = lists;
    }

    @Override
    public int getItemCount() {
        return lists != null? lists.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        final ImageView listPoster;
        final TextView listName,listFavouriteCount,listItemCount, listDescription;
        final View container;

        public ViewHolder(View itemView) {
            super(itemView);
            container = itemView;
            listPoster = (ImageView) itemView.findViewById(R.id.listPoster);
            listName = (TextView) itemView.findViewById(R.id.listName);
            listFavouriteCount = (TextView) itemView.findViewById(R.id.listFavouriteCount);
            listItemCount = (TextView) itemView.findViewById(R.id.listItemCount);
            listDescription = (TextView) itemView.findViewById(R.id.listDescription);
        }

        /**
         * Binds a {@code MovieList} to a listener to notify on click
         * @param list the list to bind
         * @param listener the listener to notify
         */
        public void bind(final MovieList list, final OnListClickListener listener){
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onListClick(list);
                }
            });
            Picasso.with(container.getContext()).load(list.getPoster().getUrl(92,0)).error(R.drawable.ic_error_black_24dp).into(listPoster);
            listName.setText(list.getName());
            listFavouriteCount.setText(Integer.toString(list.getFavouriteCount()));
            listItemCount.setText(Integer.toString(list.getMoviesCount()));
            listDescription.setText(list.getDescription());
        }
    }
}
