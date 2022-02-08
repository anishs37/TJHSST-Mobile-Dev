package com.susarlaanish.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button submitBt;
    Button incrClass;
    TextView addName;
    TextView viewClass;
    EditText editName;
    int count = 0;
    String[] classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitBt = findViewById(R.id.submit_bt);
        incrClass = findViewById(R.id.incr_bt);
        addName = findViewById(R.id.edit_text);
        viewClass = findViewById(R.id.view_classes);
        editName = findViewById(R.id.input_text);
        classes = getResources().getStringArray(R.array.classes_array);

        submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addName.setText("Hello " + editName.getText().toString() + "!");
            }
        });

        incrClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                viewClass.setText(classes[count++]);
                count %= classes.length;
            }
        });
    }
}