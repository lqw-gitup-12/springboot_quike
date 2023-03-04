package com.lqw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lqw.dao.bookdao;
import com.lqw.domain.book;
import com.lqw.service.bookService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;
;


import javax.annotation.Resource;
import java.util.List;

@Service
public class bookimplService implements bookService {
     private Counter counter;
     public  bookimplService(MeterRegistry meterRegistry)
     {
         counter= meterRegistry.counter("用户操作次数");
     }
    @Resource
    private bookdao  ba;
    @Override
    public book seekid(int id) {
       return ba.selectById(id);
    }

    @Override
    public boolean save(book book) {
       return  ba.insert(book)>0;
    }

    @Override
    public boolean del(int id) {
        counter.increment();
        return ba.deleteById(id)>0;
    }

    @Override
    public boolean update(book book) {
        return ba.updateById(book)>0;
    }

    @Override
    public List<book> seekall() {
        return ba.selectList(null);
    }

    @Override
    public IPage<book> getpage(int a, int b,book bok) {
        Page<book> bookPage = new Page<>(a, b);
        LambdaQueryWrapper<com.lqw.domain.book> qu = new LambdaQueryWrapper<>();
        if(bok!=null)
        {
            System.out.println(bok);
            qu.like(bok.getType()!=null,book::getType,bok.getType());
            qu.like(bok.getName()!=null,book::getName,bok.getName());
            qu.like(bok.getDescription()!=null,book::getDescription,bok.getDescription());
        }
        return ba.selectPage(bookPage,qu);
    }
}
