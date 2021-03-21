using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_WriteBlog : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Submit_onclick(object sender, EventArgs e)
    {
        Blog blog = new Blog();
        blog.Title = title.Value.ToString();
        blog.Content = blogcontent.Text.ToString();
        blog.UserID = Session["UserID"].ToString();
        blog.DateTime = DateTime.Now;
        blog.VisitNumber = 0;

        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            db.Blog.InsertOnSubmit(blog);
            db.SubmitChanges();

            User user = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());
            if(user.QuanZiID != null)
            {
                News news = new News();
                news.QuanZiID = user.QuanZiID;
                news.Title = user.Name + "发表了：日志《" + blog.Title + "》";
                news.HyperLink = "../PersonalWeb_other/ScanBlog_other.aspx?BlogID="+blog.BlogID;
                news.DateTime = DateTime.Now;
                news.UserID = Session["UserID"].ToString();

                db.News.InsertOnSubmit(news);
                db.SubmitChanges();
            }

            Letter letter = new Letter();
            letter.UserID = Session["UserID"].ToString();
            letter.HyperLink = "../PersonalWeb_other/ScanBlog_other.aspx?BlogID="+blog.BlogID;
            letter.DateTime = DateTime.Now;
            letter.Title = user.Name+"发表了日志《"+blog.Title+"》";
            db.Letter.InsertOnSubmit(letter);
            db.SubmitChanges();
        }
        Response.Redirect("ScanBlog.aspx?BlogID="+blog.BlogID);
    }
    protected void Return_onclick(object sender, EventArgs e)
    {

    }
}