package org.t_robop.masatsuna.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
    }
    @Override
    public void onStart(){
        super.onStart();

        TextView outcome = (TextView) findViewById(R.id.result);

        Intent intent = getIntent();
        String dist = intent.getStringExtra("DIST");

        if(dist.equals("true")){

            outcome.setText("正解");

        }
        else {

            outcome.setText("不正解");

        }

        QuizScreen.addQuizNumber();

        TextView btnNext = (TextView) findViewById(R.id.nextScreen);

        if(QuizScreen.getQuizNumber() != QuizScreen.sentence.length) {

            btnNext.setText("次の問題へ");

        }
        else {

            btnNext.setText("最終結果へ");

        }
    }

    public void onClick(View view){

       if(QuizScreen.getQuizNumber() != QuizScreen.sentence.length) {
           Intent intent = new Intent(ResultScreen.this, QuizScreen.class);
           startActivity(intent);
       }
       else {
           Intent intent = new Intent(ResultScreen.this, FinalResult.class);
           startActivity(intent);
       }
    }
}
