package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelDailyEarning {

    /**
     * data : {"total_earning":"9269.560000000001","date":"2018-09-01","completed_trip":"7 Trips","acceptance_rate":"90","online_time":"12Hr 32 Min","overall_rating":"4.5","total_billed_to_customer":"INR 9501.56","comission_deducted":"INR 232","rides_data":[{"rides_color":"bbbbbb","ride_name":"CRN # 41","ride_id":41,"ride_earning":"INR 1239"},{"rides_color":"bbbbbb","ride_name":"CRN # 43","ride_id":43,"ride_earning":"INR 1958.4"},{"rides_color":"bbbbbb","ride_name":"CRN # 44","ride_id":44,"ride_earning":"INR 1952.16"},{"rides_color":"bbbbbb","ride_name":"CRN # 45","ride_id":45,"ride_earning":"INR 1952.04"},{"rides_color":"bbbbbb","ride_name":"CRN # 46","ride_id":46,"ride_earning":"INR 0"},{"rides_color":"bbbbbb","ride_name":"CRN # 47","ride_id":47,"ride_earning":"INR 1953.96"},{"rides_color":"bbbbbb","ride_name":"CRN # 48","ride_id":48,"ride_earning":"INR 214"}]}
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
         * total_earning : 9269.560000000001
         * date : 2018-09-01
         * completed_trip : 7 Trips
         * acceptance_rate : 90
         * online_time : 12Hr 32 Min
         * overall_rating : 4.5
         * total_billed_to_customer : INR 9501.56
         * comission_deducted : INR 232
         * rides_data : [{"rides_color":"bbbbbb","ride_name":"CRN # 41","ride_id":41,"ride_earning":"INR 1239"},{"rides_color":"bbbbbb","ride_name":"CRN # 43","ride_id":43,"ride_earning":"INR 1958.4"},{"rides_color":"bbbbbb","ride_name":"CRN # 44","ride_id":44,"ride_earning":"INR 1952.16"},{"rides_color":"bbbbbb","ride_name":"CRN # 45","ride_id":45,"ride_earning":"INR 1952.04"},{"rides_color":"bbbbbb","ride_name":"CRN # 46","ride_id":46,"ride_earning":"INR 0"},{"rides_color":"bbbbbb","ride_name":"CRN # 47","ride_id":47,"ride_earning":"INR 1953.96"},{"rides_color":"bbbbbb","ride_name":"CRN # 48","ride_id":48,"ride_earning":"INR 214"}]
         */

        private String total_earning;
        private String date;
        private String completed_trip;
        private String acceptance_rate;
        private String online_time;
        private String overall_rating;
        private String total_billed_to_customer;
        private String comission_deducted;
        private List<RidesDataBean> rides_data;

        public String getTotal_earning() {
            return total_earning;
        }

        public void setTotal_earning(String total_earning) {
            this.total_earning = total_earning;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCompleted_trip() {
            return completed_trip;
        }

        public void setCompleted_trip(String completed_trip) {
            this.completed_trip = completed_trip;
        }

        public String getAcceptance_rate() {
            return acceptance_rate;
        }

        public void setAcceptance_rate(String acceptance_rate) {
            this.acceptance_rate = acceptance_rate;
        }

        public String getOnline_time() {
            return online_time;
        }

        public void setOnline_time(String online_time) {
            this.online_time = online_time;
        }

        public String getOverall_rating() {
            return overall_rating;
        }

        public void setOverall_rating(String overall_rating) {
            this.overall_rating = overall_rating;
        }

        public String getTotal_billed_to_customer() {
            return total_billed_to_customer;
        }

        public void setTotal_billed_to_customer(String total_billed_to_customer) {
            this.total_billed_to_customer = total_billed_to_customer;
        }

        public String getComission_deducted() {
            return comission_deducted;
        }

        public void setComission_deducted(String comission_deducted) {
            this.comission_deducted = comission_deducted;
        }

        public List<RidesDataBean> getRides_data() {
            return rides_data;
        }

        public void setRides_data(List<RidesDataBean> rides_data) {
            this.rides_data = rides_data;
        }

        public static class RidesDataBean {
            /**
             * rides_color : bbbbbb
             * ride_name : CRN # 41
             * ride_id : 41
             * ride_earning : INR 1239
             */

            private String rides_color;
            private String ride_name;
            private int ride_id;
            private String ride_earning;

            public String getRides_color() {
                return rides_color;
            }

            public void setRides_color(String rides_color) {
                this.rides_color = rides_color;
            }

            public String getRide_name() {
                return ride_name;
            }

            public void setRide_name(String ride_name) {
                this.ride_name = ride_name;
            }

            public int getRide_id() {
                return ride_id;
            }

            public void setRide_id(int ride_id) {
                this.ride_id = ride_id;
            }

            public String getRide_earning() {
                return ride_earning;
            }

            public void setRide_earning(String ride_earning) {
                this.ride_earning = ride_earning;
            }
        }
    }
}
