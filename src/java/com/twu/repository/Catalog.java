package com.twu.repository;

import com.twu.beans.Book;
import com.twu.beans.Movie;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private static List<Book> books = new ArrayList<>();
    private static List<Movie> movies = new ArrayList<>();

    public Catalog(){
        books = new ArrayList<Book>(){
            {
                add(new Book(1, "Dorian Grey", "Oscar Wilde", 1890));
                add(new Book(2,"Outliers", "Malcom Gladwell", 2008));
                add(new Book(3,"Pride and Prejudice", "Jane Austen", 1813));
            }
        };

        movies = new ArrayList<Movie>(){
            {
                add(new Movie(1, "Nightmare Before Christmas", 1993, "Tim Burton", 8));
                add(new Movie(2, "Titanic", 1997, "James Cameron", 7.8));
                add(new Movie(3, "The Lion King", 1994, "Rob Minkoff, Roger Allers", 8.5));
                add(new Movie(4, "Bacurau", 2019, "Kleber Mendonça Filho", 7.8));
            }
        };
    }

    public String getAllBooks() {

        List<String> bookTitles = new ArrayList<>();

        for (Book book : books) {
            if (book.isAvailable()) {
                bookTitles.add((book.getTitle()));
            }
        }

        return String.join("\n", bookTitles);
    }

    public String getAllBooksVerbose() {
        List<String> booksInfo = new ArrayList<>();

        for (Book book : books) {
            if (book.isAvailable()) {
                booksInfo.add(String.format("%s | %s | %s", book.getTitle(), book.getAuthor(), book.getYear()));
            }
        }

        return String.join("\n", booksInfo);
    }

    public Book getBookById(int id) throws Exception {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        throw new Exception("Book not found!");
    }

    public String getAllMovies() {
        List<String> movieTitles = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.isAvailable()) {
                movieTitles.add((movie.getTitle()));
            }
        }

        return String.join("\n", movieTitles);
    }


    public Movie getMovieById(int id) throws Exception {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }

        throw new Exception("Book not found!");
    }
}
