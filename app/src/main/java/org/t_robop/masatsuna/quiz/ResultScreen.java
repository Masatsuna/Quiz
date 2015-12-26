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

        TextView outcome = (TextView) findViewById(R.id.result);   //正誤を画面に表示するためのTextView

        //QuizScreenから渡された文字列を受け取る
        Intent intent = getIntent();
        String dist = intent.getStringExtra("DIST");

        //渡された文字列が"true"なら"正解"と、"false"なら"不正解"と画面に表示（outcomeに結果をsetする）
        if(dist.equals("true")){

            outcome.setText("正解");

        }
        else {

            outcome.setText("不正解");

        }

        //quizNumberに１加えて、”次の問題へ”ボタンを押したとき問題が更新されているようにする
        QuizScreen.addQuizNumber();

        //次の画面へ移るボタン
        TextView btnNext = (TextView) findViewById(R.id.nextScreen);

        //quizNumber（問題番号）が登録された問題数でなければ（最後の問題でなければ）
        if(QuizScreen.getQuizNumber() != QuizScreen.sentence.length) {

            //ボタンに”次の問題へ”と表示
            btnNext.setText("次の問題へ");

        }
        //quizNumberが登録された問題数と同じ（最後の問題の結果表示されたら）
        else {

            //ボタンに”最終結果へ”と表示
            btnNext.setText("最終結果へ");

        }
    }

    //次の画面へ移るボタンが押されたときのメソッド
    public void onClick(View view){

        //最終問題の結果表示でなければ
       if(QuizScreen.getQuizNumber() != QuizScreen.sentence.length) {

           //次の問題画面（quizNumberが更新されたQuizScreen）に移行
           Intent intent = new Intent(ResultScreen.this, QuizScreen.class);
           startActivity(intent);
       }
       //最終問題の結果表示ならば
       else {

           //最終結果の表示画面（FinalResult）に移行
           Intent intent = new Intent(ResultScreen.this, FinalResult.class);
           startActivity(intent);
       }
    }
}
