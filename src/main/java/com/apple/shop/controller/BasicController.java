package com.apple.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class BasicController {
    @GetMapping("/")
    public String index(Model model){
        LocalDate now = LocalDate.now();
        model.addAttribute("now", now);
        return"index";
    }




}
