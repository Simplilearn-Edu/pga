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
    @Column(name = "tenant_email")
    private String tenantEmail;
    @Column(name = "tenant_password")
    private String tenantPassword;
    @Column(name = "tenantGender")
    private String tenantGender;
    @Column(name = "tenant_address")
    private String tenantAddress;

    public Tenant() {
    }

    public Tenant(String tenantName, String tenantGender, String tenantAddress) {
        this.tenantName = tenantName;
        this.tenantGender = tenantGender;
        this.tenantAddress = tenantAddress;
    }

    public Tenant(Long tenantId, String tenantName, String tenantGender, String tenantAddress) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.tenantGender = tenantGender;
        this.tenantAddress = tenantAddress;
    }

    public Tenant(Long tenantId, String tenantName, String tenantEmail, String tenantPassword, String tenantGender, String tenantAddress) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.tenantPassword = tenantPassword;
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

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public String getTenantPassword() {
        return tenantPassword;
    }

    public void setTenantPassword(String tenantPassword) {
        this.tenantPassword = tenantPassword;
    }
}
