package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelDriverDetails {

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
        private String country_id;
        private String phone_code;
        private String first_name;
        private String last_name;
        private int country_area_id;
        private int login_logout;
        private String account_holder_name;
        private String rating;
        private int driver_gender;
        private String driver_admin_status;
        private String signupFrom;
        private String current_latitude;
        private String phoneNumber;
        private String email;
        private String signupStep;
        private String account_number;
        private String wallet_money;
        private String player_id;
        private String password;
        private int id;
        private String current_longitude;
        private int free_busy;
        private String profile_image;
        private String bank_name;
        private int online_offline;
        private int term_status;
        private String created_at;
        private String smoker_type;
        private String auto_accept_enable;
        private String allow_other_smoker;
        private String home_location_active;
        private String selected_address;
        private boolean any_document_expire;
        private TotalEarningBean totalEarning;
        private List<DriverVehicleBean> DriverVehicle;
        private String subscription_wise_commission;
        private String online_code;

        public String getOnline_code() {
            return online_code;
        }

        public void setOnline_code(String online_code) {
            this.online_code = online_code;
        }

        public String getSubscription_wise_commission() {
            return subscription_wise_commission;
        }

        public void setSubscription_wise_commission(String subscription_wise_commission) {
            this.subscription_wise_commission = subscription_wise_commission;
        }



        public String getCountry_id() {
            return country_id;
        }

        public void setCountry_id(String country_id) {
            this.country_id = country_id;
        }

        public String getPhone_code() {
            return phone_code;
        }

        public void setPhone_code(String phone_code) {
            this.phone_code = phone_code;
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

        public String getAccount_holder_name() {
            return account_holder_name;
        }

        public void setAccount_holder_name(String account_holder_name) {
            this.account_holder_name = account_holder_name;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public int getDriver_gender() {
            return driver_gender;
        }

        public void setDriver_gender(int driver_gender) {
            this.driver_gender = driver_gender;
        }

        public String getDriver_admin_status() {
            return driver_admin_status;
        }

        public void setDriver_admin_status(String driver_admin_status) {
            this.driver_admin_status = driver_admin_status;
        }

        public String getSignupFrom() {
            return signupFrom;
        }

        public void setSignupFrom(String signupFrom) {
            this.signupFrom = signupFrom;
        }

        public String getCurrent_latitude() {
            return current_latitude;
        }

        public void setCurrent_latitude(String current_latitude) {
            this.current_latitude = current_latitude;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSignupStep() {
            return signupStep;
        }

        public void setSignupStep(String signupStep) {
            this.signupStep = signupStep;
        }

        public String getAccount_number() {
            return account_number;
        }

        public void setAccount_number(String account_number) {
            this.account_number = account_number;
        }

        public String getWallet_money() {
            return wallet_money;
        }

        public void setWallet_money(String wallet_money) {
            this.wallet_money = wallet_money;
        }

        public String getPlayer_id() {
            return player_id;
        }

        public void setPlayer_id(String player_id) {
            this.player_id = player_id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCurrent_longitude() {
            return current_longitude;
        }

        public void setCurrent_longitude(String current_longitude) {
            this.current_longitude = current_longitude;
        }

        public int getFree_busy() {
            return free_busy;
        }

        public void setFree_busy(int free_busy) {
            this.free_busy = free_busy;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public int getOnline_offline() {
            return online_offline;
        }

        public void setOnline_offline(int online_offline) {
            this.online_offline = online_offline;
        }

        public int getTerm_status() {
            return term_status;
        }

        public void setTerm_status(int term_status) {
            this.term_status = term_status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getSmoker_type() {
            return smoker_type;
        }

        public void setSmoker_type(String smoker_type) {
            this.smoker_type = smoker_type;
        }

        public String getAuto_accept_enable() {
            return auto_accept_enable;
        }

        public void setAuto_accept_enable(String auto_accept_enable) {
            this.auto_accept_enable = auto_accept_enable;
        }

        public String getAllow_other_smoker() {
            return allow_other_smoker;
        }

        public void setAllow_other_smoker(String allow_other_smoker) {
            this.allow_other_smoker = allow_other_smoker;
        }

        public String getHome_location_active() {
            return home_location_active;
        }

        public void setHome_location_active(String home_location_active) {
            this.home_location_active = home_location_active;
        }

        public String getSelected_address() {
            return selected_address;
        }

        public void setSelected_address(String selected_address) {
            this.selected_address = selected_address;
        }

        public boolean isAny_document_expire() {
            return any_document_expire;
        }

        public void setAny_document_expire(boolean any_document_expire) {
            this.any_document_expire = any_document_expire;
        }

        public TotalEarningBean getTotalEarning() {
            return totalEarning;
        }

        public void setTotalEarning(TotalEarningBean totalEarning) {
            this.totalEarning = totalEarning;
        }

        public List<DriverVehicleBean> getDriverVehicle() {
            return DriverVehicle;
        }

        public void setDriverVehicle(List<DriverVehicleBean> DriverVehicle) {
            this.DriverVehicle = DriverVehicle;
        }

        public static class TotalEarningBean {
            private int total_ride;
            private String total_earning;
            private String rating;

            public int getTotal_ride() {
                return total_ride;
            }

            public void setTotal_ride(int total_ride) {
                this.total_ride = total_ride;
            }

            public String getTotal_earning() {
                return total_earning;
            }

            public void setTotal_earning(String total_earning) {
                this.total_earning = total_earning;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }
        }

        public static class DriverVehicleBean {
            private int id;
            private int merchant_id;
            private int driver_id;
            private int owner_id;
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