package com.twu.biblioteca;

import com.twu.beans.Book;
import com.twu.repository.Catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private Catalog catalog = new Catalog();

    public static void main(String[] args) {
        System.out.println("twu-biblioteca-yurisilva");
        System.out.println(welcomeMessage());
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String invalidOptionSelected() {
        return "Please select a valid option!";
    }

    public String displayMainMenu() {
        return "Select an option: 1) List of books";
    }

    public String menuChoice(String userInput) {
        switch (userInput){
            case "1":
                return catalog.getAllBooks();
            case "q":
                return "Bye!";
            default:
                return invalidOptionSelected();
        }
    }

    public String checkoutBookId(String bookIdToCheckout) {
        try{
            catalog.checkout(bookIdToCheckout);
        }
        catch(Exception e){

        }
        return "Thank you! Enjoy the book";
    }
}
