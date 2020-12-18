package com.example.gestionconference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.gestionconference.dto.Helper;
import com.example.gestionconference.dto.UserDetails;

public class MainActivity extends AppCompatActivity {
  private EditText nom,prenom,email,adress,pwd;
  private Button singin,con;
  private Spinner sp;
final AppCompatActivity activity=MainActivity.this;
    private InputValidation inputValidation;
    private Helper databaseHelper;
    private UserDetails user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        email=findViewById(R.id.email);
        adress=findViewById(R.id.adress);
        pwd=findViewById(R.id.passwrds);
        sp=findViewById(R.id.spinner1);
        singin=findViewById(R.id.sng);
        con=findViewById(R.id.lgin);

        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);

            }
        });

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
    }


    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new Helper(activity);
        user = new UserDetails();
    }


}