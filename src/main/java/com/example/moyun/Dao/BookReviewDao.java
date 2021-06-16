package com.example.moyun.Dao;

import com.example.moyun.Entity.BookReview;
import com.example.moyun.Entity.BookReviewCollection;
import com.example.moyun.Entity.BookReviewComment;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface BookReviewDao {
    void deleteBookReview(Integer BookReviewID);

    List<BookReview> getAllBookReview();

    BookReview getBookReviewByBookReviewID(Integer BookReviewID);

    List<BookReview> getBookReviewCollectionByUserID(String UserID);

    void likeBookReview(Integer BookReviewID);

    void cancelLikeBookReview(Integer BookReviewID);

    void createBookReviewByBookID(BookReview review);

    void createBookReviewCommentByReviewID(BookReviewComment comment);

    void updateBookReview(Integer BookReviewID,String Content,String Title,Integer Score);

    void collectBookReview(Integer BookReviewID, String UserID, Timestamp CollectTime);

    void cancelCollectBookReview(Integer BookReviewID,String UserID);

    void deleteCollectBookReview(Integer BookReviewID);

    void deleteRelatedComment(Integer BookReviewID);

    void deleteRelatedBookReview(Integer BookID);

    void deleteRelatedBookReviewComment(Integer BookID);

    List<BookReviewComment> getBookReviewCommentList(Integer BookReviewID);

    BookReviewCollection isCollect(String UserID, Integer BookReviewID);

    void deleteRelatedBookReviewCollection(Integer BookID);

    List<BookReview> getBookReviewDT(String UserID);

    List<BookReview> getBookReviewListByBookID(Integer BookID);

    List<BookReview> getMyBookReview(String UserID);
}
