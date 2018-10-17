package com.example.novaa.infs3634assignment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class TopicContentTEST extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    TextView titleView;
    TextView contentView;
    String content;
    int topicId;
    String title;
    String youtubePath;
    YouTubePlayerView youtubeView;

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
        youtubePath = extras.getString("topicVideo");


        //This is how the figures out which content to display, depending on what was clicked.
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


        youtubeView = findViewById(R.id.youtubePlayer);
        youtubeView.initialize(YoutubeConfig.API_KEY, this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(youtubePath);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

}

//Todo: Ask - "If I put a button that is aligned below my ListView (inside my ScrollView), will it be at the bottom of the scroll?
//Todo: If so, can I do the same thing but embed/add a youtube video. If not, how can i do it?