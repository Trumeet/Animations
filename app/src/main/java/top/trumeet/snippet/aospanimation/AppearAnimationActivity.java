package top.trumeet.snippet.aospanimation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.graphics.drawable.AnimationUtilsCompat;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import top.trumeet.snippet.aospanimation.library.animation.AppearAnimationCreator;
import top.trumeet.snippet.aospanimation.library.animation.AppearAnimationUtils;
import top.trumeet.snippet.aospanimation.library.animation.DisappearAnimationUtils;

/**
 * Created by Trumeet on 2017/8/7.
 * @see top.trumeet.snippet.aospanimation.library.animation.AppearAnimationUtils
 */

public class AppearAnimationActivity extends ViewAnimationActivity implements AppearAnimationCreator<Object> {
    private AppearAnimationUtils mAppearAnimationUtils;
    private DisappearAnimationUtils mDisappearAnimationUtils;

    private View icon_top;
    private TableLayout tableLayout;

    @SuppressLint("RestrictedApi")
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appear);
        icon_top = findViewById(R.id.icon_top);
        tableLayout = findViewById(R.id.table);
        mAppearAnimationUtils = new AppearAnimationUtils(this,
                AppearAnimationUtils.DEFAULT_APPEAR_DURATION, 2f /* translationScale */,
                1.3f /* delayScale */, AnimationUtilsCompat.loadInterpolator(
                this, R.anim.linear_out_slow_in));
        mDisappearAnimationUtils = new DisappearAnimationUtils(this,
                125, 4f /* translationScale */,
                0.3f /* delayScale */, AnimationUtilsCompat.loadInterpolator(
                this, R.anim.fast_out_linear_in),
                new AppearAnimationUtils.RowTranslationScaler() {
                    @Override
                    public float getRowTranslationScale(int row, int numRows) {
                        return (float)(numRows - row) / numRows;
                    }
                });
        startAnimation();
    }

    @Override
    public void startAnimation() {
        mAppearAnimationUtils.startAnimation2d(getViews()
                , null, this);
    }

    @Override
    public void stopAnimation() {
        mDisappearAnimationUtils.startAnimation2d(getViews(),
                new Runnable() {
                    @Override
                    public void run() {
                        /*
                        finish();
                        overridePendingTransition(
                                R.anim.confirm_credential_close_enter,
                                R.anim.confirm_credential_close_exit);
                        */
                    }
                }, this);
    }

    @Override
    public void onBackPressed () {
        mDisappearAnimationUtils.startAnimation2d(getViews(),
                new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        overridePendingTransition(
                                R.anim.confirm_credential_close_enter,
                                R.anim.confirm_credential_close_exit);
                    }
                }, this);
    }

    @Override
    public CharSequence getStartText() {
        return "Appear";
    }

    @Override
    public CharSequence getStopText() {
        return "Disappear";
    }

    private static List<TableRow> getRows (TableLayout table) {
        List<TableRow> list = new ArrayList<>(table.getChildCount());
        for(int i = 0, j = table.getChildCount(); i < j; i++) {
            View view = table.getChildAt(i);
            if (view instanceof TableRow) {
                TableRow row = (TableRow) view;
                list.add(row);
            }
        }
        return list;
    }

    private ArrayList<ArrayList<Object>> getAllChildren() {
        ArrayList<ArrayList<Object>> result = new ArrayList<>();
        result.add(new ArrayList<Object>(Collections.singletonList(icon_top)));
        List<TableRow> list = getRows(tableLayout);
        List<List<View>> radios = new ArrayList<>(list.size() * 5);
        for (TableRow row : list) {
            List<View> views = new ArrayList<>(row.getChildCount());
            for (int i = 0; i < row.getChildCount(); i ++) {
                views.add(row.getChildAt(i));
            }
            radios.add(views);
        }
        for (int i = 0; i < radios.size(); i++) {
            ArrayList<Object> row = new ArrayList<>();
            row.addAll(radios.get(i));
            result.add(row);
        }
        return result;
    }
    private Object[][] getViews () {
        ArrayList<ArrayList<Object>> result = getAllChildren();
        Object[][] resultArr = new Object[result.size()][5];
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Object> row = result.get(i);
            for (int j = 0; j < row.size(); j++) {
                resultArr[i][j] = row.get(j);
            }
        }
        return resultArr;
    }

    @Override
    public void createAnimation(Object obj, long delay, long duration, float translationY, boolean appearing, Interpolator interpolator, Runnable finishListener) {
        mAppearAnimationUtils.createAnimation((View) obj, delay, duration, translationY,
                appearing, interpolator, finishListener);
    }
}
