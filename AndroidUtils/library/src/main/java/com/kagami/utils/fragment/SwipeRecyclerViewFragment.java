package com.kagami.utils.fragment;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kagami on 15/8/15.
 */
public abstract class SwipeRecyclerViewFragment<T> extends BaseSwipeRecyclerViewFragment<T> {
    @Override
    protected RecyclerView.Adapter onCreateAdapter() {
        return new PrivateAdapter();
    }
    protected abstract int getItemLayout();
    protected abstract void onBindViewHolder(ViewHolder myViewHolder, int i);
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
    private class PrivateAdapter extends RecyclerView.Adapter<ViewHolder>{


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
            View v= LayoutInflater.from(viewGroup.getContext()).inflate(getItemCount(), viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder myViewHolder, int i) {
            SwipeRecyclerViewFragment.this.onBindViewHolder(myViewHolder,i);
        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }
    }
}
