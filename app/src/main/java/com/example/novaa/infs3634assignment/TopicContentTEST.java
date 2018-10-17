package com.example.novaa.infs3634assignment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TopicContentTEST extends AppCompatActivity {

    TextView titleView;
    TextView contentView;
    String content;
    int topicId;
    String title;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_content_test);

        titleView = (TextView) findViewById(R.id.titleText);
        contentView = (TextView) findViewById(R.id.contentText);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        topicId = extras.getInt("topicId");
        title = extras.getString("topicTitle");


        //Todo: Ask how I can solve this.

        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {

                switch (topicId) {
                    case 1:
                        content = getResources().getString(R.string.OOP);
                        break;
                    case 2:
                        content = getResources().getString(R.string.Attributes);
                        break;
                    case 3:
                        content = getResources().getString(R.string.Methods);
                        break;
                    case 4:
                        content = getResources().getString(R.string.Abstraction);
                        break;
                    case 5:
                        content = getResources().getString(R.string.Polymorphism);
                        break;
                    case 6:
                        content = getResources().getString(R.string.Inheritance);
                        break;
                    case 7:
                        content = getResources().getString(R.string.Encapsulation);
                        break;
                }
                return content;
            }

            protected void onPostExecute(String content) {

                titleView.setText(title);
                contentView.setText(content);

            }
        }.execute();


    }
}

//Todo: Ask - "If I put a button that is aligned below my ListView (inside my ScrollView), will it be at the bottom of the scroll?
//Todo: If so, can I do the same thing but embed/add a youtube video. If not, how can i do it?