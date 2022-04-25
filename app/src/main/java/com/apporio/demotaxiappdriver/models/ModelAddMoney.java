package com.apporio.demotaxiappdriver.models;

public class ModelAddMoney {

    /**
     * result : 1
     * message : Money Added in your Wallet
     * data : {"merchant_id":"1","user_id":9,"platfrom":2,"amount":"400.0","type":1,"updated_at":"2018-07-31 13:25:50","created_at":"2018-07-31 13:25:50","id":8}
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
         * merchant_id : 1
         * user_id : 9
         * platfrom : 2
         * amount : 400.0
         * type : 1
         * updated_at : 2018-07-31 13:25:50
         * created_at : 2018-07-31 13:25:50
         * id : 8
         */

        private String merchant_id;
        private int user_id;
        private int platfrom;
        private String amount;
        private int type;
        private String updated_at;
        private String created_at;
        private int id;

        public String getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(String merchant_id) {
            this.merchant_id = merchant_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getPlatfrom() {
            return platfrom;
        }

        public void setPlatfrom(int platfrom) {
            this.platfrom = platfrom;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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
