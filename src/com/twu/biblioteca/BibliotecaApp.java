package com.twu.biblioteca;

import com.twu.repository.Catalog;

import java.util.Scanner;

public class BibliotecaApp {

    private static Catalog catalog = new Catalog();

    public static void main(String[] args) {
        System.out.println("twu-biblioteca-yurisilva");
        System.out.println(welcomeMessage());
        System.out.println(displayMainMenu());

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        while (!userChoice.equals("q")){
            String result = menuChoice(userChoice);

            System.out.println(result);
            System.out.println(displayMainMenu());

            userChoice = scanner.nextLine();
        }
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static String invalidOptionSelected() {
        return "Please select a valid option!";
    }

    public static String displayMainMenu() {
        return "Select an option:\n1 - List of books\n2 - List of Books (detailed)\n3 - Checkout a book\n4 - Return a book\nq - Quit";
    }

    public static String menuChoice(String userInput) {
        switch (userInput){
            case "1":
                return catalog.getAllBooks();
            case "2":
                return catalog.getAllBooksVerbose();
            case "3":
                showCheckoutBookMenu();
            case "4":
                showReturnBookMenu();
            case "q":
                return "Bye!";
            default:
                return invalidOptionSelected();
        }
    }

    private static void showCheckoutBookMenu() {
        System.out.println("Please provide book ID");
        Scanner consoleInput = new Scanner(System.in);
        String bookId = consoleInput.nextLine();
        System.out.println(catalog.checkout(bookId));
    }

    private static void showReturnBookMenu() {
        System.out.println("Please provide book ID");
        Scanner consoleInput = new Scanner(System.in);
        String bookId = consoleInput.nextLine();
        System.out.println(catalog.returnBook(bookId));
    }

    public String checkoutBookId(String bookIdToCheckout) {
        return catalog.checkout(bookIdToCheckout);
    }

    public String returnBook(String bookIdToReturn) {
        return catalog.returnBook(bookIdToReturn);
    }
}
