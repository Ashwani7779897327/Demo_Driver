package com.apporio.demotaxiappdriver;

/**
 * Created by Lenovo on 19-03-2019.
 */

public class ModelReverseGeocode {


        /**
         * result : 1
         * message : Location Detail
         * data : {"address":"Unnamed Road, Rajiv Gandhi Education City, Khewra, Haryana 131021, India","city":"Sonipat"}
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
             * address : Unnamed Road, Rajiv Gandhi Education City, Khewra, Haryana 131021, India
             * city : Sonipat
             */

            private String address;
            private String city;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }
        }
    }

