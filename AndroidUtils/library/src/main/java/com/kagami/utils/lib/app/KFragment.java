package com.kagami.utils.lib.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kagami on 15/8/6.
 */
public abstract class KFragment extends Fragment {
    //private static final String ARGS_LAYOUT_RID="_ARGS_LAYOUT_RID";

    public KFragment(){
        super();
    }
//    public KFragment createFragmentWithLayout(int layoutid){
//        KFragment ret=new KFragment();
//        Bundle args=new Bundle();
//        args.putInt(ARGS_LAYOUT_RID, layoutid);
//        ret.setArguments(args);
//        return ret;
//    }
    abstract protected int getLayout();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
//        view.re
        return view;
    }
}
