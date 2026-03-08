package com.qpworld.app.activities;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.qpworld.app.R;
import com.qpworld.app.models.Country;
import com.qpworld.app.utils.DataManager;
import com.qpworld.app.utils.PrefsManager;

import java.util.ArrayList;
import java.util.List;

public class CountrySelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_select);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("ملک منتخب کریں / Select Country");
        }

        PrefsManager prefs = new PrefsManager(this);
        List<Country> countries = DataManager.getAllCountries();
        List<String> displayNames = new ArrayList<>();

        for (Country c : countries) {
            displayNames.add(c.getFlagEmoji() + "  " + c.getName() + " (" + c.getNameUrdu() + ")  — " + c.getCurrency());
        }

        ListView listView = findViewById(R.id.listCountries);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, displayNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            prefs.setSelectedCountry(countries.get(position).getCode());
            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
