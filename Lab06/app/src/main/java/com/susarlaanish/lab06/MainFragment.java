package com.susarlaanish.lab06;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class MainFragment extends Fragment {
    ViewPager2 mViewPager2;
    int position;
    public static Fragment newInstance(ViewPager2 mViewPager2, int position) {
        MainFragment fragment = new MainFragment();
        fragment.mViewPager2 = mViewPager2;
        fragment.position = position;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (position==1){
            view.setBackgroundResource(R.color.purple_200);
        }

        if (position==2){
            view.setBackgroundResource(R.color.teal_200);
        }

        if (position==3){
            view.setBackgroundResource(R.color.teal_700);
        }

        if (position==4){
            view.setBackgroundResource(R.color.black);
        }

        if (position==5){
            view.setBackgroundResource(R.color.purple_700);
        }

        Button button = view.findViewById(R.id.pressme);
        button.setText("Press " + position);
    }
}
