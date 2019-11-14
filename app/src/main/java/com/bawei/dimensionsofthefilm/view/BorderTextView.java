package com.bawei.dimensionsofthefilm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class BorderTextView  extends TextView {
    public BorderTextView(Context context) {
        super(context);
    }

    public BorderTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
     private  int sroke_width =1;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint =  new Paint();


         paint.setColor(Color.BLACK);

          canvas.drawLine(0,0,this.getWidth() - sroke_width,0,paint);
          canvas.drawLine(0,0,0,this.getHeight() - sroke_width,paint);
          canvas.drawLine(this.getWidth() - sroke_width,0,this.getWidth() - sroke_width,this.getHeight() - sroke_width,paint);
          canvas.drawLine(0,this.getHeight() - sroke_width,this.getWidth() - sroke_width,this.getHeight() - sroke_width,paint);
          super.onDraw(canvas);

    }
}
