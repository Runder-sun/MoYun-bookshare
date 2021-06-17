package com.example.moyun.Controller;

import com.example.moyun.Entity.*;
import com.example.moyun.Service.BookReviewService;
import com.example.moyun.Service.BookService;
import com.example.moyun.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookReviewService bookReviewService;
    @Autowired
    private UserService userService;

    @GetMapping("/bookWareHouse")//书库主页（已完成测试）
    public Map<String,Object> book(HttpServletRequest request){
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        Map<String,Object> map=new HashMap<>();
        try {
            List<Book> hotBooks=bookService.getHotBook();
            List<BookCollection> bookCollections= bookService.getBookCollectionByUserID(UserID);
            List<Book> books=new ArrayList<>();
            if(bookCollections.size()!=0){
                for(BookCollection bookCollection:bookCollections){
                    books.add(bookService.getBookByBookID(bookCollection.getBookID()));
                }
            }
            map.put("HotBook",hotBooks);
            map.put("BookCollection",bookCollections);
            map.put("BookCollectionBook",books);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/uploadBook")//上传书籍(已完成测试)
    public Map<String ,Object> uploadBook(HttpServletRequest request, @RequestParam("BookName") String BookName,@RequestParam("Author") String Author,
                                          @RequestParam("Publisher") String Publisher,@RequestParam("ISBN") String ISBN,@RequestParam("Kind") String Kind ,
                                          @RequestParam("Introduce") String Introduce, @RequestParam("BookFile") MultipartFile file1,@RequestParam("ImageFile")MultipartFile file2 ){
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        Map<String,Object> map=new HashMap<>();
        if (file1.isEmpty()||file2.isEmpty()){
            map.put("success",false);
            map.put("message","上传失败");
        }
        String filename1=file1.getOriginalFilename();
        String filename2=file2.getOriginalFilename();
        String newName1= UUID.randomUUID()+filename1;
        String newName2= UUID.randomUUID()+filename2;
        File dest1=new File(newName1);
        File dest2=new File(newName2);
        try {
            file1.transferTo(dest1);
            file2.transferTo(dest2);
            String Link=dest1.getPath();
            String BookImage=dest2.getPath();
            try{
                Book book=new Book();
                book.setBookName(BookName);
                book.setAuthor(Author);
                book.setISBN(ISBN);
                book.setKind(Kind);
                book.setLink(Link);
                book.setPublisher(Publisher);
                book.setBookImage(BookImage);
                book.setUserID(UserID);
                book.setIntroduce(Introduce);
                bookService.addBook(book);
                map.put("success",true);
                return map;
            }
            catch (Exception e){
                e.printStackTrace();
                map.put("success",false);
            }
        } catch (IOException e) {
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/deleteBook")//删除图书(已完成)
    public Map<String,Object> deleteBook(@RequestBody Map<String,String> dmap){
        Integer BookID=Integer.valueOf(dmap.get("BookID"));
        Map<String,Object> map=new HashMap<>();
        try {
            bookService.deleteReadHistory(BookID);
            bookService.deleteBookCollection(BookID);
            bookReviewService.deleteRelatedBookReviewCollection(BookID);
            bookReviewService.deleteRelatedBookReviewComment(BookID);
            bookReviewService.deleteRelatedBookReview(BookID);
            bookService.deleteBook(BookID);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/inspectBook")//查看书籍（已完成测试）
    public Map<String ,Object>inspectBook(HttpServletRequest request,@RequestBody Map<String,String> rmap){
        Integer BookID=Integer.valueOf(rmap.get("BookID"));
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        Timestamp ReadTime=new Timestamp(System.currentTimeMillis());
        Map<String,Object> map=new HashMap<>();
        try {
            Book book=bookService.getBookByBookID(BookID);
            ReadHistory readHistory=new ReadHistory();
            readHistory.setUserID(UserID);
            readHistory.setBookID(BookID);
            readHistory.setReadTime(ReadTime);
            User user=userService.getUserByUserID(bookService.getBookByBookID(BookID).getUserID());
            List<BookReview> bookReviews=bookReviewService.getBookReviewListByBookID(BookID);
            List<User> users=new ArrayList<>();
            if(bookReviews.size()!=0){
                for (BookReview bookReview:bookReviews){
                    users.add(userService.getUserByUserID(bookReview.getUserID()));
                }
            }
            boolean isCollect=bookService.isCollect(UserID,BookID)!=null;
            bookService.addReadHistory(readHistory);
            bookService.plusReadTime(BookID);
            map.put("book",book);
            map.put("bookAdder",user);
            map.put("bookReviewList",bookReviews);
            map.put("bookReviewUser",users);
            map.put("isCollect",isCollect);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/updateBook")//更新书籍信息（已完成测试）
    public Map<String,Object> updateBook(@RequestBody Map<String,String> umap){
        Integer BookID=Integer.valueOf(umap.get("BookID"));
        String BookName=umap.get("BookName");
        String Author=umap.get("Author");
        String Publisher=umap.get("Publisher");
        String ISBN=umap.get("ISBN");
        String Kind=umap.get("Kind");
        String Introduce=umap.get("Introduce");
        Map<String,Object> map=new HashMap<>();
        try {
            bookService.updateBook(BookID,BookName,Author,Publisher,ISBN,Kind,Introduce);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/collectBook")//收藏书籍（已完成测试）
    public Map<String,Object> collectBook(HttpServletRequest request,@RequestBody Map<String,String> cmap){
        Integer BookID=Integer.valueOf(cmap.get("BookID"));
        Timestamp CollectTime=new Timestamp(System.currentTimeMillis());
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        Map<String,Object> map=new HashMap<>();
        try {
            BookCollection bookCollection=new BookCollection();
            bookCollection.setBookID(BookID);
            bookCollection.setCollectTime(CollectTime);
            bookCollection.setUserID(UserID);
            bookService.collectBook(bookCollection);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/cancelCollectBook")//取消收藏书籍（已完成测试）
    public Map<String,Object> cancelCollectBook(HttpServletRequest request,@RequestBody Map<String,String> cancelCollectMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Integer BookID=Integer.valueOf(cancelCollectMap.get("BookID"));
        try {
            bookService.cancelCollectBook(BookID,UserID);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    /*@PostMapping("/searchBook")//查找书籍(已完成测试)
    public Map<String,Object> searchBook(@RequestBody Map<String,String> smap){
        String KeyWord=smap.get("KeyWord");
        String Tag=smap.get("Tag");
        Map<String,Object> map=new HashMap<>();
        try {
            List<Book> books=bookService.searchBook(KeyWord,Tag);
            map.put("book",books);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

     */

    @GetMapping("/searchBook")//查找书籍(已完成测试)
    public Map<String,Object> searchBook(){
        Map<String,Object> map=new HashMap<>();
        try {
            List<Book> books=bookService.getAllBook();
            map.put("book",books);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
