package pl.wojciechkostecki.library.service;

import org.springframework.stereotype.Service;
import pl.wojciechkostecki.library.model.Book;
import pl.wojciechkostecki.library.repository.BookRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Couldn't find a book with id: %s", id)));
    }

    public Book updateBook(Long id, Book book) {
        if(!id.equals(book.getId())){
            throw new IllegalArgumentException(String.format("Path id %s not matching body id %s", id, book.getId()));
        }
        return save(book);
    }
}
