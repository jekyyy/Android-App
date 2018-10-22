package com.example.novaa.infs3634assignment;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
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

    //For LOG
    private static final String TAG = "TopicContent";


    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_content);

        //Links the toolbar utilised in the xml. Note that this was one of the default activites we
        //can choose to create.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO: Make it so that if clicked, itll show a quick tip on how to remember the topic.
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        /*
        Originally we tried using YouTubePlayerView to display the video. However as we needed to
        extend AppCompactActivity for the toolbar to work, we decided to implement a Fragment instead.
         */
        YouTubePlayerSupportFragment frag =
                (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtubeFragment);
        frag.initialize(YoutubeConfig.API_KEY, this);

        contentView = (TextView) findViewById(R.id.contentText);

        //Intent and bundle is received and the contents are then assigned to variables.
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        topicId = extras.getInt("topicId");
        title = extras.getString("topicTitle");
        youtubePath = extras.getString("topicVideo");

        //We realized that the title did not fit as it was too long. To counteract this, we utilised this 'if' statement.
        if (topicId == 1) {
            setTitle("OOP");
        } else if (topicId == 3){
            setTitle("Methods");
        } else {
            setTitle(title);
        }

        //This is how the figures out which content to display, depending on what was clicked.
        //The method is run in the background using ASyncTask to avoid overloading the main interface.
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {

                //The bulk of the content were stored in strings resource file as storing them in the
                //Topic Database would be too chunky.
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
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: provider is " + provider.getClass().toString());

        // This method checks to make sure the video was not restored already before starting buffer.
        if(!wasRestored){
            youTubePlayer.cueVideo(youtubePath);

        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {


    }
}
