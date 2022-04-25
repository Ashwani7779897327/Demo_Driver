package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelSuperDriver {


    /**
     * result : 1
     * message : Super Drivers
     * data : [{"id":6473,"merchant_id":90,"booking_status":1005,"hotel_id":null,"franchise_id":null,"platform":1,"user_id":10145,"driver_id":9703,"country_area_id":215,"service_type_id":1,"vehicle_type_id":244,"package_id":null,"auto_upgradetion":2,"number_of_rider":0,"total_drop_location":1,"price_card_id":590,"driver_vehicle_id":7976,"family_member_id":null,"pickup_latitude":"28.41244496888124","pickup_longitude":"77.04409126192331","pickup_location":"IRIS Tech Park, Sector 49, Gurugram, Haryana 122018, India","drop_latitude":"28.459130585477862","drop_longitude":"77.07256056368351","drop_location":"5th Floor, Huda Metro Station, Delhi, Sector 29, Gurugram, Haryana 122007, India","waypoints":"[]","payment_status":1,"cancel_reason_id":null,"booking_type":"1","map_image":"https:maps.googleapis.com/maps/api/staticmap?center=&maptype=roadmap&path=color:0x000000%7Cweight:10%7Cenc:_hllDqtfuM@y@\\AV?A[CqAAo@@o@C}CAyHAcBCoL?yDuF@cCByEAaB@mBA}GJO??yB?}@I}@Ou@i@iBwAj@_KvDwAh@OJQLs@m@u@s@wBeCiCqCwG_FaBsAmDeDiBiBaBaByF}FsBwBiA_AgFiF}FkFkDgDsIkIgE{DiHeHa@MY[[WQEYEI@MF_@`@WR[DwAvBwDpFsExGkJzMmBzCmE~FkBlCOTw@s@m@s@kCeCoXkWiCcCiBiByKgKoIyHiA_AkKgJq@k@gByAYOgB}AmAcAk@Se@][O{@o@_@[&markers=color:green%7Clabel:P%7C28.41244496888124,77.04409126192331&markers=color:red%7Clabel:D%7C28.459130585477862,77.07256056368351&key=AIzaSyCm5nnJbETZssUAYwCpkoViadjtEW1jpJg","ploy_points":"_hllDqtfuM@y@\\AV?A[CqAAo@@o@C}CAyHAcBCoL?yDuF@cCByEAaB@mBA}GJO??yB?}@I}@Ou@i@iBwAj@_KvDwAh@OJQLs@m@u@s@wBeCiCqCwG_FaBsAmDeDiBiBaBaByF}FsBwBiA_AgFiF}FkFkDgDsIkIgE{DiHeHa@MY[[WQEYEI@MF_@`@WR[DwAvBwDpFsExGkJzMmBzCmE~FkBlCOTw@s@m@s@kCeCoXkWiCcCiBiByKgKoIyHiA_AkKgJq@k@gByAYOgB}AmAcAk@Se@][O{@o@_@[","estimate_bill":"10600.00","notificationID":null,"estimate_distance":"7.6 km","travel_distance":"0 Km","estimate_time":"22 mins","travel_time":"00 H 00 M","travel_time_min":"0.65","estimate_driver_distnace":"1 m","estimate_driver_time":"1 min","payment_method_id":1,"card_id":"","promo_code":"0","final_amount_paid":"3200.00","company_cut":"32000","driver_cut":"288000","additional_notes":null,"booking_timestamp":"1555132818","unique_id":"5cb1719e8d844","booking_closure":1,"later_booking_date":null,"later_booking_time":null,"return_date":null,"return_time":null,"ride_otp":"5358","ride_otp_verify":3,"baby_seat_enable":null,"wheel_chair_enable":null,"no_of_person":null,"no_of_children":null,"no_of_bags":null,"bags_weight_kg":null,"created_at":"2019-04-13 10:50:07","updated_at":"2019-04-13 10:54:26","totalbooking":5,"driver":{"id":9703,"merchant_id":90,"unique_number":null,"driver_gender":1,"first_name":"abcd","email":"abcdefgh56@u.com","password":"$2y$10$jSvhs.nb9fsVLJ2HPsgsnuNiq1LgtwkbxJGXwjHrJ12PRXkKqyPoq","home_location_active":2,"pool_ride_active":1,"status_for_pool":1,"avail_seats":0,"occupied_seats":4,"pick_exceed":1,"pool_user_id":10145,"phoneNumber":"+917979797979","profile_image":"driver/QtfCIDQ1uql7GCgw02BWNDcyR7HF1B5NzoB3tY8g.jpeg","wallet_money":"20000500","total_trips":6,"total_earnings":"2.72911052727E+1500","total_comany_earning":"3.0323450303E+1400","outstand_amount":"-3.0323450303E+1400","current_latitude":"28.4124446","current_longitude":"77.0440898","last_location_update_time":"2019-04-13 14:52:55","bearing":"0.0","accuracy":"20.732","player_id":"5ee269ff-fb11-4ec8-9b6b-449423e9772e","rating":"4.13","country_area_id":215,"login_logout":1,"online_offline":1,"free_busy":2,"bank_name":null,"account_holder_name":null,"account_number":null,"driver_verify_status":1,"signupFrom":1,"signupStep":3,"driver_verification_date":null,"driver_admin_status":1,"access_token_id":"ad683cc840f546b31a3d73a13f91f554e62d63b17442041d49510c51e285f2cc8179367346c973bb","driver_delete":null,"online_code":null,"last_ride_request_timestamp":"2019-04-13 14:31:32","created_at":"2019-04-11 11:58:35","updated_at":"2019-04-13 14:52:55","last_name":"efgh","driver_referralcode":"KQOND","driver_block_status":null,"term_status":0,"pending_document_status":2,"expire_personal_document":2,"expire_vehicle_document":2,"admin_msg":null}}]
     */

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
        /**
         * id : 6473
         * merchant_id : 90
         * booking_status : 1005
         * hotel_id : null
         * franchise_id : null
         * platform : 1
         * user_id : 10145
         * driver_id : 9703
         * country_area_id : 215
         * service_type_id : 1
         * vehicle_type_id : 244
         * package_id : null
         * auto_upgradetion : 2
         * number_of_rider : 0
         * total_drop_location : 1
         * price_card_id : 590
         * driver_vehicle_id : 7976
         * family_member_id : null
         * pickup_latitude : 28.41244496888124
         * pickup_longitude : 77.04409126192331
         * pickup_location : IRIS Tech Park, Sector 49, Gurugram, Haryana 122018, India
         * drop_latitude : 28.459130585477862
         * drop_longitude : 77.07256056368351
         * drop_location : 5th Floor, Huda Metro Station, Delhi, Sector 29, Gurugram, Haryana 122007, India
         * waypoints : []
         * payment_status : 1
         * cancel_reason_id : null
         * booking_type : 1
         * map_image : https:maps.googleapis.com/maps/api/staticmap?center=&maptype=roadmap&path=color:0x000000%7Cweight:10%7Cenc:_hllDqtfuM@y@\AV?A[CqAAo@@o@C}CAyHAcBCoL?yDuF@cCByEAaB@mBA}GJO??yB?}@I}@Ou@i@iBwAj@_KvDwAh@OJQLs@m@u@s@wBeCiCqCwG_FaBsAmDeDiBiBaBaByF}FsBwBiA_AgFiF}FkFkDgDsIkIgE{DiHeHa@MY[[WQEYEI@MF_@`@WR[DwAvBwDpFsExGkJzMmBzCmE~FkBlCOTw@s@m@s@kCeCoXkWiCcCiBiByKgKoIyHiA_AkKgJq@k@gByAYOgB}AmAcAk@Se@][O{@o@_@[&markers=color:green%7Clabel:P%7C28.41244496888124,77.04409126192331&markers=color:red%7Clabel:D%7C28.459130585477862,77.07256056368351&key=AIzaSyCm5nnJbETZssUAYwCpkoViadjtEW1jpJg
         * ploy_points : _hllDqtfuM@y@\AV?A[CqAAo@@o@C}CAyHAcBCoL?yDuF@cCByEAaB@mBA}GJO??yB?}@I}@Ou@i@iBwAj@_KvDwAh@OJQLs@m@u@s@wBeCiCqCwG_FaBsAmDeDiBiBaBaByF}FsBwBiA_AgFiF}FkFkDgDsIkIgE{DiHeHa@MY[[WQEYEI@MF_@`@WR[DwAvBwDpFsExGkJzMmBzCmE~FkBlCOTw@s@m@s@kCeCoXkWiCcCiBiByKgKoIyHiA_AkKgJq@k@gByAYOgB}AmAcAk@Se@][O{@o@_@[
         * estimate_bill : 10600.00
         * notificationID : null
         * estimate_distance : 7.6 km
         * travel_distance : 0 Km
         * estimate_time : 22 mins
         * travel_time : 00 H 00 M
         * travel_time_min : 0.65
         * estimate_driver_distnace : 1 m
         * estimate_driver_time : 1 min
         * payment_method_id : 1
         * card_id :
         * promo_code : 0
         * final_amount_paid : 3200.00
         * company_cut : 32000
         * driver_cut : 288000
         * additional_notes : null
         * booking_timestamp : 1555132818
         * unique_id : 5cb1719e8d844
         * booking_closure : 1
         * later_booking_date : null
         * later_booking_time : null
         * return_date : null
         * return_time : null
         * ride_otp : 5358
         * ride_otp_verify : 3
         * baby_seat_enable : null
         * wheel_chair_enable : null
         * no_of_person : null
         * no_of_children : null
         * no_of_bags : null
         * bags_weight_kg : null
         * created_at : 2019-04-13 10:50:07
         * updated_at : 2019-04-13 10:54:26
         * totalbooking : 5
         * driver : {"id":9703,"merchant_id":90,"unique_number":null,"driver_gender":1,"first_name":"abcd","email":"abcdefgh56@u.com","password":"$2y$10$jSvhs.nb9fsVLJ2HPsgsnuNiq1LgtwkbxJGXwjHrJ12PRXkKqyPoq","home_location_active":2,"pool_ride_active":1,"status_for_pool":1,"avail_seats":0,"occupied_seats":4,"pick_exceed":1,"pool_user_id":10145,"phoneNumber":"+917979797979","profile_image":"driver/QtfCIDQ1uql7GCgw02BWNDcyR7HF1B5NzoB3tY8g.jpeg","wallet_money":"20000500","total_trips":6,"total_earnings":"2.72911052727E+1500","total_comany_earning":"3.0323450303E+1400","outstand_amount":"-3.0323450303E+1400","current_latitude":"28.4124446","current_longitude":"77.0440898","last_location_update_time":"2019-04-13 14:52:55","bearing":"0.0","accuracy":"20.732","player_id":"5ee269ff-fb11-4ec8-9b6b-449423e9772e","rating":"4.13","country_area_id":215,"login_logout":1,"online_offline":1,"free_busy":2,"bank_name":null,"account_holder_name":null,"account_number":null,"driver_verify_status":1,"signupFrom":1,"signupStep":3,"driver_verification_date":null,"driver_admin_status":1,"access_token_id":"ad683cc840f546b31a3d73a13f91f554e62d63b17442041d49510c51e285f2cc8179367346c973bb","driver_delete":null,"online_code":null,"last_ride_request_timestamp":"2019-04-13 14:31:32","created_at":"2019-04-11 11:58:35","updated_at":"2019-04-13 14:52:55","last_name":"efgh","driver_referralcode":"KQOND","driver_block_status":null,"term_status":0,"pending_document_status":2,"expire_personal_document":2,"expire_vehicle_document":2,"admin_msg":null}
         */

        private int id;
        private int merchant_id;
        private int booking_status;
        private Object hotel_id;
        private Object franchise_id;
        private int platform;
        private int user_id;
        private int driver_id;
        private int country_area_id;
        private int service_type_id;
        private int vehicle_type_id;
        private Object package_id;
        private int auto_upgradetion;
        private int number_of_rider;
        private int total_drop_location;
        private int price_card_id;
        private int driver_vehicle_id;
        private Object family_member_id;
        private String pickup_latitude;
        private String pickup_longitude;
        private String pickup_location;
        private String drop_latitude;
        private String drop_longitude;
        private String drop_location;
        private String waypoints;
        private int payment_status;
        private Object cancel_reason_id;
        private String booking_type;
        private String map_image;
        private String ploy_points;
        private String estimate_bill;
        private Object notificationID;
        private String estimate_distance;
        private String travel_distance;
        private String estimate_time;
        private String travel_time;
        private String travel_time_min;
        private String estimate_driver_distnace;
        private String estimate_driver_time;
        private int payment_method_id;
        private String card_id;
        private String promo_code;
        private String final_amount_paid;
        private String company_cut;
        private String driver_cut;
        private Object additional_notes;
        private String booking_timestamp;
        private String unique_id;
        private int booking_closure;
        private Object later_booking_date;
        private Object later_booking_time;
        private Object return_date;
        private Object return_time;
        private String ride_otp;
        private int ride_otp_verify;
        private Object baby_seat_enable;
        private Object wheel_chair_enable;
        private Object no_of_person;
        private Object no_of_children;
        private Object no_of_bags;
        private Object bags_weight_kg;
        private String created_at;
        private String updated_at;
        private int totalbooking;
        private DriverBean driver;

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

        public int getBooking_status() {
            return booking_status;
        }

        public void setBooking_status(int booking_status) {
            this.booking_status = booking_status;
        }

        public Object getHotel_id() {
            return hotel_id;
        }

        public void setHotel_id(Object hotel_id) {
            this.hotel_id = hotel_id;
        }

        public Object getFranchise_id() {
            return franchise_id;
        }

        public void setFranchise_id(Object franchise_id) {
            this.franchise_id = franchise_id;
        }

        public int getPlatform() {
            return platform;
        }

        public void setPlatform(int platform) {
            this.platform = platform;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(int driver_id) {
            this.driver_id = driver_id;
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

        public int getAuto_upgradetion() {
            return auto_upgradetion;
        }

        public void setAuto_upgradetion(int auto_upgradetion) {
            this.auto_upgradetion = auto_upgradetion;
        }

        public int getNumber_of_rider() {
            return number_of_rider;
        }

        public void setNumber_of_rider(int number_of_rider) {
            this.number_of_rider = number_of_rider;
        }

        public int getTotal_drop_location() {
            return total_drop_location;
        }

        public void setTotal_drop_location(int total_drop_location) {
            this.total_drop_location = total_drop_location;
        }

        public int getPrice_card_id() {
            return price_card_id;
        }

        public void setPrice_card_id(int price_card_id) {
            this.price_card_id = price_card_id;
        }

        public int getDriver_vehicle_id() {
            return driver_vehicle_id;
        }

        public void setDriver_vehicle_id(int driver_vehicle_id) {
            this.driver_vehicle_id = driver_vehicle_id;
        }

        public Object getFamily_member_id() {
            return family_member_id;
        }

        public void setFamily_member_id(Object family_member_id) {
            this.family_member_id = family_member_id;
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

        public String getWaypoints() {
            return waypoints;
        }

        public void setWaypoints(String waypoints) {
            this.waypoints = waypoints;
        }

        public int getPayment_status() {
            return payment_status;
        }

        public void setPayment_status(int payment_status) {
            this.payment_status = payment_status;
        }

        public Object getCancel_reason_id() {
            return cancel_reason_id;
        }

        public void setCancel_reason_id(Object cancel_reason_id) {
            this.cancel_reason_id = cancel_reason_id;
        }

        public String getBooking_type() {
            return booking_type;
        }

        public void setBooking_type(String booking_type) {
            this.booking_type = booking_type;
        }

        public String getMap_image() {
            return map_image;
        }

        public void setMap_image(String map_image) {
            this.map_image = map_image;
        }

        public String getPloy_points() {
            return ploy_points;
        }

        public void setPloy_points(String ploy_points) {
            this.ploy_points = ploy_points;
        }

        public String getEstimate_bill() {
            return estimate_bill;
        }

        public void setEstimate_bill(String estimate_bill) {
            this.estimate_bill = estimate_bill;
        }

        public Object getNotificationID() {
            return notificationID;
        }

        public void setNotificationID(Object notificationID) {
            this.notificationID = notificationID;
        }

        public String getEstimate_distance() {
            return estimate_distance;
        }

        public void setEstimate_distance(String estimate_distance) {
            this.estimate_distance = estimate_distance;
        }

        public String getTravel_distance() {
            return travel_distance;
        }

        public void setTravel_distance(String travel_distance) {
            this.travel_distance = travel_distance;
        }

        public String getEstimate_time() {
            return estimate_time;
        }

        public void setEstimate_time(String estimate_time) {
            this.estimate_time = estimate_time;
        }

        public String getTravel_time() {
            return travel_time;
        }

        public void setTravel_time(String travel_time) {
            this.travel_time = travel_time;
        }

        public String getTravel_time_min() {
            return travel_time_min;
        }

        public void setTravel_time_min(String travel_time_min) {
            this.travel_time_min = travel_time_min;
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

        public int getPayment_method_id() {
            return payment_method_id;
        }

        public void setPayment_method_id(int payment_method_id) {
            this.payment_method_id = payment_method_id;
        }

        public String getCard_id() {
            return card_id;
        }

        public void setCard_id(String card_id) {
            this.card_id = card_id;
        }

        public String getPromo_code() {
            return promo_code;
        }

        public void setPromo_code(String promo_code) {
            this.promo_code = promo_code;
        }

        public String getFinal_amount_paid() {
            return final_amount_paid;
        }

        public void setFinal_amount_paid(String final_amount_paid) {
            this.final_amount_paid = final_amount_paid;
        }

        public String getCompany_cut() {
            return company_cut;
        }

        public void setCompany_cut(String company_cut) {
            this.company_cut = company_cut;
        }

        public String getDriver_cut() {
            return driver_cut;
        }

        public void setDriver_cut(String driver_cut) {
            this.driver_cut = driver_cut;
        }

        public Object getAdditional_notes() {
            return additional_notes;
        }

        public void setAdditional_notes(Object additional_notes) {
            this.additional_notes = additional_notes;
        }

        public String getBooking_timestamp() {
            return booking_timestamp;
        }

        public void setBooking_timestamp(String booking_timestamp) {
            this.booking_timestamp = booking_timestamp;
        }

        public String getUnique_id() {
            return unique_id;
        }

        public void setUnique_id(String unique_id) {
            this.unique_id = unique_id;
        }

        public int getBooking_closure() {
            return booking_closure;
        }

        public void setBooking_closure(int booking_closure) {
            this.booking_closure = booking_closure;
        }

        public Object getLater_booking_date() {
            return later_booking_date;
        }

        public void setLater_booking_date(Object later_booking_date) {
            this.later_booking_date = later_booking_date;
        }

        public Object getLater_booking_time() {
            return later_booking_time;
        }

        public void setLater_booking_time(Object later_booking_time) {
            this.later_booking_time = later_booking_time;
        }

        public Object getReturn_date() {
            return return_date;
        }

        public void setReturn_date(Object return_date) {
            this.return_date = return_date;
        }

        public Object getReturn_time() {
            return return_time;
        }

        public void setReturn_time(Object return_time) {
            this.return_time = return_time;
        }

        public String getRide_otp() {
            return ride_otp;
        }

        public void setRide_otp(String ride_otp) {
            this.ride_otp = ride_otp;
        }

        public int getRide_otp_verify() {
            return ride_otp_verify;
        }

        public void setRide_otp_verify(int ride_otp_verify) {
            this.ride_otp_verify = ride_otp_verify;
        }

        public Object getBaby_seat_enable() {
            return baby_seat_enable;
        }

        public void setBaby_seat_enable(Object baby_seat_enable) {
            this.baby_seat_enable = baby_seat_enable;
        }

        public Object getWheel_chair_enable() {
            return wheel_chair_enable;
        }

        public void setWheel_chair_enable(Object wheel_chair_enable) {
            this.wheel_chair_enable = wheel_chair_enable;
        }

        public Object getNo_of_person() {
            return no_of_person;
        }

        public void setNo_of_person(Object no_of_person) {
            this.no_of_person = no_of_person;
        }

        public Object getNo_of_children() {
            return no_of_children;
        }

        public void setNo_of_children(Object no_of_children) {
            this.no_of_children = no_of_children;
        }

        public Object getNo_of_bags() {
            return no_of_bags;
        }

        public void setNo_of_bags(Object no_of_bags) {
            this.no_of_bags = no_of_bags;
        }

        public Object getBags_weight_kg() {
            return bags_weight_kg;
        }

        public void setBags_weight_kg(Object bags_weight_kg) {
            this.bags_weight_kg = bags_weight_kg;
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

        public int getTotalbooking() {
            return totalbooking;
        }

        public void setTotalbooking(int totalbooking) {
            this.totalbooking = totalbooking;
        }

        public DriverBean getDriver() {
            return driver;
        }

        public void setDriver(DriverBean driver) {
            this.driver = driver;
        }

        public static class DriverBean {
            /**
             * id : 9703
             * merchant_id : 90
             * unique_number : null
             * driver_gender : 1
             * first_name : abcd
             * email : abcdefgh56@u.com
             * password : $2y$10$jSvhs.nb9fsVLJ2HPsgsnuNiq1LgtwkbxJGXwjHrJ12PRXkKqyPoq
             * home_location_active : 2
             * pool_ride_active : 1
             * status_for_pool : 1
             * avail_seats : 0
             * occupied_seats : 4
             * pick_exceed : 1
             * pool_user_id : 10145
             * phoneNumber : +917979797979
             * profile_image : driver/QtfCIDQ1uql7GCgw02BWNDcyR7HF1B5NzoB3tY8g.jpeg
             * wallet_money : 20000500
             * total_trips : 6
             * total_earnings : 2.72911052727E+1500
             * total_comany_earning : 3.0323450303E+1400
             * outstand_amount : -3.0323450303E+1400
             * current_latitude : 28.4124446
             * current_longitude : 77.0440898
             * last_location_update_time : 2019-04-13 14:52:55
             * bearing : 0.0
             * accuracy : 20.732
             * player_id : 5ee269ff-fb11-4ec8-9b6b-449423e9772e
             * rating : 4.13
             * country_area_id : 215
             * login_logout : 1
             * online_offline : 1
             * free_busy : 2
             * bank_name : null
             * account_holder_name : null
             * account_number : null
             * driver_verify_status : 1
             * signupFrom : 1
             * signupStep : 3
             * driver_verification_date : null
             * driver_admin_status : 1
             * access_token_id : ad683cc840f546b31a3d73a13f91f554e62d63b17442041d49510c51e285f2cc8179367346c973bb
             * driver_delete : null
             * online_code : null
             * last_ride_request_timestamp : 2019-04-13 14:31:32
             * created_at : 2019-04-11 11:58:35
             * updated_at : 2019-04-13 14:52:55
             * last_name : efgh
             * driver_referralcode : KQOND
             * driver_block_status : null
             * term_status : 0
             * pending_document_status : 2
             * expire_personal_document : 2
             * expire_vehicle_document : 2
             * admin_msg : null
             */

            private int id;
            private int merchant_id;
            private Object unique_number;
            private int driver_gender;
            private String first_name;
            private String email;
            private String password;
            private int home_location_active;
            private int pool_ride_active;
            private int status_for_pool;
            private int avail_seats;
            private int occupied_seats;
            private int pick_exceed;
            private int pool_user_id;
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
            private String last_name;
            private String driver_referralcode;
            private Object driver_block_status;
            private int term_status;
            private int pending_document_status;
            private int expire_personal_document;
            private int expire_vehicle_document;
            private Object admin_msg;

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

            public int getPick_exceed() {
                return pick_exceed;
            }

            public void setPick_exceed(int pick_exceed) {
                this.pick_exceed = pick_exceed;
            }

            public int getPool_user_id() {
                return pool_user_id;
            }

            public void setPool_user_id(int pool_user_id) {
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

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
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
        }
    }
}
