package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class SampleFare {


    /**
     * result : 1
     * message : Booking Recipt Screen
     * data : {"holder_ride_info":{"circular_image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle/1566803985_5d63881133ffb_vehicle.png","circular_image_visibility":true,"circular_text":"SEDAN","circular_text_one":"Service Type:- Normal","circular_text_style":"","circular_text_color":"333333","circular_text_visibility":true,"value_text":"INR 79","value_text_style":"BOLD","value_text_color":"2ecc71","value_text_visibility":true,"left_text":"0 Km","left_text_style":"BOLD","left_text_color":"333333","left_text_visibility":true,"right_text":"00 H 09 M","right_text_style":"BOLD","right_text_color":"333333","right_text_visibility":true,"pick_locaion":"IRIS Tech Park, Sector 49, Gurugram, Haryana 122018, India","pick_location_visibility":true,"drop_location":"IRIS Tech Park, Sector 49, Gurugram, Haryana 122018, India","drop_location_visibility":true,"static_values":[{"highlighted_text":"Bill Details","highlighted_text_color":"333333","highlighted_style":"BOLD","highlighted_visibility":true,"small_text":"eee","small_text_color":"333333","small_text_style":"","small_text_visibility":false,"value_text":"Bill Details","value_text_color":"333333","value_text_style":"","value_textvisibility":false},{"highlighted_text":"Base Fare","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 40.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Distance Charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Waiting Time charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Ride Time charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Pickup Charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Surge-Charge","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 15.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Peak Time","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 20.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"GST(5 %)\n","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 3.75","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Round Off","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.25","value_text_color":"333333","value_text_style":"","value_textvisibility":true}]},"holder_input_info":{"headline_major":"This Is dynamic Bill","headline_major_style":"BOLD","headline_major_color":"333333","headline_major_visibility":false,"headline_small_text":"Miximum Bill Amount Not Greater Then","headline_small_text_style":"","headline_small_text_color":"bbbbbb","headline_small_text_visibility":false,"fields":[]},"bottom_button":{"visibility":false,"text":"Rate User and Complete Ride","text_back_ground_Color":"e67e22","action":"RATE_USER"},"payment_holder":{"heading":"Payment Pending","text":"Payment Pending","amount":"79"},"holder_driver_ride_payment":{"message":"ap.have_you_received_cash","message_color":"#000000","button_text":"api.yes_button"}}
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
         * holder_ride_info : {"circular_image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle/1566803985_5d63881133ffb_vehicle.png","circular_image_visibility":true,"circular_text":"SEDAN","circular_text_one":"Service Type:- Normal","circular_text_style":"","circular_text_color":"333333","circular_text_visibility":true,"value_text":"INR 79","value_text_style":"BOLD","value_text_color":"2ecc71","value_text_visibility":true,"left_text":"0 Km","left_text_style":"BOLD","left_text_color":"333333","left_text_visibility":true,"right_text":"00 H 09 M","right_text_style":"BOLD","right_text_color":"333333","right_text_visibility":true,"pick_locaion":"IRIS Tech Park, Sector 49, Gurugram, Haryana 122018, India","pick_location_visibility":true,"drop_location":"IRIS Tech Park, Sector 49, Gurugram, Haryana 122018, India","drop_location_visibility":true,"static_values":[{"highlighted_text":"Bill Details","highlighted_text_color":"333333","highlighted_style":"BOLD","highlighted_visibility":true,"small_text":"eee","small_text_color":"333333","small_text_style":"","small_text_visibility":false,"value_text":"Bill Details","value_text_color":"333333","value_text_style":"","value_textvisibility":false,"small_texot_clor":"333333"},{"highlighted_text":"Base Fare","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 40.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Distance Charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Waiting Time charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Ride Time charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Pickup Charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Surge-Charge","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 15.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Peak Time","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 20.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"GST(5 %)\n","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 3.75","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Round Off","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.25","value_text_color":"333333","value_text_style":"","value_textvisibility":true}]}
         * holder_input_info : {"headline_major":"This Is dynamic Bill","headline_major_style":"BOLD","headline_major_color":"333333","headline_major_visibility":false,"headline_small_text":"Miximum Bill Amount Not Greater Then","headline_small_text_style":"","headline_small_text_color":"bbbbbb","headline_small_text_visibility":false,"fields":[]}
         * bottom_button : {"visibility":false,"text":"Rate User and Complete Ride","text_back_ground_Color":"e67e22","action":"RATE_USER"}
         * payment_holder : {"heading":"Payment Pending","text":"Payment Pending","amount":"79"}
         * holder_driver_ride_payment : {"message":"ap.have_you_received_cash","message_color":"#000000","button_text":"api.yes_button"}
         */

        private HolderRideInfoBean holder_ride_info;
        private HolderInputInfoBean holder_input_info;
        private BottomButtonBean bottom_button;
        private PaymentHolderBean payment_holder;
        private HolderDriverRidePaymentBean holder_driver_ride_payment;

        public HolderRideInfoBean getHolder_ride_info() {
            return holder_ride_info;
        }

        public void setHolder_ride_info(HolderRideInfoBean holder_ride_info) {
            this.holder_ride_info = holder_ride_info;
        }

        public HolderInputInfoBean getHolder_input_info() {
            return holder_input_info;
        }

        public void setHolder_input_info(HolderInputInfoBean holder_input_info) {
            this.holder_input_info = holder_input_info;
        }

        public BottomButtonBean getBottom_button() {
            return bottom_button;
        }

        public void setBottom_button(BottomButtonBean bottom_button) {
            this.bottom_button = bottom_button;
        }

        public PaymentHolderBean getPayment_holder() {
            return payment_holder;
        }

        public void setPayment_holder(PaymentHolderBean payment_holder) {
            this.payment_holder = payment_holder;
        }

        public HolderDriverRidePaymentBean getHolder_driver_ride_payment() {
            return holder_driver_ride_payment;
        }

        public void setHolder_driver_ride_payment(HolderDriverRidePaymentBean holder_driver_ride_payment) {
            this.holder_driver_ride_payment = holder_driver_ride_payment;
        }

        public static class HolderRideInfoBean {
            /**
             * circular_image : https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/vehicle/1566803985_5d63881133ffb_vehicle.png
             * circular_image_visibility : true
             * circular_text : SEDAN
             * circular_text_one : Service Type:- Normal
             * circular_text_style :
             * circular_text_color : 333333
             * circular_text_visibility : true
             * value_text : INR 79
             * value_text_style : BOLD
             * value_text_color : 2ecc71
             * value_text_visibility : true
             * left_text : 0 Km
             * left_text_style : BOLD
             * left_text_color : 333333
             * left_text_visibility : true
             * right_text : 00 H 09 M
             * right_text_style : BOLD
             * right_text_color : 333333
             * right_text_visibility : true
             * pick_locaion : IRIS Tech Park, Sector 49, Gurugram, Haryana 122018, India
             * pick_location_visibility : true
             * drop_location : IRIS Tech Park, Sector 49, Gurugram, Haryana 122018, India
             * drop_location_visibility : true
             * static_values : [{"highlighted_text":"Bill Details","highlighted_text_color":"333333","highlighted_style":"BOLD","highlighted_visibility":true,"small_text":"eee","small_text_color":"333333","small_text_style":"","small_text_visibility":false,"value_text":"Bill Details","value_text_color":"333333","value_text_style":"","value_textvisibility":false},{"highlighted_text":"Base Fare","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 40.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Distance Charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Waiting Time charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Ride Time charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Pickup Charges","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Surge-Charge","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 15.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Peak Time","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 20.00","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"GST(5 %)\n","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 3.75","value_text_color":"333333","value_text_style":"","value_textvisibility":true},{"highlighted_text":"Round Off","highlighted_text_color":"333333","highlighted_style":"NORMAL","highlighted_visibility":true,"small_text":"eee","small_texot_clor":"333333","small_text_style":"","small_text_visibility":false,"value_text":"INR 0.25","value_text_color":"333333","value_text_style":"","value_textvisibility":true}]
             */

            private String circular_image;
            private boolean circular_image_visibility;
            private String circular_text;
            private String circular_text_one;
            private String circular_text_style;
            private String circular_text_color;
            private boolean circular_text_visibility;
            private String value_text;
            private String value_text_style;
            private String value_text_color;
            private boolean value_text_visibility;
            private String left_text;
            private String left_text_style;
            private String left_text_color;
            private boolean left_text_visibility;
            private String right_text;
            private String right_text_style;
            private String right_text_color;
            private boolean right_text_visibility;
            private String pick_locaion;
            private boolean pick_location_visibility;
            private String drop_location;
            private boolean drop_location_visibility;
            private List<StaticValuesBean> static_values;

            public String getCircular_image() {
                return circular_image;
            }

            public void setCircular_image(String circular_image) {
                this.circular_image = circular_image;
            }

            public boolean isCircular_image_visibility() {
                return circular_image_visibility;
            }

            public void setCircular_image_visibility(boolean circular_image_visibility) {
                this.circular_image_visibility = circular_image_visibility;
            }

            public String getCircular_text() {
                return circular_text;
            }

            public void setCircular_text(String circular_text) {
                this.circular_text = circular_text;
            }

            public String getCircular_text_one() {
                return circular_text_one;
            }

            public void setCircular_text_one(String circular_text_one) {
                this.circular_text_one = circular_text_one;
            }

            public String getCircular_text_style() {
                return circular_text_style;
            }

            public void setCircular_text_style(String circular_text_style) {
                this.circular_text_style = circular_text_style;
            }

            public String getCircular_text_color() {
                return circular_text_color;
            }

            public void setCircular_text_color(String circular_text_color) {
                this.circular_text_color = circular_text_color;
            }

            public boolean isCircular_text_visibility() {
                return circular_text_visibility;
            }

            public void setCircular_text_visibility(boolean circular_text_visibility) {
                this.circular_text_visibility = circular_text_visibility;
            }

            public String getValue_text() {
                return value_text;
            }

            public void setValue_text(String value_text) {
                this.value_text = value_text;
            }

            public String getValue_text_style() {
                return value_text_style;
            }

            public void setValue_text_style(String value_text_style) {
                this.value_text_style = value_text_style;
            }

            public String getValue_text_color() {
                return value_text_color;
            }

            public void setValue_text_color(String value_text_color) {
                this.value_text_color = value_text_color;
            }

            public boolean isValue_text_visibility() {
                return value_text_visibility;
            }

            public void setValue_text_visibility(boolean value_text_visibility) {
                this.value_text_visibility = value_text_visibility;
            }

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

            public String getPick_locaion() {
                return pick_locaion;
            }

            public void setPick_locaion(String pick_locaion) {
                this.pick_locaion = pick_locaion;
            }

            public boolean isPick_location_visibility() {
                return pick_location_visibility;
            }

            public void setPick_location_visibility(boolean pick_location_visibility) {
                this.pick_location_visibility = pick_location_visibility;
            }

            public String getDrop_location() {
                return drop_location;
            }

            public void setDrop_location(String drop_location) {
                this.drop_location = drop_location;
            }

            public boolean isDrop_location_visibility() {
                return drop_location_visibility;
            }

            public void setDrop_location_visibility(boolean drop_location_visibility) {
                this.drop_location_visibility = drop_location_visibility;
            }

            public List<StaticValuesBean> getStatic_values() {
                return static_values;
            }

            public void setStatic_values(List<StaticValuesBean> static_values) {
                this.static_values = static_values;
            }

            public static class StaticValuesBean {
                /**
                 * highlighted_text : Bill Details
                 * highlighted_text_color : 333333
                 * highlighted_style : BOLD
                 * highlighted_visibility : true
                 * small_text : eee
                 * small_text_color : 333333
                 * small_text_style :
                 * small_text_visibility : false
                 * value_text : Bill Details
                 * value_text_color : 333333
                 * value_text_style :
                 * value_textvisibility : false
                 * small_texot_clor : 333333
                 */

                private String highlighted_text;
                private String highlighted_text_color;
                private String highlighted_style;
                private boolean highlighted_visibility;
                private String small_text;
                private String small_text_color;
                private String small_text_style;
                private boolean small_text_visibility;
                private String value_text;
                private String value_text_color;
                private String value_text_style;
                private boolean value_textvisibility;
                private String small_texot_clor;

                public String getHighlighted_text() {
                    return highlighted_text;
                }

                public void setHighlighted_text(String highlighted_text) {
                    this.highlighted_text = highlighted_text;
                }

                public String getHighlighted_text_color() {
                    return highlighted_text_color;
                }

                public void setHighlighted_text_color(String highlighted_text_color) {
                    this.highlighted_text_color = highlighted_text_color;
                }

                public String getHighlighted_style() {
                    return highlighted_style;
                }

                public void setHighlighted_style(String highlighted_style) {
                    this.highlighted_style = highlighted_style;
                }

                public boolean isHighlighted_visibility() {
                    return highlighted_visibility;
                }

                public void setHighlighted_visibility(boolean highlighted_visibility) {
                    this.highlighted_visibility = highlighted_visibility;
                }

                public String getSmall_text() {
                    return small_text;
                }

                public void setSmall_text(String small_text) {
                    this.small_text = small_text;
                }

                public String getSmall_text_color() {
                    return small_text_color;
                }

                public void setSmall_text_color(String small_text_color) {
                    this.small_text_color = small_text_color;
                }

                public String getSmall_text_style() {
                    return small_text_style;
                }

                public void setSmall_text_style(String small_text_style) {
                    this.small_text_style = small_text_style;
                }

                public boolean isSmall_text_visibility() {
                    return small_text_visibility;
                }

                public void setSmall_text_visibility(boolean small_text_visibility) {
                    this.small_text_visibility = small_text_visibility;
                }

                public String getValue_text() {
                    return value_text;
                }

                public void setValue_text(String value_text) {
                    this.value_text = value_text;
                }

                public String getValue_text_color() {
                    return value_text_color;
                }

                public void setValue_text_color(String value_text_color) {
                    this.value_text_color = value_text_color;
                }

                public String getValue_text_style() {
                    return value_text_style;
                }

                public void setValue_text_style(String value_text_style) {
                    this.value_text_style = value_text_style;
                }

                public boolean isValue_textvisibility() {
                    return value_textvisibility;
                }

                public void setValue_textvisibility(boolean value_textvisibility) {
                    this.value_textvisibility = value_textvisibility;
                }

                public String getSmall_texot_clor() {
                    return small_texot_clor;
                }

                public void setSmall_texot_clor(String small_texot_clor) {
                    this.small_texot_clor = small_texot_clor;
                }
            }
        }

        public static class HolderInputInfoBean {
            /**
             * headline_major : This Is dynamic Bill
             * headline_major_style : BOLD
             * headline_major_color : 333333
             * headline_major_visibility : false
             * headline_small_text : Miximum Bill Amount Not Greater Then
             * headline_small_text_style :
             * headline_small_text_color : bbbbbb
             * headline_small_text_visibility : false
             * fields : []
             */

            private String headline_major;
            private String headline_major_style;
            private String headline_major_color;
            private boolean headline_major_visibility;
            private String headline_small_text;
            private String headline_small_text_style;
            private String headline_small_text_color;
            private boolean headline_small_text_visibility;
            private List<?> fields;

            public String getHeadline_major() {
                return headline_major;
            }

            public void setHeadline_major(String headline_major) {
                this.headline_major = headline_major;
            }

            public String getHeadline_major_style() {
                return headline_major_style;
            }

            public void setHeadline_major_style(String headline_major_style) {
                this.headline_major_style = headline_major_style;
            }

            public String getHeadline_major_color() {
                return headline_major_color;
            }

            public void setHeadline_major_color(String headline_major_color) {
                this.headline_major_color = headline_major_color;
            }

            public boolean isHeadline_major_visibility() {
                return headline_major_visibility;
            }

            public void setHeadline_major_visibility(boolean headline_major_visibility) {
                this.headline_major_visibility = headline_major_visibility;
            }

            public String getHeadline_small_text() {
                return headline_small_text;
            }

            public void setHeadline_small_text(String headline_small_text) {
                this.headline_small_text = headline_small_text;
            }

            public String getHeadline_small_text_style() {
                return headline_small_text_style;
            }

            public void setHeadline_small_text_style(String headline_small_text_style) {
                this.headline_small_text_style = headline_small_text_style;
            }

            public String getHeadline_small_text_color() {
                return headline_small_text_color;
            }

            public void setHeadline_small_text_color(String headline_small_text_color) {
                this.headline_small_text_color = headline_small_text_color;
            }

            public boolean isHeadline_small_text_visibility() {
                return headline_small_text_visibility;
            }

            public void setHeadline_small_text_visibility(boolean headline_small_text_visibility) {
                this.headline_small_text_visibility = headline_small_text_visibility;
            }

            public List<?> getFields() {
                return fields;
            }

            public void setFields(List<?> fields) {
                this.fields = fields;
            }
        }

        public static class BottomButtonBean {
            /**
             * visibility : false
             * text : Rate User and Complete Ride
             * text_back_ground_Color : e67e22
             * action : RATE_USER
             */

            private boolean visibility;
            private String text;
            private String text_back_ground_Color;
            private String action;

            public boolean isVisibility() {
                return visibility;
            }

            public void setVisibility(boolean visibility) {
                this.visibility = visibility;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getText_back_ground_Color() {
                return text_back_ground_Color;
            }

            public void setText_back_ground_Color(String text_back_ground_Color) {
                this.text_back_ground_Color = text_back_ground_Color;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }
        }

        public static class PaymentHolderBean {
            /**
             * heading : Payment Pending
             * text : Payment Pending
             * amount : 79
             */

            private String heading;
            private String text;
            private String amount;

            public String getHeading() {
                return heading;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }
        }

        public static class HolderDriverRidePaymentBean {
            /**
             * message : ap.have_you_received_cash
             * message_color : #000000
             * button_text : api.yes_button
             */

            private String message;
            private String message_color;
            private String button_text;

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getMessage_color() {
                return message_color;
            }

            public void setMessage_color(String message_color) {
                this.message_color = message_color;
            }

            public String getButton_text() {
                return button_text;
            }

            public void setButton_text(String button_text) {
                this.button_text = button_text;
            }
        }
    }
}
