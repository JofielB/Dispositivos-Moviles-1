package com.example.kipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLog;
    String user = "user";
    String pass = "pass";
    EditText editTextUser;
    EditText editTextPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_main);
        editTextUser = findViewById(R.id.edTxtUserName);
        editTextPass = findViewById(R.id.edTxtUserPass);
        btnLog = findViewById(R.id.btnLogin);
        btnLog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(editTextPass.getText().toString().equals(pass) && editTextUser.getText().toString().equals(user)) {
            Intent intent = new Intent(this, PrincipalMenu.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this,  "Password or user incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}
