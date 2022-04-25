package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelSpecificTripDetails {

    private String result;
    private String message;
    private boolean bookable;
    private DataBeanXXXXXX data;

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

    public boolean isBookable() {
        return bookable;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    public DataBeanXXXXXX getData() {
        return data;
    }

    public void setData(DataBeanXXXXXX data) {
        this.data = data;
    }

    public static class DataBeanXXXXXX {
        private HolderMapImageBean holder_map_image;
        private HolderBookingDescriptionBean holder_booking_description;
        private HolderPickdropLocationBean holder_pickdrop_location;
        private HolderMeteringBean holder_metering;
        private HolderFamilyMemberBean holder_family_member;
        private HolderUserBean holder_user;
        private HolderReceiptBean holder_receipt;
        private ButtonVisibilityBean button_visibility;
        private CancelButtonVisibilityBean cancel_button_visibility;

        public CancelButtonVisibilityBean getCancel_button_visibility() {
            return cancel_button_visibility;
        }

        public void setCancel_button_visibility(CancelButtonVisibilityBean cancel_button_visibility) {
            this.cancel_button_visibility = cancel_button_visibility;
        }


        public HolderMapImageBean getHolder_map_image() {
            return holder_map_image;
        }

        public void setHolder_map_image(HolderMapImageBean holder_map_image) {
            this.holder_map_image = holder_map_image;
        }

        public HolderBookingDescriptionBean getHolder_booking_description() {
            return holder_booking_description;
        }

        public HolderFamilyMemberBean getHolder_family_member() {
            return holder_family_member;
        }

        public void setHolder_family_member(HolderFamilyMemberBean holder_family_member) {
            this.holder_family_member = holder_family_member;
        }

        public void setHolder_booking_description(HolderBookingDescriptionBean holder_booking_description) {
            this.holder_booking_description = holder_booking_description;
        }

        public HolderPickdropLocationBean getHolder_pickdrop_location() {
            return holder_pickdrop_location;
        }

        public void setHolder_pickdrop_location(HolderPickdropLocationBean holder_pickdrop_location) {
            this.holder_pickdrop_location = holder_pickdrop_location;
        }

        public HolderMeteringBean getHolder_metering() {
            return holder_metering;
        }

        public void setHolder_metering(HolderMeteringBean holder_metering) {
            this.holder_metering = holder_metering;
        }

        public HolderUserBean getHolder_user() {
            return holder_user;
        }

        public void setHolder_user(HolderUserBean holder_user) {
            this.holder_user = holder_user;
        }

        public HolderReceiptBean getHolder_receipt() {
            return holder_receipt;
        }

        public void setHolder_receipt(HolderReceiptBean holder_receipt) {
            this.holder_receipt = holder_receipt;
        }

        public ButtonVisibilityBean getButton_visibility() {
            return button_visibility;
        }

        public void setButton_visibility(ButtonVisibilityBean button_visibility) {
            this.button_visibility = button_visibility;
        }

        public static class HolderMapImageBean {
            private boolean visibility;
            private DataBean data;

            public boolean isVisibility() {
                return visibility;
            }

            public void setVisibility(boolean visibility) {
                this.visibility = visibility;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean {
                private String map_image;

                public String getMap_image() {
                    return map_image;
                }

                public void setMap_image(String map_image) {
                    this.map_image = map_image;
                }
            }
        }

        public static class HolderFamilyMemberBean {
            /**
             * name : demo
             * phoneNumber : +912525252525
             * age : 8
             */

            private Boolean visibility;
            private String name;
            private String phoneNumber;
            private String age;

            public Boolean getVisibility() {
                return visibility;
            }

            public void setVisibility(Boolean visibility) {
                this.visibility = visibility;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }
        }

        public static class HolderBookingDescriptionBean {
            private boolean visibility;
            private DataBeanX data;

            public boolean isVisibility() {
                return visibility;
            }

            public void setVisibility(boolean visibility) {
                this.visibility = visibility;
            }

            public DataBeanX getData() {
                return data;
            }

            public void setData(DataBeanX data) {
                this.data = data;
            }

            public static class DataBeanX {
                private String highlighted_left_text;
                private String highlighted_left_text_style;
                private String highlighted_left_text_color;
                private String small_left_text;
                private String small_left_text_style;
                private String small_left_text_color;
                private String highlighted_right_text;
                private String highlighted_right_text_style;
                private String highlighted_right_text_color;
                private String small_right_text;
                private String small_right_text_style;
                private String small_right_text_color;

                public String getHighlighted_left_text() {
                    return highlighted_left_text;
                }

                public void setHighlighted_left_text(String highlighted_left_text) {
                    this.highlighted_left_text = highlighted_left_text;
                }

                public String getHighlighted_left_text_style() {
                    return highlighted_left_text_style;
                }

                public void setHighlighted_left_text_style(String highlighted_left_text_style) {
                    this.highlighted_left_text_style = highlighted_left_text_style;
                }

                public String getHighlighted_left_text_color() {
                    return highlighted_left_text_color;
                }

                public void setHighlighted_left_text_color(String highlighted_left_text_color) {
                    this.highlighted_left_text_color = highlighted_left_text_color;
                }

                public String getSmall_left_text() {
                    return small_left_text;
                }

                public void setSmall_left_text(String small_left_text) {
                    this.small_left_text = small_left_text;
                }

                public String getSmall_left_text_style() {
                    return small_left_text_style;
                }

                public void setSmall_left_text_style(String small_left_text_style) {
                    this.small_left_text_style = small_left_text_style;
                }

                public String getSmall_left_text_color() {
                    return small_left_text_color;
                }

                public void setSmall_left_text_color(String small_left_text_color) {
                    this.small_left_text_color = small_left_text_color;
                }

                public String getHighlighted_right_text() {
                    return highlighted_right_text;
                }

                public void setHighlighted_right_text(String highlighted_right_text) {
                    this.highlighted_right_text = highlighted_right_text;
                }

                public String getHighlighted_right_text_style() {
                    return highlighted_right_text_style;
                }

                public void setHighlighted_right_text_style(String highlighted_right_text_style) {
                    this.highlighted_right_text_style = highlighted_right_text_style;
                }

                public String getHighlighted_right_text_color() {
                    return highlighted_right_text_color;
                }

                public void setHighlighted_right_text_color(String highlighted_right_text_color) {
                    this.highlighted_right_text_color = highlighted_right_text_color;
                }

                public String getSmall_right_text() {
                    return small_right_text;
                }

                public void setSmall_right_text(String small_right_text) {
                    this.small_right_text = small_right_text;
                }

                public String getSmall_right_text_style() {
                    return small_right_text_style;
                }

                public void setSmall_right_text_style(String small_right_text_style) {
                    this.small_right_text_style = small_right_text_style;
                }

                public String getSmall_right_text_color() {
                    return small_right_text_color;
                }

                public void setSmall_right_text_color(String small_right_text_color) {
                    this.small_right_text_color = small_right_text_color;
                }
            }
        }

        public static class HolderPickdropLocationBean {
            private boolean visibility;
            private DataBeanXX data;

            public boolean isVisibility() {
                return visibility;
            }

            public void setVisibility(boolean visibility) {
                this.visibility = visibility;
            }

            public DataBeanXX getData() {
                return data;
            }

            public void setData(DataBeanXX data) {
                this.data = data;
            }

            public static class DataBeanXX {
                private boolean pick_text_visibility;
                private String pick_text;
                private boolean drop_text_visibility;
                private String drop_text;

                public boolean isPick_text_visibility() {
                    return pick_text_visibility;
                }

                public void setPick_text_visibility(boolean pick_text_visibility) {
                    this.pick_text_visibility = pick_text_visibility;
                }

                public String getPick_text() {
                    return pick_text;
                }

                public void setPick_text(String pick_text) {
                    this.pick_text = pick_text;
                }

                public boolean isDrop_text_visibility() {
                    return drop_text_visibility;
                }

                public void setDrop_text_visibility(boolean drop_text_visibility) {
                    this.drop_text_visibility = drop_text_visibility;
                }

                public String getDrop_text() {
                    return drop_text;
                }

                public void setDrop_text(String drop_text) {
                    this.drop_text = drop_text;
                }
            }
        }

        public static class HolderMeteringBean {
            private boolean visibility;
            private DataBeanXXX data;

            public boolean isVisibility() {
                return visibility;
            }

            public void setVisibility(boolean visibility) {
                this.visibility = visibility;
            }

            public DataBeanXXX getData() {
                return data;
            }

            public void setData(DataBeanXXX data) {
                this.data = data;
            }

            public static class DataBeanXXX {
                private String text_one;
                private String text_two;
                private String text_three;

                public String getText_one() {
                    return text_one;
                }

                public void setText_one(String text_one) {
                    this.text_one = text_one;
                }

                public String getText_two() {
                    return text_two;
                }

                public void setText_two(String text_two) {
                    this.text_two = text_two;
                }

                public String getText_three() {
                    return text_three;
                }

                public void setText_three(String text_three) {
                    this.text_three = text_three;
                }
            }
        }

        public static class HolderUserBean {
            private boolean visibility;
            private DataBeanXXXX data;

            public boolean isVisibility() {
                return visibility;
            }

            public void setVisibility(boolean visibility) {
                this.visibility = visibility;
            }

            public DataBeanXXXX getData() {
                return data;
            }

            public void setData(DataBeanXXXX data) {
                this.data = data;
            }

            public static class DataBeanXXXX {
                private String circular_image;
                private String highlighted_text;
                private String small_text;
                private boolean rating_visibility;
                private String rating;
                private boolean rating_button_visibility;
                private boolean rating_button_enable;
                private String rating_button_text;
                private String rating_button_text_color;
                private String rating_button_text_style;

                public String getCircular_image() {
                    return circular_image;
                }

                public void setCircular_image(String circular_image) {
                    this.circular_image = circular_image;
                }

                public String getHighlighted_text() {
                    return highlighted_text;
                }

                public void setHighlighted_text(String highlighted_text) {
                    this.highlighted_text = highlighted_text;
                }

                public String getSmall_text() {
                    return small_text;
                }

                public void setSmall_text(String small_text) {
                    this.small_text = small_text;
                }

                public boolean isRating_visibility() {
                    return rating_visibility;
                }

                public void setRating_visibility(boolean rating_visibility) {
                    this.rating_visibility = rating_visibility;
                }

                public String getRating() {
                    return rating;
                }

                public void setRating(String rating) {
                    this.rating = rating;
                }

                public boolean isRating_button_visibility() {
                    return rating_button_visibility;
                }

                public void setRating_button_visibility(boolean rating_button_visibility) {
                    this.rating_button_visibility = rating_button_visibility;
                }

                public boolean isRating_button_enable() {
                    return rating_button_enable;
                }

                public void setRating_button_enable(boolean rating_button_enable) {
                    this.rating_button_enable = rating_button_enable;
                }

                public String getRating_button_text() {
                    return rating_button_text;
                }

                public void setRating_button_text(String rating_button_text) {
                    this.rating_button_text = rating_button_text;
                }

                public String getRating_button_text_color() {
                    return rating_button_text_color;
                }

                public void setRating_button_text_color(String rating_button_text_color) {
                    this.rating_button_text_color = rating_button_text_color;
                }

                public String getRating_button_text_style() {
                    return rating_button_text_style;
                }

                public void setRating_button_text_style(String rating_button_text_style) {
                    this.rating_button_text_style = rating_button_text_style;
                }
            }
        }

        public static class HolderReceiptBean {
            private boolean visibility;
            private List<DataBeanXXXXX> data;

            public boolean isVisibility() {
                return visibility;
            }

            public void setVisibility(boolean visibility) {
                this.visibility = visibility;
            }

            public List<DataBeanXXXXX> getData() {
                return data;
            }

            public void setData(List<DataBeanXXXXX> data) {
                this.data = data;
            }

            public static class DataBeanXXXXX {
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
            }
        }

        public static class ButtonVisibilityBean {
            private boolean visibility;
            private String button_text;
            private String text_color;
            private String text_back_ground;
            private String action;

            public boolean isVisibility() {
                return visibility;
            }

            public void setVisibility(boolean visibility) {
                this.visibility = visibility;
            }

            public String getButton_text() {
                return button_text;
            }

            public void setButton_text(String button_text) {
                this.button_text = button_text;
            }

            public String getText_color() {
                return text_color;
            }

            public void setText_color(String text_color) {
                this.text_color = text_color;
            }

            public String getText_back_ground() {
                return text_back_ground;
            }

            public void setText_back_ground(String text_back_ground) {
                this.text_back_ground = text_back_ground;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }
        }


        public static class CancelButtonVisibilityBean {

            private boolean visibility;
            private String button_text;
            private String text_color;
            private String text_back_ground;
            private String action;



            public boolean isVisibility() {
                return visibility;
            }

            public void setVisibility(boolean visibility) {
                this.visibility = visibility;
            }

            public String getButton_text() {
                return button_text;
            }

            public void setButton_text(String button_text) {
                this.button_text = button_text;
            }

            public String getText_color() {
                return text_color;
            }

            public void setText_color(String text_color) {
                this.text_color = text_color;
            }

            public String getText_back_ground() {
                return text_back_ground;
            }

            public void setText_back_ground(String text_back_ground) {
                this.text_back_ground = text_back_ground;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }







        }

    }
}