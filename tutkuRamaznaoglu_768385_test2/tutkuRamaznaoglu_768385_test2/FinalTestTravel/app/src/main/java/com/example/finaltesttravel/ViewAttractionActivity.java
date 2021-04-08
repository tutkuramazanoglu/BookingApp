package com.example.finaltesttravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAttractionActivity extends AppCompatActivity {

    final String TAG="TEST2";
    private SharedPreferences prefs;
    private static final String PREFERENCES_NAME = "SAMPLE-SP";
    private BookingDatabase mDb;


    // Edit Text Variables
    EditText etBookingDate;
    EditText etNumGuests;

    // Text View Variables
    TextView tvName;
    TextView tvAddress;
    TextView tvPrice;

    // Image View
    ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attraction);

        this.prefs = this.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        mDb = BookingDatabase.getDatabase(getApplicationContext());

        //intent
        Intent i=getIntent();
        Attraction a= (Attraction) i.getSerializableExtra("attraction");
        Log.d(TAG,a.getAddress());

        // initialize layout variables
        tvName = (TextView) findViewById(R.id.tvAttractionName);
        tvName.setText(a.getTitle());
        tvAddress = (TextView) findViewById(R.id.tvAttractionAddress);
        tvAddress.setText(a.getAddress());
        tvPrice = (TextView) findViewById(R.id.tvAttractionPrice);
        tvPrice.setText(a.getPrice());

        etBookingDate = (EditText) findViewById(R.id.etBookingDate);
        String date=etBookingDate.getText().toString();
        etNumGuests = (EditText) findViewById(R.id.etNumGuests);
        String number=etNumGuests.getText().toString();

        ivPhoto = (ImageView) findViewById(R.id.imageView);
        if(date.isEmpty() || number.isEmpty()){
            Toast t=Toast.makeText(this,"Please enter date or number",Toast.LENGTH_LONG);
            t.show();

        }
        else{
            String name=this.prefs.getString("name","");
            String id=a.getId();
            String title=a.getTitle();
            Booking b=new Booking(id,name,number,date,title);
            mDb.BookingDAO().insert(b);
        }





    }

    public void backButtonPressed(View view) {
        Intent i = new Intent(this, AttractionsListActivity.class);
        startActivity(i);
    }

    public void bookTourPressed(View view) {
        // @TODO: Write code for what should happen if they press the book tour button

        Intent i = new Intent(this, BookingsListActivity.class);
        startActivity(i);
    }
}