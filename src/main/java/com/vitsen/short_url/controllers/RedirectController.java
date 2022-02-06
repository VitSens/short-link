package com.vitsen.short_url.controllers;

import com.vitsen.short_url.services.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class RedirectController {
    private final LinkService service;

    @GetMapping("/{link}")
    public ResponseEntity<Void> redirect(@PathVariable(name = "link") String link) {
        String redirectLink = service.findByLink(link);

        return ResponseEntity.status(302)
                .location(URI.create(redirectLink))
                .build();
    }
}
