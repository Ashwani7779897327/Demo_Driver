package com.apporio.demotaxiappdriver;

/**
 * Created by Lenovo on 15-03-2019.
 */

class ModelReferAndEarn {

    /**
     * result : 1
     * message : data grabbed successfully
     * data : {"refer_image":"https://promocodes.ltd.uk/images/reveal-promo-code.png","refer_heading":"Refer Code and earn More","refer_explanation":"refer this following code to your friends and family and earn money by just viewing advertisement and refer again.","start_date":"12/Aug/2018","end_date":"19/Aug/2018","refer_code":"SSDHY7787","sharing_text":"full text gone here that we will share on other app like wats app."}
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
         * refer_image : https://promocodes.ltd.uk/images/reveal-promo-code.png
         * refer_heading : Refer Code and earn More
         * refer_explanation : refer this following code to your friends and family and earn money by just viewing advertisement and refer again.
         * start_date : 12/Aug/2018
         * end_date : 19/Aug/2018
         * refer_code : SSDHY7787
         * sharing_text : full text gone here that we will share on other app like wats app.
         */

        private String refer_image;
        private String refer_heading;
        private String refer_explanation;
        private String start_date;
        private String end_date;
        private String refer_code;
        private String sharing_text;

        public String getRefer_image() {
            return refer_image;
        }

        public void setRefer_image(String refer_image) {
            this.refer_image = refer_image;
        }

        public String getRefer_heading() {
            return refer_heading;
        }

        public void setRefer_heading(String refer_heading) {
            this.refer_heading = refer_heading;
        }

        public String getRefer_explanation() {
            return refer_explanation;
        }

        public void setRefer_explanation(String refer_explanation) {
            this.refer_explanation = refer_explanation;
        }

        public String getStart_date() {
            return start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public String getEnd_date() {
            return end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }

        public String getRefer_code() {
            return refer_code;
        }

        public void setRefer_code(String refer_code) {
            this.refer_code = refer_code;
        }

        public String getSharing_text() {
            return sharing_text;
        }

        public void setSharing_text(String sharing_text) {
            this.sharing_text = sharing_text;
        }
    }

}
