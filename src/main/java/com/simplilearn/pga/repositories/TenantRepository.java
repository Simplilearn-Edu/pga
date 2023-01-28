package com.simplilearn.pga.repositories;

import com.simplilearn.pga.models.Tenant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends CrudRepository<Tenant, Long> {
    @Query("select a from Tenant a where a.tenantEmail = ?1 and a.tenantPassword = ?2")
    Tenant login(String tenantEmail, String tenantPassword);
}
