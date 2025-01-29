package com.assignment.Ecommercebackend.Ecommerce.Service;

//import org.apache.el.stream.Optional;
import com.assignment.Ecommercebackend.Ecommerce.Entity.Product;
import com.assignment.Ecommercebackend.Ecommerce.Exceptionhandlers.ProductException;
import com.assignment.Ecommercebackend.Ecommerce.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    @Autowired

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public List<Product> getalldetails(){
        return productRepo.findAll();
    }
    public Optional<Product> GetProduct(Product product) throws ProductException {
        if(!productRepo.existsById(product.getProduct_ID())) throw new ProductException("There is no such product available");
        return productRepo.findById(product.getProduct_ID());
    }
    public List<Product> searchProductsByName(String name) {
        return productRepo.findByNameContainingIgnoreCase(name);
    }
}


