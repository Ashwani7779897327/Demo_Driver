package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelVehicleModel {

    /**
     * result : 1
     * message : Vehicle Model data
     * data : [{"id":1,"merchant_id":"1","vehicle_type_id":"1","vehicle_make_id":"1","vehicleModelName":"Swifit","vehicleModelDescription":"test","created_at":"2018-05-17 06:11:08","updated_at":"2018-05-17 06:11:08"}]
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
         * merchant_id : 1
         * vehicle_type_id : 1
         * vehicle_make_id : 1
         * vehicleModelName : Swifit
         * vehicleModelDescription : test
         * created_at : 2018-05-17 06:11:08
         * updated_at : 2018-05-17 06:11:08
         */

        private int id;
        private String merchant_id;
        private String vehicle_type_id;
        private String vehicle_make_id;
        private String vehicleModelName;
        private String vehicleModelDescription;
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

        public String getVehicle_type_id() {
            return vehicle_type_id;
        }

        public void setVehicle_type_id(String vehicle_type_id) {
            this.vehicle_type_id = vehicle_type_id;
        }

        public String getVehicle_make_id() {
            return vehicle_make_id;
        }

        public void setVehicle_make_id(String vehicle_make_id) {
            this.vehicle_make_id = vehicle_make_id;
        }

        public String getVehicleModelName() {
            return vehicleModelName;
        }

        public void setVehicleModelName(String vehicleModelName) {
            this.vehicleModelName = vehicleModelName;
        }

        public String getVehicleModelDescription() {
            return vehicleModelDescription;
        }

        public void setVehicleModelDescription(String vehicleModelDescription) {
            this.vehicleModelDescription = vehicleModelDescription;
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
