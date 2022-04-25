package com.apporio.demotaxiappdriver.newmodels;

import java.util.List;

public class TestModel {


    /**
     * data : {"currency":"INR","ride_config":{"auto_upgradetion":2,"auto_upgradetion_status":2,"pool_enable":true,"pool_enable_status":1},"home_address_activated":2,"active_vehicle":{"id":8888,"merchant_id":90,"driver_id":10948,"owner_id":10948,"ownerType":1,"vehicle_type_id":244,"shareCode":"72828383","vehicle_make_id":355,"vehicle_model_id":898,"vehicle_number":"72828383","vehicle_color":"red","vehicle_image":"driverVehicle/9zcG40DA0fhzD8NlHTyKqPiJeFT6toxivxV1nwNY.jpeg","vehicle_number_plate_image":"driverVehicle/ulnIMQUrs2gax52XxaFhfCHy0QkGhlly0Ga84hCU.jpeg","vehicle_active_status":1,"vehicle_verification_status":1,"reject_reason_id":null,"ac_nonac":null,"baby_seat":null,"wheel_chair":null,"created_at":"2019-04-16 07:34:12","updated_at":"2019-04-16 13:04:39","vehicle_type":"Luxury","vehicleTypeImage":"vehicle/olJ7tMoSuXpHTGQ2igkUIFg8lLumf6764alTZQHe.png"},"active_rides":[{"booking_id":"15407","id":10146,"UserPhone":"+918950368358","UserName":" ","email":"gag.vishal5115@gmail.com","UserProfileImage":"user/VkH2CsVwowvQgIiPERqKMFgs4OwVb8SoDRXUVlwg.jpeg","ride_status_text":"Riding Now","ride_status_color":"2ecc71"}],"scheduled_rides":[],"admin_message":[{"headline":"Gender Update!","message":"We need Your Gender Information!","action":"GENDER_UPDATE","show":false},{"headline":"Subscription Package Not Bought Yet, please buy one","message":"Subscription Package Not Bought Yet, please buy one","action":"SUBSCRIPTION_BUY","show":false},{"headline":"Subscription Package Expired","message":"Subscription Package Expired","action":"SUBSCRIPTION_EXPIRE","show":false},{"headline":"Your Personal Document","message":"Your Personal Document Expired","action":"PERSONAL_DOCUMENT_EXPIRE","show":true},{"headline":"Your Vehicle Document","message":"Your Documents are under review","action":"VEHICLE_DOCUMENT_EXPIRE","show":false}],"todays":{"todays_rides":"0","todays_rides_color":"bbbbbb","todays_earning":"INR 0.00","todays_earning_color":"2ecc71"},"term_status":0,"available_services":[{"service_id":2,"serviceName":"Rental"},{"service_id":1,"serviceName":"Normal"},{"service_id":4,"serviceName":"Outstation"}]}
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
         * ride_config : {"auto_upgradetion":2,"auto_upgradetion_status":2,"pool_enable":true,"pool_enable_status":1}
         * home_address_activated : 2
         * active_vehicle : {"id":8888,"merchant_id":90,"driver_id":10948,"owner_id":10948,"ownerType":1,"vehicle_type_id":244,"shareCode":"72828383","vehicle_make_id":355,"vehicle_model_id":898,"vehicle_number":"72828383","vehicle_color":"red","vehicle_image":"driverVehicle/9zcG40DA0fhzD8NlHTyKqPiJeFT6toxivxV1nwNY.jpeg","vehicle_number_plate_image":"driverVehicle/ulnIMQUrs2gax52XxaFhfCHy0QkGhlly0Ga84hCU.jpeg","vehicle_active_status":1,"vehicle_verification_status":1,"reject_reason_id":null,"ac_nonac":null,"baby_seat":null,"wheel_chair":null,"created_at":"2019-04-16 07:34:12","updated_at":"2019-04-16 13:04:39","vehicle_type":"Luxury","vehicleTypeImage":"vehicle/olJ7tMoSuXpHTGQ2igkUIFg8lLumf6764alTZQHe.png"}
         * active_rides : [{"booking_id":"15407","id":10146,"UserPhone":"+918950368358","UserName":" ","email":"gag.vishal5115@gmail.com","UserProfileImage":"user/VkH2CsVwowvQgIiPERqKMFgs4OwVb8SoDRXUVlwg.jpeg","ride_status_text":"Riding Now","ride_status_color":"2ecc71"}]
         * scheduled_rides : []
         * admin_message : [{"headline":"Gender Update!","message":"We need Your Gender Information!","action":"GENDER_UPDATE","show":false},{"headline":"Subscription Package Not Bought Yet, please buy one","message":"Subscription Package Not Bought Yet, please buy one","action":"SUBSCRIPTION_BUY","show":false},{"headline":"Subscription Package Expired","message":"Subscription Package Expired","action":"SUBSCRIPTION_EXPIRE","show":false},{"headline":"Your Personal Document","message":"Your Personal Document Expired","action":"PERSONAL_DOCUMENT_EXPIRE","show":true},{"headline":"Your Vehicle Document","message":"Your Documents are under review","action":"VEHICLE_DOCUMENT_EXPIRE","show":false}]
         * todays : {"todays_rides":"0","todays_rides_color":"bbbbbb","todays_earning":"INR 0.00","todays_earning_color":"2ecc71"}
         * term_status : 0
         * available_services : [{"service_id":2,"serviceName":"Rental"},{"service_id":1,"serviceName":"Normal"},{"service_id":4,"serviceName":"Outstation"}]
         */

