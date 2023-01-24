package com.simplilearn.pga.services;

import com.simplilearn.pga.models.Owner;
import com.simplilearn.pga.models.Place;
import com.simplilearn.pga.repositories.OwnerRepository;
import com.simplilearn.pga.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {
    @Autowired
    OwnerRepository repository;
    @Autowired
    private PlaceRepository placeRepository;

    public List<Owner> getAllOwners() {
        List<Owner> owners = new ArrayList<Owner>();
        repository.findAll().forEach(owners::add);
        return owners;
    }

    public Owner getOwner(Long ownerId) {
        return repository.findById(ownerId).get();
    }

    public Owner addOwner(Owner owner) {
        return repository.save(owner);
    }

    public Place addPlace(Place place) {
        if (place != null) {
            return placeRepository.save(place);
        }
        return place;
    }

    public List<Place> getAllPlacesByOwner(Long ownerId) {
        return placeRepository.findByPlaceOwner(ownerId);
    }

    public Place getPlaceByOwner(long placeId,long ownerId) {
        return placeRepository.findByPlaceOwnerId(placeId,ownerId);
    }

    public void deletePlace(Long placeId) {
        placeRepository.deleteById(placeId);
    }
}