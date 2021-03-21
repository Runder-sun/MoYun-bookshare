using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class 书库_EditBook : System.Web.UI.Page
{
    /// <summary>
    /// 加载页面
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            deletebutton.Attributes["OnClick"] = "return confirm('确认删除这篇书评吗?')";//给删除按钮添加确认功能
            InitBookReviewInfo();//初始化书评信息
        }
    }

    /// <summary>
    /// 初始化书评信息
    /// </summary>
    protected void InitBookReviewInfo()
    {
        DataClassesDataContext db = new DataClassesDataContext();
        var br = from b in db.BookReview where b.BookReviewID.ToString() == Request["BookReviewID"] select b;
        infolabel.Text = "您正在为" + br.FirstOrDefault().BookName.ToString() + "写书评";//给提示标签添加信息
        titletextbox.Text = br.FirstOrDefault().Title;
        contenttextbox.Text = br.FirstOrDefault().Content;
    }

    /// <summary>
    /// 保存按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void publishbutton_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)
        {
            //如果输入合法将日志写入数据库
            DataClassesDataContext db = new DataClassesDataContext();
            db.ExecuteCommand("UPDATE BookReview SET Title = '" + titletextbox.Text + "' , DateTime = '" + DateTime.Now.ToString() + "' , Content = '" + contenttextbox.Text + "' WHERE BookReviewID = {0}", Convert.ToInt32(Request["BookReviewID"]));
            db.SubmitChanges();


            var tempuser = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());
            if (tempuser.QuanZiID != null)
            {
                News n = new News();
                n.QuanZiID = tempuser.QuanZiID;
                n.Title = Session["Name"].ToString() + "修改书评：" + titletextbox.Text;
                n.UserID = Session["UserID"].ToString();
                n.DateTime = DateTime.Now;
                n.HyperLink = "~/BookWareHouse/CheckBookReview.aspx?BookReviewID=" + Request["BookReviewID"];
                db.News.InsertOnSubmit(n);
                db.SubmitChanges();
            }
            Response.Write(" <script language=javascript>alert('修改成功');window.window.location.href='CheckBookReview.aspx?BookReviewID=" + Request["BookReviewID"] + "';</script> ");
        }
    }

    /// <summary>
    /// 删除按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void deletebutton_Click(object sender, EventArgs e)
    {
        //在数据库中删除该书评记录，跳转到我的书评界面
        DataClassesDataContext db = new DataClassesDataContext();
        db.ExecuteCommand("delete from BookReview where BookReviewID = '" + Request["BookReviewID"].ToString() + "'");
        db.SubmitChanges();
        Response.Write(" <script language=javascript>alert('删除成功');window.window.location.href='BookReview.aspx';</script> ");
    }
}