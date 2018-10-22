package com.example.novaa.infs3634assignment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;


public class TopicContent extends AppCompatActivity
        implements YouTubePlayer.OnInitializedListener {

    TextView contentView;
    String content;
    int topicId;
    String title;
    String youtubePath;


    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_content);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        YouTubePlayerSupportFragment frag =
                (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtubeFragment);
        frag.initialize(YoutubeConfig.API_KEY, this);

        contentView = (TextView) findViewById(R.id.contentText);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        topicId = extras.getInt("topicId");
        title = extras.getString("topicTitle");
        youtubePath = extras.getString("topicVideo");

        //We realized that the title did not fit as it was too long. To counteract this, we utilised this 'if' statement.
        if (topicId == 1) {
            setTitle("OOP");
        } else {
            setTitle(title);
        }

        //This is how the figures out which content to display, depending on what was clicked.
        //The method is run in the background using ASyncTask to avoid overloading the main interface.
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

                contentView.setText(content);

            }
        }.execute();


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(youtubePath);
        
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
