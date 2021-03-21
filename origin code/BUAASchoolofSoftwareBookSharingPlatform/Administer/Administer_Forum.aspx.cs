using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Web.UI.HtmlControls;

public partial class Administer_Administer_Forum : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

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
                int id1 = Int16.Parse(id.ToString());
                var user = db.Participant.SingleOrDefault<Participant>(s => s.ParticipantID == id1);
                if (user != null)
                {
                    db.Participant.DeleteOnSubmit(user);                  
                    db.SubmitChanges();
                }
            }
            //Response.Redirect("BlogList.aspx");
        }
        else if (e.CommandName == "Scan")
        {
            Session["HostID"] = e.CommandArgument.ToString();
            Response.Redirect("../PersonalWeb_other/ScanInfo.aspx");
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
                int id = Int16.Parse(str.ToString());
                var user = db.Participant.SingleOrDefault<Participant>(s => s.ParticipantID == id);
                if (user != null)
                {
                    db.Participant.DeleteOnSubmit(user);
                    db.SubmitChanges();
                }
            }
            db.SubmitChanges();
        }
        //Response.Redirect("BlogList.aspx");
    }
}