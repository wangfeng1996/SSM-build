package com.wang.controller;

import com.wang.pojo.Books;
import com.wang.service.BookService;
import com.wang.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller掉service层
    @Autowired

    @Qualifier("BookServiceImpl")

    private BookService bookService = new BookServiceImpl();

    @RequestMapping("/allBook")
    //查询全部的书籍，并且返回到一个书籍展示页面
    public String list(Model model) {
        //调用业务层的方法，查询全部的书籍

        List<Books> list = bookService.queryAllBook();

        //返回到前端面页面展示
        model.addAttribute("list", list);
        //返回到allBook页面
        return "allBook";
    }
    //添加书籍
    @RequestMapping("/toAddBook")
    public String toAddPaper() {

        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }
    //删除书籍
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
    //这边得有个业务区处理这个请求queryBookName
        Books books = bookService.queryBookName(queryBookName);


        List<Books> list = new ArrayList<Books>();
        list.add(books);

        if(books ==  null){
            //如果查不到书籍，则返回全部的书籍
            list = bookService.queryAllBook();
            model.addAttribute("error","未查到该书籍");
        }
        model.addAttribute("list", list);
        //返回到allBook页面
        return "allBook";
    }
}
