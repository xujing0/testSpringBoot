package com.test.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.demo.entity.Book;
import com.test.demo.entity.User;
import com.test.demo.mapper.BookMapper;
import com.test.demo.mapper.UserMapper;
import com.test.demo.service.BookService;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> queryAllBookByPageL(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return bookMapper.selectList(null);
    }

    @Override
    public PageInfo<Book> queryAllBookByPageP(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookMapper.selectList(null);
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return pageInfo;
    }
}
