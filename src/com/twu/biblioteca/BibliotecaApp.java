package com.twu.biblioteca;

import com.twu.beans.Book;
import com.twu.beans.Movie;
import com.twu.repository.Catalog;
import com.twu.repository.User;

import java.util.Scanner;

public class BibliotecaApp {

    private static Catalog catalog = new Catalog();
    private static User users = new User();

    public static void main(String[] args) {
        System.out.println("twu-biblioteca-yurisilva");
        System.out.println(welcomeMessage());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type in your library number: ");
        String libraryNumber = scanner.nextLine();

        System.out.print("Type in your password: ");
        String password = scanner.nextLine();

        System.out.println(login(libraryNumber, password));

        if(users.isUserLogged()){
            System.out.println(displayMainMenu());

            String userChoice = scanner.nextLine();

            while (!userChoice.equals("q")){
                String result = menuChoice(userChoice);

                System.out.println(result);
                System.out.println(displayMainMenu());

                userChoice = scanner.nextLine();
            }
        }
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static String invalidOptionSelected() {
        return "Please select a valid option!";
    }

    public static String displayMainMenu() {
        return "Select an option:\n1 - List of books\n2 - List of Books (detailed)\n3 - Checkout a book\n4 - Return a book\n5 - List of Movies\nq - Quit";
    }

    public static String menuChoice(String userInput) {
        switch (userInput){
            case "1":
                return catalog.getAllBooks();
            case "2":
                return catalog.getAllBooksVerbose();
            case "3":
                return showCheckoutBookMenu();
            case "4":
                return showReturnBookMenu();
            case "5":
                return catalog.getAllMovies();
            case "q":
                return "Bye!";
            default:
                return invalidOptionSelected();
        }
    }

    private static String showCheckoutBookMenu() {
        System.out.println("Please provide book ID to checkout");
        Scanner consoleInput = new Scanner(System.in);
        String bookId = consoleInput.nextLine();
        return checkoutBook(bookId);
    }

    public static String checkoutBook(String bookIdToCheckout) {

        try {
            Book toCheckout = catalog.getBookById(Integer.parseInt(bookIdToCheckout));

            if (toCheckout != null && toCheckout.isAvailable()) {
                changeBookState(toCheckout, false, users.getLoggedUser());
                return "Thank you! Enjoy the book";
            }
        }
        catch(Exception e){ }

        return "Sorry, that book is not available";
    }

    private static String showReturnBookMenu() {
        System.out.println("Please provide book ID to return");
        Scanner consoleInput = new Scanner(System.in);
        String bookId = consoleInput.nextLine();
        return returnBook(bookId);
    }

    public static String returnBook(String bookIdToReturn) {
        try {
            Book toReturn = catalog.getBookById(Integer.parseInt(bookIdToReturn));

            if (toReturn != null && !toReturn.isAvailable()) {
                changeBookState(toReturn, true, "");
                return "Thank you for returning the book";
            }
        }
        catch(Exception e){ }

        return "That is not a valid book to return";
    }

    private static void changeBookState(Book book, boolean available, String whoHasIt) {
        book.setAvailable(available);
        book.setWhoHasIt(whoHasIt);
    }

    public void checkoutMovie(String movieIdToCheckout) {
        try {
            Movie toCheckout = catalog.getMovieById(Integer.parseInt(movieIdToCheckout));

            if (toCheckout != null && toCheckout.isAvailable()) {
                toCheckout.setAvailable(false);
            }
        }
        catch(Exception e){ }

    }

    public static String login(String userNumber, String userPassword) {
        if(users.login(userNumber, userPassword)){
            return String.format("Welcome, user %s", userNumber);
        }
        else{
            return "User not registered";
        }
    }

    public String whoCheckedOutBookId(String bookId) {
        try {
            Book book = catalog.getBookById(Integer.parseInt(bookId));

            if (book != null && !book.isAvailable()) {
                return book.whoHasIt();
            }
        }
        catch(Exception e){ }

        return "";
    }
}
