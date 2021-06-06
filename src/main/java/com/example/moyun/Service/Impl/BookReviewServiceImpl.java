package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.BookReviewDao;
import com.example.moyun.Entity.BookReview;
import com.example.moyun.Entity.BookReviewComment;
import com.example.moyun.Service.BookReviewService;
import com.example.moyun.Vo.BookReviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    @Override
    public List<BookReview> getBookReviewCollectionByUserID(String UserID){
        return bookReviewDao.getBookReviewCollectionByUserID(UserID);
    }

    @Override
    public void likeBookReview(Integer BookReviewID){
        bookReviewDao.likeBookReview(BookReviewID);
    }

    @Override
    public void createBookReviewByBookID(BookReview review){
        bookReviewDao.createBookReviewByBookID(review);
    }

    @Override
    public void createBookReviewCommentByReviewID(BookReviewComment comment){
        bookReviewDao.createBookReviewCommentByReviewID(comment);
    }

    @Override
    public void updateBookReview(Integer BookReviewID,String Content,String Title,Integer Score){
        bookReviewDao.updateBookReview(BookReviewID,Content,Title,Score);
    }

    @Override
    public void collectBookReview(Integer BookReviewID, String UserID, Timestamp CollectTime){
        bookReviewDao.collectBookReview(BookReviewID,UserID,CollectTime);
    }

    @Override
    public void cancelCollectBookReview(Integer BookReviewCollectionID){
        bookReviewDao.cancelCollectBookReview(BookReviewCollectionID);
    }

    @Override
    public void deleteCollectBookReview(Integer BookReviewID){
        bookReviewDao.deleteCollectBookReview(BookReviewID);
    }

    @Override
    public void deleteRelatedComment(Integer BookReviewID){
        bookReviewDao.deleteRelatedComment(BookReviewID);
    }

    @Override
    public void deleteRelatedBookReview(Integer BookID){bookReviewDao.deleteRelatedBookReview(BookID);}

    @Override
    public void deleteRelatedBookReviewComment(Integer BookID){bookReviewDao.deleteRelatedBookReviewComment(BookID);}

    @Override
    public List<BookReviewComment> getBookReviewCommentList(Integer BookReviewID){
        return bookReviewDao.getBookReviewCommentList(BookReviewID);
    }

    @Override
    public void deleteRelatedBookReviewCollection(Integer BookID){
        bookReviewDao.deleteRelatedBookReviewCollection(BookID);
    }

    @Override
    public List<BookReview> getBookReviewDT(String UserID){
        return bookReviewDao.getBookReviewDT(UserID);
    }
}
