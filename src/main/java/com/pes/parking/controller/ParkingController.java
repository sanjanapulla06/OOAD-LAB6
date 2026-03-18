package com.pes.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pes.parking.model.Parking;
import com.pes.parking.service.ParkingService;

@Controller
public class ParkingController {

    @Autowired
    private ParkingService service;

    @GetMapping("/")
    public String defaultHome() {
        return "redirect:/PES2UG23CS529";
    }

    @GetMapping("/PES2UG23CS529")
    public String home(Model model) {
        model.addAttribute("parking", new Parking());
        model.addAttribute("list", service.getAll());
        model.addAttribute("srn", "PES2UG23CS529");
        return "index";
    }

    @PostMapping("/PES2UG23CS529/save")
    public String save(@ModelAttribute Parking parking, Model model) {
        try {
            service.saveParking(parking);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("parking", new Parking());
            model.addAttribute("list", service.getAll());
            model.addAttribute("srn", "PES2UG23CS529");
            return "index";
        }
        return "redirect:/PES2UG23CS529";
    }

    @PostMapping("/save")
    public String saveDefault(@ModelAttribute Parking parking) {
        service.saveParking(parking);
        return "redirect:/PES2UG23CS529";
    }
}