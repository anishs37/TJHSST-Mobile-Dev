package com.susarlaanish.sprite09;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Sprite extends RectF {
    private int dX, dY, color;
    public Sprite(float left, float top, float right, float bottom, int dX, int dY, int color) {
        super(left, top, right, bottom);
        this.dX=dX;
        this.dY=dY;
        this.color=color;
    }

    public Sprite(float left, float top, float right, float bottom) {
        this(left, top, right, bottom, 1, 2, Color.MAGENTA);
    }

    public Sprite(int dX, int dY, int color) {
        this(1,1,110,110,dX,dY,color);
    }

    public Sprite() {
        this(2,4,Color.GREEN);
    }

    public void update(Canvas canvas) {
        if(right>= getScreenWidth())dX*=-1;
        if(bottom>=canvas.getHeight())dY*=-1;
        if(top<=0)dY*=-1;
        if(left<=0)dX*=-1;
        offset(dX, dY);

    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle(centerX(),centerY(),width()/2,paint);
    }

    public int getdX() {
        return dX;
    }

    public void setdX(int dX) {
        this.dX = dX;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
