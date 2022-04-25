package com.apporio.demotaxiappdriver.models;

public class ModelDriverRating {
    /**
     * result : 1
     * message : Average Rating
     * data : {"rating":"0.0","name":"testing","image":"driver/bNNgR9TA2D0ooLZWsqL7gyJic1hr86O2fw97BVxD.jpeg"}
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
         * rating : 0.0
         * name : testing
         * image : driver/bNNgR9TA2D0ooLZWsqL7gyJic1hr86O2fw97BVxD.jpeg
         */

        private String rating;
        private String name;
        private String image;

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
