package com.apporio.demotaxiappdriver.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.Config;
import com.apporio.demotaxiappdriver.SingletonGson;
import com.apporio.demotaxiappdriver.SplashActivity;
import com.apporio.demotaxiappdriver.models.ModelAppConfiguration;

import java.util.HashMap;
import java.util.Locale;

public class SessionManager {

    private String TAG = "SessionManager";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SharedPreferences pref1;
    SharedPreferences.Editor editor1;
    SharedPreferences pref_bookingType;
    SharedPreferences.Editor editor_bookingType;


    SharedPreferences pref_DemoOrNot;
    SharedPreferences.Editor editor_DemoOrNot;

    SharedPreferences prefVehicleId;
    SharedPreferences.Editor editonVehicleId;


    public static Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LoginPrefrences";
    private static final String PREF_NAME_1 = "LanguagePrefrences";
    private static final String PREF_NAME_Vehicle = "VehicleIdPreference";
    private static final String PREF_NAME_BOOKINGTYPE = "BookingType";
    private static final String PREF_NAME_DEMO_OR_NOT = "PREF_NAME_DEMO_OR_NOT";

    private static final String IS_LOGIN = "IsLoggedIn";
    private HashMap<String, String> headers = new HashMap<>();

    public static final String KEY_DRIVER_ACCOUNT_NAME = "driver_account_name";
    public static final String KEY_DRIVER_BANK_NAME = "driver_bank_name";
    public static final String KEY_DRIVER_ACCOUNT_NUMBER = "driver_account_number";
    public static final String KEY_DRIVER_ID = "h";
    public static final String KEY_DRIVER_NAME = "driver_name";
    public static final String KEY_DRIVER_LAST_NAME = "driver__last_name";
    public static final String KEY_DRIVER_PHONE = "driver_phone_number";
    public static final String KEY_PHONE_CODE = "driver_phone_code";
    public static final String KEY_DriverEmail = "driver_email";
    public static final String KEY_DriverGender = "driver_gender";
    public static final String KEY_DriverSmokerType = "driver_smoker";
    public static final String KEY_DriverSmokerAllow = "driver_smoker_allow";
    public static final String KEY_DriverImage = "driver_image";
    public static final String KEY_DriverPassword = "driver_password";
    public static final String KEY_DriverToken = "driver_token";
    public static final String KEY_Driver_flag = "driver_flag";
    public static final String KEY_DriverVehicleId = "driver_vehicle_id";
    public static final String KEY_Driver_CarTypeId = "driver_car_type_id";
    public static final String KEY_Driver_registeration_date = "drievr_registration_date";
    public static final String KEY_Driver_login_logout = "login_logout";
    public static final String KEY_Driver_Busy_Status = "busy_status";
    public static final String KEY_ONLINE_OFFLINE = "offline_online_status";
    public static final String KEY_SIGNUP_STEP = "KEY_SIGNUP_STEP";
    public static final String KEY_AUTO_ACCEPT = "auto_accept_status";
    public static final String KEY_SUBSCRIPTION = "subscription";
    public static final String PHONE_WITHOUT_CODE = "phone_without_code";
    public static final String KEY_TAIL = "tail";
    public static final String KEY_APP_CONFIG = "countries";
    public static final String COUNTRIES = "COUNTRIES";
    public static String KEY_AREA_ID = "KEY_AREA_ID";
    public static final String KEY_AUTO_STARt_ON = "auto_start_on";

    public static final String KEY_meter_range = "meter_range";
    public static final String KEY_service_switcher = "service_switcher";
    public static final String KEY_accuracy = "KEY_accuracy";
    public static final String LANGUAGE = "Languagae";
    public static final String Currency_symbol = "currency_symbol";
    public static final String Currency_ISO_Code = "currency_iso_code";
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_STRING_VERSION = "string_version";
    public static final String COUNTRYID = "COUNTRY_ID";
    public static final String DISTANCE_UNIT = "DISTANCE_UNIT";
    public static final String DISTANCE = "DISTANCE";
    public static final String BOOKING_ID = "BOOKING_ID";
    public static final String BOOKING_TYPE = "Booking Type";

    public static final String DEMO_LOGIN_OR_NOT = "DEMO_LOGIN_OR_NOT";

    public static final String VEHICLE_ID = "VEHICLE_ID";

    public static final String TAXI_COMPANY = "TAXI_COMPANY";

