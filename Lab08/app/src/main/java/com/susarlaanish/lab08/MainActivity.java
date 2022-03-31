package com.susarlaanish.lab08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    AppCompatImageView image;
    AnimatedVectorDrawable animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image_animate);
        animation = (AnimatedVectorDrawable) image.getDrawable();
        animation.start();
    }
}