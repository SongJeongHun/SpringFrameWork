package com.example.demo.middleProject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Scope("prototype")
public class Book {
    String ID;
    String ISBN;
    String title;
    String author;
    String publisher;
    String pubDate;
    Boolean usable;
    ArrayList<String> comments;
    ArrayList<String> reservation;

    public Book(String ID, String ISBN, String title, String author, String publisher, String pubDate, Boolean usable, ArrayList<String> comments, ArrayList<String> reservation) {
        this.ID = ID;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
        this.usable = usable;
        this.comments = comments;
        this.reservation = reservation;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getISBN() { return ISBN; }

    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getUsable() {
        return usable;
    }

    public void setUsable(Boolean usable) {
        this.usable = usable;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ArrayList<String> getReservation() {
        return reservation;
    }

    public void setReservation(ArrayList<String> reservation) {
        this.reservation = reservation;
    }
}
