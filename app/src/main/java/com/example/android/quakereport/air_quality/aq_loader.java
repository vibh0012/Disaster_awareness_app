package com.example.android.quakereport.air_quality;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.android.quakereport.Earthquake;
import com.example.android.quakereport.EarthquakeLoader;
import com.example.android.quakereport.QueryUtils;

import java.util.List;

public class aq_loader extends AsyncTaskLoader<List<Air_q_class>> {

    /** Tag for log messages */


    /** Query URL */
    private String mUrl;

    public aq_loader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Air_q_class> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Air_q_class> e = Utils_air_q.fetchAirQualityData(mUrl);
        return e;
    }
}
