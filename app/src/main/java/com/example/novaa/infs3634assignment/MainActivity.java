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
        intro = findViewById(R.id.intro);

        //When user clicks on one of the button and intent is created to open the Nav Bar activity.
        //A number is passed to differentiate which button is clicked so that the NavBar can
        //Inflate the correct fragment.
        button = (Button) findViewById(R.id.startQuiz);
        button.setOnClickListener(new View.OnClickListener() {

            // When QuizButton is clicked, an Intent is created to start the QuizActivity
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavigationBar.class);
                intent.putExtra("button", 2);
                startActivity(intent);

            }
        });

        beginModule = findViewById(R.id.beginModule);

            //When beginModule is clicked, an Intent is created to start the TopicList Activity
        beginModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, NavigationBar.class);
                intent.putExtra("button", 1);
                startActivity(intent);

            }

        });
    }
}

