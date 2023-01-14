package com.simplilearn.pga.services;

import com.simplilearn.pga.models.Tenant;
import com.simplilearn.pga.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantService {
    @Autowired
    TenantRepository repository;

    public List<Tenant> getAllTenants() {
        List<Tenant> tenants = new ArrayList<Tenant>();
        repository.findAll().forEach(tenants::add);
        return tenants;
    }

    public Tenant getTenant(Long tenantId) {
        return repository.findById(tenantId).get();
    }

    public Tenant addTenant(Tenant tenant) {
        return repository.save(tenant);
    }
}
