package com.oridway.oridcore.widge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.oridway.oridcore.R;

/**
 * Created by lihao on 2017/8/9.
 */

public class CircleHeadView extends View {

    private String firstName = "友";

    private Paint borderPaint;
    private Paint textPaint;

    private int widgeWidth = 120;
    private int widgeHeight = 120;

    private int circleRadius = 60;

    private int bgColor = Color.parseColor("#2196FC");

    public CircleHeadView(Context context) {
        this(context, null);
    }

    public CircleHeadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(60);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setColor(Color.WHITE);

        borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderPaint.setStyle(Paint.Style.FILL);

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                widgeHeight = getHeight();
                widgeWidth = getWidth();
                circleRadius = Math.min(widgeHeight, widgeWidth) / 2;
            }
        });
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        borderPaint.setColor(bgColor);
        canvas.drawCircle(widgeWidth * 0.5f, widgeHeight * 0.5f, circleRadius - 1.0f, borderPaint);
        canvas.drawText(firstName, widgeWidth * 0.5f - 30, widgeHeight * 0.5f + 22, textPaint);
    }

    public void setNameText(String firstName, int onlineStatus) {
        if (firstName != null && firstName.length() != 0) {
            if (firstName.startsWith("I")) {
                this.firstName = firstName.substring(0, 2);
            } else {
                this.firstName = firstName.substring(0, 1);
            }
            if (onlineStatus == 0) {
                bgColor = Color.parseColor("#BEBEBE");
            } else {
                bgColor = Color.parseColor("#2196FC");
            }
            invalidate();
        }
    }
}
