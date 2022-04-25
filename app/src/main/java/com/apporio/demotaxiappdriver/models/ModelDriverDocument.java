package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelDriverDocument {


    /**
     * message : Document List For Driver
     * result : 1
     * data : {"personal":[{"id":29,"merchant_id":2,"expire_date":1,"documentStatus":1,"documentNeed":1,"created_at":"2019-02-23 12:59:55","updated_at":"2019-02-23 13:00:09","document_verification_status":"0","documentname":"Driving Licence"},{"id":46,"merchant_id":2,"expire_date":2,"documentStatus":1,"documentNeed":2,"created_at":"2019-03-01 04:54:55","updated_at":"2019-03-07 18:32:53","document_verification_status":"0","documentname":"ID Proof"}],"vehicle":[{"id":30,"merchant_id":2,"expire_date":2,"documentStatus":1,"documentNeed":1,"created_at":"2019-02-23 13:01:18","updated_at":"2019-03-05 05:22:42","document_verification_status":"0","documentname":"Vehicle R.C."}],"docinfo":{"color":"3498db","message":"Your Document Is Under Review"}}
     */

    private String message;
    private String result;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * personal : [{"id":29,"merchant_id":2,"expire_date":1,"documentStatus":1,"documentNeed":1,"created_at":"2019-02-23 12:59:55","updated_at":"2019-02-23 13:00:09","document_verification_status":"0","documentname":"Driving Licence"},{"id":46,"merchant_id":2,"expire_date":2,"documentStatus":1,"documentNeed":2,"created_at":"2019-03-01 04:54:55","updated_at":"2019-03-07 18:32:53","document_verification_status":"0","documentname":"ID Proof"}]
         * vehicle : [{"id":30,"merchant_id":2,"expire_date":2,"documentStatus":1,"documentNeed":1,"created_at":"2019-02-23 13:01:18","updated_at":"2019-03-05 05:22:42","document_verification_status":"0","documentname":"Vehicle R.C."}]
         * docinfo : {"color":"3498db","message":"Your Document Is Under Review"}
         */

        private DocinfoBean docinfo;
        private List<PersonalBean> personal;
        private List<VehicleBean> vehicle;

        public DocinfoBean getDocinfo() {
            return docinfo;
        }

        public void setDocinfo(DocinfoBean docinfo) {
            this.docinfo = docinfo;
        }

        public List<PersonalBean> getPersonal() {
            return personal;
        }

        public void setPersonal(List<PersonalBean> personal) {
            this.personal = personal;
        }

        public List<VehicleBean> getVehicle() {
            return vehicle;
        }

        public void setVehicle(List<VehicleBean> vehicle) {
            this.vehicle = vehicle;
        }

        public static class DocinfoBean {

            private String concern_phone;
            private String concern_email;
            private String color;
            private String message;
            private String verification_status;
            private String dialog_title;
            private String dialog_message;

            public String getConcern_phone() {
                return concern_phone;
            }

            public void setConcern_phone(String concern_phone) {
                this.concern_phone = concern_phone;
            }

            public String getConcern_email() {
                return concern_email;
            }

            public void setConcern_email(String concern_email) {
                this.concern_email = concern_email;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getVerification_status() {
                return verification_status;
            }

            public void setVerification_status(String verification_status) {
                this.verification_status = verification_status;
            }

            public String getDialog_title() {
                return dialog_title;
            }

            public void setDialog_title(String dialog_title) {
                this.dialog_title = dialog_title;
            }

            public String getDialog_message() {
                return dialog_message;
            }

            public void setDialog_message(String dialog_message) {
                this.dialog_message = dialog_message;
            }
        }

        public static class PersonalBean {
            /**
             * id : 29
             * merchant_id : 2
             * expire_date : 1
             * documentStatus : 1
             * documentNeed : 1
             * created_at : 2019-02-23 12:59:55
             * updated_at : 2019-02-23 13:00:09
             * document_verification_status : 0
             * documentname : Driving Licence
             */

            private int id;
            private int merchant_id;
            private int expire_date;
            private int documentStatus;
            private int documentNeed;
            private String created_at;
            private String updated_at;
            private String document_verification_status;
            private String documentname;

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

            public int getExpire_date() {
                return expire_date;
            }

            public void setExpire_date(int expire_date) {
                this.expire_date = expire_date;
            }

            public int getDocumentStatus() {
                return documentStatus;
            }

            public void setDocumentStatus(int documentStatus) {
                this.documentStatus = documentStatus;
            }

            public int getDocumentNeed() {
                return documentNeed;
            }

            public void setDocumentNeed(int documentNeed) {
                this.documentNeed = documentNeed;
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

            public String getDocument_verification_status() {
                return document_verification_status;
            }

            public void setDocument_verification_status(String document_verification_status) {
                this.document_verification_status = document_verification_status;
            }

            public String getDocumentname() {
                return documentname;
            }

            public void setDocumentname(String documentname) {
                this.documentname = documentname;
            }
        }

        public static class VehicleBean {
            public int getDriver_vehicle_id() {
                return driver_vehicle_id;
            }

            public void setDriver_vehicle_id(int driver_vehicle_id) {
                this.driver_vehicle_id = driver_vehicle_id;
            }

            /**
             * id : 30
             * merchant_id : 2
             * expire_date : 2
             * documentStatus : 1
             * documentNeed : 1
             * created_at : 2019-02-23 13:01:18
             * updated_at : 2019-03-05 05:22:42
             * document_verification_status : 0
             * documentname : Vehicle R.C.
             */

            private int id;
            private int merchant_id;
            private int expire_date;
            private int documentStatus;
            private int documentNeed;
            private String created_at;
            private String updated_at;
            private String document_verification_status;
            private String documentname;
            private int driver_vehicle_id;

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

            public int getExpire_date() {
                return expire_date;
            }

            public void setExpire_date(int expire_date) {
                this.expire_date = expire_date;
            }

            public int getDocumentStatus() {
                return documentStatus;
            }

            public void setDocumentStatus(int documentStatus) {
                this.documentStatus = documentStatus;
            }

            public int getDocumentNeed() {
                return documentNeed;
            }

            public void setDocumentNeed(int documentNeed) {
                this.documentNeed = documentNeed;
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

            public String getDocument_verification_status() {
                return document_verification_status;
            }

            public void setDocument_verification_status(String document_verification_status) {
                this.document_verification_status = document_verification_status;
            }

            public String getDocumentname() {
                return documentname;
            }

            public void setDocumentname(String documentname) {
                this.documentname = documentname;
            }
        }
    }
}