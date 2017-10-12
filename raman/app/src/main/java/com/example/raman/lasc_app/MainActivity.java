package com.example.raman.lasc_app;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import static android.R.id.text1;

public class MainActivity extends AppCompatActivity {

    private String url = "https://docs.google.com/forms/d/e/1FAIpQLSdP18vvEeYidcpIr4duZBl2_tWKZHTxEyEaG-REyC0scvorpw/viewform";
    private String nameKey = "entry.2818710";
    private String rollKey = "entry.1243667418";
    private String idKey = "entry.546310133";
    private String subKey = "entry.347560076";
    public  MediaType FORM_DATA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    private String SNU_ID,name,rollNumber,subjectAttended;
    public EditText text1,text2,text3,text4;
    public Button bttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttn = (Button) findViewById(R.id.button);
        text1 = (EditText) findViewById(R.id.name);
        text2 = (EditText) findViewById(R.id.roll);
        text3 = (EditText) findViewById(R.id.id);
        text4 = (EditText) findViewById(R.id.course);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
            }
        });
    }
}


