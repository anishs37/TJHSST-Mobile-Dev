package com.susarlaanish.lab04;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int randInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        randInt = randGen();
        System.out.println(randInt);

        if(randInt == 1){
            setContentView(R.layout.layout1);
        }

        if(randInt == 2){
            setContentView(R.layout.layout2);
        }

        if(randInt == 3){
            setContentView(R.layout.layout3);
        }

        if(randInt == 4){
            setContentView(R.layout.layout4);
        }

        if(randInt == 5){
            setContentView(R.layout.layout5);
        }

        if(randInt == 6){
            setContentView(R.layout.layout6);
        }

        if(randInt == 7){
            setContentView(R.layout.layout7);
        }
    }

    private int randGen()
    {
        int rand = (int)(Math.random() * 7) + 1;
        return rand;
    }
}