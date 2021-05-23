package com.example.moyun.Dao;

import com.example.moyun.Entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
    void deleteBook(Integer BookID);
    List<Book> getAllBook();
    Book getBookByBookID(Integer BookID);
}
