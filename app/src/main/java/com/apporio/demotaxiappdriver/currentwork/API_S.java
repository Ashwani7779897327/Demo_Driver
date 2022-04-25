package com.apporio.demotaxiappdriver.currentwork;

import com.apporio.demotaxiappdriver.BuildConfig;

import java.io.StringReader;

public class API_S {
    public interface Endpoints {
        String APP_CONFIGURATIONS = BuildConfig.BASE_URL + "api/driver/configuration";
        String SET_STRING = BuildConfig.BASE_URL + "api/user/getString";
        String REGISTER_DRIVER = BuildConfig.BASE_URL + "api/driver/firtstep";
        String LOGIN = BuildConfig.BASE_URL + "api/driver/login";
        String DEMO_LOGIN = BuildConfig.BASE_URL + "api/driver/demo";
        String DRIVER_DETAILS = BuildConfig.BASE_URL + "api/driver/driverData";
        String VEHICLE_CONFIGURATION = BuildConfig.BASE_URL + "api/driver/vehicleconfiguration";
        String VEHICLE_MODEL = BuildConfig.BASE_URL + "api/driver/vehiclemodel";
        String ADD_VEHICLE = BuildConfig.BASE_URL + "api/driver/addvehicle";
        String DRIVER_DOCUMENT = BuildConfig.BASE_URL + "api/driver/documentlist";
        String DRIVER_DOCUMENT_INTERNAL = BuildConfig.BASE_URL + "api/driver/vehicledocumentlist";
        String UPLOAD_DRIVER_DOCUMENT = BuildConfig.BASE_URL + "api/driver/adddocument";
        String UPLOAD_VEHICLE_DOCUMENT = BuildConfig.BASE_URL + "api/driver/addvehicledocument";
        //String DRIVER_VEHICLES = BuildConfig.BASE_URL + "api/driver/vehicles";
        String DRIVER_VEHICLES = BuildConfig.BASE_URL + "api/driver/allVehicles";
        String OTP = BuildConfig.BASE_URL + "api/driver/otp";
        String LOGOUT = BuildConfig.BASE_URL + "api/driver/logout";
        //String ACTIVATE_VEHICLE = BuildConfig.BASE_URL + "api/driver/active_vehicle";
        String ACTIVATE_VEHICLE = BuildConfig.BASE_URL + "api/driver/changeVehicle";
        String DRIVER_LOCATION_UPDATER = BuildConfig.BASE_URL + "api/driver/location";
        String ONLINE_OFFLINE = BuildConfig.BASE_URL + "api/driver/online/offline";
        String AUTO_ACCEPT = BuildConfig.BASE_URL + "api/driver/auto_accept_mode";
        String AUTO_UPGRADE = BuildConfig.BASE_URL + "api/driver/auto-upgrade";
        String ACTIVE_POOL = BuildConfig.BASE_URL + "api/driver/pool/active/deactive";
        String CHANGE_PASSWORD = BuildConfig.BASE_URL + "api/driver/changepassword";
        String FORGOT_PASSWORD = BuildConfig.BASE_URL + "api/driver/forgotpassword";
        String SERVER_TIMESTAMP = BuildConfig.BASE_URL + "api/time";
        String RIDE_INFO = BuildConfig.BASE_URL + "api/driver/bookings/detail";
        String ACTIVE_RIDE = BuildConfig.BASE_URL + "api/driver/booking/active";
        String MANUAL_BOOKING = BuildConfig.BASE_URL + "api/driver/manual/booking";
        String CHECK_DROP_AREA = BuildConfig.BASE_URL + "api/driver/check-droplocation/area";
        String ACCEPT_RIDE = BuildConfig.BASE_URL + "api/driver/bookings/accept";
        String PARTIAL_ACCEPT = BuildConfig.BASE_URL + "api/driver/bookings/partial_accept";
        String ARRIVE_RIDE = BuildConfig.BASE_URL + "api/driver/bookings/arrive";
        String START_RIDE = BuildConfig.BASE_URL + "api/driver/bookings/start";
        String REACHED_STOP = BuildConfig.BASE_URL + "api/driver/bookings/reach";
        String END_RIDE = BuildConfig.BASE_URL + "api/driver/bookings/end";
        String TRACK_RIDE = BuildConfig.BASE_URL + "api/driver/booking/tracking";
        String CANCEL_RIDE = BuildConfig.BASE_URL + "api/driver/bookings/cancel";
        String REJECT_RIDE = BuildConfig.BASE_URL + "api/driver/bookings/reject";
        String NEW_REQUESTS = BuildConfig.BASE_URL + "api/driver/booking/history/upcomming";
        String DELIVERY_UPCOMING = BuildConfig.BASE_URL +"api/driver/booking/history/upcomming/delivery";
        String NEW_OUTSTATION_UPCOMING = BuildConfig.BASE_URL + "api/driver/booking/history/upcomming/outstation";
        String REVERSE_GEOCODE = BuildConfig.BASE_URL + "api/driver/getlocationfromLatlong";

