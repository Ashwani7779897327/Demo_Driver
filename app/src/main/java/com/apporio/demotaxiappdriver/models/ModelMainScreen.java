package com.apporio.demotaxiappdriver.models;

import com.apporio.demotaxiappdriver.newmodels.TestModel;

import java.util.List;

public class ModelMainScreen {

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

        private RideConfigBean ride_config;
        private String home_address_activated;
        private ActiveVehicleBean active_vehicle;
        private TodaysBean todays;
        private List<ActiveRidesBean> active_rides;
        private List<?> scheduled_rides;
        private List<AdminMessageBean> admin_message;
        private List<AvailableServicesBean> available_services;
        private List<DocumentMessageBean> document_message;
        private String additional_bank_data_title;
        private Boolean additional_bank_data;
        private String additional_bank_data_placeholder;



        String upcoming_bookings;

        public String getUpcoming_bookings() {
            return upcoming_bookings;
        }

        public void setUpcoming_bookings(String upcoming_bookings) {
            this.upcoming_bookings = upcoming_bookings;
        }


        public String getAdditional_bank_data_title() {
            return additional_bank_data_title;
        }

        public void setAdditional_bank_data_title(String additional_bank_data_title) {
            this.additional_bank_data_title = additional_bank_data_title;
        }

        public Boolean getAdditional_bank_data() {
            return additional_bank_data;
        }

        public void setAdditional_bank_data(Boolean additional_bank_data) {
            this.additional_bank_data = additional_bank_data;
        }

        public String getAdditional_bank_data_placeholder() {
            return additional_bank_data_placeholder;
        }

        public void setAdditional_bank_data_placeholder(String additional_bank_data_placeholder) {
            this.additional_bank_data_placeholder = additional_bank_data_placeholder;
        }

        public int getTerm_status() {
            return term_status;
        }

        public void setTerm_status(int term_status) {
            this.term_status = term_status;
        }

        private int term_status;


        public RideConfigBean getRide_config() {
            return ride_config;
        }

        public void setRide_config(RideConfigBean ride_config) {
            this.ride_config = ride_config;
        }

        public String getHome_address_activated() {
            return home_address_activated;
        }

        public void setHome_address_activated(String home_address_activated) {
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

        public List<DocumentMessageBean> getDocument_message() {
            return document_message;
        }

        public void setDocument_message(List<DocumentMessageBean> document_message) {
            this.document_message = document_message;
        }

        public List<AvailableServicesBean> getAvailable_services() {
            return available_services;
        }

        public void setAvailable_services(List<AvailableServicesBean> available_services) {
            this.available_services = available_services;
        }


        public static class RideConfigBean {
            private String auto_upgradetion;
            private String auto_upgradetion_status;
            private boolean pool_enable;
            private String pool_enable_status;

            public String getAuto_upgradetion() {
                return auto_upgradetion;
            }

            public void setAuto_upgradetion(String auto_upgradetion) {
                this.auto_upgradetion = auto_upgradetion;
            }

            public String getAuto_upgradetion_status() {
                return auto_upgradetion_status;
            }

            public void setAuto_upgradetion_status(String auto_upgradetion_status) {
                this.auto_upgradetion_status = auto_upgradetion_status;
            }

            public boolean isPool_enable() {
                return pool_enable;
            }

            public void setPool_enable(boolean pool_enable) {
                this.pool_enable = pool_enable;
            }

            public String getPool_enable_status() {
                return pool_enable_status;
            }

            public void setPool_enable_status(String pool_enable_status) {
                this.pool_enable_status = pool_enable_status;
            }
        }


        public static class ActiveVehicleBean {
            /**
             * id : 1
             * driver_id : 1
             * vehicle_type_id : 1
             * vehicle_make_id : 1
             * vehicle_model_id : 1
             * vehicle_number : DL-7754
             * vehicle_color : white
             * vehicle_image : driverVehicle/cSiyM8QWm0vIXigCy1RuGfMPBHaqeCEAkKUs89nf.jpeg
             * vehicle_number_plate_image : driverVehicle/fvU4s2UHsi9uxDGvvsdXQyBlYJVlzRysOXXfa9Yy.jpeg
             * vehicle_active_status : 1
             * vehicle_verification_status : 1
             * created_at : 2018-08-03 12:36:02
             * updated_at : 2018-08-17 03:56:36
             * vehicle_type : Luxury
             * vehicleTypeImage : vehicle/pVuAWhCXUW0NVqqh2ochCvyTS3wq2Ii8hUc2RfmQ.png
             */

            private int id;
            private String driver_id;
            private String vehicle_type_id;
            private String vehicle_make_id;
            private String vehicle_model_id;
            private String vehicle_number;
            private String vehicle_color;
            private String vehicle_image;
            private String vehicle_number_plate_image;
            private String vehicle_active_status;
            private String vehicle_verification_status;
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

            public String getDriver_id() {
                return driver_id;
            }

            public void setDriver_id(String driver_id) {
                this.driver_id = driver_id;
            }

            public String getVehicle_type_id() {
                return vehicle_type_id;
            }

            public void setVehicle_type_id(String vehicle_type_id) {
                this.vehicle_type_id = vehicle_type_id;
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
             * todays_rides : 3 Rides
             * todays_rides_color : bbbbbb
             * todays_earning : 600
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
             * id : 1
             * UserName : Samir Goelgcbb
             * UserPhone : +919650923089
             * email : samir@apporio.com
             * UserProfileImage : user/e1MhuprUZc0v3JMebNhO4Ar7CGA7NbTQr3gXIKDT.jpeg
             * booking_id : 29
             * ride_status_text : Booking Accepted
             * ride_status_color : 9b59b6
             */

            private int id;
            private String UserName;
            private String UserPhone;
            private String email;
            private String UserProfileImage;
            private String booking_id;
            private String ride_status_text;
            private String ride_status_color;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getUserPhone() {
                return UserPhone;
            }

            public void setUserPhone(String UserPhone) {
                this.UserPhone = UserPhone;
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

            public String getBooking_id() {
                return booking_id;
            }

            public void setBooking_id(String booking_id) {
                this.booking_id = booking_id;
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
             * headline : Wallet Empty
             * message : you are no longer authorised to receive any ride , please add some amount in you wallet.
             * action : WALLET_SCREEN
             */

            private String headline;
            private String message;
            private String action;
            private Boolean show;


            public String getHeadline() {
                return headline;
            }

            public Boolean getShow() {
                return show;
            }

            public void setShow(Boolean show) {
                this.show = show;
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