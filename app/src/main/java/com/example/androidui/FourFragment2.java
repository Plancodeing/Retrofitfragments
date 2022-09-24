package com.example.androidui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.awt.font.TextAttribute;


public class FourFragment2 extends Fragment {
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_four2, container, false);
        tv = v.findViewById(R.id.tv3);
        Bundle bundle = this.getArguments();
        String data = bundle.getString("keey");
        tv.setText(data);
        return v;
    }
}