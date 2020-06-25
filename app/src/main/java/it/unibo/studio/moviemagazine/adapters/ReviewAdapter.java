package it.unibo.studio.moviemagazine.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.model.interfaces.Review;

/**
 * Adapter for list of reviews. Just a simple adapter.
 */
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder>{

    private List<Review> reviews = new ArrayList<>();

    public ReviewAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_reviews_list_item, parent, false);
        ReviewAdapter.ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(reviews.get(position));
    }

    /**
     * Sets the model list to display
     * @param reviews the reviews to display
     */
    public void setReviews(List<Review> reviews){
        this.reviews = reviews;
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        final View container;
        final TextView reviewAuthor;
        final TextView reviewContent;

        public ViewHolder(View itemView) {
            super(itemView);
            container = itemView;
            reviewAuthor = (TextView) itemView.findViewById(R.id.reviewAuthor);
            reviewContent = (TextView) itemView.findViewById(R.id.reviewContent);
        }

        /**
         * Binds a review to it's views
         * @param review
         */
        public void bind(final Review review){
            reviewAuthor.setText(review.getAuthor());
            reviewContent.setText(review.getContent());
        }
    }
}
