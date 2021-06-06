package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.BookDao;
import com.example.moyun.Entity.Book;
import com.example.moyun.Entity.BookCollection;
import com.example.moyun.Entity.BookReview;
import com.example.moyun.Entity.ReadHistory;
import com.example.moyun.Service.BookService;
import com.example.moyun.Vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    public List<BookVo> BookToBookVo(List<Book> list) {
        List<BookVo> bookVos=new ArrayList<>();
        for (Book book:list){
            BookVo bookVo=new BookVo();
            bookVo.setBookID(book.getBookID());
            //待确认的属性
            bookVos.add(bookVo);
        }
        return bookVos;
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
    public List<BookReview> getBookReviewListByBookID(Integer BookID){
        return bookDao.getBookReviewListByBookID(BookID);
    }

    @Override
    public void addBook(Book book){bookDao.addBook(book);}

    @Override
    public void updateBook(Integer BookID,String BookName,String Author,String Publisher,String ISBN,String Kind){
        bookDao.updateBook(BookID,BookName,Author,Publisher,ISBN,Kind);
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
}
