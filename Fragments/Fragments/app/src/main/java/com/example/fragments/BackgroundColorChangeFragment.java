package com.example.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class BackgroundColorChangeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_background_color_change, container, false);
        Button btn=(Button) view.findViewById(R.id.button_background_color);
        Spinner spinner=(Spinner) view.findViewById(R.id.spinner_background_colors);
        LinearLayout linearLayout=(LinearLayout) view.findViewById(R.id.linear_layout_background_color);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected=String.valueOf(spinner.getSelectedItem());

                if(selected.equals("Red")) {
                    linearLayout.setBackgroundColor(Color.RED);
                } else if(selected.equals("Blue")) {
                    linearLayout.setBackgroundColor(Color.BLUE);
                } else if(selected.equals("Green")) {
                    linearLayout.setBackgroundColor(Color.GREEN);
                } else if(selected.equals("Yellow")) {
                    linearLayout.setBackgroundColor(Color.YELLOW);
                }
                Toast.makeText(getContext(), "Fragment 1 background color changed", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}