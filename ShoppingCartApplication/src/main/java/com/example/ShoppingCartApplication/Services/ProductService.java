package com.example.ShoppingCartApplication.Services;


import com.example.ShoppingCartApplication.Entity.Apparel;
import com.example.ShoppingCartApplication.Entity.Book;
import com.example.ShoppingCartApplication.Entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductsById(int productID);
    Product addProducts(Product products);
    Product updateProducts(Product products);

    boolean deleteProduct (int productID);

    Product getProductName(String productName);
    Product getProductPrice(float productPrice);

    Book getBookByAuthor (String author);
    Book getBookByGenre (String genre);
    Book getBookByPublications (String publications);

    Apparel getApparelByType (String type);
    Apparel getApparelByBrand (String brand);
    Apparel getApparelByDesign (String design);



}
