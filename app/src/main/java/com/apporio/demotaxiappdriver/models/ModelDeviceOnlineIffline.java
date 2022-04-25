package com.apporio.demotaxiappdriver.models;

/**
 * Created by lenovo-pc on 12/30/2017.
 */

public class ModelDeviceOnlineIffline {


    /**
     * result : 1
     * message : Your Are Offline Now
     * data : {"id":12,"merchant_id":"1","fullName":"samir","email":"samir@apporio.com","password":"$2y$10$6VdeSseXUZsmG5bUcpmC9OxCg7GQL/MGwebArqzKYlRgqyHcwKqG2","phoneNumber":"+919650923086","profile_image":"driver/rgayS1YXB9uGuvb3kDUoPXiiGRPmSLGzhhQ4PooP.jpeg","current_latitude":"28.4123996","current_longitude":"77.0440901","bearing":"0.0","accuracy":"26.65","country_area_id":"5","login_logout":"2","online_offline":"2","free_busy":"1","driver_verify_status":"1","signupFrom":"1","signupStep":"3","driver_verification_date":null,"driver_admin_status":"1","created_at":"2018-07-03 06:06:33","updated_at":"2018-07-05 11:14:45"}
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
         * id : 12
         * merchant_id : 1
         * fullName : samir
         * email : samir@apporio.com
         * password : $2y$10$6VdeSseXUZsmG5bUcpmC9OxCg7GQL/MGwebArqzKYlRgqyHcwKqG2
         * phoneNumber : +919650923086
         * profile_image : driver/rgayS1YXB9uGuvb3kDUoPXiiGRPmSLGzhhQ4PooP.jpeg
         * current_latitude : 28.4123996
         * current_longitude : 77.0440901
         * bearing : 0.0
         * accuracy : 26.65
         * country_area_id : 5
         * login_logout : 2
         * online_offline : 2
         * free_busy : 1
         * driver_verify_status : 1
         * signupFrom : 1
         * signupStep : 3
         * driver_verification_date : null
         * driver_admin_status : 1
         * created_at : 2018-07-03 06:06:33
         * updated_at : 2018-07-05 11:14:45
         */

        private int id;
        private String merchant_id;
        private String fullName;
        private String email;
        private String password;
        private String phoneNumber;
        private String profile_image;
        private String current_latitude;
        private String current_longitude;
        private String bearing;
        private String accuracy;
        private String country_area_id;
        private String login_logout;
        private String online_offline;
        private String free_busy;
        private String driver_verify_status;
        private String signupFrom;
        private String signupStep;
        private Object driver_verification_date;
        private String driver_admin_status;
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
