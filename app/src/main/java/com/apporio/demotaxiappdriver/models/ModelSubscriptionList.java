package com.apporio.demotaxiappdriver.models;

import java.io.Serializable;
import java.util.List;

public class ModelSubscriptionList implements Serializable {


    /**
     * result : 1
     * message : Driver
     * activated_pack : true
     * active_pack_detail : [{"subscription_pack_id":6,"payment_method_id":3,"package_duration_id":2,"package_total_trips":25,"price":"1000.00","used_trips":0,"start_date_time":"2019-10-16 15:42:46","end_date_time":"2019-10-18 15:42:46","status":2,"package_type":2,"name":"Test2day","description":"abc","show_price":"INR 1000.00","active":true,"rides_left":25,"package_duration_name":"two day","image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png","service_type":[{"id":1,"serviceName":"Normal","colour":"","icon":""},{"id":2,"serviceName":"Rental","colour":"","icon":""},{"id":4,"serviceName":"Outstation","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png"},{"id":5,"serviceName":"Pool","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/icons/1567072281_5d67a019419ff_icon.png"}],"subscription_package":{"id":6,"merchant_id":1,"package_duration_id":2,"max_trip":25,"image":null,"price":"1000.00","status":1,"package_type":2,"expire_date":"2019-10-17","admin_delete":0,"created_at":"2019-10-11 13:09:13","updated_at":"2019-10-16 07:00:09","deleted_at":null,"service_type":[{"id":1,"serviceName":"Normal","colour":"","icon":""},{"id":2,"serviceName":"Rental","colour":"","icon":""},{"id":4,"serviceName":"Outstation","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png"},{"id":5,"serviceName":"Pool","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/icons/1567072281_5d67a019419ff_icon.png"}]},"package_duration":{"id":2,"merchant_id":1,"status":1,"sequence":2,"created_at":"2019-10-05 12:35:45","updated_at":"2019-10-05 12:35:45","deleted_at":null}}]
     * data : [{"id":5,"max_trip":40,"image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png","price":"1500.00","package_type":2,"merchant_id":1,"expire_date":"2019-10-17","name":"TEST3Day","description":"abc","show_price":"INR 1500.00","package_duration_name":"Three day","service_type":[{"id":1,"serviceName":"Normal","colour":"","icon":""},{"id":2,"serviceName":"Rental","colour":"","icon":""},{"id":4,"serviceName":"Outstation","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png"},{"id":5,"serviceName":"Pool","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/icons/1567072281_5d67a019419ff_icon.png"}]},{"id":6,"max_trip":25,"image":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png","price":"1000.00","package_type":2,"merchant_id":1,"expire_date":"2019-10-17","name":"Test2day","description":"abc","show_price":"INR 1000.00","package_duration_name":"two day","service_type":[{"id":1,"serviceName":"Normal","colour":"","icon":""},{"id":2,"serviceName":"Rental","colour":"","icon":""},{"id":4,"serviceName":"Outstation","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png"},{"id":5,"serviceName":"Pool","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/icons/1567072281_5d67a019419ff_icon.png"}]}]
     * payment_method : [{"id":2,"payment_method":"Credit Card\\ Debit Card","payment_icon":"GimZ5LMX8XQ7VEbn16xH4X8rHw3pZt9XP4CLJ7lq.png"},{"id":3,"payment_method":"Wallet","payment_icon":"DnHascb4YjCZa5yMb5FbX4zAzGYn4hQibu61LVTj.png"},{"id":4,"payment_method":"Online Payment","payment_icon":"yjd4mqMYzgDbwJK58izkmXrMt1SDJ5SkyxXPMhFe.png"},{"id":5,"payment_method":"Swipe card","payment_icon":"yjd4mqMYzgDbwJK58izkmXrMt1SDJ5SkyxXPMhFe.png"}]
     */

    private String result;
    private String message;
    private boolean activated_pack;
    private List<ActivePackDetailBean> active_pack_detail;
    private List<DataBean> data;
    private List<PaymentMethodBean> payment_method;

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

