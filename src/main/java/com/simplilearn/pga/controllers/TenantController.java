package com.simplilearn.pga.controllers;

import com.simplilearn.pga.models.Tenant;
import com.simplilearn.pga.services.TenantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TenantController {
    TenantService tenantService;

    @RequestMapping("/tenant")
    public List<Tenant> getTenant() {
        return tenantService.getAllTenants();
    }
}
