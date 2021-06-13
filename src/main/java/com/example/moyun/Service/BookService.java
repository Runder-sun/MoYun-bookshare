package com.example.moyun.Service;

import com.example.moyun.Entity.Book;
import com.example.moyun.Entity.BookCollection;
import com.example.moyun.Entity.ReadHistory;

import java.util.List;

public interface BookService {
    //删除Book
    void deleteBook(Integer BookID);

    //查看全部Book
    List<Book> getAllBook();

    //根据BookID查找Book
    Book getBookByBookID(Integer BookID);

    //搜索Book(BookName使用likes匹配)
    List<Book> searchBook(String BookName,String Tag);

    //根据阅读次数获取热门书籍（前8）
    List<Book> getHotBook();

    //根据UserID查找BookCollection
    List<BookCollection> getBookCollectionByUserID(String UserID);

    //上传新书籍
    void addBook(Book book);

    //更新书籍信息
    void updateBook(Integer BookID,String BookName,String Author,String Publisher,String ISBN,String Kind);

    //收藏图书
    void collectBook(BookCollection bookCollection);

    //取消收藏图书
    void cancelCollectBook(Integer BookCollectionID);

    //增加书籍的被阅读次数
    void plusReadTime(Integer BookID);

    //添加阅览记录
    void addReadHistory(ReadHistory readHistory);

    //删除书籍时同步删除书籍收藏
    void deleteBookCollection(Integer BookID);

    //删除书籍时同步删除阅读记录
    void deleteReadHistory(Integer BookID);

    //计算书籍评分
    void updateBookScore(Integer BookID);

    //判断是否收藏
    BookCollection isCollect(String UserID,Integer BookID);
}
