package com.example.cat_airplane;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "BaggageDB.db";

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Baggage(mID integer primary key autoincrement, name VARCHAR(20), result VARCHAR(600));";
        db.execSQL(sql);

        db.execSQL("INSERT INTO Baggage VALUES(1, '음료수', '~~~~~~설명~~~~~')");
        db.execSQL("INSERT INTO Baggage VALUES(2, '충전기', '~~~~~~설명~~~~~')");
        db.execSQL("INSERT INTO Baggage VALUES(3, '음식물', '~~~~~~설명~~~~~')");
        db.execSQL("INSERT INTO Baggage VALUES(4, '지팡이', '~~~~~~설명~~~~~')");
        db.execSQL("INSERT INTO Baggage VALUES(5, '의약품', '~~~~~~설명~~~~~')");
        db.execSQL("INSERT INTO Baggage VALUES(6, '라이터', '~~~~~~설명~~~~~')");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Baggage";
        db.execSQL(sql);
        onCreate(db);
    }
}
