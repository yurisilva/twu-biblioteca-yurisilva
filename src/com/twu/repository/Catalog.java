package com.twu.repository;

import com.twu.beans.Book;
import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private static List<Book> books = new ArrayList<>();

    public Catalog(){
        books = new ArrayList<Book>(){
            {
                add(new Book(1, "Dorian Grey", "Oscar Wilde", 1890));
                add(new Book(2,"Outliers", "Malcom Gladwell", 2008));
                add(new Book(3,"Pride and Prejudice", "Jane Austen", 1813));
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

    public void checkout(String bookIdToCheckout) throws Exception {
        Book toCheckout = getBookById(Integer.parseInt(bookIdToCheckout));

        if (toCheckout != null){
            toCheckout.setAvailable(false);
        }
    }

    private Book getBookById(int id) throws Exception {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        throw new Exception("Book not found!");
    }
}
