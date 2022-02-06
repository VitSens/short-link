package com.vitsen.short_url.controllers;

import com.vitsen.short_url.models.Link;
import com.vitsen.short_url.services.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shortlink")
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @GetMapping
    public ResponseEntity<List<Link>> findAllByUrl(@RequestParam String url) {
        return ResponseEntity.ok(linkService.findAllByLink(url));
    }

    @PostMapping
    public ResponseEntity<String> createShortUrl(@RequestBody String url) {
        return ResponseEntity.ok(linkService.createShortLink(url));
    }
}
