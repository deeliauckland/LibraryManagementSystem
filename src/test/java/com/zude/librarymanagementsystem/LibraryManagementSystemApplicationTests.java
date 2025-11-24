package com.zude.librarymanagementsystem;


import com.zude.librarymanagementsystem.entity.Author;
import com.zude.librarymanagementsystem.entity.Book;
import com.zude.librarymanagementsystem.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryManagementSystemApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void testGetAllBooks() throws Exception {
        Author author = new Author();
        author.setId(1L);
        author.setName("zude");

        Book book = new Book();
        book.setId(1L);
        book.setTitle("test book");
        book.setAuthor(author);

        when(bookService.getAllBooksWithAuthors()).thenReturn(Arrays.asList(book));

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("test book"))
                .andExpect(jsonPath("$[0].author.name").value("zude"));
    }

}
