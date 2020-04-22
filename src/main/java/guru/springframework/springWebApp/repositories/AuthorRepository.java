package guru.springframework.springWebApp.repositories;

import guru.springframework.springWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
