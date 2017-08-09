package com.oridway.oridcore.widge;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.oridway.oridcore.utils.LogUtil;

/**
 * Created by lihao on 2017/8/8.
 */

public class CollapseLayout extends LinearLayout {

    private static final float COLLAPSE_RATIO = 0.5f;

    private int layoutHeight = 0;

    private int curHeight = 0;

    private boolean interceptTouch;

    private View viewTop;
    private View viewBottom;

    private int topTop, topBottom, bottomTop, bottomBottom;

    private boolean canCollapse = false;

    public CollapseLayout(Context context) {
        this(context, null);
    }

    public CollapseLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LogUtil.debugLog("初始化");
        post(new Runnable() {
            @Override
            public void run() {
                layoutHeight = getHeight();
                curHeight = layoutHeight;
                viewTop = getChildAt(0);
                viewBottom = getChildAt(1);
                topTop = viewTop.getTop();
                topBottom = viewTop.getBottom();
                bottomTop = viewBottom.getTop();
                bottomBottom = viewBottom.getBottom();
            }
        });
    }

    public int getWidgeHeight() {
        return layoutHeight;
    }

    public void changeWidgeHeight(int firstViewY) {
        if (canCollapse) {
            float changedHeight = curHeight - firstViewY * COLLAPSE_RATIO;
            if (changedHeight <= 0) {
                changedHeight = 0;
                setVisibility(View.GONE);
                interceptTouch = true;
                setAlpha(0.1f);
            } else if (changedHeight >= layoutHeight) {
                changedHeight = layoutHeight;
                setVisibility(View.VISIBLE);
                setAlpha(1f);
                ViewGroup.LayoutParams params = getLayoutParams();
                params.height = (int) changedHeight;
                setLayoutParams(params);
                interceptTouch = false;
                requestLayout();
            } else {

                setAlpha(Math.max(0.1f, changedHeight * changedHeight / layoutHeight / layoutHeight));
                setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams params = getLayoutParams();
                params.height = (int) changedHeight;
                setLayoutParams(params);
                LogUtil.debugLog("getTop:" + viewBottom.getTop() + "; getBottom:" + viewBottom.getBottom());
                interceptTouch = true;
                scrollTo(0, (int) (0.2 * (layoutHeight - changedHeight)));

            }
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return interceptTouch;
    }

    public void setCollapseEnable() {
        canCollapse = true;
    }
}
