package com.example.pc.contactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

//database class that inherits from the sqliteopenhelper class
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String dataBaseName = "ContactDataBase.db";
    private static final String tableName = "ContactInfo";
    //databasehelper constructor
    public DatabaseHelper(Context context) {
        super(context, dataBaseName, null, 1);
    }
    //oncreate database methode
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + tableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Fname TEXT, Lname TEXT, Number TEXT)");
    }
    //onupgrade database methode
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }
    //insert data method
    public boolean insertData(String FirstName, String LastName, String Number ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Fname",FirstName);
        contentValues.put("Lname",LastName);
        contentValues.put("Number",Number);
        long result = db.insert(tableName, null,contentValues);
        if (result == -1)
            return false;
        return true;
    }
    //showing data in the datalist
    public ArrayList<String> GetAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT Fname,Lname,Number FROM ContactInfo";
        Cursor cur = db.rawQuery(query, null);
        ArrayList<String> arraydata = new ArrayList<>();
        while (cur.moveToNext()){
            arraydata.add(cur.getString(0) + " " + cur.getString(1) + " " + cur.getString(2));
        }
        return arraydata;
    }
    //showing the search result in the datalist
    public ArrayList<String> searchData(String search){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT Fname,Lname,Number FROM ContactInfo WHERE Fname LIKE '%" + search + "%' or Lname LIKE '%" + search + "%' or Number LIKE '%" + search +"%'";
        Cursor cur = db.rawQuery(query, null);
        ArrayList<String> arraydata = new ArrayList<>();
        while (cur.moveToNext()){
            arraydata.add(cur.getString(0) + " " + cur.getString(1) + " " + cur.getString(2));
        }
        return arraydata;
    }
}
