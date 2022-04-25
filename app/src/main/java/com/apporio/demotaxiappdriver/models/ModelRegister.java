package com.apporio.demotaxiappdriver.models;

public class ModelRegister {

    /**
     * result : 1
     * message : Signup Sucessfully
     * data : {"merchant_id":1,"fullName":"samir","email":"samir@apporio.com","phoneNumber":"+919650923085","country_area_id":"5","password":"$2y$10$bJahlSNnuSaRy4MGLhFQAeUTsPk8QhvYoNlKvYoep5anzDuXd1I06","profile_image":"driver/znX2v0myvXFvw9D00XJSSWxyf3KdFFNgbWBoLERD.png","updated_at":"2018-07-04 04:59:07","created_at":"2018-07-04 04:59:07","id":13}
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
         * merchant_id : 1
         * fullName : samir
         * email : samir@apporio.com
         * phoneNumber : +919650923085
         * country_area_id : 5
         * password : $2y$10$bJahlSNnuSaRy4MGLhFQAeUTsPk8QhvYoNlKvYoep5anzDuXd1I06
         * profile_image : driver/znX2v0myvXFvw9D00XJSSWxyf3KdFFNgbWBoLERD.png
         * updated_at : 2018-07-04 04:59:07
         * created_at : 2018-07-04 04:59:07
         * id : 13
         */

        private int merchant_id;
        private String fullName;
        private String email;
        private String phoneNumber;
        private String country_area_id;
        private String password;
        private String profile_image;
        private String updated_at;
        private String created_at;
        private int id;

        public int getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(int merchant_id) {
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

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getCountry_area_id() {
            return country_area_id;
        }

        public void setCountry_area_id(String country_area_id) {
            this.country_area_id = country_area_id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
