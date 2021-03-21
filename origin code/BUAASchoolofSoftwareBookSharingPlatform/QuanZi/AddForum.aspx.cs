using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class QuanZi_AddForum : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void Create_onclick(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            Forum forum = new Forum();
            forum.DateTime = DateTime.Now;
            forum.UserID = Session["UserID"].ToString();
            forum.Theme = theme.Value;
            forum.QuanZiID = Int16.Parse(Session["QuanZiID"].ToString());

            db.Forum.InsertOnSubmit(forum);
            db.SubmitChanges();
        }
        Response.Redirect("ForumList.aspx");
    }

    protected void Cancel_onclick(object sender, EventArgs e)
    {
        Response.Redirect("ForumList.aspx");
    }
}