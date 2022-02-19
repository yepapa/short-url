package com.example.shorturl.application.service;

import com.example.shorturl.application.port.in.UpdateShortUrlCallCountUseCase;
import com.example.shorturl.application.port.out.LoadShortUrl;
import com.example.shorturl.application.port.out.SaveShortUrl;
import com.example.shorturl.common.exception.UrlNotFoundException;
import com.example.shorturl.domain.ShortUrl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateShortUrlCallCountService implements UpdateShortUrlCallCountUseCase {
    private final SaveShortUrl saveShortUrl;
    private final LoadShortUrl loadShortUrl;

    public UpdateShortUrlCallCountService(SaveShortUrl saveShortUrl, LoadShortUrl loadShortUrl) {
        this.saveShortUrl = saveShortUrl;
        this.loadShortUrl = loadShortUrl;
    }

    @Override
    @Transactional
    public ShortUrl updateShortUrlCallCount(String shortUrlHash) {

        ShortUrl shortUrl = loadShortUrl.loadShortUrl(shortUrlHash);
        if (shortUrl == null) {
            throw new UrlNotFoundException();
        }

        shortUrl = shortUrl.incrementCallCount();

        return saveShortUrl.saveShortUrl(shortUrl);
    }
}
