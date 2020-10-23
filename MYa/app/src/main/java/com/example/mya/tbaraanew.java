package com.example.mya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class tbaraanew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbaraanew);

        Button m =findViewById(R.id.yes);

        final EditText s = findViewById(R.id.nameone);
        final EditText sh = findViewById(R.id.nametwo);

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ma;
                ma = new Intent(tbaraanew.this,check.class);
                ma.putExtra("name", s.getText().toString());

                ma.putExtra("namew",sh.getText().toString());

                startActivity(ma);
            }
        });
    }
}