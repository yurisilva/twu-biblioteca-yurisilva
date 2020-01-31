package com.twu.beans;

public class Book {
    private int id;
    private String title;
    private String author;
    private Integer year;
    private boolean available;

    public Book(int id, String title, String author, Integer year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public Book() { }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }

    public int getId() { return id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
