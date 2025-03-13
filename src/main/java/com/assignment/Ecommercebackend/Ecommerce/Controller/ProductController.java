package com.assignment.Ecommercebackend.Ecommerce.Controller;

import com.assignment.Ecommercebackend.Ecommerce.Entity.Product;
import com.assignment.Ecommercebackend.Ecommerce.Entity.Productdetails;
import com.assignment.Ecommercebackend.Ecommerce.Exceptionhandlers.ProductException;
import com.assignment.Ecommercebackend.Ecommerce.Service.ProductService;
import com.assignment.Ecommercebackend.Ecommerce.Service.ProductdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    private final ProductdetailsService productdetailsService;

    @Autowired
    public ProductController(ProductService productService, ProductdetailsService productdetailsService) {
        this.productService = productService;
        this.productdetailsService = productdetailsService;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getalldetails());
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/product")
    public ResponseEntity<Optional<Productdetails>> getproduct(@RequestParam int product_ID) throws ProductException {
        return ResponseEntity.ok(productdetailsService.getmoredetails(product_ID));

    }
    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String name) {
        return productService.searchProductsByName(name);
    }
}

