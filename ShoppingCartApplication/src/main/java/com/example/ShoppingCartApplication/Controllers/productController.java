package com.example.ShoppingCartApplication.Controllers;


import com.example.ShoppingCartApplication.Dao.UserDao;
import com.example.ShoppingCartApplication.Entity.Cart;
import com.example.ShoppingCartApplication.Entity.Product;
import com.example.ShoppingCartApplication.Entity.User;
import com.example.ShoppingCartApplication.Services.CartService;
import com.example.ShoppingCartApplication.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {

    @Autowired
    public ProductService productService;

    @Autowired
    private CartService cartService;

@Autowired
private UserDao userDao;

    //    Mapping this url with this method needs to be done so
//    this url  invokes this method
    @RequestMapping("/")
    public String home() {

        return "<HTML><H1>Welcome to On-Line Cart Application</H1></HTML>";
    }

    @GetMapping("/Products")
    public List<Product> getProducts() {

        return this.productService.getAllProducts();
    }

    //All parameters in the url are in the string format
//converting the string above in integer type
    @GetMapping("/Product/{productID}")
    public Product getProduct(@PathVariable String productID) {

        return this.productService.getProductsById(Integer.parseInt(productID));

    }

    //this is going to request the html body for the course
    @PostMapping("/Product")
    public Product addProduct(@RequestBody Product product) {

        return this.productService.addProducts(product);
    }
    @PutMapping("/Product")
    public Product updateProduct(@RequestBody Product product) {


        return this.productService.updateProducts(product);
    }


    @DeleteMapping("/Product/{productID}")
    public boolean deleteProduct(@PathVariable String productID) {

        return this.productService.deleteProduct(Integer.parseInt(productID));
    }

    @GetMapping("/cart")
    public List<Product> getCart() {

        return cartService.getCart();
    }

    @GetMapping("/cart/{productId}")
    public Product getCart(@PathVariable String productId) {

        try {
            return cartService.getProductById(Integer.parseInt(productId));
        } catch (NumberFormatException e) {
            System.out.println("Not a valid product Id");
            return null;
        }
    }

    @PutMapping("/cart/{productId}")
    public Product addToCart(@PathVariable String productId) {
        try {
            return cartService.addProductByID(Integer.parseInt(productId));
        } catch (NumberFormatException e) {
            System.out.println("Not a valid product Id");
            return null;
        }
    }
    @PutMapping("/cart/remove/{productId}")
    public boolean removeFromCart (@PathVariable String productId){
        try {
            return cartService.removeProductById(Integer.parseInt(productId));
        } catch (NumberFormatException e) {
            System.out.println("Not a valid product Id");
            return false;
        }
    }
    @PostMapping("/user")
    public boolean createUser(@RequestBody Cart cart){
        userDao.save(new User(cart));
        return true;
    }
    @DeleteMapping("/user")
    public boolean deleteUser(){
     var user  = userDao.findAll().get(0);
     userDao.delete(user);
     return true;
    }
}











