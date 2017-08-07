package top.trumeet.snippet.aospanimation;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Trumeet on 2017/8/7.
 * A abstract activity, include "Start" and "Stop" animation menu
 */

public abstract class ViewAnimationActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        menu.add(0, 0, 0, getStartText())
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, 1, 0, getStopText())
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case 0 :
                startAnimation();
                return true;
            case 1 :
                stopAnimation();
                return true;
        }
        return false;
    }

    public abstract void startAnimation();
    public abstract void stopAnimation();

    public CharSequence getStartText () {
        return "Start";
    }

    public CharSequence getStopText () {
        return "Stop";
    }
}
