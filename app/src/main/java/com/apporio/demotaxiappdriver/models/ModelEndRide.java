package com.apporio.demotaxiappdriver.models;

public class ModelEndRide {


    /**
     * result : 1
     * message : Ride End Sucessfully
     * data : {"id":141,"merchant_id":"1","user_id":"1","country_area_id":"2","service_type_id":"1","vehicle_type_id":"1","package_id":"null","price_card_id":"1","payment_method_id":"1","pickup_latitude":"28.412381862290573","pickup_longitude":"77.04406075179577","pickup_location":"St Mark Rd, Block S, Uppal Southend, Sector 49, Gurugram, Haryana 122018, India","drop_latitude":"28.41768327457424","drop_longitude":"77.04759523272514","drop_location":"Q1 Block Rd, Sector 49, Fatehpur, Haryana 122018, India","promo_code":"0","map_image":"https:maps.googleapis.com/maps/api/staticmap?center=&maptype=roadmap&path=color:0x000000%7Cweight:10%7Cenc:ihllDmvfuMh@@VAA[CqAAo@@o@C}CAyHAcBCoL?yDuF@cCB_CAeC?mAAyFFiABo@@Ax@Df@Nh@`BfBXX~AnBN^Fj@@bH{D?aB@&markers=color:green%7Clabel:P%7C28.412381862290573,77.04406075179577&markers=color:red%7Clabel:P%7C28.41768327457424,77.04759523272514&sensor=false","estimate_bill":"200","estimate_distance":"1.9 km","estimate_time":"7 mins","estimate_driver_distnace":"0.6 km","estimate_driver_time":"3 mins","booking_type":"1","later_booking_date":"null","later_booking_time":"null","created_at":"2018-09-06 12:57:12","updated_at":"2018-09-06 12:57:55","platform":"1","driver_id":"1","booking_status":"1005","cancel_reason_id":"","ploy_points":"3","notificationID":"null","travel_distance":"0.59 Km","travel_time":"00 Hour 00 Mins","travel_time_min":"0.08","final_amount_paid":"200","company_cut":"null","driver_cut":"null","additional_notes":"null","booking_timestamp":"1536238635","unique_id":"5b912430775ac","booking_closure":"null","price_card":{"id":1,"merchant_id":"1","country_area_id":"2","service_type_id":"1","vehicle_type_id":"1","pricing_type":"1","maximum_bill_amount":"null","package_id":"null","base_fare":"100","free_distance":"10","free_time":"10","created_at":"2018-08-02 15:30:27","updated_at":"2018-08-02 15:30:27"}}
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
         * id : 141
         * merchant_id : 1
         * user_id : 1
         * country_area_id : 2
         * service_type_id : 1
         * vehicle_type_id : 1
         * package_id : null
         * price_card_id : 1
         * payment_method_id : 1
         * pickup_latitude : 28.412381862290573
         * pickup_longitude : 77.04406075179577
         * pickup_location : St Mark Rd, Block S, Uppal Southend, Sector 49, Gurugram, Haryana 122018, India
         * drop_latitude : 28.41768327457424
         * drop_longitude : 77.04759523272514
         * drop_location : Q1 Block Rd, Sector 49, Fatehpur, Haryana 122018, India
         * promo_code : 0
         * map_image : https:maps.googleapis.com/maps/api/staticmap?center=&maptype=roadmap&path=color:0x000000%7Cweight:10%7Cenc:ihllDmvfuMh@@VAA[CqAAo@@o@C}CAyHAcBCoL?yDuF@cCB_CAeC?mAAyFFiABo@@Ax@Df@Nh@`BfBXX~AnBN^Fj@@bH{D?aB@&markers=color:green%7Clabel:P%7C28.412381862290573,77.04406075179577&markers=color:red%7Clabel:P%7C28.41768327457424,77.04759523272514&sensor=false
         * estimate_bill : 200
         * estimate_distance : 1.9 km
         * estimate_time : 7 mins
         * estimate_driver_distnace : 0.6 km
         * estimate_driver_time : 3 mins
         * booking_type : 1
         * later_booking_date : null
         * later_booking_time : null
         * created_at : 2018-09-06 12:57:12
         * updated_at : 2018-09-06 12:57:55
         * platform : 1
         * driver_id : 1
         * booking_status : 1005
         * cancel_reason_id :
         * ploy_points : 3
         * notificationID : null
         * travel_distance : 0.59 Km
         * travel_time : 00 Hour 00 Mins
         * travel_time_min : 0.08
         * final_amount_paid : 200
         * company_cut : null
         * driver_cut : null
         * additional_notes : null
         * booking_timestamp : 1536238635
         * unique_id : 5b912430775ac
         * "booking_type":"2"
         * booking_closure : null
         * price_card : {"id":1,"merchant_id":"1","country_area_id":"2","service_type_id":"1","vehicle_type_id":"1","pricing_type":"1","maximum_bill_amount":"null","package_id":"null","base_fare":"100","free_distance":"10","free_time":"10","created_at":"2018-08-02 15:30:27","updated_at":"2018-08-02 15:30:27"}
         */

