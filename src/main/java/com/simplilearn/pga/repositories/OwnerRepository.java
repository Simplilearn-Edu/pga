package com.simplilearn.pga.repositories;

import com.simplilearn.pga.models.Enquiry;
import com.simplilearn.pga.models.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {
    @Query("select a from Owner a where a.ownerEmail = ?1 and a.ownerPassword = ?2")
    Owner login(String ownerEmail, String ownerPassword);
}
