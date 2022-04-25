package com.apporio.demotaxiappdriver.manager;


import com.apporio.demotaxiappdriver.models.ModelAppConfiguration;

import java.util.List;

public class ModelCountries {


    private List<CountriesBean> countries;

    public List<CountriesBean> getCountries() {
        return countries;
    }

    public void setCountries(List<CountriesBean> countries) {
        this.countries = countries;
    }

    public static class CountriesBean {
        /**
         * id : 4
         * merchant_id : 2
         * isoCode : INR
         * phonecode : +91
         * distance_unit : 1
         * default_language : en
         * maxNumPhone : 10
         * minNumPhone : 10
         * country_status : 1
         * created_at : 2019-02-23 12:44:21
         * updated_at : 2019-02-25 09:25:48
         * name : India
         * country_area : [{"id":3,"merchant_id":2,"country_id":"4","AreaCoordinates":"[{\"latitude\":\"28.438482470938308\",\"longitude\":\"76.80967473398528\"},{\"latitude\":\"28.351501403189985\",\"longitude\":\"76.81242131601653\"},{\"latitude\":\"28.327931752619012\",\"longitude\":\"77.04313420664153\"},{\"latitude\":\"28.350897118504516\",\"longitude\":\"77.13308476816496\"},{\"latitude\":\"28.446935154795593\",\"longitude\":\"77.17840337168059\"},{\"latitude\":\"28.508498596520255\",\"longitude\":\"77.10287236582121\"},{\"latitude\":\"28.529615034860367\",\"longitude\":\"76.94700383554778\"},{\"latitude\":\"28.48737793029043\",\"longitude\":\"76.80486821543059\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":null,"pool_postion":2,"status":1,"created_at":"2019-02-23 13:02:42","updated_at":"2019-02-23 13:02:42","AreaName":"Gurugram"},{"id":23,"merchant_id":2,"country_id":"4","AreaCoordinates":"[{\"latitude\":\"18.668812985897393\",\"longitude\":\"73.84633672902214\"},{\"latitude\":\"18.670114015737603\",\"longitude\":\"73.75569952199089\"},{\"latitude\":\"18.670114015737603\",\"longitude\":\"73.70900762745964\"},{\"latitude\":\"18.59984413508932\",\"longitude\":\"73.59227789113152\"},{\"latitude\":\"18.537357657678545\",\"longitude\":\"73.49065435597527\"},{\"latitude\":\"18.358885328742776\",\"longitude\":\"73.45220220753777\"},{\"latitude\":\"18.276752028560736\",\"longitude\":\"73.61562383839714\"},{\"latitude\":\"18.293703360417908\",\"longitude\":\"73.71450079152214\"},{\"latitude\":\"18.267623702116836\",\"longitude\":\"73.79552496144402\"},{\"latitude\":\"18.263711415235843\",\"longitude\":\"73.84359014699089\"},{\"latitude\":\"18.261103175001733\",\"longitude\":\"73.92324102589714\"},{\"latitude\":\"18.28587987471443\",\"longitude\":\"73.95894659230339\"},{\"latitude\":\"18.338029771684685\",\"longitude\":\"74.01937139699089\"},{\"latitude\":\"18.386254424268042\",\"longitude\":\"74.12511480519402\"},{\"latitude\":\"18.483965686882513\",\"longitude\":\"74.13472784230339\"},{\"latitude\":\"18.564698308236846\",\"longitude\":\"73.93972051808464\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":null,"pool_postion":1,"status":1,"created_at":"2019-03-01 06:51:01","updated_at":"2019-03-01 06:51:01","AreaName":"Pune"}]
         */

        private int id;
        private int merchant_id;
        private String isoCode;
        private String phonecode;
        private int distance_unit;
        private String default_language;
        private int maxNumPhone;
        private int minNumPhone;
        private int country_status;
        private String created_at;
        private String updated_at;
        private String name;
        private List<ModelCountries.CountriesBean.CountryAreaBean> country_area;

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

