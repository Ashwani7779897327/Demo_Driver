package com.apporio.demotaxiappdriver;

import java.util.List;

public class ModelEarning {

    /**
     * data : {"currency":"INR","start_date":"27/August","last_date":"02/September","total_weekly_amount":"INR 9269.56","total_weekly_rides":"1 Ride","outstand_color":"e74c3c","outstand_amount":"INR -10","detail":[{"date":"2018-08-27","day":"Monday","details":{"rides":"0","driver_amount":"0","date":"2018-08-27"}},{"date":"2018-08-28","day":"Tuesday","details":{"rides":"0","driver_amount":"0","date":"2018-08-28"}},{"date":"2018-08-29","day":"Wednesday","details":{"rides":"0","driver_amount":"0","date":"2018-08-29"}},{"date":"2018-08-30","day":"Thursday","details":{"rides":"0","driver_amount":"0","date":"2018-08-30"}},{"date":"2018-08-31","day":"Friday","details":{"rides":"0","driver_amount":"0","date":"2018-08-31"}},{"date":"2018-09-01","day":"Saturday","details":{"rides":"7","driver_amount":"9269.560000000001","date":"2018-09-01"}},{"date":"2018-09-02","day":"Sunday","details":{"rides":"0","driver_amount":"0","date":"2018-09-02"}}]}
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
         * currency : INR
         * start_date : 27/August
         * last_date : 02/September
         * total_weekly_amount : INR 9269.56
         * total_weekly_rides : 1 Ride
         * outstand_color : e74c3c
         * outstand_amount : INR -10
         * detail : [{"date":"2018-08-27","day":"Monday","details":{"rides":"0","driver_amount":"0","date":"2018-08-27"}},{"date":"2018-08-28","day":"Tuesday","details":{"rides":"0","driver_amount":"0","date":"2018-08-28"}},{"date":"2018-08-29","day":"Wednesday","details":{"rides":"0","driver_amount":"0","date":"2018-08-29"}},{"date":"2018-08-30","day":"Thursday","details":{"rides":"0","driver_amount":"0","date":"2018-08-30"}},{"date":"2018-08-31","day":"Friday","details":{"rides":"0","driver_amount":"0","date":"2018-08-31"}},{"date":"2018-09-01","day":"Saturday","details":{"rides":"7","driver_amount":"9269.560000000001","date":"2018-09-01"}},{"date":"2018-09-02","day":"Sunday","details":{"rides":"0","driver_amount":"0","date":"2018-09-02"}}]
         */

        private String currency;
        private String start_date;
        private String last_date;
        private String total_weekly_amount;
        private String total_weekly_rides;
        private String outstand_color;
        private String outstand_amount;
        private List<DetailBean> detail;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getStart_date() {
            return start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public String getLast_date() {
            return last_date;
        }

        public void setLast_date(String last_date) {
            this.last_date = last_date;
        }

        public String getTotal_weekly_amount() {
            return total_weekly_amount;
        }

        public void setTotal_weekly_amount(String total_weekly_amount) {
            this.total_weekly_amount = total_weekly_amount;
        }

        public String getTotal_weekly_rides() {
            return total_weekly_rides;
        }

        public void setTotal_weekly_rides(String total_weekly_rides) {
            this.total_weekly_rides = total_weekly_rides;
        }

        public String getOutstand_color() {
            return outstand_color;
        }

        public void setOutstand_color(String outstand_color) {
            this.outstand_color = outstand_color;
        }

        public String getOutstand_amount() {
            return outstand_amount;
        }

        public void setOutstand_amount(String outstand_amount) {
            this.outstand_amount = outstand_amount;
        }

        public List<DetailBean> getDetail() {
            return detail;
        }

        public void setDetail(List<DetailBean> detail) {
            this.detail = detail;
        }

        public static class DetailBean {
            /**
             * date : 2018-08-27
             * day : Monday
             * details : {"rides":"0","driver_amount":"0","date":"2018-08-27"}
             */

            private String date;
            private String day;
            private DetailsBean details;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public DetailsBean getDetails() {
                return details;
            }

            public void setDetails(DetailsBean details) {
                this.details = details;
            }

            public static class DetailsBean {
                /**
                 * rides : 0
                 * driver_amount : 0
                 * date : 2018-08-27
                 */

                private String rides;
                private String driver_amount;
                private String date;

                public String getRides() {
                    return rides;
                }

                public void setRides(String rides) {
                    this.rides = rides;
                }

                public String getDriver_amount() {
                    return driver_amount;
                }

                public void setDriver_amount(String driver_amount) {
                    this.driver_amount = driver_amount;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }
            }
        }
    }
}
