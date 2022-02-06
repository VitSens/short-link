package com.vitsen.short_url.repo;

import com.vitsen.short_url.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    Optional<List<Link>> findAllByFullUrl(String url);

    Optional<String> findFirstByShortUrl(String url);
}
