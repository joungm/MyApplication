package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    public static final int REQUEST_CODE_CUSTOMER = 201;
    public static final int REQUEST_CODE_REVENUE = 202;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent receivedIntent = getIntent();
        String username = receivedIntent.getStringExtra("username");
        String password = receivedIntent.getStringExtra("password");

        Toast.makeText(this, "username : " + username + ", password : " + password, Toast.LENGTH_LONG).show();





        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("message", "로그인 화면");

                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        Button menu01Button = (Button) findViewById(R.id.menu1);
        menu01Button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MovieActivity.class);
                intent.putExtra("titleMsg", "영화정보 화면");

                startActivityForResult(intent, REQUEST_CODE_CUSTOMER);
            }
        });

        Button menu02Button = (Button) findViewById(R.id.menu2);
        menu02Button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), menu2.class);
                intent.putExtra("titleMsg", "기타 화면");

                startActivityForResult(intent, REQUEST_CODE_REVENUE);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (intent != null) {
            if (requestCode == REQUEST_CODE_CUSTOMER) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "영화정보 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            } else if (requestCode == REQUEST_CODE_REVENUE) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "기타 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }


    }
}