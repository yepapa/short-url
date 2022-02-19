package com.example.shorturl.adaptor.in.web;

import com.example.shorturl.adaptor.in.web.dto.CreateShortUrlRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CreateShortUrlControllerTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("URL 생성 확인")
    @Test
    void createShortUrl(@Autowired MockMvc mvc) throws Exception {
        CreateShortUrlRequest request = new CreateShortUrlRequest("http://naver.com");

        mvc.perform(post("/short-url/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("originUrl").exists())
            .andExpect(jsonPath("shortUrl").exists())
            .andExpect(jsonPath("shortUrlHash").exists())
        ;
    }
}
