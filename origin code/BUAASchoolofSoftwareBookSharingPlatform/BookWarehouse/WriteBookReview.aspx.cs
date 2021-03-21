using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class 书库_WriteBookReview : System.Web.UI.Page
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
            using (DataClassesDataContext db = new DataClassesDataContext())
            {
                Book book = db.Book.SingleOrDefault<Book>(s => s.BookID == Int16.Parse(Request["BookID"].ToString())); 
                infolabel.Text = "您正在为" + book.Title.ToString() + "写书评";//给提示标签添加信息
            }
           
        }
    }

    /// <summary>
    /// 发表按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void publishbutton_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)
        {
            //如果输入合法将日志写入数据库
            DataClassesDataContext db = new DataClassesDataContext();
            BookReview br = new BookReview();
            br.BookID = Convert.ToInt16(Request["BookID"]);
            br.UserID = Session["UserID"].ToString();
            br.Content = contenttextbox.Text;
            br.DateTime = DateTime.Now;
            br.Score = 1;
            br.EvaluationNumbers = 0;
            br.Title = titletextbox.Text;
            br.UserName = Session["Name"].ToString();
            br.BookName = Session["BookName"].ToString();
            db.BookReview.InsertOnSubmit(br);
            db.SubmitChanges();
            string brid = br.BookReviewID.ToString();

            //如果圈子不为空在新鲜事中记录
            var tempuser = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());
            if(tempuser.QuanZiID != null)
            {
                News n = new News();
                n.QuanZiID = tempuser.QuanZiID;
                n.Title = Session["Name"].ToString() + "为 " + Session["BookName"].ToString() + " 写书评：" + titletextbox.Text;
                n.UserID = Session["UserID"].ToString();
                n.DateTime = DateTime.Now;
                n.HyperLink = "~/BookWareHouse/CheckBookReview.aspx?BookReviewID=" + brid;
                db.News.InsertOnSubmit(n);
                db.SubmitChanges();
            }

            //如果和书的上传者不是同一人在站内信中记录
            var tb = db.Book.SingleOrDefault<Book>(s => s.BookID == Convert.ToInt16(Request["BookID"]));
            if (tb.UserID != Session["UserID"])
            {
                Letter letter = new Letter();
                letter.UserID = tb.UserID.ToString();
                letter.Title = Session["Name"].ToString() + " 给您上传的：" + tb.Title.ToString() + "写书评：" + titletextbox.Text;
                letter.HyperLink = "~/BookWareHouse/CheckBookReview.aspx?BookReviewID=" + brid;
                letter.DateTime = DateTime.Now;
                db.Letter.InsertOnSubmit(letter);
                db.SubmitChanges();
            }

            Response.Write(" <script language=javascript>alert('发表成功');window.window.location.href='CheckBookReview.aspx?BookReviewID=" + brid + "';</script> ");
        }
    }
}