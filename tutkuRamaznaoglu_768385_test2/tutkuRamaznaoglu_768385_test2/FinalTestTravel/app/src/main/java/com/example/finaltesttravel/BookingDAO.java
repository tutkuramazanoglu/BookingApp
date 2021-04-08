package com.example.finaltesttravel;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookingDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Booking b);

    @Query("select*from booking_table")
    List<Booking>getAllBooking();

}
