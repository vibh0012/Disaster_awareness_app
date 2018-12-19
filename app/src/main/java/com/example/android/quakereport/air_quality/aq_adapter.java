package com.example.android.quakereport.air_quality;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.Earthquake;
import com.example.android.quakereport.R;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class aq_adapter extends ArrayAdapter<Air_q_class> {

    public aq_adapter(Context context, List<Air_q_class> values) {
        super(context, 0, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.aq_listitem, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        //Earthquake currentEarthquake = getItem(position);
        Air_q_class currentvalue=getItem(position);

        TextView aqi_index=(TextView) listItemView.findViewById(R.id.li_aqi);
        aqi_index.setText(currentvalue.get_aqi());

        TextView pmi_index=(TextView) listItemView.findViewById(R.id.li_pmi);
        pmi_index.setText(currentvalue.get_pm_aqi());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}
