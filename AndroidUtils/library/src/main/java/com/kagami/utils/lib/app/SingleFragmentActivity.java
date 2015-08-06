package com.kagami.utils.lib.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.kagami.utils.lib.R;

import java.lang.reflect.Constructor;

/**
 * Created by kagami on 15/8/6.
 */
public class SingleFragmentActivity extends AppCompatActivity {
    private final static String FRAGMENT_NAME="_fragment_name";
    private final static String FRAGMENT_TITLE="_fragment_title";
    private final static String FRAGMENT_ARGS="_fragment_args";
    private final static String FRAGMENT_TAG="_fragment_tag";

    public static void startFragment(Activity activity,Class<?> clazz,String title,Bundle args){
        Intent i=new Intent(activity,SingleFragmentActivity.class);
        i.putExtra(FRAGMENT_NAME,clazz.getName());
        i.putExtra(FRAGMENT_TITLE,title);
        if(args!=null)
            i.putExtra(FRAGMENT_ARGS,args);
        activity.startActivity(i);
    }
    public static void startFragment(Activity activity,Class<?> clazz,String title){
        startFragment(activity,clazz,title,null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(savedInstanceState!=null)
            return;
        try {
            Class<?> c = Class.forName(getIntent().getStringExtra(FRAGMENT_NAME));
                Constructor<?> cons = c.getConstructor();
                Fragment object = (Fragment) cons.newInstance();
            Bundle args = getIntent().getBundleExtra(FRAGMENT_ARGS);
                if (args != null)
                    object.setArguments(args);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, object,FRAGMENT_TAG).commit();
                getSupportActionBar().setTitle(getIntent().getStringExtra(FRAGMENT_TITLE));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

    }


    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_, menu);
//        return true;
//    }
//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
