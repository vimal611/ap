package com.example.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class TextColorChangeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_color_change, container, false);
        Button btn=(Button) view.findViewById(R.id.button_text_color);
        Spinner spinner=(Spinner) view.findViewById(R.id.spinner_text_colors);
        TextView textView=(TextView) view.findViewById(R.id.textChangeColor);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected=String.valueOf(spinner.getSelectedItem());
                if(selected.equals("Red")) {
                    textView.setTextColor(Color.RED);
                } else if(selected.equals("Blue")) {
                    textView.setTextColor(Color.BLUE);
                } else if(selected.equals("Green")) {
                    textView.setTextColor(Color.GREEN);
                } else if(selected.equals("Yellow")) {
                    textView.setTextColor(Color.YELLOW);
                }
                Toast.makeText(getContext(), "Fragment 2 text color changed", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}