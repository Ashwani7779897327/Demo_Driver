package com.apporio.demotaxiappdriver.models;

public class MOdelTrackingResponse {


    /**
     * result : 1
     * message : Booking tracking data saved successfully
     * response : {"nameValuePairs":{"booking_id":"203","driver_id":"29","poly_points":"_hllDotfuM@{@\\AV?CxA","movable_latitude":"28.4123974","movable_longitude":"77.0440823","still_latitude":"28.412143000555467","still_longitude":"77.04394575208426","estimate_driver_time":"1 min","estimate_driver_distnace":"0.1 km","bearing":"0.0","accuracy":"27.401","booking_status":"1002","marker_type":"PICK"}}
     */

    private int result;
    private String message;
    private ResponseBean response;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * nameValuePairs : {"booking_id":"203","driver_id":"29","poly_points":"_hllDotfuM@{@\\AV?CxA","movable_latitude":"28.4123974","movable_longitude":"77.0440823","still_latitude":"28.412143000555467","still_longitude":"77.04394575208426","estimate_driver_time":"1 min","estimate_driver_distnace":"0.1 km","bearing":"0.0","accuracy":"27.401","booking_status":"1002","marker_type":"PICK"}
         */

        private NameValuePairsBean nameValuePairs;

        public NameValuePairsBean getNameValuePairs() {
            return nameValuePairs;
        }

        public void setNameValuePairs(NameValuePairsBean nameValuePairs) {
            this.nameValuePairs = nameValuePairs;
        }

        public static class NameValuePairsBean {
            /**
             * booking_id : 203
             * driver_id : 29
             * poly_points : _hllDotfuM@{@\AV?CxA
             * movable_latitude : 28.4123974
             * movable_longitude : 77.0440823
             * still_latitude : 28.412143000555467
             * still_longitude : 77.04394575208426
             * estimate_driver_time : 1 min
             * estimate_driver_distnace : 0.1 km
             * bearing : 0.0
             * accuracy : 27.401
             * booking_status : 1002
             * marker_type : PICK
             */

            private String booking_id;
            private String driver_id;
            private String poly_points;
            private String movable_latitude;
            private String movable_longitude;
            private String still_latitude;
            private String still_longitude;
            private String estimate_driver_time;
            private String estimate_driver_distnace;
            private String bearing;
            private String accuracy;
            private String booking_status;
            private String marker_type;

            public String getBooking_id() {
                return booking_id;
            }

            public void setBooking_id(String booking_id) {
                this.booking_id = booking_id;
            }

            public String getDriver_id() {
                return driver_id;
            }

            public void setDriver_id(String driver_id) {
                this.driver_id = driver_id;
            }

            public String getPoly_points() {
                return poly_points;
            }

            public void setPoly_points(String poly_points) {
                this.poly_points = poly_points;
            }

            public String getMovable_latitude() {
                return movable_latitude;
            }

            public void setMovable_latitude(String movable_latitude) {
                this.movable_latitude = movable_latitude;
            }

            public String getMovable_longitude() {
                return movable_longitude;
            }

            public void setMovable_longitude(String movable_longitude) {
                this.movable_longitude = movable_longitude;
            }

            public String getStill_latitude() {
                return still_latitude;
            }

            public void setStill_latitude(String still_latitude) {
                this.still_latitude = still_latitude;
            }

            public String getStill_longitude() {
                return still_longitude;
            }

            public void setStill_longitude(String still_longitude) {
                this.still_longitude = still_longitude;
            }

            public String getEstimate_driver_time() {
                return estimate_driver_time;
            }

            public void setEstimate_driver_time(String estimate_driver_time) {
                this.estimate_driver_time = estimate_driver_time;
            }

            public String getEstimate_driver_distnace() {
                return estimate_driver_distnace;
            }

            public void setEstimate_driver_distnace(String estimate_driver_distnace) {
                this.estimate_driver_distnace = estimate_driver_distnace;
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

            public String getBooking_status() {
                return booking_status;
            }

            public void setBooking_status(String booking_status) {
                this.booking_status = booking_status;
            }

            public String getMarker_type() {
                return marker_type;
            }

            public void setMarker_type(String marker_type) {
                this.marker_type = marker_type;
            }
        }
    }
}