package lab3.hotels;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HotelsDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Hotels.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + HotelsDBSchema.HotelsTable.TABLE_NAME + " (" +
                    HotelsDBSchema.HotelsTable._ID + " INTEGER PRIMARY KEY," +
                    HotelsDBSchema.HotelsTable.COLUMN_NAME_NAME + " TEXT," +
                    HotelsDBSchema.HotelsTable.COLUMN_NAME_ADDRESS + " TEXT," +
                    HotelsDBSchema.HotelsTable.COLUMN_NAME_WEBPAGE + " TEXT," +
                    HotelsDBSchema.HotelsTable.COLUMN_NAME_PHONE + " TEXT" +" )";
    public HotelsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    { }
}
