package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelPromotionalNotification {
    /**
     * result : 1
     * message : Promotion Notifications
     * data : [{"id":2,"merchant_id":"1","application":"2","title":"hello","message":"this is aamir","image":"promotions/zUXcu6xTbxxXHNOsOomlcbLC3euTZB5aTRctUbgo.png","url":"http://apporioinfolabs.com/ApporiotaxiMaster/","user_id":"0","driver_id":"0","created_at":"2018-07-25 09:03:17","updated_at":"2018-07-25 09:03:17"}]
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
         * id : 2
         * merchant_id : 1
         * application : 2
         * title : hello
         * message : this is aamir
         * image : promotions/zUXcu6xTbxxXHNOsOomlcbLC3euTZB5aTRctUbgo.png
         * url : http://apporioinfolabs.com/ApporiotaxiMaster/
         * user_id : 0
         * driver_id : 0
         * created_at : 2018-07-25 09:03:17
         * updated_at : 2018-07-25 09:03:17
         */

        private int id;
        private String merchant_id;
        private String application;
        private String title;
        private String message;
        private String image;
        private String url;
        private String user_id;
        private String driver_id;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(String merchant_id) {
            this.merchant_id = merchant_id;
        }

        public String getApplication() {
            return application;
        }

        public void setApplication(String application) {
            this.application = application;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(String driver_id) {
            this.driver_id = driver_id;
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
