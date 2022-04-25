package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelRideInfo {


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
        private int id;
        private String service_type_id;
        private String ploy_points;
        private String driver_id;
        private String booking_status;
        private String pickup_latitude;
        private String pickup_longitude;
        private boolean send_meter_image;
        private boolean send_meter_value;
        private boolean sos_visibility;
        private PolydataBean polydata;
        private StillMarkerBean still_marker;
        private MovableMarkerBean movable_marker;
        private LocationBean location;
        private boolean cancelable;
        private FamilyMemberDetailsBean family_member_details;
        private PaymentMethodBean payment_method;
        private UserBean user;
        private List<SosBean> sos;
        private List<CancelReasonsBean> cancel_reasons;
        private String ride_otp;

        public String getAdditional_notes() {
            return additional_notes;
        }

        public void setAdditional_notes(String additional_notes) {
            this.additional_notes = additional_notes;
        }

        private String ride_otp_verify;
        private String additional_notes;

        public String getRide_otp() {
            return ride_otp;
        }

        public void setRide_otp(String ride_otp) {
            this.ride_otp = ride_otp;
        }

        public String getRide_otp_verify() {
            return ride_otp_verify;
        }

        public void setRide_otp_verify(String ride_otp_verify) {
            this.ride_otp_verify = ride_otp_verify;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getService_type_id() {
            return service_type_id;
        }

        public void setService_type_id(String service_type_id) {
            this.service_type_id = service_type_id;
        }

        public String getPloy_points() {
            return ploy_points;
        }

        public void setPloy_points(String ploy_points) {
            this.ploy_points = ploy_points;
        }

        public String getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(String driver_id) {
            this.driver_id = driver_id;
        }

        public String getBooking_status() {
            return booking_status;
        }

        public void setBooking_status(String booking_status) {
            this.booking_status = booking_status;
        }

        public String getPickup_latitude() {
            return pickup_latitude;
        }

        public void setPickup_latitude(String pickup_latitude) {
            this.pickup_latitude = pickup_latitude;
        }

        public String getPickup_longitude() {
            return pickup_longitude;
        }

        public void setPickup_longitude(String pickup_longitude) {
            this.pickup_longitude = pickup_longitude;
        }

        public boolean isSend_meter_image() {
            return send_meter_image;
        }

        public void setSend_meter_image(boolean send_meter_image) {
            this.send_meter_image = send_meter_image;
        }

        public boolean isSend_meter_value() {
            return send_meter_value;
        }

        public void setSend_meter_value(boolean send_meter_value) {
            this.send_meter_value = send_meter_value;
        }

        public boolean isSos_visibility() {
            return sos_visibility;
        }

        public void setSos_visibility(boolean sos_visibility) {
            this.sos_visibility = sos_visibility;
        }

        public FamilyMemberDetailsBean getFamily_member_details() {
            return family_member_details;
        }

        public void setFamily_member_details(FamilyMemberDetailsBean family_member_details) {
            this.family_member_details = family_member_details;
        }


        public PolydataBean getPolydata() {
            return polydata;
        }

        public void setPolydata(PolydataBean polydata) {
            this.polydata = polydata;
        }

        public StillMarkerBean getStill_marker() {
            return still_marker;
        }

        public void setStill_marker(StillMarkerBean still_marker) {
            this.still_marker = still_marker;
        }

        public MovableMarkerBean getMovable_marker() {
            return movable_marker;
        }

        public void setMovable_marker(MovableMarkerBean movable_marker) {
            this.movable_marker = movable_marker;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public boolean isCancelable() {
            return cancelable;
        }

        public void setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
        }

        public PaymentMethodBean getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(PaymentMethodBean payment_method) {
            this.payment_method = payment_method;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<SosBean> getSos() {
            return sos;
        }

        public void setSos(List<SosBean> sos) {
            this.sos = sos;
        }

        public List<CancelReasonsBean> getCancel_reasons() {
            return cancel_reasons;
        }

        public void setCancel_reasons(List<CancelReasonsBean> cancel_reasons) {
            this.cancel_reasons = cancel_reasons;
        }

        public static class PolydataBean {
            private String polyline_width;
            private String polyline_color;
            private String polyline;

            public String getPolyline_width() {
                return polyline_width;
            }

            public void setPolyline_width(String polyline_width) {
                this.polyline_width = polyline_width;
            }

            public String getPolyline_color() {
                return polyline_color;
            }

            public void setPolyline_color(String polyline_color) {
                this.polyline_color = polyline_color;
            }

            public String getPolyline() {
                return polyline;
            }

            public void setPolyline(String polyline) {
                this.polyline = polyline;
            }
        }

        public static class StillMarkerBean {
            private String marker_type;
            private String marker_lat;
            private String marker_long;

            public String getMarker_type() {
                return marker_type;
            }

            public void setMarker_type(String marker_type) {
                this.marker_type = marker_type;
            }

            public String getMarker_lat() {
                return marker_lat;
            }

            public void setMarker_lat(String marker_lat) {
                this.marker_lat = marker_lat;
            }

            public String getMarker_long() {
                return marker_long;
            }

            public void setMarker_long(String marker_long) {
                this.marker_long = marker_long;
            }
        }

        public static class MovableMarkerBean {

            private String driver_marker_name;
            private String driver_marker_type;

            public String getDriver_marker_name() {
                return driver_marker_name;
            }

            public void setDriver_marker_name(String driver_marker_name) {
                this.driver_marker_name = driver_marker_name;
            }

            private String driver_marker_lat;
            private String driver_marker_long;
            private String driver_marker_bearing;

            public String getDriver_marker_type() {
                return driver_marker_type;
            }

            public void setDriver_marker_type(String driver_marker_type) {
                this.driver_marker_type = driver_marker_type;
            }

            public String getDriver_marker_lat() {
                return driver_marker_lat;
            }

            public void setDriver_marker_lat(String driver_marker_lat) {
                this.driver_marker_lat = driver_marker_lat;
            }

            public String getDriver_marker_long() {
                return driver_marker_long;
            }

            public void setDriver_marker_long(String driver_marker_long) {
                this.driver_marker_long = driver_marker_long;
            }

            public String getDriver_marker_bearing() {
                return driver_marker_bearing;
            }

            public void setDriver_marker_bearing(String driver_marker_bearing) {
                this.driver_marker_bearing = driver_marker_bearing;
            }
        }

        public static class LocationBean {
            private boolean location_action;
            private String trip_status_text;
            private String location_headline;
            private String location_text;
            private String location_color;
            private boolean location_editable;
            private String location_message;

            public String getLocation_message() {
                return location_message;
            }

            public void setLocation_message(String location_message) {
                this.location_message = location_message;
            }

            public boolean isLocation_action() {
                return location_action;
            }

            public void setLocation_action(boolean location_action) {
                this.location_action = location_action;
            }

            public String getTrip_status_text() {
                return trip_status_text;
            }

            public void setTrip_status_text(String trip_status_text) {
                this.trip_status_text = trip_status_text;
            }

            public String getLocation_headline() {
                return location_headline;
            }

            public void setLocation_headline(String location_headline) {
                this.location_headline = location_headline;
            }

            public String getLocation_text() {
                return location_text;
            }

            public void setLocation_text(String location_text) {
                this.location_text = location_text;
            }

            public String getLocation_color() {
                return location_color;
            }

            public void setLocation_color(String location_color) {
                this.location_color = location_color;
            }

            public boolean isLocation_editable() {
                return location_editable;
            }

            public void setLocation_editable(boolean location_editable) {
                this.location_editable = location_editable;
            }
        }

        public static class FamilyMemberDetailsBean {
            /**
             * family_visibility : true
             * family_member_name : hnhb
             * family_member_phoneNumber : +916928282850
             * family_member_age : 23
             */

            private boolean family_visibility;
            private String family_member_name;
            private String family_member_phoneNumber;
            private String family_member_age;

            public boolean isFamily_visibility() {
                return family_visibility;
            }

            public void setFamily_visibility(boolean family_visibility) {
                this.family_visibility = family_visibility;
            }

            public String getFamily_member_name() {
                return family_member_name;
            }

            public void setFamily_member_name(String family_member_name) {
                this.family_member_name = family_member_name;
            }

            public String getFamily_member_phoneNumber() {
                return family_member_phoneNumber;
            }

            public void setFamily_member_phoneNumber(String family_member_phoneNumber) {
                this.family_member_phoneNumber = family_member_phoneNumber;
            }

            public String getFamily_member_age() {
                return family_member_age;
            }

            public void setFamily_member_age(String family_member_age) {
                this.family_member_age = family_member_age;
            }
        }


        public static class PaymentMethodBean {
            private int id;
            private String merchant_id;
            private String payment_method;
            private String payment_method_type;
            private String payment_method_status;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(String merchant_id) {
                this.merchant_id = merchant_id;
            }

            public String getPayment_method() {
                return payment_method;
            }

            public void setPayment_method(String payment_method) {
                this.payment_method = payment_method;
            }

            public String getPayment_method_type() {
                return payment_method_type;
            }

            public void setPayment_method_type(String payment_method_type) {
                this.payment_method_type = payment_method_type;
            }

            public String getPayment_method_status() {
                return payment_method_status;
            }

            public void setPayment_method_status(String payment_method_status) {
                this.payment_method_status = payment_method_status;
            }
        }

        public static class UserBean {
            private int id;
            private String UserName;
            private String UserPhone;
            private String email;
            private String rating;
            private Object UserProfileImage;
            private int ride_otp;

            public int getRide_otp() {
                return ride_otp;
            }

            public void setRide_otp(int ride_otp) {
                this.ride_otp = ride_otp;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getUserPhone() {
                return UserPhone;
            }

            public void setUserPhone(String UserPhone) {
                this.UserPhone = UserPhone;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }

            public Object getUserProfileImage() {
                return UserProfileImage;
            }

            public void setUserProfileImage(Object UserProfileImage) {
                this.UserProfileImage = UserProfileImage;
            }
        }

        public static class SosBean {
            private int id;
            private String merchant_id;
            private String number;
            private String sosStatus;
            private String created_at;
            private String updated_at;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(String merchant_id) {
                this.merchant_id = merchant_id;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getSosStatus() {
                return sosStatus;
            }

            public void setSosStatus(String sosStatus) {
                this.sosStatus = sosStatus;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class CancelReasonsBean {
            private int id;
            private String reason;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }
        }
    }
}