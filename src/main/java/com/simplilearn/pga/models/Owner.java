package com.simplilearn.pga.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id", nullable = false)
    private Long ownerId;
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "ownerGender")
    private String ownerGender;
    @Column(name = "owner_address")
    private String ownerAddress;

    public Owner() {
    }

    public Owner(String ownerName, String ownerGender, String ownerAddress) {
        this.ownerName = ownerName;
        this.ownerGender = ownerGender;
        this.ownerAddress = ownerAddress;
    }

    public Owner(Long ownerId, String ownerName, String ownerGender, String ownerAddress) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerGender = ownerGender;
        this.ownerAddress = ownerAddress;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerGender() {
        return ownerGender;
    }

    public void setOwnerGender(String ownerGender) {
        this.ownerGender = ownerGender;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }
}
