package com.test.demo.service.impl;

import com.github.pagehelper.PageInfo;
import com.test.demo.entity.Book;
import com.test.demo.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    void queryAllBookByPageL() {
        List<Book> books = bookService.queryAllBookByPageL(1, 5);
        books.forEach(System.out::println);
    }

    @Test
    void queryAllBookByPageP() {
        PageInfo<Book> bookPageInfo = bookService.queryAllBookByPageP(1, 3);

    }
}
