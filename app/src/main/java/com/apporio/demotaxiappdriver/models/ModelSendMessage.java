package com.apporio.demotaxiappdriver.models;

public class ModelSendMessage {

    /**
     * result : 1
     * message : Ready For Booking
     * data : {"id":6,"booking_id":"15","chat":{"message":"tjdhjjgg","sender":"DRIVER","timestamp":1533639228},"created_at":"2018-08-07 10:49:57","updated_at":"2018-08-07 10:53:48"}
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
         * id : 6
         * booking_id : 15
         * chat : {"message":"tjdhjjgg","sender":"DRIVER","timestamp":1533639228}
         * created_at : 2018-08-07 10:49:57
         * updated_at : 2018-08-07 10:53:48
         */

        private int id;
        private String booking_id;
        private ChatBean chat;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBooking_id() {
            return booking_id;
        }

        public void setBooking_id(String booking_id) {
            this.booking_id = booking_id;
        }

        public ChatBean getChat() {
            return chat;
        }

        public void setChat(ChatBean chat) {
            this.chat = chat;
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

        public static class ChatBean {
            /**
             * message : tjdhjjgg
             * sender : DRIVER
             * timestamp : 1533639228
             */

            private String message;
            private String sender;
            private int timestamp;

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getSender() {
                return sender;
            }

            public void setSender(String sender) {
                this.sender = sender;
            }

            public int getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(int timestamp) {
                this.timestamp = timestamp;
            }
        }
    }
}
