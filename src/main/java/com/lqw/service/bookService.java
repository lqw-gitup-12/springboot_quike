package com.lqw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lqw.domain.book;

import java.util.List;

public interface bookService {
    book  seekid(int id);
    boolean  save(book book);
    boolean  del(int id);
    boolean   update(book book);
    List<book> seekall();
    IPage<book> getpage(int a, int b,book book);
}
