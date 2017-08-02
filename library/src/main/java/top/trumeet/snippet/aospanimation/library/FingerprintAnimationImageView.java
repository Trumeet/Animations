package top.trumeet.snippet.aospanimation.library;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Trumeet on 2017/8/2.
 * @see <a href="https://github.com/android/platform_packages_apps_settings/blob/master/src/com/android/settings/fingerprint/FingerprintEnrollEnrolling.java" />
 */

public class FingerprintAnimationImageView extends ImageView {
    private AnimatedVectorDrawableCompat mIconAnimationDrawable;
    private boolean mAnimationCancelled;

    public FingerprintAnimationImageView(Context context) {
        super(context);
        init();
    }

    public FingerprintAnimationImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FingerprintAnimationImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init () {
        Drawable background = getResources().getDrawable(R.drawable.fp_illustration_enrollment);
        DrawableCompat.setTintList(background, ColorStateList.valueOf(getResources().getColor(R.color.fingerprint_indicator_background_resting)));
        setBackgroundDrawable(background);
        mIconAnimationDrawable = AnimatedVectorDrawableCompat.create(getContext(),
                R.drawable.enrollment_fingerprint_isolated_animation);
        setImageDrawable(mIconAnimationDrawable);
        mIconAnimationDrawable.registerAnimationCallback(mIconAnimationCallback);
    }

    private final Animatable2Compat.AnimationCallback mIconAnimationCallback =
            new Animatable2Compat.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable d) {
                    if (mAnimationCancelled) {
                        return;
                    }

                    // Start animation after it has ended.
                    post(new Runnable() {
                        @Override
                        public void run() {
                            startIconAnimation();
                        }
                    });
                }
            };

    /**
     * Start animation
     */
    public void startIconAnimation() {
        mAnimationCancelled = false;
        mIconAnimationDrawable.start();
    }

    /**
     * Stop animation, do not forgot it in onStop
     */
    public void stopIconAnimation() {
        mAnimationCancelled = true;
        mIconAnimationDrawable.stop();
    }
}
