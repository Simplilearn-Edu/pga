package com.simplilearn.pga.services;

import com.simplilearn.pga.models.Tenant;
import com.simplilearn.pga.repositories.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantService {
    TenantRepository repository;

    public List<Tenant> getAllTenants() {
        List<Tenant> tenants = new ArrayList<Tenant>();
        repository.findAll().forEach(tenants::add);
        return tenants;
    }
}
