package com.example.databasehandling;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText rollno, name;
    private Button insertbtn, updatebtn, deletebtn, querybtn;
    private TextView roll_dataView, name_dataView;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollno=(EditText) findViewById(R.id.idRollno);
        name=(EditText) findViewById(R.id.idName);
        insertbtn=(Button) findViewById(R.id.insertData);
        updatebtn=(Button) findViewById(R.id.updateData);
        deletebtn=(Button) findViewById(R.id.deleteData);
        querybtn=(Button) findViewById(R.id.showData);

        roll_dataView=(TextView) findViewById(R.id.displayRollno);
        name_dataView=(TextView) findViewById(R.id.displayName);

        dbHandler=new DBHandler(MainActivity.this);

        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stu_roll=rollno.getText().toString();
                String stu_name=name.getText().toString();

                if(stu_roll.isEmpty() || stu_name.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHandler.addData(stu_roll,stu_name);
                    Toast.makeText(getApplicationContext(),"Details added", Toast.LENGTH_SHORT).show();
                    rollno.setText("");
                    name.setText("");
                }
            }
        });

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stu_roll=rollno.getText().toString();
                String stu_name=name.getText().toString();

                if(stu_roll.isEmpty() || stu_name.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHandler.updateStudentName(stu_roll,stu_name);
                    Toast.makeText(getApplicationContext(),"Details updated", Toast.LENGTH_SHORT).show();
                    rollno.setText("");
                    name.setText("");
                }
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stu_roll=rollno.getText().toString();
                if(stu_roll.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter rollno to delete", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHandler.deleteRecord(stu_roll);
                    Toast.makeText(getApplicationContext(),"Record deleted", Toast.LENGTH_SHORT).show();
                    rollno.setText("");
                    name.setText("");
                }
            }
        });


        querybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    SQLiteOpenHelper dBHandlerHelper = new DBHandler(getApplicationContext());
                    SQLiteDatabase db = dBHandlerHelper.getReadableDatabase();
                    Cursor cursor=db.query(DBHandler.TABLE_NAME,new String[]{"id","ROLL_NO","NAME"}, null, null, null, null, null);
                    cursor.moveToFirst();
                    String rollno_text="";
                    String name_text="";
                    do {
                        rollno_text+=cursor.getString(1) + "\n";
                        name_text+=cursor.getString(2) + "\n";
                    } while(cursor.move(1));

                    roll_dataView.setText(rollno_text);
                    name_dataView.setText(name_text);
                    Toast.makeText(getApplicationContext(),"Table contents displayed", Toast.LENGTH_SHORT).show();

                    cursor.close();
                    db.close();
                }catch(Exception e) {
                    Toast.makeText(getApplicationContext(),"Database unavailable", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}