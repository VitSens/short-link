package com.vitsen.short_url.controllers;

import com.vitsen.short_url.models.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class ShortURLController {
    private ShortURLService shortUrlService;

    @Autowired
    public ShortURLController(ShortURLService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }


    @PostMapping()
    public URL createShortURL(@RequestParam String fullUrl) {
        return shortUrlService.createShortURL(fullUrl);
    }
}