        private String currency;
        private RideConfigBean ride_config;
        private int home_address_activated;
        private ActiveVehicleBean active_vehicle;
        private TodaysBean todays;
        private int term_status;
        private List<ActiveRidesBean> active_rides;
        private List<?> scheduled_rides;
        private List<AdminMessageBean> admin_message;
        private List<AvailableServicesBean> available_services;

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

        public List<ActiveRidesBean> getActive_rides() {
            return active_rides;
        }

        public void setActive_rides(List<ActiveRidesBean> active_rides) {
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

        public List<AvailableServicesBean> getAvailable_services() {
            return available_services;
        }

        public void setAvailable_services(List<AvailableServicesBean> available_services) {
            this.available_services = available_services;
        }

        public static class RideConfigBean {
            /**
             * auto_upgradetion : 2
             * auto_upgradetion_status : 2
             * pool_enable : true
             * pool_enable_status : 1
             */

            private int auto_upgradetion;
            private int auto_upgradetion_status;
            private boolean pool_enable;
            private int pool_enable_status;

            public int getAuto_upgradetion() {
                return auto_upgradetion;
            }

            public void setAuto_upgradetion(int auto_upgradetion) {
                this.auto_upgradetion = auto_upgradetion;
            }

            public int getAuto_upgradetion_status() {
                return auto_upgradetion_status;
            }

            public void setAuto_upgradetion_status(int auto_upgradetion_status) {
                this.auto_upgradetion_status = auto_upgradetion_status;
            }

            public boolean isPool_enable() {
                return pool_enable;
            }

            public void setPool_enable(boolean pool_enable) {
                this.pool_enable = pool_enable;
            }

            public int getPool_enable_status() {
                return pool_enable_status;
            }

            public void setPool_enable_status(int pool_enable_status) {
                this.pool_enable_status = pool_enable_status;
            }
        }

        public static class ActiveVehicleBean {
            /**
             * id : 8888
             * merchant_id : 90
             * driver_id : 10948
             * owner_id : 10948
             * ownerType : 1
             * vehicle_type_id : 244
             * shareCode : 72828383
             * vehicle_make_id : 355
             * vehicle_model_id : 898
             * vehicle_number : 72828383
             * vehicle_color : red
             * vehicle_image : driverVehicle/9zcG40DA0fhzD8NlHTyKqPiJeFT6toxivxV1nwNY.jpeg
             * vehicle_number_plate_image : driverVehicle/ulnIMQUrs2gax52XxaFhfCHy0QkGhlly0Ga84hCU.jpeg
             * vehicle_active_status : 1
             * vehicle_verification_status : 1
             * reject_reason_id : null
             * ac_nonac : null
             * baby_seat : null
             * wheel_chair : null
             * created_at : 2019-04-16 07:34:12
             * updated_at : 2019-04-16 13:04:39
             * vehicle_type : Luxury
             * vehicleTypeImage : vehicle/olJ7tMoSuXpHTGQ2igkUIFg8lLumf6764alTZQHe.png
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
            private String created_at;
            private String updated_at;
            private String vehicle_type;
            private String vehicleTypeImage;

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

        public static class ActiveRidesBean {
            /**
             * booking_id : 15407
             * id : 10146
             * UserPhone : +918950368358
             * UserName :
             * email : gag.vishal5115@gmail.com
             * UserProfileImage : user/VkH2CsVwowvQgIiPERqKMFgs4OwVb8SoDRXUVlwg.jpeg
             * ride_status_text : Riding Now
             * ride_status_color : 2ecc71
             */

            private String booking_id;
            private int id;
            private String UserPhone;
            private String UserName;
            private String email;
            private String UserProfileImage;
            private String ride_status_text;
            private String ride_status_color;

            public String getBooking_id() {
                return booking_id;
            }

            public void setBooking_id(String booking_id) {
                this.booking_id = booking_id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUserPhone() {
                return UserPhone;
            }

            public void setUserPhone(String UserPhone) {
                this.UserPhone = UserPhone;
            }

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getUserProfileImage() {
                return UserProfileImage;
            }

            public void setUserProfileImage(String UserProfileImage) {
                this.UserProfileImage = UserProfileImage;
            }

            public String getRide_status_text() {
                return ride_status_text;
            }

            public void setRide_status_text(String ride_status_text) {
                this.ride_status_text = ride_status_text;
            }

            public String getRide_status_color() {
                return ride_status_color;
            }

            public void setRide_status_color(String ride_status_color) {
                this.ride_status_color = ride_status_color;
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

        public static class AvailableServicesBean {
            /**
             * service_id : 2
             * serviceName : Rental
             */

            private int service_id;
            private String serviceName;

            public int getService_id() {
                return service_id;
            }

            public void setService_id(int service_id) {
                this.service_id = service_id;
            }

            public String getServiceName() {
                return serviceName;
            }

            public void setServiceName(String serviceName) {
                this.serviceName = serviceName;
            }
        }
    }
}
