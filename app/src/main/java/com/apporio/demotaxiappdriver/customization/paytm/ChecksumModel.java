package com.apporio.demotaxiappdriver.customization.paytm;

class ChecksumModel {

    private String result;
    private String id;
    private String paytmChecksum;
    private String order_id;
    private String merchantId;
    private String merchantKey;
    private int gatewayCondition;
    private String callbackURL;
    private String msg;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaytmChecksum() {
        return paytmChecksum;
    }

    public void setPaytmChecksum(String paytmChecksum) {
        this.paytmChecksum = paytmChecksum;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public int getGatewayCondition() {
        return gatewayCondition;
    }

    public void setGatewayCondition(int gatewayCondition) {
        this.gatewayCondition = gatewayCondition;
    }

    public String getCallbackURL() {
        return callbackURL;
    }

    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

