package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class LinearLayout_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        Toast toast= Toast.makeText(getApplicationContext(), "This is linear layout", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickNextLinear(View view) {
        Intent intent=new Intent(this, GridLayout_Activity.class);
        startActivity(intent);
    }
}