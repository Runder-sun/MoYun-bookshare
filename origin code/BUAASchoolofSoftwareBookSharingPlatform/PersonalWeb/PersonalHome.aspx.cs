using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PersonalWeb_Personal_Home : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            Session["HostID"] = Session["UserID"];
        }
        Init1();
        Init2();
        Init3();
        Init4();
        Init5();
        Init6();
    }

    protected void Init1()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var today_num = (from vs in db.VisitRecord where vs.Date == DateTime.Now.Date select vs).Count();
            today_visit.Text = today_num.ToString();

            var te = (from vs in db.VisitRecord where vs.Date == DateTime.Now.Date select vs);
            var today1 = (from vs in te
                          join u in db.User on vs.UserID equals u.UserID
                          where vs.HostID == Session["UserID"].ToString()
                          select u.Name).Distinct().Take(5);

            List<string> namelist = new List<string>();
            foreach(var name in today1) namelist.Add(name.ToString());
            if (namelist.Count > 0) today1_name1.Text = namelist[0] + "访问了您";
            if (namelist.Count > 1) today1_name2.Text = namelist[1] + "访问了您";
            if (namelist.Count > 2) today1_name3.Text = namelist[2] + "访问了您";
            if (namelist.Count > 3) today1_name4.Text = namelist[3] + "访问了您";
            if (namelist.Count > 4) today1_name5.Text = namelist[4] + "访问了您";
        }
    }

    protected void Init2()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var today_num = (from ms in db.LeaveMessage where ms.DateTime.Date == DateTime.Now.Date select ms).Count();
            today_message.Text = today_num.ToString();

            var te = (from ms in db.LeaveMessage where ms.DateTime.Date == DateTime.Now.Date select ms);
            var today1 = (from ms in te
                          join u in db.User on ms.UserID equals u.UserID
                          where ms.HostID == Session["UserID"].ToString()
                          select u.Name).Distinct().Take(5);

            List<string> namelist = new List<string>();
            foreach (var name in today1) namelist.Add(name.ToString());
            if (namelist.Count > 0) today2_name1.Text = namelist[0] + "给您留言了";
            if (namelist.Count > 1) today2_name2.Text = namelist[1] + "给您留言了";
            if (namelist.Count > 2) today2_name3.Text = namelist[2] + "给您留言了";
            if (namelist.Count > 3) today2_name4.Text = namelist[3] + "给您留言了";
            if (namelist.Count > 4) today2_name5.Text = namelist[4] + "给您留言了";
        }
    }

    protected void Init3()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var today_num = (from vs in db.BlogComment where vs.DateTime.Date == DateTime.Now.Date select vs).Count();
            today_conment.Text = today_num.ToString();

            var te = (from vs in db.BlogComment where vs.DateTime.Date == DateTime.Now.Date select vs);
            var te2 = (from vs in db.Blog where vs.UserID == Session["UserID"].ToString() select vs);
            var te3 = (from vs in te join ms in te2 on vs.BlogID equals ms.BlogID select vs);
            var today1 = (from vs in te3
                          join u in db.User on vs.UserID equals u.UserID
                          select u.Name).Distinct().Take(5);

            List<string> namelist = new List<string>();
            foreach (var name in today1) namelist.Add(name.ToString());
            if (namelist.Count > 0) today3_name1.Text = namelist[0] + "评论了日志";
            if (namelist.Count > 1) today3_name2.Text = namelist[1] + "评论了日志";
            if (namelist.Count > 2) today3_name3.Text = namelist[2] + "评论了日志";
            if (namelist.Count > 3) today3_name4.Text = namelist[3] + "评论了日志";
            if (namelist.Count > 4) today3_name5.Text = namelist[4] + "评论了日志";
        }
    }

    protected void Init4()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var te1 = (from vs in db.VisitRecord where vs.HostID == Session["UserID"].ToString() select vs);

            var num1 = (from vs in te1 where vs.Date == DateTime.Now.Date.AddDays(-1) select vs).Count();
            var num2 = (from vs in te1 where vs.Date == DateTime.Now.Date.AddDays(-2) select vs).Count();
            var num3 = (from vs in te1 where vs.Date == DateTime.Now.Date.AddDays(-3) select vs).Count();
            var num4 = (from vs in te1 where vs.Date == DateTime.Now.Date.AddDays(-4) select vs).Count();
            var num5 = (from vs in te1 where vs.Date == DateTime.Now.Date.AddDays(-5) select vs).Count();

            last1_day1.Text = num1.ToString();
            last1_day2.Text = num2.ToString();
            last1_day3.Text = num3.ToString();
            last1_day4.Text = num4.ToString();
            last1_day5.Text = num5.ToString();
        }
    }

    protected void Init5()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var te1 = (from vs in db.LeaveMessage where vs.HostID == Session["UserID"].ToString() select vs);

            var num1 = (from vs in te1 where vs.DateTime.Date == DateTime.Now.Date.AddDays(-1) select vs).Count();
            var num2 = (from vs in te1 where vs.DateTime.Date == DateTime.Now.Date.AddDays(-2) select vs).Count();
            var num3 = (from vs in te1 where vs.DateTime.Date == DateTime.Now.Date.AddDays(-3) select vs).Count();
            var num4 = (from vs in te1 where vs.DateTime.Date == DateTime.Now.Date.AddDays(-4) select vs).Count();
            var num5 = (from vs in te1 where vs.DateTime.Date == DateTime.Now.Date.AddDays(-5) select vs).Count();

            last2_day1.Text = num1.ToString();
            last2_day2.Text = num2.ToString();
            last2_day3.Text = num3.ToString();
            last2_day4.Text = num4.ToString();
            last2_day5.Text = num5.ToString();
        }
    }

    protected void Init6()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var te1 = (from vs in db.Blog where vs.UserID == Session["UserID"].ToString() select vs);
            var te2 = (from vs in db.BlogComment join u in te1 on vs.BlogID equals u.BlogID select vs);

            var num1 = (from vs in te2 where vs.DateTime.Date == DateTime.Now.Date.AddDays(-1) select vs).Count();
            var num2 = (from vs in te2 where vs.DateTime.Date == DateTime.Now.Date.AddDays(-2) select vs).Count();
            var num3 = (from vs in te2 where vs.DateTime.Date == DateTime.Now.Date.AddDays(-3) select vs).Count();
            var num4 = (from vs in te2 where vs.DateTime.Date == DateTime.Now.Date.AddDays(-4) select vs).Count();
            var num5 = (from vs in te2 where vs.DateTime.Date == DateTime.Now.Date.AddDays(-5) select vs).Count();

            last3_day1.Text = num1.ToString();
            last3_day2.Text = num2.ToString();
            last3_day3.Text = num3.ToString();
            last3_day4.Text = num4.ToString();
            last3_day5.Text = num5.ToString();
        }
    }
}