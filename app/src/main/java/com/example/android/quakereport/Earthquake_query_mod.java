package com.example.android.quakereport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Earthquake_query_mod extends AppCompatActivity {
    //https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_query_mod);
        String query_earthquake= "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson";
        //query_earthquake.append("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson");
        EditText e1=(EditText)findViewById(R.id.text);
        //Log.v("Earthquake_query_mod",e1.getText().toString().trim());
       // if(!e1.getText().toString().isEmpty()) {
        String endtime_check=e1.getText().toString();
        query_earthquake=query_earthquake+"&endtime=";
              query_earthquake=query_earthquake+endtime_check ;
        //}
        EditText e2=(EditText)findViewById(R.id.text2);
        //if(!e2.getText().toString().isEmpty()) {
            //query_earthquake.append("&starttime=" + e2.getText().toString().trim());
        String starttime_check=e2.getText().toString();
        query_earthquake=query_earthquake.concat("&starttime=");
              query_earthquake=query_earthquake.concat(starttime_check) ;
        //}
        EditText e3=(EditText)findViewById(R.id.text3);
        Log.v("Earthquake_query_mod",e3.getText().toString().trim());
        if(!e3.getText().toString().isEmpty())

        {
            query_earthquake=query_earthquake+"&minlatitude" + e3.getText().toString().trim();
            //query_earthquake.append("&minlatitude="+e3.getText().toString().trim());
        }
        EditText e4=(EditText)findViewById(R.id.text4);
        if(!e4.getText().toString().isEmpty())
        {
            query_earthquake=query_earthquake+"&maxlatitude=" + e4.getText().toString().trim();
            //query_earthquake.append("&maxlatitude="+e4.getText().toString().trim());
        }EditText e5=(EditText)findViewById(R.id.text5);
        if(!e5.getText().toString().isEmpty())
        {
            query_earthquake=query_earthquake+"&minlongitude=" + e5.getText().toString().trim();
            //query_earthquake.append("&minlongitude="+e5.getText().toString().trim());
        }EditText e6=(EditText)findViewById(R.id.text6);
        if(!e6.getText().toString().isEmpty())
        {
            query_earthquake=query_earthquake+"&maxlongitude=" + e6.getText().toString().trim();
            //query_earthquake.append("&maxlongitude="+e6.getText().toString().trim());
        }
        EditText e7=(EditText)findViewById(R.id.text7);
        if(!e7.getText().toString().isEmpty())
        {
            query_earthquake=query_earthquake+"&limit=" + e7.getText().toString().trim();
            //query_earthquake.append("&limit="+e7.getText().toString().trim());
        }
        EditText e8=(EditText)findViewById(R.id.text8);
        if(!e8.getText().toString().isEmpty())
        {
            query_earthquake=query_earthquake+"&maxmagnitude=" + e8.getText().toString().trim();
            //query_earthquake.append("&maxmagnitude="+e8.getText().toString().trim());
        }
        EditText e9=(EditText)findViewById(R.id.text9);
        if(!e9.getText().toString().isEmpty())
        {
            query_earthquake=query_earthquake+"&orderby=" + e9.getText().toString().trim();
            //query_earthquake.append("&orderby="+e9.getText().toString().trim());
        }
        final String query_earthquake_string=query_earthquake.toString();
        Log.v("Earthquake_query_mod",query_earthquake_string);
        Button abc=(Button)findViewById(R.id.query_results);
        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ij= new Intent(Earthquake_query_mod.this,EarthquakeActivity.class);
                ij.putExtra("URL",query_earthquake_string);
                startActivity(ij);
            }
        });
    }
}
