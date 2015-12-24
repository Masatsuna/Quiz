package org.t_robop.masatsuna.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startButton:
                Intent intent = new Intent(this, QuizScreen.class);
                startActivity(intent);
        }
    }
}
