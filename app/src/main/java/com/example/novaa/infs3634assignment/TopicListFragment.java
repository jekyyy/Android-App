package com.example.novaa.infs3634assignment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class TopicListFragment extends Fragment {
    ArrayList<Topics> topics;
    ListView listView;

    public TopicListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_topic_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listview);
        topics = TopicDatabase.getTopicsArrayList();

        //Instantiating a ArrayAdapter and feeding it to the Topic Database we previously created.
        //We are also utilising the xml layout topic_item, which dictates what each cell of the ArrayList
        //will look like.
        ArrayAdapter<Topics> adapter = new ArrayAdapter<>(getContext(), R.layout.topic_item, topics);

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
                Intent intent = new Intent(getContext(), TopicContent.class);
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