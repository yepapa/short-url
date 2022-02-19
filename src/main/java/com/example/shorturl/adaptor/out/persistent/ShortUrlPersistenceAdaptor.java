package com.example.shorturl.adaptor.out.persistent;

import com.example.shorturl.application.port.out.LoadShortUrl;
import com.example.shorturl.application.port.out.SaveShortUrl;
import com.example.shorturl.domain.ShortUrl;
import org.springframework.stereotype.Component;

@Component
class ShortUrlPersistenceAdaptor implements SaveShortUrl, LoadShortUrl {
    private final ShortUrlRepository shortUrlRepository;
    private final ShortUrlMapper shortUrlMapper;

    public ShortUrlPersistenceAdaptor(ShortUrlRepository shortUrlRepository, ShortUrlMapper shortUrlMapper) {
        this.shortUrlRepository = shortUrlRepository;
        this.shortUrlMapper = shortUrlMapper;
    }

    @Override
    public ShortUrl saveShortUrl(ShortUrl shortUrl) {
        ShortUrlEntity savedShortUrl = this.shortUrlRepository.save(shortUrlMapper.toShortUrlEntity(shortUrl));
        return this.shortUrlMapper.toShortUrl(savedShortUrl);
    }

    @Override
    public ShortUrl loadShortUrl(String shortUrlHash) {
        return shortUrlMapper.toShortUrl(shortUrlRepository.findByShortUrlHash(shortUrlHash));
    }

    @Override
    public ShortUrl loadOriginUrl(String originUrl) {
        ShortUrlEntity shortUrl = shortUrlRepository.findByOriginUrl(originUrl);
        if (shortUrl == null) {
            return null;
        }

        return shortUrlMapper.toShortUrl(shortUrl);
    }
}
