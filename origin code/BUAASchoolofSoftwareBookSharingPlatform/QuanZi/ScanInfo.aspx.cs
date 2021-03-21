using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Web.UI.HtmlControls;

public partial class QuanZi_ScanInfo : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        Init();
    }

    protected void Init()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            User user = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"]);
            if(user == null) return;

            if (user.Identity == "学生")
            {
                Modify.Visible = false;
                add.Visible = false;
                GridView1.Columns[4].Visible = false;
            }

            name.Text = user.Name;
            sex.Text = user.Sex;
            email.Text = user.Email;
            Image1.ImageUrl = user.UserImagePath;

            QuanZi quanzi = db.QuanZi.SingleOrDefault<QuanZi>(s => s.QuanZiID == Int16.Parse(Session["QuanZiID"].ToString()));
            if (quanzi == null) return;
            course.Text = quanzi.CreatorCourse;
            address.Text = quanzi.CreatorAddress;
            tel.Text = quanzi.CreatorTel;
        }
        name.Enabled = false; name.BorderStyle = BorderStyle.None;
        sex.Enabled = false; sex.BorderStyle = BorderStyle.None;
        tel.Enabled = false; tel.BorderStyle = BorderStyle.None;
        address.Enabled = false; address.BorderStyle = BorderStyle.None;
        course.Enabled = false; course.BorderStyle = BorderStyle.None;
        email.Enabled = false; email.BorderStyle = BorderStyle.None;
        Save.Visible = false;
    }
    /// <summary>
    /// 获取选中的博客代码
    /// </summary>
    /// <param name="GridViewMain"></param>
    /// <param name="RowCheckBoxName"></param>
    /// <param name="RowHiddenInputName"></param>
    /// <returns></returns>
    private static string RetrieveCheckValue(GridView GridViewMain, string RowCheckBoxName, string RowHiddenInputName)
    {
        string a = "";
        foreach (GridViewRow GridViewMainItem in GridViewMain.Rows)
        {
            HtmlInputCheckBox chk = (HtmlInputCheckBox)(GridViewMainItem.FindControl(RowCheckBoxName));
            HtmlInputHidden hiInput = (HtmlInputHidden)(GridViewMainItem.FindControl(RowHiddenInputName));
            if (chk.Checked == true)
            {
                a += "," + hiInput.Value;
            }
        }
        if (a != "")
        {
            a = a.Substring(1, a.Length - 1);
        }

        return a;
    }


    /// <summary>
    /// 下面的是三个函数都是用作分页的后台代码
    /// </summary>
    private void BindGridView()
    {
        using (DataClassesDataContext bdc = new DataClassesDataContext())
        {
            var artList = from u in bdc.Blog where u.UserID == Session["UserID"] select u;
            //var artList = bdc.Blog_GetAllCommentationArticles();
            //Blog_GetAllCommentationArticlesResult g = new Blog_GetAllCommentationArticlesResult();

            GridView1.DataSource = artList;
            GridView1.DataBind();
        }
    }

    protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
    {
        try
        {
            GridView1.PageIndex = e.NewPageIndex;
            BindGridView();

            TextBox tb = (TextBox)GridView1.BottomPagerRow.FindControl("inPageNum");
            tb.Text = (GridView1.PageIndex + 1).ToString();
        }
        catch
        {
        }
    }

    protected void GridView1_RowCommand(object sender, GridViewCommandEventArgs e)
    {
        if (e.CommandName == "go")
        {
            try
            {
                TextBox tb = (TextBox)GridView1.BottomPagerRow.FindControl("inPageNum");
                int num = Int32.Parse(tb.Text);
                GridViewPageEventArgs ea = new GridViewPageEventArgs(num - 1);
                GridView1_PageIndexChanging(null, ea);
            }
            catch
            {
            }
        }
        else if (e.CommandName == "Del")
        {
            string id = e.CommandArgument.ToString();
            using (DataClassesDataContext db = new DataClassesDataContext())
            {
                var user = db.User.SingleOrDefault<User>(s => s.UserID == id);
                if (user != null)
                {
                    user.QuanZiID = null;
                }
                db.SubmitChanges();
            }
            GridView1.DataBind();
            //Response.Redirect("BlogList.aspx");
        }
        else if (e.CommandName == "Scan")
        {
            Session["HostID"] = e.CommandArgument.ToString();
            Response.Redirect("../PersonalWeb_other/ScanInfo_other.aspx");
        }
    }
    protected void DAL_onclick(object sender, EventArgs e)
    {
        string ID = RetrieveCheckValue(GridView1, "cbChecked", "HiddenSysCode");
        string[] numbers = ID.Trim().Split(',');

        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            foreach (string str in numbers)
            {
                var user = db.User.SingleOrDefault<User>(s => s.UserID == str);
                if (user != null)
                    db.User.DeleteOnSubmit(user);
            }
            db.SubmitChanges();
        }
        //Response.Redirect("BlogList.aspx");
    }
    protected void ModifyMessage_Click(object sender, EventArgs e)
    {
        name.Enabled = true; name.BorderStyle = BorderStyle.NotSet;
        sex.Enabled = true; sex.BorderStyle = BorderStyle.NotSet;
        tel.Enabled = true; tel.BorderStyle = BorderStyle.NotSet;
        address.Enabled = true; address.BorderStyle = BorderStyle.NotSet;
        course.Enabled = true; course.BorderStyle = BorderStyle.NotSet;
        email.Enabled = true; email.BorderStyle = BorderStyle.NotSet;
        Save.Visible = true;
    }

    protected void Save_onclick(object sender, EventArgs e)
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            User user = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"]);
            if (user == null) return;

            user.Name = name.Text;
            user.Sex = sex.Text;
            user.Email = email.Text;

            QuanZi quanzi = db.QuanZi.SingleOrDefault<QuanZi>(s => s.QuanZiID == Int16.Parse(Session["QuanZiID"].ToString()));
            if (quanzi == null) return;
            quanzi.CreatorCourse = course.Text;
            quanzi.CreatorAddress = address.Text;
            quanzi.CreatorTel = tel.Text;

            db.SubmitChanges();
        }
        name.Enabled = false; name.BorderStyle = BorderStyle.None;
        sex.Enabled = false; sex.BorderStyle = BorderStyle.None;
        tel.Enabled = false; tel.BorderStyle = BorderStyle.None;
        address.Enabled = false; address.BorderStyle = BorderStyle.None;
        course.Enabled = false; course.BorderStyle = BorderStyle.None;
        email.Enabled = false; email.BorderStyle = BorderStyle.None;
        Save.Visible = false;
    }

    protected void Add_onclick(object sender, EventArgs e)
    {
        Response.Redirect("AddMembers.aspx");
    }
}