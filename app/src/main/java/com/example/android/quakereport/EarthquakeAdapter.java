package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * Constructs a new {@link EarthquakeAdapter}.
     *
     * @param context of the app
     * @param earthquakes is the list of earthquakes, which is the data source of the adapter
     */
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView with view ID magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeFloor = (int) Math.floor(currentEarthquake.getMagnitude());
        int magnitudeColor = getMagnitudeColor(magnitudeFloor);
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        // Display the magnitude of the current earthquake in that TextView

        magnitudeView.setText(formatMagnitude(currentEarthquake.getMagnitude()));

        //////////////////////////////////////////////////

        // Find the TextView with view ID location
        TextView locationView_one = (TextView) listItemView.findViewById(R.id.location_one);
        TextView locationView_two = (TextView) listItemView.findViewById(R.id.location_two);
        // Display the location of the current earthquake in that TextView
        String total_loc=currentEarthquake.getLocation();
        String[] parts;
        String loc_one,loc_two;
        if(total_loc.contains("of")) {
            parts = total_loc.split("(?<=of)");
            loc_one = parts[0];
            String random=loc_one;
            random=random.toUpperCase();
            Log.v("EarthquakeAdapter",random +"tag");
            loc_one=loc_one.toUpperCase(Locale.ENGLISH);
            loc_two = parts[1];
            loc_two=loc_two.trim();
        }
        else
        {
            loc_one="NEAR THE";
            loc_two=total_loc;
        }
        locationView_one.setText(loc_one);
        locationView_two.setText(loc_two);

        // CHECK THIS!!
        //there are 12 characters with special meanings: the backslash \, the caret ^,
        // the dollar sign $, the period or dot ., the vertical bar or pipe symbol |, the question mark ?
        // , the asterisk or star  *, the plus sign +, the opening parenthesis (, the closing parenthesis ), and the opening square
        // bracket [, the opening curly brace {, These special characters are often called "metacharacters".


        /////////////////////////////////////////////////////////////////////
        Date dataobj=new Date(currentEarthquake.getTimeInMilliseconds());
        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String a=formatDate(dataobj);
        // Display the date of the current earthquake in that TextView
        dateView.setText(a);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String b=formatTime(dataobj);
        // Display the date of the current earthquake in that TextView
        timeView.setText(b);
        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private int getMagnitudeColor(int a)
    {
        int magnitude1Color= ContextCompat.getColor(getContext(), R.color.colorPrimaryDark);
        switch(a)
        {
            case 1:{

                if(a<=2&&a>=0)
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            }
            case 3:
            {
                magnitude1Color=ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            }
            case 4:
            {
                magnitude1Color=ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            }
            case 5:
            {
                magnitude1Color=ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            }
            case 6:
            {
                magnitude1Color=ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            }
            case 7:
            {
                magnitude1Color=ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            }
            case 8:
            {
                magnitude1Color=ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            }
            case 9:
            {
                magnitude1Color=ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            }
            case 10:
            {
                magnitude1Color=ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            }
        }
        return magnitude1Color;
    }
}