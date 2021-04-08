package com.example.finaltesttravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AttractionsListActivity extends AppCompatActivity {

    // TAG
    String TAG = "ATTRACTIONS-LIST";

    // ListView
    ListView lvAttractions;

    // data source
    String[] attractionNames = new String[] {
            "CN Tower",
            "Eaton Center",
            "Ripley's Aquarium",
            "Yonge Dundas Square",
            "Kensington Market"
    };

    ArrayList<String>titles=new ArrayList<>();
    ArrayList<Attraction>attractions=new ArrayList<>();
    Attraction a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions_list);

        //JSON
        String fileContents = loadDataFromFile("attractions.json");

        // convert the string to an JSONObject (peter.json = object)
        JSONArray fileContentsAsJSON = convertToJSONArray(fileContents);
        try {
            parseJSONData(fileContentsAsJSON);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // initialize the list view
        lvAttractions = (ListView) findViewById(R.id.lvAttractionsList);

        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
        lvAttractions.setAdapter(adapter);

        // on click listener
        lvAttractions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Attraction attraction=attractions.get(i);
                Log.d(TAG, "User clicked on item " + i+"  "+attraction.getId());

                Intent intentViewAttractions
                        = new Intent(getApplicationContext(), ViewAttractionActivity.class);
                intentViewAttractions.putExtra("attraction",attraction);
                startActivity(intentViewAttractions);
            }
        });

    }

    public void viewBookingsButtonPressed(View view) {
        Intent i = new Intent(this, BookingsListActivity.class);

        startActivity(i);
    }
    public void logoutButtonPressed(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public String loadDataFromFile(String FILENAME) {
        // get the JSON file from the
//         = "person.json";

        String jsonString;

        try {
            // open the file
            InputStream fileData = this.getAssets().open(FILENAME);

            // get information about the file
            int fileSize = fileData.available();

            // set up a array to store each piece of data in the file
            // the size of the array is the same size as the file
            byte[] buffer = new byte[fileSize];

            // get all the data from the file
            fileData.read(buffer);

            // close the file
            fileData.close();

            // convert the data to json
            jsonString = new String(buffer, "UTF-8");

            return jsonString;

        } catch (IOException e) {
            Log.d(TAG,"Error opening file.");
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray convertToJSONArray(String fileData) {
        JSONArray jsonData;
        try {
            // 1. try to convert the string to the JSONObject data type
            jsonData = new JSONArray(fileData);
            // 2. if successful return it
            return jsonData;

        }catch (JSONException e) {
            // 2. if conversion fails, then print error message and return
            e.printStackTrace();
            return null;
        }

    }

    public void parseJSONData(JSONArray jsonArray) throws JSONException {
        // 1. get the firstname
        // 2. get the age
        // output both to the screen (terminal)
        Log.d(TAG, "Successfully got the file contents as a json object");
        for(int i=0;i<jsonArray.length();i++){
            String title=jsonArray.getJSONObject(i).getString("name");
            String id=jsonArray.getJSONObject(i).getString("id");
            String address=jsonArray.getJSONObject(i).getString("address");
            String price=jsonArray.getJSONObject(i).getString("price");
            String description=jsonArray.getJSONObject(i).getString("description");
            String photo=jsonArray.getJSONObject(i).getString("photo");
            this.a=new Attraction(id,title,address,price,photo,description);

            Log.d(TAG,"tit "+title);
            titles.add(title);
            attractions.add(a);
        }
//        Log.d(TAG, "titles"+titles);

    }



}