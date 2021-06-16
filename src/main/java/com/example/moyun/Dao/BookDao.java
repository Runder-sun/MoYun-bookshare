package com.example.moyun.Dao;

import com.example.moyun.Entity.Book;
import com.example.moyun.Entity.BookCollection;
import com.example.moyun.Entity.BookReview;
import com.example.moyun.Entity.ReadHistory;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface BookDao {
    void deleteBook(Integer BookID);

    List<Book> getAllBook();

    Book getBookByBookID(Integer BookID);

    List<Book> getHotBook();

    List<BookCollection> getBookCollectionByUserID(String UserID);

    List<Book> searchBook(String BookName,String Tag);

    void addBook(Book book);

    void updateBook(Integer BookID,String BookName,String Author,String Publisher,String ISBN,String Kind,String Introduce);

    void collectBook(BookCollection bookCollection);

    void cancelCollectBook(Integer BookID,String UserID);

    void plusReadTime(Integer BookID);

    void addReadHistory(ReadHistory readHistory);

    void deleteBookCollection(Integer BookID);

    void deleteReadHistory(Integer BookID);

    void updateBookScore(Integer BookID);

    BookCollection isCollect(String UserID,Integer BookID);
}
