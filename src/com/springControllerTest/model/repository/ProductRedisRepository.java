package com.springControllerTest.model.repository;

import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Repository
public class ProductRedisRepository {
//    JedisCluster jc = RedisObj.getJedisCluster();

    Jedis jedis = new Jedis("localhost");

    public String getStringJson() {
        return jedis.get("pr");
    }

    public void persistToRedis (String stringJson) {
        jedis.set("pr", stringJson);
        jedis.expire("pr", 7200);
    }

    public boolean isExisting() {
        if(jedis.exists("pr"))
            return true;
        return false;
    }

}










/********************************************************

String StringJson = null;
        if(jc.exists("pr")){
                StringJson = jc.get("pr");
                }
                else{
                ProductService productService = new ProductService();
                StringJson = productService.FetchJsonFromURL();
                jc.set("pr", StringJson);
                jc.expire("pr", 7200);

                }
                ObjectMapper objectMapper = new ObjectMapper();
                Product[] productsFromJson = new Product[0];
                try {
                productsFromJson = objectMapper.readValue(StringJson, Product[].class);
        } catch (IOException e) {
        e.printStackTrace();
        }

        return productsFromJson;
***/