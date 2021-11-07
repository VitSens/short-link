package com.vitsen.short_url.controllers;

import com.vitsen.short_url.models.Url;
import com.vitsen.short_url.services.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shortlink")
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @GetMapping
    public ResponseEntity<List<Url>> findAllByUrl(@RequestParam String url) {
        return ResponseEntity.ok(shortUrlService.findAllByUrl(url));
    }

    @PostMapping
    public ResponseEntity<String> createShortUrl(@RequestBody String url) {
        return ResponseEntity.ok(shortUrlService.createShortURL(url));
    }
}
