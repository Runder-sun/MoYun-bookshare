package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.BookDao;
import com.example.moyun.Entity.Book;
import com.example.moyun.Entity.BookCollection;
import com.example.moyun.Entity.ReadHistory;
import com.example.moyun.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void deleteBook(Integer BookID){
        bookDao.deleteBook(BookID);
    }

    @Override
    public List<Book> getAllBook(){
        return bookDao.getAllBook();
    }

    @Override
    public Book getBookByBookID(Integer BookID) {
        return bookDao.getBookByBookID(BookID);
    }

    @Override
    public List<Book> searchBook(String BookName, String Tag) {
        return bookDao.searchBook(BookName,Tag);
    }

    @Override
    public List<Book> getHotBook(){
        return bookDao.getHotBook();
    }

    @Override
    public List<BookCollection> getBookCollectionByUserID(String UserID){
        return bookDao.getBookCollectionByUserID(UserID);
    }

    @Override
    public void addBook(Book book){bookDao.addBook(book);}

    @Override
    public void updateBook(Integer BookID,String BookName,String Author,String Publisher,String ISBN,String Kind,String Introduce){
        bookDao.updateBook(BookID,BookName,Author,Publisher,ISBN,Kind,Introduce);
    }

    @Override
    public void collectBook(BookCollection bookCollection){
        bookDao.collectBook(bookCollection);
    }

    @Override
    public void cancelCollectBook(Integer BookCollectionID){
        bookDao.cancelCollectBook(BookCollectionID);
    }

    @Override
    public void plusReadTime(Integer BookID){bookDao.plusReadTime(BookID);}

    @Override
    public void addReadHistory(ReadHistory readHistory){
        bookDao.addReadHistory(readHistory);
    }

    @Override
    public void deleteBookCollection(Integer BookID){
        bookDao.deleteBookCollection(BookID);
    }

    @Override
    public void deleteReadHistory(Integer BookID){
        bookDao.deleteReadHistory(BookID);
    }

    @Override
    public void updateBookScore(Integer BookID){
        bookDao.updateBookScore(BookID);
    }

    @Override
    public BookCollection isCollect(String UserID,Integer BookID){
        return bookDao.isCollect(UserID,BookID);
    }
}
