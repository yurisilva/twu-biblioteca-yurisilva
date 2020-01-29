package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private BibliotecaApp bibliotecaApp = new BibliotecaApp();
    private List<String> allExpectedBooks = new ArrayList<>();

    @Before
    public void prepareTest(){
        BibliotecaApp.populateBooks();

        allExpectedBooks = new ArrayList<String>(){
            {
                add("Dorian Grey");
                add("Outliers");
                add("Pride and Prejudice");
            }
        };
    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void viewWelcomeMessageTest(){
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        String actualMessage = bibliotecaApp.welcomeMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void viewAllBooks(){
        List<String> allBooks = bibliotecaApp.getAllBooks();

        assertEquals(allExpectedBooks, allBooks);
    }

    @Test
    public void viewAllBooksWithAuthorAndYear(){
        List<String> allBooks = bibliotecaApp.getAllBooksVerbose();
        List<String> allExpectedBooksInfo = new ArrayList<String>(){
            {
                add("Dorian Grey | Oscar Wilde | 1890");
                add("Outliers | Malcom Gladwell | 2008");
                add("Pride and Prejudice | Jane Austen | 1813");
            }
        };

        assertEquals(allBooks, allExpectedBooksInfo);
    }

    @Test
    public void displayMainMenu(){
        String expectedResult = "Select an option: 1) List of books";
        String actualResult = bibliotecaApp.displayMainMenu();

        assertEquals(expectedResult, actualResult);

        String userInput = "1";

        assertEquals(allExpectedBooks, bibliotecaApp.menuChoice(userInput));
    }

    @Test
    public void notifyUserInvalidOptionWasSelected(){
        String expectedResult = "Please select a valid option!";

        String userInput = "100";

        assertEquals(expectedResult, bibliotecaApp.menuChoice(userInput).get(0));
    }
}
