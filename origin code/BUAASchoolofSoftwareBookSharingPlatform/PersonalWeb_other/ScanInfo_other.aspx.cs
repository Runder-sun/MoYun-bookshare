using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_other_ScanInfo_other : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        Init();
    }

    protected void Init()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            User user = db.User.SingleOrDefault<User>(s => s.UserID == Session["HostID"].ToString());

            acc.Value = user.UserID;
            name.Value = user.Name;
            iden.Value = user.Identity;
            birth.Value = user.Birthday;
            sex.Value = user.SecurityA;
            grade.Value = user.Grade + "级";
            singn.Text = user.Signature;
        }
    }
}