        private int id;
        private String merchant_id;
        private String user_id;
        private String country_area_id;
        private String service_type_id;
        private String vehicle_type_id;
        private String package_id;
        private String price_card_id;
        private String payment_method_id;
        private String pickup_latitude;
        private String pickup_longitude;
        private String pickup_location;
        private String drop_latitude;
        private String drop_longitude;
        private String drop_location;
        private String promo_code;
        private String map_image;
        private String estimate_bill;
        private String estimate_distance;
        private String estimate_time;
        private String estimate_driver_distnace;
        private String estimate_driver_time;
        private String booking_type;
        private String later_booking_date;
        private String later_booking_time;
        private String created_at;
        private String updated_at;
        private String platform;
        private String driver_id;
        private String booking_status;
        private String cancel_reason_id;
        private String ploy_points;
        private String notificationID;
        private String travel_distance;
        private String travel_time;
        private String travel_time_min;
        private String final_amount_paid;
        private String company_cut;
        private String driver_cut;
        private String additional_notes;
        private String booking_timestamp;
        private String unique_id;
        private String booking_closure;
        private PriceCardBean price_card;

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

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getCountry_area_id() {
            return country_area_id;
        }

        public void setCountry_area_id(String country_area_id) {
            this.country_area_id = country_area_id;
        }

        public String getService_type_id() {
            return service_type_id;
        }

        public void setService_type_id(String service_type_id) {
            this.service_type_id = service_type_id;
        }

        public String getVehicle_type_id() {
            return vehicle_type_id;
        }

        public void setVehicle_type_id(String vehicle_type_id) {
            this.vehicle_type_id = vehicle_type_id;
        }

        public String getPackage_id() {
            return package_id;
        }

        public void setPackage_id(String package_id) {
            this.package_id = package_id;
        }

        public String getPrice_card_id() {
            return price_card_id;
        }

        public void setPrice_card_id(String price_card_id) {
            this.price_card_id = price_card_id;
        }

        public String getPayment_method_id() {
            return payment_method_id;
        }

