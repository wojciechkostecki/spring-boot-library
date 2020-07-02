package pl.wojciechkostecki.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wojciechkostecki.library.model.Book;
import pl.wojciechkostecki.library.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(id,book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
