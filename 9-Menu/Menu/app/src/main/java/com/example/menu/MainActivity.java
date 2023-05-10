package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView) findViewById(R.id.text_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.item1) {
            Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
            t.setText("Item 1 Selected");
            return true;
        } else if (itemId == R.id.item2) {
            Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
            t.setText("Item 2 Selected");
            return true;
        } else if (itemId == R.id.item3) {
            Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show();
            t.setText("Item 3 Selected");
            return true;
        } else if (itemId == R.id.item4) {
            Toast.makeText(this, "Item 4", Toast.LENGTH_SHORT).show();
            t.setText("Item 4 Selected");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}