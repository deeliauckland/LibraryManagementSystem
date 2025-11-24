package com.zude.librarymanagementsystem.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zude.librarymanagementsystem.entity.Book;
import com.zude.librarymanagementsystem.entity.QAuthor;
import com.zude.librarymanagementsystem.entity.QBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<Book> findAllBooksWithAuthor() {
        QBook book = QBook.book;
        QAuthor author = QAuthor.author;

        return queryFactory
                .selectFrom(book)
                .join(book.author, author).fetchJoin()
                .fetch();
    }


}
