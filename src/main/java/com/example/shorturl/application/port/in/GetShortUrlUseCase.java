package com.example.shorturl.application.port.in;

import com.example.shorturl.domain.ShortUrl;

public interface GetShortUrlUseCase {

    ShortUrl getShortUrl(String shortUrlHash);
}
