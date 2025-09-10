package lab3.hotels;

import android.provider.BaseColumns;

public final class HotelsDBSchema {
    private HotelsDBSchema() {}
    public static class HotelsTable implements BaseColumns {
        public static final String TABLE_NAME = "hotels";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_WEBPAGE = "webpage";
        public static final String COLUMN_NAME_PHONE = "phone";
    }
}
