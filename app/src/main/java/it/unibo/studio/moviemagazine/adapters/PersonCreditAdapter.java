package it.unibo.studio.moviemagazine.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.model.interfaces.Credit;
import it.unibo.studio.moviemagazine.view.listeners.OnMovieClickListener;

/**
 * Adapter for a person credit (displays movies)
 */
class PersonCreditAdapter extends AbstractCreditAdapter<PersonCreditAdapter.ViewHolder>{

    private final OnMovieClickListener listener;

    /**
     * Creates a new adapter with a listener to notify on click on a movie
     * @param listener the listener to notify
     */
    public PersonCreditAdapter(OnMovieClickListener listener) {
        this.listener = listener;
    }

    @Override
    public PersonCreditAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_credits_list_item, parent, false);
        PersonCreditAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Credit credit = credits.get(position);
        holder.bind(credit, listener);
    }

    /**
     * Subclass of the base {@link it.unibo.studio.moviemagazine.adapters.AbstractCreditAdapter.ViewHolder}
     */
    static class ViewHolder extends AbstractCreditAdapter.ViewHolder{

        final View container;
        final ImageView moviePoster;
        final TextView title;

        public ViewHolder(View itemView) {
            //super here is required too because the base view holder needs to initialize the role text view
            super(itemView, R.id.role);
            container = itemView;
            title = (TextView) itemView.findViewById(R.id.Title);
            moviePoster = (ImageView) itemView.findViewById(R.id.poster);
        }

        /**
         * Binds a credit to listener to notify on container click
         * @param credit the credit to bind
         * @param listener the listener to notify
         */
        public void bind(final Credit credit, final OnMovieClickListener listener){
            super.bind(credit);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onMovieClick(credit.getMovie());
                }
            });
            title.setText(credit.getMovie().getTitle());
            Picasso.with(container.getContext()).load(credit.getMovie().getMainPoster().getUrl(92,0)).error(R.drawable.ic_error_black_24dp).into(moviePoster);
        }
    }
}
