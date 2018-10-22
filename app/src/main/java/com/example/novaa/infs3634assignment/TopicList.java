package com.example.novaa.infs3634assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TopicList extends AppCompatActivity {
    ArrayList<Topics> topics;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);

        listView = findViewById(R.id.listview);
        topics = TopicDatabase.getTopicsArrayList();

        //Instantiating a ArrayAdapter and feeding it to the Topic Database we previously created.
        //We are also utilising the xml layout topic_item, which dictates what each cell of the ArrayList
        //will look like.
        ArrayAdapter<Topics> adapter = new ArrayAdapter<>(this, R.layout.topic_item, topics);

        //Setting the ListView that displays all the Topics to the Adapter.
        listView.setAdapter(adapter);

        //When the student selects a topic on the List View, it will look at the position it is in
        // to determine which Topic was selected. 'clicked' will then become that topic.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Topics clicked = (Topics) adapterView.getItemAtPosition(i);

                //Intent is created to proceed to the contents page. The 'clicked' Topic's attributes
                // are collated into a Bundle and passed onto the Topic Content activity.
                Intent intent = new Intent(TopicList.this, TopicContent.class);
                Bundle extras = new Bundle();
                extras.putInt("topicId", clicked.getId());
                extras.putString("topicTitle", clicked.getName());
                extras.putString("topicVideo", clicked.getYoutubePath());
                intent.putExtras(extras);
                startActivity(intent);

            }
        });
    }
}
