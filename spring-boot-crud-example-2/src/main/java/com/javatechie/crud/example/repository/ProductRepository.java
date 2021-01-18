package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface ProductRepository  extends JpaRepository<Product,Integer> {
    List<Product> findByName(String name);
    Product findByPrice(double price);


    @Query( value = "SELECT p.* FROM Product p WHERE p.name = ?1 AND p.price = ?2",nativeQuery = true)
   Product findpricename(String name,double price);
}

//findpricename call in service

//JPA orm rea
//dto=productdto