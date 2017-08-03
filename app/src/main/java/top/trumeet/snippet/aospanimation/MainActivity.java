package top.trumeet.snippet.aospanimation;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatImageView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

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
        final AppCompatImageView fingerprintIsolated = findViewById(R.id.fingerprint_animator);
        mFingerprintAnimator = new LoopAnimatedVectorDrawableCompat(AnimatedVectorDrawableCompat.create(this,
                R.drawable.enrollment_fingerprint_isolated_animation));

        fingerprintIsolated.setBackgroundDrawable(AppCompatResources.getDrawable(MainActivity.this
                , top.trumeet.snippet.aospanimation.library.R.drawable.fp_illustration_enrollment));
        fingerprintIsolated.setSupportBackgroundTintList(ColorStateList.valueOf(getResources().getColor(top.trumeet.snippet.aospanimation.library.R.color.fingerprint_indicator_background_resting)));

        CheckBox showBackground = findViewById(R.id.check_show_background);
        showBackground.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    fingerprintIsolated.setBackgroundDrawable(AppCompatResources.getDrawable(MainActivity.this
                            , top.trumeet.snippet.aospanimation.library.R.drawable.fp_illustration_enrollment));
                    fingerprintIsolated.setSupportBackgroundTintList(ColorStateList.valueOf(getResources().getColor(top.trumeet.snippet.aospanimation.library.R.color.fingerprint_indicator_background_resting)));
                } else {
                    fingerprintIsolated.setBackgroundDrawable(null);
                }
            }
        });

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
