package com.example.gestionconference.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gestionconference.Conference;
import com.example.gestionconference.Login;
import com.example.gestionconference.MainActivity;
import com.example.gestionconference.R;

public class Home extends AppCompatActivity {
 private Button vconf;
 private TextView welcom,liens,lien1,lien2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcom=findViewById(R.id.wlcom);
        liens=findViewById(R.id.lien);
        lien1=findViewById(R.id.l1);
        lien2=findViewById(R.id.l2);
        vconf=findViewById(R.id.lgin);


        lien1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, Conference.class);
                startActivity(intent);
            }
        });

        lien2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, Conference.class);
                startActivity(intent);
            }
        });


    }
}