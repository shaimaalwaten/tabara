package com.example.mya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText email;
    EditText password;
    Button login;
    TextView forget;
    private FirebaseAuth mAuth;
    ProgressDialog mloadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.inputemail);
        password = findViewById(R.id.inputpassword);
        login = findViewById(R.id.btnlogin);
        forget = findViewById(R.id.forget);
        mAuth = FirebaseAuth.getInstance();
        mloadingBar = new ProgressDialog(com.example.mya.login.this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(com.example.mya.login.this, MainActivity12.class);
                startActivity(i);
            }
        });
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

    private void checkCrededntials() {
        String emaile = email.getText().toString();
        String passw = password.getText().toString();

        if (emaile.isEmpty() || !emaile.contains("@"))
        {
            showError(email, "الأيميل غير متوفر");
        }
        else if (passw.isEmpty() || passw.length() < 7)
        {
            showError(password, "يجيب أن يكون أكثر من سبعة احرف");
        }
        else {
            mloadingBar.setTitle("دخول");
            mloadingBar.setMessage("الرجاء الانتظار,للتحقق من هويتك");
            mloadingBar.setCanceledOnTouchOutside(false);
            mloadingBar.show();

            mAuth.signInWithEmailAndPassword(emaile, passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        mloadingBar.dismiss();

                            Intent intent = new Intent(login.this, MainActivity12.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    else {
                        Toast.makeText(login.this, task.getException().toString(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

