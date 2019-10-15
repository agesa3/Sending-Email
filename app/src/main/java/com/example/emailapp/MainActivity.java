package com.example.emailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.EnumMap;

public class MainActivity extends AppCompatActivity {
    EditText toEmail;
    EditText subjectEmail;
    EditText eMessage;
    Button sendBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toEmail=findViewById(R.id.toEmail);
        subjectEmail=findViewById(R.id.subject);
        eMessage=findViewById(R.id.messageEmail);
        sendBtn=findViewById(R.id.btn_send);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email=new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{toEmail.getText().toString()});
                email.putExtra(Intent.EXTRA_SUBJECT,subjectEmail.getText().toString());
                email.putExtra(Intent.EXTRA_TEXT,eMessage.getText());
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Choose Mail App"));
            }
        });
    }
}
