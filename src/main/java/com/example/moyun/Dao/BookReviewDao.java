package com.example.moyun.Dao;

import com.example.moyun.Entity.BookReview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookReviewDao {
    void deleteBookReview(Integer BookReviewID);

    List<BookReview> getAllBookReview();

    BookReview getBookReviewByBookReviewID(Integer BookReviewID);
}
