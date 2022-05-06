package com.example.ShoppingCartApplication.Dao;

import com.example.ShoppingCartApplication.Entity.Cart;
import com.example.ShoppingCartApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart,Integer> {
}
