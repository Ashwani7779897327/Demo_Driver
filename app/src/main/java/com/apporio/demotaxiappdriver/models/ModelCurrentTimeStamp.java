package com.apporio.demotaxiappdriver.models;

public class ModelCurrentTimeStamp {


    /**
     * result : 1
     * message : Time Stamp
     * data : {"current_time":1557914247,"diffrance":7455}
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
         * current_time : 1557914247
         * diffrance : 7455
         */

        private int current_time;
        private int diffrance;

        public int getCurrent_time() {
            return current_time;
        }

        public void setCurrent_time(int current_time) {
            this.current_time = current_time;
        }

        public int getDiffrance() {
            return diffrance;
        }

        public void setDiffrance(int diffrance) {
            this.diffrance = diffrance;
        }
    }
}
