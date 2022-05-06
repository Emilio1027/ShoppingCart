package com.example.ShoppingCartApplication.Services;


import com.example.ShoppingCartApplication.Dao.ProductDao;
import com.example.ShoppingCartApplication.Entity.Apparel;
import com.example.ShoppingCartApplication.Entity.Book;
import com.example.ShoppingCartApplication.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductDao dao;

    public ProductServiceImpl() {
//        list = new ArrayList<>();
//        list.add(new Product(101,"CloroxPro Total 360", 9.99F));
//        list.add(new Product(102,"Dreametech T30 Cordless Vacuum",499.0F));
//        list.add(new Product(103,"Learning Java",32.49F,getBookByAuthor(" Marc Loy")));
//        list.add(new Product(105,"Ralph Lauren's Polo Shirt",19.39F,getBookByAuthor("Ralph Lauren")));

    }
//    I now need an Object from Dao so first declare the object
//    don't forget to use an @Autowire for the CourseDao object to
//    map it with the name class


    @Override
    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    @Override
    public Product getProductsById(int productID) {
        return dao.getById(productID);
    }

    @Override
    public Product addProducts(Product products) {
        dao.save(products);
        return products;
    }

    @Override
    public Product updateProducts(Product products) {
        dao.save(products);
        return products;
    }

    @Override
    public boolean deleteProduct(int productID) {
        dao.deleteById(productID);
        return true;
    }

    @Override
    public Product getProductName(String productName) {
        List<Product> productlist = dao.findByProductNameIgnoreCase(productName);
        if (productlist.isEmpty()) {
            System.out.println("Nothing with that name");
            return null;
        }

        return productlist.get(0);
    }

    @Override
    public Product getProductPrice(float productPrice) {
        List<Product> productlist = dao.findByProductPrice(productPrice);
        if (productlist.isEmpty()) {
            System.out.println("Nothing with that price");
            return null;
        }

        return productlist.get(0);
    }

    @Override
    public Book getBookByAuthor(String author) {
        List<Book> productsList = dao.findAll().stream().
                filter(x -> x instanceof Book).map(x -> ((Book) x)).
                filter(x -> (x).getAuthor() == author).collect(Collectors.toList());
        if (productsList.isEmpty()) {
            System.out.println("Nothing with that author");
            return null;
        }

        return productsList.get(0);
    }

    @Override
    public Book getBookByGenre(String genre) {
        List<Book> productsList = dao.findAll().stream().
                filter(x -> x instanceof Book).map(x -> ((Book) x)).
                filter(x -> (x).getGenre() == genre).collect(Collectors.toList());
        if (productsList.isEmpty()) {
            System.out.println("Nothing with that genre");
            return null;
        }

        return productsList.get(0);
    }

    @Override
    public Book getBookByPublications(String publications) {
        List<Book> productsList = dao.findAll().stream().
                filter(x -> x instanceof Book).map(x -> ((Book) x)).
                filter(x -> (x).getPublications() == publications).collect(Collectors.toList());
        if (productsList.isEmpty()) {
            System.out.println("Nothing with that publication");
            return null;
        }

        return productsList.get(0);
    }

    @Override
    public Apparel getApparelByType(String type) {
        List<Apparel> productsList = dao.findAll().stream().
                filter(x -> x instanceof Apparel).map(x -> ((Apparel) x)).
                filter(x -> (x).getType() == type).collect(Collectors.toList());
        if (productsList.isEmpty()) {
            System.out.println("Nothing with that publication");
            return null;
        }
        return productsList.get(0);
    }

    @Override
    public Apparel getApparelByBrand(String brand) {
        List<Apparel> productsList = dao.findAll().stream().
                filter(x -> x instanceof Apparel).map(x -> ((Apparel) x)).
                filter(x -> (x).getBrand() == brand).collect(Collectors.toList());
        if (productsList.isEmpty()) {
            System.out.println("Nothing with that publication");
            return null;
        }
        return productsList.get(0);
    }

    @Override
    public Apparel getApparelByDesign(String design) {
        List<Apparel> productsList = dao.findAll().stream().
                filter(x -> x instanceof Apparel).map(x -> ((Apparel) x)).
                filter(x -> (x).getDesign() == design).collect(Collectors.toList());
        if (productsList.isEmpty()) {
            System.out.println("Nothing with that publication");
            return null;
        }
        return productsList.get(0);
    }

}
