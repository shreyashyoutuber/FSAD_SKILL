package com.klu;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 1 Welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // 2 Count
    @GetMapping("/count")
    public int countBooks() {
        return 100;
    }

    // 3 Price
    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    // 4 List of titles
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Spring Boot","Java Programming","Data Structures");
    }

    // 5 Book by ID
    @GetMapping("/books/{id}")
    public String bookDetails(@PathVariable int id) {
        return "Details for Book ID: " + id;
    }

    // 6 Search by title
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching book with title: " + title;
    }

    // 7 Author
    @GetMapping("/author/{name}")
    public String authorName(@PathVariable String name) {
        return "Books written by: " + name;
    }

    // 8 Add book
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully";
    }

    // 9 View books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}