package com.example.novaa.infs3634assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TopicContentTEST extends AppCompatActivity {

    TextView titleView;
    TextView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_content_test);

        titleView = (TextView) findViewById(R.id.titleText);
        contentView = (TextView) findViewById(R.id.contentText);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int topicId = extras.getInt("topicId");
        String title = extras.getString("topicTitle");
        String path = extras.getString("topicPath");

        //Right now the pages content is static and assigned. We need to figure out a way to get the string from the string.xml file
        //and pass that through the intents. 

        String content = getResources().getString(R.string.large_text);



        titleView.setText(title);
        contentView.setText(content);

    }
}
