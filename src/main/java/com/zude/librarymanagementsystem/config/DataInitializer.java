package com.zude.librarymanagementsystem.config;

import com.zude.librarymanagementsystem.entity.Author;
import com.zude.librarymanagementsystem.entity.Book;
import com.zude.librarymanagementsystem.repository.AuthorRepository;
import com.zude.librarymanagementsystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public void run(String... args) {

        Author author1 = new Author();
        author1.setName("author 1");
        authorRepository.save(author1);

        Author author2 = new Author();
        author2.setName("author 2");
        authorRepository.save(author2);

        Author author3 = new Author();
        author3.setName("author 3");
        authorRepository.save(author3);

        Book book1 = new Book();
        book1.setTitle("book1 Title");
        book1.setAuthor(author1);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("book2 Title");
        book2.setAuthor(author1);
        bookRepository.save(book2);

        Book book3 = new Book();
        book3.setTitle("book3 Title");
        book3.setAuthor(author2);
        bookRepository.save(book3);

        Book book4 = new Book();
        book4.setTitle("book3 Title");
        book4.setAuthor(author3);
        bookRepository.save(book4);

        log.info("create {} books", bookRepository.count());
    }
}
