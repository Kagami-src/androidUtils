package com.kagami.utils.sample;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kagami.utils.fragment.BaseSwipeRecyclerViewFragment;

/**
 * Created by kagami on 15/8/15.
 */
public class SRFragment extends BaseSwipeRecyclerViewFragment<String> {

    @Override
    protected RecyclerView.Adapter onCreateAdapter() {
        return new PrivateAdapter();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataSet.add("");
        dataSet.add("");
        dataSet.add("");
        dataSet.add("");
        dataSet.add("");
        dataSet.add("");
        dataSet.add("");
        dataSet.add("");
        dataSet.add("");
        privateAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onRefresh() {
        dataSet.add("");
        privateAdapter.notifyDataSetChanged();
        setRefreshing(false);
    }

    private class PrivateAdapter extends RecyclerView.Adapter<MyViewHolder>{


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
            TextView tv=new TextView(viewGroup.getContext());
            tv.setText("test"+type);
            return new MyViewHolder(tv);
        }

        @Override
        public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
