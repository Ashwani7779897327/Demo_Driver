package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelDriverVehicles {

    private String result;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String merchant_id;
        private String driver_id;
        private String owner_id;
        private String vehicle_type_id;
        private String shareCode;
        private String vehicle_make_id;
        private String vehicle_model_id;
        private String vehicle_number;
        private String vehicle_color;
        private String vehicle_image;
        private String vehicle_number_plate_image;
        private String vehicle_active_status;
        private String vehicle_verification_status;
        private Object reject_reason_id;
        private String created_at;
        private String updated_at;
        private String vehicle_type;
        private String vehicleTypeImage;
        private String vehicleTypeMapImage;
        private String pool_enable;
        private String vehicle_make;
        private String vehicleMakeLogo;
        private String vehicle_model;
        private int ready_for_live;
        private String show_msg;
        private String service_types;
        private DriverBean driver;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(String merchant_id) {
            this.merchant_id = merchant_id;
        }

        public String getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(String driver_id) {
            this.driver_id = driver_id;
        }

        public String getOwner_id() {
            return owner_id;
        }

        public void setOwner_id(String owner_id) {
            this.owner_id = owner_id;
        }

        public String getVehicle_type_id() {
            return vehicle_type_id;
        }

        public void setVehicle_type_id(String vehicle_type_id) {
            this.vehicle_type_id = vehicle_type_id;
        }

        public String getShareCode() {
            return shareCode;
        }

        public void setShareCode(String shareCode) {
            this.shareCode = shareCode;
        }

        public String getVehicle_make_id() {
            return vehicle_make_id;
        }

        public void setVehicle_make_id(String vehicle_make_id) {
            this.vehicle_make_id = vehicle_make_id;
        }

        public String getVehicle_model_id() {
            return vehicle_model_id;
        }

        public void setVehicle_model_id(String vehicle_model_id) {
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

        public String getVehicle_active_status() {
            return vehicle_active_status;
        }

        public void setVehicle_active_status(String vehicle_active_status) {
            this.vehicle_active_status = vehicle_active_status;
        }

        public String getVehicle_verification_status() {
            return vehicle_verification_status;
        }

        public void setVehicle_verification_status(String vehicle_verification_status) {
            this.vehicle_verification_status = vehicle_verification_status;
        }

        public Object getReject_reason_id() {
            return reject_reason_id;
        }

        public void setReject_reason_id(Object reject_reason_id) {
            this.reject_reason_id = reject_reason_id;
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

        public String getVehicle_type() {
            return vehicle_type;
        }

        public void setVehicle_type(String vehicle_type) {
            this.vehicle_type = vehicle_type;
        }

        public String getVehicleTypeImage() {
            return vehicleTypeImage;
        }

        public void setVehicleTypeImage(String vehicleTypeImage) {
            this.vehicleTypeImage = vehicleTypeImage;
        }

        public String getVehicleTypeMapImage() {
            return vehicleTypeMapImage;
        }

        public void setVehicleTypeMapImage(String vehicleTypeMapImage) {
            this.vehicleTypeMapImage = vehicleTypeMapImage;
        }

        public String getPool_enable() {
            return pool_enable;
        }

        public void setPool_enable(String pool_enable) {
            this.pool_enable = pool_enable;
        }

        public String getVehicle_make() {
            return vehicle_make;
        }

        public void setVehicle_make(String vehicle_make) {
            this.vehicle_make = vehicle_make;
        }

        public String getVehicleMakeLogo() {
            return vehicleMakeLogo;
        }

        public void setVehicleMakeLogo(String vehicleMakeLogo) {
            this.vehicleMakeLogo = vehicleMakeLogo;
        }

        public String getVehicle_model() {
            return vehicle_model;
        }

        public void setVehicle_model(String vehicle_model) {
            this.vehicle_model = vehicle_model;
        }

        public int getReady_for_live() {
            return ready_for_live;
        }

        public void setReady_for_live(int ready_for_live) {
            this.ready_for_live = ready_for_live;
        }

        public String getShow_msg() {
            return show_msg;
        }

        public void setShow_msg(String show_msg) {
            this.show_msg = show_msg;
        }

        public String getService_types() {
            return service_types;
        }

        public void setService_types(String service_types) {
            this.service_types = service_types;
        }

        public DriverBean getDriver() {
            return driver;
        }

        public void setDriver(DriverBean driver) {
            this.driver = driver;
        }

        public static class DriverBean {
            private int id;
            private String merchant_id;
            private Object unique_number;
            private String driver_gender;
            private String fullName;
            private String email;
            private String password;
            private String home_location_active;
            private String pool_ride_active;
            private String status_for_pool;
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
            private String country_area_id;
            private String login_logout;
            private String online_offline;
            private String free_busy;
            private String bank_name;
            private String account_holder_name;
            private String account_number;
            private String driver_verify_status;
            private String signupFrom;
            private String signupStep;
            private Object driver_verification_date;
            private String driver_admin_status;
            private String access_token_id;
            private String driver_delete;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(String merchant_id) {
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

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
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

            public String getHome_location_active() {
                return home_location_active;
            }

            public void setHome_location_active(String home_location_active) {
                this.home_location_active = home_location_active;
            }

            public String getPool_ride_active() {
                return pool_ride_active;
            }

            public void setPool_ride_active(String pool_ride_active) {
                this.pool_ride_active = pool_ride_active;
            }

            public String getStatus_for_pool() {
                return status_for_pool;
            }

            public void setStatus_for_pool(String status_for_pool) {
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

            public String getCountry_area_id() {
                return country_area_id;
            }

            public void setCountry_area_id(String country_area_id) {
                this.country_area_id = country_area_id;
            }

            public String getLogin_logout() {
                return login_logout;
            }

            public void setLogin_logout(String login_logout) {
                this.login_logout = login_logout;
            }

            public String getOnline_offline() {
                return online_offline;
            }

            public void setOnline_offline(String online_offline) {
                this.online_offline = online_offline;
            }

            public String getFree_busy() {
                return free_busy;
            }

            public void setFree_busy(String free_busy) {
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

            public String getDriver_verify_status() {
                return driver_verify_status;
            }

            public void setDriver_verify_status(String driver_verify_status) {
                this.driver_verify_status = driver_verify_status;
            }

            public String getSignupFrom() {
                return signupFrom;
            }

            public void setSignupFrom(String signupFrom) {
                this.signupFrom = signupFrom;
            }

            public String getSignupStep() {
                return signupStep;
            }

            public void setSignupStep(String signupStep) {
                this.signupStep = signupStep;
            }

            public Object getDriver_verification_date() {
                return driver_verification_date;
            }

            public void setDriver_verification_date(Object driver_verification_date) {
                this.driver_verification_date = driver_verification_date;
            }

            public String getDriver_admin_status() {
                return driver_admin_status;
            }

            public void setDriver_admin_status(String driver_admin_status) {
                this.driver_admin_status = driver_admin_status;
            }

            public String getAccess_token_id() {
                return access_token_id;
            }

            public void setAccess_token_id(String access_token_id) {
                this.access_token_id = access_token_id;
            }

            public String getDriver_delete() {
                return driver_delete;
            }

            public void setDriver_delete(String driver_delete) {
                this.driver_delete = driver_delete;
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