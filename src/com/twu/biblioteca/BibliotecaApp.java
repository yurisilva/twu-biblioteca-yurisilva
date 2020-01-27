package com.twu.biblioteca;

import com.sun.codemodel.internal.JForEach;
import com.twu.beans.Book;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static List<Book> books = new ArrayList<>();

    public static void populateBooks(){
        books = new ArrayList<Book>(){
            {
                add(new Book("Dorian Grey", "Oscar Wilde", 1890));
                add(new Book("Outliers", "Malcom Gladwell", 2008));
                add(new Book("Pride and Prejudice", "Jane Austen", 1813));
            }
        };
    }

    public static void main(String[] args) {
        populateBooks();
        System.out.println("Hello, world!");
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public List<String> getAllBooks() {

        List<String> bookTitles = new ArrayList<>();

        for (Book book : books) {
            bookTitles.add((book.getTitle()));
        }

        return bookTitles;
    }

    public List<String> getAllBooksVerbose() {
        List<String> booksInfo = new ArrayList<>();

        for (Book book : books) {
            booksInfo.add(String.format("%s | %s | %s", book.getTitle(), book.getAuthor(), book.getYear()));
        }

        return booksInfo;
    }

    public String displayMainMenu() {
        return "Select an option: 1) List of books";
    }

    public List<String> menuChoice(String userInput) {
        return getAllBooks();
    }
}
