package com.apporio.demotaxiappdriver.models;

public class ModelTermsAndCodition {


    /**
     * result : 1
     * message : Cms Pages
     * data : {"id":5,"merchant_id":"1","application":"2","slug":"terms_and_Conditions","title":"Some Title","description":"some terms and condition goes here","created_at":"2018-07-31 12:49:51","updated_at":"2018-07-31 12:49:51"}
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
         * id : 5
         * merchant_id : 1
         * application : 2
         * slug : terms_and_Conditions
         * title : Some Title
         * description : some terms and condition goes here
         * created_at : 2018-07-31 12:49:51
         * updated_at : 2018-07-31 12:49:51
         */

        private int id;
        private String merchant_id;
        private String application;
        private String slug;
        private String title;
        private String description;
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

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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
