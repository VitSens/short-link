package com.vitsen.short_url.services;

import com.vitsen.short_url.exceptions.NotRightUrlException;
import com.vitsen.short_url.models.Url;
import com.vitsen.short_url.repo.UrlRepository;
import com.vitsen.short_url.utility.UrlMatcherUtility;
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
    public String createShortURL(String fullUrl) {
        boolean b = UrlMatcherUtility.checkUrlMatch(fullUrl);
        if (!b) throw new NotRightUrlException();

        Url save = repository.save(new Url(fullUrl, "w4324324"));

        return save.getShortUrl();
    }
}
