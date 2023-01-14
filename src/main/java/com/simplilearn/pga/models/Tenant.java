package com.simplilearn.pga.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;
    @Column(name = "tenant_name")
    private String tenantName;
    @Column(name = "tenantGender")
    private String tenantGender;
    @Column(name = "tenant_address")
    private String tenantAddress;

    public Tenant() {
    }

    public Tenant(Long tenantId, String tenantName, String tenantGender, String tenantAddress) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.tenantGender = tenantGender;
        this.tenantAddress = tenantAddress;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantGender() {
        return tenantGender;
    }

    public void setTenantGender(String tenantGender) {
        this.tenantGender = tenantGender;
    }

    public String getTenantAddress() {
        return tenantAddress;
    }

    public void setTenantAddress(String tenantAddress) {
        this.tenantAddress = tenantAddress;
    }
}
