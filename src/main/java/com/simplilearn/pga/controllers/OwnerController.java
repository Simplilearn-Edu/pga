package com.simplilearn.pga.controllers;

import com.simplilearn.pga.models.Owner;
import com.simplilearn.pga.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @RequestMapping("/owner")
    public List<Owner> getOwner(ModelMap modelMap) {
        List<Owner> owners = null;
        try {
            owners = ownerService.getAllOwners();
            return owners;
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return owners;
        }
    }

    @RequestMapping("/owner/{owner_id}")
    public Owner getOwner(ModelMap modelMap, @PathVariable Long owner_id) {
        Owner owner = null;
        try {
            owner = ownerService.getOwner(owner_id);
            return owner;
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return owner;
        }
    }

    @RequestMapping("/owner/add")
    public Owner addOwner(ModelMap modelMap,
                            @RequestParam("owner_name") String owner_name,
                            @RequestParam("owner_gender") String owner_gender,
                            @RequestParam("owner_address") String owner_address) {
        Owner owner = new Owner(owner_name, owner_gender, owner_address);
        System.out.println(owner.getOwnerAddress() + owner.getOwnerName() + owner.getOwnerGender());
        return ownerService.addOwner(owner);
    }

    @RequestMapping("/owner/edit")
    public Owner editOwner(ModelMap modelMap,
                             @RequestParam("owner_id") Long owner_id,
                             @RequestParam("owner_name") String owner_name,
                             @RequestParam("owner_gender") String owner_gender,
                             @RequestParam("owner_address") String owner_address) {
        Owner owner = new Owner(owner_id, owner_name, owner_gender, owner_address);
        System.out.println(owner.getOwnerAddress() + owner.getOwnerName() + owner.getOwnerGender());
        return ownerService.addOwner(owner);
    }
}
