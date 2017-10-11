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

import static android.R.id.text1;

public class MainActivity extends AppCompatActivity {

    private String url = "https://docs.google.com/forms/d/e/1FAIpQLSdP18vvEeYidcpIr4duZBl2_tWKZHTxEyEaG-REyC0scvorpw/viewform";
    private String nameKey = "entry.2818710";
    private String rollKey = "entry.1243667418";
    private String idKey = "entry.546310133";
    private String subKey = "entry.347560076";
    public  MediaType FORM_DATA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    private String SNU_ID,name,rollNumber,subjectAttended;
    EditText text1,text2,text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bttn = (Button)findViewById(R.id.button);
        text1 = (EditText)findViewById(R.id.name);
        text2 = (EditText)findViewById(R.id.roll);
        text3 = (EditText)findViewById(R.id.id);
        text4 = (EditText)findViewById(R.id.course);

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
        PostDataTask task = new PostDataTask();
        name = text1.getText().toString();
        rollNumber = text2.getText().toString();
        SNU_ID = text3.getText().toString();
        subjectAttended = text4.getText().toString();
        task.execute(url);
    }

    public class PostDataTask extends AsyncTask<String,Void,Boolean>{
        String postBody = "";
        boolean result = true;
        @Override
        protected Boolean doInBackground(String... contactData){
            try{
                postBody = nameKey + "=" + URLEncoder.encode(name,"UTF-8")+ "&" +
                        rollKey + "=" + URLEncoder.encode(rollNumber,"UTF-8") + "&" +
                        idKey + "=" + URLEncoder.encode(SNU_ID,"UTF-8") + "&" +
                        subKey + "=" + URLEncoder.encode(subjectAttended,"UTF-8");
            }
            catch(UnsupportedEncodingException e){
                Log.e("#",""+e);
                result = false;
            }
            try{
                OkHttpClient client = new OkHttpClient();
                RequestBody body = RequestBody.create(FORM_DATA_TYPE,postBody);
                Request req = new Request.Builder().url(url).post(body).build();
                Response response = client.newCall(req).execute();
            }
            catch(IOException e){
                Log.e("#",""+e);
            }
            return result;
        }

        @Override
        protected  void onPostExecute(Boolean result){
            Toast.makeText(getApplicationContext(),"Data Added",Toast.LENGTH_SHORT).show();
        }
    }
}

