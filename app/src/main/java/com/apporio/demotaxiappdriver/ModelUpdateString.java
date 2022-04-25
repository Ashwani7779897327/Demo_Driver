package com.apporio.demotaxiappdriver;

public class ModelUpdateString {


    /**
     * result : 1
     * message : Updated Strings
     * locale : es
     * data : {"LOGIN_ACTIVITY__new_here_sign_up":"Please SignUp","first_name":"Enter Firsto Name"}
     * latest_version : 1.3
     */

    private String result;
    private String message;
    private String locale;
    private DataBean data;
    private String latest_version;

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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getLatest_version() {
        return latest_version;
    }

    public void setLatest_version(String latest_version) {
        this.latest_version = latest_version;
    }

    public static class DataBean {
        /**
         * LOGIN_ACTIVITY__new_here_sign_up : Please SignUp
         * first_name : Enter Firsto Name
         */

        private String LOGIN_ACTIVITY__new_here_sign_up;
        private String first_name;

        public String getLOGIN_ACTIVITY__new_here_sign_up() {
            return LOGIN_ACTIVITY__new_here_sign_up;
        }

        public void setLOGIN_ACTIVITY__new_here_sign_up(String LOGIN_ACTIVITY__new_here_sign_up) {
            this.LOGIN_ACTIVITY__new_here_sign_up = LOGIN_ACTIVITY__new_here_sign_up;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }
    }
}