package uo.sdm.mapintegrationapp.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import uo.sdm.mapintegrationapp.business.Zone;

public class ZoneGateway {

    private SQLiteDatabase database;
    private final ZoneDatabaseHandler dbHelper;

    private final String[] columns = {
            ZoneDatabaseHandler.COLUMN_ID,
            ZoneDatabaseHandler.COLUMN_LATITUDE,
            ZoneDatabaseHandler.COLUMN_LONGITUDE,
            ZoneDatabaseHandler.COLUMN_RADIUS,
            ZoneDatabaseHandler.COLUMN_INFLUENCERADIUS
    };

    public ZoneGateway (final Context context){
        dbHelper = new ZoneDatabaseHandler(context);
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

        values.put(ZoneDatabaseHandler.COLUMN_LATITUDE, latitude);
        values.put(ZoneDatabaseHandler.COLUMN_LONGITUDE, longitude);
        values.put(ZoneDatabaseHandler.COLUMN_RADIUS, radius);
        values.put(ZoneDatabaseHandler.COLUMN_INFLUENCERADIUS, influenceRadius);

        return database.insert(ZoneDatabaseHandler.TABLE_ZONES, null, values);
    }

    public Zone getZone(final long id){

        String[] queryArgs = {
                String.valueOf(id)
        };

        Cursor cursor = database.query(
                ZoneDatabaseHandler.TABLE_ZONES,
                columns,
                ZoneDatabaseHandler.COLUMN_ID + " = ?",
                queryArgs,
                null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        //TODO return new Circle(cursor.getLong(0));
        return null;
    }
}
