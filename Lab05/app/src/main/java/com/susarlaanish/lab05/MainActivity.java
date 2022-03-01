package com.susarlaanish.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    String TAG = "com.susarlaanish.lab05.sharedpreferences";
    LifecycleData currentRun, lifeTime;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView currentTV, lifetimeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        currentRun = new LifecycleData();
        currentRun.duration="Current Run";

        String lifecycleDataAsString = sharedPreferences.getString("lifetime", "");

        if (lifecycleDataAsString.equals("")){
            lifeTime = new LifecycleData();
            lifeTime.duration = "Lifetime Data";
        } else {
            lifeTime = LifecycleData.parseJSON(lifecycleDataAsString);
        }

        currentTV = findViewById(R.id.current);
        lifetimeTV = findViewById(R.id.lifetime);
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
        displayData();
    }

    private void displayData() {
        currentTV.setText(currentRun.toString());
        lifetimeTV.setText(lifeTime.toString());
    }

    public void storeData(){
        editor.putString("lifetime", lifeTime.toJSON()).apply();
    }

    public void updateCount(String currentEnclosingMethod){
        currentRun.updateEvent(currentEnclosingMethod);
        lifeTime.updateEvent(currentEnclosingMethod);
        displayData();
        storeData();
    }

    private void erase() {
        editor.remove("Values").commit();
    }

    @Override
    protected void onStart(){
        super.onStart();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }

    @Override
    protected void onResume(){
        super.onResume();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }

    @Override
    protected void onPause(){
        super.onPause();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }

    @Override
    protected void onStop(){
        super.onStop();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }
}