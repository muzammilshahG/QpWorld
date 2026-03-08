package com.qpworld.app.models;

public class Country {
    private String name;
    private String nameUrdu;
    private String code;
    private String currency;
    private String flagEmoji;

    public Country(String name, String nameUrdu, String code, String currency, String flagEmoji) {
        this.name = name;
        this.nameUrdu = nameUrdu;
        this.code = code;
        this.currency = currency;
        this.flagEmoji = flagEmoji;
    }

    public String getName() { return name; }
    public String getNameUrdu() { return nameUrdu; }
    public String getCode() { return code; }
    public String getCurrency() { return currency; }
    public String getFlagEmoji() { return flagEmoji; }
}
