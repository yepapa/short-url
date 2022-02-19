package com.example.shorturl.application.service;

import com.example.shorturl.application.port.in.GetShortUrlUseCase;
import com.example.shorturl.application.port.out.LoadShortUrl;
import com.example.shorturl.domain.ShortUrl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetShortUrlService implements GetShortUrlUseCase {
    private final LoadShortUrl loadShortUrl;

    public GetShortUrlService(LoadShortUrl loadShortUrl) {
        this.loadShortUrl = loadShortUrl;
    }

    @Override
    @Transactional(readOnly = true)
    public ShortUrl getShortUrl(String shortUrlHash) {
        return loadShortUrl.loadShortUrl(shortUrlHash);
    }
}
