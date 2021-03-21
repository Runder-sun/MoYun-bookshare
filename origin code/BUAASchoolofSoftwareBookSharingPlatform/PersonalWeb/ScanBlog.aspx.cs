using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_ScanBlog : System.Web.UI.Page
{
    private int blogID;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            
        }
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
            blog_content.Text = blog.Content;
            
        }
        this.Page.ClientScript.RegisterStartupScript(this.Page.GetType(), "", "<script>BodyOnLoad();</script>", true);
        blog_content.ReadOnly = true;
    }

    protected void Edit_onclick(object sender, EventArgs e)
    {
        blog_content.ReadOnly = false;
    }
    protected void Save_onclick(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var blog = db.Blog.SingleOrDefault<Blog>(s => s.BlogID == blogID);
            blog.Title = title.Text;
            blog.Content = title.Text;
            blog_content.ReadOnly = true;
        }
    }
    protected void Delete_onclick(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var blog = db.Blog.SingleOrDefault<Blog>(s => s.BlogID == blogID);

            if (blog != null)
            {
                db.Blog.DeleteOnSubmit(blog);
                db.SubmitChanges();
            }
        }
        Response.Redirect("BlogList.aspx");
    }
    protected void Return_onclick(object sender, EventArgs e)
    {
        Response.Redirect("BlogList.aspx");
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
        else if (e.CommandName == "Del")
        {
            int id = Convert.ToInt32(e.CommandArgument);
            using (DataClassesDataContext db = new DataClassesDataContext())
            {
                var comment = db.BlogComment.SingleOrDefault<BlogComment>(s => s.BlogCommentID == id);
                if (comment != null)
                {
                    db.BlogComment.DeleteOnSubmit(comment);
                    db.SubmitChanges();
                    
                }
                GridView1.DataBind();
            }
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

            //Response.Redirect("ScanBlog.aspx?BlogID="+Request["BlogID"]);
            GridView1.DataBind();
        }
    }
}