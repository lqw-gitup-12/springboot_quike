package com.lqw.cotroller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lqw.cotroller.Result.Result;
import com.lqw.domain.book;
import com.lqw.service.bookService;
import com.lqw.service.bookService2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class bookcontroller {
    @Resource
    private bookService bo;

    @GetMapping("{id}")
    Result  seekid(@PathVariable int id)
    {
        System.out.println("seekid[[[[[[[[[[[[[[[[[[[[[[[[");
        book byId = bo.seekid(id);
        return new Result(true,byId);
    }
    @GetMapping
    Result  seekall()
    {
        return new Result(true,bo.seekall());
    }
    @DeleteMapping("{id}")
    Result  del(@PathVariable int id)
    {
        return  new Result(bo.del(id));
    }
    @PostMapping
    Result  save(@RequestBody  book  book) throws IOException {
        if(book.getName().equals("123")) throw new IOException();
        boolean save = bo.save(book);
        return new Result(save, save ? "添加成功":"添加失败");
    }
    @PutMapping
    Result  modify( @RequestBody  book  book)
    {
       boolean  flag= bo.update(book);
        return new Result(flag,flag? "修改成功！":"修改失败！");
    }
   /* @GetMapping("{a}/{b}")
    Result  seekpage(@PathVariable int a, @PathVariable int b)
    {
        IPage<book> getpage = bo.getpage(a,b,null);
        if(a>getpage.getPages())
        {
           getpage = bo.getpage((int) getpage.getPages(),b,null);
        }
        System.out.println("111");
        return new Result(null !=getpage,getpage,"123");
    }*/
    @GetMapping("{a}/{b}")
    Result  seekpage(@PathVariable int a, @PathVariable int b,book book)
    {
        IPage<book> getpage = bo.getpage(a,b,book);
        if(a>getpage.getPages())
        {
            getpage = bo.getpage((int) getpage.getPages(),b,book);
        }
        return new Result(null !=getpage,getpage,"123");
    }
}
