package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Relative layout

    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast=Toast.makeText(getApplicationContext(), "This is relative layout", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickNextRelative(View v) {
        Spinner spinner=(Spinner) findViewById(R.id.spinner_relativelayout);
        String selected=String.valueOf(spinner.getSelectedItem());
        Intent intent;
        if(selected.equals("Relative Layout")) {
            toast.show();
        } else if (selected.equals("Linear Layout")) {
            intent=new Intent(this, LinearLayout_Activity.class);
            startActivity(intent);
        }
        else {
            intent=new Intent(this, GridLayout_Activity.class);
            startActivity(intent);
        }
    }

}