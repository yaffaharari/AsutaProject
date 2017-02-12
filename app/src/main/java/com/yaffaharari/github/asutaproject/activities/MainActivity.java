package com.yaffaharari.github.asutaproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yaffaharari.github.asutaproject.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "MainActivity";

    EditText userName, password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);

        loginBtn = (Button) findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String strUserName = userName.getText().toString();
        String strPassword = password.getText().toString();
       // if (strUserName.equalsIgnoreCase("ness-tech") && strPassword.equalsIgnoreCase("123")) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
       // }else{
       //     Toast.makeText(this, "error please check your email or password", Toast.LENGTH_LONG).show();
       // }
    }
}
