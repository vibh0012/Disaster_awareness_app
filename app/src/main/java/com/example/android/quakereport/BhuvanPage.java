package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BhuvanPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhuvan_page);
        TextView bt=(TextView)findViewById(R.id.main_text);
        bt.setText("ISRO’s Geo-portal, Bhuvan is providing visualisation" +
                " services and Earth observation data to users in public domain. Besides, the portal " +
                "also services several users for their remote sensing application needs." +
                "" +
                "Space technology is being used for the benefit of society especially during natural disasters. Bhuvan support" +
                "s management of disasters like Cyclone, Floods, Landslides, Earthquakes, Forest Fire and Drought" +
                ", which is useful for various phases of disaster management including preparedness and response. " +
                "Uttarakhand disaster in 2013, J&K floods and Hudhud Cyclone in 2014 and Nepal Earthquake in 2015 are some " +
                "of the examples where Bhuvan provided unique services in terms of online disaster information update, " +
                "forecasts and post-disaster scenario. Yet another important forewarning solution provided by Bhuvan is" +
                " in the landslide forewarning system.  The rain induced landslide warning for major pilgrimage routes in" +
                " Uttarakhand hills are being provided on an experimental basis for the past 2 seasons. This gives regular" +
                " updates on the potential landslides alert based on rainfall and other parameters."
        );
     Button bu_bh=(Button)findViewById(R.id.bhuvan_access);
     bu_bh.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

                 Intent intent = new Intent();
                 intent.setAction(Intent.ACTION_VIEW);
                 //intent.addCategory(Intent.CATEGORY_BROWSABLE);
                 intent.setData(Uri.parse("http://bhuvan-noeda.nrsc.gov.in/disaster/disaster/disaster.php"));
                 startActivity(intent);

         }
     });
    }
}
