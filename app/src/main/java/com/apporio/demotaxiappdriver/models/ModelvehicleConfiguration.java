package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class ModelvehicleConfiguration {
    /**
     * result : 1
     * message : Vehicle Configuration
     * data : {"vehicle_type":[{"id":1,"vehicleTypeName":"Sedan","vehicleTypeImage":"vehicle/nyP6FvIZiRjrpi3HNtd5KPPKyytBYABbCJGngYJ3.png","vehicleTypeMapImage":"vehicle/ZpgdY077yfmVYz3t4O6qVIQgVwDhyLNKYd9g2b18.png","services":[{"id":1,"merchant_id":"1","serviceName":"Normal","serviceStatus":"1","created_at":"2018-05-18 20:30:00","updated_at":"2018-05-18 21:30:00"}]},{"id":2,"vehicleTypeName":"Luxury","vehicleTypeImage":"vehicle/TNlHOKqN1sIQu1yUtX0bOU2AqBgkwe6uZrbXcPh4.jpeg","vehicleTypeMapImage":"vehicle/0jr43fkvZxZMbVB1d4LcTxD6JPl0we3a36dZm2Xr.jpeg","services":[{"id":1,"merchant_id":"1","serviceName":"Normal","serviceStatus":"1","created_at":"2018-05-18 20:30:00","updated_at":"2018-05-18 21:30:00"}]},{"id":3,"vehicleTypeName":"Mini","vehicleTypeImage":"vehicle/h0Abg0rgZIaL9V6TRsGw6Soan7U2kWIP8nIve6eq.png","vehicleTypeMapImage":"vehicle/dE3aw0bTXmzGVTjERAnvT9AQHTHN6Y4o5MHcZ1xZ.png","services":[{"id":1,"merchant_id":"1","serviceName":"Normal","serviceStatus":"1","created_at":"2018-05-18 20:30:00","updated_at":"2018-05-18 21:30:00"}]},{"id":4,"vehicleTypeName":"Micro","vehicleTypeImage":"vehicle/44h4bqGH1RMXvPTc4XrAZpWnJqqLdUKxgbmDw5pC.png","vehicleTypeMapImage":"vehicle/f7s3T8rdkTNZHRAEztziztwzjjH9RFhvEvBFe9np.png","services":[{"id":2,"merchant_id":"1","serviceName":"Rental","serviceStatus":"1","created_at":"2018-05-18 23:30:00","updated_at":"2018-05-18 22:30:00"}]},{"id":5,"vehicleTypeName":"Micro english","vehicleTypeImage":"vehicle/SCaNip93Sfrwtk6Oy0yi478488TLitAVZdWsXxaw.jpeg","vehicleTypeMapImage":"vehicle/BS8sPUrfVH3nAAvXHFix3MvlFbMpy82F02WuWWLr.jpeg","services":[{"id":3,"merchant_id":"1","serviceName":"Transfer","serviceStatus":"1","created_at":"2018-05-18 22:30:00","updated_at":"2018-05-19 01:30:00"}]}],"vehicle_make":[{"id":1,"merchant_id":"1","vehicleMakeLogo":"vehicle/abjoZ7LusR8yWeBRQg8XU661nYhpDsPozmxm6tbo.png","vehicleMakeStatus":"1","created_at":"2018-10-10 06:30:06","updated_at":"2018-10-23 01:16:37","vehicleMakeName":"BMW"},{"id":2,"merchant_id":"1","vehicleMakeLogo":"vehiclelogo/uSfRG5pdFMqbmaJ9ljsGYiwmW6D6ZXA60JXaU66x.jpeg","vehicleMakeStatus":"1","created_at":"2018-10-10 07:22:00","updated_at":"2018-10-10 07:22:00","vehicleMakeName":"Mercury Benz"},{"id":3,"merchant_id":"1","vehicleMakeLogo":"vehiclelogo/teKDea7Eon86zVieKngkkAsm6kjAE3nE6uRYoVJf.jpeg","vehicleMakeStatus":"1","created_at":"2018-10-10 07:26:26","updated_at":"2018-10-10 07:26:26","vehicleMakeName":"swift"},{"id":4,"merchant_id":"1","vehicleMakeLogo":"vehiclelogo/Lk1JM0uNMXN5o0bdS6w22f645lNPGZQEDM6Du2or.jpeg","vehicleMakeStatus":"1","created_at":"2018-10-11 10:42:39","updated_at":"2018-10-11 10:42:39","vehicleMakeName":"वोक्सवैगन"}]}
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
        private List<VehicleTypeBean> vehicle_type;
        private List<VehicleMakeBean> vehicle_make;

        public List<VehicleTypeBean> getVehicle_type() {
            return vehicle_type;
        }

        public void setVehicle_type(List<VehicleTypeBean> vehicle_type) {
            this.vehicle_type = vehicle_type;
        }

        public List<VehicleMakeBean> getVehicle_make() {
            return vehicle_make;
        }

        public void setVehicle_make(List<VehicleMakeBean> vehicle_make) {
            this.vehicle_make = vehicle_make;
        }

        public static class VehicleTypeBean {
            /**
             * id : 1
             * vehicleTypeName : Sedan
             * vehicleTypeImage : vehicle/nyP6FvIZiRjrpi3HNtd5KPPKyytBYABbCJGngYJ3.png
             * vehicleTypeMapImage : vehicle/ZpgdY077yfmVYz3t4O6qVIQgVwDhyLNKYd9g2b18.png
             * services : [{"id":1,"merchant_id":"1","serviceName":"Normal","serviceStatus":"1","created_at":"2018-05-18 20:30:00","updated_at":"2018-05-18 21:30:00"}]
             */

            private int id;
            private String vehicleTypeName;
            private String vehicleTypeImage;
            private String vehicleTypeMapImage;
            private List<ServicesBean> services;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getVehicleTypeName() {
                return vehicleTypeName;
            }

            public void setVehicleTypeName(String vehicleTypeName) {
                this.vehicleTypeName = vehicleTypeName;
            }

            public String getVehicleTypeImage() {
                return vehicleTypeImage;
            }

            public void setVehicleTypeImage(String vehicleTypeImage) {
                this.vehicleTypeImage = vehicleTypeImage;
            }

            public String getVehicleTypeMapImage() {
                return vehicleTypeMapImage;
            }

            public void setVehicleTypeMapImage(String vehicleTypeMapImage) {
                this.vehicleTypeMapImage = vehicleTypeMapImage;
            }

            public List<ServicesBean> getServices() {
                return services;
            }

            public void setServices(List<ServicesBean> services) {
                this.services = services;
            }

            public static class ServicesBean {
                /**
                 * id : 1
                 * merchant_id : 1
                 * serviceName : Normal
                 * serviceStatus : 1
                 * created_at : 2018-05-18 20:30:00
                 * updated_at : 2018-05-18 21:30:00
                 */

                private int id;
                private String merchant_id;
                private String serviceName;
                private String serviceStatus;
                private String created_at;
                private String updated_at;

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

                public String getServiceName() {
                    return serviceName;
                }

                public void setServiceName(String serviceName) {
                    this.serviceName = serviceName;
                }

                public String getServiceStatus() {
                    return serviceStatus;
                }

                public void setServiceStatus(String serviceStatus) {
                    this.serviceStatus = serviceStatus;
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
            }
        }

        public static class VehicleMakeBean {
            /**
             * id : 1
             * merchant_id : 1
             * vehicleMakeLogo : vehicle/abjoZ7LusR8yWeBRQg8XU661nYhpDsPozmxm6tbo.png
             * vehicleMakeStatus : 1
             * created_at : 2018-10-10 06:30:06
             * updated_at : 2018-10-23 01:16:37
             * vehicleMakeName : BMW
             */

            private int id;
            private String merchant_id;
            private String vehicleMakeLogo;
            private String vehicleMakeStatus;
            private String created_at;
            private String updated_at;
            private String vehicleMakeName;

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

            public String getVehicleMakeLogo() {
                return vehicleMakeLogo;
            }

            public void setVehicleMakeLogo(String vehicleMakeLogo) {
                this.vehicleMakeLogo = vehicleMakeLogo;
            }

            public String getVehicleMakeStatus() {
                return vehicleMakeStatus;
            }

            public void setVehicleMakeStatus(String vehicleMakeStatus) {
                this.vehicleMakeStatus = vehicleMakeStatus;
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

            public String getVehicleMakeName() {
                return vehicleMakeName;
            }

            public void setVehicleMakeName(String vehicleMakeName) {
                this.vehicleMakeName = vehicleMakeName;
            }
        }
    }






    /*
    *//**
     * result : 1
     * message : Vehicle Configuration
     * data : {"vehicle_type":[{"id":1,"merchant_id":"1","vehicleTypeName":"Luxury","vehicleTypeImage":"vehicle/nhp1CptlRygGPkAHGstiPAd4Sr9aIrxe2lbq4O9B.png","vehicleTypeMapImage":"vehicle/aiLRD7DnBNedXSNKxX1CPEQ8vmnQQzZ1m5yXjb93.png","vehicleTypeDescription":"Luxury","vehicleTypeStatus":"1","created_at":"2018-05-30 05:30:48","updated_at":"2018-05-30 05:30:48"}],"vehicle_make":[{"id":1,"merchant_id":"1","vehicleMakeName":"Audi","vehicleMakeLogo":"vehiclelogo/riVHEtwHePdssWRckVFtbe9TmgzsW9wEuSp39T0H.png","vehicleMakeDescription":"test","created_at":"2018-05-17 05:40:22","updated_at":"2018-05-17 05:40:22"}],"service_type":[{"id":1,"merchant_id":"1","serviceName":"Normal","serviceStatus":"1","created_at":"2018-05-18 20:30:00","updated_at":"2018-05-18 21:30:00","pivot":{"country_area_id":"5","service_type_id":"1"}},{"id":2,"merchant_id":"1","serviceName":"Rental","serviceStatus":"1","created_at":"2018-05-18 23:30:00","updated_at":"2018-05-18 22:30:00","pivot":{"country_area_id":"5","service_type_id":"2"}},{"id":3,"merchant_id":"1","serviceName":"Transfer","serviceStatus":"1","created_at":"2018-05-18 22:30:00","updated_at":"2018-05-19 01:30:00","pivot":{"country_area_id":"5","service_type_id":"3"}}]}
     *//*

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
        private List<VehicleTypeBean> vehicle_type;
        private List<VehicleMakeBean> vehicle_make;
        private List<ServiceTypeBean> service_type;

        public List<VehicleTypeBean> getVehicle_type() {
            return vehicle_type;
        }

        public void setVehicle_type(List<VehicleTypeBean> vehicle_type) {
            this.vehicle_type = vehicle_type;
        }

        public List<VehicleMakeBean> getVehicle_make() {
            return vehicle_make;
        }

        public void setVehicle_make(List<VehicleMakeBean> vehicle_make) {
            this.vehicle_make = vehicle_make;
        }

        public List<ServiceTypeBean> getService_type() {
            return service_type;
        }

        public void setService_type(List<ServiceTypeBean> service_type) {
            this.service_type = service_type;
        }

        public static class VehicleTypeBean {
            *//**
             * id : 1
             * merchant_id : 1
             * vehicleTypeName : Luxury
             * vehicleTypeImage : vehicle/nhp1CptlRygGPkAHGstiPAd4Sr9aIrxe2lbq4O9B.png
             * vehicleTypeMapImage : vehicle/aiLRD7DnBNedXSNKxX1CPEQ8vmnQQzZ1m5yXjb93.png
             * vehicleTypeDescription : Luxury
             * vehicleTypeStatus : 1
             * created_at : 2018-05-30 05:30:48
             * updated_at : 2018-05-30 05:30:48
             *//*

            private int id;
            private String merchant_id;
            private String vehicleTypeName;
            private String vehicleTypeImage;
            private String vehicleTypeMapImage;
            private String vehicleTypeDescription;
            private String vehicleTypeStatus;
            private String created_at;
            private String updated_at;

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

            public String getVehicleTypeName() {
                return vehicleTypeName;
            }

            public void setVehicleTypeName(String vehicleTypeName) {
                this.vehicleTypeName = vehicleTypeName;
            }

            public String getVehicleTypeImage() {
                return vehicleTypeImage;
            }

            public void setVehicleTypeImage(String vehicleTypeImage) {
                this.vehicleTypeImage = vehicleTypeImage;
            }

            public String getVehicleTypeMapImage() {
                return vehicleTypeMapImage;
            }

            public void setVehicleTypeMapImage(String vehicleTypeMapImage) {
                this.vehicleTypeMapImage = vehicleTypeMapImage;
            }

            public String getVehicleTypeDescription() {
                return vehicleTypeDescription;
            }

            public void setVehicleTypeDescription(String vehicleTypeDescription) {
                this.vehicleTypeDescription = vehicleTypeDescription;
            }

            public String getVehicleTypeStatus() {
                return vehicleTypeStatus;
            }

            public void setVehicleTypeStatus(String vehicleTypeStatus) {
                this.vehicleTypeStatus = vehicleTypeStatus;
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
        }

        public static class VehicleMakeBean {
            *//**
             * id : 1
             * merchant_id : 1
             * vehicleMakeName : Audi
             * vehicleMakeLogo : vehiclelogo/riVHEtwHePdssWRckVFtbe9TmgzsW9wEuSp39T0H.png
             * vehicleMakeDescription : test
             * created_at : 2018-05-17 05:40:22
             * updated_at : 2018-05-17 05:40:22
             *//*

            private int id;
            private String merchant_id;
            private String vehicleMakeName;
            private String vehicleMakeLogo;
            private String vehicleMakeDescription;
            private String created_at;
            private String updated_at;

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

            public String getVehicleMakeName() {
                return vehicleMakeName;
            }

            public void setVehicleMakeName(String vehicleMakeName) {
                this.vehicleMakeName = vehicleMakeName;
            }

            public String getVehicleMakeLogo() {
                return vehicleMakeLogo;
            }

            public void setVehicleMakeLogo(String vehicleMakeLogo) {
                this.vehicleMakeLogo = vehicleMakeLogo;
            }

            public String getVehicleMakeDescription() {
                return vehicleMakeDescription;
            }

            public void setVehicleMakeDescription(String vehicleMakeDescription) {
                this.vehicleMakeDescription = vehicleMakeDescription;
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
        }

        public static class ServiceTypeBean {
            *//**
             * id : 1
             * merchant_id : 1
             * serviceName : Normal
             * serviceStatus : 1
             * created_at : 2018-05-18 20:30:00
             * updated_at : 2018-05-18 21:30:00
             * pivot : {"country_area_id":"5","service_type_id":"1"}
             *//*

            private int id;
            private String merchant_id;
            private String serviceName;
            private String serviceStatus;
            private String created_at;
            private String updated_at;
            private PivotBean pivot;

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

            public String getServiceName() {
                return serviceName;
            }

            public void setServiceName(String serviceName) {
                this.serviceName = serviceName;
            }

            public String getServiceStatus() {
                return serviceStatus;
            }

            public void setServiceStatus(String serviceStatus) {
                this.serviceStatus = serviceStatus;
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

            public PivotBean getPivot() {
                return pivot;
            }

            public void setPivot(PivotBean pivot) {
                this.pivot = pivot;
            }

            public static class PivotBean {
                *//**
                 * country_area_id : 5
                 * service_type_id : 1
                 *//*

                private String country_area_id;
                private String service_type_id;

                public String getCountry_area_id() {
                    return country_area_id;
                }

                public void setCountry_area_id(String country_area_id) {
                    this.country_area_id = country_area_id;
                }

                public String getService_type_id() {
                    return service_type_id;
                }

                public void setService_type_id(String service_type_id) {
                    this.service_type_id = service_type_id;
                }
            }
        }
    }*/
}
