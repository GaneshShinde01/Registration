package com.example.registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.registration.Model.StudentModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static String DBName = "StudentInfo";
    private static int DBVersion = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table students" +
                "(id integer primary key autoincrement," +
                "fname text," +
                "lname text," +
                "mail text," +
                "gender text," +
                "dob text," +
                "password text )"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists students");
        onCreate(db);
    }

    public boolean insertStudent(String fname, String lname, String mail, String gender, String dob,String password ){

        SQLiteDatabase database =getReadableDatabase();
        ContentValues values =new ContentValues();

        values.put("fname",fname);
        values.put("lname",lname);
        values.put("mail",mail);
        values.put("gender",gender);
        values.put("dob",dob);
        values.put("password",password);

        long rowCount = database.insert("students",null,values);

        if (rowCount <= 0){
            return false;
        }
        else {
            return true;
        }
    }

    public ArrayList<StudentModel> getStudents(){

        ArrayList<StudentModel> arrayList =new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from students",null);

        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){

                StudentModel studentModel = new StudentModel();
                studentModel.setFname(cursor.getString(1));
                studentModel.setLname(cursor.getString(2));
                studentModel.setMail(cursor.getString(3));
                studentModel.setGender(cursor.getString(4));
                studentModel.setDob(cursor.getString(5));
                studentModel.setPassword(cursor.getString(6));

                arrayList.add(studentModel);
            }
        }

        cursor.close();
        database.close();

        return arrayList;

    }

    public Cursor getStudentById(int id){

        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from students where id = "+id,null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        return cursor;
    }

    public boolean updateStudent(int id, String fname, String lname, String mail, String gender, String dob,String password ) {

        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put("fname",fname);
        values.put("lname",lname);
        values.put("mail",mail);
        values.put("gender",gender);
        values.put("dob",dob);
        values.put("password",password);

        long row = database.update("students",values,"id="+id,null);


        if(row <= 0){
            return false;
        }else {
            return true;
        }
    }

    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();

        return database.delete("students","id="+id,null);
    }

}
