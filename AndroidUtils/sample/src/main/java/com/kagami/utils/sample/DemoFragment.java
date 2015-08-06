package com.kagami.utils.sample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kagami.utils.lib.app.KFragment;

/**
 * Created by kagami on 15/8/6.
 */
public class DemoFragment extends KFragment {
    @Override
    protected int getLayout() {
        return R.layout.fragment;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("DemoFragment", "onViewCreated");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("DemoFragment","onViewStateRestored");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("DemoFragment", "onSaveInstanceState");
    }
}
