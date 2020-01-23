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

        for (int i = 0; i < allBooks.size(); i++) {
            assertEquals(allBooks.get(i), allExpectedBooks.get(i));
        }
    }
}