        String RIDE_HISTORY_ACTIVE = BuildConfig.BASE_URL + "api/driver/booking/history/active";
        String RIDE_HISTORY_SCHEDULE = BuildConfig.BASE_URL + "api/driver/booking/history/schedule";
        String RIDE_HISTORY_PAST = BuildConfig.BASE_URL + "api/driver/booking/history/past";
        String TRIP_SPECIFIC_DETAIL = BuildConfig.BASE_URL + "api/driver/booking/history/detail";
        String DEMAND_SPOT = BuildConfig.BASE_URL + "api/driver/demandspot";
        String SUPER_DRIVER = BuildConfig.BASE_URL + "api/driver/getSuperDrivers";
        String SUBSCRIPTION_LIST = BuildConfig.BASE_URL + "api/driver/view-subscription-packages";

        String ACTIVATE_PACKAGE = BuildConfig.BASE_URL + "api/driver/view-subscription-packages";


        String REQUEST_FOR_VEHICLE = BuildConfig.BASE_URL + "api/driver/vehicleRequest";
        String MATCH_VEHICLE_OTP = BuildConfig.BASE_URL + "api/driver/vehicle/otp";

        //     String RECEIPT = "http://atulpratise.getsandbox.com/receipt";
        String RECEIPT = BuildConfig.BASE_URL + "api/driver/receipt";
        String RIDE_CLOSE = BuildConfig.BASE_URL + "api/driver/bookings/close";

        String TIME_STAMP = BuildConfig.BASE_URL + "api/driver/timeStamp";

       // String TIME_STAMP = BuildConfig.BASE_URL + "api/time";


        String PROMOTIONAL_NOTIFICATION = BuildConfig.BASE_URL + "api/driver/promotion/notification";
        String CHANGE_ADDRESS = BuildConfig.BASE_URL + "api/driver/booking/change_address";
        String SOS_REQUEST = BuildConfig.BASE_URL + "api/driver/sos/request";
        String CMS_PAGES = BuildConfig.BASE_URL + "api/driver/cms/pages";
        String WALLET_BALANCE = BuildConfig.BASE_URL + "api/driver/wallet/transaction";
        String VIEW_CARDS = BuildConfig.BASE_URL + "api/driver/cards";
        String ADD_MONEY_IN_WALLET = BuildConfig.BASE_URL + "api/driver/wallet/addMoney";
        //     String EARNING = "http://atulpratise.getsandbox.com/driver_earning";
        String EARNING = BuildConfig.BASE_URL + "api/driver/earnings";
        String NEW_EARNING = BuildConfig.BASE_URL + "api/driver/earnings_revised";
        //     String MAIN_SCREEN = "http://atulpratise.getsandbox.com/driver_main_screen";
        String MAIN_SCREEN = BuildConfig.BASE_URL + "api/driver/main/screen";

        String VIEW_CHAT = BuildConfig.BASE_URL + "api/driver/chat";
        String SEND_CHAT_MESSAGE = BuildConfig.BASE_URL + "api/driver/chat/send_message";
        //     String WEEKLY_STATEMENTS = "http://atulpratise.getsandbox.com/weeklyEarning";
        String WEEKLY_STATEMENTS = BuildConfig.BASE_URL + "api/driver/earning/details";

