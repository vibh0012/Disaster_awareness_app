package com.example.android.quakereport.air_quality;

import java.util.List;

public class Air_q_class {

        /** Magnitude of the earthquake */
        private int aqi;

        /** Location of the earthquake */
        private int pm_aqi;

        public Air_q_class(int a, int b) {
        aqi=a;
        pm_aqi=b;
        }

        /**
         +     * Returns the magnitude of the earthquake.
         +     */
        public int get_aqi() {
            return aqi;
        }

        /**
         +     * Returns the location of the earthquake.
         +     */
        public int get_pm_aqi() {
            return pm_aqi;
        }
        }

