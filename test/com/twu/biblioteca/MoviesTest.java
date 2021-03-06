package com.twu.biblioteca;

import com.twu.repository.Catalog;
import com.twu.repository.Users;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MoviesTest {

    private BibliotecaApp bibliotecaApp = new BibliotecaApp();
    private Catalog catalog = new Catalog();
    private String allExpectedMovies = "";
    private Users users = new Users();

    @Before
    public void prepareTest(){
        allExpectedMovies = "Nightmare Before Christmas\nTitanic\nThe Lion King\nBacurau";
    }

    @Test
    public void showAllMoviesTest(){
        String allMovies = catalog.getAllMovies();
        assertEquals(allExpectedMovies, allMovies);
    }

    @Test
    public void checkoutMovieTest(){
        String movieIdToCheckout = "1";
        String moviesAvailableAfterCheckout = "Titanic\nThe Lion King\nBacurau";
        bibliotecaApp.checkoutMovie(movieIdToCheckout);

        assertEquals(moviesAvailableAfterCheckout, catalog.getAllMovies());

    }

    @Test
    public void loginSuccessfulTest(){
        String userNumber = "0000001";
        String userPassword = "123";

        String expectedMessage = String.format("Welcome, user %s",userNumber);

        assertEquals(expectedMessage, bibliotecaApp.login(userNumber, userPassword));
    }

    @Test
    public void loginUnsuccessfulTest(){
        String userNumber = "0000001";
        String userPassword = "1234";

        String expectedMessage = "User not registered";

        assertEquals(expectedMessage, bibliotecaApp.login(userNumber, userPassword));
    }

    @Test
    public void getLoggedUserTest(){
        String userNumber = "0000001";
        String userPassword = "123";
        users.login(userNumber, userPassword);
        String expectedResult = "0000001";

        assertEquals(expectedResult, users.getLoggedUser());
    }

    @Test
    public void viewMyInfoTest(){
        String userNumber = "1234567";
        String userPassword = "123";
        bibliotecaApp.login(userNumber, userPassword);
        String expectedResult = "Joey Tribbiani\njoey@friends.com\n(919)641-8490";
        String userInput = "6";

        assertEquals(expectedResult, bibliotecaApp.menuChoice(userInput));

    }
}
