package com.example.travissimple;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.Observable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.QueryObservable;
import com.squareup.sqlbrite.SqlBrite;

import java.util.concurrent.atomic.AtomicInteger;

import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        UsersDatabaseHelper usersDatabaseHelper = new UsersDatabaseHelper(this);
        SqlBrite sqlBrite = SqlBrite.create();
        BriteDatabase briteDatabase = sqlBrite.wrapDatabaseHelper(usersDatabaseHelper, Schedulers.io());

        QueryObservable users = briteDatabase.createQuery("users", "SELECT * FROM users");


//        final AtomicInteger queries = new AtomicInteger();
//        users.subscribe(new Action1<SqlBrite.Query>() {
//            @Override public void call(SqlBrite.Query query) {
//                queries.getAndIncrement();
//            }
//        });

        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersDatabaseHelper.KEY_USER_NAME,"Beto2");

        briteDatabase.insert("users", contentValues);

        users.subscribe(new Action1<SqlBrite.Query>() {
            @Override public void call(SqlBrite.Query query) {
                Cursor cursor = query.run();
                while (cursor.moveToNext()){
                    System.out.println(cursor.getString(cursor.getColumnIndex(UsersDatabaseHelper.KEY_USER_NAME)));
                }
            }
        });

//        System.out.println("Queries: " + queries.get()); // Prints 4
        //Change test
        //Commit test
    }
}
