package com.vitsen.short_url.services;

import com.vitsen.short_url.exceptions.NotRightLinkException;
import com.vitsen.short_url.models.Link;
import com.vitsen.short_url.repo.LinkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LinkService {

    private final LinkRepository repository;

    public List<Link> findAllByLink(String link) {
        Optional<List<Link>> allLinks = repository.findAllByFullUrl(link);

        existByLink(allLinks.isPresent());

        return allLinks.get();
    }

    public String findByLink(String link) {
        Optional<String> firstLink = repository.findFirstByShortUrl(link);

        existByLink(firstLink.isPresent());

        return firstLink.get();
    }

    @Transactional
    public String createShortLink(String link) {
        int defaultRandomInt = 8;
        if (!link.endsWith("/")) link += "/";

        String uniqueValueShortUrl = RandomStringUtils.randomAlphanumeric(defaultRandomInt);
        while (repository.findFirstByShortUrl(uniqueValueShortUrl).isPresent()) {
            uniqueValueShortUrl = RandomStringUtils.randomAlphanumeric(defaultRandomInt);
        }

        Link shortLink = repository.save(new Link(link, uniqueValueShortUrl));
        return shortLink.getShortUrl();
    }

    private void existByLink(boolean oneLink) {
        if (!oneLink) throw new NotRightLinkException();
    }
}
