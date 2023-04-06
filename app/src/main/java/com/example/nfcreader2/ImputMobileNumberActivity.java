package com.example.nfcreader2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ImputMobileNumberActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imput_mobile_number);

        findViewById(R.id.btnInput).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = findViewById(R.id.editTextPhone);
                String strText = edit.getText().toString();
                Toast.makeText(ImputMobileNumberActivity.this,  strText, Toast.LENGTH_SHORT).show();
                if(strText != null  && strText != "")
                {
                    Intent i =  new Intent(ImputMobileNumberActivity.this, WelcomeCardActivity.class);

                    ImputMobileNumberActivity.this.startActivity(i);
                }
            }
        });
    }
}