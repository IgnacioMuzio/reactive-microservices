package com.im.ms_products.service;

import com.im.ms_products.model.Product;

import java.util.List;

public interface ProductService {

    List <Product> getCatalogue ();

    List <Product> getProductsByCategory(String category);

    Product getProductByCode(Integer code);
    void addProduct (Product product);

    Product deleteProduct (Integer code);
    Product updatePrice (Integer code, Double price);
}
