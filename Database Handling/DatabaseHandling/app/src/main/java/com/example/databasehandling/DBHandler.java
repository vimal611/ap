package com.example.databasehandling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME="students";
    private static final int DB_VERSION=1;
    public static final String TABLE_NAME="StuDetails";
    private static final String ID="id";

    public DBHandler(@Nullable Context context) {
        super(context, TABLE_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE " + TABLE_NAME + " (" + ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + " ROLL_NO TEXT, NAME TEXT)";
        db.execSQL(query);
    }

    public void addData(String rno, String name) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("ROLL_NO", rno);
        values.put("NAME", name);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateStudentName(String rno, String name) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("ROLL_NO", rno);
        values.put("NAME", name);

        db.update(TABLE_NAME, values, "ROLL_NO=?",new String[]{rno});
        db.close();
    }

    public void deleteRecord(String rno) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME, "ROLL_NO=?", new String[]{rno});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
