package com.vitsen.short_url.repo;

import com.vitsen.short_url.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    @Query("FROM Url WHERE fullUrl = :url")
    List<Url> findAllByUrl(@Param("url") String url);

    @Query(value = "SELECT fullUrl FROM Url WHERE shortUrl = :shortUrl")
    String findByShortUrl(@Param("shortUrl") String shortUrl);
}
