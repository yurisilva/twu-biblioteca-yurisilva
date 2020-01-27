package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void viewWelcomeMessageTest(){
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String actualMessage = bibliotecaApp.welcomeMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void viewAllBooks(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        ArrayList<String> allBooks = bibliotecaApp.getAllBooks();
        ArrayList<String> allExpectedBooks = new ArrayList<String>(){
            {
                add("Dorian Grey");
                add("Outliers");
                add("Pride and Prejudice");
            }
        };

        assertEquals(allBooks, allExpectedBooks);
    }

    @Test
    public void viewAllBooksWithAuthorAndYear(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        ArrayList<String> allBooks = bibliotecaApp.getAllBooksVerbose();
        ArrayList<String> allExpectedBooks = new ArrayList<String>(){
            {
                add("Dorian Grey | Oscar Wilde | 1890");
                add("Outliers | Malcom Gladwell | 2008");
                add("Pride and Prejudice | Jane Austen | 1813");
            }
        };

        assertEquals(allBooks, allExpectedBooks);
    }
}
