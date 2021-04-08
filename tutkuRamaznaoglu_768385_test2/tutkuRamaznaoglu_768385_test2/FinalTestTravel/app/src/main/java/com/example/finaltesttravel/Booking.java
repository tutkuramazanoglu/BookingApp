package com.example.finaltesttravel;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "booking_table")
public class Booking {
    @PrimaryKey
    @NonNull
    public String id;
    public String name;
    public String numb;
    public String date;
    public String title;

    public Booking(String id, String name, String numb, String date, String title) {
        this.id = id;
        this.name = name;
        this.numb = numb;
        this.date = date;
        this.title = title;
    }
}
