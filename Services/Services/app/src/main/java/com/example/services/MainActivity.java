package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button start_button, stop_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button=(Button)findViewById(R.id.start_service);
        stop_button=(Button)findViewById(R.id.stop_service);

        Intent intent=new Intent(this, BackgroundMusicService.class);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
                Toast.makeText(getApplicationContext(),"Service started", Toast.LENGTH_SHORT).show();
            }
        });

        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
                Toast.makeText(getApplicationContext(),"Service stopped", Toast.LENGTH_SHORT).show();
            }
        });
    }
}