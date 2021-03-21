using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Administer_404NotFound : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void Return_onclick(object sender, EventArgs e)
    {
        Response.Redirect("../PersonalWeb/LettersList.aspx");
    }
    protected void Host_onclick(object sender, EventArgs e)
    {
        Response.Redirect("../PersonalWeb/PersonalHome.aspx");
    }
}