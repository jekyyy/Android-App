package com.example.novaa.infs3634assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class navTEST extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //TODO: Delete current TopicList code from this file and convert the TopicList file into a fragment.
    //TODO: Change the UI of the Nav Bar.
    ArrayList<Topics> topics;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
                    Intent intent = new Intent(navTEST.this, TopicContent.class);
                    Bundle extras = new Bundle();
                    extras.putInt("topicId", clicked.getId());
                    extras.putString("topicTitle", clicked.getName());
                    extras.putString("topicVideo", clicked.getYoutubePath());
                    intent.putExtras(extras);
                    startActivity(intent);
    }

});
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(getApplicationContext(), navTEST.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            fragment = new QuizFragment();
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        if(fragment !=null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();

            ft.replace(R.id.container, fragment);
            ft.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
