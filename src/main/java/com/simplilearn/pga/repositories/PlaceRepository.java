package com.simplilearn.pga.repositories;

import com.simplilearn.pga.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    @Query("select p from Place p where p.placeOwner.ownerId = ?1 order by p.placeId")
    List<Place> findByPlaceOwner(Long ownerId);

    @Query("select p from Place p " +
            "where upper(p.placeAddress) like upper(concat('%', ?1, '%')) and p.placeStatus = true " +
            "order by p.placeId")
    List<Place> getPlaceByLocality(String placeAddress);
}