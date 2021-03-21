using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Administer_Administer : System.Web.UI.MasterPage
{
    protected void Page_Load(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            Session["HostID"] = Session["UserID"];

            var user = db.User.SingleOrDefault<User>(s => s.UserID == Session["HostID"]);
            Name.Text = user.Name;
            Grade.Text = "管理员";
            UserImage.ImageUrl = user.UserImagePath;
        }
    }
}
