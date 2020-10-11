package com.example.mya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private int mCounter =  0;
    TextView txv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lo = findViewById(R.id.login);
        TextView s = findViewById(R.id.singin);


       s.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                   Intent S = new Intent(MainActivity.this, singup.class);
                   startActivity(S);
           }
       });
       lo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                   Intent sd = new Intent(MainActivity.this, login.class);
                   startActivity(sd);
           }
       });
    }
}