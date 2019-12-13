package com.wang.dao;

import com.wang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //对数据进行增删改查

    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(@Param("bookID") int id);

    //更新Book-- 传递完整的书
    int updateBook(Books books);

    //根据id查询,返回一个具体的Book
    Books queryBookById(@Param("bookID") int id);


    //查询全部Book,返回list集合
    List<Books> queryAllBook();
    //根据书籍的名称，查询书籍
    Books queryBookByName(@Param("bookName") String bookName);


}