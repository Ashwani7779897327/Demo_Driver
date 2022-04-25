package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelEmergencyContactList {
    /**
     * result : 1
     * message : sos list
     * data : [{"id":1,"merchant_id":18,"number":"100","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-02-26 07:18:19","updated_at":"2019-02-26 07:18:19"},{"id":2,"merchant_id":31,"number":"+507 6280 5454","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-02-28 17:42:36","updated_at":"2019-02-28 17:42:36"},{"id":3,"merchant_id":23,"number":"012 896 628","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-02-28 21:35:51","updated_at":"2019-02-28 21:35:51"},{"id":4,"merchant_id":23,"number":"012 999 999","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-02-28 21:41:10","updated_at":"2019-02-28 21:41:10"},{"id":5,"merchant_id":23,"number":"119","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-02-28 21:43:00","updated_at":"2019-02-28 21:43:00"},{"id":6,"merchant_id":13,"number":"999","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-03-01 03:41:40","updated_at":"2019-03-01 03:41:40"},{"id":7,"merchant_id":10,"number":"911","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-03-22 11:27:24","updated_at":"2019-03-22 11:27:24"},{"id":8,"merchant_id":53,"number":"+60127788207","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-03-28 08:17:24","updated_at":"2019-03-28 08:17:24"},{"id":9,"merchant_id":53,"number":"+60167878373","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-03-28 09:06:30","updated_at":"2019-03-28 09:06:30"},{"id":10,"merchant_id":2,"number":"9876543210","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-03-28 10:10:31","updated_at":"2019-03-30 18:26:45"},{"id":11,"merchant_id":2,"number":"100","sosStatus":2,"application":null,"user_id":null,"created_at":"2019-03-28 10:10:40","updated_at":"2019-03-30 18:26:55"},{"id":12,"merchant_id":63,"number":"+27823864143","sosStatus":1,"application":null,"user_id":null,"created_at":"2019-03-30 08:45:01","updated_at":"2019-03-30 08:45:01"}]
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
         * id : 1
         * merchant_id : 18
         * number : 100
         * sosStatus : 1
         * application : null
         * user_id : null
         * created_at : 2019-02-26 07:18:19
         * updated_at : 2019-02-26 07:18:19
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




        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


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
    }
}
