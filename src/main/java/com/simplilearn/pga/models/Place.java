package com.simplilearn.pga.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id", nullable = false)
    private Long placeId;
    @Column(name = "place_name")
    private String placeName;
    @Column(name = "place_address")
    private String placeAddress;

    @Column(name = "place_city")
    private String placeCity;
    @Column(name = "place_rent")
    private int placeRent;

    @Column(name = "place_status")
    private boolean placeStatus;
    @OneToOne
    @JoinColumn(name = "place_owner_id")
    private Owner placeOwner;

    public Place() {
    }

    public Place(Long placeId, String placeName, String placeAddress, String placeCity, int placeRent, boolean placeStatus, Owner placeOwner) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeAddress = placeAddress;
        this.placeCity = placeCity;
        this.placeRent = placeRent;
        this.placeStatus = placeStatus;
        this.placeOwner = placeOwner;
    }

    public Place(String placeName, String placeAddress, String placeCity, int placeRent, boolean placeStatus, Owner placeOwner) {
        this.placeName = placeName;
        this.placeAddress = placeAddress;
        this.placeCity = placeCity;
        this.placeRent = placeRent;
        this.placeStatus = placeStatus;
        this.placeOwner = placeOwner;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public boolean isPlaceStatus() {
        return placeStatus;
    }

    public void setPlaceStatus(boolean placeStatus) {
        this.placeStatus = placeStatus;
    }

    public Owner getPlaceOwner() {
        return placeOwner;
    }

    public void setPlaceOwner(Owner placeOwner) {
        this.placeOwner = placeOwner;
    }

    public int getPlaceRent() {
        return placeRent;
    }

    public void setPlaceRent(int placeRent) {
        this.placeRent = placeRent;
    }

    public String getPlaceCity() {
        return placeCity;
    }

    public void setPlaceCity(String placeCity) {
        this.placeCity = placeCity;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", placeName='" + placeName + '\'' +
                ", placeAddress='" + placeAddress + '\'' +
                ", placeCity='" + placeCity + '\'' +
                ", placeRent=" + placeRent +
                ", placeStatus=" + placeStatus +
                ", placeOwner=" + placeOwner +
                '}';
    }
}
