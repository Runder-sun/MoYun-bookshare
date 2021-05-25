package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.BookDao;
import com.example.moyun.Entity.Book;
import com.example.moyun.Service.BookService;
import com.example.moyun.Vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
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
}
