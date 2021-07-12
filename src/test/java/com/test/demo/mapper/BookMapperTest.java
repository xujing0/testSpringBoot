package com.test.demo.mapper;

import com.test.demo.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void test(){
        List<Book> books = bookMapper.selectList(null);
        books.forEach(System.out::println);
    }

    @Test
    public void saveBook(){
        Book book = new Book();
        book.setName("test");
        book.setAuthor("test");
        int count = bookMapper.insert(book);
        System.out.println("count = " + count);
    }
}
