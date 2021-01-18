package com.javatechie.crud.example.converter;


import com.javatechie.crud.example.dto.ProductDto;
import com.javatechie.crud.example.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDto entityToDto(Product product){

        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setQuantity(product.getQuantity());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public Product dtoTOEntity(ProductDto dto){

        Product p = new Product();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setQuantity(dto.getQuantity());
        p.setPrice(dto.getPrice());
        return p;
    }

}
