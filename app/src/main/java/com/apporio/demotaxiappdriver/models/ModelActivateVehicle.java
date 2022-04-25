package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelActivateVehicle {


    /**
     * result : 1
     * message : Vehicle Active Successfully
     * data : {"id":215,"merchant_id":1,"driver_id":213,"owner_id":213,"ownerType":1,"vehicle_type_id":23,"shareCode":"GAACFVQGW4","vehicle_make_id":8,"vehicle_model_id":12,"vehicle_number":"dl0962","vehicle_color":"red","vehicle_image":"1571642991_5dad5e6fbed1d_vehicle_document.jpg","vehicle_number_plate_image":"1571642995_5dad5e730f797_vehicle_document.jpg","vehicle_active_status":1,"vehicle_verification_status":1,"reject_reason_id":null,"ac_nonac":null,"baby_seat":null,"wheel_chair":null,"vehicle_delete":null,"created_at":"2019-10-21 07:29:55","updated_at":"2019-10-21 13:15:12","total_expire_document":null,"vehicle_additional_data":null,"drivers":[{"id":213,"merchant_driver_id":"3","merchant_id":1,"last_bill_generated":null,"subscription_wise_commission":2,"taxi_company_id":null,"unique_number":null,"driver_gender":2,"first_name":"Jimin","last_name":"Park","email":"jimin@gmail.com","password":"$2y$10$S8BI.p/QPVMgyNdTwu0STuz32.6HuzTtTHHbZghcd4B7USjOYEjZG","driver_address":null,"home_location_active":2,"pool_ride_active":2,"status_for_pool":1,"avail_seats":null,"occupied_seats":null,"pick_exceed":null,"pool_user_id":null,"phoneNumber":"+919559189641","profile_image":"1571638756_5dad4de4bd6f4_driver.jpg","wallet_money":"0","total_trips":null,"total_earnings":null,"total_comany_earning":null,"outstand_amount":null,"current_latitude":"28.4123562","current_longitude":"77.0440429","last_location_update_time":"2019-10-21 13:15:12","bearing":"139.66118","accuracy":"17.824","player_id":"c250a3e9-0bfd-4aa3-b68f-fa4ee89e99b6","rating":"0","country_area_id":7,"login_logout":1,"online_offline":1,"free_busy":2,"bank_name":null,"account_holder_name":null,"account_number":null,"account_type_id":null,"driver_verify_status":1,"signupFrom":1,"signupStep":3,"driver_verification_date":null,"driver_admin_status":1,"access_token_id":"47b358a18b3363ff10082545813b4d3ddfe4020218dcf21b6ac1732007192c75b0a664d2c2b36054","driver_delete":null,"online_code":null,"last_ride_request_timestamp":"2019-10-21 06:19:20","created_at":"2019-10-21 06:19:20","updated_at":"2019-10-21 13:15:12","driver_referralcode":"7PKWQ","driver_block_status":null,"term_status":0,"pending_document_status":2,"admin_msg":"please share vaild doc.","fullName":null,"dob":null,"reject_driver":1,"driver_cpf_number":null,"agency_number":null,"driver_additional_data":null,"reward_points":0,"usable_reward_points":0,"use_reward_trip_count":0,"is_suspended":null,"network_code":null,"referred_by":null}]}
     */

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
        /**
         * id : 215
         * merchant_id : 1
         * driver_id : 213
         * owner_id : 213
         * ownerType : 1
         * vehicle_type_id : 23
         * shareCode : GAACFVQGW4
         * vehicle_make_id : 8
         * vehicle_model_id : 12
         * vehicle_number : dl0962
         * vehicle_color : red
         * vehicle_image : 1571642991_5dad5e6fbed1d_vehicle_document.jpg
         * vehicle_number_plate_image : 1571642995_5dad5e730f797_vehicle_document.jpg
         * vehicle_active_status : 1
         * vehicle_verification_status : 1
         * reject_reason_id : null
         * ac_nonac : null
         * baby_seat : null
         * wheel_chair : null
         * vehicle_delete : null
         * created_at : 2019-10-21 07:29:55
         * updated_at : 2019-10-21 13:15:12
         * total_expire_document : null
         * vehicle_additional_data : null
         * drivers : [{"id":213,"merchant_driver_id":"3","merchant_id":1,"last_bill_generated":null,"subscription_wise_commission":2,"taxi_company_id":null,"unique_number":null,"driver_gender":2,"first_name":"Jimin","last_name":"Park","email":"jimin@gmail.com","password":"$2y$10$S8BI.p/QPVMgyNdTwu0STuz32.6HuzTtTHHbZghcd4B7USjOYEjZG","driver_address":null,"home_location_active":2,"pool_ride_active":2,"status_for_pool":1,"avail_seats":null,"occupied_seats":null,"pick_exceed":null,"pool_user_id":null,"phoneNumber":"+919559189641","profile_image":"1571638756_5dad4de4bd6f4_driver.jpg","wallet_money":"0","total_trips":null,"total_earnings":null,"total_comany_earning":null,"outstand_amount":null,"current_latitude":"28.4123562","current_longitude":"77.0440429","last_location_update_time":"2019-10-21 13:15:12","bearing":"139.66118","accuracy":"17.824","player_id":"c250a3e9-0bfd-4aa3-b68f-fa4ee89e99b6","rating":"0","country_area_id":7,"login_logout":1,"online_offline":1,"free_busy":2,"bank_name":null,"account_holder_name":null,"account_number":null,"account_type_id":null,"driver_verify_status":1,"signupFrom":1,"signupStep":3,"driver_verification_date":null,"driver_admin_status":1,"access_token_id":"47b358a18b3363ff10082545813b4d3ddfe4020218dcf21b6ac1732007192c75b0a664d2c2b36054","driver_delete":null,"online_code":null,"last_ride_request_timestamp":"2019-10-21 06:19:20","created_at":"2019-10-21 06:19:20","updated_at":"2019-10-21 13:15:12","driver_referralcode":"7PKWQ","driver_block_status":null,"term_status":0,"pending_document_status":2,"admin_msg":"please share vaild doc.","fullName":null,"dob":null,"reject_driver":1,"driver_cpf_number":null,"agency_number":null,"driver_additional_data":null,"reward_points":0,"usable_reward_points":0,"use_reward_trip_count":0,"is_suspended":null,"network_code":null,"referred_by":null}]
         */

        private int id;
        private int merchant_id;
        private int driver_id;
        private int owner_id;
        private int ownerType;
        private int vehicle_type_id;
        private String shareCode;
        private int vehicle_make_id;
        private int vehicle_model_id;
        private String vehicle_number;
        private String vehicle_color;
        private String vehicle_image;
        private String vehicle_number_plate_image;
        private int vehicle_active_status;
        private int vehicle_verification_status;
        private Object reject_reason_id;
        private Object ac_nonac;
        private Object baby_seat;
        private Object wheel_chair;
        private Object vehicle_delete;
        private String created_at;
        private String updated_at;
        private Object total_expire_document;
        private Object vehicle_additional_data;
        private List<DriversBean> drivers;

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

        public int getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(int driver_id) {
            this.driver_id = driver_id;
        }

        public int getOwner_id() {
            return owner_id;
        }

        public void setOwner_id(int owner_id) {
            this.owner_id = owner_id;
        }

        public int getOwnerType() {
            return ownerType;
        }

        public void setOwnerType(int ownerType) {
            this.ownerType = ownerType;
        }

        public int getVehicle_type_id() {
            return vehicle_type_id;
        }

        public void setVehicle_type_id(int vehicle_type_id) {
            this.vehicle_type_id = vehicle_type_id;
        }

        public String getShareCode() {
            return shareCode;
        }

        public void setShareCode(String shareCode) {
            this.shareCode = shareCode;
        }

        public int getVehicle_make_id() {
            return vehicle_make_id;
        }

        public void setVehicle_make_id(int vehicle_make_id) {
            this.vehicle_make_id = vehicle_make_id;
        }

        public int getVehicle_model_id() {
            return vehicle_model_id;
        }

        public void setVehicle_model_id(int vehicle_model_id) {
            this.vehicle_model_id = vehicle_model_id;
        }

        public String getVehicle_number() {
            return vehicle_number;
        }

        public void setVehicle_number(String vehicle_number) {
            this.vehicle_number = vehicle_number;
        }

        public String getVehicle_color() {
            return vehicle_color;
        }

        public void setVehicle_color(String vehicle_color) {
            this.vehicle_color = vehicle_color;
        }

        public String getVehicle_image() {
            return vehicle_image;
        }

        public void setVehicle_image(String vehicle_image) {
            this.vehicle_image = vehicle_image;
        }

        public String getVehicle_number_plate_image() {
            return vehicle_number_plate_image;
        }

        public void setVehicle_number_plate_image(String vehicle_number_plate_image) {
            this.vehicle_number_plate_image = vehicle_number_plate_image;
        }

        public int getVehicle_active_status() {
            return vehicle_active_status;
        }

        public void setVehicle_active_status(int vehicle_active_status) {
            this.vehicle_active_status = vehicle_active_status;
        }

        public int getVehicle_verification_status() {
            return vehicle_verification_status;
        }

        public void setVehicle_verification_status(int vehicle_verification_status) {
            this.vehicle_verification_status = vehicle_verification_status;
        }

        public Object getReject_reason_id() {
            return reject_reason_id;
        }

        public void setReject_reason_id(Object reject_reason_id) {
            this.reject_reason_id = reject_reason_id;
        }

        public Object getAc_nonac() {
            return ac_nonac;
        }

        public void setAc_nonac(Object ac_nonac) {
            this.ac_nonac = ac_nonac;
        }

        public Object getBaby_seat() {
            return baby_seat;
        }

        public void setBaby_seat(Object baby_seat) {
            this.baby_seat = baby_seat;
        }

        public Object getWheel_chair() {
            return wheel_chair;
        }

        public void setWheel_chair(Object wheel_chair) {
            this.wheel_chair = wheel_chair;
        }

        public Object getVehicle_delete() {
            return vehicle_delete;
        }

        public void setVehicle_delete(Object vehicle_delete) {
            this.vehicle_delete = vehicle_delete;
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

        public Object getTotal_expire_document() {
            return total_expire_document;
        }

        public void setTotal_expire_document(Object total_expire_document) {
            this.total_expire_document = total_expire_document;
        }

        public Object getVehicle_additional_data() {
            return vehicle_additional_data;
        }

        public void setVehicle_additional_data(Object vehicle_additional_data) {
            this.vehicle_additional_data = vehicle_additional_data;
        }

        public List<DriversBean> getDrivers() {
            return drivers;
        }

        public void setDrivers(List<DriversBean> drivers) {
            this.drivers = drivers;
        }

        public static class DriversBean {
            /**
             * id : 213
             * merchant_driver_id : 3
             * merchant_id : 1
             * last_bill_generated : null
             * subscription_wise_commission : 2
             * taxi_company_id : null
             * unique_number : null
             * driver_gender : 2
             * first_name : Jimin
             * last_name : Park
             * email : jimin@gmail.com
             * password : $2y$10$S8BI.p/QPVMgyNdTwu0STuz32.6HuzTtTHHbZghcd4B7USjOYEjZG
             * driver_address : null
             * home_location_active : 2
             * pool_ride_active : 2
             * status_for_pool : 1
             * avail_seats : null
             * occupied_seats : null
             * pick_exceed : null
             * pool_user_id : null
             * phoneNumber : +919559189641
             * profile_image : 1571638756_5dad4de4bd6f4_driver.jpg
             * wallet_money : 0
             * total_trips : null
             * total_earnings : null
             * total_comany_earning : null
             * outstand_amount : null
             * current_latitude : 28.4123562
             * current_longitude : 77.0440429
             * last_location_update_time : 2019-10-21 13:15:12
             * bearing : 139.66118
             * accuracy : 17.824
             * player_id : c250a3e9-0bfd-4aa3-b68f-fa4ee89e99b6
             * rating : 0
             * country_area_id : 7
             * login_logout : 1
             * online_offline : 1
             * free_busy : 2
             * bank_name : null
             * account_holder_name : null
             * account_number : null
             * account_type_id : null
             * driver_verify_status : 1
             * signupFrom : 1
             * signupStep : 3
             * driver_verification_date : null
             * driver_admin_status : 1
             * access_token_id : 47b358a18b3363ff10082545813b4d3ddfe4020218dcf21b6ac1732007192c75b0a664d2c2b36054
             * driver_delete : null
             * online_code : null
             * last_ride_request_timestamp : 2019-10-21 06:19:20
             * created_at : 2019-10-21 06:19:20
             * updated_at : 2019-10-21 13:15:12
             * driver_referralcode : 7PKWQ
             * driver_block_status : null
             * term_status : 0
             * pending_document_status : 2
             * admin_msg : please share vaild doc.
             * fullName : null
             * dob : null
             * reject_driver : 1
             * driver_cpf_number : null
             * agency_number : null
             * driver_additional_data : null
             * reward_points : 0
             * usable_reward_points : 0
             * use_reward_trip_count : 0
             * is_suspended : null
             * network_code : null
             * referred_by : null
             */

            private int id;
            private String merchant_driver_id;
            private int merchant_id;
            private Object last_bill_generated;
            private int subscription_wise_commission;
            private Object taxi_company_id;
            private Object unique_number;
            private int driver_gender;
            private String first_name;
            private String last_name;
            private String email;
            private String password;
            private Object driver_address;
            private int home_location_active;
            private int pool_ride_active;
            private int status_for_pool;
            private Object avail_seats;
            private Object occupied_seats;
            private Object pick_exceed;
            private Object pool_user_id;
            private String phoneNumber;
            private String profile_image;
            private String wallet_money;
            private Object total_trips;
            private Object total_earnings;
            private Object total_comany_earning;
            private Object outstand_amount;
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
            private Object bank_name;
            private Object account_holder_name;
            private Object account_number;
            private Object account_type_id;
            private int driver_verify_status;
            private int signupFrom;
            private int signupStep;
            private Object driver_verification_date;
            private int driver_admin_status;
            private String access_token_id;
            private Object driver_delete;
            private Object online_code;
            private String last_ride_request_timestamp;
            private String created_at;
            private String updated_at;
            private String driver_referralcode;
            private Object driver_block_status;
            private int term_status;
            private int pending_document_status;
            private String admin_msg;
            private Object fullName;
            private Object dob;
            private int reject_driver;
            private Object driver_cpf_number;
            private Object agency_number;
            private Object driver_additional_data;
            private int reward_points;
            private int usable_reward_points;
            private int use_reward_trip_count;
            private Object is_suspended;
            private Object network_code;
            private Object referred_by;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMerchant_driver_id() {
                return merchant_driver_id;
            }

            public void setMerchant_driver_id(String merchant_driver_id) {
                this.merchant_driver_id = merchant_driver_id;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public Object getLast_bill_generated() {
                return last_bill_generated;
            }

            public void setLast_bill_generated(Object last_bill_generated) {
                this.last_bill_generated = last_bill_generated;
            }

            public int getSubscription_wise_commission() {
                return subscription_wise_commission;
            }

            public void setSubscription_wise_commission(int subscription_wise_commission) {
                this.subscription_wise_commission = subscription_wise_commission;
            }

            public Object getTaxi_company_id() {
                return taxi_company_id;
            }

            public void setTaxi_company_id(Object taxi_company_id) {
                this.taxi_company_id = taxi_company_id;
            }

            public Object getUnique_number() {
                return unique_number;
            }

            public void setUnique_number(Object unique_number) {
                this.unique_number = unique_number;
            }

            public int getDriver_gender() {
                return driver_gender;
            }

            public void setDriver_gender(int driver_gender) {
                this.driver_gender = driver_gender;
            }

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Object getDriver_address() {
                return driver_address;
            }

            public void setDriver_address(Object driver_address) {
                this.driver_address = driver_address;
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

            public Object getAvail_seats() {
                return avail_seats;
            }

            public void setAvail_seats(Object avail_seats) {
                this.avail_seats = avail_seats;
            }

            public Object getOccupied_seats() {
                return occupied_seats;
            }

            public void setOccupied_seats(Object occupied_seats) {
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

            public String getWallet_money() {
                return wallet_money;
            }

            public void setWallet_money(String wallet_money) {
                this.wallet_money = wallet_money;
            }

            public Object getTotal_trips() {
                return total_trips;
            }

            public void setTotal_trips(Object total_trips) {
                this.total_trips = total_trips;
            }

            public Object getTotal_earnings() {
                return total_earnings;
            }

            public void setTotal_earnings(Object total_earnings) {
                this.total_earnings = total_earnings;
            }

            public Object getTotal_comany_earning() {
                return total_comany_earning;
            }

            public void setTotal_comany_earning(Object total_comany_earning) {
                this.total_comany_earning = total_comany_earning;
            }

            public Object getOutstand_amount() {
                return outstand_amount;
            }

            public void setOutstand_amount(Object outstand_amount) {
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

            public Object getBank_name() {
                return bank_name;
            }

            public void setBank_name(Object bank_name) {
                this.bank_name = bank_name;
            }

            public Object getAccount_holder_name() {
                return account_holder_name;
            }

            public void setAccount_holder_name(Object account_holder_name) {
                this.account_holder_name = account_holder_name;
            }

            public Object getAccount_number() {
                return account_number;
            }

            public void setAccount_number(Object account_number) {
                this.account_number = account_number;
            }

            public Object getAccount_type_id() {
                return account_type_id;
            }

            public void setAccount_type_id(Object account_type_id) {
                this.account_type_id = account_type_id;
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

            public Object getOnline_code() {
                return online_code;
            }

            public void setOnline_code(Object online_code) {
                this.online_code = online_code;
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

            public String getAdmin_msg() {
                return admin_msg;
            }

            public void setAdmin_msg(String admin_msg) {
                this.admin_msg = admin_msg;
            }

            public Object getFullName() {
                return fullName;
            }

            public void setFullName(Object fullName) {
                this.fullName = fullName;
            }

            public Object getDob() {
                return dob;
            }

            public void setDob(Object dob) {
                this.dob = dob;
            }

            public int getReject_driver() {
                return reject_driver;
            }

            public void setReject_driver(int reject_driver) {
                this.reject_driver = reject_driver;
            }

            public Object getDriver_cpf_number() {
                return driver_cpf_number;
            }

            public void setDriver_cpf_number(Object driver_cpf_number) {
                this.driver_cpf_number = driver_cpf_number;
            }

            public Object getAgency_number() {
                return agency_number;
            }

            public void setAgency_number(Object agency_number) {
                this.agency_number = agency_number;
            }

            public Object getDriver_additional_data() {
                return driver_additional_data;
            }

            public void setDriver_additional_data(Object driver_additional_data) {
                this.driver_additional_data = driver_additional_data;
            }

            public int getReward_points() {
                return reward_points;
            }

            public void setReward_points(int reward_points) {
                this.reward_points = reward_points;
            }

            public int getUsable_reward_points() {
                return usable_reward_points;
            }

            public void setUsable_reward_points(int usable_reward_points) {
                this.usable_reward_points = usable_reward_points;
            }

            public int getUse_reward_trip_count() {
                return use_reward_trip_count;
            }

            public void setUse_reward_trip_count(int use_reward_trip_count) {
                this.use_reward_trip_count = use_reward_trip_count;
            }

            public Object getIs_suspended() {
                return is_suspended;
            }

            public void setIs_suspended(Object is_suspended) {
                this.is_suspended = is_suspended;
            }

            public Object getNetwork_code() {
                return network_code;
            }

            public void setNetwork_code(Object network_code) {
                this.network_code = network_code;
            }

            public Object getReferred_by() {
                return referred_by;
            }

            public void setReferred_by(Object referred_by) {
                this.referred_by = referred_by;
            }
        }
    }
}
