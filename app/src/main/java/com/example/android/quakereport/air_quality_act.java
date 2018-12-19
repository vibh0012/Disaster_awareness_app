package com.example.android.quakereport;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.quakereport.air_quality.Air_q_class;
import com.example.android.quakereport.air_quality.aq_adapter;
import com.example.android.quakereport.air_quality.aq_loader;

import java.util.ArrayList;
import java.util.List;

public class air_quality_act extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<List<Air_q_class>> {
    private static final String ACICN_AIR_QUAL="https://api.waqi.info/feed/delhi/?token=29213eb4dd68852d292faf6ee5ccd8c66d80f071";
    private static final int AQ_LOADER_ID = 2;
    private aq_adapter a_adapter;
    private TextView aEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_quality);


        ListView AQListView = (ListView) findViewById(R.id.list_aq);

        // Create a new adapter that takes an empty list of earthquakes as input
        a_adapter = new aq_adapter(this, new ArrayList<Air_q_class>());

        aEmptyStateTextView = (TextView) findViewById(R.id.empty_view2);
        AQListView.setEmptyView(aEmptyStateTextView);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        AQListView.setAdapter(a_adapter);
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(AQ_LOADER_ID, null, this);

    }
    @Override
    public Loader<List<Air_q_class>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new aq_loader(this, ACICN_AIR_QUAL);
    }
    @Override
    public void onLoadFinished(Loader<List<Air_q_class>> loader, List<Air_q_class> a_objects) {
        // Clear the adapter of previous earthquake data
        a_adapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (a_objects != null && !a_objects.isEmpty()) {
            a_adapter.addAll(a_objects);
        }
        aEmptyStateTextView.setText("No results found!");
    }
    @Override
    public void onLoaderReset(Loader<List<Air_q_class>> loader) {
        // Loader reset, so we can clear out our existing data.
        a_adapter.clear();
    }
}
