package com.example.ShoppingCartApplication.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int cartID;

    @OneToMany(cascade = CascadeType.ALL)
    private  List<Product> listOfProduct;

    public Cart() {
    }

    public Cart(List<Product> products) {
        this.listOfProduct = products;
    }

    public void addProduct(Product product){
        listOfProduct.add(product);

    }
    public Optional<Product> getProductById(int productId){

        return listOfProduct.stream().filter(p->p.getProductID()==productId).findFirst();
    }
    public boolean removeProductById(int productId){
        var product =listOfProduct.stream().filter(p->p.getProductID()==productId).findFirst().orElse(null);
        if(product==null)return false;
        return removeProduct(product);
    }
    public boolean removeProduct(Product product){
        if (!listOfProduct.contains(product))return false;
        return listOfProduct.remove(product);
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public List<Product> getProducts() {
        return listOfProduct;
    }

    public void setListOfProduct(List<Product> listOfProduct) {
        this.listOfProduct = listOfProduct;
    }
}
