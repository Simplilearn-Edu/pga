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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//@RestController
@Controller
@RequestMapping(path = "/owner")
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @RequestMapping("/")
    private String home(ModelMap modelMap) {
        modelMap.addAttribute("pagetitle", "Login");
        return "login";
    }

    @RequestMapping("/login")
    private String login(ModelMap modelMap,
                         HttpServletRequest request,
                         @RequestParam(value = "user_email", required = true) String user_email,
                         @RequestParam(value = "user_password", required = true) String user_password) {
        modelMap.addAttribute("pagetitle", "Login");
        Owner owner = ownerService.login(user_email, user_password);
        if (owner == null) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Invalid Credentials! Please try again.");
            return "login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("ownerId", owner.getOwnerId());
        session.setAttribute("ownerName", owner.getOwnerName());
        return "redirect:places";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

    /*@RequestMapping("/")
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
*/
    @RequestMapping("/places/add-new")
    public String addPlaces(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }

        String[] cities = {"Delhi", "Mumbai", "Pune", "Bengaluru", "Hyderabad", "Chennai", "Surat"};
        modelMap.addAttribute("cities", cities);
        return "add-place";
    }

    @RequestMapping("/places/add")
    public String addPlaces(ModelMap modelMap,
                            @RequestParam("place_name") String place_name,
                            @RequestParam("place_address") String place_address,
                            @RequestParam("place_city") String place_city,
                            @RequestParam("place_rent") int place_rent,
                            HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/";
        }
        long ownerId = (Long) session.getAttribute("ownerId");
        Owner owner = ownerService.getOwner(ownerId);
        Place place = new Place(place_name, place_address, place_city, place_rent, true, owner);
        ownerService.addPlace(place);
        return "redirect:/owner/places";
    }

    @RequestMapping("/places/edit-place/{place_id}")
    public String editPlaces(ModelMap modelMap, @PathVariable Long place_id) {
        String[] cities = {"Delhi", "Mumbai", "Pune", "Bengaluru", "Hyderabad", "Chennai", "Surat"};
        modelMap.addAttribute("cities", cities);
        Place place = ownerService.getPlaceByOwner(place_id, 1l);
        modelMap.addAttribute("place", place);
        return "edit-place";
    }

    @RequestMapping("/places/edit")
    public String addPlaces(ModelMap modelMap,
                            @RequestParam("place_id") Long place_id,
                            @RequestParam("place_name") String place_name,
                            @RequestParam("place_address") String place_address,
                            @RequestParam("place_city") String place_city,
                            @RequestParam("place_rent") int place_rent,
                            @RequestParam("place_status") boolean place_status) {
        Owner owner = ownerService.getOwner(1l);
        Place place = new Place(place_id, place_name, place_address, place_city, place_rent, place_status, owner);
        ownerService.addPlace(place);
        return "redirect:places";
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
    public String getAllPlaces(ModelMap modelMap,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        List<Place> places = null;
        try {
            places = ownerService.getAllPlacesByOwner(1l);
            modelMap.addAttribute("places", places);
            modelMap.addAttribute("message", "TOTAL " + places.size() + " RECORDS FOUND");
            return "owner-place-list";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return "owner-place-list";
        }
    }

    @RequestMapping("/places/{id}")
    public String getAllPlaces(ModelMap modelMap, @PathVariable long id) {
        Place place = null;
        try {
            place = ownerService.getPlaceByOwner(id, 1l);
            modelMap.addAttribute("place", place);
            return "owner-place-single";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return "owner-place-single";
        }
    }
}