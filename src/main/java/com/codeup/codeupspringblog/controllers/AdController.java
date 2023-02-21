package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class AdController {

    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }
    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ad";
    }

    @GetMapping("/ads/{title}")
    public String adShow(@PathVariable String title, Model model){
        model.addAttribute("title", adDao.findByTitle(title));
        return "adsShow";
    }
}

