package com.test.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.demo.entity.Book;
import com.test.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findAll/{pageNum}/{pageSize}")
    public PageInfo<Book> findAll(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> books = bookService.list();
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return pageInfo;
    }

    @GetMapping("testPageHelper1")
    public PageInfo<Book> testPageHelper1() {
        return bookService.queryAllBookByPageP(1, 5);
    }

    @GetMapping("testPageHelper2")
    public List<Book> testPageHelper2() {
        return bookService.queryAllBookByPageL(1, 5);
    }


    @PostMapping("/saveBook")
    public Boolean saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public Boolean deleteBookById(@PathVariable("id") Integer id) {
        return bookService.removeById(id);
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id) {
        return bookService.getById(id);
    }

    @PostMapping("/updateById")
    public Boolean updateById(@RequestBody Book book) {
        return bookService.updateById(book);
    }
}
