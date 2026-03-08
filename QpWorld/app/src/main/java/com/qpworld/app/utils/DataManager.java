package com.qpworld.app.utils;

import com.qpworld.app.models.Country;
import com.qpworld.app.models.PriceItem;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    // ==================== COUNTRIES ====================
    public static List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Pakistan", "پاکستان", "PK", "PKR", "🇵🇰"));
        countries.add(new Country("India", "بھارت", "IN", "INR", "🇮🇳"));
        countries.add(new Country("Saudi Arabia", "سعودی عرب", "SA", "SAR", "🇸🇦"));
        countries.add(new Country("UAE", "یو اے ای", "AE", "AED", "🇦🇪"));
        countries.add(new Country("USA", "امریکہ", "US", "USD", "🇺🇸"));
        countries.add(new Country("UK", "برطانیہ", "GB", "GBP", "🇬🇧"));
        countries.add(new Country("China", "چین", "CN", "CNY", "🇨🇳"));
        countries.add(new Country("Turkey", "ترکی", "TR", "TRY", "🇹🇷"));
        countries.add(new Country("Bangladesh", "بنگلہ دیش", "BD", "BDT", "🇧🇩"));
        countries.add(new Country("Afghanistan", "افغانستان", "AF", "AFN", "🇦🇫"));
        return countries;
    }

    // ==================== PAKISTAN PRICES ====================
    public static List<PriceItem> getPakistanPrices() {
        List<PriceItem> items = new ArrayList<>();

        // FUEL
        items.add(new PriceItem(
                "Petrol", "پیٹرول",
                "fuel",
                289.29, 272.89,
                "PKR", "Pakistan", "PK",
                "per liter", "March 2025",
                "بین الاقوامی تیل کی قیمتوں میں اضافے اور روپے کی قدر میں کمی کی وجہ سے پیٹرول مہنگا ہوا۔",
                "Petrol prices rose due to increase in global oil prices and depreciation of the Pakistani Rupee.",
                "سفر کم کریں، کارپول استعمال کریں، الیکٹرک رکشہ استعمال کریں۔",
                "Reduce travel, use carpooling, or switch to electric rickshaw."
        ));

        items.add(new PriceItem(
                "Diesel", "ڈیزل",
                "fuel",
                282.24, 260.00,
                "PKR", "Pakistan", "PK",
                "per liter", "March 2025",
                "بین الاقوامی مارکیٹ میں خام تیل مہنگا ہوا اور حکومت نے ٹیکس بھی بڑھایا۔",
                "Crude oil prices rose internationally and government increased petroleum levy.",
                "CNG گاڑی استعمال کریں یا پبلک ٹرانسپورٹ پر منتقل ہوں۔",
                "Switch to CNG vehicle or use public transport."
        ));

        items.add(new PriceItem(
                "LPG", "ایل پی جی",
                "fuel",
                230.00, 245.00,
                "PKR", "Pakistan", "PK",
                "per kg", "March 2025",
                "سردیوں کی طلب کم ہوئی اور درآمد زیادہ ہوئی، اس لیے قیمت گھٹی۔",
                "LPG price dropped due to reduced winter demand and increased imports.",
                "LPG سستی ہے، لکڑی یا کوئلے کی بجائے LPG استعمال کریں۔",
                "LPG is now cheaper, prefer it over wood or coal for cooking."
        ));

        // FOOD
        items.add(new PriceItem(
                "Wheat Flour (Atta)", "آٹا",
                "food",
                110.00, 125.00,
                "PKR", "Pakistan", "PK",
                "per kg", "March 2025",
                "گندم کی نئی فصل آئی اور سرکاری سبسڈی بھی ملی، اس لیے آٹا سستا ہوا۔",
                "New wheat crop arrived and government subsidy helped reduce flour prices.",
                "آٹا سستا ہو گیا ہے، ذخیرہ اندوزی سے بچیں۔",
                "Flour is now affordable, avoid hoarding."
        ));

        items.add(new PriceItem(
                "Rice (Basmati)", "چاول (باسمتی)",
                "food",
                380.00, 350.00,
                "PKR", "Pakistan", "PK",
                "per kg", "March 2025",
                "برآمدات بڑھنے سے ملکی مارکیٹ میں چاول کم ہوئے اور قیمت بڑھ گئی۔",
                "Rice exports increased, reducing domestic supply and raising prices.",
                "عام چاول (IRRI) استعمال کریں جو 180-200 روپے کلو ہے۔",
                "Use regular IRRI rice which costs Rs. 180-200 per kg."
        ));

        items.add(new PriceItem(
                "Cooking Oil", "کھانے کا تیل",
                "food",
                480.00, 500.00,
                "PKR", "Pakistan", "PK",
                "per liter", "March 2025",
                "پام آئل کی بین الاقوامی قیمت گھٹی اور درآمدی ڈیوٹی کم ہوئی۔",
                "International palm oil prices fell and import duties were reduced.",
                "گھی کی بجائے کم مقدار میں تیل استعمال کریں، صحت بھی بہتر ہوگی۔",
                "Use less oil instead of ghee for health and savings."
        ));

        items.add(new PriceItem(
                "Sugar", "چینی",
                "food",
                140.00, 130.00,
                "PKR", "Pakistan", "PK",
                "per kg", "March 2025",
                "گنے کا سیزن ختم ہوا اور ذخیرہ اندوزی بڑھی، اس لیے چینی مہنگی ہوئی۔",
                "Sugar cane season ended and hoarding increased, raising sugar prices.",
                "چینی کم استعمال کریں، گڑ یا شہد صحت کے لیے بہتر متبادل ہے۔",
                "Use less sugar, jaggery or honey is a healthier alternative."
        ));

        items.add(new PriceItem(
                "Tomatoes", "ٹماٹر",
                "vegetables",
                60.00, 120.00,
                "PKR", "Pakistan", "PK",
                "per kg", "March 2025",
                "نئی فصل آئی اور موسم اچھا رہا، اس لیے ٹماٹر بہت سستے ہوگئے۔",
                "New crop arrived with good weather conditions, making tomatoes very cheap.",
                "ٹماٹر سستے ہیں، چٹنی بنا کر محفوظ کریں۔",
                "Tomatoes are cheap now, make chutney or paste for storage."
        ));

        items.add(new PriceItem(
                "Onions", "پیاز",
                "vegetables",
                80.00, 65.00,
                "PKR", "Pakistan", "PK",
                "per kg", "March 2025",
                "افغانستان سے درآمد کم ہوئی اور مقامی ذخیرہ ختم ہو رہا ہے۔",
                "Imports from Afghanistan reduced and local storage is depleting.",
                "پیاز کی جگہ لہسن یا ادرک استعمال کریں کھانوں میں۔",
                "Use garlic or ginger as an alternative flavoring in dishes."
        ));

        // ELECTRICITY & GAS
        items.add(new PriceItem(
                "Electricity", "بجلی",
                "utility",
                65.00, 50.00,
                "PKR", "Pakistan", "PK",
                "per unit (kWh)", "March 2025",
                "آئی پی پیز کے ساتھ معاہدوں کی ادائیگی اور IMF شرائط کی وجہ سے بجلی مہنگی ہوئی۔",
                "Electricity price rose due to IPP capacity payments and IMF conditions.",
                "سولر پینل لگائیں، LED بلب استعمال کریں اور غیر ضروری آلات بند رکھیں۔",
                "Install solar panels, use LED bulbs and turn off unused appliances."
        ));

        items.add(new PriceItem(
                "Gas (SNGPL)", "گیس",
                "utility",
                1800.00, 1500.00,
                "PKR", "Pakistan", "PK",
                "per MMBTU (slab 1)", "March 2025",
                "گیس کی کمی اور درآمدی LNG کی بڑھتی قیمت کی وجہ سے گیس مہنگی ہوئی۔",
                "Gas shortage and rising imported LNG prices caused gas tariff increase.",
                "LPG سلنڈر استعمال کریں یا الیکٹرک کک ٹاپ پر سوئچ کریں۔",
                "Use LPG cylinder or switch to electric cooktop."
        ));

        return items;
    }

    // ==================== INDIA PRICES ====================
    public static List<PriceItem> getIndiaPrices() {
        List<PriceItem> items = new ArrayList<>();

        items.add(new PriceItem("Petrol", "پیٹرول", "fuel",
                96.72, 94.72, "INR", "India", "IN", "per liter", "March 2025",
                "بین الاقوامی تیل کی قیمتوں میں اضافہ ہوا۔",
                "Petrol prices rose due to rise in global crude oil prices.",
                "CNG گاڑی یا الیکٹرک اسکوٹر استعمال کریں۔",
                "Use CNG vehicle or electric scooter."));

        items.add(new PriceItem("Diesel", "ڈیزل", "fuel",
                89.62, 87.00, "INR", "India", "IN", "per liter", "March 2025",
                "خام تیل کی قیمت بڑھی اور ٹیکس میں اضافہ ہوا۔",
                "Crude oil price increased and taxes were raised.",
                "پبلک ٹرانسپورٹ یا الیکٹرک گاڑی استعمال کریں۔",
                "Use public transport or electric vehicle."));

        items.add(new PriceItem("Rice", "چاول", "food",
                45.00, 40.00, "INR", "India", "IN", "per kg", "March 2025",
                "برآمدات پر پابندی اٹھائی گئی جس سے ملکی قیمت بڑھ گئی۔",
                "Export restrictions lifted causing domestic price rise.",
                "باجرا یا جوار کو متبادل کے طور پر استعمال کریں۔",
                "Use millet or sorghum as an alternative grain."));

        return items;
    }

    // ==================== UAE PRICES ====================
    public static List<PriceItem> getUaePrices() {
        List<PriceItem> items = new ArrayList<>();

        items.add(new PriceItem("Petrol (Special 95)", "پیٹرول", "fuel",
                2.89, 2.75, "AED", "UAE", "AE", "per liter", "March 2025",
                "بین الاقوامی تیل کی قیمتوں میں اضافے کی وجہ سے قیمت بڑھی۔",
                "Petrol price rose due to increase in global oil prices.",
                "میٹرو یا پبلک بس استعمال کریں۔",
                "Use Metro or public bus for commuting."));

        items.add(new PriceItem("Electricity", "بجلی", "utility",
                0.38, 0.35, "AED", "UAE", "AE", "per kWh", "March 2025",
                "گرمیوں کی آمد سے بجلی کی طلب بڑھی اور قیمت بھی بڑھی۔",
                "Electricity demand increased with approaching summer.",
                "ایئر کنڈیشنر کا ٹمپریچر 24 ڈگری پر رکھیں۔",
                "Set AC temperature to 24°C to save electricity."));

        return items;
    }

    // ==================== USA PRICES ====================
    public static List<PriceItem> getUsaPrices() {
        List<PriceItem> items = new ArrayList<>();

        items.add(new PriceItem("Gasoline", "پیٹرول", "fuel",
                3.45, 3.20, "USD", "USA", "US", "per gallon", "March 2025",
                "سردیوں کے بعد ریفائنری تبدیلیوں کی وجہ سے قیمت بڑھی۔",
                "Price rose due to refinery switchover to summer blends.",
                "کارپول کریں یا پبلک ٹرانسپورٹ استعمال کریں۔",
                "Carpool or use public transportation."));

        items.add(new PriceItem("Eggs (dozen)", "انڈے (12)", "food",
                4.25, 3.80, "USD", "USA", "US", "per dozen", "March 2025",
                "برڈ فلو کی وجہ سے مرغیاں کم ہوئیں اور انڈوں کی قیمت بڑھ گئی۔",
                "Bird flu reduced chicken population causing egg price surge.",
                "پروٹین کے لیے دالیں یا پھلیاں استعمال کریں۔",
                "Use lentils or beans as protein alternative."));

        return items;
    }

    // ==================== SAUDI ARABIA PRICES ====================
    public static List<PriceItem> getSaudiPrices() {
        List<PriceItem> items = new ArrayList<>();

        items.add(new PriceItem("Petrol (91 Octane)", "پیٹرول", "fuel",
                2.18, 2.18, "SAR", "Saudi Arabia", "SA", "per liter", "March 2025",
                "سعودی عرب میں پیٹرول کی قیمت مستحکم ہے، کوئی تبدیلی نہیں۔",
                "Petrol price in Saudi Arabia remains stable with no change.",
                "قیمت مستحکم ہے، کوئی متبادل کی ضرورت نہیں۔",
                "Price is stable, no alternative needed."));

        items.add(new PriceItem("Rice (Basmati)", "چاول (باسمتی)", "food",
                12.00, 10.50, "SAR", "Saudi Arabia", "SA", "per kg", "March 2025",
                "بھارت نے باسمتی چاول کی برآمد پر پابندی لگائی جس سے قیمت بڑھ گئی۔",
                "India imposed basmati export restrictions causing price increase.",
                "پاکستانی چاول یا مقامی چاول استعمال کریں جو سستے ہیں۔",
                "Use Pakistani rice or local rice which is cheaper."));

        return items;
    }

    // ==================== GET PRICES BY COUNTRY CODE ====================
    public static List<PriceItem> getPricesByCountry(String countryCode) {
        switch (countryCode) {
            case "PK": return getPakistanPrices();
            case "IN": return getIndiaPrices();
            case "AE": return getUaePrices();
            case "US": return getUsaPrices();
            case "SA": return getSaudiPrices();
            default:   return getPakistanPrices();
        }
    }

    // ==================== CATEGORIES ====================
    public static List<String> getCategories() {
        List<String> cats = new ArrayList<>();
        cats.add("all");
        cats.add("fuel");
        cats.add("food");
        cats.add("vegetables");
        cats.add("utility");
        return cats;
    }
}
