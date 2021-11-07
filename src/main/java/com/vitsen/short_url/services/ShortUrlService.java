package com.vitsen.short_url.services;

import com.vitsen.short_url.exceptions.NotRightUrlException;
import com.vitsen.short_url.models.Url;
import com.vitsen.short_url.repo.UrlRepository;
import com.vitsen.short_url.utility.UrlMatcherUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShortUrlService {
    private final UrlRepository repository;

    public List<Url> findAllByUrl(String url) {
        return repository.findAllByUrl(url);
    }

    public String findByShortUrl(String fullUrl) {
        return repository.findByShortUrl(fullUrl);
    }

    @Transactional(rollbackFor = Exception.class)
    public String createShortURL(String fullUrl) {
        String uniqueValueShortUrl = createUniqueValueShortUrl();
        boolean b = UrlMatcherUtility.checkUrlMatch(fullUrl);
        if (!b) throw new NotRightUrlException();

        Url save = repository.save(new Url(fullUrl, uniqueValueShortUrl));

        return save.getShortUrl();
    }

    private String createUniqueValueShortUrl() {
        String rand = UUID.randomUUID().toString();

        String[] a = rand.split("-");

        return a[0];
    }
}
