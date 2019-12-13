package com.wang.service;


import com.wang.dao.BookMapper;
import com.wang.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class BookServiceImpl implements BookService {

    //业务层掉dao层;
    //调用dao层的操作，设置一个set接口，方便Spring管理
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books book) {

        return bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {

        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {

        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {

        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {

        return bookMapper.queryAllBook();
    }

    public Books queryBookName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}