        //     String DAILY_STATEMENT = "http://atulpratise.getsandbox.com/daily_earning";
        String DAILY_STATEMENT = BuildConfig.BASE_URL + "api/driver/earnings/singleDay";
        String VIEW_PERSONAL_DOCUMENT = BuildConfig.BASE_URL + "api/driver/personal/documentlist";
        String VIEW_EXPIRY_DOCUMENT = BuildConfig.BASE_URL + "api/driver/expiredocuments";
        String ADD_HOME_ADRESS = BuildConfig.BASE_URL + "api/driver/add/homeaddress";
        String ADDRESS_LIST = BuildConfig.BASE_URL + "api/driver/homeaddress";
        String SELECT_HOME_ADDRESS = BuildConfig.BASE_URL + "api/driver/select/homelocation";
        String ACTIVE_DEACTIVE_HOME_ADDRESS = BuildConfig.BASE_URL + "api/driver/active/deactive/homelocation";
        String DELETE_HOME_ADDRESS = BuildConfig.BASE_URL + "api/driver/delete/homelocation";
        String EDIT_PROFILE = BuildConfig.BASE_URL + "api/driver/edit-profile";
        String SAVE_BANK_DETAILS = BuildConfig.BASE_URL + "api/driver/bankdetails";
        String RATE_USER = BuildConfig.BASE_URL + "api/driver/booking/rate/user";
        String CASH_COLLECTION = BuildConfig.BASE_URL + "api/driver/ride-payment-status";
        String CUSTOMER_SUPPORT = BuildConfig.BASE_URL + "api/driver/customer_support";
        String GOOGLE_STATIC_MAP_API = "https://maps.googleapis.com/maps/api/staticmap?";
        String CANCLE_REASION = BuildConfig.BASE_URL + "api/driver/cancelReasons";
        String SEND_STRIPE_TOKEN = BuildConfig.BASE_URL + "api/driver/savecards";
        String DELETE_CARD = BuildConfig.BASE_URL + "api/driver/Deletecards";
        String MAKE_PAYMENT_WITH_CARD = BuildConfig.BASE_URL + "api/driver/makePayment";
        String RIDE_START_OTP = BuildConfig.BASE_URL + "api/driver/booking/otp_verify";
        String Paytm_checksum = "http://apporio.org/paytm/paytm.php";
        String driver_rating = BuildConfig.BASE_URL + "api/driver/AverageRating";
        String terms_and_conditions = BuildConfig.BASE_URL + "api/driver/updateTerms";
        String REFER_AND_EARN = BuildConfig.BASE_URL + "api/driver/refer_driver";

        String DRIVER_LIMIT_API = BuildConfig.BASE_URL + "api/driver/limit-driver";
        String CHECK_ESTIMATE_URL = BuildConfig.BASE_URL + "api/driver/manual_dispatch_estimate";
        String checkoutBooking_url = BuildConfig.BASE_URL + "api/driver/manual/checkoutBooking";

        String ACTIVE_SUBSCRIPTION = BuildConfig.BASE_URL + "api/driver/activate-subscription-package";

        String EMERGENCY_CONTACT_LIST = BuildConfig.BASE_URL + "api/driver/sos";
        String DELETE_EMERGENCY_CONTACT = BuildConfig.BASE_URL + "api/driver/sos/distory";
        String ADD_EMERGENCY_CONTACT = BuildConfig.BASE_URL + "api/driver/sos/create";
        String ACCOUNT_TYPE_API = BuildConfig.BASE_URL + "api/driver/account-types";

        String GOOGLE_PLACE_PICKER = "https://maps.googleapis.com/maps/api/place/autocomplete/json";
        String GOOGLE_PLACE_MainAPICKER = "https://maps.googleapis.com/maps/api/place/autocomplete/json";
        String GOOGLE_PLACE_ID_RESPONSE = "https://maps.googleapis.com/maps/api/place/details/json?placeid=";
        String MERCADO_PREFRENCE_ID = BuildConfig.BASE_URL + "api/driver/creatPrefId";
        String BANCARD_URL = BuildConfig.BASE_URL +  "api/driver/BancardCheckout";


    }

