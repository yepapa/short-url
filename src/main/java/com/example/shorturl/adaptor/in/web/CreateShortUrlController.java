package com.example.shorturl.adaptor.in.web;

import com.example.shorturl.adaptor.in.web.dto.CreateShortUrlRequest;
import com.example.shorturl.adaptor.in.web.dto.ShortUrlResponse;
import com.example.shorturl.application.port.in.CreateShortUrlUseCase;
import com.example.shorturl.domain.ShortUrl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CreateShortUrlController {
    private final CreateShortUrlUseCase createShortUrlUseCase;

    public CreateShortUrlController(CreateShortUrlUseCase createShortUrlUseCase) {
        this.createShortUrlUseCase = createShortUrlUseCase;
    }

    @PostMapping(value = "/short-url/create")
    public ShortUrlResponse createShortUrl(@Valid @RequestBody CreateShortUrlRequest request) {
        ShortUrl shortUrl = createShortUrlUseCase.createShortUrl(request.getOriginUrl());

        return new ShortUrlResponse(shortUrl.getOriginUrl(), shortUrl.getShortUrl(), shortUrl.getShortUrlHash());
    }
}
