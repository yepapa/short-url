package com.example.shorturl.adaptor.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortUrlResponse {
    private String originUrl;
    private String shortUrl;
    private String shortUrlHash;
}
