package com.twu.biblioteca;

import com.twu.beans.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("twu-biblioteca-yurisilva");
        System.out.println(welcomeMessage());
        Scanner userInput = new Scanner(System.in);
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String getAllBooks() {

        List<String> bookTitles = new ArrayList<>();

        for (Book book : books) {
            bookTitles.add((book.getTitle()));
        }

        return String.join("\n", bookTitles);
    }

    public String invalidOptionSelected() {
        return "Please select a valid option!";
    }

    public String getAllBooksVerbose() {
        List<String> booksInfo = new ArrayList<>();

        for (Book book : books) {
            booksInfo.add(String.format("%s | %s | %s", book.getTitle(), book.getAuthor(), book.getYear()));
        }

        return String.join("\n", booksInfo);
    }

    public String displayMainMenu() {
        return "Select an option: 1) List of books";
    }

    public String menuChoice(String userInput) {
        switch (userInput){
            case "1":
                return getAllBooks();
            default:
                return invalidOptionSelected();
        }
    }
}
