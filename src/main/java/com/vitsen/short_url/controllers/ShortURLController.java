package com.vitsen.short_url.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class ShortURLController {
    private ShortURLService shortURLService;

    @Autowired
    public ShortURLController(ShortURLService shortURLService) {
        this.shortURLService = shortURLService;
    }


    @PostMapping()
    public URL createShortURL(@RequestParam String fullUrl) {
        return shortURLService.createShortURL(fullUrl);
    }
}
