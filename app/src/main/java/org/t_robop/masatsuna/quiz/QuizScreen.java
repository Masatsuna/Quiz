package org.t_robop.masatsuna.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizScreen extends AppCompatActivity {

    private static int quizNumber = 0;                                //問題に関する配列の添字に使用

    private static int point = 0;                                     //正解数を記憶

    public static int getQuizNumber(){
        return quizNumber;
    }          //quizNumberのgetter

    public static void setQuizNumber(int num){
        quizNumber = num;
    }   //quizNumberのsetter

    public static void addQuizNumber(){
        quizNumber++;
    }              //quizNumberに１加える

    static int getPoint(){
        return point;
    }                           //pointのgetter

    static void setPoint(int num){
        point = num;
    }                    //pointのsetter

    //問題を配列に格納
    static String [] sentence = {
            "『罪と罰』の著者は誰でしょう？",
            "村上春樹著の作品でないのはどれでしょう？",
            "史上初の推理小説と言われている作品はなんでしょう？",
            "シェイクスピアの四大悲劇でないものはどれでしょう？",
            "夏目漱石の前期三部作の一つである作品はどれでしょう？"
    };

    //選択肢を配列に格納
    String[][] answer = {
            {"ソーネチカ", "ラスコーリニコフ", "ドストエフスキー", "ペトローヴィチ"},
            {"ノルウェイの森", "海賊と呼ばれた男", "風の歌を聴け", "ねじまき鳥クロニクル"},
            {"モルグ街の殺人", "そして誰もいなくなった", "緋色の研究", "Xの悲劇"},
            {"ロミオとジュリエット", "ハムレット", "オセロー", "マクベス"},
            {"こころ", "行人", "彼岸過迄", "門"}
    };

    //buttonのidを配列に格納
    int[] iButton = {
            R.id.button1, R.id.button2, R.id.button3, R.id.button4
    };

    //答えに対応する数字を配列に格納
    int [] trueAnswer = {
        3, 2, 1, 1, 4
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);
    }

    @Override
    protected void onStart(){
        super.onStart();

        // ”問 ”を表示
        TextView qNumber = (TextView) findViewById(R.id.qnumber);
        qNumber.setText("問" + (quizNumber + 1));

        // 問題文を表示
        TextView quiz = (TextView) findViewById(R.id.examinationSentence);
        quiz.setText(sentence[quizNumber]);

        //選択肢を各々のボタンに登録
        for(int i = 0; i < iButton.length; i++) {
            TextView ans = (TextView) findViewById(iButton[i]);
            ans.setText(answer[quizNumber][i]);
        }

    }

    //ボタンを識別してそれに対応する数字を引数にしてdistinction() を呼び出す
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

    //正誤を判定してResultScreenにその結果を渡して画面遷移する
    public void distinction(int ans){

        Intent intent = new Intent(QuizScreen.this,ResultScreen.class);

        //引数と問題に対応するtrueAnswerで正誤を判定
        if(ans == trueAnswer[quizNumber]){

            point++;                            //正解（引数 ＝ trueNumber）ならpointに１加える

            intent.putExtra("DIST","true");     //正解ならResultScreenに"true"という文字列を渡す
        }
        else{

            intent.putExtra("DIST","false");    //不正解ならResultScreenに”false”という文字列を渡す
        }


        startActivity( intent );
    }

}
