package com.simplilearn.pga.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_enquiry")
public class Enquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enquiry_id", nullable = false)
    private Long enquiryId;
    @ManyToOne
    @JoinColumn(name = "enquiry_tenant_id")
    private Tenant tenant;
    @ManyToOne
    @JoinColumn(name = "enquiry_place_id")
    private Place place;


    public Enquiry() {
    }

    public Enquiry(Long enquiryId, Tenant tenant, Place place) {
        this.enquiryId = enquiryId;
        this.tenant = tenant;
        this.place = place;
    }

    public Enquiry(Tenant tenant, Place place) {
        this.tenant = tenant;
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Long getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Long enquiryId) {
        this.enquiryId = enquiryId;
    }
}
