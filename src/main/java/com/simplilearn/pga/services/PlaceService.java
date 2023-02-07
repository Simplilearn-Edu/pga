package com.simplilearn.pga.services;

import com.simplilearn.pga.models.Enquiry;
import com.simplilearn.pga.models.Place;
import com.simplilearn.pga.repositories.EnquiryRepository;
import com.simplilearn.pga.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private EnquiryRepository enquiryRepository;

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Place getPlaceById(long place_id) {
        return placeRepository.findById(place_id).get();
    }

    public List<Place> getPlaceByLocality(String place_locality) {
        return placeRepository.getPlaceByLocality(place_locality);
    }

    public Enquiry markEnquiry(Enquiry enquiry) {
        if (enquiryRepository.isEnquiry(enquiry.getTenant().getTenantId(), enquiry.getPlace().getPlaceId()))
            return enquiry;
        return enquiryRepository.save(enquiry);
    }

    public List<Enquiry> getEnquiries(Long tenantId) {
        return enquiryRepository.findByTenant(tenantId);
    }
}
