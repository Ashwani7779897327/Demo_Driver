package com.apporio.atslocation.db;

import android.util.Log;

public class OfflineDataTable {



    int _id;
    double _latitude;
    double _longitude;
    double _accuracy;
    float _bearing;
    float _speed;
    String _battery;
    String _devicetime;
    String _ischarging;


    public OfflineDataTable(){   }
    public OfflineDataTable(int id,  double _latitude, double _longitude, double _accuracy, float _bearing, float _speed, String _battery, String _devicetime, String _ischarging){
        this._id = id;
        this._latitude = _latitude;
        this._longitude = _longitude;
        this._accuracy = _accuracy;
        this._bearing = _bearing;
        this._speed = _speed;
        this._battery = _battery ;
        this._devicetime = _devicetime ;
        this._ischarging = _ischarging ;
    }

    public OfflineDataTable(double _latitude, double _longitude, double _accuracy, float _bearing, float _speed, String _battery, String _devicetime, String _ischarging){

        this._latitude = _latitude;
        this._longitude = _longitude;
        this._accuracy = _accuracy;
        this._bearing = _bearing;
        this._speed = _speed;
        this._battery = _battery ;
        this._devicetime = _devicetime ;
        this._ischarging = _ischarging ;
    }

    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public double get_latitude() {
        return this._latitude;
    }

    public void set_latitude(double _latitude) {
        this._latitude = _latitude;
    }

    public double get_longitude() {
        return this._longitude;
    }

    public void set_longitude(double _longitude) {
        this._longitude = _longitude;
    }

    public double get_accuracy() {
        return this._accuracy;
    }

    public void set_accuracy(double _accuracy) {
        this._accuracy = _accuracy;
    }

    public float get_bearing() {
        return this._bearing;
    }

    public void set_bearing(float _bearing) {
        this._bearing = _bearing;
    }

    public float get_speed() {
        return this._speed;
    }

    public void set_speed(float _speed) {
        this._speed = _speed;
    }

    public String get_battery() {
        return this._battery;
    }

    public void set_battery(String _battery) {
        this._battery = _battery;
    }


    public String get_devicetime() {
        return this._devicetime;
    }

    public void set_devicetime(String devicetime) {
        this._devicetime = devicetime;
    }

    public String get_ischarging() {
        return this._ischarging;
    }

    public void set_ischarging(String _ischarging) {
        this._ischarging = _ischarging;
    }


}