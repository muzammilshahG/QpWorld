# 🌍 QpWorld — قیمتوں کی دنیا

## ایپ کیا کرتی ہے؟
QpWorld ایک Android ایپ ہے جو دنیا بھر کی اشیاء (پیٹرول، ڈیزل، آٹا، چاول، بجلی وغیرہ) کی قیمتیں دکھاتی ہے۔ جب کوئی چیز مہنگی یا سستی ہو تو وجہ بتاتی ہے اور سستا متبادل بھی تجویز کرتی ہے۔

---

## 📁 فائلوں کا ڈھانچہ

```
QpWorld/
├── app/
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/qpworld/app/
│       │   ├── activities/
│       │   │   ├── SplashActivity.java       ← اوپنگ اسکرین
│       │   │   ├── MainActivity.java          ← مین اسکرین (قیمتوں کی لسٹ)
│       │   │   ├── PriceDetailActivity.java   ← تفصیلی صفحہ
│       │   │   ├── CountrySelectActivity.java ← ملک منتخب کریں
│       │   │   └── SettingsActivity.java      ← ترتیبات
│       │   ├── adapters/
│       │   │   └── PriceAdapter.java          ← RecyclerView adapter
│       │   ├── models/
│       │   │   ├── PriceItem.java             ← قیمت کا ماڈل
│       │   │   └── Country.java               ← ملک کا ماڈل
│       │   └── utils/
│       │       ├── DataManager.java           ← سارا ڈیٹا (قیمتیں)
│       │       └── PrefsManager.java          ← ترجیحات محفوظ کرنا
│       └── res/
│           ├── layout/                        ← XML ڈیزائن فائلیں
│           ├── values/                        ← رنگ، متن، styles
│           └── menu/                          ← مینو
├── build.gradle
├── settings.gradle
└── gradle.properties
```

---

## 🚀 Android Studio میں کیسے کھولیں؟

### مرحلہ 1: Android Studio ڈاؤنلوڈ کریں
- https://developer.android.com/studio سے ڈاؤنلوڈ کریں

### مرحلہ 2: پروجیکٹ کھولیں
1. Android Studio کھولیں
2. **"Open"** پر کلک کریں
3. **QpWorld** فولڈر منتخب کریں
4. **Sync Project with Gradle Files** انتظار کریں

### مرحلہ 3: APK بنائیں
1. اوپر مینو میں **Build** → **Build Bundle(s)/APK(s)** → **Build APK(s)**
2. APK یہاں ملے گی: `app/build/outputs/apk/debug/app-debug.apk`

---

## 💰 AdMob (اشتہارات) سیٹ اپ

### ابھی Test IDs استعمال ہیں:
- App ID: `ca-app-pub-3940256099942544~3347511713`
- Banner ID: `ca-app-pub-3940256099942544/6300978111`

### اصلی IDs لگانے کے لیے:
1. https://admob.google.com پر اکاؤنٹ بنائیں
2. نئی ایپ شامل کریں
3. اپنے IDs ان فائلوں میں تبدیل کریں:
   - `AndroidManifest.xml` (App ID)
   - `activity_main.xml` (Banner ID)
   - `activity_price_detail.xml` (Banner ID)
   - `strings.xml`

---

## 🌍 ممالک جن کا ڈیٹا ہے
| ملک | کرنسی | اشیاء |
|-----|--------|-------|
| 🇵🇰 پاکستان | PKR | پیٹرول، ڈیزل، LPG، آٹا، چاول، تیل، چینی، ٹماٹر، پیاز، بجلی، گیس |
| 🇮🇳 بھارت | INR | پیٹرول، ڈیزل، چاول |
| 🇦🇪 یو اے ای | AED | پیٹرول، بجلی |
| 🇺🇸 امریکہ | USD | پیٹرول، انڈے |
| 🇸🇦 سعودی عرب | SAR | پیٹرول، چاول |

---

## ➕ نئی قیمت کیسے شامل کریں؟

`DataManager.java` میں جا کر مناسب ملک کے طریقے میں نیا `PriceItem` شامل کریں:

```java
items.add(new PriceItem(
    "Item Name",           // انگریزی نام
    "آئٹم کا نام",         // اردو نام
    "food",                // category: fuel/food/vegetables/utility
    150.00,                // موجودہ قیمت
    130.00,                // پرانی قیمت
    "PKR",                 // کرنسی
    "Pakistan",            // ملک
    "PK",                  // country code
    "per kg",              // اکائی
    "March 2025",          // آخری اپڈیٹ
    "اردو میں وجہ",        // مہنگا/سستا کیوں ہوا
    "English reason",      // English reason
    "اردو متبادل",         // سستا متبادل اردو
    "English alternative"  // English alternative
));
```

---

## 🎨 رنگ تبدیل کرنے کے لیے
`res/values/colors.xml` میں جائیں:
- `colorPrimary` — ٹول بار کا رنگ
- `colorMehnga` — مہنگے کا رنگ (سرخ)
- `colorSasta` — سستے کا رنگ (سبز)

---

## 📞 مدد چاہیے؟
QpWorld کا پورا کوڈ مکمل ہے۔ Android Studio میں کھولیں اور APK بنائیں!
