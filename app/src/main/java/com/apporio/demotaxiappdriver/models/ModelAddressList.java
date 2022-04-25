package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelAddressList {


    /**
     * result : 1
     * message : Home Location Saved
     * data : [{"id":1,"address_name":"sfggghgbhghh","address_value":"Oodles Technologies Private Limited","check_visibility":false}]
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
         * address_name : sfggghgbhghh
         * address_value : Oodles Technologies Private Limited
         * check_visibility : false
         */

        private int id;
        private String address_name;
        private String address_value;
        private boolean check_visibility;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAddress_name() {
            return address_name;
        }

        public void setAddress_name(String address_name) {
            this.address_name = address_name;
        }

        public String getAddress_value() {
            return address_value;
        }

        public void setAddress_value(String address_value) {
            this.address_value = address_value;
        }

        public boolean isCheck_visibility() {
            return check_visibility;
        }

        public void setCheck_visibility(boolean check_visibility) {
            this.check_visibility = check_visibility;
        }
    }
}
