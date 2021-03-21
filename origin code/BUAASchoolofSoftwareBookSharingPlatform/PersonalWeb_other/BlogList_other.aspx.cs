using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_Blog_other : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            using (DataClassesDataContext db = new DataClassesDataContext())
            {
                User user = db.User.SingleOrDefault<User>(s => s.UserID == Session["HostID"]);
                HostName.Text = user.Name;
            }
            GridView1.Columns[0].Visible = false;
        }
    }
    private void BindGridView()
    {
        using (DataClassesDataContext bdc = new DataClassesDataContext())
        {
            var artList = from u in bdc.Blog where u.UserID == Session["HostID"] select u;
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
}