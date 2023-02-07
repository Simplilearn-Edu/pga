package com.simplilearn.pga.controllers;

import com.simplilearn.pga.models.Enquiry;
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
        modelMap.addAttribute("user", "Owner");
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
        session.setAttribute("userName", owner.getOwnerName());
        session.setAttribute("user", "owner");

        return "redirect:places";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

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
            return "redirect:/owner/";
        }
        long ownerId = (Long) session.getAttribute("ownerId");
        Owner owner = ownerService.getOwner(ownerId);
        Place place = new Place(place_name, place_address, place_city, place_rent, true, owner);
        ownerService.addPlace(place);
        return "redirect:/owner/places";
    }

    @RequestMapping("/places/edit-place/{place_id}")
    public String editPlaces(ModelMap modelMap, HttpServletRequest request, @PathVariable Long place_id) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        String[] cities = {"Delhi", "Mumbai", "Pune", "Bengaluru", "Hyderabad", "Chennai", "Surat"};
        modelMap.addAttribute("cities", cities);
        long ownerId = (Long) session.getAttribute("ownerId");

        Place place = ownerService.getPlaceByOwner(place_id, ownerId);
        modelMap.addAttribute("place", place);
        return "edit-place";
    }

    @RequestMapping("/places/edit")
    public String addPlaces(ModelMap modelMap, HttpServletRequest request,
                            @RequestParam("place_id") Long place_id,
                            @RequestParam("place_name") String place_name,
                            @RequestParam("place_address") String place_address,
                            @RequestParam("place_city") String place_city,
                            @RequestParam("place_rent") int place_rent,
                            @RequestParam("place_status") boolean place_status) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        long ownerId = (Long) session.getAttribute("ownerId");
        Owner owner = ownerService.getOwner(ownerId);
        Place place = new Place(place_id, place_name, place_address, place_city, place_rent, place_status, owner);
        ownerService.addPlace(place);
        return "redirect:/owner/places";
    }

    @RequestMapping("/places/delete/{placeId}")
    public String deletePlaces(ModelMap modelMap, HttpServletRequest request,
                               @PathVariable("placeId") Long place_id) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        long ownerId = (Long) session.getAttribute("ownerId");
        Place place = ownerService.getPlaceByOwner(place_id, 1l);

        if (place.isPlaceStatus()) {
            ownerService.deletePlace(place_id);
            return "redirect:/owner/places";
        }
        modelMap.addAttribute("error", true);
        modelMap.addAttribute("message", "Occupied place cannot be deleted");
        return "owner-place-list";
    }

    @RequestMapping("/places")
    public String getAllPlaces(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        List<Place> places = null;
        try {
            long ownerId = (Long) session.getAttribute("ownerId");
            places = ownerService.getAllPlacesByOwner(ownerId);
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
    public String getAllPlaces(ModelMap modelMap, HttpServletRequest request, @PathVariable long id) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        Place place = null;

        try {
            long ownerId = (Long) session.getAttribute("ownerId");
            place = ownerService.getPlaceByOwner(id, ownerId);
            modelMap.addAttribute("place", place);
            return "owner-place-single";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return "owner-place-single";
        }
    }

    @RequestMapping("/enquiries")
    public String getAllEnquiries(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        long ownerId = (Long) session.getAttribute("ownerId");
        try {
            List<Enquiry> enquiries = ownerService.getEnquiries(ownerId);
            modelMap.addAttribute("enquiries", enquiries);
            modelMap.addAttribute("message", "TOTAL "+enquiries.size()+" ENQUIRIES FOUND.");
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
        }
        return "owner-enquiry-list";
    }
}