package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText usernameInput;
    EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.logBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                loginProcess(v);


            }
        });

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);

    }

   public void loginProcess(View v){
        String uid = usernameInput.getText().toString();
        String upass = passwordInput.getText().toString();
        if(uid.equals("y") && upass.equals("1")){
            Intent intent = new Intent(this,menu.class);
            intent.putExtra("username", uid);
            intent.putExtra("password", upass);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"다시 입력해주세요",Toast.LENGTH_LONG).show();
            usernameInput.setText("");
            passwordInput.setText("");
        }
   }







    }
