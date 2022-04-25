package com.apporio.demotaxiappdriver.models;

public class ModelNotificationChat {
    /**
     * data : {"sender":"DRIVER","message":"huda","timestamp":1533638311}
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
         * sender : DRIVER
         * message : huda
         * timestamp : 1533638311
         */

        private String sender;
        private String message;
        private int timestamp;

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
    }
}
