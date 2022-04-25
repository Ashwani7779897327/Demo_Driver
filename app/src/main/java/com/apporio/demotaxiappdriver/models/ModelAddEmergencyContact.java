package com.apporio.demotaxiappdriver.models;

public class ModelAddEmergencyContact {
    /**
     * result : 1
     * message : sos list
     * data : {"id":1,"merchant_id":18,"number":"100","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-02-26 07:18:19","updated_at":"2019-02-26 07:18:19","name":"Police"}
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
         * id : 1
         * merchant_id : 18
         * number : 100
         * sosStatus : 1
         * application : null
         * user_id : null
         * created_at : 2019-02-26 07:18:19
         * updated_at : 2019-02-26 07:18:19
         * name : Police
         */

        private int id;
        private int merchant_id;
        private String number;
        private int sosStatus;
        private Object application;
        private Object user_id;
        private String created_at;
        private String updated_at;
        private String name;

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

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public int getSosStatus() {
            return sosStatus;
        }

        public void setSosStatus(int sosStatus) {
            this.sosStatus = sosStatus;
        }

        public Object getApplication() {
            return application;
        }

        public void setApplication(Object application) {
            this.application = application;
        }

        public Object getUser_id() {
            return user_id;
        }

        public void setUser_id(Object user_id) {
            this.user_id = user_id;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
