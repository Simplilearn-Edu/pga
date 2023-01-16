package com.simplilearn.pga.services;

import com.simplilearn.pga.models.Owner;
import com.simplilearn.pga.models.Place;
import com.simplilearn.pga.repositories.PlaceRepository;
import com.simplilearn.pga.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private PlaceRepository placeRepository;

    public List<Owner> getAllOwners() {
        List<Owner> owners = new ArrayList<Owner>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    public Owner getOwner(Long ownerId) {
        return ownerRepository.findById(ownerId).get();
    }

    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Place> getAllPlaces(Long ownerId) {
        return placeRepository.findByPlaceOwner(ownerId);
    }

    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }
}
