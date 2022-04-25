package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelRideNotifications {


    /**
     * data : {"service_type_id":1,"multiple_text":"multipleStop","drop_location":"Shalimar Huda City Center, Delhi, Sector 29, Gurugram, Haryana 122007, India","vehicle":"Luxury","booking_id":35280,"additional_notes":"","driver_request_timeout":30,"estimate_distance":"17.742","estimate_time":"0.78","pickup_latitude":"28.41243051924464","drop_latitude":"28.459159471996777","multiple_visable":true,"drop_longitude":"77.07253273576498","email":"gag.vishal5115@gmail.com","payment_method":"Cash","multiple_stop_list":[{"stop":1,"drop_latitude":"28.4286913","drop_location":"Subhash Chowk, Sector 47, Gurugram, Haryana","drop_longitude":"77.0370213","status":"1"},{"stop":2,"drop_latitude":"28.4374374","drop_location":"Sector 46, Gurugram, Haryana, India","drop_longitude":"77.05857499999999","status":"1"}],"timestamp":1558612828,"vehicleimage":"vehicle/ZlOhBLVYe4lDa8YvFnBOxFRbjAkEJxKGdpkKNTJ3.jpeg","pickup_longitude":"77.04408489167689","pickup_location":"IRIS Tech Park, Sector 49, Gurugram, Haryana 122018, India","user_image":"user/VkH2CsVwowvQgIiPERqKMFgs4OwVb8SoDRXUVlwg.jpeg","booking_status":1001,"outstation_msg":" There Is New Upcomming Booking","phone":"+918950368358","service":"Normal","estimate_bill":"775","package_name":"","booking_type":"1","username":"vishaluu garg"}
     * type : 1
     */

    private DataBean data;
    private int type;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static class DataBean {
        /**
         * service_type_id : 1
         * multiple_text : multipleStop
         * drop_location : Shalimar Huda City Center, Delhi, Sector 29, Gurugram, Haryana 122007, India
         * vehicle : Luxury
         * booking_id : 35280
         * additional_notes :
         * driver_request_timeout : 30
         * estimate_distance : 17.742
         * estimate_time : 0.78
         * pickup_latitude : 28.41243051924464
         * drop_latitude : 28.459159471996777
         * multiple_visable : true
         * drop_longitude : 77.07253273576498
         * email : gag.vishal5115@gmail.com
         * payment_method : Cash
         * multiple_stop_list : [{"stop":1,"drop_latitude":"28.4286913","drop_location":"Subhash Chowk, Sector 47, Gurugram, Haryana","drop_longitude":"77.0370213","status":"1"},{"stop":2,"drop_latitude":"28.4374374","drop_location":"Sector 46, Gurugram, Haryana, India","drop_longitude":"77.05857499999999","status":"1"}]
         * timestamp : 1558612828
         * vehicleimage : vehicle/ZlOhBLVYe4lDa8YvFnBOxFRbjAkEJxKGdpkKNTJ3.jpeg
         * pickup_longitude : 77.04408489167689
         * pickup_location : IRIS Tech Park, Sector 49, Gurugram, Haryana 122018, India
         * user_image : user/VkH2CsVwowvQgIiPERqKMFgs4OwVb8SoDRXUVlwg.jpeg
         * booking_status : 1001
         * outstation_msg :  There Is New Upcomming Booking
         * phone : +918950368358
         * service : Normal
         * estimate_bill : 775
         * package_name :
         * booking_type : 1
         * username : vishaluu garg
         */

        private String service_type_id;
        private String multiple_text;
        private String drop_location;
        private String vehicle;
        private String booking_id;
        private String additional_notes;
        private int driver_request_timeout;
        private String estimate_distance;
        private String estimate_time;
        private String pickup_latitude;
        private String drop_latitude;
        private boolean multiple_visable;
        private String drop_longitude;
        private String email;
        private String payment_method;
        private int timestamp;
        private String vehicleimage;
        private String pickup_longitude;
        private String pickup_location;
        private String user_image;
        private String booking_status;
        private String outstation_msg;
        private String phone;
        private String service;
        private String estimate_bill;
        private String package_name;
        private String booking_type;
        private String username;

        private String trip_way;

        public String getTrip_way() {
            return trip_way;
        }

        public void setTrip_way(String trip_way) {
            this.trip_way = trip_way;
        }



        private List<MultipleStopListBean> multiple_stop_list;

        public String getService_type_id() {
            return service_type_id;
        }

        public void setService_type_id(String service_type_id) {
            this.service_type_id = service_type_id;
        }

        public String getMultiple_text() {
            return multiple_text;
        }

        public void setMultiple_text(String multiple_text) {
            this.multiple_text = multiple_text;
        }

        public String getDrop_location() {
            return drop_location;
        }

        public void setDrop_location(String drop_location) {
            this.drop_location = drop_location;
        }

        public String getVehicle() {
            return vehicle;
        }

        public void setVehicle(String vehicle) {
            this.vehicle = vehicle;
        }

        public String getBooking_id() {
            return booking_id;
        }

        public void setBooking_id(String booking_id) {
            this.booking_id = booking_id;
        }

        public String getAdditional_notes() {
            return additional_notes;
        }

        public void setAdditional_notes(String additional_notes) {
            this.additional_notes = additional_notes;
        }

        public int getDriver_request_timeout() {
            return driver_request_timeout;
        }

        public void setDriver_request_timeout(int driver_request_timeout) {
            this.driver_request_timeout = driver_request_timeout;
        }

        public String getEstimate_distance() {
            return estimate_distance;
        }

        public void setEstimate_distance(String estimate_distance) {
            this.estimate_distance = estimate_distance;
        }

        public String getEstimate_time() {
            return estimate_time;
        }

        public void setEstimate_time(String estimate_time) {
            this.estimate_time = estimate_time;
        }

        public String getPickup_latitude() {
            return pickup_latitude;
        }

        public void setPickup_latitude(String pickup_latitude) {
            this.pickup_latitude = pickup_latitude;
        }

        public String getDrop_latitude() {
            return drop_latitude;
        }

        public void setDrop_latitude(String drop_latitude) {
            this.drop_latitude = drop_latitude;
        }

        public boolean isMultiple_visable() {
            return multiple_visable;
        }

        public void setMultiple_visable(boolean multiple_visable) {
            this.multiple_visable = multiple_visable;
        }

        public String getDrop_longitude() {
            return drop_longitude;
        }

        public void setDrop_longitude(String drop_longitude) {
            this.drop_longitude = drop_longitude;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getVehicleimage() {
            return vehicleimage;
        }

        public void setVehicleimage(String vehicleimage) {
            this.vehicleimage = vehicleimage;
        }

        public String getPickup_longitude() {
            return pickup_longitude;
        }

        public void setPickup_longitude(String pickup_longitude) {
            this.pickup_longitude = pickup_longitude;
        }

        public String getPickup_location() {
            return pickup_location;
        }

        public void setPickup_location(String pickup_location) {
            this.pickup_location = pickup_location;
        }

        public String getUser_image() {
            return user_image;
        }

        public void setUser_image(String user_image) {
            this.user_image = user_image;
        }

        public String getBooking_status() {
            return booking_status;
        }

        public void setBooking_status(String booking_status) {
            this.booking_status = booking_status;
        }

        public String getOutstation_msg() {
            return outstation_msg;
        }

        public void setOutstation_msg(String outstation_msg) {
            this.outstation_msg = outstation_msg;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getEstimate_bill() {
            return estimate_bill;
        }

        public void setEstimate_bill(String estimate_bill) {
            this.estimate_bill = estimate_bill;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

        public String getBooking_type() {
            return booking_type;
        }

        public void setBooking_type(String booking_type) {
            this.booking_type = booking_type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<MultipleStopListBean> getMultiple_stop_list() {
            return multiple_stop_list;
        }

        public void setMultiple_stop_list(List<MultipleStopListBean> multiple_stop_list) {
            this.multiple_stop_list = multiple_stop_list;
        }

        public static class MultipleStopListBean {
            /**
             * stop : 1
             * drop_latitude : 28.4286913
             * drop_location : Subhash Chowk, Sector 47, Gurugram, Haryana
             * drop_longitude : 77.0370213
             * status : 1
             */

            private int stop;
            private String drop_latitude;
            private String drop_location;
            private String drop_longitude;
            private String status;

            public int getStop() {
                return stop;
            }

            public void setStop(int stop) {
                this.stop = stop;
            }

            public String getDrop_latitude() {
                return drop_latitude;
            }

            public void setDrop_latitude(String drop_latitude) {
                this.drop_latitude = drop_latitude;
            }

            public String getDrop_location() {
                return drop_location;
            }

            public void setDrop_location(String drop_location) {
                this.drop_location = drop_location;
            }

            public String getDrop_longitude() {
                return drop_longitude;
            }

            public void setDrop_longitude(String drop_longitude) {
                this.drop_longitude = drop_longitude;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
