package it.unibo.studio.moviemagazine.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Credit;
import it.unibo.studio.moviemagazine.view.listeners.OnMovieClickListener;
import it.unibo.studio.moviemagazine.view.listeners.OnPersonClickListener;

/**
 * Base abstract credit adapter that manages the displaying of the role only. The template parameters of RecyclerView
 * are moved to this class to limit force the extension of the base ViewHolder.
 */
public abstract class AbstractCreditAdapter<VH extends AbstractCreditAdapter.ViewHolder> extends RecyclerView.Adapter<VH>{

    protected List<Credit> credits;

    public void setCredits(final List<Credit> credits){
        this.credits = credits;
    }


    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    /**
     * Factory method to create a concrete Credit adapter when the credits displayed are of a {@link it.unibo.studio.moviemagazine.model.interfaces.Movie}
     * @param listener the listener to notify when the user clicks on a credit, in this case the credits displayed are {@code Person}s
     * @return a concrete implementation of this base class {@link MovieCreditAdapter}
     */
    public static AbstractCreditAdapter createAdapter(OnPersonClickListener listener){
        return new MovieCreditAdapter(listener);
    }

    /**
     * Factory method to create a concrete Credit adapter when the credits displayed are of a {@link it.unibo.studio.moviemagazine.model.interfaces.Person}
     * @param listener the listener to notify when the user clicks on a credit, in this case the credits displayed are {@code Movie}s
     * @return a concrete implementation of this base class {@link PersonCreditAdapter}
     */
    public static AbstractCreditAdapter createAdapter(OnMovieClickListener listener){
        return new PersonCreditAdapter(listener);
    }

    @Override
    public abstract void onBindViewHolder(VH holder, int position);

    @Override
    public int getItemCount() {
        return credits != null? credits.size() : -1;
    }

    /**
     * ViewHolder is a pattern used by {@code RecyclerView} to recycle the views and make the scrolling more efficient.
     * This base {@code ViewHolder} holds only the {@code TextView} that will display the role of a person in a movie.
     */
    static abstract class ViewHolder extends RecyclerView.ViewHolder{
        final TextView role;

        /**
         * In order to use different layout files for single rows, in concrete subclasses. It is required to pass the correct id of the TextView
         * @param itemView container already inflated by subclass
         * @param roleId the id of the TextView to use as a role display text view
         */
        public ViewHolder(View itemView, int roleId) {
            super(itemView);
            role = (TextView)itemView.findViewById(roleId);
        }

        /**
         * Actually sets the role of the {@link Credit} to the TextView displaying it
         * @param credit
         */
        public void bind(final Credit credit){
            role.setText(credit.getRole());
        }
    }
}
