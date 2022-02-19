package com.example.shorturl.common;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AppConfig {
    private String prefixShortUrl = "http://localhost/";
}
