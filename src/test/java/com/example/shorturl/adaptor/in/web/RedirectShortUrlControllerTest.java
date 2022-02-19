package com.example.shorturl.adaptor.in.web;

import com.example.shorturl.adaptor.in.web.dto.CreateShortUrlRequest;
import com.example.shorturl.adaptor.in.web.dto.ShortUrlResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RedirectShortUrlControllerTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("rediect 확인")
    @Test
    void redirectShortUrl(@Autowired MockMvc mvc) throws Exception {
        CreateShortUrlRequest request = new CreateShortUrlRequest("http://naver.com");

        MvcResult mvcResult = mvc.perform(post("/short-url/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andReturn();

        ShortUrlResponse shortUrlResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ShortUrlResponse.class);

        mvc.perform(get("/" + shortUrlResponse.getShortUrlHash())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is3xxRedirection());
    }
}
