using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_Login : System.Web.UI.Page
{
    public void Page_Load(object sender, EventArgs e)
    {

    }
    public void Login_onclick(object sender, EventArgs e)
    {
        string account = acc.Value, password = pass.Value,identity=null;
        if (std.Checked) identity = "学生";
        else if (tea.Checked) identity = "教师";
        else identity = "管理员";

        int result = IsVaild(account, password, identity);
        if (result == 1) Response.Redirect("PersonalHome.aspx?HostID=" + Session["UserID"]);
        else if (result == 2) Response.Redirect("../Administer/Administer_Members.aspx");
        else return;
    }
    public void Reg_onclick(object sender, EventArgs e)
    {
        Response.Redirect("Register1.aspx");
    }
    public void Lost_Pass_onclick(object sender, EventArgs e)
    {
        Response.Redirect("ForgotPassword.aspx");
    }
    public int IsVaild(string accout,string password,string identity)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var user = db.User.SingleOrDefault<User>(s => s.UserID == accout);
            if (user == null)
            {
                Label1.Text = "账号或者密码不正确";
                return 0;
            }

            if (user.Password != password)
            {
                Label1.Text = "账号或者密码不正确";
                return 0;
            }

            if (user.Identity != identity)
            {
                Response.Write("<script language=javascript>alert('请选择与自己账号匹配的身份奥~');</script> ");
                return 0;
            }

            Session["UserID"] = user.UserID;
            Session["Identity"] = user.Identity;
            Session["Name"] = user.Name;
            Session["QuanZiId"] = user.QuanZiID;
            Session["HostID"] = user.UserID;
            Session["ImageUrl"] = user.UserImagePath;

            Label1.Text = "";
            if (user.Identity == "管理员") return 2;
            else return 1;
        }
    }
}