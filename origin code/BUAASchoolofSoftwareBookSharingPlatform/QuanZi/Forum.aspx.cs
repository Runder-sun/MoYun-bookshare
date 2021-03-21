using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Web.UI.HtmlControls;

public partial class QuanZi_Forum_ : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// 下面的是三个函数都是用作分页的后台代码
    /// </summary>
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
    }

    protected void Reply_onclick(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            Participant p = new Participant();
            p.UserID = Session["UserID"].ToString();
            p.ForumID = Int16.Parse(Request["ForumID"].ToString());
            p.DateTime = DateTime.Now;
            p.Content = reply.Value;

            db.Participant.InsertOnSubmit(p);
            db.SubmitChanges();
        }
        GridView1.DataBind();
    }

    protected void Return_onclick(object sender, EventArgs e)
    {
        Response.Redirect("ForumList.aspx");
    }
}