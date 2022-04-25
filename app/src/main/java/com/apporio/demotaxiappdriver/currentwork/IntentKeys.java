package com.apporio.demotaxiappdriver.currentwork;

public interface IntentKeys {
    String ACCESS_TOKEN = "ACCESS_TOKEN";
    String AREA_ID = "AREA_ID";
    String DRIVER_ID = "DRIVER_ID";
    String DOCUMENT_ID = "DOCUMENT_ID";
    String DRIVER_VEHICLE_ID = "DRIVER_VEHICLE_ID";
    String DOCUMENT_TYPE = "DOCUMENT_TYPE";
    String VERIFIER_TYPE = "VERIFIER_TYPE";
    String VERIFIER_MODE = "VERIFIER_MODE";
    String EMAIL = "EMAIL";
    String SCRIPT = "SCRIPT";
    String NAVIGATION = "NAVIGATION";  //1:- OneSignal  //2:- From API
    String BOOKING_ID = "BOOKING_ID";
    String TOP_UP_AMOUNT = "TOP_UP_AMOUNT";
    String IMAGE = "IMAGE";
    String METER_VALUE = "METER_VALUE";
    String STATUS = "STATUS";
    String USER_IMAGE = "USER_IMAGE";
    String USER_NAME = "USER_NAME";
    String EXPIRY_DATE = "EXPIRY_DATE";

    String LATITUDE = "LATITUDE";
    String LONGITUDE = "LONGITUDE";
    String ADDRESS_NAME = "ADDRESS_NAME";


    String SOS_ID = "SOS_ID";
    String SOS_NAMES = "SOS_NAMES";
    String SOS_NUMBERS = "SOS_NUMBERS";
    String PHONE = "PHONE";

    String DATE = "DATE";
    String ADDRESS = "ADDRESS";
    String BANK_NAME = "BANK_NAME";
    String BANK_HOLDER_NAME = "BANK_HOLDER_NAME";
    String BANK_ACCOUNT_NUMBER = "BANK_ACCOUNT_NUMBER";
    String IFSC_CODE = "IFSC_CODE";
    String IFSC_VISIBILITY = "IFSC_VISIBILITY";
    String IFSC_PLACEHOLDER = "IFSC_PLACEHOLDER";
    String HOME_LOCATION_ACTIVE_STATUS = "HOME_LOCATION_ACTIVE_STATUS";

    String AUTO_UPGRADATION = "AUTO_UPGRADATION";

    String POOL_RIDE_ACTIVATE = "POOL_RIDE_ACTIVATE";

    String AUTO_UPGRADATION_SHOW = "AUTO_UPGRADATION_SHOW";

    String POOL_RIDE_ACTIVATE_SHOW = "POOL_RIDE_ACTIVATE_SHOW";


    // emit events for Sockets
    String DRIVER_CONNECTION ="driverConnection";
    String SAVE_DRIVER_LAT_LONG = "saveDriverLatLong";
    String SAVE_DRIVER_TRACKING = "saveDriverTracking";
    String bookingCoordinatePhp = "bookingCoordinatePhp";

    // listen events sockets
    String DRIVER_CONNECTED= "DriverConnected";
    String DRIVER_LOCATION_SAVED= "driverLatLongSaved";
    String DRIVER_TRACKING_SAVED= "19";

}

