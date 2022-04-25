package com.apporio.demotaxiappdriver.models;

public class ModelEditProfile {


    private String result;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int merchant_id;
        private Object unique_number;
        private String driver_gender;
        private String first_name;
        private String email;
        private String wallet_money;
        private String password;
        private int home_location_active;
        private int pool_ride_active;
        private int status_for_pool;
        private int avail_seats;
        private int occupied_seats;
        private Object pick_exceed;
        private Object pool_user_id;
        private String phoneNumber;
        private String profile_image;
        private int total_trips;
        private String total_earnings;
        private String total_comany_earning;
        private String outstand_amount;
        private String current_latitude;
        private String current_longitude;
        private String last_location_update_time;
        private String bearing;
        private String accuracy;
        private String player_id;
        private String rating;
        private int country_area_id;
        private int login_logout;
        private int online_offline;
        private int free_busy;
        private String bank_name;
        private String account_holder_name;
        private String account_number;
        private int driver_verify_status;
        private int signupFrom;
        private int signupStep;
        private Object driver_verification_date;
        private int driver_admin_status;
        private String access_token_id;
        private Object driver_delete;
        private String last_ride_request_timestamp;
        private String created_at;
        private String updated_at;
        private String last_name;
        private String driver_referralcode;
        private Object driver_block_status;
        private int term_status;
        private int pending_document_status;
        private int expire_personal_document;
        private int expire_vehicle_document;
        private Object admin_msg;
        private String smoker_type;
        private String allow_other_smoker;
        private String auto_accept_enable;
        private CountryAreaBean country_area;
        private MerchantBean merchant;
        private DriverRideConfigBean driver_ride_config;
        private String subscription_wise_commission;
        private String phone_code;
        private String phone_without_code;

        public String getPhone_code() {
            return phone_code;
        }

        public void setPhone_code(String phone_code) {
            this.phone_code = phone_code;
        }

        public String getPhone_without_code() {
            return phone_without_code;
        }

        public void setPhone_without_code(String phone_without_code) {
            this.phone_without_code = phone_without_code;
        }

        public String getSubscription_wise_commission() {
            return subscription_wise_commission;
        }

        public void setSubscription_wise_commission(String subscription_wise_commission) {
            this.subscription_wise_commission = subscription_wise_commission;
        }

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

        public Object getUnique_number() {
            return unique_number;
        }

        public void setUnique_number(Object unique_number) {
            this.unique_number = unique_number;
        }

        public String getDriver_gender() {
            return driver_gender;
        }

