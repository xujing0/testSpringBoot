package com.test.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.test.demo.entity.Book;

import java.util.List;

public interface BookService extends IService<Book> {
    List<Book> queryAllBookByPageL(int pageNum, int pageSize);

    PageInfo<Book> queryAllBookByPageP(int pageNum, int pageSize);
}
