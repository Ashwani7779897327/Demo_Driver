package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelExpiryDocuments {


    /**
     * result : 1
     * expiry_visibility : true
     * expiry_message : api.expiry_document_message
     * expired_personal_documents : [{"document_id":29,"document_name":"Driving Licence","document_file":"driverdocument/8mJA3APaojbWOLzyvzaLBy0U4mOp9QSEJ10j8VDW.jpeg","document_verification_status":4,"document_expiry_date":"2017-03-14"}]
     * expired_vehicle_documents : [{"id":49,"merchant_id":2,"driver_id":52,"owner_id":52,"vehicle_type_id":29,"shareCode":"dl7878","vehicle_make_id":29,"vehicle_model_id":24,"vehicle_number":"dl7878","vehicle_color":"black","vehicle_image":"driverVehicle/v84COGV0x5jlLG5kt6XfI92hgyGnfy0irhPgnaAB.jpeg","vehicle_number_plate_image":"driverVehicle/miQJROHW9qNA20VoanWaeNSS86e2tGjhVL14EP8T.jpeg","vehicle_active_status":1,"vehicle_verification_status":4,"reject_reason_id":null,"ac_nonac":null,"created_at":"2019-03-14 14:21:44","updated_at":"2019-03-14 14:26:24","VehicleTypeName":"Luxury","vehicleTypeImage":"vehicle/TcsyxHFDm4D4UiZVOS6tPUFX5kb6LlDhJOHgetKk.png","VehicleMakeName":"BMW","VehicleModelName":"3 series","driver_vehicle_document":[{"id":34,"driver_vehicle_id":49,"document":"drivervehicledocument/Pwcm5uYicC0bNSUr89JpRRkeOuXFUBcK5a6NzUw3.jpeg","document_id":30,"expire_date":"2017-03-14","document_verification_status":4,"document_name":"Vehicle R.C."}]}]
     */

    private String result;
    private boolean expiry_visibility;
    private String expiry_message;
    private List<ExpiredPersonalDocumentsBean> expired_personal_documents;
    private List<ExpiredVehicleDocumentsBean> expired_vehicle_documents;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isExpiry_visibility() {
        return expiry_visibility;
    }

    public void setExpiry_visibility(boolean expiry_visibility) {
        this.expiry_visibility = expiry_visibility;
    }

    public String getExpiry_message() {
        return expiry_message;
    }

    public void setExpiry_message(String expiry_message) {
        this.expiry_message = expiry_message;
    }

    public List<ExpiredPersonalDocumentsBean> getExpired_personal_documents() {
        return expired_personal_documents;
    }

    public void setExpired_personal_documents(List<ExpiredPersonalDocumentsBean> expired_personal_documents) {
        this.expired_personal_documents = expired_personal_documents;
    }

    public List<ExpiredVehicleDocumentsBean> getExpired_vehicle_documents() {
        return expired_vehicle_documents;
    }

    public void setExpired_vehicle_documents(List<ExpiredVehicleDocumentsBean> expired_vehicle_documents) {
        this.expired_vehicle_documents = expired_vehicle_documents;
    }

    public static class ExpiredPersonalDocumentsBean {
        public Boolean getTemp_doc_upload() {
            return temp_doc_upload;
        }

        public void setTemp_doc_upload(Boolean temp_doc_upload) {
            this.temp_doc_upload = temp_doc_upload;
        }

        /**
         * document_id : 29
         * document_name : Driving Licence
         * document_file : driverdocument/8mJA3APaojbWOLzyvzaLBy0U4mOp9QSEJ10j8VDW.jpeg
         * document_verification_status : 4
         * document_expiry_date : 2017-03-14
         */

        private int document_id;
        private String document_name;
        private String document_file;
        private int document_verification_status;
        private String document_expiry_date;
        private Boolean temp_doc_upload;

        public int getDocument_id() {
            return document_id;
        }

        public void setDocument_id(int document_id) {
            this.document_id = document_id;
        }

        public String getDocument_name() {
            return document_name;
        }

        public void setDocument_name(String document_name) {
            this.document_name = document_name;
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

        public String getDocument_expiry_date() {
            return document_expiry_date;
        }

        public void setDocument_expiry_date(String document_expiry_date) {
            this.document_expiry_date = document_expiry_date;
        }
    }

    public static class ExpiredVehicleDocumentsBean {
        /**
         * id : 49
         * merchant_id : 2
         * driver_id : 52
         * owner_id : 52
         * vehicle_type_id : 29
         * shareCode : dl7878
         * vehicle_make_id : 29
         * vehicle_model_id : 24
         * vehicle_number : dl7878
         * vehicle_color : black
         * vehicle_image : driverVehicle/v84COGV0x5jlLG5kt6XfI92hgyGnfy0irhPgnaAB.jpeg
         * vehicle_number_plate_image : driverVehicle/miQJROHW9qNA20VoanWaeNSS86e2tGjhVL14EP8T.jpeg
         * vehicle_active_status : 1
         * vehicle_verification_status : 4
         * reject_reason_id : null
         * ac_nonac : null
         * created_at : 2019-03-14 14:21:44
         * updated_at : 2019-03-14 14:26:24
         * VehicleTypeName : Luxury
         * vehicleTypeImage : vehicle/TcsyxHFDm4D4UiZVOS6tPUFX5kb6LlDhJOHgetKk.png
         * VehicleMakeName : BMW
         * VehicleModelName : 3 series
         * driver_vehicle_document : [{"id":34,"driver_vehicle_id":49,"document":"drivervehicledocument/Pwcm5uYicC0bNSUr89JpRRkeOuXFUBcK5a6NzUw3.jpeg","document_id":30,"expire_date":"2017-03-14","document_verification_status":4,"document_name":"Vehicle R.C."}]
         */

        private int id;
        private int merchant_id;
        private int driver_id;
        private int owner_id;
        private int vehicle_type_id;
        private String shareCode;
        private int vehicle_make_id;
        private int vehicle_model_id;
        private String vehicle_number;
        private String vehicle_color;
        private String vehicle_image;
        private String vehicle_number_plate_image;
        private int vehicle_active_status;
        private int vehicle_verification_status;
        private Object reject_reason_id;
        private Object ac_nonac;
        private String created_at;
        private String updated_at;
        private String VehicleTypeName;
        private String vehicleTypeImage;
        private String VehicleMakeName;
        private String VehicleModelName;
        private List<DriverVehicleDocumentBean> driver_vehicle_document;

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

        public int getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(int driver_id) {
            this.driver_id = driver_id;
        }

        public int getOwner_id() {
            return owner_id;
        }

        public void setOwner_id(int owner_id) {
            this.owner_id = owner_id;
        }

        public int getVehicle_type_id() {
            return vehicle_type_id;
        }

        public void setVehicle_type_id(int vehicle_type_id) {
            this.vehicle_type_id = vehicle_type_id;
        }

        public String getShareCode() {
            return shareCode;
        }

        public void setShareCode(String shareCode) {
            this.shareCode = shareCode;
        }

        public int getVehicle_make_id() {
            return vehicle_make_id;
        }

        public void setVehicle_make_id(int vehicle_make_id) {
            this.vehicle_make_id = vehicle_make_id;
        }

        public int getVehicle_model_id() {
            return vehicle_model_id;
        }

        public void setVehicle_model_id(int vehicle_model_id) {
            this.vehicle_model_id = vehicle_model_id;
        }

        public String getVehicle_number() {
            return vehicle_number;
        }

        public void setVehicle_number(String vehicle_number) {
            this.vehicle_number = vehicle_number;
        }

        public String getVehicle_color() {
            return vehicle_color;
        }

        public void setVehicle_color(String vehicle_color) {
            this.vehicle_color = vehicle_color;
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

        public int getVehicle_active_status() {
            return vehicle_active_status;
        }

        public void setVehicle_active_status(int vehicle_active_status) {
            this.vehicle_active_status = vehicle_active_status;
        }

        public int getVehicle_verification_status() {
            return vehicle_verification_status;
        }

        public void setVehicle_verification_status(int vehicle_verification_status) {
            this.vehicle_verification_status = vehicle_verification_status;
        }

        public Object getReject_reason_id() {
            return reject_reason_id;
        }

        public void setReject_reason_id(Object reject_reason_id) {
            this.reject_reason_id = reject_reason_id;
        }

        public Object getAc_nonac() {
            return ac_nonac;
        }

        public void setAc_nonac(Object ac_nonac) {
            this.ac_nonac = ac_nonac;
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

        public String getVehicleTypeName() {
            return VehicleTypeName;
        }

        public void setVehicleTypeName(String VehicleTypeName) {
            this.VehicleTypeName = VehicleTypeName;
        }

        public String getVehicleTypeImage() {
            return vehicleTypeImage;
        }

        public void setVehicleTypeImage(String vehicleTypeImage) {
            this.vehicleTypeImage = vehicleTypeImage;
        }

        public String getVehicleMakeName() {
            return VehicleMakeName;
        }

        public void setVehicleMakeName(String VehicleMakeName) {
            this.VehicleMakeName = VehicleMakeName;
        }

        public String getVehicleModelName() {
            return VehicleModelName;
        }

        public void setVehicleModelName(String VehicleModelName) {
            this.VehicleModelName = VehicleModelName;
        }

        public List<DriverVehicleDocumentBean> getDriver_vehicle_document() {
            return driver_vehicle_document;
        }

        public void setDriver_vehicle_document(List<DriverVehicleDocumentBean> driver_vehicle_document) {
            this.driver_vehicle_document = driver_vehicle_document;
        }

        public static class DriverVehicleDocumentBean {
            /**
             * id : 34
             * driver_vehicle_id : 49
             * document : drivervehicledocument/Pwcm5uYicC0bNSUr89JpRRkeOuXFUBcK5a6NzUw3.jpeg
             * document_id : 30
             * expire_date : 2017-03-14
             * document_verification_status : 4
             * document_name : Vehicle R.C.
             */

            private int id;
            private int driver_vehicle_id;
            private String document;
            private int document_id;
            private String expire_date;
            private int document_verification_status;
            private String document_name;
            private Boolean temp_doc_upload;

            public int getId() {
                return id;
            }

            public Boolean getTemp_doc_upload() {
                return temp_doc_upload;
            }

            public void setTemp_doc_upload(Boolean temp_doc_upload) {
                this.temp_doc_upload = temp_doc_upload;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDriver_vehicle_id() {
                return driver_vehicle_id;
            }

            public void setDriver_vehicle_id(int driver_vehicle_id) {
                this.driver_vehicle_id = driver_vehicle_id;
            }

            public String getDocument() {
                return document;
            }

            public void setDocument(String document) {
                this.document = document;
            }

            public int getDocument_id() {
                return document_id;
            }

            public void setDocument_id(int document_id) {
                this.document_id = document_id;
            }

            public String getExpire_date() {
                return expire_date;
            }

            public void setExpire_date(String expire_date) {
                this.expire_date = expire_date;
            }

            public int getDocument_verification_status() {
                return document_verification_status;
            }

            public void setDocument_verification_status(int document_verification_status) {
                this.document_verification_status = document_verification_status;
            }

            public String getDocument_name() {
                return document_name;
            }

            public void setDocument_name(String document_name) {
                this.document_name = document_name;
            }
        }
    }
}
