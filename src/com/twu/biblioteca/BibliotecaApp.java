package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public ArrayList<String> getAllBooks() {
        return new ArrayList<String>(){
            {
                add("Dorian Grey");
                add("Outliers");
                add("Pride and Prejudice");
            }
        };
    }

    public ArrayList<String> getAllBooksVerbose() {
        return new ArrayList<String>() {
            {
                add("Dorian Grey | Oscar Wilde | 1890");
                add("Outliers | Malcom Gladwell | 2008");
                add("Pride and Prejudice | Jane Austen | 1813");
            }
        };
    }
}
