package com.twu.biblioteca;

import com.twu.repository.Catalog;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private BibliotecaApp bibliotecaApp = new BibliotecaApp();
    private Catalog catalog = new Catalog();
    private String allExpectedBooks = "";

    @Before
    public void prepareTest(){
        allExpectedBooks = "Dorian Grey\nOutliers\nPride and Prejudice";
    }

    @Test
    public void viewWelcomeMessageTest(){
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        String actualMessage = bibliotecaApp.welcomeMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void viewAllBooks(){
        String allBooks = catalog.getAllBooks();
        assertEquals(allExpectedBooks, allBooks);
    }

    @Test
    public void viewAllBooksWithAuthorAndYear(){
        String allBooks = catalog.getAllBooksVerbose();
        String allExpectedBooksInfo = "Dorian Grey | Oscar Wilde | 1890\nOutliers | Malcom Gladwell | 2008\nPride and Prejudice | Jane Austen | 1813";

        assertEquals(allBooks, allExpectedBooksInfo);
    }

    @Test
    public void displayMainMenu(){
        String userInput = "1";

        assertEquals(allExpectedBooks, bibliotecaApp.menuChoice(userInput));
    }

    @Test
    public void notifyUserInvalidOptionWasSelected(){
        String expectedResult = "Please select a valid option!";
        String userInput = "100";

        assertEquals(expectedResult, bibliotecaApp.menuChoice(userInput));
    }

    @Test
    public void exitApplicationTest(){
        String expectedResult = "Bye!";
        String userInput = "q";

        assertEquals(expectedResult, bibliotecaApp.menuChoice(userInput));
    }

    @Test
    public void checkoutBookTest(){
        String bookIdToCheckout = "1";
        String booksAvailableAfterCheckout = "Outliers\nPride and Prejudice";
        bibliotecaApp.checkoutBookId(bookIdToCheckout);

        assertEquals(booksAvailableAfterCheckout, catalog.getAllBooks());

    }

    @Test
    public void checkoutMessageTest(){
        String bookIdToCheckout = "1";
        String expectedMessage = "Thank you! Enjoy the book";

        assertEquals(expectedMessage, bibliotecaApp.checkoutBookId(bookIdToCheckout));

    }

    @Test
    public void returnBookSuccessfullyMessageTest(){
        String bookId = "1";
        String expectedMessage = "Thank you for returning the book";

        bibliotecaApp.checkoutBookId(bookId);
        assertEquals(expectedMessage, bibliotecaApp.returnBook(bookId));

    }

    @Test
    public void returnBookFailedMessageTest(){
        String bookId = "100";
        String expectedMessage = "That is not a valid book to return";

        bibliotecaApp.checkoutBookId(bookId);
        assertEquals(expectedMessage, bibliotecaApp.returnBook(bookId));

    }

    @Test
    public void checkoutFailedTest(){
        String expectedMessage = "Sorry, that book is not available";
        String bookIdToCheckout = "1";
        bibliotecaApp.checkoutBookId(bookIdToCheckout);

        assertEquals(expectedMessage, bibliotecaApp.checkoutBookId(bookIdToCheckout));

    }

    @Test
    public void returnBookTest(){
        allExpectedBooks = "Dorian Grey\nOutliers\nPride and Prejudice";
        String bookIdToCheckout = "1";
        String bookIdToReturn = "1";
        String booksAvailableAfterCheckout = "Outliers\nPride and Prejudice";

        bibliotecaApp.checkoutBookId(bookIdToCheckout);
        assertEquals(booksAvailableAfterCheckout, catalog.getAllBooks());

        bibliotecaApp.returnBook(bookIdToReturn);
        assertEquals(allExpectedBooks, catalog.getAllBooks());
    }
}
