package it.unibo.studio.moviemagazine.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.model.interfaces.Credit;
import it.unibo.studio.moviemagazine.view.listeners.OnPersonClickListener;

/**
 * Adapter for a movie credit (displays persons)
 */
class MovieCreditAdapter extends AbstractCreditAdapter<MovieCreditAdapter.ViewHolder>{

    private final OnPersonClickListener listener;

    /**
     * Creates a new adapter with a listener to notify when the user clicks on a person
     * @param listener the listener to notify
     */
    public MovieCreditAdapter(OnPersonClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MovieCreditAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_credits_list_item, parent, false);
        MovieCreditAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Credit credit = credits.get(position);
        holder.bind(credit, listener);
    }

    /**
     * Extension of base {@link it.unibo.studio.moviemagazine.adapters.AbstractCreditAdapter.ViewHolder}
     */
    static class ViewHolder extends AbstractCreditAdapter.ViewHolder{
        final View container;
        final ImageView personProfile;
        final TextView personName;

        public ViewHolder(View itemView) {
            //call to super is required to initialize the role text view in super class
            super(itemView, R.id.personRole);
            container = itemView;
            personName = (TextView)itemView.findViewById(R.id.personName);
            personProfile = (ImageView) itemView.findViewById(R.id.personProfile);
        }

        /**
         * Binds a credit to a listener to notify when the user clicks on a person
         * @param credit credit to bind to a listener and the views
         * @param listener listener to bind to view container click
         */
        public void bind(final Credit credit, final OnPersonClickListener listener){
            //call to super for binding the role TextView, otherwise it will not be displayed
            super.bind(credit);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPersonClick(credit.getPerson());
                }
            });
            personName.setText(credit.getPerson().getName());
            Picasso.with(container.getContext()).load(credit.getPerson().getProfileImage().getUrl(45,0)).error(R.drawable.ic_error_black_24dp).into(personProfile);
        }

    }
}
