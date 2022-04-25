package com.apporio.demotaxiappdriver.models;

public class ModelRateUser {

    /**
     * result : 1
     * message : Thank For Rating
     * data : {"booking_id":"97","driver_rating_points":"4.0","driver_comment":"did","updated_at":"2018-09-03 11:49:52","created_at":"2018-09-03 11:49:52","id":11}
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
         * booking_id : 97
         * driver_rating_points : 4.0
         * driver_comment : did
         * updated_at : 2018-09-03 11:49:52
         * created_at : 2018-09-03 11:49:52
         * id : 11
         */

        private String booking_id;
        private String driver_rating_points;
        private String driver_comment;
        private String updated_at;
        private String created_at;
        private int id;

        public String getBooking_id() {
            return booking_id;
        }

        public void setBooking_id(String booking_id) {
            this.booking_id = booking_id;
        }

        public String getDriver_rating_points() {
            return driver_rating_points;
        }

        public void setDriver_rating_points(String driver_rating_points) {
            this.driver_rating_points = driver_rating_points;
        }

        public String getDriver_comment() {
            return driver_comment;
        }

        public void setDriver_comment(String driver_comment) {
            this.driver_comment = driver_comment;
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
