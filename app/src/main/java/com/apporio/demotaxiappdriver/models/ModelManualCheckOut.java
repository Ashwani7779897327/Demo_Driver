package com.apporio.demotaxiappdriver.models;

public class ModelManualCheckOut {


    /**
     * result : 1
     * message : Checkout Created Successfully
     * data : {"merchant_id":2,"user_id":717,"country_area_id":3,"service_type_id":1,"vehicle_type_id":129,"package_id":null,"price_card_id":238,"total_drop_location":1,"auto_upgradetion":2,"payment_method_id":1,"pickup_latitude":"28.4124047","pickup_longitude":"77.0440943","pickup_location":"spaze itech","drop_latitude":"28.4591307","drop_longitude":"77.0725607","drop_location":"Shalimar Huda City Center","booking_type":1,"waypoints":null,"map_image":"https:maps.googleapis.com/maps/api/staticmap?center=&maptype=roadmap&path=color:0x000000%7Cweight:10%7Cenc:_hllDqtfuM@y@\\AV?A[CqAAo@@o@C}CAyHAcBCoL?yDuF@cCByEAaB@mBA}GJO??yB?}@I}@Ou@i@iBwAj@_KvDwAh@OJQLs@m@u@s@wBeCiCqCwG_FaBsAmDeDiBiBaBaByF}FsBwBiA_AgFiF}FkFkDgDsIkIgE{DiHeHa@MY[[WQEYEI@MF_@`@WR[DwAvBwDpFsExGkJzMmBzCmE~FkBlCOTw@s@m@s@kCeCoXkWiCcCiBiByKgKoIyHiA_AkKgJq@k@gByAYOgB}AmAcAk@Se@][O_@Uw@s@CA&markers=color:green%7Clabel:P%7C28.4124047,77.0440943&markers=color:red%7Clabel:D%7C28.4591307,77.0725607&key=AIzaSyCm5nnJbETZssUAYwCpkoViadjtEW1jpJg&size=400x400","estimate_distance":"","estimate_time":"","estimate_bill":"","promo_code":"","estimate_driver_distnace":"","estimate_driver_time":"","updated_at":"2019-03-19 16:32:41","created_at":"2019-03-19 16:32:41","id":1462}
     * otp : 2018
     */

