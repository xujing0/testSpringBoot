package com.test.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;
import com.test.demo.entity.Book;

import java.util.List;

public interface BookMapper extends BaseMapper<Book> {

    List<Book> queryAllBookByPageL(int pageNum,int pageSize);

    PageInfo<Book> queryAllBookByPageP(int pageNum,int pageSize);
}
