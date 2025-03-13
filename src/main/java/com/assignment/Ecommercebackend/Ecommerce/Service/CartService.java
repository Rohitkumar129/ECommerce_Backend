package com.assignment.Ecommercebackend.Ecommerce.Service;

import com.assignment.Ecommercebackend.Ecommerce.Exceptionhandlers.CartException;
import com.assignment.Ecommercebackend.Ecommerce.Entity.Cart;
import com.assignment.Ecommercebackend.Ecommerce.Repository.CartRepo;
import com.assignment.Ecommercebackend.Ecommerce.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepo cartRepo;
    private final ProductRepo productRepo;
    @Autowired
    public CartService(CartRepo cartRepo, ProductRepo productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    public List<Cart> getcart(){
        return cartRepo.findAll();

    }

    public Cart AddToCart(int product_ID)  {
        Cart cart=null;
        if(cartRepo.existsById(product_ID)) {
            Optional<Cart> c=cartRepo.findById(product_ID);
            if(c.isPresent()){
                 cart=c.get();
               int previousquantity=cart.getQuantity();
               cart.setQuantity(previousquantity+1);
                cartRepo.save(cart);
            }
        }
        else {
             cart = new Cart(product_ID, 1);
            cart = cartRepo.save(cart);
            cart.setProduct(productRepo.findById(product_ID).isPresent() ? productRepo.findById(product_ID).get() : cart.getProduct());
        }
        return cart;

    }

    public List<Cart> RemoveFromCart(int product_ID) throws CartException {
        if(cartRepo.existsById(product_ID)) cartRepo.deleteById(product_ID);
        else throw new CartException("There is no such product in the cart to remove");
        return cartRepo.findAll();
    }

    public void UpdateQuantity(int product_ID,int quantity) throws CartException {
        if(cartRepo.existsById(product_ID)&&quantity>0){
            Optional<Cart> cartOptional=cartRepo.findById(product_ID);
            if(cartOptional.isPresent()){
                Cart cart=cartOptional.get();
                cart.setQuantity(quantity);
                cartRepo.save(cart);
            }
        }
        else if(!cartRepo.existsById(product_ID)&&quantity<0)throw new CartException("There is no such product in the cart to update quantity and provided quantity should be more than 0");
        else if(quantity<0) throw new CartException("Quantity should be greater than 0");
        else throw new CartException("There is no such product in the cart to update quantity");
    }



}
