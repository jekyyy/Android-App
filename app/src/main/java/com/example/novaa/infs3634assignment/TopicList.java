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
        setContentView(R.layout.activity_topic_list2);

        listView = findViewById(R.id.listview);
        topics = TopicDatabase.getTopicsArrayList();

        ArrayAdapter<Topics> adapter = new ArrayAdapter<>(this, R.layout.topic_item, topics);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Topics clicked = (Topics) adapterView.getItemAtPosition(i);
                System.out.println(adapterView.getItemAtPosition(i));


                Intent intent = new Intent(TopicList.this, ScrollingActivity.class);
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
