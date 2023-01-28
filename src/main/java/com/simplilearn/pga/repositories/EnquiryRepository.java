package com.simplilearn.pga.repositories;

import com.simplilearn.pga.models.Enquiry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnquiryRepository extends CrudRepository<Enquiry, Long> {
    @Query("select (count(e) > 0) from Enquiry e where e.tenant.tenantId = ?1 and e.place.placeId = ?2")
    boolean isEnquiry(Long tenantId, Long placeId);

    @Query("select e from Enquiry e where e.tenant.tenantId = ?1")
    List<Enquiry> findByTenant(Long tenantId);
}
