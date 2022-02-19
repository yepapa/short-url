package com.example.shorturl.adaptor.out.persistent;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ShortUrlEntity {

    @Id
    @GeneratedValue
    private long id;

    private String originUrl;

    private String shortUrlHash;

    private int callCount;
}
