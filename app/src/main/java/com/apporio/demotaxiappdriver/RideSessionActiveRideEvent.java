package com.apporio.demotaxiappdriver;

/**
 * Created by Lenovo on 2/26/2018.
 */

public class RideSessionActiveRideEvent {
    public String ride_status;
    public String ride_id;

    public RideSessionActiveRideEvent(String ride_status, String ride_id ) {
        this.ride_status = ride_status ;
        this.ride_id = ride_id ;
    }

    public String getRide_status() {
        return ride_status;
    }

    public void setRide_status(String ride_status) {
        this.ride_status = ride_status;
    }

}
