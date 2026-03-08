package com.qpworld.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.qpworld.app.R;
import com.qpworld.app.adapters.PriceAdapter;
import com.qpworld.app.models.Country;
import com.qpworld.app.models.PriceItem;
import com.qpworld.app.utils.DataManager;
import com.qpworld.app.utils.PrefsManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PriceAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private PriceAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;
    private Spinner spinnerCountry;
    private ChipGroup chipGroupCategory;
    private TextView tvSelectedCountry;
    private AdView adView;

    private PrefsManager prefsManager;
    private List<PriceItem> allPrices = new ArrayList<>();
    private List<Country> countries;
    private String selectedCountryCode = "PK";
    private String selectedCategory = "all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefsManager = new PrefsManager(this);
        selectedCountryCode = prefsManager.getSelectedCountry();

        setupToolbar();
        setupAdMob();
        setupCountrySpinner();
        setupCategoryChips();
        setupRecyclerView();
        setupSwipeRefresh();
        loadPrices();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("QpWorld 🌍");
        }
    }

    private void setupAdMob() {
        MobileAds.initialize(this, initializationStatus -> {});
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private void setupCountrySpinner() {
        countries = DataManager.getAllCountries();
        List<String> countryNames = new ArrayList<>();
        int selectedIndex = 0;

        for (int i = 0; i < countries.size(); i++) {
            Country c = countries.get(i);
            countryNames.add(c.getFlagEmoji() + " " + c.getName());
            if (c.getCode().equals(selectedCountryCode)) {
                selectedIndex = i;
            }
        }

        spinnerCountry = findViewById(R.id.spinnerCountry);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, countryNames);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(spinnerAdapter);
        spinnerCountry.setSelection(selectedIndex);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCountryCode = countries.get(position).getCode();
                prefsManager.setSelectedCountry(selectedCountryCode);
                loadPrices();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void setupCategoryChips() {
        chipGroupCategory = findViewById(R.id.chipGroupCategory);

        String[][] chips = {
                {"all", "سب", "All"},
                {"fuel", "ایندھن", "Fuel"},
                {"food", "خوراک", "Food"},
                {"vegetables", "سبزیاں", "Veggies"},
                {"utility", "یوٹیلیٹی", "Utility"}
        };

        for (String[] chipData : chips) {
            Chip chip = new Chip(this);
            chip.setText(chipData[1] + " / " + chipData[2]);
            chip.setCheckable(true);
            chip.setChecked(chipData[0].equals("all"));
            String categoryKey = chipData[0];
            chip.setOnClickListener(v -> {
                selectedCategory = categoryKey;
                filterAndShow();
            });
            chipGroupCategory.addView(chip);
        }
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PriceAdapter(this, new ArrayList<>(), this,
                prefsManager.getLanguage());
        recyclerView.setAdapter(adapter);
    }

    private void setupSwipeRefresh() {
        swipeRefresh = findViewById(R.id.swipeRefresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(() -> {
            loadPrices();
            swipeRefresh.setRefreshing(false);
        });
    }

    private void loadPrices() {
        allPrices = DataManager.getPricesByCountry(selectedCountryCode);
        filterAndShow();
    }

    private void filterAndShow() {
        List<PriceItem> filtered = new ArrayList<>();
        for (PriceItem item : allPrices) {
            if (selectedCategory.equals("all") ||
                    item.getCategory().equals(selectedCategory)) {
                filtered.add(item);
            }
        }
        adapter.updateData(filtered);
    }

    @Override
    public void onItemClick(PriceItem item) {
        Intent intent = new Intent(this, PriceDetailActivity.class);
        intent.putExtra("item_name", item.getItemName());
        intent.putExtra("item_name_urdu", item.getItemNameUrdu());
        intent.putExtra("current_price", item.getCurrentPrice());
        intent.putExtra("previous_price", item.getPreviousPrice());
        intent.putExtra("currency", item.getCurrency());
        intent.putExtra("unit", item.getUnit());
        intent.putExtra("country", item.getCountry());
        intent.putExtra("last_updated", item.getLastUpdated());
        intent.putExtra("reason_urdu", item.getReasonUrdu());
        intent.putExtra("reason_english", item.getReasonEnglish());
        intent.putExtra("alternative_urdu", item.getAlternativeUrdu());
        intent.putExtra("alternative_english", item.getAlternativeEnglish());
        intent.putExtra("language", prefsManager.getLanguage());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
