package com.example.gestionconference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class Conference extends AppCompatActivity {
    private TextView n,p,e,a,d,desc;
    String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference);
        recycletext();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Conference.this,"CONFERENCE ADD SUCCESFULLY",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void recycletext() {
        n=findViewById(R.id.name);

        e=findViewById(R.id.email);
      d=findViewById(R.id.dt);
      d.setText(currentDateTimeString);
      desc=findViewById(R.id.desc);
        btn=findViewById(R.id.join);
    }
}