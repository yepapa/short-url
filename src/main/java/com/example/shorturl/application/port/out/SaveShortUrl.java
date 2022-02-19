package com.example.shorturl.application.port.out;

import com.example.shorturl.domain.ShortUrl;

public interface SaveShortUrl {
    ShortUrl saveShortUrl(ShortUrl shortUrl);
}