    public boolean isActivated_pack() {
        return activated_pack;
    }

    public void setActivated_pack(boolean activated_pack) {
        this.activated_pack = activated_pack;
    }

    public List<ActivePackDetailBean> getActive_pack_detail() {
        return active_pack_detail;
    }

    public void setActive_pack_detail(List<ActivePackDetailBean> active_pack_detail) {
        this.active_pack_detail = active_pack_detail;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<PaymentMethodBean> getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(List<PaymentMethodBean> payment_method) {
        this.payment_method = payment_method;
    }

    public static class ActivePackDetailBean implements Serializable {
        /**
         * subscription_pack_id : 6
         * payment_method_id : 3
         * package_duration_id : 2
         * package_total_trips : 25
         * price : 1000.00
         * used_trips : 0
         * start_date_time : 2019-10-16 15:42:46
         * end_date_time : 2019-10-18 15:42:46
         * status : 2
         * package_type : 2
         * name : Test2day
         * description : abc
         * show_price : INR 1000.00
         * active : true
         * rides_left : 25
         * package_duration_name : two day
         * image : https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png
         * service_type : [{"id":1,"serviceName":"Normal","colour":"","icon":""},{"id":2,"serviceName":"Rental","colour":"","icon":""},{"id":4,"serviceName":"Outstation","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png"},{"id":5,"serviceName":"Pool","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/icons/1567072281_5d67a019419ff_icon.png"}]
         * subscription_package : {"id":6,"merchant_id":1,"package_duration_id":2,"max_trip":25,"image":null,"price":"1000.00","status":1,"package_type":2,"expire_date":"2019-10-17","admin_delete":0,"created_at":"2019-10-11 13:09:13","updated_at":"2019-10-16 07:00:09","deleted_at":null,"service_type":[{"id":1,"serviceName":"Normal","colour":"","icon":""},{"id":2,"serviceName":"Rental","colour":"","icon":""},{"id":4,"serviceName":"Outstation","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png"},{"id":5,"serviceName":"Pool","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/icons/1567072281_5d67a019419ff_icon.png"}]}
         * package_duration : {"id":2,"merchant_id":1,"status":1,"sequence":2,"created_at":"2019-10-05 12:35:45","updated_at":"2019-10-05 12:35:45","deleted_at":null}
         */

        private int subscription_pack_id;
        private int payment_method_id;
        private int package_duration_id;
        private int package_total_trips;
        private String price;
        private int used_trips;
        private String start_date_time;
        private String end_date_time;
        private int status;
        private int package_type;
        private String name;
        private String description;
        private String show_price;
        private boolean active;
        private int rides_left;
        private String package_duration_name;
        private String image;
        private SubscriptionPackageBean subscription_package;
        private PackageDurationBean package_duration;
        private List<ServiceTypeBeanX> service_type;

        public int getSubscription_pack_id() {
            return subscription_pack_id;
        }

        public void setSubscription_pack_id(int subscription_pack_id) {
            this.subscription_pack_id = subscription_pack_id;
        }

        public int getPayment_method_id() {
            return payment_method_id;
        }

        public void setPayment_method_id(int payment_method_id) {
            this.payment_method_id = payment_method_id;
        }

        public int getPackage_duration_id() {
            return package_duration_id;
        }

        public void setPackage_duration_id(int package_duration_id) {
            this.package_duration_id = package_duration_id;
        }

        public int getPackage_total_trips() {
            return package_total_trips;
        }

        public void setPackage_total_trips(int package_total_trips) {
            this.package_total_trips = package_total_trips;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getUsed_trips() {
            return used_trips;
        }

        public void setUsed_trips(int used_trips) {
            this.used_trips = used_trips;
        }

        public String getStart_date_time() {
            return start_date_time;
        }

        public void setStart_date_time(String start_date_time) {
            this.start_date_time = start_date_time;
        }

        public String getEnd_date_time() {
            return end_date_time;
        }

        public void setEnd_date_time(String end_date_time) {
            this.end_date_time = end_date_time;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getPackage_type() {
            return package_type;
        }

        public void setPackage_type(int package_type) {
            this.package_type = package_type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getShow_price() {
            return show_price;
        }

        public void setShow_price(String show_price) {
            this.show_price = show_price;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public int getRides_left() {
            return rides_left;
        }

        public void setRides_left(int rides_left) {
            this.rides_left = rides_left;
        }

        public String getPackage_duration_name() {
            return package_duration_name;
        }

        public void setPackage_duration_name(String package_duration_name) {
            this.package_duration_name = package_duration_name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public SubscriptionPackageBean getSubscription_package() {
            return subscription_package;
        }

        public void setSubscription_package(SubscriptionPackageBean subscription_package) {
            this.subscription_package = subscription_package;
        }

        public PackageDurationBean getPackage_duration() {
            return package_duration;
        }

        public void setPackage_duration(PackageDurationBean package_duration) {
            this.package_duration = package_duration;
        }

        public List<ServiceTypeBeanX> getService_type() {
            return service_type;
        }

        public void setService_type(List<ServiceTypeBeanX> service_type) {
            this.service_type = service_type;
        }

        public static class SubscriptionPackageBean implements Serializable {
            /**
             * id : 6
             * merchant_id : 1
             * package_duration_id : 2
             * max_trip : 25
             * image : null
             * price : 1000.00
             * status : 1
             * package_type : 2
             * expire_date : 2019-10-17
             * admin_delete : 0
             * created_at : 2019-10-11 13:09:13
             * updated_at : 2019-10-16 07:00:09
             * deleted_at : null
             * service_type : [{"id":1,"serviceName":"Normal","colour":"","icon":""},{"id":2,"serviceName":"Rental","colour":"","icon":""},{"id":4,"serviceName":"Outstation","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png"},{"id":5,"serviceName":"Pool","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/icons/1567072281_5d67a019419ff_icon.png"}]
             */

            private int id;
            private int merchant_id;
            private int package_duration_id;
            private int max_trip;
            private Object image;
            private String price;
            private int status;
            private int package_type;
            private String expire_date;
            private int admin_delete;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private List<ServiceTypeBean> service_type;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public int getPackage_duration_id() {
                return package_duration_id;
            }

            public void setPackage_duration_id(int package_duration_id) {
                this.package_duration_id = package_duration_id;
            }

            public int getMax_trip() {
                return max_trip;
            }

            public void setMax_trip(int max_trip) {
                this.max_trip = max_trip;
            }

            public Object getImage() {
                return image;
            }

            public void setImage(Object image) {
                this.image = image;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getPackage_type() {
                return package_type;
            }

            public void setPackage_type(int package_type) {
                this.package_type = package_type;
            }

            public String getExpire_date() {
                return expire_date;
            }

            public void setExpire_date(String expire_date) {
                this.expire_date = expire_date;
            }

            public int getAdmin_delete() {
                return admin_delete;
            }

            public void setAdmin_delete(int admin_delete) {
                this.admin_delete = admin_delete;
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

            public Object getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(Object deleted_at) {
                this.deleted_at = deleted_at;
            }

            public List<ServiceTypeBean> getService_type() {
                return service_type;
            }

            public void setService_type(List<ServiceTypeBean> service_type) {
                this.service_type = service_type;
            }

            public static class ServiceTypeBean implements Serializable{
                /**
                 * id : 1
                 * serviceName : Normal
                 * colour :
                 * icon :
                 */

                private int id;
                private String serviceName;
                private String colour;
                private String icon;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getServiceName() {
                    return serviceName;
                }

                public void setServiceName(String serviceName) {
                    this.serviceName = serviceName;
                }

                public String getColour() {
                    return colour;
                }

                public void setColour(String colour) {
                    this.colour = colour;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }
            }
        }

        public static class PackageDurationBean implements Serializable {
            /**
             * id : 2
             * merchant_id : 1
             * status : 1
             * sequence : 2
             * created_at : 2019-10-05 12:35:45
             * updated_at : 2019-10-05 12:35:45
             * deleted_at : null
             */

            private int id;
            private int merchant_id;
            private int status;
            private int sequence;
            private String created_at;
            private String updated_at;
            private Object deleted_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
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

            public Object getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(Object deleted_at) {
                this.deleted_at = deleted_at;
            }
        }

        public static class ServiceTypeBeanX implements Serializable {
            /**
             * id : 1
             * serviceName : Normal
             * colour :
             * icon :
             */

            private int id;
            private String serviceName;
            private String colour;
            private String icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getServiceName() {
                return serviceName;
            }

            public void setServiceName(String serviceName) {
                this.serviceName = serviceName;
            }

            public String getColour() {
                return colour;
            }

            public void setColour(String colour) {
                this.colour = colour;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }

    public static class DataBean implements Serializable {
        /**
         * id : 5
         * max_trip : 40
         * image : https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png
         * price : 1500.00
         * package_type : 2
         * merchant_id : 1
         * expire_date : 2019-10-17
         * name : TEST3Day
         * description : abc
         * show_price : INR 1500.00
         * package_duration_name : Three day
         * service_type : [{"id":1,"serviceName":"Normal","colour":"","icon":""},{"id":2,"serviceName":"Rental","colour":"","icon":""},{"id":4,"serviceName":"Outstation","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/static-images/no-image.png"},{"id":5,"serviceName":"Pool","colour":"#000000","icon":"https://s3.ap-south-1.amazonaws.com/apporiotaxi-bucket/apporio-taxi/icons/1567072281_5d67a019419ff_icon.png"}]
         */

        private int id;
        private int max_trip;
        private String image;
        private String price;
        private int package_type;
        private int merchant_id;
        private String expire_date;
        private String name;
        private String description;
        private String show_price;
        private String package_duration_name;
        private List<ServiceTypeBeanXX> service_type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMax_trip() {
            return max_trip;
        }

        public void setMax_trip(int max_trip) {
            this.max_trip = max_trip;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getPackage_type() {
            return package_type;
        }

        public void setPackage_type(int package_type) {
            this.package_type = package_type;
        }

        public int getMerchant_id() {
            return merchant_id;
        }

        public void setMerchant_id(int merchant_id) {
            this.merchant_id = merchant_id;
        }

        public String getExpire_date() {
            return expire_date;
        }

        public void setExpire_date(String expire_date) {
            this.expire_date = expire_date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getShow_price() {
            return show_price;
        }

        public void setShow_price(String show_price) {
            this.show_price = show_price;
        }

        public String getPackage_duration_name() {
            return package_duration_name;
        }

        public void setPackage_duration_name(String package_duration_name) {
            this.package_duration_name = package_duration_name;
        }

        public List<ServiceTypeBeanXX> getService_type() {
            return service_type;
        }

        public void setService_type(List<ServiceTypeBeanXX> service_type) {
            this.service_type = service_type;
        }

        public static class ServiceTypeBeanXX implements Serializable{
            /**
             * id : 1
             * serviceName : Normal
             * colour :
             * icon :
             */

            private int id;
            private String serviceName;
            private String colour;
            private String icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getServiceName() {
                return serviceName;
            }

            public void setServiceName(String serviceName) {
                this.serviceName = serviceName;
            }

            public String getColour() {
                return colour;
            }

            public void setColour(String colour) {
                this.colour = colour;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }

    public static class PaymentMethodBean implements Serializable{
        /**
         * id : 2
         * payment_method : Credit Card\ Debit Card
         * payment_icon : GimZ5LMX8XQ7VEbn16xH4X8rHw3pZt9XP4CLJ7lq.png
         */

        private int id;
        private String payment_method;
        private String payment_icon;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public String getPayment_icon() {
            return payment_icon;
        }

        public void setPayment_icon(String payment_icon) {
            this.payment_icon = payment_icon;
        }
    }
}