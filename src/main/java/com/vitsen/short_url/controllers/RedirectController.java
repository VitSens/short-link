package com.vitsen.short_url.controllers;

import com.vitsen.short_url.services.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class RedirectController {
    private final ShortUrlService service;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectFromShortUrl(@PathVariable(name = "shortUrl") String url) {
        String shortUrl = service.findByShortUrl(url);
        shortUrl = shortUrl.replaceAll("^\"+|\"+$", "");

        return ResponseEntity.status(302)
                .location(URI.create(shortUrl))
                .build();
    }
}
