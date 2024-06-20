package com.burgertracker.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.burgertracker.burgertracker.models.Burger;
import com.burgertracker.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

    @Autowired
     BurgerService burgerService;

    @GetMapping("/")
    public String index(Model model) {
        List<Burger> burgers = burgerService.findAll();
        model.addAttribute("burgers", burgers);
        model.addAttribute("burger", new Burger());
        return "index.jsp";
    }

    @PostMapping("/burgers")
    public String addBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Burger> burgers = burgerService.findAll();
            model.addAttribute("burgers", burgers);
            return "index.jsp";
        }
        burgerService.save(burger);
        return "redirect:/burgers";
    }
}

