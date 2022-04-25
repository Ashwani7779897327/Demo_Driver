package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelAppConfiguration {


    /**
     * data : {"countries":[{"id":4,"merchant_id":2,"isoCode":"INR","phonecode":"+91","distance_unit":1,"default_language":"en","maxNumPhone":10,"minNumPhone":10,"country_status":1,"created_at":"2019-02-23 12:44:21","updated_at":"2019-02-25 09:25:48","name":"India","country_area":[{"id":3,"merchant_id":2,"country_id":"4","AreaCoordinates":"[{\"latitude\":\"28.438482470938308\",\"longitude\":\"76.80967473398528\"},{\"latitude\":\"28.351501403189985\",\"longitude\":\"76.81242131601653\"},{\"latitude\":\"28.327931752619012\",\"longitude\":\"77.04313420664153\"},{\"latitude\":\"28.350897118504516\",\"longitude\":\"77.13308476816496\"},{\"latitude\":\"28.446935154795593\",\"longitude\":\"77.17840337168059\"},{\"latitude\":\"28.508498596520255\",\"longitude\":\"77.10287236582121\"},{\"latitude\":\"28.529615034860367\",\"longitude\":\"76.94700383554778\"},{\"latitude\":\"28.48737793029043\",\"longitude\":\"76.80486821543059\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":null,"pool_postion":2,"status":1,"created_at":"2019-02-23 13:02:42","updated_at":"2019-02-23 13:02:42","AreaName":"Gurugram"},{"id":23,"merchant_id":2,"country_id":"4","AreaCoordinates":"[{\"latitude\":\"18.668812985897393\",\"longitude\":\"73.84633672902214\"},{\"latitude\":\"18.670114015737603\",\"longitude\":\"73.75569952199089\"},{\"latitude\":\"18.670114015737603\",\"longitude\":\"73.70900762745964\"},{\"latitude\":\"18.59984413508932\",\"longitude\":\"73.59227789113152\"},{\"latitude\":\"18.537357657678545\",\"longitude\":\"73.49065435597527\"},{\"latitude\":\"18.358885328742776\",\"longitude\":\"73.45220220753777\"},{\"latitude\":\"18.276752028560736\",\"longitude\":\"73.61562383839714\"},{\"latitude\":\"18.293703360417908\",\"longitude\":\"73.71450079152214\"},{\"latitude\":\"18.267623702116836\",\"longitude\":\"73.79552496144402\"},{\"latitude\":\"18.263711415235843\",\"longitude\":\"73.84359014699089\"},{\"latitude\":\"18.261103175001733\",\"longitude\":\"73.92324102589714\"},{\"latitude\":\"18.28587987471443\",\"longitude\":\"73.95894659230339\"},{\"latitude\":\"18.338029771684685\",\"longitude\":\"74.01937139699089\"},{\"latitude\":\"18.386254424268042\",\"longitude\":\"74.12511480519402\"},{\"latitude\":\"18.483965686882513\",\"longitude\":\"74.13472784230339\"},{\"latitude\":\"18.564698308236846\",\"longitude\":\"73.93972051808464\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":null,"pool_postion":1,"status":1,"created_at":"2019-03-01 06:51:01","updated_at":"2019-03-01 06:51:01","AreaName":"Pune"}]},{"id":22,"merchant_id":2,"isoCode":"CAD","phonecode":"+1","distance_unit":1,"default_language":"en","maxNumPhone":12,"minNumPhone":2,"country_status":2,"created_at":"2019-02-28 07:15:06","updated_at":"2019-03-01 06:40:16","name":"Canada","country_area":[]}],"navigation_drawer":{"language":true,"customer_support":true,"report_issue":true,"cms_page":true,"wallet":false},"register":{"smoker":true,"email":true,"phone":true,"gender":true},"general_config":{"manual_dispatch":false,"demo":false,"default_language":"en","driver_wallet_package":[{"amount":"100"},{"amount":"200"},{"amount":"300"}],"chat":true,"splash_screen":"Apporio Taxi","vehicle_owner":false,"enable_super_driver":true},"languages":[{"id":1,"name":"English","locale":"en","created_at":"2018-05-27 21:30:00","updated_at":"2018-05-28 00:30:00"},{"id":3,"name":"Spanish","locale":"sp","created_at":"2018-09-29 00:00:00","updated_at":"2018-09-29 00:00:00"}],"customer_support":{"mail":"apporio@gmail.com","phone":"9090909090"},"paymentOption":[{"id":1,"slug":"STRIPE","name":"Stripe","created_at":"2018-12-10 18:30:00","updated_at":"2018-12-10 18:30:00"}],"app_version_dialog":{"show_dialog":false,"mandatory":true,"dialog_message":"Application is Update to date"},"app_maintainance":{"show_dialog":false,"show_message":""},"ride_config":{"outstation":true,"location_update_timeband":"5","tracking_screen_refresh_timeband":null,"slide_button":true},"tracking":{"scroll":true},"receiving":{"drop_point":true,"estimate_fare":true},"login":{"email":false,"phone":true},"theme_cofig":{"primary_color_driver":"#4080bf","chat_button_color_driver":"#44bb77","share_button_color_driver":"#ffff00","call_button_color_driver":"#ffff00","cancel_button_color_driver":"#ffff00"}}
     * result : 1
     * message : Application Configuration
     */

    private DataBean data;
    private String result;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * countries : [{"id":4,"merchant_id":2,"isoCode":"INR","phonecode":"+91","distance_unit":1,"default_language":"en","maxNumPhone":10,"minNumPhone":10,"country_status":1,"created_at":"2019-02-23 12:44:21","updated_at":"2019-02-25 09:25:48","name":"India","country_area":[{"id":3,"merchant_id":2,"country_id":"4","AreaCoordinates":"[{\"latitude\":\"28.438482470938308\",\"longitude\":\"76.80967473398528\"},{\"latitude\":\"28.351501403189985\",\"longitude\":\"76.81242131601653\"},{\"latitude\":\"28.327931752619012\",\"longitude\":\"77.04313420664153\"},{\"latitude\":\"28.350897118504516\",\"longitude\":\"77.13308476816496\"},{\"latitude\":\"28.446935154795593\",\"longitude\":\"77.17840337168059\"},{\"latitude\":\"28.508498596520255\",\"longitude\":\"77.10287236582121\"},{\"latitude\":\"28.529615034860367\",\"longitude\":\"76.94700383554778\"},{\"latitude\":\"28.48737793029043\",\"longitude\":\"76.80486821543059\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":null,"pool_postion":2,"status":1,"created_at":"2019-02-23 13:02:42","updated_at":"2019-02-23 13:02:42","AreaName":"Gurugram"},{"id":23,"merchant_id":2,"country_id":"4","AreaCoordinates":"[{\"latitude\":\"18.668812985897393\",\"longitude\":\"73.84633672902214\"},{\"latitude\":\"18.670114015737603\",\"longitude\":\"73.75569952199089\"},{\"latitude\":\"18.670114015737603\",\"longitude\":\"73.70900762745964\"},{\"latitude\":\"18.59984413508932\",\"longitude\":\"73.59227789113152\"},{\"latitude\":\"18.537357657678545\",\"longitude\":\"73.49065435597527\"},{\"latitude\":\"18.358885328742776\",\"longitude\":\"73.45220220753777\"},{\"latitude\":\"18.276752028560736\",\"longitude\":\"73.61562383839714\"},{\"latitude\":\"18.293703360417908\",\"longitude\":\"73.71450079152214\"},{\"latitude\":\"18.267623702116836\",\"longitude\":\"73.79552496144402\"},{\"latitude\":\"18.263711415235843\",\"longitude\":\"73.84359014699089\"},{\"latitude\":\"18.261103175001733\",\"longitude\":\"73.92324102589714\"},{\"latitude\":\"18.28587987471443\",\"longitude\":\"73.95894659230339\"},{\"latitude\":\"18.338029771684685\",\"longitude\":\"74.01937139699089\"},{\"latitude\":\"18.386254424268042\",\"longitude\":\"74.12511480519402\"},{\"latitude\":\"18.483965686882513\",\"longitude\":\"74.13472784230339\"},{\"latitude\":\"18.564698308236846\",\"longitude\":\"73.93972051808464\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":null,"pool_postion":1,"status":1,"created_at":"2019-03-01 06:51:01","updated_at":"2019-03-01 06:51:01","AreaName":"Pune"}]},{"id":22,"merchant_id":2,"isoCode":"CAD","phonecode":"+1","distance_unit":1,"default_language":"en","maxNumPhone":12,"minNumPhone":2,"country_status":2,"created_at":"2019-02-28 07:15:06","updated_at":"2019-03-01 06:40:16","name":"Canada","country_area":[]}]
         * navigation_drawer : {"language":true,"customer_support":true,"report_issue":true,"cms_page":true,"wallet":false}
         * register : {"smoker":true,"email":true,"phone":true,"gender":true}
         * general_config : {"manual_dispatch":false,"demo":false,"default_language":"en","driver_wallet_package":[{"amount":"100"},{"amount":"200"},{"amount":"300"}],"chat":true,"splash_screen":"Apporio Taxi","vehicle_owner":false,"enable_super_driver":true}
         * languages : [{"id":1,"name":"English","locale":"en","created_at":"2018-05-27 21:30:00","updated_at":"2018-05-28 00:30:00"},{"id":3,"name":"Spanish","locale":"sp","created_at":"2018-09-29 00:00:00","updated_at":"2018-09-29 00:00:00"}]
         * customer_support : {"mail":"apporio@gmail.com","phone":"9090909090"}
         * paymentOption : [{"id":1,"slug":"STRIPE","name":"Stripe","created_at":"2018-12-10 18:30:00","updated_at":"2018-12-10 18:30:00"}]
         * app_version_dialog : {"show_dialog":false,"mandatory":true,"dialog_message":"Application is Update to date"}
         * app_maintainance : {"show_dialog":false,"show_message":""}
         * ride_config : {"outstation":true,"location_update_timeband":"5","tracking_screen_refresh_timeband":null,"slide_button":true}
         * tracking : {"scroll":true}
         * receiving : {"drop_point":true,"estimate_fare":true}
         * login : {"email":false,"phone":true}
         * theme_cofig : {"primary_color_driver":"#4080bf","chat_button_color_driver":"#44bb77","share_button_color_driver":"#ffff00","call_button_color_driver":"#ffff00","cancel_button_color_driver":"#ffff00"}
         *driver_commission_choices
         */

        private NavigationDrawerBean navigation_drawer;
        private RegisterBean register;
        private GeneralConfigBean general_config;
        private CustomerSupportBean customer_support;
        private AppVersionDialogBean app_version_dialog;
        private AppMaintainanceBean app_maintainance;
        private RideConfigBean ride_config;
        private TrackingBean tracking;
        private ReceivingBean receiving;
        private LoginBean login;
        private ThemeCofigBean theme_cofig;
        private List<CountriesBean> countries;
        private List<LanguagesBean> languages;
        private List<SegmentsBean> segments;

        public List<SegmentsBean> getSegments() {
            return segments;
        }

        public void setSegments(List<SegmentsBean> segments) {
            this.segments = segments;
        }

        private List<PaymentOptionBean> paymentOption;
        private List<DriverCommissionChoicesBean> driver_commission_choices;

        public List<DriverCommissionChoicesBean> getDriver_commission_choices() {
            return driver_commission_choices;
        }

        public void setDriver_commission_choices(List<DriverCommissionChoicesBean> driver_commission_choices) {
            this.driver_commission_choices = driver_commission_choices;
        }

        public NavigationDrawerBean getNavigation_drawer() {
            return navigation_drawer;
        }

        public void setNavigation_drawer(NavigationDrawerBean navigation_drawer) {
            this.navigation_drawer = navigation_drawer;
        }

        public RegisterBean getRegister() {
            return register;
        }

        public void setRegister(RegisterBean register) {
            this.register = register;
        }

        public GeneralConfigBean getGeneral_config() {
            return general_config;
        }

        public void setGeneral_config(GeneralConfigBean general_config) {
            this.general_config = general_config;
        }

        public CustomerSupportBean getCustomer_support() {
            return customer_support;
        }

        public void setCustomer_support(CustomerSupportBean customer_support) {
            this.customer_support = customer_support;
        }

        public AppVersionDialogBean getApp_version_dialog() {
            return app_version_dialog;
        }

        public void setApp_version_dialog(AppVersionDialogBean app_version_dialog) {
            this.app_version_dialog = app_version_dialog;
        }

        public AppMaintainanceBean getApp_maintainance() {
            return app_maintainance;
        }

        public void setApp_maintainance(AppMaintainanceBean app_maintainance) {
            this.app_maintainance = app_maintainance;
        }

        public RideConfigBean getRide_config() {
            return ride_config;
        }

        public void setRide_config(RideConfigBean ride_config) {
            this.ride_config = ride_config;
        }

        public TrackingBean getTracking() {
            return tracking;
        }

        public void setTracking(TrackingBean tracking) {
            this.tracking = tracking;
        }

        public ReceivingBean getReceiving() {
            return receiving;
        }

        public void setReceiving(ReceivingBean receiving) {
            this.receiving = receiving;
        }

        public LoginBean getLogin() {
            return login;
        }

        public void setLogin(LoginBean login) {
            this.login = login;
        }

        public ThemeCofigBean getTheme_cofig() {
            return theme_cofig;
        }

        public void setTheme_cofig(ThemeCofigBean theme_cofig) {
            this.theme_cofig = theme_cofig;
        }

        public List<CountriesBean> getCountries() {
            return countries;
        }

        public void setCountries(List<CountriesBean> countries) {
            this.countries = countries;
        }

        public List<LanguagesBean> getLanguages() {
            return languages;
        }

        public void setLanguages(List<LanguagesBean> languages) {
            this.languages = languages;
        }

        public List<PaymentOptionBean> getPaymentOption() {
            return paymentOption;
        }

        public void setPaymentOption(List<PaymentOptionBean> paymentOption) {
            this.paymentOption = paymentOption;
        }

        public static class NavigationDrawerBean {
            /**
             * language : true
             * customer_support : true
             * report_issue : true
             * cms_page : true
             * wallet : false
             */

            private boolean language;
            private boolean customer_support;
            private boolean report_issue;
            private boolean cms_page;
            private boolean wallet;

            public boolean isLanguage() {
                return language;
            }

            public void setLanguage(boolean language) {
                this.language = language;
            }

            public boolean isCustomer_support() {
                return customer_support;
            }

            public void setCustomer_support(boolean customer_support) {
                this.customer_support = customer_support;
            }

            public boolean isReport_issue() {
                return report_issue;
            }

            public void setReport_issue(boolean report_issue) {
                this.report_issue = report_issue;
            }

            public boolean isCms_page() {
                return cms_page;
            }

            public void setCms_page(boolean cms_page) {
                this.cms_page = cms_page;
            }

            public boolean isWallet() {
                return wallet;
            }

            public void setWallet(boolean wallet) {
                this.wallet = wallet;
            }
        }

        public static class RegisterBean {
            /**
             * smoker : true
             * email : true
             * phone : true
             * gender : true
             */
            private boolean smoker;
            private boolean email;
            private boolean phone;
            private boolean gender;
            private boolean driver_email_otp;
            private boolean driver_phone_otp;
            private boolean driver_commission_choice;

            public boolean isDriver_commission_choice() {
                return driver_commission_choice;
            }

            public void setDriver_commission_choice(boolean driver_commission_choice) {
                this.driver_commission_choice = driver_commission_choice;
            }

            public boolean isDriver_email_otp() {
                return driver_email_otp;
            }

            public void setDriver_email_otp(boolean driver_email_otp) {
                this.driver_email_otp = driver_email_otp;
            }

            public boolean isDriver_phone_otp() {
                return driver_phone_otp;
            }

            public void setDriver_phone_otp(boolean driver_phone_otp) {
                this.driver_phone_otp = driver_phone_otp;
            }

            public boolean isSmoker() {
                return smoker;
            }

            public void setSmoker(boolean smoker) {
                this.smoker = smoker;
            }

            public boolean isEmail() {
                return email;
            }

            public void setEmail(boolean email) {
                this.email = email;
            }

            public boolean isPhone() {
                return phone;
            }

            public void setPhone(boolean phone) {
                this.phone = phone;
            }

            public boolean isGender() {
                return gender;
            }

            public void setGender(boolean gender) {
                this.gender = gender;
            }
        }

        public static class GeneralConfigBean {
            /**
             * manual_dispatch : false
             * demo : false
             * default_language : en
             * driver_wallet_package : [{"amount":"100"},{"amount":"200"},{"amount":"300"}]
             * chat : true
             * splash_screen : Apporio Taxi
             * vehicle_owner : false
             * enable_super_driver : true
             * baby_seat_enable : true
             */

            private boolean manual_dispatch;
            private boolean demo;

            public boolean isPolyline() {
                return polyline;
            }

            public void setPolyline(boolean polyline) {
                this.polyline = polyline;
            }

            private boolean add_multiple_vehicle;
            private boolean auto_accept_mode;
            private boolean polyline;

            public boolean isBooking_eta() {
                return booking_eta;
            }

            public void setBooking_eta(boolean booking_eta) {
                this.booking_eta = booking_eta;
            }

            private boolean subscription_package;
            private boolean booking_eta;

            public boolean isVehicle_make_text() {
                return vehicle_make_text;
            }

            public void setVehicle_make_text(boolean vehicle_make_text) {
                this.vehicle_make_text = vehicle_make_text;
            }

            public boolean isVehicle_model_text() {
                return vehicle_model_text;
            }

            public void setVehicle_model_text(boolean vehicle_model_text) {
                this.vehicle_model_text = vehicle_model_text;
            }

            private boolean demand_spot_enable;
            private boolean service_type_selection;
            private boolean driver_cpf_number_enable;
            private String splash_screen_driver;
            private boolean otp_from_firebase;

            public boolean isReferral_code_mandatory_driver_signup() {
                return referral_code_mandatory_driver_signup;
            }

            public void setReferral_code_mandatory_driver_signup(boolean referral_code_mandatory_driver_signup) {
                this.referral_code_mandatory_driver_signup = referral_code_mandatory_driver_signup;
            }

            private boolean vehicle_make_text;
            private boolean vehicle_model_text;
            private boolean referral_code_mandatory_driver_signup;

            public boolean isOtp_from_firebase() {
                return otp_from_firebase;
            }

            public void setOtp_from_firebase(boolean otp_from_firebase) {
                this.otp_from_firebase = otp_from_firebase;
            }

            public String getSplash_screen_driver() {
                return splash_screen_driver;
            }

            public void setSplash_screen_driver(String splash_screen_driver) {
                this.splash_screen_driver = splash_screen_driver;
            }

            public boolean isDriver_cpf_number_enable() {
                return driver_cpf_number_enable;
            }

            public void setDriver_cpf_number_enable(boolean driver_cpf_number_enable) {
                this.driver_cpf_number_enable = driver_cpf_number_enable;
            }
            public boolean isDemand_spot_enable() {
                return demand_spot_enable;
            }

            public void setDemand_spot_enable(boolean demand_spot_enable) {
                this.demand_spot_enable = demand_spot_enable;
            }

            public boolean isService_type_selection() {
                return service_type_selection;
            }

            public void setService_type_selection(boolean service_type_selection) {
                this.service_type_selection = service_type_selection;
            }

            public boolean isVehicle_ac_enable() {
                return vehicle_ac_enable;
            }

            public void setVehicle_ac_enable(boolean vehicle_ac_enable) {
                this.vehicle_ac_enable = vehicle_ac_enable;
            }

            public OnlineTransactionCode getOnline_transaction_code() {
                return online_transaction_code;
            }

            public void setOnline_transaction_code(OnlineTransactionCode online_transaction_code) {
                this.online_transaction_code = online_transaction_code;
            }

            private OnlineTransactionCode online_transaction_code;

            public boolean isHome_address_enable() {
                return home_address_enable;
            }

            public void setHome_address_enable(boolean home_address_enable) {
                this.home_address_enable = home_address_enable;
            }

            private boolean driver_limit;
            private String default_language;
            private boolean chat;
            private String splash_screen;
            private boolean vehicle_owner;
            private boolean bank_details_enable;
            private boolean existing_vehicle_enable;
            private boolean emergency_contact;
            private boolean baby_seat_enable;
            private boolean wheel_chair_enable;

            public class OnlineTransactionCode{

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPlaceholder() {
                    return placeholder;
                }

                public void setPlaceholder(String placeholder) {
                    this.placeholder = placeholder;
                }

                private String name;
                private String placeholder;

            }

            public boolean isWheel_chair_enable() {
                return wheel_chair_enable;
            }

            public void setWheel_chair_enable(boolean wheel_chair_enable) {
                this.wheel_chair_enable = wheel_chair_enable;
            }

            public boolean isEmergency_contact() {
                return emergency_contact;
            }

            public void setEmergency_contact(boolean emergency_contact) {
                this.emergency_contact = emergency_contact;
            }

            public boolean isBaby_seat_enable() {
                return baby_seat_enable;
            }

            public void setBaby_seat_enable(boolean baby_seat_enable) {
                this.baby_seat_enable = baby_seat_enable;
            }

            public boolean isExisting_vehicle_enable() {
                return existing_vehicle_enable;
            }

            public void setExisting_vehicle_enable(boolean existing_vehicle_enable) {
                this.existing_vehicle_enable = existing_vehicle_enable;
            }

            public boolean isAdd_multiple_vehicle() {
                return add_multiple_vehicle;
            }

            public void setAdd_multiple_vehicle(boolean add_multiple_vehicle) {
                this.add_multiple_vehicle = add_multiple_vehicle;
            }

            private boolean home_address_enable;
            private boolean enable_super_driver;
            private List<DriverWalletPackageBean> driver_wallet_package;
            private boolean vehicle_ac_enable;


            public boolean isAc_vehicle_enable() {
                return vehicle_ac_enable;
            }

            public boolean isDriver_limit() {
                return driver_limit;
            }

            public void setDriver_limit(boolean driver_limit) {
                this.driver_limit = driver_limit;
            }

            public void setAc_vehicle_enable(boolean vehicle_ac_enable) {
                this.vehicle_ac_enable = vehicle_ac_enable;

            }

            public boolean isSubscription_package() {
                return subscription_package;
            }

            public boolean isAuto_accept_mode() {
                return auto_accept_mode;
            }

            public void setAuto_accept_mode(boolean auto_accept_mode) {
                this.auto_accept_mode = auto_accept_mode;
            }

            public boolean isBank_details_enable() {
                return bank_details_enable;
            }

            public void setBank_details_enable(boolean bank_details_enable) {
                this.bank_details_enable = bank_details_enable;
            }

            public void setSubscription_package(boolean subscription_package) {

                this.subscription_package = subscription_package;
            }

            public boolean isManual_dispatch() {
                return manual_dispatch;
            }

            public void setManual_dispatch(boolean manual_dispatch) {
                this.manual_dispatch = manual_dispatch;
            }

            public boolean isDemo() {
                return demo;
            }

            public void setDemo(boolean demo) {
                this.demo = demo;
            }

            public String getDefault_language() {
                return default_language;
            }

            public void setDefault_language(String default_language) {
                this.default_language = default_language;
            }

            public boolean isChat() {
                return chat;
            }

            public void setChat(boolean chat) {
                this.chat = chat;
            }

            public String getSplash_screen() {
                return splash_screen;
            }

            public void setSplash_screen(String splash_screen) {
                this.splash_screen = splash_screen;
            }

            public boolean isVehicle_owner() {
                return vehicle_owner;
            }

            public void setVehicle_owner(boolean vehicle_owner) {
                this.vehicle_owner = vehicle_owner;
            }

            public boolean isEnable_super_driver() {
                return enable_super_driver;
            }

            public void setEnable_super_driver(boolean enable_super_driver) {
                this.enable_super_driver = enable_super_driver;
            }

            public List<DriverWalletPackageBean> getDriver_wallet_package() {
                return driver_wallet_package;
            }

            public void setDriver_wallet_package(List<DriverWalletPackageBean> driver_wallet_package) {
                this.driver_wallet_package = driver_wallet_package;
            }

            public static class DriverWalletPackageBean {
                /**
                 * amount : 100
                 */

                private String amount;

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }
            }
        }

        public static class CustomerSupportBean {
            /**
             * mail : apporio@gmail.com
             * phone : 9090909090
             */

            private String mail;
            private String phone;

            public String getMail() {
                return mail;
            }

            public void setMail(String mail) {
                this.mail = mail;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }

        public static class AppVersionDialogBean {
            /**
             * show_dialog : false
             * mandatory : true
             * dialog_message : Application is Update to date
             */

            private boolean show_dialog;
            private boolean mandatory;
            private String dialog_message;

            public boolean isShow_dialog() {
                return show_dialog;
            }

            public void setShow_dialog(boolean show_dialog) {
                this.show_dialog = show_dialog;
            }

            public boolean isMandatory() {
                return mandatory;
            }

            public void setMandatory(boolean mandatory) {
                this.mandatory = mandatory;
            }

            public String getDialog_message() {
                return dialog_message;
            }

            public void setDialog_message(String dialog_message) {
                this.dialog_message = dialog_message;
            }
        }

        public static class AppMaintainanceBean {
            /**
             * show_dialog : false
             * show_message :
             */

            private boolean show_dialog;
            private String show_message;

            public boolean isShow_dialog() {
                return show_dialog;
            }

            public void setShow_dialog(boolean show_dialog) {
                this.show_dialog = show_dialog;
            }

            public String getShow_message() {
                return show_message;
            }

            public void setShow_message(String show_message) {
                this.show_message = show_message;
            }
        }

        public static class RideConfigBean {
            /**
             * outstation : true
             * location_update_timeband : 5
             * tracking_screen_refresh_timeband : null
             * slide_button : true
             */

            private boolean outstation;
            private String location_update_timeband;
            private Object tracking_screen_refresh_timeband;
            private boolean slide_button;
            private boolean outstation_notification_popup;


            public boolean isOutstation() {
                return outstation;
            }

            public void setOutstation(boolean outstation) {
                this.outstation = outstation;
            }

            public boolean isOutstation_notification_popup() {
                return outstation_notification_popup;
            }

            public void setOutstation_notification_popup(boolean outstation_notification_popup) {
                this.outstation_notification_popup = outstation_notification_popup;
            }

            public String getLocation_update_timeband() {
                return location_update_timeband;
            }

            public void setLocation_update_timeband(String location_update_timeband) {
                this.location_update_timeband = location_update_timeband;
            }

            public Object getTracking_screen_refresh_timeband() {
                return tracking_screen_refresh_timeband;
            }

            public void setTracking_screen_refresh_timeband(Object tracking_screen_refresh_timeband) {
                this.tracking_screen_refresh_timeband = tracking_screen_refresh_timeband;
            }

            public boolean isSlide_button() {
                return slide_button;
            }

            public void setSlide_button(boolean slide_button) {
                this.slide_button = slide_button;
            }
        }

        public static class TrackingBean {
            /**
             * scroll : true
             */

            private boolean scroll;

            public boolean isScroll() {
                return scroll;
            }

            public void setScroll(boolean scroll) {
                this.scroll = scroll;
            }
        }

        public static class ReceivingBean {
            /**
             * drop_point : true
             * estimate_fare : true
             */

            private boolean drop_point;
            private boolean estimate_fare;
            private boolean driver_commission_choice;
            public boolean isDriver_commission_choice() {
                return driver_commission_choice;
            }

            public void setDriver_commission_choice(boolean driver_commission_choice) {
                this.driver_commission_choice = driver_commission_choice;
            }



            public boolean isDrop_point() {
                return drop_point;
            }

            public void setDrop_point(boolean drop_point) {
                this.drop_point = drop_point;
            }

            public boolean isEstimate_fare() {
                return estimate_fare;
            }

            public void setEstimate_fare(boolean estimate_fare) {
                this.estimate_fare = estimate_fare;
            }
        }

        public static class LoginBean {
            /**
             * email : false
             * phone : true
             */

            private boolean email;
            private boolean phone;

            public boolean isEmail() {
                return email;
            }

            public void setEmail(boolean email) {
                this.email = email;
            }

            public boolean isPhone() {
                return phone;
            }

            public void setPhone(boolean phone) {
                this.phone = phone;
            }
        }

        public static class ThemeCofigBean {
            /**
             * primary_color_driver : #4080bf
             * chat_button_color_driver : #44bb77
             * share_button_color_driver : #ffff00
             * call_button_color_driver : #ffff00
             * cancel_button_color_driver : #ffff00
             */

            private String primary_color_driver;
            private String chat_button_color_driver;
            private String share_button_color_driver;
            private String call_button_color_driver;
            private String cancel_button_color_driver;

            public String getPrimary_color_driver() {
                return primary_color_driver;
            }

            public void setPrimary_color_driver(String primary_color_driver) {
                this.primary_color_driver = primary_color_driver;
            }

            public String getChat_button_color_driver() {
                return chat_button_color_driver;
            }

            public void setChat_button_color_driver(String chat_button_color_driver) {
                this.chat_button_color_driver = chat_button_color_driver;
            }

            public String getShare_button_color_driver() {
                return share_button_color_driver;
            }

            public void setShare_button_color_driver(String share_button_color_driver) {
                this.share_button_color_driver = share_button_color_driver;
            }

            public String getCall_button_color_driver() {
                return call_button_color_driver;
            }

            public void setCall_button_color_driver(String call_button_color_driver) {
                this.call_button_color_driver = call_button_color_driver;
            }

            public String getCancel_button_color_driver() {
                return cancel_button_color_driver;
            }

            public void setCancel_button_color_driver(String cancel_button_color_driver) {
                this.cancel_button_color_driver = cancel_button_color_driver;
            }
        }

        public static class CountriesBean {
            /**
             * id : 4
             * merchant_id : 2
             * isoCode : INR
             * phonecode : +91
             * distance_unit : 1
             * default_language : en
             * maxNumPhone : 10
             * minNumPhone : 10
             * country_status : 1
             * created_at : 2019-02-23 12:44:21
             * updated_at : 2019-02-25 09:25:48
             * name : India
             * country_area : [{"id":3,"merchant_id":2,"country_id":"4","AreaCoordinates":"[{\"latitude\":\"28.438482470938308\",\"longitude\":\"76.80967473398528\"},{\"latitude\":\"28.351501403189985\",\"longitude\":\"76.81242131601653\"},{\"latitude\":\"28.327931752619012\",\"longitude\":\"77.04313420664153\"},{\"latitude\":\"28.350897118504516\",\"longitude\":\"77.13308476816496\"},{\"latitude\":\"28.446935154795593\",\"longitude\":\"77.17840337168059\"},{\"latitude\":\"28.508498596520255\",\"longitude\":\"77.10287236582121\"},{\"latitude\":\"28.529615034860367\",\"longitude\":\"76.94700383554778\"},{\"latitude\":\"28.48737793029043\",\"longitude\":\"76.80486821543059\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":null,"pool_postion":2,"status":1,"created_at":"2019-02-23 13:02:42","updated_at":"2019-02-23 13:02:42","AreaName":"Gurugram"},{"id":23,"merchant_id":2,"country_id":"4","AreaCoordinates":"[{\"latitude\":\"18.668812985897393\",\"longitude\":\"73.84633672902214\"},{\"latitude\":\"18.670114015737603\",\"longitude\":\"73.75569952199089\"},{\"latitude\":\"18.670114015737603\",\"longitude\":\"73.70900762745964\"},{\"latitude\":\"18.59984413508932\",\"longitude\":\"73.59227789113152\"},{\"latitude\":\"18.537357657678545\",\"longitude\":\"73.49065435597527\"},{\"latitude\":\"18.358885328742776\",\"longitude\":\"73.45220220753777\"},{\"latitude\":\"18.276752028560736\",\"longitude\":\"73.61562383839714\"},{\"latitude\":\"18.293703360417908\",\"longitude\":\"73.71450079152214\"},{\"latitude\":\"18.267623702116836\",\"longitude\":\"73.79552496144402\"},{\"latitude\":\"18.263711415235843\",\"longitude\":\"73.84359014699089\"},{\"latitude\":\"18.261103175001733\",\"longitude\":\"73.92324102589714\"},{\"latitude\":\"18.28587987471443\",\"longitude\":\"73.95894659230339\"},{\"latitude\":\"18.338029771684685\",\"longitude\":\"74.01937139699089\"},{\"latitude\":\"18.386254424268042\",\"longitude\":\"74.12511480519402\"},{\"latitude\":\"18.483965686882513\",\"longitude\":\"74.13472784230339\"},{\"latitude\":\"18.564698308236846\",\"longitude\":\"73.93972051808464\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":null,"pool_postion":1,"status":1,"created_at":"2019-03-01 06:51:01","updated_at":"2019-03-01 06:51:01","AreaName":"Pune"}]
             */

            private int id;
            private int merchant_id;
            private String isoCode;
            private String phonecode;
            private int distance_unit;
            private String default_language;
            private int maxNumPhone;
            private int minNumPhone;
            private int country_status;
            private String created_at;
            private String updated_at;
            private String name;
            private List<CountryAreaBean> country_area;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public String getIsoCode() {
                return isoCode;
            }

            public void setIsoCode(String isoCode) {
                this.isoCode = isoCode;
            }

            public String getPhonecode() {
                return phonecode;
            }

            public void setPhonecode(String phonecode) {
                this.phonecode = phonecode;
            }

            public int getDistance_unit() {
                return distance_unit;
            }

            public void setDistance_unit(int distance_unit) {
                this.distance_unit = distance_unit;
            }

            public String getDefault_language() {
                return default_language;
            }

            public void setDefault_language(String default_language) {
                this.default_language = default_language;
            }

            public int getMaxNumPhone() {
                return maxNumPhone;
            }

            public void setMaxNumPhone(int maxNumPhone) {
                this.maxNumPhone = maxNumPhone;
            }

            public int getMinNumPhone() {
                return minNumPhone;
            }

            public void setMinNumPhone(int minNumPhone) {
                this.minNumPhone = minNumPhone;
            }

            public int getCountry_status() {
                return country_status;
            }

            public void setCountry_status(int country_status) {
                this.country_status = country_status;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<CountryAreaBean> getCountry_area() {
                return country_area;
            }

            public void setCountry_area(List<CountryAreaBean> country_area) {
                this.country_area = country_area;
            }

            public static class CountryAreaBean {
                /**
                 * id : 3
                 * merchant_id : 2
                 * country_id : 4
                 * AreaCoordinates : [{"latitude":"28.438482470938308","longitude":"76.80967473398528"},{"latitude":"28.351501403189985","longitude":"76.81242131601653"},{"latitude":"28.327931752619012","longitude":"77.04313420664153"},{"latitude":"28.350897118504516","longitude":"77.13308476816496"},{"latitude":"28.446935154795593","longitude":"77.17840337168059"},{"latitude":"28.508498596520255","longitude":"77.10287236582121"},{"latitude":"28.529615034860367","longitude":"76.94700383554778"},{"latitude":"28.48737793029043","longitude":"76.80486821543059"}]
                 * auto_upgradetion : 2
                 * timezone : Asia/Kolkata
                 * minimum_wallet_amount : null
                 * pool_postion : 2
                 * status : 1
                 * created_at : 2019-02-23 13:02:42
                 * updated_at : 2019-02-23 13:02:42
                 * AreaName : Gurugram
                 */

                private int id;
                private int merchant_id;
                private String country_id;
                private String AreaCoordinates;
                private int auto_upgradetion;
                private String timezone;
                private Object minimum_wallet_amount;
                private int pool_postion;
                private int status;
                private String created_at;
                private String updated_at;
                private String AreaName;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getMerchant_id() {
                    return merchant_id;
                }

                public void setMerchant_id(int merchant_id) {
                    this.merchant_id = merchant_id;
                }

                public String getCountry_id() {
                    return country_id;
                }

                public void setCountry_id(String country_id) {
                    this.country_id = country_id;
                }

                public String getAreaCoordinates() {
                    return AreaCoordinates;
                }

                public void setAreaCoordinates(String AreaCoordinates) {
                    this.AreaCoordinates = AreaCoordinates;
                }

                public int getAuto_upgradetion() {
                    return auto_upgradetion;
                }

                public void setAuto_upgradetion(int auto_upgradetion) {
                    this.auto_upgradetion = auto_upgradetion;
                }

                public String getTimezone() {
                    return timezone;
                }

                public void setTimezone(String timezone) {
                    this.timezone = timezone;
                }

                public Object getMinimum_wallet_amount() {
                    return minimum_wallet_amount;
                }

                public void setMinimum_wallet_amount(Object minimum_wallet_amount) {
                    this.minimum_wallet_amount = minimum_wallet_amount;
                }

                public int getPool_postion() {
                    return pool_postion;
                }

                public void setPool_postion(int pool_postion) {
                    this.pool_postion = pool_postion;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(String created_at) {
                    this.created_at = created_at;
                }

                public String getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(String updated_at) {
                    this.updated_at = updated_at;
                }

                public String getAreaName() {
                    return AreaName;
                }

                public void setAreaName(String AreaName) {
                    this.AreaName = AreaName;
                }
            }
        }

        public static class LanguagesBean {
            /**
             * id : 1
             * name : English
             * locale : en
             * created_at : 2018-05-27 21:30:00
             * updated_at : 2018-05-28 00:30:00
             */

            private int id;
            private String name;
            private String locale;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLocale() {
                return locale;
            }

            public void setLocale(String locale) {
                this.locale = locale;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }

        public static class SegmentsBean{


            /**
             * id : 1
             * icon : segment/holder_taxi.png
             * name : Taxi
             * description : Taxi
             * slag : TAXI
             * created_at : 2019-06-04 05:48:53
             * updated_at : 2019-06-04 05:48:53
             */

            private int id;
            private String icon;
            private String name;
            private String description;
            private String slag;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getSlag() {
                return slag;
            }

            public void setSlag(String slag) {
                this.slag = slag;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }
        public static class PaymentOptionBean {
            /**
             * id : 1
             * slug : STRIPE
             * name : Stripe
             * created_at : 2018-12-10 18:30:00
             * updated_at : 2018-12-10 18:30:00
             */

            private int id;
            private String slug;
            private String name;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

        }


        public static class DriverCommissionChoicesBean {
            /**
             * id : 1
             * lang_data : Subscription Based
             */

            private int id;
            private String lang_data;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLang_data() {
                return lang_data;
            }

            public void setLang_data(String lang_data) {
                this.lang_data = lang_data;
            }
        }
    }
}