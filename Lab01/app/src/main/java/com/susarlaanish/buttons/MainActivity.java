package com.susarlaanish.buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button myButton;
    Button myButton1;
    Button myButton2;
    TextView greetings;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = findViewById(R.id.my_button);
        myButton1 = findViewById(R.id.my_button_1);
        myButton2 = findViewById(R.id.my_button_2);
        greetings = findViewById(R.id.text_greetings);
    }

    public void inc(View view){
        count = count + 2;
        System.out.println("incrementing by two: " + count);
        greetings.setText("" +count);
    }

    public void dec(View view){
        count = count - 2;
        System.out.println("decrementing by two: " + count);
        greetings.setText("" + count);
    }

    public void chCol(View view){
        System.out.println("changing color now");
        count = count + 5;
        System.out.println("incrementing by five: " + count);
        greetings.setText("" + count);
    }
}