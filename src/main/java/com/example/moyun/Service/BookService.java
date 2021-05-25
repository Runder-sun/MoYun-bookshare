package com.example.moyun.Service;

import com.example.moyun.Entity.Book;
import com.example.moyun.Vo.BookVo;

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

    //BookList转成BookVoList
    List<BookVo> BookToBookVo(List<Book> list);

    //根据阅读次数获取热门书籍（前8）
    List<Book> getHotBook();
}
