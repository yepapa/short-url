package com.example.shorturl.adaptor.in.web;

import com.example.shorturl.application.port.in.GetShortUrlUseCase;
import com.example.shorturl.application.port.in.UpdateShortUrlCallCountUseCase;
import com.example.shorturl.domain.ShortUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectShortUrlController {
    private final GetShortUrlUseCase getShortUrlUseCase;
    private final UpdateShortUrlCallCountUseCase updateShortUrlCallCountUseCase;

    public RedirectShortUrlController(GetShortUrlUseCase getShortUrlUseCase, UpdateShortUrlCallCountUseCase updateShortUrlCallCountUseCase) {
        this.getShortUrlUseCase = getShortUrlUseCase;
        this.updateShortUrlCallCountUseCase = updateShortUrlCallCountUseCase;
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirectShortUrl(@PathVariable("shortUrl") String shortUrl) {
        ShortUrl shortUrlInfo = getShortUrlUseCase.getShortUrl(shortUrl);
        updateShortUrlCallCountUseCase.updateShortUrlCallCount(shortUrl);
        return new RedirectView(shortUrlInfo.getOriginUrl());
    }
}
