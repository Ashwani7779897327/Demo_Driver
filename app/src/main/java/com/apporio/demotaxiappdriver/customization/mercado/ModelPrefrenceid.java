package com.apporio.demotaxiappdriver.customization.mercado;

import java.util.List;

public class ModelPrefrenceid {
    /**
     * result : 1
     * message : api.message195
     * data : {"processing_modes":[],"binary_mode":false,"payment_methods":{"excluded_payment_methods":[{"id":""}],"excluded_payment_types":[{"id":""}],"installments":null,"default_payment_method_id":null,"default_installments":null},"collector_id":434032485,"operation_type":"regular_payment","items":[{"id":"","picture_url":"","title":"Taxi Payment","description":"Taxi Payment","category_id":"","currency_id":"ARS","quantity":1,"unit_price":10}],"payer":{"name":"","surname":"","email":"xf@gmail.com","date_created":"","phone":{"area_code":"","number":""},"identification":{"type":"","number":""},"address":{"street_name":"","street_number":null,"zip_code":""}},"back_urls":{"success":"","pending":"","failure":""},"auto_return":"","client_id":"3926041902393349","marketplace":"NONE","marketplace_fee":0,"shipments":{"receiver_address":{"zip_code":"","street_number":null,"street_name":"","floor":"","apartment":""}},"notification_url":null,"external_reference":"","additional_info":"","expires":false,"expiration_date_from":null,"expiration_date_to":null,"date_created":"2019-05-23T06:52:17.445-04:00","id":"434032485-451c1b39-8891-464f-8974-e9e83b22e3ef","init_point":"https://www.mercadopago.com/mla/checkout/start?pref_id=434032485-451c1b39-8891-464f-8974-e9e83b22e3ef","sandbox_init_point":"https://sandbox.mercadopago.com/mla/checkout/pay?pref_id=434032485-451c1b39-8891-464f-8974-e9e83b22e3ef"}
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
         * processing_modes : []
         * binary_mode : false
         * payment_methods : {"excluded_payment_methods":[{"id":""}],"excluded_payment_types":[{"id":""}],"installments":null,"default_payment_method_id":null,"default_installments":null}
         * collector_id : 434032485
         * operation_type : regular_payment
         * items : [{"id":"","picture_url":"","title":"Taxi Payment","description":"Taxi Payment","category_id":"","currency_id":"ARS","quantity":1,"unit_price":10}]
         * payer : {"name":"","surname":"","email":"xf@gmail.com","date_created":"","phone":{"area_code":"","number":""},"identification":{"type":"","number":""},"address":{"street_name":"","street_number":null,"zip_code":""}}
         * back_urls : {"success":"","pending":"","failure":""}
         * auto_return :
         * client_id : 3926041902393349
         * marketplace : NONE
         * marketplace_fee : 0
         * shipments : {"receiver_address":{"zip_code":"","street_number":null,"street_name":"","floor":"","apartment":""}}
         * notification_url : null
         * external_reference :
         * additional_info :
         * expires : false
         * expiration_date_from : null
         * expiration_date_to : null
         * date_created : 2019-05-23T06:52:17.445-04:00
         * id : 434032485-451c1b39-8891-464f-8974-e9e83b22e3ef
         * init_point : https://www.mercadopago.com/mla/checkout/start?pref_id=434032485-451c1b39-8891-464f-8974-e9e83b22e3ef
         * sandbox_init_point : https://sandbox.mercadopago.com/mla/checkout/pay?pref_id=434032485-451c1b39-8891-464f-8974-e9e83b22e3ef
         */

        private boolean binary_mode;
        private PaymentMethodsBean payment_methods;
        private int collector_id;
        private String operation_type;
        private PayerBean payer;
        private BackUrlsBean back_urls;
        private String auto_return;
        private String client_id;
        private String marketplace;
        private int marketplace_fee;
        private ShipmentsBean shipments;
        private Object notification_url;
        private String external_reference;
        private String additional_info;
        private boolean expires;
        private Object expiration_date_from;
        private Object expiration_date_to;
        private String date_created;
        private String id;
        private String init_point;
        private String sandbox_init_point;
        private List<?> processing_modes;
        private List<ItemsBean> items;

        public boolean isBinary_mode() {
            return binary_mode;
        }

        public void setBinary_mode(boolean binary_mode) {
            this.binary_mode = binary_mode;
        }

        public PaymentMethodsBean getPayment_methods() {
            return payment_methods;
        }

        public void setPayment_methods(PaymentMethodsBean payment_methods) {
            this.payment_methods = payment_methods;
        }

        public int getCollector_id() {
            return collector_id;
        }

        public void setCollector_id(int collector_id) {
            this.collector_id = collector_id;
        }

