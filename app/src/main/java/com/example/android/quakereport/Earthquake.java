package com.example.android.quakereport;
public class Earthquake {

            /** Magnitude of the earthquake */
            private double mMagnitude;

           /** Location of the earthquake */
            private String mLocation;

            /** Date of the earthquake */
            private long mDate;

            private String mid_entry;

            /**
 +     * Constructs a new {@link Earthquake} object.
 +     *
 +     * @param magnitude is the magnitude (size) of the earthquake
 +     * @param location is the city location of the earthquake
 +     * @param date is the date the earthquake happened
 +     */
            public Earthquake(double magnitude, String location, long date,String ide) {
                mMagnitude = magnitude;
                mLocation = location;
                mDate = date;
                mid_entry=ide;
            }

           /**
 +     * Returns the magnitude of the earthquake.
 +     */
            public double getMagnitude() {
                return mMagnitude;
            }

            /**
 +     * Returns the location of the earthquake.
 +     */
            public String getLocation() {
                return mLocation;
            }

            /**
 +     * Returns the date of the earthquake.
 +     */
            public long getTimeInMilliseconds() {
                return mDate;
            }

    public String getMid_entry() {
        return mid_entry;
    }
}
