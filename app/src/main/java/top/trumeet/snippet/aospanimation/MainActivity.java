package top.trumeet.snippet.aospanimation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatImageView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import top.trumeet.snippet.aospanimation.library.drawables.LoopAnimatedVectorDrawableCompat;

/**
 * Created by Trumeet on 2017/8/2.
 * Demo activity
 */

public class MainActivity extends AppCompatActivity {
    private LoopAnimatedVectorDrawableCompat mFingerprintAnimator;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatImageView fingerprintIsolated = findViewById(R.id.fingerprint_animator);
        mFingerprintAnimator = new LoopAnimatedVectorDrawableCompat(AnimatedVectorDrawableCompat.create(this,
                R.drawable.enrollment_fingerprint_isolated_animation));
        fingerprintIsolated.setBackgroundDrawable(AppCompatResources.getDrawable(this, top.trumeet.snippet.aospanimation.library.R.drawable.fp_illustration_enrollment));
        fingerprintIsolated.setSupportBackgroundTintList(ColorStateList.valueOf(getResources().getColor(top.trumeet.snippet.aospanimation.library.R.color.fingerprint_indicator_background_resting)));

        fingerprintIsolated.setImageDrawable(mFingerprintAnimator.getDrawable());
    }

    @Override
    public void onStart () {
        super.onStart();
        mFingerprintAnimator.startAnimation();
    }

    @Override
    public void onStop () {
        mFingerprintAnimator.stopAnimation();
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
                mFingerprintAnimator.startAnimation();
                return true;
            case 1 :
                mFingerprintAnimator.stopAnimation();
                return true;
        }
        return false;
    }
}
