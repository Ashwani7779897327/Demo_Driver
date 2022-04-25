package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelAccountType {


    /**
     * result : 1
     * message : Data Fetched Successfully
     * account_types : [{"id":1,"name":"Saving Account spanish"},{"id":2,"name":"Current Account"}]
     */

    private String result;
    private String message;
    private List<AccountTypesBean> account_types;

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

    public List<AccountTypesBean> getAccount_types() {
        return account_types;
    }

    public void setAccount_types(List<AccountTypesBean> account_types) {
        this.account_types = account_types;
    }

    public static class AccountTypesBean {
        /**
         * id : 1
         * name : Saving Account spanish
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