        public void setDriver_gender(String driver_gender) {
            this.driver_gender = driver_gender;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getWallet_money() {
            return wallet_money;
        }

        public void setWallet_money(String wallet_money) {
            this.wallet_money = wallet_money;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getHome_location_active() {
            return home_location_active;
        }

        public void setHome_location_active(int home_location_active) {
            this.home_location_active = home_location_active;
        }

        public int getPool_ride_active() {
            return pool_ride_active;
        }

        public void setPool_ride_active(int pool_ride_active) {
            this.pool_ride_active = pool_ride_active;
        }

        public int getStatus_for_pool() {
            return status_for_pool;
        }

        public void setStatus_for_pool(int status_for_pool) {
            this.status_for_pool = status_for_pool;
        }

        public int getAvail_seats() {
            return avail_seats;
        }

        public void setAvail_seats(int avail_seats) {
            this.avail_seats = avail_seats;
        }

        public int getOccupied_seats() {
            return occupied_seats;
        }

        public void setOccupied_seats(int occupied_seats) {
            this.occupied_seats = occupied_seats;
        }

        public Object getPick_exceed() {
            return pick_exceed;
        }

        public void setPick_exceed(Object pick_exceed) {
            this.pick_exceed = pick_exceed;
        }

        public Object getPool_user_id() {
            return pool_user_id;
        }

        public void setPool_user_id(Object pool_user_id) {
            this.pool_user_id = pool_user_id;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public int getTotal_trips() {
            return total_trips;
        }

        public void setTotal_trips(int total_trips) {
            this.total_trips = total_trips;
        }

        public String getTotal_earnings() {
            return total_earnings;
        }

        public void setTotal_earnings(String total_earnings) {
            this.total_earnings = total_earnings;
        }

        public String getTotal_comany_earning() {
            return total_comany_earning;
        }

        public void setTotal_comany_earning(String total_comany_earning) {
            this.total_comany_earning = total_comany_earning;
        }

        public String getOutstand_amount() {
            return outstand_amount;
        }

        public void setOutstand_amount(String outstand_amount) {
            this.outstand_amount = outstand_amount;
        }

        public String getCurrent_latitude() {
            return current_latitude;
        }

        public void setCurrent_latitude(String current_latitude) {
            this.current_latitude = current_latitude;
        }

        public String getCurrent_longitude() {
            return current_longitude;
        }

        public void setCurrent_longitude(String current_longitude) {
            this.current_longitude = current_longitude;
        }

        public String getLast_location_update_time() {
            return last_location_update_time;
        }

        public void setLast_location_update_time(String last_location_update_time) {
            this.last_location_update_time = last_location_update_time;
        }

        public String getBearing() {
            return bearing;
        }

        public void setBearing(String bearing) {
            this.bearing = bearing;
        }

        public String getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(String accuracy) {
            this.accuracy = accuracy;
        }

        public String getPlayer_id() {
            return player_id;
        }

        public void setPlayer_id(String player_id) {
            this.player_id = player_id;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public int getCountry_area_id() {
            return country_area_id;
        }

        public void setCountry_area_id(int country_area_id) {
            this.country_area_id = country_area_id;
        }

        public int getLogin_logout() {
            return login_logout;
        }

        public void setLogin_logout(int login_logout) {
            this.login_logout = login_logout;
        }

        public int getOnline_offline() {
            return online_offline;
        }

        public void setOnline_offline(int online_offline) {
            this.online_offline = online_offline;
        }

        public int getFree_busy() {
            return free_busy;
        }

        public void setFree_busy(int free_busy) {
            this.free_busy = free_busy;
        }

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public String getAccount_holder_name() {
            return account_holder_name;
        }

        public void setAccount_holder_name(String account_holder_name) {
            this.account_holder_name = account_holder_name;
        }

        public String getAccount_number() {
            return account_number;
        }

        public void setAccount_number(String account_number) {
            this.account_number = account_number;
        }

        public int getDriver_verify_status() {
            return driver_verify_status;
        }

        public void setDriver_verify_status(int driver_verify_status) {
            this.driver_verify_status = driver_verify_status;
        }

        public int getSignupFrom() {
            return signupFrom;
        }

        public void setSignupFrom(int signupFrom) {
            this.signupFrom = signupFrom;
        }

        public int getSignupStep() {
            return signupStep;
        }

        public void setSignupStep(int signupStep) {
            this.signupStep = signupStep;
        }

        public Object getDriver_verification_date() {
            return driver_verification_date;
        }

        public void setDriver_verification_date(Object driver_verification_date) {
            this.driver_verification_date = driver_verification_date;
        }

        public int getDriver_admin_status() {
            return driver_admin_status;
        }

        public void setDriver_admin_status(int driver_admin_status) {
            this.driver_admin_status = driver_admin_status;
        }

        public String getAccess_token_id() {
            return access_token_id;
        }

        public void setAccess_token_id(String access_token_id) {
            this.access_token_id = access_token_id;
        }

        public Object getDriver_delete() {
            return driver_delete;
        }

        public void setDriver_delete(Object driver_delete) {
            this.driver_delete = driver_delete;
        }

        public String getLast_ride_request_timestamp() {
            return last_ride_request_timestamp;
        }

        public void setLast_ride_request_timestamp(String last_ride_request_timestamp) {
            this.last_ride_request_timestamp = last_ride_request_timestamp;
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

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getDriver_referralcode() {
            return driver_referralcode;
        }

        public void setDriver_referralcode(String driver_referralcode) {
            this.driver_referralcode = driver_referralcode;
        }

        public Object getDriver_block_status() {
            return driver_block_status;
        }

        public void setDriver_block_status(Object driver_block_status) {
            this.driver_block_status = driver_block_status;
        }

        public int getTerm_status() {
            return term_status;
        }

        public void setTerm_status(int term_status) {
            this.term_status = term_status;
        }

        public int getPending_document_status() {
            return pending_document_status;
        }

        public void setPending_document_status(int pending_document_status) {
            this.pending_document_status = pending_document_status;
        }

        public int getExpire_personal_document() {
            return expire_personal_document;
        }

        public void setExpire_personal_document(int expire_personal_document) {
            this.expire_personal_document = expire_personal_document;
        }

        public int getExpire_vehicle_document() {
            return expire_vehicle_document;
        }

        public void setExpire_vehicle_document(int expire_vehicle_document) {
            this.expire_vehicle_document = expire_vehicle_document;
        }

        public Object getAdmin_msg() {
            return admin_msg;
        }

        public void setAdmin_msg(Object admin_msg) {
            this.admin_msg = admin_msg;
        }

        public String getSmoker_type() {
            return smoker_type;
        }

        public void setSmoker_type(String smoker_type) {
            this.smoker_type = smoker_type;
        }

        public String getAllow_other_smoker() {
            return allow_other_smoker;
        }

        public void setAllow_other_smoker(String allow_other_smoker) {
            this.allow_other_smoker = allow_other_smoker;
        }

        public String getAuto_accept_enable() {
            return auto_accept_enable;
        }

        public void setAuto_accept_enable(String auto_accept_enable) {
            this.auto_accept_enable = auto_accept_enable;
        }

        public CountryAreaBean getCountry_area() {
            return country_area;
        }

        public void setCountry_area(CountryAreaBean country_area) {
            this.country_area = country_area;
        }

        public MerchantBean getMerchant() {
            return merchant;
        }

        public void setMerchant(MerchantBean merchant) {
            this.merchant = merchant;
        }

        public DriverRideConfigBean getDriver_ride_config() {
            return driver_ride_config;
        }

        public void setDriver_ride_config(DriverRideConfigBean driver_ride_config) {
            this.driver_ride_config = driver_ride_config;
        }

        public static class CountryAreaBean {
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
        }

        public static class MerchantBean {
            private int id;
            private int parent_id;
            private String BusinessName;
            private String email;
            private String BusinessLogo;
            private String alias_name;
            private String merchantFirstName;
            private String merchantLastName;
            private String merchantPhone;
            private String merchantAddress;
            private String password;
            private String merchantPublicKey;
            private String merchantSecretKey;
            private Object hotel_active;
            private Object franchisees_active;
            private Object doctor_active;
            private int cancel_charges;
            private int cancel_outstanding;
            private String tax;
            private String page_color;
            private String header_color;
            private String sidebar_color;
            private String footer_color;
            private int merchantStatus;
            private Object default_config;
            private String remember_token;
            private String created_at;
            private String updated_at;
            private ApplicationConfigurationBean application_configuration;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public String getBusinessName() {
                return BusinessName;
            }

            public void setBusinessName(String BusinessName) {
                this.BusinessName = BusinessName;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getBusinessLogo() {
                return BusinessLogo;
            }

            public void setBusinessLogo(String BusinessLogo) {
                this.BusinessLogo = BusinessLogo;
            }

            public String getAlias_name() {
                return alias_name;
            }

            public void setAlias_name(String alias_name) {
                this.alias_name = alias_name;
            }

            public String getMerchantFirstName() {
                return merchantFirstName;
            }

            public void setMerchantFirstName(String merchantFirstName) {
                this.merchantFirstName = merchantFirstName;
            }

            public String getMerchantLastName() {
                return merchantLastName;
            }

            public void setMerchantLastName(String merchantLastName) {
                this.merchantLastName = merchantLastName;
            }

            public String getMerchantPhone() {
                return merchantPhone;
            }

            public void setMerchantPhone(String merchantPhone) {
                this.merchantPhone = merchantPhone;
            }

            public String getMerchantAddress() {
                return merchantAddress;
            }

            public void setMerchantAddress(String merchantAddress) {
                this.merchantAddress = merchantAddress;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getMerchantPublicKey() {
                return merchantPublicKey;
            }

            public void setMerchantPublicKey(String merchantPublicKey) {
                this.merchantPublicKey = merchantPublicKey;
            }

            public String getMerchantSecretKey() {
                return merchantSecretKey;
            }

            public void setMerchantSecretKey(String merchantSecretKey) {
                this.merchantSecretKey = merchantSecretKey;
            }

            public Object getHotel_active() {
                return hotel_active;
            }

            public void setHotel_active(Object hotel_active) {
                this.hotel_active = hotel_active;
            }

            public Object getFranchisees_active() {
                return franchisees_active;
            }

            public void setFranchisees_active(Object franchisees_active) {
                this.franchisees_active = franchisees_active;
            }

            public Object getDoctor_active() {
                return doctor_active;
            }

            public void setDoctor_active(Object doctor_active) {
                this.doctor_active = doctor_active;
            }

            public int getCancel_charges() {
                return cancel_charges;
            }

            public void setCancel_charges(int cancel_charges) {
                this.cancel_charges = cancel_charges;
            }

            public int getCancel_outstanding() {
                return cancel_outstanding;
            }

            public void setCancel_outstanding(int cancel_outstanding) {
                this.cancel_outstanding = cancel_outstanding;
            }

            public String getTax() {
                return tax;
            }

            public void setTax(String tax) {
                this.tax = tax;
            }

            public String getPage_color() {
                return page_color;
            }

            public void setPage_color(String page_color) {
                this.page_color = page_color;
            }

            public String getHeader_color() {
                return header_color;
            }

            public void setHeader_color(String header_color) {
                this.header_color = header_color;
            }

            public String getSidebar_color() {
                return sidebar_color;
            }

            public void setSidebar_color(String sidebar_color) {
                this.sidebar_color = sidebar_color;
            }

            public String getFooter_color() {
                return footer_color;
            }

            public void setFooter_color(String footer_color) {
                this.footer_color = footer_color;
            }

            public int getMerchantStatus() {
                return merchantStatus;
            }

            public void setMerchantStatus(int merchantStatus) {
                this.merchantStatus = merchantStatus;
            }

            public Object getDefault_config() {
                return default_config;
            }

            public void setDefault_config(Object default_config) {
                this.default_config = default_config;
            }

            public String getRemember_token() {
                return remember_token;
            }

            public void setRemember_token(String remember_token) {
                this.remember_token = remember_token;
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

            public ApplicationConfigurationBean getApplication_configuration() {
                return application_configuration;
            }

            public void setApplication_configuration(ApplicationConfigurationBean application_configuration) {
                this.application_configuration = application_configuration;
            }

            public static class ApplicationConfigurationBean {
                private int id;
                private int merchant_id;
                private int vehicle_owner;
                private int home_screen_view;
                private String user_default_language;
                private String driver_default_language;
                private Object demo;
                private int user_email;
                private int driver_email;
                private int user_phone;
                private int driver_phone;
                private int user_email_otp;
                private int user_phone_otp;
                private int driver_email_otp;
                private int driver_phone_otp;
                private String user_login;
                private int user_email_otp_while_phone;
                private String driver_login;
                private int driver_email_otp_while_phone;
                private int smoker;
                private int gender;
                private String pickup_color;
                private String dropoff_color;
                private int time_charges;
                private int favourite_driver_module;
                private int vehicle_rating_enable;
                private int security_question;
                private int enable_super_driver;
                private int super_driver_limit;
                private int tip_status;
                private int sub_charge;
                private int user_document;
                private Object default_config;
                private String created_at;
                private String updated_at;

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

                public int getVehicle_owner() {
                    return vehicle_owner;
                }

                public void setVehicle_owner(int vehicle_owner) {
                    this.vehicle_owner = vehicle_owner;
                }

                public int getHome_screen_view() {
                    return home_screen_view;
                }

                public void setHome_screen_view(int home_screen_view) {
                    this.home_screen_view = home_screen_view;
                }

                public String getUser_default_language() {
                    return user_default_language;
                }

                public void setUser_default_language(String user_default_language) {
                    this.user_default_language = user_default_language;
                }

                public String getDriver_default_language() {
                    return driver_default_language;
                }

                public void setDriver_default_language(String driver_default_language) {
                    this.driver_default_language = driver_default_language;
                }

                public Object getDemo() {
                    return demo;
                }

                public void setDemo(Object demo) {
                    this.demo = demo;
                }

                public int getUser_email() {
                    return user_email;
                }

                public void setUser_email(int user_email) {
                    this.user_email = user_email;
                }

                public int getDriver_email() {
                    return driver_email;
                }

                public void setDriver_email(int driver_email) {
                    this.driver_email = driver_email;
                }

                public int getUser_phone() {
                    return user_phone;
                }

                public void setUser_phone(int user_phone) {
                    this.user_phone = user_phone;
                }

                public int getDriver_phone() {
                    return driver_phone;
                }

                public void setDriver_phone(int driver_phone) {
                    this.driver_phone = driver_phone;
                }

                public int getUser_email_otp() {
                    return user_email_otp;
                }

                public void setUser_email_otp(int user_email_otp) {
                    this.user_email_otp = user_email_otp;
                }

                public int getUser_phone_otp() {
                    return user_phone_otp;
                }

                public void setUser_phone_otp(int user_phone_otp) {
                    this.user_phone_otp = user_phone_otp;
                }

                public int getDriver_email_otp() {
                    return driver_email_otp;
                }

                public void setDriver_email_otp(int driver_email_otp) {
                    this.driver_email_otp = driver_email_otp;
                }

                public int getDriver_phone_otp() {
                    return driver_phone_otp;
                }

                public void setDriver_phone_otp(int driver_phone_otp) {
                    this.driver_phone_otp = driver_phone_otp;
                }

                public String getUser_login() {
                    return user_login;
                }

                public void setUser_login(String user_login) {
                    this.user_login = user_login;
                }

                public int getUser_email_otp_while_phone() {
                    return user_email_otp_while_phone;
                }

                public void setUser_email_otp_while_phone(int user_email_otp_while_phone) {
                    this.user_email_otp_while_phone = user_email_otp_while_phone;
                }

                public String getDriver_login() {
                    return driver_login;
                }

                public void setDriver_login(String driver_login) {
                    this.driver_login = driver_login;
                }

                public int getDriver_email_otp_while_phone() {
                    return driver_email_otp_while_phone;
                }

                public void setDriver_email_otp_while_phone(int driver_email_otp_while_phone) {
                    this.driver_email_otp_while_phone = driver_email_otp_while_phone;
                }

                public int getSmoker() {
                    return smoker;
                }

                public void setSmoker(int smoker) {
                    this.smoker = smoker;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public String getPickup_color() {
                    return pickup_color;
                }

                public void setPickup_color(String pickup_color) {
                    this.pickup_color = pickup_color;
                }

                public String getDropoff_color() {
                    return dropoff_color;
                }

                public void setDropoff_color(String dropoff_color) {
                    this.dropoff_color = dropoff_color;
                }

                public int getTime_charges() {
                    return time_charges;
                }

                public void setTime_charges(int time_charges) {
                    this.time_charges = time_charges;
                }

                public int getFavourite_driver_module() {
                    return favourite_driver_module;
                }

                public void setFavourite_driver_module(int favourite_driver_module) {
                    this.favourite_driver_module = favourite_driver_module;
                }

                public int getVehicle_rating_enable() {
                    return vehicle_rating_enable;
                }

                public void setVehicle_rating_enable(int vehicle_rating_enable) {
                    this.vehicle_rating_enable = vehicle_rating_enable;
                }

                public int getSecurity_question() {
                    return security_question;
                }

                public void setSecurity_question(int security_question) {
                    this.security_question = security_question;
                }

                public int getEnable_super_driver() {
                    return enable_super_driver;
                }

                public void setEnable_super_driver(int enable_super_driver) {
                    this.enable_super_driver = enable_super_driver;
                }

                public int getSuper_driver_limit() {
                    return super_driver_limit;
                }

                public void setSuper_driver_limit(int super_driver_limit) {
                    this.super_driver_limit = super_driver_limit;
                }

                public int getTip_status() {
                    return tip_status;
                }

                public void setTip_status(int tip_status) {
                    this.tip_status = tip_status;
                }

                public int getSub_charge() {
                    return sub_charge;
                }

                public void setSub_charge(int sub_charge) {
                    this.sub_charge = sub_charge;
                }

                public int getUser_document() {
                    return user_document;
                }

                public void setUser_document(int user_document) {
                    this.user_document = user_document;
                }

                public Object getDefault_config() {
                    return default_config;
                }

                public void setDefault_config(Object default_config) {
                    this.default_config = default_config;
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
        }

        public static class DriverRideConfigBean {
            private int id;
            private int driver_id;
            private int auto_upgradetion;
            private int pool_enable;
            private int smoker_type;
            private int allow_other_smoker;
            private Object latitude;
            private Object longitude;
            private Object radius;
            private int auto_accept_enable;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDriver_id() {
                return driver_id;
            }

            public void setDriver_id(int driver_id) {
                this.driver_id = driver_id;
            }

            public int getAuto_upgradetion() {
                return auto_upgradetion;
            }

            public void setAuto_upgradetion(int auto_upgradetion) {
                this.auto_upgradetion = auto_upgradetion;
            }

            public int getPool_enable() {
                return pool_enable;
            }

            public void setPool_enable(int pool_enable) {
                this.pool_enable = pool_enable;
            }

            public int getSmoker_type() {
                return smoker_type;
            }

            public void setSmoker_type(int smoker_type) {
                this.smoker_type = smoker_type;
            }

            public int getAllow_other_smoker() {
                return allow_other_smoker;
            }

            public void setAllow_other_smoker(int allow_other_smoker) {
                this.allow_other_smoker = allow_other_smoker;
            }

            public Object getLatitude() {
                return latitude;
            }

            public void setLatitude(Object latitude) {
                this.latitude = latitude;
            }

            public Object getLongitude() {
                return longitude;
            }

            public void setLongitude(Object longitude) {
                this.longitude = longitude;
            }

            public Object getRadius() {
                return radius;
            }

            public void setRadius(Object radius) {
                this.radius = radius;
            }

            public int getAuto_accept_enable() {
                return auto_accept_enable;
            }

            public void setAuto_accept_enable(int auto_accept_enable) {
                this.auto_accept_enable = auto_accept_enable;
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
    }
}