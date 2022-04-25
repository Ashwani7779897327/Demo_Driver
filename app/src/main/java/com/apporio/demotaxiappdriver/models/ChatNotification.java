package com.apporio.demotaxiappdriver.models;

public class ChatNotification {

    /**
     * data : {"booking_id":1345,"driver":"driver","sender":"DRIVER","message":"hi","timestamp":1549546956,"username":"shilpa"}
     * type : 5
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
         * booking_id : 1345
         * driver : driver
         * sender : DRIVER
         * message : hi
         * timestamp : 1549546956
         * username : shilpa
         */

        private int booking_id;
        private String driver;
        private String sender;
        private String message;
        private int timestamp;
        private String username;

        public int getBooking_id() {
            return booking_id;
        }

        public void setBooking_id(int booking_id) {
            this.booking_id = booking_id;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
