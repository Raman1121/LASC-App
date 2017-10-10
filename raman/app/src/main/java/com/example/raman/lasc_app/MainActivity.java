package com.example.raman.lasc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bttn = (Button)findViewById(R.id.button);
        final EditText text1 = (EditText)findViewById(R.id.name);
        final EditText text2 = (EditText)findViewById(R.id.roll);
        final EditText text3 = (EditText)findViewById(R.id.id);
        final EditText text4 = (EditText)findViewById(R.id.course);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Set the values of the text fields to blank.
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");


                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        postData();
                    }
                });
                t.start();
            }
        });

    }

    public void postData(){

    }
}

