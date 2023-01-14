package com.simplilearn.pga.repositories;

import com.simplilearn.pga.models.Tenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends CrudRepository<Tenant,Long> {
}
