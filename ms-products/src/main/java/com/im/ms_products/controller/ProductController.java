package com.im.ms_products.controller;

import com.im.ms_products.model.Product;
import com.im.ms_products.service.ProductService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getCatalogue(){
        return new ResponseEntity<>(productService.getCatalogue(),HttpStatus.OK);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category){
        return new ResponseEntity<>(productService.getProductsByCategory(category),HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Product> getProductByCode(@PathVariable("code") Integer code){
        return new ResponseEntity<>(productService.getProductByCode(code),HttpStatus.OK);
    }

    @PostMapping("add-product")
    public ResponseEntity<Void> addProduct (@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("delete-product")
    public ResponseEntity<Product> deleteProductByCode (@RequestParam("code") Integer code){
        return new ResponseEntity<>(productService.deleteProduct(code),HttpStatus.OK);
    }

    @PutMapping("update-product")
    public ResponseEntity<Product> updateProductPriceByCode (@RequestParam("code") Integer code, @RequestParam("price") Double price){
        return new ResponseEntity<>(productService.updatePrice(code,price),HttpStatus.OK);
    }
}
