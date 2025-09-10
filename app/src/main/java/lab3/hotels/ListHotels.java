package lab3.hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ListHotels extends AppCompatActivity {
    private final String[] from = new String[]{"name", "address", "webpage", "phone"};
    private final int[] to = new int[]{R.id.hotel_name, R.id.hotel_address, R.id.hotel_webpage, R.id.hotel_phone};
    private final HotelsDB db = new HotelsDB(this);

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hotels);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextAppearance(this, R.style.TitleText);
        setSupportActionBar(myToolbar);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_item_layout,
                db.getHotels(), from, to);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onRestart() {
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_item_layout,
                db.getHotels(), from, to);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        super.onRestart();
    }

    public void newHotel(View view) {
        Intent intent = new Intent(this, NewHotel.class);
        startActivity(intent);
    }

    public void showLocation(View view) {
        View parent = (View) view.getParent();
        TextView textView = parent.findViewById(R.id.hotel_address);
        Uri location = Uri.parse("geo:" + textView.getText().toString());
        Intent webIntent = new Intent(Intent.ACTION_VIEW, location);
        try {
            startActivity(webIntent);
        } catch (ActivityNotFoundException e) {
            System.out.println("Activity not found for show location intent!");
        }
    }

    public void showWebpage(View view) {
        View parent = (View) view.getParent();
        TextView textView = parent.findViewById(R.id.hotel_webpage);
        Uri webpage = Uri.parse("http://" + textView.getText().toString());
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        try {
            startActivity(webIntent);
        } catch (ActivityNotFoundException e) {
            System.out.println("Activity not found for show webpage intent!");
        }
    }

    public void callPhone(View view) {
        View parent = (View) view.getParent();
        TextView textView = parent.findViewById(R.id.hotel_phone);
        Uri phoneNumber = Uri.parse("tel:" + textView.getText().toString());
        Intent callIntent = new Intent(Intent.ACTION_DIAL, phoneNumber);
        try {
            startActivity(callIntent);
        } catch (ActivityNotFoundException e) {
            System.out.println("Activity not found for phone call intent!");
        }
    }
}