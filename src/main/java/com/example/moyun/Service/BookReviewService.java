package com.example.moyun.Service;

import com.example.moyun.Entity.BookReview;
import com.example.moyun.Entity.BookReviewCollection;
import com.example.moyun.Entity.BookReviewComment;

import java.sql.Timestamp;
import java.util.List;

public interface BookReviewService {
    //删除书评
    void deleteBookReview(Integer BookReviewID);

    //查看全部BookReview
    List<BookReview> getAllBookReview();

    //根据BookReviewID查找BookReview
    BookReview getBookReviewByBookReviewID(Integer BookReviewID);

    //根据UserID查找BookReviewCollection
    List<BookReview> getBookReviewCollectionByUserID(String UserID);

    //点赞书评
    void likeBookReview(Integer BookReviewID);

    //取消点赞书评
    void cancelLikeBookReview(Integer BookReviewID);

    //创建书评
    void createBookReviewByBookID(BookReview review);

    //创建书评的评论
    void createBookReviewCommentByReviewID(BookReviewComment comment);

    //修改书评内容
    void updateBookReview(Integer BookReviewID,String Content,String Title,Integer Score);

    //收藏书评
    void collectBookReview(Integer BookReviewID, String UserID, Timestamp CollectTime);

    //取消收藏书评
    void cancelCollectBookReview(Integer BookReviewID,String UserID);

    //删除书评时同步删除收藏书评记录
    void deleteCollectBookReview(Integer BookReviewID);

    //删除书评时同步删除书评评论
    void deleteRelatedComment(Integer BookReviewID);

    //删除书籍时同步删除相关书评
    void deleteRelatedBookReview(Integer BookID);

    //删除书籍时同步删除相关书评的相关评论
    void deleteRelatedBookReviewComment(Integer BookID);

    //删除书籍时同删除相关书评的收藏
    void deleteRelatedBookReviewCollection(Integer BookID);

    //获取书评的评论列表
    List<BookReviewComment> getBookReviewCommentList(Integer BookReviewID);

    //获取书评动态
    List<BookReview> getBookReviewDT(String UserID);

    //获取一本书的书评
    List<BookReview> getBookReviewListByBookID(Integer BookID);

    //判断是否收藏
    BookReviewCollection isCollect(String UserID,Integer BookReviewID);

    //获取我的书评
    List<BookReview> getMyBookReview(String UserID);
}
