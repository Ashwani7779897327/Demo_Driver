package com.apporio.demotaxiappdriver;

import java.util.List;

public class ModelNewEarnings {

    /**
     * result : 1
     * message : Your Earning!
     * data : {"next_period":null,"previous_period":"2019-05-10 23:59:59/2019-06-10 23:59:59","current_period":"10 Jun 2019-17 Jun 2019","total_earnings":"INR90.00","trips":0,"balance_due":"INR90.00","holder_data":[{"left_text":"Total Earnings","left_text_style":"BOLD","left_text_color":"333333","left_text_visibility":true,"right_text":"","right_text_style":"BOLD","right_text_color":"333333","right_text_visibility":false},{"left_text":"Fare Amount in Rides","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Company Fees in Rides","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Toll Amount","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Tip Amount","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Cancellation Amount","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Referral Amount","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR0.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Net Earnings","left_text_style":"BOLD","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"BOLD","right_text_color":"333333","right_text_visibility":true},{"left_text":"Cash Received","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Net Payout","left_text_style":"BOLD","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"BOLD","right_text_color":"333333","right_text_visibility":true}]}
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
         * next_period : null
         * previous_period : 2019-05-10 23:59:59/2019-06-10 23:59:59
         * current_period : 10 Jun 2019-17 Jun 2019
         * total_earnings : INR90.00
         * trips : 0
         * balance_due : INR90.00
         * holder_data : [{"left_text":"Total Earnings","left_text_style":"BOLD","left_text_color":"333333","left_text_visibility":true,"right_text":"","right_text_style":"BOLD","right_text_color":"333333","right_text_visibility":false},{"left_text":"Fare Amount in Rides","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Company Fees in Rides","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Toll Amount","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Tip Amount","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Cancellation Amount","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Referral Amount","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR0.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Net Earnings","left_text_style":"BOLD","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"BOLD","right_text_color":"333333","right_text_visibility":true},{"left_text":"Cash Received","left_text_style":"NORMAL","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"NORMAL","right_text_color":"333333","right_text_visibility":true},{"left_text":"Net Payout","left_text_style":"BOLD","left_text_color":"333333","left_text_visibility":true,"right_text":"INR90.00","right_text_style":"BOLD","right_text_color":"333333","right_text_visibility":true}]
         */

        private String settled_message;
        private String settled_message_colour;
        private String next_period;
        private String previous_period;
        private String current_period;
        private String current_period_forsend;

        public String getSettled_message() {
            return settled_message;
        }

        public void setSettled_message(String settled_message) {
            this.settled_message = settled_message;
        }

        public String getSettled_message_colour() {
            return settled_message_colour;
        }

        public void setSettled_message_colour(String settled_message_colour) {
            this.settled_message_colour = settled_message_colour;
        }

        public String getCurrent_period_forsend() {
            return current_period_forsend;
        }

        public void setCurrent_period_forsend(String current_period_forsend) {
            this.current_period_forsend = current_period_forsend;
        }

        private String total_earnings;
        private int trips;
        private String balance_due;
        private List<HolderDataBean> holder_data;

        public String getNext_period() {
            return next_period;
        }

        public void setNext_period(String next_period) {
            this.next_period = next_period;
        }

        public String getPrevious_period() {
            return previous_period;
        }

        public void setPrevious_period(String previous_period) {
            this.previous_period = previous_period;
        }

        public String getCurrent_period() {
            return current_period;
        }

        public void setCurrent_period(String current_period) {
            this.current_period = current_period;
        }

        public String getTotal_earnings() {
            return total_earnings;
        }

        public void setTotal_earnings(String total_earnings) {
            this.total_earnings = total_earnings;
        }

        public int getTrips() {
            return trips;
        }

        public void setTrips(int trips) {
            this.trips = trips;
        }

        public String getBalance_due() {
            return balance_due;
        }

        public void setBalance_due(String balance_due) {
            this.balance_due = balance_due;
        }

        public List<HolderDataBean> getHolder_data() {
            return holder_data;
        }

        public void setHolder_data(List<HolderDataBean> holder_data) {
            this.holder_data = holder_data;
        }

        public static class HolderDataBean {
            /**
             * left_text : Total Earnings
             * left_text_style : BOLD
             * left_text_color : 333333
             * left_text_visibility : true
             * right_text :
             * right_text_style : BOLD
             * right_text_color : 333333
             * right_text_visibility : false
             */

            private String left_text;
            private String left_text_style;
            private String left_text_color;
            private boolean left_text_visibility;
            private String right_text;
            private String right_text_style;
            private String right_text_color;
            private boolean right_text_visibility;

            public String getLeft_text() {
                return left_text;
            }

            public void setLeft_text(String left_text) {
                this.left_text = left_text;
            }

            public String getLeft_text_style() {
                return left_text_style;
            }

            public void setLeft_text_style(String left_text_style) {
                this.left_text_style = left_text_style;
            }

            public String getLeft_text_color() {
                return left_text_color;
            }

            public void setLeft_text_color(String left_text_color) {
                this.left_text_color = left_text_color;
            }

            public boolean isLeft_text_visibility() {
                return left_text_visibility;
            }

            public void setLeft_text_visibility(boolean left_text_visibility) {
                this.left_text_visibility = left_text_visibility;
            }

            public String getRight_text() {
                return right_text;
            }

            public void setRight_text(String right_text) {
                this.right_text = right_text;
            }

            public String getRight_text_style() {
                return right_text_style;
            }

            public void setRight_text_style(String right_text_style) {
                this.right_text_style = right_text_style;
            }

            public String getRight_text_color() {
                return right_text_color;
            }

            public void setRight_text_color(String right_text_color) {
                this.right_text_color = right_text_color;
            }

            public boolean isRight_text_visibility() {
                return right_text_visibility;
            }

            public void setRight_text_visibility(boolean right_text_visibility) {
                this.right_text_visibility = right_text_visibility;
            }
        }
    }
}
