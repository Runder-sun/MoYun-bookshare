using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_ScanBlog_other : System.Web.UI.Page
{
    private int blogID;
    protected void Page_Load(object sender, EventArgs e)
    {
        Init_Page();
    }

    void Init_Page()
    {
        GridView1.Columns[0].Visible = false;
        Session["BlogID"] = Request["BlogID"].ToString();
        blogID = Int16.Parse(Request["BlogID"].ToString());
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var blog = db.Blog.SingleOrDefault<Blog>(s => s.BlogID == blogID);
            title.Text = blog.Title;
            content.Text = blog.Content;
            blog.VisitNumber = blog.VisitNumber + 1;

            db.SubmitChanges();
        }
        this.Page.ClientScript.RegisterStartupScript(this.Page.GetType(), "", "<script>BodyOnLoad();</script>", true);
        content.ReadOnly = true;
        //content.Height = 10 * content.Rows;
    }

    protected void Return_onclick(object sender, EventArgs e)
    {
        Response.Redirect("BlogList_other.aspx");
    }

    private void BindGridView()
    {
        using (DataClassesDataContext bdc = new DataClassesDataContext())
        {
            var artList = from u in bdc.Blog where u.UserID == Session["UserID"] select u;
            //var artList = bdc.Blog_GetAllCommentationArticles();
            //Blog_GetAllCommentationArticlesResult g = new Blog_GetAllCommentationArticlesResult();

            GridView1.DataSource = artList;
            GridView1.DataBind();
        }
    }

    protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
    {
        try
        {
            GridView1.PageIndex = e.NewPageIndex;
            BindGridView();

            TextBox tb = (TextBox)GridView1.BottomPagerRow.FindControl("inPageNum");
            tb.Text = (GridView1.PageIndex + 1).ToString();
        }
        catch
        {
        }
    }

    protected void GridView1_RowCommand(object sender, GridViewCommandEventArgs e)
    {
        if (e.CommandName == "go")
        {
            try
            {
                TextBox tb = (TextBox)GridView1.BottomPagerRow.FindControl("inPageNum");
                int num = Int32.Parse(tb.Text);
                GridViewPageEventArgs ea = new GridViewPageEventArgs(num - 1);
                GridView1_PageIndexChanging(null, ea);
            }
            catch
            {
            }
        }
        else if (e.CommandName == "Delete")
        {
            int id = Convert.ToInt32(e.CommandArgument);
            using (DataClassesDataContext db = new DataClassesDataContext())
            {
                var blog = db.Blog.SingleOrDefault<Blog>(s => s.BlogID == id);
                if (blog != null)
                {
                    db.Blog.DeleteOnSubmit(blog);
                    db.SubmitChanges();
                }
            }
            Response.Redirect("BlogList.aspx");
        }
    }

    protected void Submit_onclick(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            BlogComment bcom = new BlogComment();
            bcom.UserID = Session["UserID"].ToString();
            bcom.DateTime = DateTime.Now;
            bcom.Content = comment.Value;
            bcom.BlogID = Int16.Parse(Request["BlogID"].ToString());

            db.BlogComment.InsertOnSubmit(bcom);
            db.SubmitChanges();
            GridView1.DataBind();
        }
    }

    protected void Recreate_onclick(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            Blog blog = new Blog();
            blog.BlogID = Int16.Parse(Request["BlogID"].ToString());
            blog.Title = "（转载）" + title.Text;
            blog.Content = content.Text;
            blog.UserID = Session["UserID"].ToString();
            blog.DateTime = DateTime.Now;
            blog.VisitNumber = 0;

            db.Blog.InsertOnSubmit(blog);
            db.SubmitChanges();
            User user = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());
            if (user.QuanZiID != null)
            {
                News news = new News();
                news.QuanZiID = user.QuanZiID;
                news.Title = user.Name + "转载了：日志《" + blog.Title + "》";
                news.HyperLink = "../PersonalWeb_other/ScanBlog_other.aspx?BlogID=" + blog.BlogID;
                news.DateTime = DateTime.Now;
                news.UserID = Session["UserID"].ToString();
            
                db.News.InsertOnSubmit(news);
                db.SubmitChanges();
            }  
        }
    }
}