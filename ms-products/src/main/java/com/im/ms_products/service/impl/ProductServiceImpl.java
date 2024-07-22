package com.im.ms_products.service.impl;

import com.im.ms_products.model.Product;
import com.im.ms_products.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static List<Product> products = new ArrayList<>(List.of(
            new Product(100, "Azucar", "Alimentación", 1.10, 20),
            new Product(101, "Leche", "Alimentación", 1.20, 15),
            new Product(102, "Jabón", "Limpieza", 0.89, 30),
            new Product(103, "Mesa", "Hogar", 125.0, 4),
            new Product(104, "Televisión", "Hogar", 650.0, 10),
            new Product(105, "Huevos", "Alimentación", 2.20, 30),
            new Product(106, "Fregona", "Limpieza", 3.40, 6),
            new Product(107, "Detergente", "Limpieza", 8.7, 12)
    ));

    @Override
    public List<Product> getCatalogue() {
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return products.stream().filter(product -> product.getCategory().equals(category)).toList();
    }

    @Override
    public Product getProductByCode(Integer code) {
        return products.stream().filter(product -> product.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public void addProduct(Product product) {
        if(getProductByCode(product.getCode()) == null ){
            products.add(product);
        }
    }

    @Override
    public Product deleteProduct(Integer code) {
        Product product = getProductByCode(code);

        if(product != null){
            products.removeIf(p -> p.getCode().equals(code));
        }

        return product;
    }

    @Override
    public Product updatePrice(Integer code, Double price) {
        Product product = getProductByCode(code);

        if(product != null){
            product.setPrice(price);
        }

        return product;
    }
}