    public interface Tags {
        String APP_CONFIGURATIONS = "APP_CONFIGURATIONS";
        String SET_STRING = "SET_STRING";
        String REGISTER_DRIVER = "REGISTER_DRIVER";
        String REQUEST_FOR_VEHICLE = "REQUEST_FOR_VEHICLE";
        String MATCH_VEHICLE_OTP = "MATCH_VEHICLE_OTP";
        String LOGIN = "LOGIN";
        String DEMO_LOGIN = "DEMO_LOGIN";
        String DRIVER_DETAILS = "DRIVER_DETAILS";
        String VEHICLE_CONFIGURATION = "VEHICLE_CONFIGURATION";
        String VEHICLE_MODEL = "VEHICLE_MODEL";
        String ADD_VEHICLE = "ADD_VEHICLE";
        String DRIVER_DOCUMENT = "DRIVER_DOCUMENT";
        String DRIVER_DOCUMENT_INTERNAL = "DRIVER_DOCUMENT_INTERNAL";
        String UPLOAD_DRIVER_DOCUMENT = "UPLOAD_DRIVER_DOCUMENT";
        String UPLOAD_VEHICLE_DOCUMENT = "UPLOAD_VEHICLE_DOCUMENT";
        String DRIVER_VEHICLES = "DRIVER_VEHICLES";
        String OTP = "OTP";
        String LOGOUT = "LOGOUT";
        String ACTIVATE_VEHICLE = "ACTIVATE_VEHICLE";
        String DRIVER_LOCATION_UPDATER = "DRIVER_LOCATION_UPDATER";
        String ONLINE_OFFLINE = "ONLINE_OFFLINE";
        String AUTO_ACCEPT = "AUTO_ACCEPT";
        String AUTO_UPGRADE = "AUTO_UPGRADE";
        String ACTIVE_POOL = "ACTIVE_POOL";
        String CHANGE_PASSWORD = "CHANGE_PASSWORD";
        String FORGOT_PASSWORD = "FORGOT_PASSWORD";
        String SERVER_TIMESTAMP = "SERVER_TIMESTAMP";
        String RIDE_INFO = "RIDE_INFO";
        String ACCEPT_RIDE = "ACCEPT_RIDE";
        String PARTIAL_ACCEPT = "PARTIAL_ACCEPT";
        String ARRIVE_RIDE = "ARRIVE_RIDE";
        String START_RIDE = "START_RIDE";
        String REACHED_STOP = "REACHED_pi/timeSTOP";
        String MANUAL_BOOKING = "MANUAL_BOOKING";
        String CHECK_DROP_AREA = "CHECK_DROP_AREA";
        String END_RIDE = "END_RIDE";
        String TRACK_RIDE = "TRACK_RIDE";
        String RIDE_HISTORY = "RIDE_HISTORY";
        String ACTIVE_RIDE = "ACTIVE_RIDE";
        String CANCEL_RIDE = "CANCEL_RIDE";
        String CANCEL_REASION = "CANCEL_REASION";
        String RIDE_HISTORY_ACTIVE = "RIDE_HISTORY_ACTIVE";
        String TRIP_SPECIFIC_DETAIL = "TRIP_SPECIFIC_DETAIL";
        String RIDE_HISTORY_PAST = "RIDE_HISTORY_PAST";
        String RECEIPT = "RECEIPT";
        String DEMAND_SPOT = "DEMAND_SPOT";
        String PROMOTIONAL_NOTIFICATION = "PROMOTIONAL_NOTIFICATION";
        String SOS_REQUEST = "SOS_REQUEST";
        String CHANGE_ADDRESS = "CHANGE_ADDRESS";
        String CMS_PAGES = "CMS_PAGES";
        String WALLET_BALANCE = "WALLET_BALANCE";
        String VIEW_CARDS = "VIEW_CARDS";
        String ADD_MONEY_IN_WALLET = "ADD_MONEY_IN_WALLET";
        String EARNING = "EARNING";
        String NEW_EARNING = "NEW_EARNING";
        String MAIN_SCREEN = "MAIN_SCREEN";
        String RIDE_CLOSE = "RIDE_CLOSE";
        String CURRENT_TIMESTAMP = "CURRENT_TIMESTAMP";
        String VIEW_CHAT = "VIEW_CHAT";
        String SEND_CHAT_MESSAGE = "SEND_CHAT_MESSAGE";
        String REJECT_RIDE = "REJECT_RIDE";
        String NEW_REQUESTS = "NEW_REQUESTS";
        String DELIVERY_UPCOMING = "DELIVERY_UPCOMING";
        String NEW_UPCOMING_OUSTATIONS = "NEW_UPCOMING_OUSTATIONS";
        String CHECK_RIDE_TIME = "NEW_UPCOMING_OUSTATIONS";
        String RIDE_HISTORY_SCHEDULE = "RIDE_HISTORY_SCHEDULE";
        String LOAD_MORE_TRANSACTION = "LOAD_MORE_TRANSACTION";
        String WEEKLY_STATEMENTS = "WEEKLY_STATEMENTS";
        String DAILY_STATEMENT = "DAILY_STATEMENT";
        String VIEW_PERSONAL_DOCUMENT = "VIEW_PERSONAL_DOCUMENT";
        String VIEW_EXPIRY_DOCUMENT = "VIEW_EXPIRY_DOCUMENT";
        String ADD_HOME_ADRESS = "ADD_HOME_ADRESS";
        String ADDRESS_LIST = "ADDRESS_LIST";
        String ACTIVE_DEACTIVE_HOME_ADDRESS = "ACTIVE_DEACTIVE_HOME_ADDRESS";
        String DELETE_HOME_ADDRESS = "DELETE_HOME_ADDRESS";
        String EDIT_PROFILE = "EDIT_PROFILE";
        String SELECT_HOME_ADDRESS = "SELECT_HOME_ADDRESS";
        String SAVE_BANK_DETAILS = "SAVE_BANK_DETAILS";
        String RATE_USER = "RATE_USER";
        String CASH_COLLECTION = "CASH_COLLECTION";
        String CUSTOMER_SUPPORT = "CUSTOMER_SUPPORT";
        String REVERSE_GEOCODE = "REVERSE_GEOCODE";
        String SEND_STRIPE_TOKEN = "SEND_STRIPE_TOKEN";
        String DELETE_CARD = "DELETE_CARD";
        String MAKE_PAYMENT_WITH_CARD = "MAKE_PAYMENT_WITH_CARD";
        String RIDE_START_OTP = "ride_start_otp";
        String PAYTM_CHECKSUM = "Paytm";
        String SUPER_DRIVER = "Super_driver";
        String DRIVER_RATING = "driver_rating";
        String TERMS_AND_CONDITIONS = "terms_and_conditions";
        String REFER_AND_EARN = "REFER_AND_EARN";
        String DRIVER_LIMIT = "DRIVER LIMIT";

        String CHECK_ESTIMATE_TAG = "CHECK_ESTIMATE_TAG";
        String MANUAL_DETAILS_CHECKOUT = "MANUAL_DETAILS_CHECKOUT";
        String SUBSCRIPTION_LIST = "SUBSCRIPTION_LIST";
        String ACTIVATE_PACKAGE = "ACTIVATE_PACKAGE";
        String ACTIVE_SUBSCRIPTION = "ACTIVE_SUBSCRIPTION";
        String EMERGENCY_CONTACT_LIST = "EMERGENCY_CONTACT_LIST";
        String DELETE_EMERGENCY_CONTACT = "DELETE_EMERGENCY_CONTACT";
        String ADD_EMERGENCY_CONTACT = "ADD_EMERGENCY_CONTACT";
        String ACCOUNT_TYPE = "ACCOUNT_TYPE";
        String MERCADO_PREFRENCE_ID = "MERCADO_PREFRENCE_ID";
        String BANCARD_URL = "BANCARD_URL";


        String GOOGLE_PLACE_PICKER = "GOOGLE_PLACE_PICKER";

    }
}
