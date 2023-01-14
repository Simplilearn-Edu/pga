package com.simplilearn.pga.controllers;

import com.simplilearn.pga.models.Tenant;
import com.simplilearn.pga.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TenantController {
    @Autowired
    TenantService tenantService;

    @RequestMapping("/tenant")
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

    @RequestMapping("/tenant/{tenant_id}")
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

    @RequestMapping("/tenant/add")
    public Tenant addTenant(ModelMap modelMap,
                            @RequestParam("tenant_name") String tenant_name,
                            @RequestParam("tenant_gender") String tenant_gender,
                            @RequestParam("tenant_address") String tenant_address) {
        Tenant tenant = new Tenant(tenant_name, tenant_gender, tenant_address);
        System.out.println(tenant.getTenantAddress() + tenant.getTenantName() + tenant.getTenantGender());
        return tenantService.addTenant(tenant);
    }

    @RequestMapping("/tenant/edit")
    public Tenant editTenant(ModelMap modelMap,
                             @RequestParam("tenant_id") Long tenant_id,
                             @RequestParam("tenant_name") String tenant_name,
                             @RequestParam("tenant_gender") String tenant_gender,
                             @RequestParam("tenant_address") String tenant_address) {
        Tenant tenant = new Tenant(tenant_id, tenant_name, tenant_gender, tenant_address);
        System.out.println(tenant.getTenantAddress() + tenant.getTenantName() + tenant.getTenantGender());
        return tenantService.addTenant(tenant);
    }
}
