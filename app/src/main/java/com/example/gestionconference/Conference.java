package com.example.gestionconference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Conference extends AppCompatActivity {
    private TextView n,p,e,a;

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
        p=findViewById(R.id.prnom);
        e=findViewById(R.id.email);
        a=findViewById(R.id.adrss);

        btn=findViewById(R.id.join);
    }
}