        public String getOperation_type() {
            return operation_type;
        }

        public void setOperation_type(String operation_type) {
            this.operation_type = operation_type;
        }

        public PayerBean getPayer() {
            return payer;
        }

        public void setPayer(PayerBean payer) {
            this.payer = payer;
        }

        public BackUrlsBean getBack_urls() {
            return back_urls;
        }

        public void setBack_urls(BackUrlsBean back_urls) {
            this.back_urls = back_urls;
        }

        public String getAuto_return() {
            return auto_return;
        }

        public void setAuto_return(String auto_return) {
            this.auto_return = auto_return;
        }

        public String getClient_id() {
            return client_id;
        }

        public void setClient_id(String client_id) {
            this.client_id = client_id;
        }

        public String getMarketplace() {
            return marketplace;
        }

        public void setMarketplace(String marketplace) {
            this.marketplace = marketplace;
        }

        public int getMarketplace_fee() {
            return marketplace_fee;
        }

        public void setMarketplace_fee(int marketplace_fee) {
            this.marketplace_fee = marketplace_fee;
        }

        public ShipmentsBean getShipments() {
            return shipments;
        }

        public void setShipments(ShipmentsBean shipments) {
            this.shipments = shipments;
        }

        public Object getNotification_url() {
            return notification_url;
        }

        public void setNotification_url(Object notification_url) {
            this.notification_url = notification_url;
        }

        public String getExternal_reference() {
            return external_reference;
        }

        public void setExternal_reference(String external_reference) {
            this.external_reference = external_reference;
        }

        public String getAdditional_info() {
            return additional_info;
        }

        public void setAdditional_info(String additional_info) {
            this.additional_info = additional_info;
        }

        public boolean isExpires() {
            return expires;
        }

        public void setExpires(boolean expires) {
            this.expires = expires;
        }

        public Object getExpiration_date_from() {
            return expiration_date_from;
        }

        public void setExpiration_date_from(Object expiration_date_from) {
            this.expiration_date_from = expiration_date_from;
        }

        public Object getExpiration_date_to() {
            return expiration_date_to;
        }

        public void setExpiration_date_to(Object expiration_date_to) {
            this.expiration_date_to = expiration_date_to;
        }

        public String getDate_created() {
            return date_created;
        }

