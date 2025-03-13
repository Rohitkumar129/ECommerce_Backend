package com.assignment.Ecommercebackend.Ecommerce.Repository;

import com.assignment.Ecommercebackend.Ecommerce.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
}
