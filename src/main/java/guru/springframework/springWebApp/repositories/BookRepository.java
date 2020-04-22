package guru.springframework.springWebApp.repositories;

import guru.springframework.springWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
