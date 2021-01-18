package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProduct() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
    public Product getProductByPrice(double price) {
        return repository.findByPrice(price);
    }
    public Product getproductnameprice(String name,double price){
        return repository.findpricename(name,price);
    }

    public List<Product> getProductByName(String name){
        List<Product> Productlist = repository.findByName(name);
        return Productlist;
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product Removed" + id;
    }
    public Product  updateProduct(Product product){
      Product existingProduct=repository.findById(product.getId()).orElse(null);
      existingProduct.setName(product.getName()) ;
      existingProduct.setQuantity(product.getQuantity());
      existingProduct.setPrice(product.getPrice());
      return repository.save(existingProduct);

    }
}