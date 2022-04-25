package com.apporio.demotaxiappdriver.activities.placepicker;

import java.util.List;

public class ModelPlaceIdResponse {

    /**
     * html_attributions : []
     * result : {"geometry":{"location":{"lat":28.4593364,"lng":77.0725872},"viewport":{"northeast":{"lat":28.4606853802915,"lng":77.0739361802915},"southwest":{"lat":28.4579874197085,"lng":77.07123821970849}}}}
     * status : OK
     */

    private ResultBean result;
    private String status;
    private List<?> html_attributions;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<?> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<?> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public static class ResultBean {
        /**
         * geometry : {"location":{"lat":28.4593364,"lng":77.0725872},"viewport":{"northeast":{"lat":28.4606853802915,"lng":77.0739361802915},"southwest":{"lat":28.4579874197085,"lng":77.07123821970849}}}
         */

        private GeometryBean geometry;

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public static class GeometryBean {
            /**
             * location : {"lat":28.4593364,"lng":77.0725872}
             * viewport : {"northeast":{"lat":28.4606853802915,"lng":77.0739361802915},"southwest":{"lat":28.4579874197085,"lng":77.07123821970849}}
             */

            private LocationBean location;
            private ViewportBean viewport;

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public ViewportBean getViewport() {
                return viewport;
            }

            public void setViewport(ViewportBean viewport) {
                this.viewport = viewport;
            }

            public static class LocationBean {
                /**
                 * lat : 28.4593364
                 * lng : 77.0725872
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class ViewportBean {
                /**
                 * northeast : {"lat":28.4606853802915,"lng":77.0739361802915}
                 * southwest : {"lat":28.4579874197085,"lng":77.07123821970849}
                 */

                private NortheastBean northeast;
                private SouthwestBean southwest;

                public NortheastBean getNortheast() {
                    return northeast;
                }

                public void setNortheast(NortheastBean northeast) {
                    this.northeast = northeast;
                }

                public SouthwestBean getSouthwest() {
                    return southwest;
                }

                public void setSouthwest(SouthwestBean southwest) {
                    this.southwest = southwest;
                }

                public static class NortheastBean {
                    /**
                     * lat : 28.4606853802915
                     * lng : 77.0739361802915
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class SouthwestBean {
                    /**
                     * lat : 28.4579874197085
                     * lng : 77.07123821970849
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }
    }
}
