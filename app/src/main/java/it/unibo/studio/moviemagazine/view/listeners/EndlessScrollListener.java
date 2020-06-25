package it.unibo.studio.moviemagazine.view.listeners;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import it.unibo.studio.moviemagazine.controllers.ListController;

/**
 * Simple endless scroll listener that notifies che controller when the last item in the list is visible
 */
public class EndlessScrollListener extends RecyclerView.OnScrollListener{

    private final LinearLayoutManager layoutManager;
    private final ListController controller;
    private final RecyclerView.Adapter adapter;

    public EndlessScrollListener(LinearLayoutManager layoutManager, ListController controller, RecyclerView.Adapter adapter) {
        this.layoutManager = layoutManager;
        this.controller = controller;
        this.adapter = adapter;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (layoutManager.findLastCompletelyVisibleItemPosition() == adapter.getItemCount() - 1){
            controller.commandLoadMore();
        }
    }
}
