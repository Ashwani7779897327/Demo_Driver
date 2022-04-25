package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class SampleModel {


    /**
     * data : {"currency":"INR","ride_config":{"auto_upgradetion":1,"auto_upgradetion_status":"2","pool_enable":false,"pool_enable_status":2},"home_address_activated":2,"active_vehicle":{},"active_rides":[],"scheduled_rides":[],"admin_message":[{"headline":"Gender Update!","message":"We need Your Gender Information!","action":"GENDER_UPDATE","show":false},{"headline":"Subscription Package Not Bought Yet, please buy one","message":"Subscription Package Not Bought Yet, please buy one","action":"SUBSCRIPTION_BUY","show":false},{"headline":"Subscription Package Expired","message":"Subscription Package Expired","action":"SUBSCRIPTION_EXPIRE","show":false},{"headline":"Your Personal Document","message":"Your Documents are under review","action":"PERSONAL_DOCUMENT_EXPIRE","show":false},{"headline":"Your Vehicle Document","message":"Your Documents are under review","action":"VEHICLE_DOCUMENT_EXPIRE","show":false},{"headline":"Wallet Balance","message":"Wallet Balance","action":"WALLET_BALANCE","show":false}],"document_message":[{"headline":"Document status","message":"Some of documents are either expired or pending, please upload.","action":"DOCUMENT_STATUS","show":true}],"todays":{"todays_rides":"0","todays_rides_color":"bbbbbb","todays_earning":"INR 0.00","todays_earning_color":"2ecc71"},"term_status":0,"available_services":[],"additional_bank_data":false,"additional_bank_data_title":"","additional_bank_data_placeholder":"","refer_enable":true,"is_suspended":"","driver_data":{"driver_name":"Shilpa Rawat","profile_image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/driver/1571289835_5da7faebcf17f_driver.jpg"}}
     * result : 1
     * message : User Active Booking
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
         * currency : INR
         * ride_config : {"auto_upgradetion":1,"auto_upgradetion_status":"2","pool_enable":false,"pool_enable_status":2}
         * home_address_activated : 2
         * active_vehicle : {}
         * active_rides : []
         * scheduled_rides : []
         * admin_message : [{"headline":"Gender Update!","message":"We need Your Gender Information!","action":"GENDER_UPDATE","show":false},{"headline":"Subscription Package Not Bought Yet, please buy one","message":"Subscription Package Not Bought Yet, please buy one","action":"SUBSCRIPTION_BUY","show":false},{"headline":"Subscription Package Expired","message":"Subscription Package Expired","action":"SUBSCRIPTION_EXPIRE","show":false},{"headline":"Your Personal Document","message":"Your Documents are under review","action":"PERSONAL_DOCUMENT_EXPIRE","show":false},{"headline":"Your Vehicle Document","message":"Your Documents are under review","action":"VEHICLE_DOCUMENT_EXPIRE","show":false},{"headline":"Wallet Balance","message":"Wallet Balance","action":"WALLET_BALANCE","show":false}]
         * document_message : [{"headline":"Document status","message":"Some of documents are either expired or pending, please upload.","action":"DOCUMENT_STATUS","show":true}]
         * todays : {"todays_rides":"0","todays_rides_color":"bbbbbb","todays_earning":"INR 0.00","todays_earning_color":"2ecc71"}
         * term_status : 0
         * available_services : []
         * additional_bank_data : false
         * additional_bank_data_title :
         * additional_bank_data_placeholder :
         * refer_enable : true
         * is_suspended :
         * driver_data : {"driver_name":"Shilpa Rawat","profile_image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/driver/1571289835_5da7faebcf17f_driver.jpg"}
         */

        private String currency;
        private RideConfigBean ride_config;
        private int home_address_activated;
        private ActiveVehicleBean active_vehicle;
        private TodaysBean todays;
        private int term_status;
        private boolean additional_bank_data;
        private String additional_bank_data_title;
        private String additional_bank_data_placeholder;
        private boolean refer_enable;
        private String is_suspended;
        private DriverDataBean driver_data;
        private List<?> active_rides;
        private List<?> scheduled_rides;
        private List<AdminMessageBean> admin_message;
        private List<DocumentMessageBean> document_message;
        private List<?> available_services;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public RideConfigBean getRide_config() {
            return ride_config;
        }

        public void setRide_config(RideConfigBean ride_config) {
            this.ride_config = ride_config;
        }

        public int getHome_address_activated() {
            return home_address_activated;
        }

        public void setHome_address_activated(int home_address_activated) {
            this.home_address_activated = home_address_activated;
        }

        public ActiveVehicleBean getActive_vehicle() {
            return active_vehicle;
        }

        public void setActive_vehicle(ActiveVehicleBean active_vehicle) {
            this.active_vehicle = active_vehicle;
        }

        public TodaysBean getTodays() {
            return todays;
        }

        public void setTodays(TodaysBean todays) {
            this.todays = todays;
        }

        public int getTerm_status() {
            return term_status;
        }

        public void setTerm_status(int term_status) {
            this.term_status = term_status;
        }

        public boolean isAdditional_bank_data() {
            return additional_bank_data;
        }

        public void setAdditional_bank_data(boolean additional_bank_data) {
            this.additional_bank_data = additional_bank_data;
        }

        public String getAdditional_bank_data_title() {
            return additional_bank_data_title;
        }

        public void setAdditional_bank_data_title(String additional_bank_data_title) {
            this.additional_bank_data_title = additional_bank_data_title;
        }

        public String getAdditional_bank_data_placeholder() {
            return additional_bank_data_placeholder;
        }

        public void setAdditional_bank_data_placeholder(String additional_bank_data_placeholder) {
            this.additional_bank_data_placeholder = additional_bank_data_placeholder;
        }

        public boolean isRefer_enable() {
            return refer_enable;
        }

        public void setRefer_enable(boolean refer_enable) {
            this.refer_enable = refer_enable;
        }

        public String getIs_suspended() {
            return is_suspended;
        }

        public void setIs_suspended(String is_suspended) {
            this.is_suspended = is_suspended;
        }

        public DriverDataBean getDriver_data() {
            return driver_data;
        }

        public void setDriver_data(DriverDataBean driver_data) {
            this.driver_data = driver_data;
        }

        public List<?> getActive_rides() {
            return active_rides;
        }

        public void setActive_rides(List<?> active_rides) {
            this.active_rides = active_rides;
        }

        public List<?> getScheduled_rides() {
            return scheduled_rides;
        }

        public void setScheduled_rides(List<?> scheduled_rides) {
            this.scheduled_rides = scheduled_rides;
        }

        public List<AdminMessageBean> getAdmin_message() {
            return admin_message;
        }

        public void setAdmin_message(List<AdminMessageBean> admin_message) {
            this.admin_message = admin_message;
        }

        public List<DocumentMessageBean> getDocument_message() {
            return document_message;
        }

        public void setDocument_message(List<DocumentMessageBean> document_message) {
            this.document_message = document_message;
        }

        public List<?> getAvailable_services() {
            return available_services;
        }

        public void setAvailable_services(List<?> available_services) {
            this.available_services = available_services;
        }

        public static class RideConfigBean {
        }

        public static class ActiveVehicleBean {
        }

        public static class TodaysBean {
            /**
             * todays_rides : 0
             * todays_rides_color : bbbbbb
             * todays_earning : INR 0.00
             * todays_earning_color : 2ecc71
             */

            private String todays_rides;
            private String todays_rides_color;
            private String todays_earning;
            private String todays_earning_color;

            public String getTodays_rides() {
                return todays_rides;
            }

            public void setTodays_rides(String todays_rides) {
                this.todays_rides = todays_rides;
            }

            public String getTodays_rides_color() {
                return todays_rides_color;
            }

            public void setTodays_rides_color(String todays_rides_color) {
                this.todays_rides_color = todays_rides_color;
            }

            public String getTodays_earning() {
                return todays_earning;
            }

            public void setTodays_earning(String todays_earning) {
                this.todays_earning = todays_earning;
            }

            public String getTodays_earning_color() {
                return todays_earning_color;
            }

            public void setTodays_earning_color(String todays_earning_color) {
                this.todays_earning_color = todays_earning_color;
            }
        }

        public static class DriverDataBean {
            /**
             * driver_name : Shilpa Rawat
             * profile_image : https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/driver/1571289835_5da7faebcf17f_driver.jpg
             */

            private String driver_name;
            private String profile_image;

            public String getDriver_name() {
                return driver_name;
            }

            public void setDriver_name(String driver_name) {
                this.driver_name = driver_name;
            }

            public String getProfile_image() {
                return profile_image;
            }

            public void setProfile_image(String profile_image) {
                this.profile_image = profile_image;
            }
        }

        public static class AdminMessageBean {
            /**
             * headline : Gender Update!
             * message : We need Your Gender Information!
             * action : GENDER_UPDATE
             * show : false
             */

            private String headline;
            private String message;
            private String action;
            private boolean show;

            public String getHeadline() {
                return headline;
            }

            public void setHeadline(String headline) {
                this.headline = headline;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public boolean isShow() {
                return show;
            }

            public void setShow(boolean show) {
                this.show = show;
            }
        }

        public static class DocumentMessageBean {
            /**
             * headline : Document status
             * message : Some of documents are either expired or pending, please upload.
             * action : DOCUMENT_STATUS
             * show : true
             */

            private String headline;
            private String message;
            private String action;
            private boolean show;

            public String getHeadline() {
                return headline;
            }

            public void setHeadline(String headline) {
                this.headline = headline;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public boolean isShow() {
                return show;
            }

            public void setShow(boolean show) {
                this.show = show;
            }
        }
    }
}