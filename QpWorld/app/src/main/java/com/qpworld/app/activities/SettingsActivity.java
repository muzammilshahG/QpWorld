package com.qpworld.app.activities;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.qpworld.app.R;
import com.qpworld.app.utils.PrefsManager;

public class SettingsActivity extends AppCompatActivity {

    private PrefsManager prefsManager;
    private RadioGroup rgLanguage;
    private RadioButton rbUrdu, rbEnglish, rbBoth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        prefsManager = new PrefsManager(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("ترتیبات / Settings");
        }

        rgLanguage  = findViewById(R.id.rgLanguage);
        rbUrdu      = findViewById(R.id.rbUrdu);
        rbEnglish   = findViewById(R.id.rbEnglish);
        rbBoth      = findViewById(R.id.rbBoth);

        // Set current selection
        String lang = prefsManager.getLanguage();
        if (lang.equals("ur"))   rbUrdu.setChecked(true);
        else if (lang.equals("en")) rbEnglish.setChecked(true);
        else rbBoth.setChecked(true);

        rgLanguage.setOnCheckedChangeListener((group, checkedId) -> {
            String selected;
            if (checkedId == R.id.rbUrdu)         selected = "ur";
            else if (checkedId == R.id.rbEnglish) selected = "en";
            else                                   selected = "both";
            prefsManager.setLanguage(selected);
            Toast.makeText(this, "زبان تبدیل ہوگئی! / Language changed!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
