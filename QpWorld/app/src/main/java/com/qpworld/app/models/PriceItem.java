package com.qpworld.app.models;

public class PriceItem {
    private String itemName;
    private String itemNameUrdu;
    private String category;
    private double currentPrice;
    private double previousPrice;
    private String currency;
    private String country;
    private String countryCode;
    private String unit;
    private String lastUpdated;
    private String reasonUrdu;
    private String reasonEnglish;
    private String alternativeUrdu;
    private String alternativeEnglish;

    public PriceItem() {}

    public PriceItem(String itemName, String itemNameUrdu, String category,
                     double currentPrice, double previousPrice,
                     String currency, String country, String countryCode,
                     String unit, String lastUpdated,
                     String reasonUrdu, String reasonEnglish,
                     String alternativeUrdu, String alternativeEnglish) {
        this.itemName = itemName;
        this.itemNameUrdu = itemNameUrdu;
        this.category = category;
        this.currentPrice = currentPrice;
        this.previousPrice = previousPrice;
        this.currency = currency;
        this.country = country;
        this.countryCode = countryCode;
        this.unit = unit;
        this.lastUpdated = lastUpdated;
        this.reasonUrdu = reasonUrdu;
        this.reasonEnglish = reasonEnglish;
        this.alternativeUrdu = alternativeUrdu;
        this.alternativeEnglish = alternativeEnglish;
    }

    // Price change calculation
    public double getPriceChange() {
        return currentPrice - previousPrice;
    }

    public double getPriceChangePercent() {
        if (previousPrice == 0) return 0;
        return ((currentPrice - previousPrice) / previousPrice) * 100;
    }

    public boolean isMehnga() { // is expensive / went up
        return currentPrice > previousPrice;
    }

    public boolean isSasta() { // is cheap / went down
        return currentPrice < previousPrice;
    }

    // Getters and Setters
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getItemNameUrdu() { return itemNameUrdu; }
    public void setItemNameUrdu(String itemNameUrdu) { this.itemNameUrdu = itemNameUrdu; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getCurrentPrice() { return currentPrice; }
    public void setCurrentPrice(double currentPrice) { this.currentPrice = currentPrice; }

    public double getPreviousPrice() { return previousPrice; }
    public void setPreviousPrice(double previousPrice) { this.previousPrice = previousPrice; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public String getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; }

    public String getReasonUrdu() { return reasonUrdu; }
    public void setReasonUrdu(String reasonUrdu) { this.reasonUrdu = reasonUrdu; }

    public String getReasonEnglish() { return reasonEnglish; }
    public void setReasonEnglish(String reasonEnglish) { this.reasonEnglish = reasonEnglish; }

    public String getAlternativeUrdu() { return alternativeUrdu; }
    public void setAlternativeUrdu(String alternativeUrdu) { this.alternativeUrdu = alternativeUrdu; }

    public String getAlternativeEnglish() { return alternativeEnglish; }
    public void setAlternativeEnglish(String alternativeEnglish) { this.alternativeEnglish = alternativeEnglish; }
}
