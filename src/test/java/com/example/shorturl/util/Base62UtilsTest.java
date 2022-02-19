package com.example.shorturl.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base62UtilsTest {

    @Test
    void encodeToLong() {
        String shortUrl = Base62Utils.encodeToLong(System.currentTimeMillis());
        System.out.println(shortUrl);
    }
}
