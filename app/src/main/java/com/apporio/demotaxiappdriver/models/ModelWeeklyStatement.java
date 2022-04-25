package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelWeeklyStatement {

    /**
     * data : {"outstand_amount":"INR -10","date_text":"27/August To 02/September","total_commision_deducted":"INR 232","total_earning":"INR 0","total_ride":"7 Ride","total_billed_to_consumer":"INR 9501.56","weekly_data":[{"date":"2018-09-01","day_name":"Saturday","rides":"7 Rides","rides_color":"bbbbbb","day_earning":"INR 9269.560000000001"}]}
     * result : 1
     * message : Your Weekly Earning
     */

    private DataBean data;
    private String result;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean {
        /**
         * outstand_amount : INR -10
         * date_text : 27/August To 02/September
         * total_commision_deducted : INR 232
         * total_earning : INR 0
         * total_ride : 7 Ride
         * total_billed_to_consumer : INR 9501.56
         * weekly_data : [{"date":"2018-09-01","day_name":"Saturday","rides":"7 Rides","rides_color":"bbbbbb","day_earning":"INR 9269.560000000001"}]
         */

        private String outstand_amount;
        private String date_text;
        private String total_commision_deducted;
        private String total_earning;
        private String total_ride;
        private String total_billed_to_consumer;
        private List<WeeklyDataBean> weekly_data;

        public String getOutstand_amount() {
            return outstand_amount;
        }

        public void setOutstand_amount(String outstand_amount) {
            this.outstand_amount = outstand_amount;
        }

        public String getDate_text() {
            return date_text;
        }

        public void setDate_text(String date_text) {
            this.date_text = date_text;
        }

        public String getTotal_commision_deducted() {
            return total_commision_deducted;
        }

        public void setTotal_commision_deducted(String total_commision_deducted) {
            this.total_commision_deducted = total_commision_deducted;
        }

        public String getTotal_earning() {
            return total_earning;
        }

        public void setTotal_earning(String total_earning) {
            this.total_earning = total_earning;
        }

        public String getTotal_ride() {
            return total_ride;
        }

        public void setTotal_ride(String total_ride) {
            this.total_ride = total_ride;
        }

        public String getTotal_billed_to_consumer() {
            return total_billed_to_consumer;
        }

        public void setTotal_billed_to_consumer(String total_billed_to_consumer) {
            this.total_billed_to_consumer = total_billed_to_consumer;
        }

        public List<WeeklyDataBean> getWeekly_data() {
            return weekly_data;
        }

        public void setWeekly_data(List<WeeklyDataBean> weekly_data) {
            this.weekly_data = weekly_data;
        }

        public static class WeeklyDataBean {
            /**
             * date : 2018-09-01
             * day_name : Saturday
             * rides : 7 Rides
             * rides_color : bbbbbb
             * day_earning : INR 9269.560000000001
             */

            private String date;
            private String day_name;
            private String rides;
            private String rides_color;
            private String day_earning;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDay_name() {
                return day_name;
            }

            public void setDay_name(String day_name) {
                this.day_name = day_name;
            }

            public String getRides() {
                return rides;
            }

            public void setRides(String rides) {
                this.rides = rides;
            }

            public String getRides_color() {
                return rides_color;
            }

            public void setRides_color(String rides_color) {
                this.rides_color = rides_color;
            }

            public String getDay_earning() {
                return day_earning;
            }

            public void setDay_earning(String day_earning) {
                this.day_earning = day_earning;
            }
        }
    }
}
