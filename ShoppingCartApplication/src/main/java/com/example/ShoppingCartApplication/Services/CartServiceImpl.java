package com.example.ShoppingCartApplication.Services;

import com.example.ShoppingCartApplication.Dao.CartDao;
import com.example.ShoppingCartApplication.Dao.ProductDao;
import com.example.ShoppingCartApplication.Entity.Cart;
import com.example.ShoppingCartApplication.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private  CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getCart() {
        var cart = cartDao.findAll().get(0);
        return cart.getProducts();
    }

    @Override
    public Product getProductById(int productId) {
        var cart = cartDao.findAll().get(0);
        return cart.getProductById(productId).orElse(null);
    }

    @Override
    public Product addProductByID(int productId) {
        var product = productDao.findById(productId).orElse(null);
        return addProduct(product);
    }

    @Override
    public Product addProduct(Product product) {
        var cart = cartDao.findAll().get(0);
        if (product==null)return null;
        cart.addProduct(product);
        cartDao.save(cart);
        return product;
    }

    @Override
    public boolean removeProductById(int productId) {
        var cart = cartDao.findAll().get(0);
        var ret = cart.removeProductById(productId);
        cartDao.save(cart);

        return ret;
    }

    @Override
    public boolean addCart(Cart cart) {
        cartDao.save(cart);
        return true;
    }

    @Override
    public boolean deleteCartById(int cardId) {
        cartDao.deleteById(cardId);
        return true;
    }
}














