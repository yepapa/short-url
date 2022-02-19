package com.example.shorturl.application.port.in;

import com.example.shorturl.domain.ShortUrl;

public interface UpdateShortUrlCallCountUseCase {

    ShortUrl updateShortUrlCallCount(String shortUrlHash);
}
