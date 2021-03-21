using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_MessageBox : System.Web.UI.Page
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
        else if (e.CommandName == "Reply")
        {
            
        }
        else if (e.CommandName == "Edit")
        {
            string name = e.CommandArgument.ToString();
            reply.Text = "回复 " + name + ":";
        }
        else if (e.CommandName == "Del")
        {
            using (DataClassesDataContext db = new DataClassesDataContext())
            {
                int id = Int16.Parse(e.CommandArgument.ToString());
                var me = db.LeaveMessage.SingleOrDefault<LeaveMessage>(s => s.LeaveMessageID == id);
                if (me == null)
                {
                    db.LeaveMessage.DeleteOnSubmit(me);
                    db.SubmitChanges();
                }
            }
            Response.Redirect("MessageBox.aspx");
        }
    }

    protected void Submit_onclick(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            LeaveMessage message = new LeaveMessage();
            message.Content = reply.Text;
            message.UserID = Session["UserID"].ToString();
            message.HostID = Session["HostID"].ToString();
            message.DateTime = DateTime.Now;

            db.LeaveMessage.InsertOnSubmit(message);
            db.SubmitChanges();
        }
    }
}