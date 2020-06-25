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
import it.unibo.studio.moviemagazine.model.interfaces.Person;
import it.unibo.studio.moviemagazine.view.listeners.OnPersonClickListener;

/**
 *
 */
public class PersonAdapter extends AbstractListAdapter<PersonAdapter.ViewHolder>{

    private List<Person> people;
    private final OnPersonClickListener listener;

    /**
     * Creates a {@code PersonAdapter} with a listener that will be notified on click on a person
     * @param listener
     */
    public PersonAdapter(OnPersonClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(people.get(position), listener);
    }

    /**
     * Sets the model list to display
     * @param people
     */
    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public int getItemCount() {
        return people != null? people.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        final ImageView profile;
        final TextView name;
        final View container;

        public ViewHolder(View itemView) {
            super(itemView);
            container = itemView;
            name = (TextView) itemView.findViewById(R.id.name);
            profile = (ImageView) itemView.findViewById(R.id.profile);
        }

        /**
         * Binds a person to a listener to notify on click
         * @param person person to bind
         * @param listener listener to notify
         */
        public void bind(final Person person, final OnPersonClickListener listener){
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPersonClick(person);
                }
            });
            name.setText(person.getName());
            Picasso.with(container.getContext()).load(person.getProfileImage().getUrl(45,0)).error(R.drawable.ic_error_black_24dp).into(profile);
        }
    }
}
