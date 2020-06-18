package pl.wojciechkostecki.library.service;

import org.springframework.stereotype.Service;
import pl.wojciechkostecki.library.model.Book;
import pl.wojciechkostecki.library.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }
}
