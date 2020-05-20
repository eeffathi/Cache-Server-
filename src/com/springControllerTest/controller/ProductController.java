package com.springControllerTest.controller;

import com.springControllerTest.model.entity.Product;
import com.springControllerTest.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/getAllProducts")
    public String getAllProducts(HttpServletRequest request) {
        String json = productService.FetchJson();

        String jsonstring = "{ products : "+ json + " } ";

        Product [] products = productService.ConvertJsonToObject(json);

        request.setAttribute("jsonstring",jsonstring);
        request.setAttribute("list",products);

        return "index";
    }

}

