package com.wwt.cache.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CecheController {

    @RequestMapping("/cache")
    public String getCache() {
        return "welcome";
    }
}
