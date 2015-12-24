package org.t_robop.masatsuna.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
    }

    @Override
    public void onStart(){
        super.onStart();

        TextView fin = (TextView) findViewById(R.id.finalResult);
        fin.setText("あなたの得点は" + QuizScreen.sentence.length + "点満点の" +
                QuizScreen.getPoint() + "点でした。");
    }

    public void onClick(View view){
        QuizScreen.setQuizNumber(0);
        QuizScreen.setPoint(0);

        Intent intent = new Intent(FinalResult.this, StartScreen.class);
        startActivity(intent);
    }
}
