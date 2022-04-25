package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelFragmenRides {

    /**
     * result : 1
     * message : Your Ride History
     * total_pages : 1
     * current_page : 1
     * data : [{"highlighted_left_text":"Normal Luxury","highlighted_left_text_style":"BOLD","highlighted_left_text_color":"333333","small_left_text":"2018-07-18 11:10:17","small_left_text_style":"","small_left_text_color":"333333","highlighted_right_text":"Cash","highlighted_right_text_style":"BOLD","highlighted_right_text_color":"27ae60","small_right_text":"","small_right_text_style":"BOLD","small_right_text_color":"bbbbbb","pick_location":"438, Sohna Rd, Park View City 1, Tatvam Villas, Dhani, Sector 48, Gurugram, Haryana 122103, India","pick_location_visibility":true,"drop_location":"11, Orchid Petals Internal Road, Sector 49, Gurugram, Haryana 122018, India","drop_location_visibility":true,"user_description_layout_visibility":true,"circular_image":null,"user_name_text":"samir goel","user_descriptive_text":"+919650923089","status_text":"Accepted","status_text_syle":"BOLD","status_text_color":"333333"}]
     */

    private String result;
    private String message;
    private int total_pages;
    private int current_page;
    private String next_page_url;
    private List<DataBean> data;

    public String getResult() {
        return result;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
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

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * highlighted_left_text : Normal Luxury
         * highlighted_left_text_style : BOLD
         * highlighted_left_text_color : 333333
         * small_left_text : 2018-07-18 11:10:17
         * small_left_text_style :
         * small_left_text_color : 333333
         * highlighted_right_text : Cash
         * highlighted_right_text_style : BOLD
         * highlighted_right_text_color : 27ae60
         * small_right_text :
         * small_right_text_style : BOLD
         * small_right_text_color : bbbbbb
         * pick_location : 438, Sohna Rd, Park View City 1, Tatvam Villas, Dhani, Sector 48, Gurugram, Haryana 122103, India
         * pick_location_visibility : true
         * drop_location : 11, Orchid Petals Internal Road, Sector 49, Gurugram, Haryana 122018, India
         * drop_location_visibility : true
         * user_description_layout_visibility : true
         * circular_image : null
         * user_name_text : samir goel
         * user_descriptive_text : +919650923089
         * status_text : Accepted
         * status_text_syle : BOLD
         * status_text_color : 333333
         */

        private String highlighted_left_text;
        private String highlighted_left_text_style;
        private String highlighted_left_text_color;
        private String small_left_text;
        private String small_left_text_style;
        private String small_left_text_color;
        private String highlighted_right_text;
        private String highlighted_right_text_style;
        private String highlighted_right_text_color;
        private String small_right_text;
        private String small_right_text_style;
        private String small_right_text_color;
        private String pick_location;
        private boolean pick_location_visibility;
        private String drop_location;
        private boolean drop_location_visibility;
        private boolean user_description_layout_visibility;
        private Object circular_image;
        private String user_name_text;
        private String user_descriptive_text;
        private String status_text;
        private String status_text_syle;
        private String status_text_color;
        private String booking_id;
        private String estimate_bill;

        public String getEstimate_bill() {
            return estimate_bill;
        }

        public void setEstimate_bill(String estimate_bill) {
            this.estimate_bill = estimate_bill;
        }

        public String getBooking_id() {
            return booking_id;
        }

        public void setBooking_id(String booking_id) {
            this.booking_id = booking_id;
        }



        public String getHighlighted_left_text() {
            return highlighted_left_text;
        }

        public void setHighlighted_left_text(String highlighted_left_text) {
            this.highlighted_left_text = highlighted_left_text;
        }

        public String getHighlighted_left_text_style() {
            return highlighted_left_text_style;
        }

        public void setHighlighted_left_text_style(String highlighted_left_text_style) {
            this.highlighted_left_text_style = highlighted_left_text_style;
        }

        public String getHighlighted_left_text_color() {
            return highlighted_left_text_color;
        }

        public void setHighlighted_left_text_color(String highlighted_left_text_color) {
            this.highlighted_left_text_color = highlighted_left_text_color;
        }

        public String getSmall_left_text() {
            return small_left_text;
        }

        public void setSmall_left_text(String small_left_text) {
            this.small_left_text = small_left_text;
        }

        public String getSmall_left_text_style() {
            return small_left_text_style;
        }

        public void setSmall_left_text_style(String small_left_text_style) {
            this.small_left_text_style = small_left_text_style;
        }

        public String getSmall_left_text_color() {
            return small_left_text_color;
        }

        public void setSmall_left_text_color(String small_left_text_color) {
            this.small_left_text_color = small_left_text_color;
        }

        public String getHighlighted_right_text() {
            return highlighted_right_text;
        }

        public void setHighlighted_right_text(String highlighted_right_text) {
            this.highlighted_right_text = highlighted_right_text;
        }

        public String getHighlighted_right_text_style() {
            return highlighted_right_text_style;
        }

        public void setHighlighted_right_text_style(String highlighted_right_text_style) {
            this.highlighted_right_text_style = highlighted_right_text_style;
        }

        public String getHighlighted_right_text_color() {
            return highlighted_right_text_color;
        }

        public void setHighlighted_right_text_color(String highlighted_right_text_color) {
            this.highlighted_right_text_color = highlighted_right_text_color;
        }

        public String getSmall_right_text() {
            return small_right_text;
        }

        public void setSmall_right_text(String small_right_text) {
            this.small_right_text = small_right_text;
        }

        public String getSmall_right_text_style() {
            return small_right_text_style;
        }

        public void setSmall_right_text_style(String small_right_text_style) {
            this.small_right_text_style = small_right_text_style;
        }

        public String getSmall_right_text_color() {
            return small_right_text_color;
        }

        public void setSmall_right_text_color(String small_right_text_color) {
            this.small_right_text_color = small_right_text_color;
        }

        public String getPick_location() {
            return pick_location;
        }

        public void setPick_location(String pick_location) {
            this.pick_location = pick_location;
        }

        public boolean isPick_location_visibility() {
            return pick_location_visibility;
        }

        public void setPick_location_visibility(boolean pick_location_visibility) {
            this.pick_location_visibility = pick_location_visibility;
        }

        public String getDrop_location() {
            return drop_location;
        }

        public void setDrop_location(String drop_location) {
            this.drop_location = drop_location;
        }

        public boolean isDrop_location_visibility() {
            return drop_location_visibility;
        }

        public void setDrop_location_visibility(boolean drop_location_visibility) {
            this.drop_location_visibility = drop_location_visibility;
        }

        public boolean isUser_description_layout_visibility() {
            return user_description_layout_visibility;
        }

        public void setUser_description_layout_visibility(boolean user_description_layout_visibility) {
            this.user_description_layout_visibility = user_description_layout_visibility;
        }

        public Object getCircular_image() {
            return circular_image;
        }

        public void setCircular_image(Object circular_image) {
            this.circular_image = circular_image;
        }

        public String getUser_name_text() {
            return user_name_text;
        }

        public void setUser_name_text(String user_name_text) {
            this.user_name_text = user_name_text;
        }

        public String getUser_descriptive_text() {
            return user_descriptive_text;
        }

        public void setUser_descriptive_text(String user_descriptive_text) {
            this.user_descriptive_text = user_descriptive_text;
        }

        public String getStatus_text() {
            return status_text;
        }

        public void setStatus_text(String status_text) {
            this.status_text = status_text;
        }

        public String getStatus_text_syle() {
            return status_text_syle;
        }

        public void setStatus_text_syle(String status_text_syle) {
            this.status_text_syle = status_text_syle;
        }

        public String getStatus_text_color() {
            return status_text_color;
        }

        public void setStatus_text_color(String status_text_color) {
            this.status_text_color = status_text_color;
        }
    }
}
