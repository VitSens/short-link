package com.vitsen.short_url.controllers;

import com.vitsen.short_url.models.Url;
import com.vitsen.short_url.services.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shortlink")
@RequiredArgsConstructor
public class ShortUrlController {
    private final ShortUrlService shortUrlService;


    @PostMapping
    public Url createShortUrl(@RequestParam String url) {
        return shortUrlService.createShortURL(url);
    }
}
