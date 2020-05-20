package com.springControllerTest.model.repository;

import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;
@Repository
public class ProductCache2KRepository {
    Cache<String,String> cache = new Cache2kBuilder<String, String>() {}
            .expireAfterWrite(7200, TimeUnit.SECONDS)
                .build();


    public void persistToCache2k (String stringJson) {
        cache.put("pr", stringJson);
    }


    public String getFromCache2k () {
        return cache.get("pr");

    }

    public boolean isExisting() {
        if(cache.containsKey("pr"))
            return true;
        return false;
    }

}
