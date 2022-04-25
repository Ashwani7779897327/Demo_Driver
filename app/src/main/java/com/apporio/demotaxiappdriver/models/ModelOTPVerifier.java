package com.apporio.demotaxiappdriver.models;

public class ModelOTPVerifier {

    /**
     * result : 1
     * message : Otp Send To Your Number
     * data : {"auto_fill":true,"otp":"2018"}
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
         * auto_fill : true
         * otp : 2018
         */

        private boolean auto_fill;
        private String otp;

        public boolean isAuto_fill() {
            return auto_fill;
        }

        public void setAuto_fill(boolean auto_fill) {
            this.auto_fill = auto_fill;
        }

        public String getOtp() {
            return otp;
        }

        public void setOtp(String otp) {
            this.otp = otp;
        }
    }
}
