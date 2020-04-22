package guru.springframework.springWebApp.controllers;

import guru.springframework.springWebApp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        // Execute the getBooks() method and execute BookRepository
        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}