package com.assignment.Ecommercebackend.Ecommerce.Controller;

import com.assignment.Ecommercebackend.Ecommerce.Exceptionhandlers.CartException;
import com.assignment.Ecommercebackend.Ecommerce.Service.CartService;
import com.assignment.Ecommercebackend.Ecommerce.Entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> getAllproducts(){
        return ResponseEntity.ok(cartService.getcart());
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/cart/add")
    public ResponseEntity<Cart> AddProduct (@RequestParam int product_ID){
        Cart cart = cartService.AddToCart(product_ID);
        System.out.println("product saved succesffully with data ");
        System.out.println(cart.toString());
        return ResponseEntity.ok(cart);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/cart/remove")
    public ResponseEntity<List<Cart>> RemoveProduct(@RequestParam int product_ID) throws CartException {
        return ResponseEntity.ok(cartService.RemoveFromCart(product_ID));
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/cart/update")
    public void Updatequantity(@RequestParam int product_ID,@RequestParam int quantity) throws CartException {
        cartService.UpdateQuantity(product_ID,quantity);
    }

}
