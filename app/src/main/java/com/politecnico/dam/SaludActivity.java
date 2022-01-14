package com.politecnico.dam;

import static java.nio.charset.StandardCharsets.UTF_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class SaludActivity extends AppCompatActivity {

    // ArrayList for person names, calleDireccion Id's and mobile numbers
    ArrayList<String> centroNombres = new ArrayList<>();
    ArrayList<String> direcciones = new ArrayList<>();
    ArrayList<String> Localidades = new ArrayList<>();
    ArrayList<Integer> numTelefonos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);
        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named users
            JSONArray itemsArray = obj.getJSONArray("ITEMS");
            // implement for loop for getting users list data
            for (int i = 0; i < itemsArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject centroDetails = itemsArray.getJSONObject(i);
                // fetch calleDireccion and centroNombre and store it in arraylist
                centroNombres.add(centroDetails.getString("nombre"));
                direcciones.add(centroDetails.getString("direccion"));
                // create a object for getting contact data from JSONObject
                Localidades.add(centroDetails.getString("localidad"));
                numTelefonos.add(centroDetails.getInt("telefono"));



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(SaludActivity.this, centroNombres, direcciones, Localidades,numTelefonos);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("CentrosSanitarios.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}