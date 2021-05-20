package com.example.moyun.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_info")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookID;
    private String BookName;
    private String Author;
    private String Publisher;
    private String ISBN;
    private String Kind;
    private double Score;
    private String Link;
    private String BookImage;
    private int ReadTimes;

    public Book(int bookID, String bookName, String author, String publisher, String ISBN, String kind, double score, String link, String bookImage, int readTimes) {
        BookID = bookID;
        BookName = bookName;
        Author = author;
        Publisher = publisher;
        this.ISBN = ISBN;
        Kind = kind;
        Score = score;
        Link = link;
        BookImage = bookImage;
        ReadTimes = readTimes;
    }

    public Book() {
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getKind() {
        return Kind;
    }

    public void setKind(String kind) {
        Kind = kind;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getBookImage() {
        return BookImage;
    }

    public void setBookImage(String bookImage) {
        BookImage = bookImage;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public int getReadTimes() {
        return ReadTimes;
    }

    public void setReadTimes(int readTimes) {
        ReadTimes = readTimes;
    }
}
