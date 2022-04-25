package com.apporio.demotaxiappdriver.activities.vehicleModule;

public interface VehicleInterface {
    void newVehicle(String city_id, String driver_id, String phone_no);
    void existingVehicle(String city_id, String driver_id);
}
