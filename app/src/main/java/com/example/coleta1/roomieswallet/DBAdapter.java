package com.example.coleta1.roomieswallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;



public class DBAdapter {
    public static final String KEY_ID = "id";
    public static final String KEY_DATE = "date";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_PERSON = "person";
    public static final String KEY_PERSON_AMOUNT = "person_amount";
    public static final String KEY_ANJI_AMOUNT = "anji_amount";
    public static final String KEY_KESAV_AMOUNT = "kesav_amount";
    public static final String KEY_TRINADH_AMOUNT = "trinadh_amount";
    public static final String KEY_SUJITH_AMOUNT = "sujith_amount";
    public static final String KEY_VICKY_AMOUNT = "vicky_amount";
    public static final String KEY_CHAKRI_AMOUNT = "chakri_amount";

    private static final String TAG = "DBAdapter";
    private static final String DATABASE_NAME = "RoomieWalletManager";
    private static final String DATABASE_TABLE_ROOMIE_WALLET = "roomiewallet";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_ADD_ROOMIE_WALLET =
            "create table roomiewallet(id integer primary key autoincrement, "
                    + "date text not null," + " description text not null, "
                    + "person text not null,"+ "person_amount text not null," + "anji_amount text not null,"
                    + "kesav_amount text not null,"
                    +"trinadh_amount text not null,"
                    +"sujith_amount text not null,"
                    +"vicky_amount text not null,"
                    +"chakri_amount text not null);";
    public String fieldObjectName = "name";



    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context)

        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_ADD_ROOMIE_WALLET);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {

            Log.w(TAG, "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE_ROOMIE_WALLET);

            onCreate(db);
        }
    }
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;

    }

    public void close() {
        DBHelper.close();


    }

    public void insertItemDetails(RoomieWallet roomieWallet) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_DATE, roomieWallet.getDate());

        initialValues.put(KEY_DESCRIPTION, roomieWallet.getDescription());

        initialValues.put(KEY_PERSON, roomieWallet.getPerson());

        initialValues.put(KEY_PERSON_AMOUNT, roomieWallet.getPerson_amount());

        initialValues.put(KEY_ANJI_AMOUNT, roomieWallet.getAnji_amount());

        initialValues.put(KEY_KESAV_AMOUNT, roomieWallet.getKesav_amount());

        initialValues.put(KEY_TRINADH_AMOUNT, roomieWallet.getTrinadh_amount());

        initialValues.put(KEY_SUJITH_AMOUNT, roomieWallet.getSujith_amount());

        initialValues.put(KEY_VICKY_AMOUNT, roomieWallet.getVicky_amount());

        initialValues.put(KEY_CHAKRI_AMOUNT, roomieWallet.getChakri_amount());


        db.insert(DATABASE_TABLE_ROOMIE_WALLET, null, initialValues);
    }


    public List<RoomieWallet> getAllDetailsByPerson() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_ROOMIE_WALLET;

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setDate(cursor.getString(1));
                roomieWallet.setDescription(cursor.getString(2));
                roomieWallet.setPerson(cursor.getString(3));
                roomieWallet.setPerson_amount(cursor.getString(4));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }
    public List<RoomieWallet> getAllDetailsByAmount() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_ROOMIE_WALLET;

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setDate(cursor.getString(1));
                roomieWallet.setAnji_amount(cursor.getString(5));
                roomieWallet.setKesav_amount(cursor.getString(6));
                roomieWallet.setTrinadh_amount(cursor.getString(7));
                roomieWallet.setSujith_amount(cursor.getString(8));
                roomieWallet.setVicky_amount(cursor.getString(9));
                roomieWallet.setChakri_amount(cursor.getString(10));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }

    public List<RoomieWallet> getAllDetailsByCreditChakri() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET+" WHERE person = 'chakri' ";

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setPerson_amount(cursor.getString(4));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }
    public List<RoomieWallet> getAllDetailsByDebitChakri() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET;

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setChakri_amount(cursor.getString(10));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }

    public List<RoomieWallet> getAllDetailsByCreditAnji() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET+" WHERE person = 'anji' ";

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setPerson_amount(cursor.getString(4));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }
    public List<RoomieWallet> getAllDetailsByDebitAnji() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET;

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setAnji_amount(cursor.getString(5));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }

    public List<RoomieWallet> getAllDetailsByCreditKesav() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET+" WHERE person = 'kesav' ";

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setPerson_amount(cursor.getString(4));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }
    public List<RoomieWallet> getAllDetailsByDebitKesav() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET;

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setKesav_amount(cursor.getString(6));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }
    public List<RoomieWallet> getAllDetailsByCreditTrinadh() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET+" WHERE person = 'trinadh' ";

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setPerson_amount(cursor.getString(4));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }
    public List<RoomieWallet> getAllDetailsByDebitTrinadh() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET;

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setTrinadh_amount(cursor.getString(7));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }
    public List<RoomieWallet> getAllDetailsByCreditSujith() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET+" WHERE person = 'sujith' ";

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setPerson_amount(cursor.getString(4));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }
    public List<RoomieWallet> getAllDetailsByDebitSujith() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET;

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setSujith_amount(cursor.getString(8));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }

    public List<RoomieWallet> getAllDetailsByCreditVicky() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET+" WHERE person = 'vicky' ";

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setPerson_amount(cursor.getString(4));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }
    public List<RoomieWallet> getAllDetailsByDebitVicky() {
        List<RoomieWallet> cardList = new ArrayList<RoomieWallet>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE_ROOMIE_WALLET;

        SQLiteDatabase db = DBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomieWallet roomieWallet = new RoomieWallet();

                roomieWallet.setVicky_amount(cursor.getString(9));

                // Adding contact to list
                cardList.add(roomieWallet);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cardList;
    }

}