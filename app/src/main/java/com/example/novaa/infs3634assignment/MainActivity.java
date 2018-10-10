package com.example.novaa.infs3634assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button beginModule;
    TextView intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beginModule = findViewById(R.id.beginModule);
        intro = findViewById(R.id.intro);

        beginModule.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, TopicList.class);

                startActivity(intent);
            }
        });
    }
}
<<<<<<< HEAD

//PLEASE WORK
//ji
=======
>>>>>>> 01e23bf6580900f684d8df3eeeecd508ae3134e2
