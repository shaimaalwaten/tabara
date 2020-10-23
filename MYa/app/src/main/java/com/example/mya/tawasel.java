package com.example.mya;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class tawasel extends AppCompatActivity {
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tawasel);
        img = (ImageView) findViewById(R.id.location);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog();}
        });

        ImageView a = findViewById(R.id.callme);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_CALL);
               call.setData(Uri.parse("tel:99688685"));
                //رقم التلفون
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CALL_PHONE)!=
                        PackageManager.PERMISSION_GRANTED){

                   return;
                }
                startActivity(call);
            }
        });


    }

    public void emailbtm(View view) {
        try {
            Intent send = new Intent(Intent.ACTION_SEND);
            send.setData(Uri.parse("mailto"));

            send.setType("message/rfo822");
            send.putExtra(Intent.EXTRA_EMAIL, "shaimaalw2@gmail.com");
            send.putExtra(Intent.EXTRA_SUBJECT, "Title");
            send.putExtra(Intent.EXTRA_TEXT, "Subject");

            startActivity(send);
        }
        catch (Exception e){
            Toast.makeText(this,"Faild",Toast.LENGTH_LONG).show();}

        }
        public void opendialog() {
        new AlertDialog.Builder(this)
                .setTitle("تنبيه!")
                .setMessage("سوف تتوفر هذه الخدمة قريبا")
                .setPositiveButton("حسنا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create().show();
        }
    }
