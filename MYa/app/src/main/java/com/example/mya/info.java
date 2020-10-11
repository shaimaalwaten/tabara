package com.example.mya;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class info extends AppCompatActivity {
    ImageView mLmageView;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PREMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mLmageView = findViewById(R.id.imageView);

        mLmageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED){
                        String[] permissions= {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PREMISSION_CODE);
                    }
                    else {
                        pickImageFromGallery();
                    }
                }
                else {
                    pickImageFromGallery();
                }
            }
        });



    }

    private void pickImageFromGallery() {
        Intent im = new Intent(Intent.ACTION_PICK);
        im.setType("image/*");
        startActivityForResult(im,IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PREMISSION_CODE:{
                if (grantResults.length>0 && grantResults[0]==
                PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery();
                }
                else {
                    // y
                    Toast.makeText(this,"رقض",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            // set image to image view
            mLmageView.setImageURI(data.getData());
        }
    }
}
