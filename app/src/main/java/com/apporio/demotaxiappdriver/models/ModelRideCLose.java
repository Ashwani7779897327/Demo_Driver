package com.apporio.demotaxiappdriver.models;

public class ModelRideCLose {

    /**
     * result : 1
     * message : Address Changed
     * data : {"refresh_screen":true}
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
         * refresh_screen : true
         */

        private boolean refresh_screen;

        public boolean isRefresh_screen() {
            return refresh_screen;
        }

        public void setRefresh_screen(boolean refresh_screen) {
            this.refresh_screen = refresh_screen;
        }
    }

}
