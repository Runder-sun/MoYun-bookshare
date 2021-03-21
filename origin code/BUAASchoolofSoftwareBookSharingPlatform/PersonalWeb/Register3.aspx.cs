using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_Register3 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Next_onclick(object sender, EventArgs e)
    {
        Session["Secqu"] = sel.Items[sel.SelectedIndex].ToString();
        Session["Secans"] = ans.Value;

        Response.Redirect("Register4.aspx");
    }
    protected void Return_onclick(object sender, EventArgs e)
    {
        if(Session["Secqu"] != null) Session.Remove("Secqu");
        if(Session["Secans"] != null)  Session.Remove("Secans");
        Response.Redirect("Register2.aspx");
    }
}