package com.politecnico.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import data.DbHelper;
import data.Question;

public class GamesActivity extends AppCompatActivity {

    //put question id into list
    List<Question> questionList;
    int quid = 1;
    Question currentQuestion;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    TextView questionid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        changeIMage();





        //get all question from db
        DbHelper dbHelper = new DbHelper(this);

        //
        questionList = dbHelper.getAllQuestions();
        System.out.println(questionList.size());

        //random question
        Collections.shuffle(questionList);
        System.out.println(questionList.size());
        currentQuestion = questionList.get(quid);
        questionid = (TextView) findViewById(R.id.questionIdText);
        txtQuestion = (TextView) findViewById(R.id.question);
        rda = (RadioButton) findViewById(R.id.radio0);
        rdb = (RadioButton) findViewById(R.id.radio1);
        rdc = (RadioButton) findViewById(R.id.radio2);
        butNext = (Button) findViewById(R.id.button1);
        setQuestionView();

    }

    private void setQuestionView() {
        txtQuestion.setText(currentQuestion.getQuestion());
        rda.setText(currentQuestion.getOptA());
        rdb.setText(currentQuestion.getOptB());
        rdc.setText(currentQuestion.getOptC());
        questionid.setText( " question number "+currentQuestion.getId() );

    }
    public void changeIMage(){
        ImageView randomImage = findViewById(R.id.imageView2);
        Picasso.get().load("https://picsum.photos/200/300").into(randomImage); //Añade una imagen (aleatoria) de tamaño 200 x 300
    }

    public void btClick(View view) {
        RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
        if(grp.getCheckedRadioButtonId() == -1){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "NINGUNA RESPUESTA ELEGIDA, ELIGUE UNA", Toast.LENGTH_SHORT);

            toast1.show();
            return;


        }
        RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
        if (currentQuestion.getAnswer().equals(answer.getText())) {
            questionid = (TextView) findViewById(R.id.questionIdText);
            if(questionid.getText().equals("question number 20")){
                String result = "Fin";
                Intent intent = new Intent(GamesActivity.this, GamesSecondActivity.class);
                intent.putExtra("message", result);
                startActivity(intent);


            }

            String result = "Correcto";
            Intent intent = new Intent(GamesActivity.this, GamesSecondActivity.class);
            intent.putExtra("message", result);
            startActivity(intent);




        }   if(!currentQuestion.getAnswer().equals(answer.getText())) {

            String result = "Incorrecto";
            Intent intent = new Intent(GamesActivity.this, GamesSecondActivity.class);
            intent.putExtra("message", result);
            startActivity(intent);




        }


    }





}