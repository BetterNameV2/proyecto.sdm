package uo.sdm.mapintegrationapp.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ZoneDatabaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "zonemanager";

    public static final String TABLE_ZONES = "zones",
    COLUMN_ID = "id",
    COLUMN_LATITUDE = "latitude",
    COLUMN_LONGITUDE = "longitude",
    COLUMN_RADIUS = "radius",
    COLUMN_INFLUENCERADIUS = "influenceradius",
    CREATE_TABLE_ZONES = "CREATE TABLE " + TABLE_ZONES + "(" +
            COLUMN_ID + " BIGINT PRIMARY KEY AUTOINCREMENT," +
            COLUMN_LATITUDE + " DOUBLE NOT NULL," +
            COLUMN_LONGITUDE + " DOUBLE NOT NULL," +
            COLUMN_RADIUS + " DOUBLE NOT NULL," +
            COLUMN_INFLUENCERADIUS + " DOUBLE NOT NULL);",
    DROP_TABLE_ZONES = "DROP TABLE IF EXISTS " + TABLE_ZONES;

    public ZoneDatabaseHandler (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ZONES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_ZONES);

        onCreate(db);
    }
}
