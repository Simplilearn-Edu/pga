package com.simplilearn.pga.controllers;

import com.simplilearn.pga.models.Place;
import com.simplilearn.pga.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(path = "/pg")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @RequestMapping("/")
    public String getPlaces(ModelMap modelMap) {
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
    public String getPlaceDetails(ModelMap modelMap,
                                  @PathVariable Long place_id) {

        Place place = placeService.getPlaceById(place_id);
        modelMap.addAttribute("place", place);
        return "place-single";
    }

    @RequestMapping("/search")
    public List<Place> getPlacesByLocality(ModelMap modelMap,
                                           @RequestParam("locality") String place_locality) {

        List<Place> places = null;
        try {
            places = placeService.getPlaceByLocality(place_locality);
            return places;
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "NO DATA FOUND");
            return places;
        }
    }
}