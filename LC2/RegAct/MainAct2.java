package com.example.sjcet.regact;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;

public class MainAct2 extends AppCompatActivity {
    private TextView textViewName, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s);

        textViewName = findViewById(R.id.ViewName);
        textViewEmail = findViewById(R.id.ViewEmail);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String email = sharedPreferences.getString("email", "");

        textViewName.setText("Name: " + name);
        textViewEmail.setText("Email: " + email);
    }
}
