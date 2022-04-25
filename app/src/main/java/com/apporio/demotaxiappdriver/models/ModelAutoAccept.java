package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelAutoAccept {


    private String result;
    private String message;
    private String AutoAccept;
    private List<?> data;

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

    public String getAutoAccept() {
        return AutoAccept;
    }

    public void setAutoAccept(String AutoAccept) {
        this.AutoAccept = AutoAccept;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}