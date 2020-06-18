package pl.wojciechkostecki.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojciechkostecki.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
