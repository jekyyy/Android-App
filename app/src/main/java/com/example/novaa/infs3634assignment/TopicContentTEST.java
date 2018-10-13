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
        int topicId = extras.getInt("topidId");
        String title = extras.getString("topicTitle");
        String content = extras.getString("topicPath");


        titleView.setText(title);
        contentView.setText(content);

    }
}
