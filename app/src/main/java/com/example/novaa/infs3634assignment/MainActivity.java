package com.example.novaa.infs3634assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//Completed by Jacky, UI design by Leslie
public class MainActivity extends AppCompatActivity {

    //created quizBtn for 'Start Quiz' which takes inflates the QuizFragment in the NavBar Activity.
    Button quizBtn;

    //TextView is created for the title.
    Button beginModule;
    TextView intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intro = findViewById(R.id.intro);

        /*When user clicks on one of the two buttons, an intent is created to open the Nav Bar activity.*/
        /*Extra data is inserted into the intent to identify which button was clicked so that the
        * correct fragment is inflated.*/
        quizBtn = (Button) findViewById(R.id.startQuiz);
        quizBtn.setOnClickListener(new View.OnClickListener() {

            // When QuizButton is clicked, an Intent is created to start the QuizActivity
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavigationBar.class);
                intent.putExtra("quizBtn", 2);
                startActivity(intent);
            }
        });

        beginModule = findViewById(R.id.beginModule);
        beginModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, NavigationBar.class);
                intent.putExtra("quizBtn", 1);
                startActivity(intent);
            }

        });
    }
}

