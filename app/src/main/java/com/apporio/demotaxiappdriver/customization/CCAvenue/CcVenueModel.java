package com.apporio.demotaxiappdriver.customization.CCAvenue;

public class CcVenueModel {


    /**
     * result : 1
     * Rsakey : MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk9T91noiifCDvrp0kEpbHHZY95bYUDtd
     g4BUE1zpmg2euIeC86mJF5kjGkwqEeIiUOA89UV0FOVT8e/uV4EXSiMxS4hevK3hBxkQ3LUrvvpE
     FP3GXbpSY+AStgrD8X+HoXQ4gVMkbmNKcvkomxw9ox04TjZBYg469fFPywbatIXNEIAxs474yBF0
     NACY2mNuqqdCCb5wZuBy0EGC4sjFc4LyU4oklS2o7dAr+wXzGPmn41OFjYTcwQVzcispZ/q6R+v7
     gKgqD0vSXlKgvZec02VlIq9rj2PegtYZK0Az4Daema6j0u4C/MGg7Zdr8pklGz7AUsFC3/lDBOjR
     1coT0QIDAQAB
     * cancel_url : http://myautto.com/public/api/redirect-from-ccavenue
     * return_url : http://myautto.com/public/api/redirect-from-ccavenue
     */

    private String result;
    private String Rsakey;
    private String cancel_url;
    private String return_url;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRsakey() {
        return Rsakey;
    }

    public void setRsakey(String Rsakey) {
        this.Rsakey = Rsakey;
    }

    public String getCancel_url() {
        return cancel_url;
    }

    public void setCancel_url(String cancel_url) {
        this.cancel_url = cancel_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }
}
