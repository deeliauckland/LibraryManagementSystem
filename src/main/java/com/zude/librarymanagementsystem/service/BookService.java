package com.zude.librarymanagementsystem.service;

import com.zude.librarymanagementsystem.entity.Book;
import com.zude.librarymanagementsystem.repository.BookQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {
    private final BookQueryRepository bookQueryRepository;

    public List<Book> getAllBooksWithAuthors() {
        return bookQueryRepository.findAllBooksWithAuthor();
    }
}
