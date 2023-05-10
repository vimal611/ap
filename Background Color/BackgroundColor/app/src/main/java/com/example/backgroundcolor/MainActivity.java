package com.example.backgroundcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);

    }

    public void changeToRed(View v) {
        relativeLayout.setBackgroundColor(getColor(R.color.red)); //added color to colors.xml resource file
        Toast.makeText(getApplicationContext(), "Background color change to red", Toast.LENGTH_SHORT).show();
    }

    public void changeToBlue(View v) {
        relativeLayout.setBackgroundColor(getColor(R.color.blue));
        Toast.makeText(getApplicationContext(), "Background color change to blue", Toast.LENGTH_SHORT).show();
    }

    public void changeToYellow(View v) {
        relativeLayout.setBackgroundColor(getColor(R.color.yellow));
        Toast.makeText(getApplicationContext(), "Background color change to yellow", Toast.LENGTH_SHORT).show();
    }

    public void changeToWhite(View v) {
        relativeLayout.setBackgroundColor(getColor(R.color.white));
        Toast.makeText(getApplicationContext(), "Background color change to white", Toast.LENGTH_SHORT).show();
    }
}