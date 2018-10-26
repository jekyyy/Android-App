package com.example.novaa.infs3634assignment;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

//Completed by Jacky
public class NavigationBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*Fragment Manager is instantiated to manage the back-stack of fragment transactions.*/
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Default Navigation Bar Code.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*When NavigationBar UI is created, we need to know which fragment to employ. The numbers 1
        and 2 differentiate whether the Quiz or Begin Module button was clicked.*/
        Bundle bundle = getIntent().getExtras();
        int buttonPressed = bundle.getInt("quizBtn");

        if (buttonPressed == 1) {
            fragment = new TopicListFragment();
        } else {
            fragment = new QuizFragment();
        }
        FragReplace(fragment);

    }

    //Default method.
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //Default method.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_test, menu);
        return true;
    }

    /*If the button is clicked, the user will be brought to his home screen.*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_quit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*Method determines which item in the Nav Bar is clicked. Depending on which item, a fragment
    will be inflated in the container.*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.topics) {
            fragment = new TopicListFragment();

        } else if (id == R.id.quiz) {
            fragment = new QuizFragment();
        }
        if (fragment != null) {
            FragReplace(fragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /*Method to create a fragment transaction which is used to add,remove,update fragments.
    * This transaction then replaces the current container with the selected fragment.*/
    public void FragReplace(Fragment frag) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container, frag);
        ft.commit();
    }

}

