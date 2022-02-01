package com.susarlaanish.buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button myButton1;
    Button myButton2;
    TextView greetings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout relativeLayout;
        myButton1 = findViewById(R.id.bt1);
        myButton2 = findViewById(R.id.bt2);
        greetings = findViewById(R.id.text_greetings);
        relativeLayout = findViewById(R.id.relLay);

        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                relativeLayout.setBackgroundResource(R.color.teal_200);
            }
        });

        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                relativeLayout.setBackgroundResource(R.color.purple_200);
            }
        });
    }
}