        public String getIsoCode() {
            return isoCode;
        }

        public void setIsoCode(String isoCode) {
            this.isoCode = isoCode;
        }

        public String getPhonecode() {
            return phonecode;
        }

        public void setPhonecode(String phonecode) {
            this.phonecode = phonecode;
        }

        public int getDistance_unit() {
            return distance_unit;
        }

        public void setDistance_unit(int distance_unit) {
            this.distance_unit = distance_unit;
        }

        public String getDefault_language() {
            return default_language;
        }

        public void setDefault_language(String default_language) {
            this.default_language = default_language;
        }

        public int getMaxNumPhone() {
            return maxNumPhone;
        }

        public void setMaxNumPhone(int maxNumPhone) {
            this.maxNumPhone = maxNumPhone;
        }

        public int getMinNumPhone() {
            return minNumPhone;
        }

        public void setMinNumPhone(int minNumPhone) {
            this.minNumPhone = minNumPhone;
        }

        public int getCountry_status() {
            return country_status;
        }

        public void setCountry_status(int country_status) {
            this.country_status = country_status;
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

        public List<ModelCountries.CountriesBean.CountryAreaBean> getCountry_area() {
            return country_area;
        }

        public void setCountry_area(List<ModelCountries.CountriesBean.CountryAreaBean> country_area) {
            this.country_area = country_area;
        }

        public static class CountryAreaBean {
            /**
             * id : 3
             * merchant_id : 2
             * country_id : 4
             * AreaCoordinates : [{"latitude":"28.438482470938308","longitude":"76.80967473398528"},{"latitude":"28.351501403189985","longitude":"76.81242131601653"},{"latitude":"28.327931752619012","longitude":"77.04313420664153"},{"latitude":"28.350897118504516","longitude":"77.13308476816496"},{"latitude":"28.446935154795593","longitude":"77.17840337168059"},{"latitude":"28.508498596520255","longitude":"77.10287236582121"},{"latitude":"28.529615034860367","longitude":"76.94700383554778"},{"latitude":"28.48737793029043","longitude":"76.80486821543059"}]
             * auto_upgradetion : 2
             * timezone : Asia/Kolkata
             * minimum_wallet_amount : null
             * pool_postion : 2
             * status : 1
             * created_at : 2019-02-23 13:02:42
             * updated_at : 2019-02-23 13:02:42
             * AreaName : Gurugram
             */

            private int id;
            private int merchant_id;
            private String country_id;
            private String AreaCoordinates;
            private int auto_upgradetion;
            private String timezone;
            private Object minimum_wallet_amount;
            private int pool_postion;
            private int status;
            private String created_at;
            private String updated_at;
            private String AreaName;

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

            public String getCountry_id() {
                return country_id;
            }

            public void setCountry_id(String country_id) {
                this.country_id = country_id;
            }

            public String getAreaCoordinates() {
                return AreaCoordinates;
            }

            public void setAreaCoordinates(String AreaCoordinates) {
                this.AreaCoordinates = AreaCoordinates;
            }

            public int getAuto_upgradetion() {
                return auto_upgradetion;
            }

            public void setAuto_upgradetion(int auto_upgradetion) {
                this.auto_upgradetion = auto_upgradetion;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public Object getMinimum_wallet_amount() {
                return minimum_wallet_amount;
            }

            public void setMinimum_wallet_amount(Object minimum_wallet_amount) {
                this.minimum_wallet_amount = minimum_wallet_amount;
            }

            public int getPool_postion() {
                return pool_postion;
            }

            public void setPool_postion(int pool_postion) {
                this.pool_postion = pool_postion;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
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

            public String getAreaName() {
                return AreaName;
            }

            public void setAreaName(String AreaName) {
                this.AreaName = AreaName;
            }
        }
    }

}