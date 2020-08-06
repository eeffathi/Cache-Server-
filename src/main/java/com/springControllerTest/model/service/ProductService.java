package com.springControllerTest.model.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springControllerTest.model.entity.Product;
import com.springControllerTest.model.entity.YamlConfig;
import com.springControllerTest.model.repository.ProductCache2KRepository;
import com.springControllerTest.model.repository.ProductRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@ImportResource({"classpath:application*.xml"})
@Service
public class ProductService {
    @Autowired
    ProductRedisRepository productRedisRepository;
    @Autowired
    ProductCache2KRepository productCache2KRepository;
    @Autowired
    YamlConfig yamlConfig;
    String json,StringJson;

    public String FetchJson() {
        if (yamlConfig.getDatabase().equals("redisdb")) {
            if (productRedisRepository.isExisting()) {

                System.out.println("string is getting from redis...");
                json = productRedisRepository.getStringJson();
                return json;
            }

            else {
                StringJson = fetchFromURL();
                System.out.println("string is fetching from url...");

                productRedisRepository.persistToRedis(StringJson);
                System.out.println("persisted to redis...");

            }
        }

        if (yamlConfig.getDatabase().equals("javaCaching")) {
            if (productCache2KRepository.isExisting()) {

                System.out.println("string is getting from cache2k...");
                json = productCache2KRepository.getFromCache2k();
                return json;
            }
            else {
                StringJson = fetchFromURL();
                System.out.println("string is fetching from url...");

                productCache2KRepository.persistToCache2k(StringJson);
                System.out.println("persisted to cache2k...");
            }
        }
        return StringJson;
    }


     public String fetchFromURL() {
         final String uri = "http://185.104.229.164:12561/" +
            "appStore/restAPI/spring/service/getAllProducts?from=0&count=10";
         RestTemplate restTemplate = new RestTemplate();
         HttpHeaders headers = new HttpHeaders();
         headers.set("OSTYPE", "ANDROID");
         HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
         ResponseEntity result = restTemplate.exchange(uri, HttpMethod.GET, entity, byte[].class);

         //converting byte array to string with the right Encoding
         String Json = new String((byte[]) result.getBody(), StandardCharsets.UTF_8);

         return Json;
     }

    public Product[] ConvertJsonToObject (String json) {
        Product [] products = new Product[0];
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            products = objectMapper.readValue(json, Product[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

}




/*****************************************************************************/


//    public void writeIntoJsonFile( String str) {
//
////        String filePath = request.getSession().getServletContext().getRealPath("/")+"WEB-INF/resources/json.json";
//
////        File file = new File(filePath);
////
////        if (!file.exists()){
////            file.mkdirs();
////        }
//
//        try {
////            PrintWriter printWriter = new PrintWriter("D:\\json.json");
//            PrintWriter printWriter = new PrintWriter("C:\\xampp\\htdocs\\products\\json.json");
//
//            printWriter.write(str);
//            printWriter.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////


//public static void main(String[] args) {
//        final String uri = "http://185.104.229.164:12561/" +
//                "appStore/restAPI/spring/service/getAllProducts?from=0&count=10";
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("OSTYPE", "ANDROID");
//        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//        ResponseEntity result = restTemplate.exchange(uri, HttpMethod.GET, entity, byte[].class);
//
//        //converting byte array to string with the right Encoding
//        String StringJson = new String((byte[]) result.getBody(), StandardCharsets.UTF_8);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        Product[] productsFromJson = new Product[0];
//        try {
//            productsFromJson = objectMapper.readValue(StringJson, Product[].class);
//            Arrays.stream(productsFromJson).forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////////////////////////////////////////////////////////
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("OSTYPE", "ANDROID");
//
//        StringBuilder builder = new StringBuilder("http://185.104.229.164:12561/appStore/restAPI/spring/service/getAllProducts?from=0&count=10");
//        RestTemplate restTemplate = new RestTemplate();
//        URI uri = URI.create(builder.toString());
//        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            Product[] productsFromJson = objectMapper.readValue(result.getBody(), Product[].class);
//            Arrays.stream(productsFromJson).forEach(System.out::println);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//



