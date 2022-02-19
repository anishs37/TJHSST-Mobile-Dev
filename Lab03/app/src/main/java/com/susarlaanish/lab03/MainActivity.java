package com.susarlaanish.lab03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String TAG = "com.susarlaanish.lab03.sharedprefs";
    Button btBL, btBR;
    TextView tvTL, tvTR;
    SeekBar skBar;
    TextView[] views;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btBL = findViewById(R.id.botLeft_Button);
        btBR = findViewById(R.id.botRight_Button);
        tvTL = findViewById(R.id.topLeft_textView);
        tvTR = findViewById(R.id.topRight_textView);
        skBar = findViewById(R.id.seekbar);
        layout = findViewById(R.id.activity_main);
        views = new TextView[]{btBL, btBR, tvTL, tvTR};

        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btBL.setOnClickListener(this);
        btBR.setOnClickListener(this);
        tvTL.setOnClickListener(this);
        tvTR.setOnClickListener(this);

        skBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lastProgress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for (TextView x : views) {
                    x.setTextSize(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                lastProgress = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Snackbar snackbar = Snackbar.make(layout, "Font Size Changed To " + skBar.getProgress() + "sp", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        skBar.setProgress(lastProgress);
                        Snackbar.make(layout, "Font Size Reverted to " + lastProgress + "sp", Snackbar.LENGTH_LONG);
                    }
                });
                snackbar.setActionTextColor(Color.CYAN);
                snackbar.show();
            }
        });

        layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editor.clear().apply();
                setInitVals();
                return false;
            }
        });
        setInitVals();
    }

    private void setInitVals(){
        for (TextView x : views) {
            x.setText(sharedPreferences.getString(x.getTag().toString(),"0"));
        }

        skBar.setProgress(15);
    }

    @Override
    public void onClick(View v) {
        TextView v1 = (TextView) v;
        String strText = v1.getText().toString();
        v1.setText("" + (Integer.parseInt(strText) + 1));
        editor.putString(v1.getTag().toString(), v1.getText().toString());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setInitVals();
    }
}