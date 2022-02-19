package com.example.shorturl.adaptor.in.web;

import com.example.shorturl.adaptor.in.web.dto.ShortUrlResponse;
import com.example.shorturl.application.port.in.GetShortUrlUseCase;
import com.example.shorturl.domain.ShortUrl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetShortUrlController {
    private final GetShortUrlUseCase getShortUrlUseCase;

    public GetShortUrlController(GetShortUrlUseCase getShortUrlUseCase) {
        this.getShortUrlUseCase = getShortUrlUseCase;
    }

    @GetMapping("/short-url/{shortUrlHash}")
    public ShortUrlResponse getShortUrl(@PathVariable("shortUrlHash") String shortUrlHash) {

        ShortUrl shortUrl = getShortUrlUseCase.getShortUrl(shortUrlHash);

        return new ShortUrlResponse(shortUrl.getOriginUrl(), shortUrl.getShortUrl(), shortUrl.getShortUrlHash());
    }
}
