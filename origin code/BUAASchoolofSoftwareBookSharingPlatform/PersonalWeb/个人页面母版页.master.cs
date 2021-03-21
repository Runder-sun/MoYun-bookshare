using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class 个人页面_个人页面主页 : System.Web.UI.MasterPage
{
    protected void Page_Load(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            Session["HostID"] = Session["UserID"];

            var user = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());
            Name.Text = user.Name;
            if (user.Identity == "教师") Grade.Text = "教师";
            else Grade.Text = user.Grade + "级本科生";

            Signature.Text = user.Signature;
            UserImage.ImageUrl = user.UserImagePath;
        }
    }
}
