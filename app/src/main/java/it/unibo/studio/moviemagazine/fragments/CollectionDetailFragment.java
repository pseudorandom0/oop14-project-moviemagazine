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
import it.unibo.studio.moviemagazine.controllers.ICollectionDetailController;
import it.unibo.studio.moviemagazine.model.interfaces.MovieCollection;
import it.unibo.studio.moviemagazine.model.interfaces.MovieList;
import it.unibo.studio.moviemagazine.view.CollectionDetailView;

/**
 *
 */
public class CollectionDetailFragment extends BaseFragment implements CollectionDetailView{

    private ICollectionDetailController controller;

    private ImageView collectionPoster, collectionBackdrop;
    private TextView collectionName, collectionOverview;
    private TextView listAuthor;

    public static CollectionDetailFragment createWithController(ICollectionDetailController controller){
        CollectionDetailFragment fragment = new CollectionDetailFragment();
        fragment.controller = controller;
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.controller.addCollectionDetailView(this);
        this.controller.commandLoad();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_collection_detail, container, false);

        collectionBackdrop = (ImageView) view.findViewById(R.id.collectionBackdrop);
        collectionPoster = (ImageView) view.findViewById(R.id.collectionPoster);
        collectionName = (TextView) view.findViewById(R.id.collectionName);
        collectionOverview = (TextView) view.findViewById(R.id.collectionOverview);

        listAuthor = (TextView) view.findViewById(R.id.listAuthor);

        return view;
    }

    @Override
    public void displayCollection(MovieCollection collection) {
        displayData(collection.getMainPoster().getUrl(154,0), collection.getMainBackdrop().getUrl(300,0), collection.getName(), collection.getOverview(), null);
    }

    private void displayData(String posterUrl, String backdropUrl, String name, String overview, @Nullable String author){
        Picasso.with(getContext()).load(posterUrl).error(R.drawable.ic_error_black_24dp).into(collectionPoster);
        if(backdropUrl == null || backdropUrl.isEmpty()){
            collectionBackdrop.setVisibility(View.GONE);
        } else {
            Picasso.with(getContext()).load(backdropUrl).error(R.drawable.ic_error_black_24dp).into(collectionBackdrop);
        }
        if(author == null){
            listAuthor.setVisibility(View.GONE);
        } else {
            String content = getString(R.string.created_by) + author;
            listAuthor.setText(content);
        }
        collectionName.setText(name);
        collectionOverview.setText(overview);
    }

    @Override
    public void displayList(MovieList movieList) {
        displayData(movieList.getPoster().getUrl(154,0), null, movieList.getName(), movieList.getDescription(), movieList.getAuthor());
    }
}
