package com.apporio.demotaxiappdriver.models;

public class ModelHomeAddressActivate {

    /**
     * result : 1
     * message : Home Location Activate
     * data : true
     */

    private String result;
    private String message;
    private boolean data;

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

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }
}
