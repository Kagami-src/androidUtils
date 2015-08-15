package com.kagami.utils.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kagami.utils.lib.R;
import com.kagami.utils.lib.app.KFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kagami on 15/8/15.
 */
public abstract class BaseSwipeRecyclerViewFragment<T> extends KFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_swiperecyclerview;
    }
    protected List<T> dataSet;
    protected RecyclerView recyclerView;
    protected SwipeRefreshLayout swipeRefreshLayout;
    protected RecyclerView.Adapter privateAdapter;
    protected RecyclerView.LayoutManager layoutManager;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataSet=new ArrayList<>();
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        privateAdapter=onCreateAdapter();
        recyclerView.setAdapter(privateAdapter);
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                BaseSwipeRecyclerViewFragment.this.onRefresh();
            }
        });

    }
    public void setRefreshing(final boolean refreshing){
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(refreshing);
            }
        });
    }
    protected abstract RecyclerView.Adapter onCreateAdapter();
    protected void onRefresh(){};


}
