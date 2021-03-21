using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class QuanZi_CreateQuanZi : System.Web.UI.Page
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

        }
    }

    /// <summary>
    /// 保存按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void Button1_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)
        {
            DataClassesDataContext db = new DataClassesDataContext();
            QuanZi qz = new QuanZi();
            qz.UserID = Session["UserID"].ToString();
            qz.QuanZiName = quanzinametextbox.Text;
            qz.CreatorCourse = coursetextbox.Text;
            qz.CreatorTel = teltextbox.Text;
            qz.CreatorAddress = addresstextbox.Text;
            qz.DateTime = DateTime.Now;
            db.QuanZi.InsertOnSubmit(qz);
            db.SubmitChanges();

            User user = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());
            user.QuanZiID = qz.QuanZiID;
            db.SubmitChanges();
            Session["QuanZiID"] = qz.QuanZiID;
            
            Response.Write(" <script language=javascript>alert('创建成功');window.window.location.href='ScanInfo.aspx?';</script> ");
        }
    }
}