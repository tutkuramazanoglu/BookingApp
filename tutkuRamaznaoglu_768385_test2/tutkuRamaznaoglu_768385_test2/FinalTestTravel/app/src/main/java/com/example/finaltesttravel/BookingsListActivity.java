package com.example.finaltesttravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class BookingsListActivity extends AppCompatActivity {

    // Text View
    TextView resultsList;
    private BookingDatabase mDb;

    private String TAG = "EMPLOYEES";
    private SharedPreferences prefs;
    private static final String PREFERENCES_NAME = "SAMPLE-SP";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings_list);

        this.prefs = this.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        resultsList = (TextView) findViewById(R.id.tvBookings);
        resultsList.setText("hi");

        mDb = BookingDatabase.getDatabase(getApplicationContext());
        List<Booking>bookings=mDb.BookingDAO().getAllBooking();
        //check sharepreferences if name equal to booking name then show resevartion

        String name=this.prefs.getString("name","");

        if(bookings.isEmpty()){
            resultsList.setText("No reservations found");
        }
        else{
            for(Booking b:bookings){
                if(b.name.equals(name)){
                    String text=b.date+"  "+b.title;
                    resultsList.setText(text);
                }
            }
        }

        // initialize the list of results




    }

    public void backButtonPressed(View view) {
        Intent i = new Intent(this, AttractionsListActivity.class);
        startActivity(i);
    }
}