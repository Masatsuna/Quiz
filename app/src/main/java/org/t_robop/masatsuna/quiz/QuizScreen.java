package org.t_robop.masatsuna.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizScreen extends AppCompatActivity {

    private static int quizNumber = 0;

    private static int point = 0;

    public static int getQuizNumber(){
        return quizNumber;
    }

    public static void setQuizNumber(int num){
        quizNumber = num;
    }

    public static void addQuizNumber(){
        quizNumber++;
    }

    static int getPoint(){
        return point;
    }

    static void setPoint(int num){
        point = num;
    }

    static String [] sentence = {
            "1 + 1 = ?", "1 - 1 ="
    };

    String[][] answer = {
            {"1", "2", "3", "4"}, {"0", "1", "2", "3"}
    };

    int[] iButton = {
            R.id.button1, R.id.button2, R.id.button3, R.id.button4
    };

    int [] trueAnswer = {
        2, 1
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);
    }

    @Override
    protected void onStart(){
        super.onStart();

        TextView qNumber = (TextView) findViewById(R.id.qnumber);
        qNumber.setText("問" + (quizNumber + 1));

        TextView quiz = (TextView) findViewById(R.id.examinationSentence);
        quiz.setText(sentence[quizNumber]);

        for(int i = 0; i < iButton.length; i++) {
            TextView ans = (TextView) findViewById(iButton[i]);
            ans.setText(answer[quizNumber][i]);
        }

    }

    public void onClick(View view){
        switch(view.getId()) {
            case R.id.button1:
                distinction(1);
                break;

            case R.id.button2:
                distinction(2);
                break;

            case R.id.button3:
                distinction(3);
                break;

            case R.id.button4:
                distinction(4);
                break;
        }
    }

    public void distinction(int alpha){

        Intent intent = new Intent(QuizScreen.this,ResultScreen.class);

        if(alpha == trueAnswer[quizNumber]){

            point++;

            intent.putExtra("DIST","true");
        }
        else{

            intent.putExtra("DIST","false");
        }


        startActivity( intent );
    }

}
