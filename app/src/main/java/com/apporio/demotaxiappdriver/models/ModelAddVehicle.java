package com.apporio.demotaxiappdriver.models;

public class ModelAddVehicle {

    /**
     * result : 1
     * message : Vehicle added
     * data : {"driver_id":"12","vehicle_type_id":"1","vehicle_make_id":"1","vehicle_model_id":"1","vehicle_number":"Dl-3358","vehicle_color":"Cyan","vehicle_image":"driverVehicle/Tb0Pt5reERIx58SXU8emS0y2NxqvsfSvhQj3lphR.png","vehicle_number_plate_image":"driverVehicle/hqWiGW16a5lo2MPqMO1eO8IaDjgDkFGpQJMCyn0R.png","updated_at":"2018-07-04 06:05:10","created_at":"2018-07-04 06:05:10","id":1}
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
         * vehicle_type_id : 1
         * vehicle_make_id : 1
         * vehicle_model_id : 1
         * vehicle_number : Dl-3358
         * vehicle_color : Cyan
         * vehicle_image : driverVehicle/Tb0Pt5reERIx58SXU8emS0y2NxqvsfSvhQj3lphR.png
         * vehicle_number_plate_image : driverVehicle/hqWiGW16a5lo2MPqMO1eO8IaDjgDkFGpQJMCyn0R.png
         * updated_at : 2018-07-04 06:05:10
         * created_at : 2018-07-04 06:05:10
         * id : 1
         */

        private String driver_id;
        private String vehicle_type_id;
        private String vehicle_make_id;
        private String vehicle_model_id;

        public int getOnline_offline() {
            return online_offline;
        }

        public void setOnline_offline(int online_offline) {
            this.online_offline = online_offline;
        }

        public int getLogin_logout() {
            return login_logout;
        }

        public void setLogin_logout(int login_logout) {
            this.login_logout = login_logout;
        }

        private String vehicle_number;
        private String vehicle_color;
        private String vehicle_image;
        private String vehicle_number_plate_image;
        private String updated_at;

        public int getCountry_area_id() {
            return country_area_id;
        }

        public void setCountry_area_id(int country_area_id) {
            this.country_area_id = country_area_id;
        }

        private String created_at;
        private int online_offline;
        private int country_area_id;
        private int login_logout;
        private int id;

        public String getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(String driver_id) {
            this.driver_id = driver_id;
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

        public String getVehicle_model_id() {
            return vehicle_model_id;
        }

        public void setVehicle_model_id(String vehicle_model_id) {
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
