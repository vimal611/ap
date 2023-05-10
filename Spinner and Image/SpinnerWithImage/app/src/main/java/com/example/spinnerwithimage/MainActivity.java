package com.example.spinnerwithimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Spinner spinner;
    public ImageView imageView;
    public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner) findViewById(R.id.select_language);
        imageView=(ImageView) findViewById(R.id.language_image);
        textView=(TextView) findViewById(R.id.language_description);

        //creating listener for spinner items
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage=String.valueOf(spinner.getSelectedItem());
                if(selectedLanguage.equals("C++")) {
                    imageView.setImageDrawable(getDrawable(R.drawable.cplusplus));
                    textView.setText(R.string.cpp_desc);
                } else if(selectedLanguage.equals("Java")) {
                    imageView.setImageDrawable(getDrawable(R.drawable.java));
                    textView.setText(R.string.java_desc);
                } else if(selectedLanguage.equals("Python")) {
                    imageView.setImageDrawable(getDrawable(R.drawable.python));
                    textView.setText(R.string.python_desc);
                } else if(selectedLanguage.equals("Javascript")) {
                    imageView.setImageDrawable(getDrawable(R.drawable.javascript));
                    textView.setText(R.string.javascript_desc);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}