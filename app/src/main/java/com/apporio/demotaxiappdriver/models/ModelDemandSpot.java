package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelDemandSpot {


    /**
     * result : 1
     * message : High Demand Area
     * data : [{"pickup_latitude":"28.4125","pickup_longitude":"77.0439"},{"pickup_latitude":"28.40660096217675","pickup_longitude":"77.04555340111256"}]
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
         * pickup_latitude : 28.4125
         * pickup_longitude : 77.0439
         */

        private String pickup_latitude;
        private String pickup_longitude;

        public String getPickup_latitude() {
            return pickup_latitude;
        }

        public void setPickup_latitude(String pickup_latitude) {
            this.pickup_latitude = pickup_latitude;
        }

        public String getPickup_longitude() {
            return pickup_longitude;
        }

        public void setPickup_longitude(String pickup_longitude) {
            this.pickup_longitude = pickup_longitude;
        }
    }
}
