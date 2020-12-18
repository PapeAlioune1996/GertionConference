package com.example.gestionconference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestionconference.dto.Helper;
import com.example.gestionconference.home.Home;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
private Button login,signin;
private EditText mail,password;
private  InputValidation inputValidation;
private Helper helper;
private AppCompatActivity activity;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
private TextInputLayout textInputLayoutemail,textInputLayoutpwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mail=findViewById(R.id.email);
        password=findViewById(R.id.pasword);


        login=findViewById(R.id.lgin);

        signin=findViewById(R.id.sng);

   initObject();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();


            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        if( mail.getText().toString().isEmpty()  || password.getText().toString().isEmpty())
        {
            Toast.makeText(Login.this, "Veillez remplir tous les champs  svp", Toast.LENGTH_LONG).show();
        }
        else {

            if (mail.getText().toString().trim().matches(emailPattern)) {
                if (password.getText().toString().length() < 6) {
                    Toast.makeText(Login.this, "Password to short", Toast.LENGTH_LONG).show();

                } else {
                    Intent accountsIntent = new Intent(Login.this, Home.class);
                    //accountsIntent.putExtra("EMAIL", mail.getText().toString().trim());
                    emptyInputEditText();
                    startActivity(accountsIntent);
                }
            }
        }
            }

    private void emptyInputEditText() {
        mail.setText(null);
        password.setText(null);
    }


    private void initObject() {
        helper=new Helper(activity);
        inputValidation=new InputValidation(activity);
    }
}



