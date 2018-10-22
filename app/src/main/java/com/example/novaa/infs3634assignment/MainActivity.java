package com.example.novaa.infs3634assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //created button for 'Start Quiz' which takes user to QuizActivity (Multiple Choice Quiz)
    private Button button;

    Button beginModule;
    TextView intro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.beginQuiz);
        button.setOnClickListener(new View.OnClickListener() {

            //https://www.youtube.com/watch?v=onJB8g504mw was used as a source on how to link the MainActivity to the QuizActivity
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);

            }
        });

        beginModule = findViewById(R.id.beginModule);
        intro = findViewById(R.id.intro);

        beginModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TopicList.class);

                startActivity(intent);
            }

        });
    }
}
