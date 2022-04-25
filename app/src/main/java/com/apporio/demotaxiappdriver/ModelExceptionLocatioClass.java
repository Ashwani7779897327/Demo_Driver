package com.apporio.demotaxiappdriver;

import java.util.List;

public class ModelExceptionLocatioClass {


    private String result;
    private String message;
    private BookingBean booking;
    private List<?> data;

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

    public BookingBean getBooking() {
        return booking;
    }

    public void setBooking(BookingBean booking) {
        this.booking = booking;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public static class BookingBean {
        private int id;
        private int merchant_id;
        private Object unique_number;
        private int driver_gender;
        private String first_name;
        private String last_name;
        private String email;
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
        private String wallet_money;
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
        private Object bank_name;
        private Object account_holder_name;
        private Object account_number;
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
        private int expire_personal_document;
        private int expire_vehicle_document;
        private Object admin_msg;
        private Object fullName;
        private Object dob;
        private int reject_driver;
        private CountryAreaBean country_area;

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

        public String getWallet_money() {
            return wallet_money;
        }

        public void setWallet_money(String wallet_money) {
            this.wallet_money = wallet_money;
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

        public CountryAreaBean getCountry_area() {
            return country_area;
        }

        public void setCountry_area(CountryAreaBean country_area) {
            this.country_area = country_area;
        }

        public static class CountryAreaBean {
            private int id;
            private int merchant_id;
            private String country_id;
            private String AreaCoordinates;
            private int auto_upgradetion;
            private String timezone;
            private String minimum_wallet_amount;
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

            public String getMinimum_wallet_amount() {
                return minimum_wallet_amount;
            }

            public void setMinimum_wallet_amount(String minimum_wallet_amount) {
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
    }
}
