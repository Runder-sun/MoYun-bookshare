using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PlatHome_PlatHome : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        Init();
        Init1();
        Init2();
        Init3();
        Init4();
        Init5();
        Init6();
        Init7();
    }
    
    protected void Init()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            Session["HostID"] = Session["UserID"];

            var user = db.User.SingleOrDefault<User>(s => s.UserID == Session["HostID"]);
            Name.Text = user.Name;
            if (user.Identity == "教师") Grade.Text = "教师";
            else Grade.Text = user.Grade + "级本科生";

            Signature.Text = user.Signature;
            UserImage.ImageUrl = user.UserImagePath;
        }
    }
    
    protected void Init1()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            liter_num.Text = (from vs in db.Book where vs.Category == "文学" select vs).Count().ToString();
            popu_num.Text = (from vs in db.Book where vs.Category == "流行" select vs).Count().ToString();
            cus_num.Text = (from vs in db.Book where vs.Category == "文化" select vs).Count().ToString();
            life_num.Text = (from vs in db.Book where vs.Category == "生活" select vs).Count().ToString();
            ecom_num.Text = (from vs in db.Book where vs.Category == "经济" select vs).Count().ToString();
            tec_num.Text = (from vs in db.Book where vs.Category == "科技" select vs).Count().ToString();
        }
    }

    protected void Init2()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var te1 = (from vs in db.Blog where vs.DateTime.Date == DateTime.Now.Date select vs);
            today_blog.Text = te1.Count().ToString();

            var te2 = (from vs in te1 join u in db.User on vs.UserID equals u.UserID select u.Name);
            List<string> namelist = new List<string>();
            foreach (var name in te2) namelist.Add(name.ToString());

            if (namelist.Count > 0) blog1.Text = namelist[0] + "发表了博客";
            if (namelist.Count > 1) blog2.Text = namelist[1] + "发表了博客";
            if (namelist.Count > 2) blog3.Text = namelist[2] + "发表了博客";
            if (namelist.Count > 3) blog4.Text = namelist[3] + "发表了博客";
            if (namelist.Count > 4) blog5.Text = namelist[4] + "发表了博客";
        }
    }

    protected void Init3()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var te1 = (from vs in db.Forum where vs.DateTime.Date == DateTime.Now.Date select vs);
            today_book.Text = te1.Count().ToString();

            var te2 = (from vs in te1 join u in db.User on vs.UserID equals u.UserID select u.Name);
            List<string> namelist = new List<string>();
            foreach (var name in te2) namelist.Add(name.ToString());

            if (namelist.Count > 0) book1.Text = namelist[0] + "创建了讨论区";
            if (namelist.Count > 1) book2.Text = namelist[1] + "创建了讨论区";
            if (namelist.Count > 2) book3.Text = namelist[2] + "创建了讨论区";
            if (namelist.Count > 3) book4.Text = namelist[3] + "创建了讨论区";
            if (namelist.Count > 4) book5.Text = namelist[4] + "创建了讨论区";
        }
    }

    protected void Init4()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var te1 = (from vs in db.BookReview where vs.DateTime.Date == DateTime.Now.Date select vs);
            today_com.Text = te1.Count().ToString();

            var te2 = (from vs in te1 join u in db.User on vs.UserID equals u.UserID select u.Name);
            List<string> namelist = new List<string>();
            foreach (var name in te2) namelist.Add(name.ToString());

            if (namelist.Count > 0) com1.Text = namelist[0] + "发表了书评";
            if (namelist.Count > 1) com2.Text = namelist[1] + "发表了书评";
            if (namelist.Count > 2) com3.Text = namelist[2] + "发表了书评";
            if (namelist.Count > 3) com4.Text = namelist[3] + "发表了书评";
            if (namelist.Count > 4) com5.Text = namelist[4] + "发表了书评";
        }
    }

    protected void Init5()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            last_blog1.Text = (from vs in db.Blog where vs.DateTime.Date == DateTime.Now.Date.AddDays(-1) select vs).Count().ToString();
            last_blog2.Text = (from vs in db.Blog where vs.DateTime.Date == DateTime.Now.Date.AddDays(-2) select vs).Count().ToString();
            last_blog3.Text = (from vs in db.Blog where vs.DateTime.Date == DateTime.Now.Date.AddDays(-3) select vs).Count().ToString();
            last_blog4.Text = (from vs in db.Blog where vs.DateTime.Date == DateTime.Now.Date.AddDays(-4) select vs).Count().ToString();
            last_blog5.Text = (from vs in db.Blog where vs.DateTime.Date == DateTime.Now.Date.AddDays(-5) select vs).Count().ToString();
        }
    }

    protected void Init6()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            last_forum1.Text = (from vs in db.Forum where vs.DateTime.Date == DateTime.Now.Date.AddDays(-1) select vs).Count().ToString();
            last_forum2.Text = (from vs in db.Forum where vs.DateTime.Date == DateTime.Now.Date.AddDays(-2) select vs).Count().ToString();
            last_forum3.Text = (from vs in db.Forum where vs.DateTime.Date == DateTime.Now.Date.AddDays(-3) select vs).Count().ToString();
            last_forum4.Text = (from vs in db.Forum where vs.DateTime.Date == DateTime.Now.Date.AddDays(-4) select vs).Count().ToString();
            last_forum5.Text = (from vs in db.Forum where vs.DateTime.Date == DateTime.Now.Date.AddDays(-5) select vs).Count().ToString();
        }
    }

    protected void Init7()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            last_com1.Text = (from vs in db.BookReview where vs.DateTime.Date == DateTime.Now.Date.AddDays(-1) select vs).Count().ToString();
            last_com2.Text = (from vs in db.BookReview where vs.DateTime.Date == DateTime.Now.Date.AddDays(-2) select vs).Count().ToString();
            last_com3.Text = (from vs in db.BookReview where vs.DateTime.Date == DateTime.Now.Date.AddDays(-3) select vs).Count().ToString();
            last_com4.Text = (from vs in db.BookReview where vs.DateTime.Date == DateTime.Now.Date.AddDays(-4) select vs).Count().ToString();
            last_com5.Text = (from vs in db.BookReview where vs.DateTime.Date == DateTime.Now.Date.AddDays(-5) select vs).Count().ToString();
        }
    }
}