package com.apporio.demotaxiappdriver.models;

public class ModelUploadpersonalDocument {

    /**
     * result : 1
     * message : Document Uploaded Successfully
     * data : {"driver_id":"12","document_id":"1","document_file":"driverdocument/2XdJHeOHLu1KytcO0O8zUKFqQQBp5mKj3AFcuZpp.jpeg","document_verification_status":1,"expire_date":"2018-7-27","updated_at":"2018-07-04 10:03:18","created_at":"2018-07-04 10:03:18","id":3}
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
         * driver_id : 12
         * document_id : 1
         * document_file : driverdocument/2XdJHeOHLu1KytcO0O8zUKFqQQBp5mKj3AFcuZpp.jpeg
         * document_verification_status : 1
         * expire_date : 2018-7-27
         * updated_at : 2018-07-04 10:03:18
         * created_at : 2018-07-04 10:03:18
         * id : 3
         */

        private String driver_id;
        private String document_id;
        private String document_file;
        private int document_verification_status;
        private String expire_date;
        private String updated_at;
        private String created_at;
        private int id;

        public String getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(String driver_id) {
            this.driver_id = driver_id;
        }

        public String getDocument_id() {
            return document_id;
        }

        public void setDocument_id(String document_id) {
            this.document_id = document_id;
        }

        public String getDocument_file() {
            return document_file;
        }

        public void setDocument_file(String document_file) {
            this.document_file = document_file;
        }

        public int getDocument_verification_status() {
            return document_verification_status;
        }

        public void setDocument_verification_status(int document_verification_status) {
            this.document_verification_status = document_verification_status;
        }

        public String getExpire_date() {
            return expire_date;
        }

        public void setExpire_date(String expire_date) {
            this.expire_date = expire_date;
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
