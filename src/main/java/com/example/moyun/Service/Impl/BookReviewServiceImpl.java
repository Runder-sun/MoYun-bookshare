package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.BookReviewDao;
import com.example.moyun.Entity.BookReview;
import com.example.moyun.Service.BookReviewService;
import com.example.moyun.Vo.BookReviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookReviewServiceImpl implements BookReviewService {
    @Autowired
    private BookReviewDao bookReviewDao;
    
    @Override
    public void deleteBookReview(Integer BookReviewID){
        bookReviewDao.deleteBookReview(BookReviewID);
    }
    
    @Override
    public List<BookReview> getAllBookReview(){
        return bookReviewDao.getAllBookReview();
    }
    
    @Override
    public BookReview getBookReviewByBookReviewID(Integer BookReviewID){
        return bookReviewDao.getBookReviewByBookReviewID(BookReviewID);
    }
    
    @Override
    public List<BookReviewVo> BookReviewToBookReviewVo(List<BookReview> list){
        List<BookReviewVo> bookReviewVos=new ArrayList<>();
        for (BookReview bookReview:list){
            BookReviewVo bookReviewVo=new BookReviewVo();
            bookReviewVo.setBookReviewID(bookReview.getBookReviewID());
            //待确认的属性
            bookReviewVos.add(bookReviewVo);
        }
        return bookReviewVos;
    }
}
