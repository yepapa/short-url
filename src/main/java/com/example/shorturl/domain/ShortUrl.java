package com.example.shorturl.domain;

import lombok.Value;

@Value
public class ShortUrl {
    private String originUrl;
    private String shortUrl;
    private String shortUrlHash;
    private int callCount;

    public ShortUrl incrementCallCount() {
        int callCount = this.callCount + 1;
        return new ShortUrl(this.originUrl, this.shortUrl, this.shortUrlHash, callCount);
    }
}
