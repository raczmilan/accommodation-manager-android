package lab3.hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class NewHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hotel);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        myToolbar.setTitleTextAppearance(this, R.style.TitleText);
        setSupportActionBar(myToolbar);
    }

    public void saveHotel(View view) {
        HotelsDB db = new HotelsDB(this);
        EditText editText1 = findViewById(R.id.edit_text_name);
        EditText editText2 = findViewById(R.id.edit_text_address);
        EditText editText3 = findViewById(R.id.edit_text_webpage);
        EditText editText4 = findViewById(R.id.edit_text_phone);
        String name = editText1.getText().toString();
        String address = editText2.getText().toString();
        String webpage = editText3.getText().toString();
        String phone = editText4.getText().toString();

        if (name.isEmpty() || address.isEmpty() || webpage.isEmpty() || phone.isEmpty()) {
            CharSequence text = "All fields are required.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        } else {
            db.insertHotel(name, address, webpage, phone);
            editText1.getText().clear();
            editText2.getText().clear();
            editText3.getText().clear();
            editText4.getText().clear();

            CharSequence text = "Added new hotel.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }
    }
}