package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;

public class menu2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);




        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("message", "선택메뉴로");

                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });


    }

    public void naver(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://naver.com"));
        startActivity(intent);
    }

    public void call(View v){
        Uri locat = Uri.parse("geo:37.556402, 126.987500");
        showMap(locat);


    }
    public void showMap(Uri geoLocation){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        startActivity(intent);

    }


}