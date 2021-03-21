using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Web.UI.HtmlControls;

public partial class PersonalWeb_BlogList : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        GridView1.Columns[1].Visible = false;
    }

    protected void WB_onclick(object sender, EventArgs e)
    {
        Response.Redirect("WriteBlog.aspx");
    }
    protected void DAL_onclick(object sender, EventArgs e)
    {
        string ID = RetrieveCheckValue(GridView1, "cbChecked", "HiddenSysCode");
        string[] numbers = ID.Trim().Split(',');

        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            foreach (string str in numbers)
            {
                int BlogID = Int16.Parse(str);
                var blog = db.Blog.SingleOrDefault<Blog>(s => s.BlogID == BlogID);
                if(blog != null)
                db.Blog.DeleteOnSubmit(blog);   
            }
            db.SubmitChanges();
        }
        Response.Redirect("BlogList.aspx");
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
            int id = Convert.ToInt32(e.CommandArgument);
            using (DataClassesDataContext db = new DataClassesDataContext())
            {
                var blog = db.Blog.SingleOrDefault<Blog>(s => s.BlogID == id);
                if (blog != null)
                {
                    db.Blog.DeleteOnSubmit(blog);
                    db.SubmitChanges();
                }
            }
            Response.Redirect("BlogList.aspx");
        }
        else if (e.CommandName == "edit")
        {
            string id = e.CommandArgument.ToString();
            Response.Redirect("ScanBlog.aspx?BlogID="+id);
        }
    }
}