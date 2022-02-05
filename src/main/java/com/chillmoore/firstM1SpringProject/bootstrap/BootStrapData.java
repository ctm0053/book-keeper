package com.chillmoore.firstM1SpringProject.bootstrap;

import com.chillmoore.firstM1SpringProject.model.Author;
import com.chillmoore.firstM1SpringProject.model.Book;
import com.chillmoore.firstM1SpringProject.model.Publisher;
import com.chillmoore.firstM1SpringProject.repository.AuthorRepository;
import com.chillmoore.firstM1SpringProject.repository.BookRepository;
import com.chillmoore.firstM1SpringProject.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void run(String... args) throws Exception {
        System.out.println("Started in bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setAddress("Florida");

        publisherRepository.save(publisher);

        Author cormen = new Author("Thomas", "Cormen");
        Author leiserson = new Author("Charles", "Lieserson");
        Author rivest = new Author("Ronald", "Rivest");
        Author stein = new Author("Clifford", "Stein");
        Book introToAlgorithms = new Book("Introduction To Algorithsm", "9780262033848");


        cormen.getBooks().add(introToAlgorithms);
        leiserson.getBooks().add(introToAlgorithms);
        rivest.getBooks().add(introToAlgorithms);
        stein.getBooks().add(introToAlgorithms);
        introToAlgorithms.getAuthors().add(cormen);
        introToAlgorithms.getAuthors().add(leiserson);
        introToAlgorithms.getAuthors().add(rivest);
        introToAlgorithms.getAuthors().add(stein);

        introToAlgorithms.setPublisher(publisher);
        publisher.getBooks().add(introToAlgorithms);

        authorRepository.save(cormen);
        authorRepository.save(leiserson);
        authorRepository.save(rivest);
        authorRepository.save(stein);
        bookRepository.save(introToAlgorithms);
        publisherRepository.save(publisher);


        Author bloch =  new Author("Joshua", "Bloch");
        Book effectiveJava = new Book("Effect Java", "0134685997");

        bloch.getBooks().add(effectiveJava);
        effectiveJava.getAuthors().add(bloch);
        effectiveJava.setPublisher(publisher);
        publisher.getBooks().add(effectiveJava);

        authorRepository.save(bloch);
        bookRepository.save(effectiveJava);
        publisherRepository.save(publisher);

        Author evans = new Author("Eric", "Evans");
        Book ddd = new Book("Domain-Driven Design", "0321125215");


        evans.getBooks().add(ddd);
        ddd.getAuthors().add(evans);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(evans);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of publisher books: " + publisher.getBooks().size());
    }

}
