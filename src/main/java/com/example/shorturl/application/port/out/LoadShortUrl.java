package com.example.shorturl.application.port.out;

import com.example.shorturl.domain.ShortUrl;

public interface LoadShortUrl {
    ShortUrl loadShortUrl(String shortUrlHash);
    ShortUrl loadOriginUrl(String originUrl);
}
