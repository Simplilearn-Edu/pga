package com.simplilearn.pga.controllers;

import com.simplilearn.pga.models.Tenant;
import com.simplilearn.pga.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/tenant")
public class TenantController {
    @Autowired
    TenantService tenantService;

    @RequestMapping("/")
    public List<Tenant> getTenant(ModelMap modelMap) {
        List<Tenant> tenants = null;
        try {
            tenants = tenantService.getAllTenants();
            return tenants;
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return tenants;
        }
    }

    @RequestMapping("/{tenant_id}")
    public Tenant getTenant(ModelMap modelMap, @PathVariable Long tenant_id) {
        Tenant tenant = null;
        try {
            tenant = tenantService.getTenant(tenant_id);
            return tenant;
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return tenant;
        }
    }
}