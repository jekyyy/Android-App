package com.example.novaa.infs3634assignment;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

//Completed by Jacky, Strings inserted by Leslie
public class TopicContent extends AppCompatActivity
        implements YouTubePlayer.OnInitializedListener {

    TextView contentView;
    String content;
    int topicId;
    String title;
    String youtubePath;
    String tip;

    //For LOG
    private static final String TAG = "TopicContent";


    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_content);

        //Links the toolbar utilised in the xml. Note that this was one of the default activities we
        //can choose to create.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        } else if (topicId == 3) {
            setTitle("Methods");
        } else {
            setTitle(title);
        }


        //This is how the figures out which content to display, depending on what was clicked.
        //The method is run in the background using ASyncTask to avoid overloading the main interface.
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {

                //The bulk of the content were stored in strings in content.xml and tips.xml
                //as storing them in the Topic Database would be too chunky.
                switch (topicId) {
                    case 1:
                        content = getResources().getString(R.string.OOP);
                        tip = getResources().getString(R.string.OOPtip);
                        break;
                    case 2:
                        content = getResources().getString(R.string.Attributes);
                        tip = getResources().getString(R.string.AttributesTip);
                        break;
                    case 3:
                        content = getResources().getString(R.string.Methods);
                        tip = getResources().getString(R.string.MethodTip);
                        break;
                    case 4:
                        content = getResources().getString(R.string.Abstraction);
                        tip = getResources().getString(R.string.AbstractionTip);
                        break;
                    case 5:
                        content = getResources().getString(R.string.Polymorphism);
                        tip = getResources().getString(R.string.PolymorphismTip);
                        break;
                    case 6:
                        content = getResources().getString(R.string.Inheritance);
                        tip = getResources().getString(R.string.InheritanceTip);
                        break;
                    case 7:
                        content = getResources().getString(R.string.Encapsulation);
                        tip = getResources().getString(R.string.EncapsulationTip);
                        break;
                }
                return content;
            }

            protected void onPostExecute(String content) {
                contentView.setText(content);

            }
        }.execute();


        //This is the method for the "quick tip" button.
        FloatingActionButton tips = (FloatingActionButton) findViewById(R.id.tips);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, tip, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: provider is " + provider.getClass().toString());

        // This method checks to make sure the video was not restored already before starting buffer.
        if (!wasRestored) {
            youTubePlayer.cueVideo(youtubePath);
            youTubePlayer.setPlaybackEventListener(playbackEventListener);
        }


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.e("Youtube", "Failed to initialize error.");
        Toast.makeText(TopicContent.this, "Video failed to initialize. Please try reload the page.", Toast.LENGTH_SHORT);


    }

    /*Provided method listens to changes in the state of the Youtube Video. I have assigned
     * simple Toast messages to display the current state of the video to the user.*/
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener(){
        @Override
        public void onPlaying() {
            Toast.makeText(TopicContent.this, "Video is now playing.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(TopicContent.this, "Video has been paused.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopped() {
        }

        @Override
        public void onBuffering(boolean b) {
        }

        @Override
        public void onSeekTo(int i) {

        }
    };
}
