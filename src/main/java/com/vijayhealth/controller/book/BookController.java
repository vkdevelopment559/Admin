package com.vijayhealth.controller.book;

import com.vijayhealth.entity.book.BookEntity;
import com.vijayhealth.service.book.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody BookEntity book){
        return ResponseEntity.ok(bookService.createBook(book));
    }


}
