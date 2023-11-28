package com.example.runappstor.Adapter;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class IteamSuportStoryActivity extends RecyclerView.ItemDecoration {
    private Paint dividerPaint;

    public IteamSuportStoryActivity(Context context) {
        dividerPaint = new Paint();
        dividerPaint.setColor(Color.GRAY);
        dividerPaint.setStyle(Paint.Style.STROKE);
        dividerPaint.setStrokeWidth(1);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(1, 0, 0, 0); // Đặt khoảng cách và độ dày đường kẻ cho mỗi item
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            float left = child.getLeft();
            float top = child.getTop();
            float right = child.getRight();
            float bottom = child.getBottom();

            // Vẽ đường kẻ bên phải và dưới của mỗi item
            canvas.drawLine(right, top, right, bottom, dividerPaint);
            canvas.drawLine(left, bottom, right, bottom, dividerPaint);
        }
    }
}

