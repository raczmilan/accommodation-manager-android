package lab3.hotels;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class HotelsDB {
    private final HotelsDBHelper hotelsDBHelper;
    public HotelsDB(Context context){
        hotelsDBHelper = new HotelsDBHelper(context);
    }
    public long insertHotel(String name, String address, String webpage, String phone) {
        SQLiteDatabase db = hotelsDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("webpage", webpage);
        contentValues.put("phone", phone);
        return db.insert("hotels", null, contentValues);
    }
    public Cursor getHotels(){
        SQLiteDatabase db = hotelsDBHelper.getReadableDatabase();
        String[] columns = new String[]{"_id", "name", "address", "webpage", "phone"};
        String orderBy = "name";
        return db.query("hotels", columns, null, null, null, null, orderBy);
    }
}
