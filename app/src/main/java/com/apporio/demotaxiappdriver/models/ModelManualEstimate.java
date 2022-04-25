package com.apporio.demotaxiappdriver.models;

public class ModelManualEstimate {


    /**
     * result : 1
     * message : estimate
     * data : {"time":"22 mins","amount":"\u20b931.16","distance":"7.6 km"}
     * otp_manual_dispatch : true
     */

    private String result;
    private String message;
    private DataBean data;
    private boolean otp_manual_dispatch;

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

    public boolean isOtp_manual_dispatch() {
        return otp_manual_dispatch;
    }

    public void setOtp_manual_dispatch(boolean otp_manual_dispatch) {
        this.otp_manual_dispatch = otp_manual_dispatch;
    }

    public static class DataBean {
        /**
         * time : 22 mins
         * amount : ₹31.16
         * distance : 7.6 km
         */

        private String time;
        private String amount;
        private String distance;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }
    }
}
