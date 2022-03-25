package com.politecnico.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GamesSecondActivity extends AppCompatActivity {
    String isDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_second);

        TextView txtUserInfo = (TextView) findViewById(R.id.textViewUsuario);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn4 = (Button)findViewById(R.id.button4);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        isDemo = intent.getStringExtra("siDemo");



        if(str.equalsIgnoreCase("Correcto")){
            btn2.setText("exit");
            btn4.setText("next");
            txtUserInfo.setText("Has acertado la pregunta");


        }
        else if(str.equalsIgnoreCase("Incorrecto")){
            btn2.setText("exit");
            btn4.setText("try again");
            txtUserInfo.setText("Has fallado la pregunta");



        }  else if(str.equalsIgnoreCase("Fin")){
            btn2.setText("exit");
            btn4.setText("restart");
            txtUserInfo.setText("FIn del quizz");



        }


        }






    public void exit_game(View view){
        Intent intent = new Intent(GamesSecondActivity.this, DashboardActivity.class);
        startActivity(intent);
    }
    public void try_again(){
        this.finish();
    }
    public void next_question(){
        Intent intent = new Intent(GamesSecondActivity.this, GamesActivity.class);
        startActivity(intent);
    }
    public void onbutton4click(View view) {
        Button btn4 = (Button) findViewById(R.id.button4);
        if (isDemo.equalsIgnoreCase("DEMO")) {
            Intent intent = new Intent(GamesSecondActivity.this, DashboardActivity.class);
            startActivity(intent);
        }

            if (btn4.getText().equals("next")) {
                next_question();
            }
            if (btn4.getText().equals("try again")) {
                try_again();

            }
            if (btn4.getText().equals("Fin")) {
                Intent intent = new Intent(GamesSecondActivity.this, GamesActivity.class);
                startActivity(intent);

            }
        }
    }
