package com.example.ShoppingCartApplication.Services;

import com.example.ShoppingCartApplication.Entity.Cart;
import com.example.ShoppingCartApplication.Entity.Product;

import java.util.List;

public interface CartService {

    List<Product> getCart();
    Product getProductById(int productId);
    Product addProductByID(int productId );
    Product addProduct(Product product);
    boolean removeProductById(int productId);
    boolean addCart(Cart cart);
    boolean deleteCartById(int cardId);
}
