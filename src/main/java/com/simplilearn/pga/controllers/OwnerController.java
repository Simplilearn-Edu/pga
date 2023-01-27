package com.simplilearn.pga.controllers;

import com.simplilearn.pga.models.Owner;
import com.simplilearn.pga.models.Place;
import com.simplilearn.pga.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@RestController
@Controller
@RequestMapping(path = "/owner")
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @RequestMapping("/")
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

    @RequestMapping("/{owner_id}")
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

    @RequestMapping("/add")
    public Owner addOwner(ModelMap modelMap,
                          @RequestParam("owner_name") String owner_name,
                          @RequestParam("owner_gender") String owner_gender,
                          @RequestParam("owner_address") String owner_address) {
        Owner owner = new Owner(owner_name, owner_gender, owner_address);
        System.out.println(owner.getOwnerAddress() + owner.getOwnerName() + owner.getOwnerGender());
        return ownerService.addOwner(owner);
    }

    @RequestMapping("/edit")
    public Owner editOwner(ModelMap modelMap,
                           @RequestParam("owner_id") Long owner_id,
                           @RequestParam("owner_name") String owner_name,
                           @RequestParam("owner_gender") String owner_gender,
                           @RequestParam("owner_address") String owner_address) {
        Owner owner = new Owner(owner_id, owner_name, owner_gender, owner_address);
        System.out.println(owner.getOwnerAddress() + owner.getOwnerName() + owner.getOwnerGender());
        return ownerService.addOwner(owner);
    }

    @RequestMapping("/places/add-new")
    public String addPlaces() {
        return "add-place";
    }

    @RequestMapping("/places/add")
    public String addPlaces(ModelMap modelMap,
                            @RequestParam("place_name") String place_name,
                            @RequestParam("place_address") String place_address,
                            @RequestParam("place_rent") int place_rent) {
        Owner owner = ownerService.getOwner(2l);
        Place place = new Place(place_name, place_address, place_rent, true, owner);
        ownerService.addPlace(place);
        return "redirect:/owner/places";
    }
    @RequestMapping("/places/edit-place/{place_id}")
    public String editPlaces(ModelMap modelMap,@PathVariable Long place_id) {
        Place place = ownerService.getPlaceByOwner(place_id,1l);
        modelMap.addAttribute("place",place);
        return "edit-place";
    }
    @RequestMapping("/places/edit")
    public String addPlaces(ModelMap modelMap,
                           @RequestParam("place_id") Long place_id,
                           @RequestParam("place_name") String place_name,
                           @RequestParam("place_address") String place_address,
                           @RequestParam("place_rent") int place_rent,
                           @RequestParam("place_status") boolean place_status) {
        Owner owner = ownerService.getOwner(1l);
        Place place = new Place(place_id,place_name, place_address, place_rent, place_status, owner);
        ownerService.addPlace(place);
        return "redirect:/owner/places";
    }

    @RequestMapping("/places/delete/{placeId}")
    public ResponseEntity<String> deletePlaces(ModelMap modelMap,
                                               @PathVariable("placeId") Long place_id) {
        Place place = ownerService.getPlaceByOwner(place_id, 1l);

        if (place.isPlaceStatus()) {
            ownerService.deletePlace(place_id);
            return new ResponseEntity<>("Place Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Occupied place can not be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping("/places")
    public String getAllPlaces(ModelMap modelMap) {
        List<Place> places = null;
        try {
            places = ownerService.getAllPlacesByOwner(1l);
            modelMap.addAttribute("places", places);
            modelMap.addAttribute("message", "TOTAL " + places.size() + " RECORDS FOUND");
            return "place-list";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return "place-list";
        }
    }

    @RequestMapping("/places/{id}")
    public String getAllPlaces(ModelMap modelMap, @PathVariable long id) {
        Place place = null;
        try {
            place = ownerService.getPlaceByOwner(id, 1l);
            modelMap.addAttribute("place", place);
            return "place-single";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return "place-single";
        }
    }
}