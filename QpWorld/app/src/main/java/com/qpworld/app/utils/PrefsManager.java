package com.qpworld.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {
    private static final String PREF_NAME = "QpWorldPrefs";
    private static final String KEY_COUNTRY = "selected_country";
    private static final String KEY_LANGUAGE = "app_language";
    private static final String KEY_FIRST_LAUNCH = "first_launch";

    private SharedPreferences prefs;

    public PrefsManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public String getSelectedCountry() {
        return prefs.getString(KEY_COUNTRY, "PK"); // Default Pakistan
    }

    public void setSelectedCountry(String countryCode) {
        prefs.edit().putString(KEY_COUNTRY, countryCode).apply();
    }

    public String getLanguage() {
        return prefs.getString(KEY_LANGUAGE, "ur"); // Default Urdu
    }

    public void setLanguage(String lang) {
        prefs.edit().putString(KEY_LANGUAGE, lang).apply();
    }

    public boolean isFirstLaunch() {
        return prefs.getBoolean(KEY_FIRST_LAUNCH, true);
    }

    public void setFirstLaunch(boolean isFirst) {
        prefs.edit().putBoolean(KEY_FIRST_LAUNCH, isFirst).apply();
    }
}
