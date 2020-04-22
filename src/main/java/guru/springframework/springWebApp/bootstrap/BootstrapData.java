package guru.springframework.springWebApp.bootstrap;

import guru.springframework.springWebApp.domain.Author;
import guru.springframework.springWebApp.domain.Book;
import guru.springframework.springWebApp.domain.Publisher;
import guru.springframework.springWebApp.repositories.AuthorRepository;
import guru.springframework.springWebApp.repositories.BookRepository;
import guru.springframework.springWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Vans");
        Book ddd = new Book("Domain Driven Design", "123456");
        Publisher publisher = new Publisher("Str. New York Line", "New York City", "New York State", "552P");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rob = new Author("Rob", "Johnson");
        Book noJbe = new Book("J2EE", "333555");

        rob.getBooks().add(noJbe);
        noJbe.getAuthors().add(rob);

        authorRepository.save(rob);
        bookRepository.save(noJbe);
        publisherRepository.save(publisher);


        ddd.setPublisher(publisher);
        noJbe.setPublisher(publisher);
        publisher.getBooks().add(noJbe);
        publisherRepository.save(publisher);



        System.out.println("Started in Bootstrap!");
        System.out.println("Books in repo: " + bookRepository.count());
        System.out.println("Publishers in repo " + publisherRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