        public void setPayment_method_id(String payment_method_id) {
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

        public String getPromo_code() {
            return promo_code;
        }

        public void setPromo_code(String promo_code) {
            this.promo_code = promo_code;
        }

        public String getMap_image() {
            return map_image;
        }

        public void setMap_image(String map_image) {
            this.map_image = map_image;
        }

        public String getEstimate_bill() {
            return estimate_bill;
        }

        public void setEstimate_bill(String estimate_bill) {
            this.estimate_bill = estimate_bill;
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

        public String getBooking_type() {
            return booking_type;
        }

        public void setBooking_type(String booking_type) {
            this.booking_type = booking_type;
        }

        public String getLater_booking_date() {
            return later_booking_date;
        }

        public void setLater_booking_date(String later_booking_date) {
            this.later_booking_date = later_booking_date;
        }

        public String getLater_booking_time() {
            return later_booking_time;
        }

        public void setLater_booking_time(String later_booking_time) {
            this.later_booking_time = later_booking_time;
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

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(String driver_id) {
            this.driver_id = driver_id;
        }

        public String getBooking_status() {
            return booking_status;
        }

        public void setBooking_status(String booking_status) {
            this.booking_status = booking_status;
        }

        public String getCancel_reason_id() {
            return cancel_reason_id;
        }

        public void setCancel_reason_id(String cancel_reason_id) {
            this.cancel_reason_id = cancel_reason_id;
        }

        public String getPloy_points() {
            return ploy_points;
        }

        public void setPloy_points(String ploy_points) {
            this.ploy_points = ploy_points;
        }

        public String getNotificationID() {
            return notificationID;
        }

        public void setNotificationID(String notificationID) {
            this.notificationID = notificationID;
        }

        public String getTravel_distance() {
            return travel_distance;
        }

        public void setTravel_distance(String travel_distance) {
            this.travel_distance = travel_distance;
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

        public String getAdditional_notes() {
            return additional_notes;
        }

        public void setAdditional_notes(String additional_notes) {
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

        public String getBooking_closure() {
            return booking_closure;
        }

        public void setBooking_closure(String booking_closure) {
            this.booking_closure = booking_closure;
        }

        public PriceCardBean getPrice_card() {
            return price_card;
        }

        public void setPrice_card(PriceCardBean price_card) {
            this.price_card = price_card;
        }

        public static class PriceCardBean {
            /**
             * id : 1
             * merchant_id : 1
             * country_area_id : 2
             * service_type_id : 1
             * vehicle_type_id : 1
             * pricing_type : 1
             * maximum_bill_amount : null
             * package_id : null
             * base_fare : 100
             * free_distance : 10
             * free_time : 10
             * created_at : 2018-08-02 15:30:27
             * updated_at : 2018-08-02 15:30:27
             */

            private int id;
            private String merchant_id;
            private String country_area_id;
            private String service_type_id;
            private String vehicle_type_id;
            private String pricing_type;
            private String maximum_bill_amount;
            private String package_id;
            private String base_fare;
            private String free_distance;
            private String free_time;
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

            public String getCountry_area_id() {
                return country_area_id;
            }

            public void setCountry_area_id(String country_area_id) {
                this.country_area_id = country_area_id;
            }

            public String getService_type_id() {
                return service_type_id;
            }

            public void setService_type_id(String service_type_id) {
                this.service_type_id = service_type_id;
            }

            public String getVehicle_type_id() {
                return vehicle_type_id;
            }

            public void setVehicle_type_id(String vehicle_type_id) {
                this.vehicle_type_id = vehicle_type_id;
            }

            public String getPricing_type() {
                return pricing_type;
            }

            public void setPricing_type(String pricing_type) {
                this.pricing_type = pricing_type;
            }

            public String getMaximum_bill_amount() {
                return maximum_bill_amount;
            }

            public void setMaximum_bill_amount(String maximum_bill_amount) {
                this.maximum_bill_amount = maximum_bill_amount;
            }

            public String getPackage_id() {
                return package_id;
            }

            public void setPackage_id(String package_id) {
                this.package_id = package_id;
            }

            public String getBase_fare() {
                return base_fare;
            }

            public void setBase_fare(String base_fare) {
                this.base_fare = base_fare;
            }

            public String getFree_distance() {
                return free_distance;
            }

            public void setFree_distance(String free_distance) {
                this.free_distance = free_distance;
            }

            public String getFree_time() {
                return free_time;
            }

            public void setFree_time(String free_time) {
                this.free_time = free_time;
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
