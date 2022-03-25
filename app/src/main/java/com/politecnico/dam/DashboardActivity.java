package com.politecnico.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void startMapWindow(View view) {
        Intent intent = new Intent(DashboardActivity.this, MapsActivity.class);
        startActivity(intent);
    }
    public void startSaludWindow(View view) {
        Intent intent = new Intent(DashboardActivity.this, SaludActivity.class);
        startActivity(intent);
    }
    public void startGameWindow(View view) {
        Intent intent = new Intent(DashboardActivity.this, GamesActivity.class);
        startActivity(intent);
    }
    public void startDemoGameWindow(View view){
        Intent intent = new Intent(DashboardActivity.this, GamesActivity.class);
        intent.putExtra("isDemo", "DEMO");
        startActivity(intent);

    }
//

}