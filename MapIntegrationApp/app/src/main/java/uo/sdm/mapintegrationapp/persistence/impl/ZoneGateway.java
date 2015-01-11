package uo.sdm.mapintegrationapp.persistence.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import uo.sdm.mapintegrationapp.business.Zone;
import uo.sdm.mapintegrationapp.persistence.ZoneDB;

public class ZoneGateway {

    private SQLiteDatabase database;
    private final ZoneDB dbHelper;

    private final String[] columns = {
            ZoneDB.TABLE_ZONES.COLUMN_ID,
            ZoneDB.TABLE_ZONES.COLUMN_LATITUDE,
            ZoneDB.TABLE_ZONES.COLUMN_LONGITUDE,
            ZoneDB.TABLE_ZONES.COLUMN_RADIUS,
            ZoneDB.TABLE_ZONES.COLUMN_INFLUENCE_RADIUS
    };

    public ZoneGateway (final Context context){
        dbHelper = new ZoneDB(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    //TODO cambiar parámetro por objeto Circle
    public long createZone(final double longitude, final double latitude, final double radius, final double influenceRadius){
        final ContentValues values = new ContentValues();

        values.put(ZoneDB.TABLE_ZONES.COLUMN_LATITUDE, latitude);
        values.put(ZoneDB.TABLE_ZONES.COLUMN_LONGITUDE, longitude);
        values.put(ZoneDB.TABLE_ZONES.COLUMN_RADIUS, radius);
        values.put(ZoneDB.TABLE_ZONES.COLUMN_INFLUENCE_RADIUS, influenceRadius);

        return database.insert(ZoneDB.TABLE_ZONES.NAME, null, values);
    }

    public Zone getZone(final long id){

        String[] queryArgs = {
                String.valueOf(id)
        };

        Cursor cursor = database.query(
                ZoneDB.TABLE_ZONES.NAME,
                columns,
                ZoneDB.TABLE_ZONES.COLUMN_ID + " = ?",
                queryArgs,
                null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        //TODO return new Circle(cursor.getLong(0));
        return null;
    }
}