        public void setDate_created(String date_created) {
            this.date_created = date_created;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInit_point() {
            return init_point;
        }

        public void setInit_point(String init_point) {
            this.init_point = init_point;
        }

        public String getSandbox_init_point() {
            return sandbox_init_point;
        }

        public void setSandbox_init_point(String sandbox_init_point) {
            this.sandbox_init_point = sandbox_init_point;
        }

        public List<?> getProcessing_modes() {
            return processing_modes;
        }

        public void setProcessing_modes(List<?> processing_modes) {
            this.processing_modes = processing_modes;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class PaymentMethodsBean {
            /**
             * excluded_payment_methods : [{"id":""}]
             * excluded_payment_types : [{"id":""}]
             * installments : null
             * default_payment_method_id : null
             * default_installments : null
             */

            private Object installments;
            private Object default_payment_method_id;
            private Object default_installments;
            private List<ExcludedPaymentMethodsBean> excluded_payment_methods;
            private List<ExcludedPaymentTypesBean> excluded_payment_types;

            public Object getInstallments() {
                return installments;
            }

            public void setInstallments(Object installments) {
                this.installments = installments;
            }

            public Object getDefault_payment_method_id() {
                return default_payment_method_id;
            }

            public void setDefault_payment_method_id(Object default_payment_method_id) {
                this.default_payment_method_id = default_payment_method_id;
            }

            public Object getDefault_installments() {
                return default_installments;
            }

            public void setDefault_installments(Object default_installments) {
                this.default_installments = default_installments;
            }

            public List<ExcludedPaymentMethodsBean> getExcluded_payment_methods() {
                return excluded_payment_methods;
            }

            public void setExcluded_payment_methods(List<ExcludedPaymentMethodsBean> excluded_payment_methods) {
                this.excluded_payment_methods = excluded_payment_methods;
            }

            public List<ExcludedPaymentTypesBean> getExcluded_payment_types() {
                return excluded_payment_types;
            }

            public void setExcluded_payment_types(List<ExcludedPaymentTypesBean> excluded_payment_types) {
                this.excluded_payment_types = excluded_payment_types;
            }

            public static class ExcludedPaymentMethodsBean {
                /**
                 * id :
                 */

                private String id;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }

            public static class ExcludedPaymentTypesBean {
                /**
                 * id :
                 */

                private String id;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }

        public static class PayerBean {
            /**
             * name :
             * surname :
             * email : xf@gmail.com
             * date_created :
             * phone : {"area_code":"","number":""}
             * identification : {"type":"","number":""}
             * address : {"street_name":"","street_number":null,"zip_code":""}
             */

            private String name;
            private String surname;
            private String email;
            private String date_created;
            private PhoneBean phone;
            private IdentificationBean identification;
            private AddressBean address;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSurname() {
                return surname;
            }

            public void setSurname(String surname) {
                this.surname = surname;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getDate_created() {
                return date_created;
            }

            public void setDate_created(String date_created) {
                this.date_created = date_created;
            }

            public PhoneBean getPhone() {
                return phone;
            }

            public void setPhone(PhoneBean phone) {
                this.phone = phone;
            }

            public IdentificationBean getIdentification() {
                return identification;
            }

            public void setIdentification(IdentificationBean identification) {
                this.identification = identification;
            }

            public AddressBean getAddress() {
                return address;
            }

            public void setAddress(AddressBean address) {
                this.address = address;
            }

            public static class PhoneBean {
                /**
                 * area_code :
                 * number :
                 */

                private String area_code;
                private String number;

                public String getArea_code() {
                    return area_code;
                }

                public void setArea_code(String area_code) {
                    this.area_code = area_code;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }
            }

            public static class IdentificationBean {
                /**
                 * type :
                 * number :
                 */

                private String type;
                private String number;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }
            }

            public static class AddressBean {
                /**
                 * street_name :
                 * street_number : null
                 * zip_code :
                 */

                private String street_name;
                private Object street_number;
                private String zip_code;

                public String getStreet_name() {
                    return street_name;
                }

                public void setStreet_name(String street_name) {
                    this.street_name = street_name;
                }

                public Object getStreet_number() {
                    return street_number;
                }

                public void setStreet_number(Object street_number) {
                    this.street_number = street_number;
                }

                public String getZip_code() {
                    return zip_code;
                }

                public void setZip_code(String zip_code) {
                    this.zip_code = zip_code;
                }
            }
        }

        public static class BackUrlsBean {
            /**
             * success :
             * pending :
             * failure :
             */

            private String success;
            private String pending;
            private String failure;

            public String getSuccess() {
                return success;
            }

            public void setSuccess(String success) {
                this.success = success;
            }

            public String getPending() {
                return pending;
            }

            public void setPending(String pending) {
                this.pending = pending;
            }

            public String getFailure() {
                return failure;
            }

            public void setFailure(String failure) {
                this.failure = failure;
            }
        }

        public static class ShipmentsBean {
            /**
             * receiver_address : {"zip_code":"","street_number":null,"street_name":"","floor":"","apartment":""}
             */

            private ReceiverAddressBean receiver_address;

            public ReceiverAddressBean getReceiver_address() {
                return receiver_address;
            }

            public void setReceiver_address(ReceiverAddressBean receiver_address) {
                this.receiver_address = receiver_address;
            }

            public static class ReceiverAddressBean {
                /**
                 * zip_code :
                 * street_number : null
                 * street_name :
                 * floor :
                 * apartment :
                 */

                private String zip_code;
                private Object street_number;
                private String street_name;
                private String floor;
                private String apartment;

                public String getZip_code() {
                    return zip_code;
                }

                public void setZip_code(String zip_code) {
                    this.zip_code = zip_code;
                }

                public Object getStreet_number() {
                    return street_number;
                }

                public void setStreet_number(Object street_number) {
                    this.street_number = street_number;
                }

                public String getStreet_name() {
                    return street_name;
                }

                public void setStreet_name(String street_name) {
                    this.street_name = street_name;
                }

                public String getFloor() {
                    return floor;
                }

                public void setFloor(String floor) {
                    this.floor = floor;
                }

                public String getApartment() {
                    return apartment;
                }

                public void setApartment(String apartment) {
                    this.apartment = apartment;
                }
            }
        }

        public static class ItemsBean {
            /**
             * id :
             * picture_url :
             * title : Taxi Payment
             * description : Taxi Payment
             * category_id :
             * currency_id : ARS
             * quantity : 1
             * unit_price : 10
             */

            private String id;
            private String picture_url;
            private String title;
            private String description;
            private String category_id;
            private String currency_id;
            private int quantity;
            private int unit_price;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPicture_url() {
                return picture_url;
            }

            public void setPicture_url(String picture_url) {
                this.picture_url = picture_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getCurrency_id() {
                return currency_id;
            }

            public void setCurrency_id(String currency_id) {
                this.currency_id = currency_id;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getUnit_price() {
                return unit_price;
            }

            public void setUnit_price(int unit_price) {
                this.unit_price = unit_price;
            }
        }
    }
}