package com.susarlaanish.lab09;

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
    int lcc = 0;
    int lcc1 = 0;

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

                if(lcc == 0) {
                    layout.setBackgroundResource(R.color.teal_700);
                    btBL.setBackgroundResource(R.color.teal_700);
                    btBR.setBackgroundResource(R.color.teal_700);
                    tvTL.setBackgroundResource(R.color.teal_700);
                    tvTR.setBackgroundResource(R.color.teal_700);
                    lcc = 1;
                }

                else if(lcc == 1){
                    layout.setBackgroundResource(R.color.purple_200);
                    btBL.setBackgroundResource(R.color.purple_200);
                    btBR.setBackgroundResource(R.color.purple_200);
                    tvTL.setBackgroundResource(R.color.purple_200);
                    tvTR.setBackgroundResource(R.color.purple_200);
                    lcc = 2;
                }

                else if(lcc == 2){
                    layout.setBackgroundResource(R.color.purple_500);
                    btBL.setBackgroundResource(R.color.purple_500);
                    btBR.setBackgroundResource(R.color.purple_500);
                    tvTL.setBackgroundResource(R.color.purple_500);
                    tvTR.setBackgroundResource(R.color.purple_500);
                    lcc = 3;
                }

                else if(lcc == 3){
                    layout.setBackgroundResource(R.color.purple_700);
                    btBL.setBackgroundResource(R.color.purple_700);
                    btBR.setBackgroundResource(R.color.purple_700);
                    tvTL.setBackgroundResource(R.color.purple_700);
                    tvTR.setBackgroundResource(R.color.purple_700);
                    lcc = 4;
                }

                else if(lcc == 4){
                    layout.setBackgroundResource(R.color.white);
                    btBL.setBackgroundResource(R.color.white);
                    btBR.setBackgroundResource(R.color.white);
                    tvTL.setBackgroundResource(R.color.white);
                    tvTR.setBackgroundResource(R.color.white);
                    lcc = 0;
                }

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

        if(lcc1 == 0) {
            v1.setBackgroundResource(R.color.teal_700);
            lcc1 = 1;
        }

        else if(lcc1 == 1){
            v1.setBackgroundResource(R.color.purple_200);
            lcc1 = 2;
        }

        else if(lcc1 == 2){
            v1.setBackgroundResource(R.color.purple_500);
            lcc1 = 3;
        }

        else if(lcc1 == 3){
            v1.setBackgroundResource(R.color.purple_700);
            lcc1 = 4;
        }

        else if(lcc1 == 4){
            v1.setBackgroundResource(R.color.white);
            lcc1 = 0;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setInitVals();
    }
}