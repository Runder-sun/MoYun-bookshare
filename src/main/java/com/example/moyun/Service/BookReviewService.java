package com.example.moyun.Service;

import com.example.moyun.Entity.BookReview;
import com.example.moyun.Vo.BookReviewVo;

import java.util.List;

public interface BookReviewService {
    //删除BookReview
    void deleteBookReview(Integer BookReviewID);

    //查看全部BookReview
    List<BookReview> getAllBookReview();

    //根据BookReviewID查找BookReview
    BookReview getBookReviewByBookReviewID(Integer BookReviewID);

    //BookReviewList转BookReviewVoList
    List<BookReviewVo> BookReviewToBookReviewVo(List<BookReview> list);
}
