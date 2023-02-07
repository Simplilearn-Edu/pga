package com.simplilearn.pga.controllers;

import com.simplilearn.pga.models.Enquiry;
import com.simplilearn.pga.models.Tenant;
import com.simplilearn.pga.models.Place;
import com.simplilearn.pga.repositories.PlaceRepository;
import com.simplilearn.pga.services.PlaceService;
import com.simplilearn.pga.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/pg")
public class PlaceController {
    @Autowired
    private PlaceService placeService;
    @Autowired
    private TenantService tenantService;

    @RequestMapping("/")
    private String home(ModelMap modelMap) {
        modelMap.addAttribute("pagetitle", "Login");
        modelMap.addAttribute("user", "Tenant");
        return "login";
    }

    @RequestMapping("/login")
    private String login(ModelMap modelMap,
                         HttpServletRequest request,
                         @RequestParam(value = "user_email", required = true) String user_email,
                         @RequestParam(value = "user_password", required = true) String user_password) {
        modelMap.addAttribute("pagetitle", "Login");
        Tenant tenant = tenantService.login(user_email, user_password);
        if (tenant == null) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Invalid Credentials! Please try again.");
            return "login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("tenantId", tenant.getTenantId());
        session.setAttribute("userName", tenant.getTenantName());
        session.setAttribute("user", "pg");
        return "redirect:places";
    }

    @RequestMapping("/places")
    public String getPlaces(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("tenantId") == null) {
            return "redirect:/pg/";
        }
        List<Place> places = null;
        try {
            places = placeService.getAllPlaces();
            modelMap.addAttribute("places", places);
            modelMap.addAttribute("message", "TOTAL " + places.size() + " RECORDS FOUND.");
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
        }
        return "place-list";
    }

    @RequestMapping("/details/{place_id}")
    public String getPlaceDetails(ModelMap modelMap, HttpServletRequest request,
                                  @PathVariable Long place_id) {
        HttpSession session = request.getSession();
        if (session.getAttribute("tenantId") == null) {
            return "redirect:/pg/";
        }
        Tenant tenant = tenantService.getTenant((Long) session.getAttribute("tenantId"));
        Place place = placeService.getPlaceById(place_id);
        Enquiry enquiry = new Enquiry(tenant, place);
        placeService.markEnquiry(enquiry);
        modelMap.addAttribute("place", place);
        return "place-single";
    }

    @RequestMapping("/search")
    public String getPlacesByLocality(ModelMap modelMap, HttpServletRequest request,
                                      @RequestParam("locality") String place_locality) {

        HttpSession session = request.getSession();
        if (session.getAttribute("tenantId") == null) {
            return "redirect:/pg/";
        }
        List<Place> places = null;
        try {
            places = placeService.getPlaceByLocality(place_locality);
            modelMap.addAttribute("places",places);
            modelMap.addAttribute("message", "TOTAL " + places.size() + " RECORDS FOUND.");
            return "place-list";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return "place-list";
        }
    }

    @RequestMapping("/enquiries")
    public String getMyEnquiries(ModelMap modelMap, HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (session.getAttribute("tenantId") == null) {
            return "redirect:/pg/";
        }
        List<Enquiry> enquiries = null;
        try {
            Long tenant_id = (Long) session.getAttribute("tenantId");
            enquiries = placeService.getEnquiries(tenant_id);
            modelMap.addAttribute("enquiries", enquiries);
            modelMap.addAttribute("message", "TOTAL " + enquiries.size() + " RECORDS FOUND.");
            return "enquiry-list";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return "enquiry-list";
        }
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}