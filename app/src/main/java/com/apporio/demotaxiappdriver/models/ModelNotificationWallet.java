package com.apporio.demotaxiappdriver.models;

public class ModelNotificationWallet {

    /**
     * data : {"booking_id":"27","message":"Company commission by Booking id:27"}
     * type : 3
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
         * booking_id : 27
         * message : Company commission by Booking id:27
         */

        private String booking_id;
        private String message;

        public String getBooking_id() {
            return booking_id;
        }

        public void setBooking_id(String booking_id) {
            this.booking_id = booking_id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
