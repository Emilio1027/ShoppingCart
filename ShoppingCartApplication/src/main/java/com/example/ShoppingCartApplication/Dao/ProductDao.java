package com.example.ShoppingCartApplication.Dao;

import com.example.ShoppingCartApplication.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {


    List<Product> findByProductNameIgnoreCase (String name);
    List<Product> findByProductPrice (float price);


}