    private String result;
    private String message;
    private DataBean data;
    private String otp;

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

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public static class DataBean {
        /**
         * merchant_id : 2
         * user_id : 717
         * country_area_id : 3
         * service_type_id : 1
         * vehicle_type_id : 129
         * package_id : null
         * price_card_id : 238
         * total_drop_location : 1
         * auto_upgradetion : 2
         * payment_method_id : 1
         * pickup_latitude : 28.4124047
         * pickup_longitude : 77.0440943
         * pickup_location : spaze itech
         * drop_latitude : 28.4591307
         * drop_longitude : 77.0725607
         * drop_location : Shalimar Huda City Center
         * booking_type : 1
         * waypoints : null
         * map_image : https:maps.googleapis.com/maps/api/staticmap?center=&maptype=roadmap&path=color:0x000000%7Cweight:10%7Cenc:_hllDqtfuM@y@\AV?A[CqAAo@@o@C}CAyHAcBCoL?yDuF@cCByEAaB@mBA}GJO??yB?}@I}@Ou@i@iBwAj@_KvDwAh@OJQLs@m@u@s@wBeCiCqCwG_FaBsAmDeDiBiBaBaByF}FsBwBiA_AgFiF}FkFkDgDsIkIgE{DiHeHa@MY[[WQEYEI@MF_@`@WR[DwAvBwDpFsExGkJzMmBzCmE~FkBlCOTw@s@m@s@kCeCoXkWiCcCiBiByKgKoIyHiA_AkKgJq@k@gByAYOgB}AmAcAk@Se@][O_@Uw@s@CA&markers=color:green%7Clabel:P%7C28.4124047,77.0440943&markers=color:red%7Clabel:D%7C28.4591307,77.0725607&key=AIzaSyCm5nnJbETZssUAYwCpkoViadjtEW1jpJg&size=400x400
         * estimate_distance :
         * estimate_time :
         * estimate_bill :
         * promo_code :
         * estimate_driver_distnace :
         * estimate_driver_time :
         * updated_at : 2019-03-19 16:32:41
         * created_at : 2019-03-19 16:32:41
         * id : 1462
         */

        private int merchant_id;
        private int user_id;
        private int country_area_id;
        private int service_type_id;
        private int vehicle_type_id;
        private Object package_id;
        private int price_card_id;
        private int total_drop_location;
        private int auto_upgradetion;
        private int payment_method_id;
        private String pickup_latitude;
        private String pickup_longitude;
        private String pickup_location;
        private String drop_latitude;
        private String drop_longitude;
        private String drop_location;
        private int booking_type;
        private Object waypoints;
        private String map_image;
        private String estimate_distance;
        private String estimate_time;
        private String estimate_bill;
        private String promo_code;
        private String estimate_driver_distnace;
        private String estimate_driver_time;
        private String updated_at;
        private String created_at;
        private int id;

        public int getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(int merchant_id) {
            this.merchant_id = merchant_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getCountry_area_id() {
            return country_area_id;
        }

        public void setCountry_area_id(int country_area_id) {
            this.country_area_id = country_area_id;
        }

        public int getService_type_id() {
            return service_type_id;
        }

        public void setService_type_id(int service_type_id) {
            this.service_type_id = service_type_id;
        }

        public int getVehicle_type_id() {
            return vehicle_type_id;
        }

        public void setVehicle_type_id(int vehicle_type_id) {
            this.vehicle_type_id = vehicle_type_id;
        }

        public Object getPackage_id() {
            return package_id;
        }

        public void setPackage_id(Object package_id) {
            this.package_id = package_id;
        }

        public int getPrice_card_id() {
            return price_card_id;
        }

        public void setPrice_card_id(int price_card_id) {
            this.price_card_id = price_card_id;
        }

        public int getTotal_drop_location() {
            return total_drop_location;
        }

        public void setTotal_drop_location(int total_drop_location) {
            this.total_drop_location = total_drop_location;
        }

        public int getAuto_upgradetion() {
            return auto_upgradetion;
        }

        public void setAuto_upgradetion(int auto_upgradetion) {
            this.auto_upgradetion = auto_upgradetion;
        }

        public int getPayment_method_id() {
            return payment_method_id;
        }

        public void setPayment_method_id(int payment_method_id) {
            this.payment_method_id = payment_method_id;
        }

        public String getPickup_latitude() {
            return pickup_latitude;
        }

        public void setPickup_latitude(String pickup_latitude) {
            this.pickup_latitude = pickup_latitude;
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

        public String getDrop_latitude() {
            return drop_latitude;
        }

        public void setDrop_latitude(String drop_latitude) {
            this.drop_latitude = drop_latitude;
        }

        public String getDrop_longitude() {
            return drop_longitude;
        }

        public void setDrop_longitude(String drop_longitude) {
            this.drop_longitude = drop_longitude;
        }

        public String getDrop_location() {
            return drop_location;
        }

        public void setDrop_location(String drop_location) {
            this.drop_location = drop_location;
        }

        public int getBooking_type() {
            return booking_type;
        }

        public void setBooking_type(int booking_type) {
            this.booking_type = booking_type;
        }

        public Object getWaypoints() {
            return waypoints;
        }

        public void setWaypoints(Object waypoints) {
            this.waypoints = waypoints;
        }

        public String getMap_image() {
            return map_image;
        }

        public void setMap_image(String map_image) {
            this.map_image = map_image;
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

        public String getEstimate_bill() {
            return estimate_bill;
        }

        public void setEstimate_bill(String estimate_bill) {
            this.estimate_bill = estimate_bill;
        }

        public String getPromo_code() {
            return promo_code;
        }

        public void setPromo_code(String promo_code) {
            this.promo_code = promo_code;
        }

        public String getEstimate_driver_distnace() {
            return estimate_driver_distnace;
        }

        public void setEstimate_driver_distnace(String estimate_driver_distnace) {
            this.estimate_driver_distnace = estimate_driver_distnace;
        }

        public String getEstimate_driver_time() {
            return estimate_driver_time;
        }

        public void setEstimate_driver_time(String estimate_driver_time) {
            this.estimate_driver_time = estimate_driver_time;
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
