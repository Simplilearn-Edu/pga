package com.simplilearn.pga.services;

import com.simplilearn.pga.models.Owner;
import com.simplilearn.pga.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {
    @Autowired
    OwnerRepository repository;

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
}
