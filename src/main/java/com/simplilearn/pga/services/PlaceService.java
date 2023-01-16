package com.simplilearn.pga.services;

import com.simplilearn.pga.models.Place;
import com.simplilearn.pga.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Place getPlaceById(long place_id) {
        return placeRepository.findById(place_id).get();
    }

    public List<Place> getPlaceByLocality(String place_locality) {
        return placeRepository.getPlaceByLocality(place_locality);
    }
}
