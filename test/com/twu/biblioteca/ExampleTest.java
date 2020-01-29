package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private BibliotecaApp bibliotecaApp = new BibliotecaApp();
    private String allExpectedBooks = "";

    @Before
    public void prepareTest(){
        BibliotecaApp.populateBooks();
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
        String allBooks = bibliotecaApp.getAllBooks();
        assertEquals(allExpectedBooks, allBooks);
    }

    @Test
    public void viewAllBooksWithAuthorAndYear(){
        String allBooks = bibliotecaApp.getAllBooksVerbose();
        String allExpectedBooksInfo = "Dorian Grey | Oscar Wilde | 1890\nOutliers | Malcom Gladwell | 2008\nPride and Prejudice | Jane Austen | 1813";

        assertEquals(allBooks, allExpectedBooksInfo);
    }

    @Test
    public void displayMainMenu(){
        String expectedResult = "Select an option: 1) List of books";
        String actualResult = bibliotecaApp.displayMainMenu();
        String userInput = "1";

        assertEquals(allExpectedBooks, bibliotecaApp.menuChoice(userInput));
    }

    @Test
    public void notifyUserInvalidOptionWasSelected(){
        String expectedResult = "Please select a valid option!";
        String userInput = "100";

        assertEquals(expectedResult, bibliotecaApp.menuChoice(userInput));
    }
}
