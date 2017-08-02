package top.trumeet.snippet.aospanimation.library.drawables;

import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;

/**
 * Created by Trumeet on 2017/8/2.
 * Wrap android.support.graphics.drawable.AnimatedVectorDrawableCompat,
 * support loop
 * @see AnimatedVectorDrawableCompat
 */

public class LoopAnimatedVectorDrawableCompat {
    private AnimatedVectorDrawableCompat mAnimator;
    private boolean mAnimationCancelled;

    public LoopAnimatedVectorDrawableCompat (AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.mAnimator = animatedVectorDrawableCompat;
        setLoopEnable(true);
    }

    private final Animatable2Compat.AnimationCallback mIconAnimationCallback =
            new Animatable2Compat.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable d) {
                    if (mAnimationCancelled) {
                        return;
                    }

                    startAnimation();
                }
            };

    /**
     * Start animation
     */
    public void startAnimation() {
        mAnimationCancelled = false;
        mAnimator.start();
    }

    /**
     * Stop animation, do not forgot it in onStop
     */
    public void stopAnimation() {
        mAnimationCancelled = true;
        mAnimator.stop();
    }

    /**
     * Enable or Disable loop
     * @param enable enable loop
     */
    public void setLoopEnable (boolean enable) {
        if (enable)
            mAnimator.registerAnimationCallback(mIconAnimationCallback);
        else
            mAnimator.unregisterAnimationCallback(mIconAnimationCallback);
    }

    public AnimatedVectorDrawableCompat getDrawable () {
        return mAnimator;
    }
}
