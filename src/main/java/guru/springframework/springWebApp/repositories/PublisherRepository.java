package guru.springframework.springWebApp.repositories;

import guru.springframework.springWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
