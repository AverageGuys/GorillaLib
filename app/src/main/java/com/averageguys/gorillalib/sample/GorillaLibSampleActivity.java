package com.averageguys.gorillalib.sample;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.averageguys.gorillalib.GorillaGeneral;
import com.averageguys.gorillalib.utils.GlobalValues;


public class GorillaLibSampleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorilla_lib_sample);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gorilla_lib_sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, new AboutFragment(), GlobalValues.FRAG_TAG_ABOUT);
            ft.addToBackStack(GlobalValues.FRAG_TAG_MAIN);
            ft.commit();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private final String TAG = "MainFragment";

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_gorilla_lib_sample, container, false);

            Log.i(TAG, "Device OS version: " + GorillaGeneral.getOSVersion());
            Log.i(TAG, "Device ID: " + GorillaGeneral.getDeviceID(getActivity()));
            Log.i(TAG, "Device name manufacturer: " + GorillaGeneral.getDeviceNameModel(false));
            Log.i(TAG, "Device name model: " + GorillaGeneral.getDeviceNameModel(true));
            Log.i(TAG, "Device app version: " + GorillaGeneral.getAppVersion(getActivity()));
            Log.i(TAG, "Device language: " + GorillaGeneral.getLanguage(getActivity()));

            return rootView;
        }
    }
}
