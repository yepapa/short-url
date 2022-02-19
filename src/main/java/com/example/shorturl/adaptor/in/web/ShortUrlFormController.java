package com.example.shorturl.adaptor.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShortUrlFormController {
    @GetMapping("/shortUrlForm")
    public String greeting(Model model) {
        return "shorturlForm";
    }
}
