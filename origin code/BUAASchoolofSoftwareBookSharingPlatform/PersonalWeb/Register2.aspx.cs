using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_Register2 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Next_onclick(object sender, EventArgs e)
    {
        if (sex_f.Checked) Session["Sex"] = "男";
        else Session["Sex"] = "女";

        if (id_stu.Checked) Session["Identity"] = "学生";
        else Session["Identity"] = "教师";

        if (Session["Identity"] != "教师")
        {
            if (gra_12.Checked) Session["Grade"] = "2012";
            else if (gra_13.Checked) Session["Grade"] = "2013";
            else if (gra_14.Checked) Session["Grade"] = "2014";
            else Session["Grade"] = "2015";
        }

        Session["Birthday"] = birth.Value;
        Session["Email"] = email.Value;

        if (!IsVaild(birth.Value)){
            Response.Write("<script language=javascript>alert('日期不合法~')</script>");
            return;
        }
        Response.Redirect("Register3.aspx");
    }
    protected void Return_onclick(object sender, EventArgs e)
    {
        if (Session["Sex"] != null) Session.Remove("Sex");
        if (Session["Identity"] != null) Session.Remove("Identity");
        if (Session["Grade"] != null) Session.Remove("Grade");
        if (Session["Birthday"] != null) Session.Remove("Birthday");
        if (Session["Email"] != null) Session.Remove("Email");

        Response.Redirect("Register1.aspx");
    }
    protected bool IsVaild(string birth)
    {
        int a, b, c;
        a = Int32.Parse(birth.Substring(0,4));
        b = Int32.Parse(birth.Substring(5, 2));
        c = Int32.Parse(birth.Substring(8, 2));
        if (b<=12&&c<=31) 
        {
            if (!((a%4==0&&a%100!=0)||a%400==0) && c == 29) return false;
            else if ((b == 4 || b == 6 || b == 9 || b ==11) && c == 31) return false;
            else return true; 
        } 
          else return false; 
    } 
}