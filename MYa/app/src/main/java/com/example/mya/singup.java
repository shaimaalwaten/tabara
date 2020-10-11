package com.example.mya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class singup extends AppCompatActivity {
         RadioGroup radioGroup;
         RadioButton radioButton;
         TextView textView;
         EditText username;
         EditText Email;
         EditText Password1;
         EditText Password2;
         Button btn;

         private FirebaseAuth mAuth;
         private ProgressDialog mLoadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        username=findViewById(R.id.inputusername);
        Email=findViewById(R.id.inputemail);
        Password1=findViewById(R.id.inputpassword);
        Password2=findViewById(R.id.inputpassword2);
        mAuth=FirebaseAuth.getInstance();
        btn=findViewById(R.id.buttond2);
        mLoadingBar=new ProgressDialog(singup.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkcrededntials();
            }
        });

        Button buttonapplay = findViewById(R.id.buttond);
        radioGroup = findViewById(R.id.radio);
        textView = findViewById(R.id.text_view);

        buttonapplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioed;
                radioed = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioed);

                textView.setText("أختيارك هو : " + radioButton.getText());
            }
        });
    }

    public void ch (View view){
        int radioed;
        radioed = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioed);

        Toast.makeText(this," تم أختيار :" + radioButton.getText(),Toast.LENGTH_SHORT).show();
    }
    private void checkcrededntials (){
        String usernamee = username.getText().toString();
        String email = Email.getText().toString();
        String password = Password1.getText().toString();
        String passwoord = Password2.getText().toString();

        if (usernamee.isEmpty() || usernamee.length()<7)
        {
            showError(username,"أسم المستخدم غير متوفر");
        }
        else if ( email.isEmpty() || !email.contains("a"))
        {
            showError(Email,"الايميل غير متوفر");
        }
        else if (password.isEmpty() || password.length()<7)
        {
           showError(Password1,"يجيب أن يكون أكثر من سبعة احرف");
        }
        else if (passwoord.isEmpty() || passwoord.equals(password))
        {
            showError(Password2,"الرمز السري لا يتطابق");
        }
        else {
            mLoadingBar.setTitle("التسجيل");
            mLoadingBar.setMessage("الرجاء الانتظار,للتحقق من هويتك");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();


            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(singup.this, "نجحت", Toast.LENGTH_SHORT).show();

                        mLoadingBar.dismiss();

                        Intent intent = new Intent(singup.this, MainActivity12.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(singup.this, task.getException().toString(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }
}