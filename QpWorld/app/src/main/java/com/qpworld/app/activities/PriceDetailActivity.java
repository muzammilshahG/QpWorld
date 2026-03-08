package com.qpworld.app.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.qpworld.app.R;

import java.util.Locale;

public class PriceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_detail);

        // Get data from intent
        String itemName       = getIntent().getStringExtra("item_name");
        String itemNameUrdu   = getIntent().getStringExtra("item_name_urdu");
        double currentPrice   = getIntent().getDoubleExtra("current_price", 0);
        double previousPrice  = getIntent().getDoubleExtra("previous_price", 0);
        String currency       = getIntent().getStringExtra("currency");
        String unit           = getIntent().getStringExtra("unit");
        String country        = getIntent().getStringExtra("country");
        String lastUpdated    = getIntent().getStringExtra("last_updated");
        String reasonUrdu     = getIntent().getStringExtra("reason_urdu");
        String reasonEnglish  = getIntent().getStringExtra("reason_english");
        String altUrdu        = getIntent().getStringExtra("alternative_urdu");
        String altEnglish     = getIntent().getStringExtra("alternative_english");
        String language       = getIntent().getStringExtra("language");

        boolean isUrdu = language != null && language.equals("ur");

        // Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(isUrdu ? itemNameUrdu : itemName);
        }

        // Price change
        double change = currentPrice - previousPrice;
        double changePercent = previousPrice > 0 ? (change / previousPrice) * 100 : 0;
        boolean isMehnga = change > 0;

        // Views
        TextView tvItemName       = findViewById(R.id.tvItemName);
        TextView tvCurrentPrice   = findViewById(R.id.tvCurrentPrice);
        TextView tvPreviousPrice  = findViewById(R.id.tvPreviousPrice);
        TextView tvChange         = findViewById(R.id.tvChange);
        TextView tvStatus         = findViewById(R.id.tvStatus);
        TextView tvCountry        = findViewById(R.id.tvCountry);
        TextView tvLastUpdated    = findViewById(R.id.tvLastUpdated);
        TextView tvReasonTitle    = findViewById(R.id.tvReasonTitle);
        TextView tvReason         = findViewById(R.id.tvReason);
        TextView tvAltTitle       = findViewById(R.id.tvAltTitle);
        TextView tvAlternative    = findViewById(R.id.tvAlternative);
        CardView cardStatus       = findViewById(R.id.cardStatus);

        // Set values
        tvItemName.setText(isUrdu ? itemNameUrdu : itemName);
        tvCurrentPrice.setText(String.format(Locale.getDefault(),
                "%s %.2f / %s", currency, currentPrice, unit));
        tvPreviousPrice.setText(String.format(Locale.getDefault(),
                isUrdu ? "پہلے: %s %.2f" : "Previous: %s %.2f", currency, previousPrice));

        if (isMehnga) {
            tvChange.setText(String.format(Locale.getDefault(),
                    "▲ %s +%.2f (%.1f%%)", currency, change, changePercent));
            tvChange.setTextColor(getResources().getColor(R.color.colorMehnga));
            tvStatus.setText(isUrdu ? "📈 مہنگا ہوا!" : "📈 Price Increased!");
            cardStatus.setCardBackgroundColor(getResources().getColor(R.color.colorMehngaLight));
        } else if (change < 0) {
            tvChange.setText(String.format(Locale.getDefault(),
                    "▼ %s %.2f (%.1f%%)", currency, change, changePercent));
            tvChange.setTextColor(getResources().getColor(R.color.colorSasta));
            tvStatus.setText(isUrdu ? "📉 سستا ہوا!" : "📉 Price Decreased!");
            cardStatus.setCardBackgroundColor(getResources().getColor(R.color.colorSastaLight));
        } else {
            tvChange.setText(isUrdu ? "— کوئی تبدیلی نہیں" : "— No Change");
            tvChange.setTextColor(getResources().getColor(R.color.colorNeutral));
            tvStatus.setText(isUrdu ? "قیمت مستحکم ہے" : "Price Stable");
        }

        tvCountry.setText("🌍 " + country);
        tvLastUpdated.setText((isUrdu ? "آخری اپڈیٹ: " : "Last Updated: ") + lastUpdated);

        // Reason
        tvReasonTitle.setText(isUrdu ? "وجہ کیا ہے؟" : "Why did this happen?");
        tvReason.setText(isUrdu ? reasonUrdu : reasonEnglish);

        // Alternative
        tvAltTitle.setText(isUrdu ? "سستا متبادل:" : "Cheaper Alternative:");
        tvAlternative.setText(isUrdu ? altUrdu : altEnglish);

        // AdMob
        MobileAds.initialize(this, initializationStatus -> {});
        AdView adView = findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
