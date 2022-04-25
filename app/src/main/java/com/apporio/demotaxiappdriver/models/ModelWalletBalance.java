package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelWalletBalance {

    /**
     * result : 1
     * message : Your Wallet Transaction
     * total_pages : 7
     * current_page : 1
     * data : {"recent_transactoin":[{"amount":"100.0","date":"2018-08-03 12:38:58","value_color":"2ecc71","icon":"dollar1.png","driver_id":"1","transaction_type":"Credit","payment_method":"Non Cash","platform":"Application","description":"sending as per demo card only","narration":"Wallet recharged by Driver"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"11","platform":"Application","date":"2018-08-04 05:07:39","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:6","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 05:42:55","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:7","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 05:48:20","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:8","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 06:06:25","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:9","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 06:28:56","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:10","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 06:46:18","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:11","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 06:53:44","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:12","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 06:59:06","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:13","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 07:21:03","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:14","value_color":"e74c3c","icon":"dollar.png"}],"wallet_money":"536"}
     * next_page_url : http://apporioinfolabs.com/ApporiotaxiMaster/public/api/driver/wallet/transaction?page=2
     */

    private String result;
    private String message;
    private int total_pages;
    private int current_page;
    private DataBean data;
    private String next_page_url;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public static class DataBean {
        /**
         * recent_transactoin : [{"amount":"100.0","date":"2018-08-03 12:38:58","value_color":"2ecc71","icon":"dollar1.png","driver_id":"1","transaction_type":"Credit","payment_method":"Non Cash","platform":"Application","description":"sending as per demo card only","narration":"Wallet recharged by Driver"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"11","platform":"Application","date":"2018-08-04 05:07:39","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:6","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 05:42:55","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:7","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 05:48:20","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:8","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 06:06:25","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:9","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 06:28:56","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:10","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 06:46:18","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:11","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 06:53:44","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:12","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 06:59:06","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:13","value_color":"e74c3c","icon":"dollar.png"},{"driver_id":"1","transaction_type":"Debit","payment_method":"Cash","amount":"12","platform":"Application","date":"2018-08-04 07:21:03","description":"Auto Deduct At Ride End","narration":"Company commission by Booking id:14","value_color":"e74c3c","icon":"dollar.png"}]
         * wallet_money : 536
         */

        private String wallet_money;
        private List<RecentTransactoinBean> recent_transactoin;

        public String getWallet_money() {
            return wallet_money;
        }

        public void setWallet_money(String wallet_money) {
            this.wallet_money = wallet_money;
        }

        public List<RecentTransactoinBean> getRecent_transactoin() {
            return recent_transactoin;
        }

        public void setRecent_transactoin(List<RecentTransactoinBean> recent_transactoin) {
            this.recent_transactoin = recent_transactoin;
        }

        public static class RecentTransactoinBean {
            /**
             * amount : 100.0
             * date : 2018-08-03 12:38:58
             * value_color : 2ecc71
             * icon : dollar1.png
             * driver_id : 1
             * transaction_type : Credit
             * payment_method : Non Cash
             * platform : Application
             * description : sending as per demo card only
             * narration : Wallet recharged by Driver
             */

            private String amount;
            private String date;
            private String value_color;
            private String icon;
            private String driver_id;
            private String transaction_type;
            private String payment_method;
            private String platform;
            private String description;
            private String narration;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getValue_color() {
                return value_color;
            }

            public void setValue_color(String value_color) {
                this.value_color = value_color;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getDriver_id() {
                return driver_id;
            }

            public void setDriver_id(String driver_id) {
                this.driver_id = driver_id;
            }

            public String getTransaction_type() {
                return transaction_type;
            }

            public void setTransaction_type(String transaction_type) {
                this.transaction_type = transaction_type;
            }

            public String getPayment_method() {
                return payment_method;
            }

            public void setPayment_method(String payment_method) {
                this.payment_method = payment_method;
            }

            public String getPlatform() {
                return platform;
            }

            public void setPlatform(String platform) {
                this.platform = platform;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getNarration() {
                return narration;
            }

            public void setNarration(String narration) {
                this.narration = narration;
            }
        }
    }
}
