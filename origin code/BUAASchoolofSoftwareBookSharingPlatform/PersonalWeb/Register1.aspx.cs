using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_Register1 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void next_onclick(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            User user = db.User.SingleOrDefault<User>(s => s.UserID == acc.Value);
            if (user != null)
            {
                Response.Write("<script language=javascript>alert('账号已经被别人占用了，换一个吧~');</script> ");
                return;
            }
        }
        if (pass1.Value != pass2.Value)
        {
            Response.Write("<script language=javascript>alert('两次输入的密码不一样~');</script> ");
            return;
        }
        else
        {
            Session["UserID"] = acc.Value;
            Session["Password"] = pass2.Value;
            Session["Name"] = name.Value;
            Response.Redirect("Register2.aspx");
        }
    }
    protected void return_onclick(object sender, EventArgs e)
    {
        Session.Clear();
    }
}