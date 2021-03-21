using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_Letter : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

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
            int id = Int16.Parse(e.CommandArgument.ToString());
            using (DataClassesDataContext db = new DataClassesDataContext())
            {
                var blog = db.Blog.SingleOrDefault<Blog>(s => s.BlogID == id);
                if (blog != null)
                {
                    db.Blog.DeleteOnSubmit(blog);
                    db.SubmitChanges();
                }
            }
            Response.Redirect("Administer_Blog.aspx");
        }
        else if (e.CommandName == "Scan")
        {
            //Session["HostID"] = e.CommandArgument.ToString();
            Response.Redirect("../PersonalWeb_other/ScanBlog_other.aspx?BlogID=" + e.CommandArgument.ToString());
        }
    }
}