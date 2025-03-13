package com.assignment.Ecommercebackend.Ecommerce.Service;

import com.assignment.Ecommercebackend.Ecommerce.Entity.Productdetails;
import com.assignment.Ecommercebackend.Ecommerce.Exceptionhandlers.ProductException;
import com.assignment.Ecommercebackend.Ecommerce.Repository.ProductdetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductdetailsService {
    private final ProductdetailsRepo productdetailsRepo;
    @Autowired

    public ProductdetailsService(ProductdetailsRepo productdetailsRepo) {
        this.productdetailsRepo = productdetailsRepo;
    }

    public Optional<Productdetails> getmoredetails(int product_ID) throws ProductException {
        if(!productdetailsRepo.existsById(product_ID))throw new ProductException("No such product exists");
        return productdetailsRepo.findById(product_ID);
       // else throw new("No such product exists")  ;
    }
}
