package com.example.novaa.infs3634assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //created button for 'Start Quiz' which takes user to QuizActivity (Multiple Choice Quiz).
    private Button button;

    //TextView is created for intro.
    Button beginModule;
    TextView intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencing and linking startQuiz button.
        //when user clicks on the startQuiz button, open and start QuizActivity activity.
        button = (Button) findViewById(R.id.startQuiz);
        button.setOnClickListener(new View.OnClickListener() {

            // When QuizButton is clicked, an Intent is created to start the QuizActivity
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);

            }
        });

        //referencing beginModule to its button.
        //when user clicks on beginModule button, open and start TopicList activity.
        beginModule = findViewById(R.id.beginModule);
        intro = findViewById(R.id.intro);

            //When beginModule is clicked, an Intent is created to start the TopicList Activity
        beginModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TopicList.class);

                startActivity(intent);
            }

        });
    }
}
