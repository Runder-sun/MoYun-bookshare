using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Setting_Help_Log_Out : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        UserID.Text = Session["UserID"] + " 用户";
    }

    protected void Log_Out_onclick(object sender, EventArgs e)
    {
        Session.Clear();
        Response.Redirect("~/PersonalWeb/Login.aspx");
    }

    protected void Return_onclick(object sender, EventArgs e)
    {

    }
}