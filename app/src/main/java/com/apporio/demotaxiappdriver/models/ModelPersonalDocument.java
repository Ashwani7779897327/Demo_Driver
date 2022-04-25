package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelPersonalDocument {


    /**
     * result : 1
     * message : Your Personal Document
     * data : [{"id":13,"merchant_id":1,"expire_date":"2019-07-26","documentStatus":1,"documentNeed":1,"created_at":"2019-06-28 13:59:04","updated_at":"2019-06-28 13:59:04","document_verification_status":2,"documentname":"LICENCE","image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/driver-document/1561961287_5d19a347c1257_driver_document.jpg","status":"Verified","uploaded_at":"01-07-2019","status_color":"333333"}]
     * vehicle_document : [{"id":8,"vehicle_number":"778","vehicle_type":"SEDAN","vehicle_model":"3 series","vehicle_verfication_status":1,"vehicle_image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle-document/1561961274_5d19a33a91168_vehicle_document.jpg","vehicle_number_plate_image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle-document/1561961275_5d19a33bbfd9f_vehicle_document.jpg","vehicle_documents":[{"id":7,"document_verification_status":2,"documentname":"LICENCE","image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle-document/1561961299_5d19a353a6488_vehicle_document.jpg","expire_date":"2019-07-27","status":"Verified","uploaded_at":"01-07-2019","status_color":"333333"}]},{"id":16,"vehicle_number":"DL-10S-9999","vehicle_type":"SEDAN","vehicle_model":"3 series","vehicle_verfication_status":1,"vehicle_image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle-document/1562326560_5d1f36201121e_vehicle_document.jpeg","vehicle_number_plate_image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle-document/1562326571_5d1f362b7c297_vehicle_document.jpeg","vehicle_documents":[{"id":15,"document_verification_status":2,"documentname":"LICENCE","image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle-document/1562326779_5d1f36fb06ab8_vehicle_document.jpeg","expire_date":"2019-08-22","status":"Verified","uploaded_at":"05-07-2019","status_color":"333333"}]}]
     */

    private String result;
    private String message;
    private List<DataBean> data;
    private List<VehicleDocumentBean> vehicle_document;

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

    public List<VehicleDocumentBean> getVehicle_document() {
        return vehicle_document;
    }

    public void setVehicle_document(List<VehicleDocumentBean> vehicle_document) {
        this.vehicle_document = vehicle_document;
    }

    public static class DataBean {
        /**
         * id : 13
         * merchant_id : 1
         * expire_date : 2019-07-26
         * documentStatus : 1
         * documentNeed : 1
         * created_at : 2019-06-28 13:59:04
         * updated_at : 2019-06-28 13:59:04
         * document_verification_status : 2
         * documentname : LICENCE
         * image : https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/driver-document/1561961287_5d19a347c1257_driver_document.jpg
         * status : Verified
         * uploaded_at : 01-07-2019
         * status_color : 333333
         */

        private int id;
        private int merchant_id;
        private String expire_date;
        private int documentStatus;
        private int documentNeed;
        private String created_at;
        private String updated_at;
        private int document_verification_status;
        private String documentname;
        private String image;


        private String status;
        private String uploaded_at;
        private String status_color;
        private Boolean temp_doc_upload;

        public Boolean getTemp_doc_upload() {
            return temp_doc_upload;
        }

        public void setTemp_doc_upload(Boolean temp_doc_upload) {
            this.temp_doc_upload = temp_doc_upload;
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

        public String getExpire_date() {
            return expire_date;
        }

        public void setExpire_date(String expire_date) {
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

        public int getDocument_verification_status() {
            return document_verification_status;
        }

        public void setDocument_verification_status(int document_verification_status) {
            this.document_verification_status = document_verification_status;
        }

        public String getDocumentname() {
            return documentname;
        }

        public void setDocumentname(String documentname) {
            this.documentname = documentname;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUploaded_at() {
            return uploaded_at;
        }

        public void setUploaded_at(String uploaded_at) {
            this.uploaded_at = uploaded_at;
        }

        public String getStatus_color() {
            return status_color;
        }

        public void setStatus_color(String status_color) {
            this.status_color = status_color;
        }
    }

    public static class VehicleDocumentBean {
        /**
         * id : 8
         * vehicle_number : 778
         * vehicle_type : SEDAN
         * vehicle_model : 3 series
         * vehicle_verfication_status : 1
         * vehicle_image : https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle-document/1561961274_5d19a33a91168_vehicle_document.jpg
         * vehicle_number_plate_image : https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle-document/1561961275_5d19a33bbfd9f_vehicle_document.jpg
         * vehicle_documents : [{"id":7,"document_verification_status":2,"documentname":"LICENCE","image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle-document/1561961299_5d19a353a6488_vehicle_document.jpg","expire_date":"2019-07-27","status":"Verified","uploaded_at":"01-07-2019","status_color":"333333"}]
         */

        private int id;
        private String vehicle_number;
        private String vehicle_type;
        private String vehicle_model;
        private int vehicle_verfication_status;
        private String vehicle_image;
        private String vehicle_number_plate_image;
        private List<VehicleDocumentsBean> vehicle_documents;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVehicle_number() {
            return vehicle_number;
        }

        public void setVehicle_number(String vehicle_number) {
            this.vehicle_number = vehicle_number;
        }

        public String getVehicle_type() {
            return vehicle_type;
        }

        public void setVehicle_type(String vehicle_type) {
            this.vehicle_type = vehicle_type;
        }

        public String getVehicle_model() {
            return vehicle_model;
        }

        public void setVehicle_model(String vehicle_model) {
            this.vehicle_model = vehicle_model;
        }

        public int getVehicle_verfication_status() {
            return vehicle_verfication_status;
        }

        public void setVehicle_verfication_status(int vehicle_verfication_status) {
            this.vehicle_verfication_status = vehicle_verfication_status;
        }

        public String getVehicle_image() {
            return vehicle_image;
        }

        public void setVehicle_image(String vehicle_image) {
            this.vehicle_image = vehicle_image;
        }

        public String getVehicle_number_plate_image() {
            return vehicle_number_plate_image;
        }

        public void setVehicle_number_plate_image(String vehicle_number_plate_image) {
            this.vehicle_number_plate_image = vehicle_number_plate_image;
        }

        public List<VehicleDocumentsBean> getVehicle_documents() {
            return vehicle_documents;
        }

        public void setVehicle_documents(List<VehicleDocumentsBean> vehicle_documents) {
            this.vehicle_documents = vehicle_documents;
        }

        public static class VehicleDocumentsBean {
            /**
             * id : 7
             * document_verification_status : 2
             * documentname : LICENCE
             * image : https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle-document/1561961299_5d19a353a6488_vehicle_document.jpg
             * expire_date : 2019-07-27
             * status : Verified
             * uploaded_at : 01-07-2019
             * status_color : 333333
             */

            private int id;
            private int document_verification_status;
            private String documentname;
            private String image;
            private String expire_date;
            private String status;
            private int documentNeed;
            private String uploaded_at;
            private String status_color;
            private Boolean temp_doc_upload;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDocumentNeed() {
                return documentNeed;
            }

            public void setDocumentNeed(int documentNeed) {
                this.documentNeed = documentNeed;
            }

            public int getDocument_verification_status() {
                return document_verification_status;
            }

            public Boolean getTemp_doc_upload() {
                return temp_doc_upload;
            }

            public void setTemp_doc_upload(Boolean temp_doc_upload) {
                this.temp_doc_upload = temp_doc_upload;
            }

            public void setDocument_verification_status(int document_verification_status) {
                this.document_verification_status = document_verification_status;
            }

            public String getDocumentname() {
                return documentname;
            }

            public void setDocumentname(String documentname) {
                this.documentname = documentname;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getExpire_date() {
                return expire_date;
            }

            public void setExpire_date(String expire_date) {
                this.expire_date = expire_date;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getUploaded_at() {
                return uploaded_at;
            }

            public void setUploaded_at(String uploaded_at) {
                this.uploaded_at = uploaded_at;
            }

            public String getStatus_color() {
                return status_color;
            }

            public void setStatus_color(String status_color) {
                this.status_color = status_color;
            }
        }
    }
}