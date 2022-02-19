package com.example.shorturl.application.service;

import com.example.shorturl.application.port.in.CreateShortUrlUseCase;
import com.example.shorturl.application.port.out.LoadShortUrl;
import com.example.shorturl.application.port.out.SaveShortUrl;
import com.example.shorturl.domain.ShortUrl;
import com.example.shorturl.util.Base62Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateShortUrlService implements CreateShortUrlUseCase {
    private final SaveShortUrl saveShortUrl;
    private final LoadShortUrl loadShortUrl;

    public CreateShortUrlService(SaveShortUrl saveShortUrl, LoadShortUrl loadShortUrl) {
        this.saveShortUrl = saveShortUrl;
        this.loadShortUrl = loadShortUrl;
    }

    @Override
    @Transactional
    public ShortUrl createShortUrl(String originUrl) {

        ShortUrl shortUrl = loadShortUrl.loadOriginUrl(originUrl);
        if (shortUrl == null) {
            // TODO 분산 시스템 환경에서 snowflake id와 같은 값으로 변경이 되어야 됨.
            String shortUrlHash = Base62Utils.encodeToLong(System.currentTimeMillis());

            ShortUrl newShortUrl = new ShortUrl(originUrl, null, shortUrlHash, 0);

            return saveShortUrl.saveShortUrl(newShortUrl);
        }

        return shortUrl;
    }
}
