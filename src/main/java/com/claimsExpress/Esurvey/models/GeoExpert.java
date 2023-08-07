package com.claimsExpress.Esurvey.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="CARS_GEO_EXPERT")
@EntityListeners(AuditingEntityListener.class)
public class GeoExpert {
    @Id
    @Column(name = "GEO_ID", nullable = false)
    private String geoId;
    @Column(name = "GEO_EXPERT_ID")
    private String geoExpertId;
    @Column(name = "GEO_LONGITUDE")
    private  String longitude ;
    @Column(name = "GEO_LATITUDE")
    private  String latitude ;
    @Column(name = "GEO_DISPATCHING_TIME")
    private Timestamp dispatchingTime ;
    @Column(name = "GEO_STATUS")
    private String status ;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Timestamp getDispatchingTime() {
        return dispatchingTime;
    }

    public void setDispatchingTime(Timestamp dispatchingTime) {
        this.dispatchingTime = dispatchingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGeoId() {
        return geoId;
    }

    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    public String getGeoExpertId() {
        return geoExpertId;
    }

    public void setGeoExpertId(String geoExpertId) {
        this.geoExpertId = geoExpertId;
    }
}
