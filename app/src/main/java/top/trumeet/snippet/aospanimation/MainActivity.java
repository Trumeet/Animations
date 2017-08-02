package top.trumeet.snippet.aospanimation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import top.trumeet.snippet.aospanimation.library.FingerprintAnimationImageView;

/**
 * Created by Trumeet on 2017/8/2.
 * Demo activity
 */

public class MainActivity extends AppCompatActivity {
    private FingerprintAnimationImageView mFingerprintAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFingerprintAnimator = findViewById(R.id.fingerprint_animator);
    }

    @Override
    public void onStart () {
        super.onStart();
        mFingerprintAnimator.startIconAnimation();
    }

    @Override
    public void onStop () {
        mFingerprintAnimator.stopIconAnimation();
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        menu.add(0, 0, 0, "Start")
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, 1, 0, "Stop")
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case 0 :
                mFingerprintAnimator.startIconAnimation();
                return true;
            case 1 :
                mFingerprintAnimator.stopIconAnimation();
                return true;
        }
        return false;
    }
}
