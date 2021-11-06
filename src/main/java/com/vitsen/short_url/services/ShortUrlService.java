package com.vitsen.short_url.services;

import com.vitsen.short_url.models.Url;
import com.vitsen.short_url.repo.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShortUrlService {
    private final UrlRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public Url createShortURL(String fullUrl) {
        return null;
    }
}
