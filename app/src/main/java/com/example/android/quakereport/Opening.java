package com.example.android.quakereport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opening extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        Button a=(Button)findViewById(R.id.opening_button);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Opening.this,Earthquake_query_mod.class);
                startActivity(i);
            }
        });
        Button b=(Button)findViewById(R.id.op_aq);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(Opening.this,air_quality_act.class);
                startActivity(j);
            }
        });
        Button c=(Button)findViewById(R.id.bhuv);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k= new Intent(Opening.this,BhuvanPage.class);
                startActivity(k);
            }
        });
        Button d=(Button)findViewById(R.id.sch);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kj= new Intent(Opening.this,Schemes.class);
                startActivity(kj);
            }
        });
    }
}
