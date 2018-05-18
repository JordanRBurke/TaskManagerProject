package com.jordanburke.taskmanagerproject;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ActionProvider;


public class MaterialShapeDrawable extends Drawable {

    private ColorFilter colorFilter;



    @Override
    public void draw(@NonNull Canvas canvas) {


        setColorFilter(colorFilter);
        setBounds(5, 5, 5, 5);


    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
