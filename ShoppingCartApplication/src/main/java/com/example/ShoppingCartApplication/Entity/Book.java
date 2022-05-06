package com.example.ShoppingCartApplication.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Book extends Product {

    String genre;
    String author;
    String publications;


    public Book() {

    }

    public Book( String productName, float productPrice, String genre, String author, String publications) {
        super( productName, productPrice);
        this.genre = genre;
        this.author = author;
        this.publications = publications;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublications() {
        return publications;
    }

    public void setPublications(String publications) {
        this.publications = publications;
    }
}

