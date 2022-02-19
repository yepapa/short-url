package com.example.shorturl.adaptor.out.persistent;

import com.example.shorturl.common.AppConfig;
import com.example.shorturl.common.exception.UrlNotFoundException;
import com.example.shorturl.domain.ShortUrl;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlMapper {
    private final AppConfig appConfig;

    public ShortUrlMapper(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public ShortUrl toShortUrl(ShortUrlEntity shortUrlEntity) {

        if (shortUrlEntity == null) {
            throw new UrlNotFoundException();
        }

        ShortUrl shortUrl = new ShortUrl(shortUrlEntity.getOriginUrl()
            , appConfig.getPrefixShortUrl() + shortUrlEntity.getShortUrlHash()
            , shortUrlEntity.getShortUrlHash()
            , shortUrlEntity.getCallCount());

        return shortUrl;
    }

    public ShortUrlEntity toShortUrlEntity(ShortUrl shortUrl) {
        ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
        shortUrlEntity.setOriginUrl(shortUrl.getOriginUrl());
        shortUrlEntity.setShortUrlHash(shortUrl.getShortUrlHash());

        return shortUrlEntity;
    }
}
