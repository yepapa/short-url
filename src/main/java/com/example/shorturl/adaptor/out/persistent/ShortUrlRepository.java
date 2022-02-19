package com.example.shorturl.adaptor.out.persistent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {
    ShortUrlEntity findByOriginUrl(String originUrl);
    ShortUrlEntity findByShortUrlHash(String shortUrlHash);
}
