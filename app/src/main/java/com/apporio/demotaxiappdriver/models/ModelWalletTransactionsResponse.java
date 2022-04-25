package com.apporio.demotaxiappdriver.models;

import java.io.Serializable;
import java.util.List;

public class ModelWalletTransactionsResponse implements Serializable {

    /**
     * result : 1
     * message : Booking Data Successfully Fatcehd
     * wallet_balance : 900
     * low_alert_balance_status : 1
     * transactions : [{"trans_id":"12","driver_id":"1","payment_method":"Cash","receipt_number":"","total_amount":"0.00","description":"","order_via":"2","date_time":"2018-05-30 09:07:36","transaction_type":"Debit","narration":"Ride is Completed Successfully","added_by":"Rajat ."},{"trans_id":"11","driver_id":"1","payment_method":"Cash","receipt_number":"","total_amount":"0.00","description":"","order_via":"2","date_time":"2018-05-30 09:05:55","transaction_type":"Debit","narration":"Ride is Completed Successfully","added_by":"Rajat ."},{"trans_id":"10","driver_id":"1","payment_method":"Cash","receipt_number":"","total_amount":"0.00","description":"","order_via":"2","date_time":"2018-05-30 08:51:44","transaction_type":"Debit","narration":"Ride is Completed Successfully","added_by":"Rajat ."},{"trans_id":"9","driver_id":"1","payment_method":"Cash","receipt_number":"","total_amount":"0.00","description":"","order_via":"2","date_time":"2018-05-30 08:12:43","transaction_type":"Debit","narration":"Ride is Completed Successfully","added_by":"Rajat ."},{"trans_id":"8","driver_id":"1","payment_method":"Cash","receipt_number":"","total_amount":"0.00","description":"","order_via":"2","date_time":"2018-05-30 08:09:12","transaction_type":"Debit","narration":"Ride is Completed Successfully","added_by":"Rajat ."},{"trans_id":"7","driver_id":"1","payment_method":"Cash","receipt_number":"","total_amount":"0.00","description":"","order_via":"2","date_time":"2018-05-30 08:04:49","transaction_type":"Debit","narration":"Ride is Completed Successfully","added_by":"Rajat ."},{"trans_id":"6","driver_id":"1","payment_method":"Cash","receipt_number":"","total_amount":"0.00","description":"","order_via":"2","date_time":"2018-05-30 07:44:05","transaction_type":"Debit","narration":"Ride is Completed Successfully","added_by":"Rajat ."},{"trans_id":"5","driver_id":"1","payment_method":"Cash","receipt_number":"","total_amount":"0.00","description":"","order_via":"2","date_time":"2018-05-30 07:42:27","transaction_type":"Debit","narration":"Ride is Completed Successfully","added_by":"Rajat ."},{"trans_id":"4","driver_id":"1","payment_method":"Cash","receipt_number":"","total_amount":"0.00","description":"","order_via":"2","date_time":"2018-05-30 07:29:43","transaction_type":"Debit","narration":"Ride is Completed Successfully","added_by":"Rajat ."},{"trans_id":"3","driver_id":"1","payment_method":"Cash","receipt_number":"543","total_amount":"400","description":"tesfd","order_via":"1","date_time":"2018-05-28 16:28:11","transaction_type":"Credit","narration":"Wallet recharged by admin","added_by":"Apporio"},{"trans_id":"2","driver_id":"1","payment_method":"Cash","receipt_number":"3243","total_amount":"500","description":"test","order_via":"1","date_time":"2018-05-28 16:27:27","transaction_type":"Credit","narration":"Wallet recharged by admin","added_by":"Apporio"},{"trans_id":"1","driver_id":"1","payment_method":"Cash","receipt_number":"3243","total_amount":"500","description":"tedsf","order_via":"1","date_time":"2018-05-28 12:53:48","transaction_type":"Credit","narration":"Wallet recharged by admin","added_by":"Apporio"}]
     */

    private int result;
    private String message;
    private String wallet_balance;
    private String low_alert_balance_status;
    private List<TransactionsBean> transactions;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getWallet_balance() {
        return wallet_balance;
    }

    public void setWallet_balance(String wallet_balance) {
        this.wallet_balance = wallet_balance;
    }

    public String getLow_alert_balance_status() {
        return low_alert_balance_status;
    }

    public void setLow_alert_balance_status(String low_alert_balance_status) {
        this.low_alert_balance_status = low_alert_balance_status;
    }

    public List<TransactionsBean> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionsBean> transactions) {
        this.transactions = transactions;
    }

    public static class TransactionsBean {
        /**
         * trans_id : 12
         * driver_id : 1
         * payment_method : Cash
         * receipt_number :
         * total_amount : 0.00
         * description :
         * order_via : 2
         * date_time : 2018-05-30 09:07:36
         * transaction_type : Debit
         * narration : Ride is Completed Successfully
         * added_by : Rajat .
         */

        private String trans_id;
        private String driver_id;
        private String payment_method;
        private String receipt_number;
        private String total_amount;
        private String description;
        private String order_via;
        private String date_time;
        private String transaction_type;
        private String narration;
        private String added_by;

        public String getTrans_id() {
            return trans_id;
        }

        public void setTrans_id(String trans_id) {
            this.trans_id = trans_id;
        }

        public String getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(String driver_id) {
            this.driver_id = driver_id;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public String getReceipt_number() {
            return receipt_number;
        }

        public void setReceipt_number(String receipt_number) {
            this.receipt_number = receipt_number;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getOrder_via() {
            return order_via;
        }

        public void setOrder_via(String order_via) {
            this.order_via = order_via;
        }

        public String getDate_time() {
            return date_time;
        }

        public void setDate_time(String date_time) {
            this.date_time = date_time;
        }

        public String getTransaction_type() {
            return transaction_type;
        }

        public void setTransaction_type(String transaction_type) {
            this.transaction_type = transaction_type;
        }

        public String getNarration() {
            return narration;
        }

        public void setNarration(String narration) {
            this.narration = narration;
        }

        public String getAdded_by() {
            return added_by;
        }

        public void setAdded_by(String added_by) {
            this.added_by = added_by;
        }
    }
}
