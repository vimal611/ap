package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class GridLayout_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        Toast toast= Toast.makeText(getApplicationContext(), "This is grid layout", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void onCLickNextGrid(View view) {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}