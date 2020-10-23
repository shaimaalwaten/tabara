package com.example.mya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        TextView a = findViewById(R.id.textView13);
        TextView ssa = findViewById(R.id.textView20);

        TextView s = findViewById(R.id.textView21);
        TextView aa = findViewById(R.id.textView22);
        Bundle air = getIntent().getExtras();

        ssa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent me = new Intent(check.this,tawasel.class);
                startActivity(me);
            }
        });


        String saw = air.getString("name");
        a.setText(saw);

        String sa = air.getString("namew" + "!");
        aa.setText(sa);
    }
}