    public static final String VEHICLE_ID_ONLINE = "VEHICLE_ID_ONLINE";

    public static final String KEY_LAT = "lat";
    public static final String KEY_LNG = "lng";

    private static final String KEY_SECRET = "api_secret";


    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        pref1 = _context.getSharedPreferences(PREF_NAME_1, PRIVATE_MODE);
        editor1 = pref1.edit();
        prefVehicleId = _context.getSharedPreferences(PREF_NAME_Vehicle, PRIVATE_MODE);
        editonVehicleId = prefVehicleId.edit();
        pref_bookingType = _context.getSharedPreferences(PREF_NAME_BOOKINGTYPE, PRIVATE_MODE);
        editor_bookingType = pref_bookingType.edit();

        pref_DemoOrNot = _context.getSharedPreferences(PREF_NAME_DEMO_OR_NOT, PRIVATE_MODE);
        editor_DemoOrNot = pref_DemoOrNot.edit();
    }

    public String getAppSecret() {
        try {
            return pref.getString(KEY_SECRET, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setAppSecret(String secret) {
        try {
            editor.putString(KEY_SECRET, secret);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLanguage(String locale) {
        Log.d("" + TAG, "Setting languge = " + locale);
        editor1.putString(LANGUAGE, "" + locale);
        editor1.commit();

        Locale myLocale = new Locale("" + locale);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        _context.getResources().updateConfiguration(config, _context.getResources().getDisplayMetrics());

    }


    public String getLanguage() {
        return pref1.getString(LANGUAGE, "");
    }

    public String getBookingType() {
        return pref_bookingType.getString(BOOKING_TYPE, "");
    }

    public void setBookingType(String bookingType) {
        Log.d("**" + TAG, "Booking Type = " + bookingType);
        editor_bookingType.putString(BOOKING_TYPE, "" + bookingType);
        editor_bookingType.commit();

    }

    public String getDemoOrNot() {
        return pref_DemoOrNot.getString(DEMO_LOGIN_OR_NOT, "");
    }

    public void setDemoOrNot(String demoLoginOrNot) {
        Log.d("**" + TAG, "DEMO_LOGIN_OR_NOT = " + demoLoginOrNot);
        editor_DemoOrNot.putString(DEMO_LOGIN_OR_NOT, "" + demoLoginOrNot);
        editor_DemoOrNot.commit();

    }


    public String getVehicleId() {
        return prefVehicleId.getString(VEHICLE_ID, "");
    }

    public void setVehicleId(String vehicleId) {
        Log.d("**" + TAG, "VEHICLE_ID = " + vehicleId);
        editonVehicleId.putString(VEHICLE_ID, "" + vehicleId);
        editonVehicleId.commit();

    }

    public boolean getTaxiCompany() {
        return pref.getBoolean(TAXI_COMPANY, false);
    }


    public void setTaxiCompany(Boolean value) {
        editor.putBoolean(TAXI_COMPANY, value);
        editor.commit();
    }

//    public Boolean getTaxiCompany() {
//        return pref.getBoolean(TAXI_COMPANY, false);
//    }
//
//    public void setTaxiCompany(Boolean taxiCompany) {
//        Log.d("**" + TAG, "TaxiCompany = " + taxiCompany);
//        editor.putBoolean(TAXI_COMPANY, "" + taxiCompany);
//        editor.commit();
//
//    }


    public String getVehicleIdForOnline() {
        return prefVehicleId.getString(VEHICLE_ID_ONLINE, "");
    }

    public void setVehicleIdForOnline(String vehicleId) {
        Log.d("**" + TAG, "VEHICLE_ID = " + vehicleId);
        editonVehicleId.putString(VEHICLE_ID_ONLINE, "" + vehicleId);
        editonVehicleId.commit();

    }

    public void clearBookingType() {

        editor_bookingType.clear();
        editor_bookingType.commit();
    }

    public void createNewPassword(String password) {
        editor.putString(KEY_DriverPassword, password);
        editor.commit();
    }


    public void createLoginSession(Boolean value, String DriverId, String DriverVehicleId, String DriverName, String DriverLastName, String DriverPhoneNumber, String DriverPhoneCode, String DriverEmail, String DriverGender, String DriverSmokerType, String DriverSmokerAllow, String DriverImage, String area_id, String Driver_registeration_date, String Driver_login_logout, String Driver_Busy_Status, String Driver_Online_Offline_Status, String signupStep, String Driver_Auto_Accept, String Subscription_plan, String phone_without_code) {
        editor.putBoolean(IS_LOGIN, value);
        editor.putString(KEY_DRIVER_ID, DriverId);
        editor.putString(KEY_DriverVehicleId, DriverVehicleId);
        editor.putString(KEY_DRIVER_NAME, DriverName);
        editor.putString(KEY_DRIVER_LAST_NAME, DriverLastName);
        editor.putString(KEY_DRIVER_PHONE, DriverPhoneNumber);
        editor.putString(KEY_PHONE_CODE, DriverPhoneCode);
        editor.putString(KEY_DriverEmail, DriverEmail);
        editor.putString(KEY_DriverGender, DriverGender);
        editor.putString(KEY_DriverSmokerType, DriverSmokerType);
        editor.putString(KEY_DriverSmokerAllow, DriverSmokerAllow);
        editor.putString(KEY_DriverImage, DriverImage);
        editor.putString(KEY_AREA_ID, area_id);
        editor.putString(KEY_Driver_registeration_date, Driver_registeration_date);
        editor.putString(KEY_Driver_login_logout, Driver_login_logout);
        editor.putString(KEY_Driver_Busy_Status, Driver_Busy_Status);
        editor.putString(KEY_ONLINE_OFFLINE, Driver_Online_Offline_Status);
        editor.putString(KEY_SIGNUP_STEP, signupStep);
        editor.putString(KEY_AUTO_ACCEPT, Driver_Auto_Accept);
        editor.putString(KEY_SUBSCRIPTION, Subscription_plan);
        editor.putString(PHONE_WITHOUT_CODE, phone_without_code);
        editor.commit();
    }


    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_DRIVER_ID, pref.getString(KEY_DRIVER_ID, ""));
        user.put(KEY_DriverVehicleId, pref.getString(KEY_DriverVehicleId, ""));
        user.put(KEY_DRIVER_NAME, pref.getString(KEY_DRIVER_NAME, ""));
        user.put(KEY_DRIVER_LAST_NAME, pref.getString(KEY_DRIVER_LAST_NAME, ""));
        user.put(KEY_DRIVER_PHONE, pref.getString(KEY_DRIVER_PHONE, ""));
        user.put(KEY_PHONE_CODE, pref.getString(KEY_PHONE_CODE, ""));
        user.put(KEY_DriverEmail, pref.getString(KEY_DriverEmail, ""));
        user.put(KEY_DriverGender, pref.getString(KEY_DriverGender, ""));
        user.put(KEY_DriverSmokerType, pref.getString(KEY_DriverSmokerType, ""));
        user.put(KEY_DriverSmokerAllow, pref.getString(KEY_DriverSmokerAllow, ""));
        user.put(KEY_DriverImage, pref.getString(KEY_DriverImage, ""));
        user.put(KEY_AREA_ID, pref.getString(KEY_AREA_ID, ""));
        user.put(KEY_Driver_registeration_date, pref.getString(KEY_Driver_registeration_date, ""));
        user.put(KEY_Driver_login_logout, pref.getString(KEY_Driver_login_logout, ""));
        user.put(KEY_Driver_Busy_Status, pref.getString(KEY_Driver_Busy_Status, ""));
        user.put(KEY_ONLINE_OFFLINE, pref.getString(KEY_ONLINE_OFFLINE, ""));
        user.put(KEY_SIGNUP_STEP, pref.getString(KEY_SIGNUP_STEP, ""));
        user.put(KEY_AUTO_ACCEPT, pref.getString(KEY_AUTO_ACCEPT, ""));
        user.put(KEY_SUBSCRIPTION, pref.getString(KEY_SUBSCRIPTION, ""));

        return user;
    }

    public void setAccuracy(String accuracy) {
        editor.putString(KEY_accuracy, accuracy);
        editor.commit();
    }


    public boolean isAutoStartIsOn() {
        return pref.getBoolean(KEY_AUTO_STARt_ON, false);
    }


    public void turnOnAutoStart(Boolean value) {
        editor.putBoolean(KEY_AUTO_STARt_ON, value);
        editor.commit();
    }


    public void logoutUser() {
        editonVehicleId.clear();
        editonVehicleId.commit();

        editor_DemoOrNot.clear();
        editor_DemoOrNot.commit();

        editor.clear();
        editor.commit();
    }


    public void setTailValue(String value) {
        editor.putString(KEY_TAIL, value);
        editor.commit();
    }


    public void setMeterRange(String meter_range) {
        editor.putString(KEY_meter_range, meter_range);
        editor.commit();
    }

    public void setSwitcher(String switch_val) {
        editor.putString(KEY_service_switcher, switch_val);
        editor.commit();
    }

    public void setDemoDialog(String demo) {
        editor.putString("Demo", demo);
        editor.commit();
    }

    public String getDemoDialog() {

        return pref.getString("Demo", "No name defined");
    }


    public void setSessionLocation(Double latitude, Double longitude) {
        editor.putString(KEY_LAT, String.valueOf(latitude));
        editor.putString(KEY_LNG, String.valueOf(longitude));
        editor.commit();
    }

    public HashMap<String, String> getSessionLocation() {
        HashMap<String, String> location = new HashMap<>();
        location.put(KEY_LAT, pref.getString(KEY_LAT, ""));
        location.put(KEY_LNG, pref.getString(KEY_LNG, ""));

        return location;
    }


    public void setonline_offline(boolean value) {
        Log.e("Value", "" + value);
        if (value) {
            editor.putString(KEY_ONLINE_OFFLINE, "1");
            editor.commit();
        } else if (!value) {
            editor.putString(KEY_ONLINE_OFFLINE, "2");
            editor.commit();
        }
    }

    public void setAutoAccept(boolean value) {
        if (value) {
            editor.putString(KEY_AUTO_ACCEPT, "1");
            editor.commit();
        } else if (!value) {
            editor.putString(KEY_AUTO_ACCEPT, "2");
            editor.commit();
        }
    }


    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }


    public String getCurrencyCode() {

        if (pref.getString(Currency_symbol, "").equals("0")) {
            return "" + pref.getString(Currency_ISO_Code, "ISO");
        }
        if (pref.getString(Currency_ISO_Code, "").equals("0")) {
            return "" + getSymbol();
        } else {
            return "" + getSymbol();
        }
    }


    public void setCurrencyCode(String iso_code, String symbol) {

        Log.d("" + TAG, "Setting symbol = " + symbol);
        Log.d("" + TAG, "Setting ISO = " + iso_code);
        editor.putString(Currency_ISO_Code, "" + iso_code);
        editor.putString(Currency_symbol, "" + symbol);
        editor.commit();
    }


    public String getSymbol() {
        String currency = "NA";
        Log.e("***symbol", "" + Currency_ISO_Code);
        switch (pref.getString(Currency_ISO_Code, "")) {
            case "0024":
                currency = "\u0024";
                break;
            case "00A2":
                currency = "\u00A2";
                break;
            case "00A3":
                currency = "\u00A3";
                break;
            case "00A5":
                currency = "\u00A5";
                break;
            case "058F":
                currency = "\u058F";
                break;
            case "060B":
                currency = "\u060B";
                break;
            case "09F2":
                currency = "\u09F2";
                break;
            case "20A0":
                currency = "\u20A0";
                break;
            case "20A1":
                currency = "\u20A1";
                break;
            case "20A2":
                currency = "\u20A2";
                break;
            case "20A3":
                currency = "\u20A3";
                break;
            case "20A4":
                currency = "\u20A4";
                break;
            case "20A5":
                currency = "\u20A5";
                break;
            case "20A6":
                currency = "\u20A6";
                break;
            case "20A7":
                currency = "\u20A7";
                break;
            case "20A8":
                currency = "\u20A8";
                break;
            case "20A9":
                currency = "\u20A9";
                break;
            case "20AA":
                currency = "\u20AA";
                break;
            case "20AB":
                currency = "\u20AB";
                break;
            case "20AC":
                currency = "\u20AC";
                break;
            case "20AD":
                currency = "\u20AD";
                break;
            case "20AE":
                currency = "\u20AE";
                break;
            case "20AF":
                currency = "\u20AF";
                break;
            case "20B0":
                currency = "\u20B0";
                break;
            case "20B1":
                currency = "\u20B1";
                break;
            case "20B2":
                currency = "\u20B2";
                break;
            case "20B3":
                currency = "\u20B3";
                break;
            case "20B4":
                currency = "\u20B4";
                break;
            case "20B5":
                currency = "\u20B5";
                break;
            case "20B6":
                currency = "\u20B6";
                break;
            case "20B7":
                currency = "\u20B7";
                break;
            case "20B8":
                currency = "\u20B8";
                break;
            case "20B9":
                currency = "\u20B9";
                break;
            case "20BA":
                currency = "\u20BA";
                break;
            case "20BB":
                currency = "\u20BB";
                break;
            case "20BC":
                currency = "\u20BC";
                break;
            case "20BD":
                currency = "\u20BD";
                break;
            case "20BE":
                currency = "\u20BE";
                break;
            case "20BF":
                currency = "\u20BF";
                break;
            case "A838":
                currency = "\uA838";
                break;
            case "FDFC":
                currency = "\uFDFC";
                break;
            case "FE69":
                currency = "\uFE69";
                break;
            case "FF04":
                currency = "\uFF04";
                break;
            case "FFE0":
                currency = "\uFFE0";
                break;
            case "FFE1":
                currency = "\uFFE1";
                break;
            case "FFE5":
                currency = "\uFFE5";
                break;
            case "FFE6":
                currency = "\uFFE6";
                break;
            case "00024":
                currency = "\u0024";
                break;
            case "020B9":
                currency = "\u20B9";
                break;
            default:
                currency = pref.getString(Currency_ISO_Code, "");
                break;
        }

        return currency;
    }

    @SuppressLint("LongLogTag")
    public HashMap<String, String> getHeader() throws Exception {
        headers.clear();
        if (getAccessToken() != null || !getAccessToken().equals("")) {
            headers.put("Authorization", "" + getAccessToken());
            return headers;
        } else {
            headers.put(Config.IntentKeys.PUBLIC_KEY, "" + BuildConfig.PUBLIC_KEY);
            headers.put(Config.IntentKeys.SECRET_KEY, "" + BuildConfig.SECRET_KEY);
            return headers;
        }
    }

    public void setAppConfig(String appConfig) {

        Log.d("" + TAG, "Adding countries in prefrences");
        editor.putString(KEY_APP_CONFIG, "" + appConfig);
        editor.commit();
    }


    public ModelAppConfiguration getAppConfig() {
        ModelAppConfiguration data = SingletonGson.getInstance().fromJson("" + pref.getString(KEY_APP_CONFIG, ""), ModelAppConfiguration.class);
        return data;
    }


    public void setCountries(String countries) {
        Log.d("" + TAG, "Adding countries in prefrences");
        editor.putString(COUNTRIES, "" + countries);
        editor.commit();
    }


    public ModelCountries getCountries() {
        ModelCountries data = SingletonGson.getInstance().fromJson("" + pref.getString(COUNTRIES, ""), ModelCountries.class);
        return data;
    }


    @SuppressLint("LongLogTag")
    public void setAccessToken(String accessToken) {

        editor.putString(KEY_ACCESS_TOKEN, "Bearer " + accessToken);
        editor.commit();
    }

    @SuppressLint("LongLogTag")
    public void clearAccessToken(String accessToken) {

        editor.putString(KEY_ACCESS_TOKEN, "" + accessToken);
        editor.commit();
    }

    @SuppressLint("LongLogTag")
    public void setUpdatedStringVersion(String version) {

        editor.putString(KEY_STRING_VERSION, version);
        editor.commit();
    }

    @SuppressLint("LongLogTag")
    public String getUpdateStringVersion() {
        return "" + pref.getString(KEY_STRING_VERSION, "0.0");
    }

    public String getAccessToken() {
        return "" + pref.getString(KEY_ACCESS_TOKEN, "");
    }


    public void setcountryid(int id) {
        editor.putInt(COUNTRYID, id);
        editor.commit();

    }

    public int getcountryid() {
        return pref.getInt(COUNTRYID, 1);

    }


    public void setDistanceUnit(int id) {
        editor.putInt(DISTANCE_UNIT, id);
        editor.commit();

    }

    public int getDistanceUnit() {
        return pref.getInt(DISTANCE_UNIT, 1);

    }


    public void setDistance(String value) {
        editor.putString(DISTANCE, value);
        editor.commit();

    }

    public String getDistance() {
        return pref.getString(DISTANCE, "0");
    }

    public void setBooking_Id(String booking_id) {
        editor.putString(BOOKING_ID, booking_id);
        editor.commit();

    }

    public String getbooking_Id() {
        return pref.getString(BOOKING_ID, null);
    }

}
