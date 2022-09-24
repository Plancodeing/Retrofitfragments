package com.example.androidui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Button sb;
    FrameLayout frameLayout;


  FloatingActionButton firstfragment,secondfragment,ThirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
ThirdFragment = findViewById(R.id.ThirdFragment);

        frameLayout = findViewById(R.id.frameLayout);
        firstfragment = findViewById(R.id.firstfragment);
        secondfragment = findViewById(R.id.secondfragment);

        firstfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 replace(new FirstFragment());
            }


        });
        secondfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replace(new SecondFragment());
            }
        });
        ThirdFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace(new BlankFragment());
            }
        });



    }
    private void replace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment).commit();

    }


    }


