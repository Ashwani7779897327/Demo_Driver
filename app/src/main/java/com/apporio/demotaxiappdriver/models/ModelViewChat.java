package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelViewChat {

    /**
     * result : 1
     * message : Ready For Booking
     * data : {"id":3,"booking_id":"12","chat":[{"message":"Xxcvdfbhg","sender":"USER","timestamp":1533634945},{"message":"Hxmdgm","sender":"USER","timestamp":1533634953},{"message":"Dhm","sender":"USER","timestamp":1533634958}],"created_at":"2018-08-07 09:42:25","updated_at":"2018-08-07 09:42:38"}
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
         * id : 3
         * booking_id : 12
         * chat : [{"message":"Xxcvdfbhg","sender":"USER","timestamp":1533634945},{"message":"Hxmdgm","sender":"USER","timestamp":1533634953},{"message":"Dhm","sender":"USER","timestamp":1533634958}]
         * created_at : 2018-08-07 09:42:25
         * updated_at : 2018-08-07 09:42:38
         */

        private int id;
        private String booking_id;
        private String created_at;
        private String updated_at;
        private List<ChatBean> chat;

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

        public List<ChatBean> getChat() {
            return chat;
        }

        public void setChat(List<ChatBean> chat) {
            this.chat = chat;
        }

        public static class ChatBean {
            /**
             * message : Xxcvdfbhg
             * sender : USER
             * timestamp : 1533634945
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
