package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.converter.ProductConverter;
import com.javatechie.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.javatechie.crud.example.entity.Product;

import java.sql.ClientInfoStatus;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    ProductConverter converter;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product) ;
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProduct();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

//    @GetMapping("/product/{name}")
//    public Product findProductByName(@PathVariable String name){
//        return service.getProductByName(name);
//    }

    @GetMapping("/productByNameAndPrice/{name}/{price}")
    public Product findpricename(@PathVariable String name,@PathVariable double price){
        return service.getproductnameprice(name,price);
    }
//   for Find product by name and id
//    @GetMapping("/productByNameAndId/{name}/{id}")
//    public Product findProductByNameAndId(@PathVariable String name,@PathVariable int id){
//        return service.getProductByNameAndId(name,id);
//    }



    @GetMapping("/product/{name}")
    public List<Product> findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }



    @GetMapping("/productByPrice/{price}")
    public Product findProductByPrice(@PathVariable double price){
        return service.getProductByPrice(price);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
