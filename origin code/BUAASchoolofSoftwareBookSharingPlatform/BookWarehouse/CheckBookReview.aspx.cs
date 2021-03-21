using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class 书库_CheckBookReview : System.Web.UI.Page
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
            for (int i = 10; i >= 1; i--)//初始化评分选择框
                scoreselectlist.Items.Add(i.ToString());
            scoreselectlist.Items[0].Selected = true;
            InitBookReviewInfo();//初始化书评信息
            InitCommentTable();//初始化评论列表

            deletebutton.Attributes["OnClick"] = "return confirm('确认删除这篇书评吗?')";//给删除按钮添加确认功能
        }
    }

    /// <summary>
    /// 初始化书评信息
    /// </summary>
    protected void InitBookReviewInfo()
    {
        //从数据库初始化书评信息
        DataClassesDataContext db = new DataClassesDataContext();
        var br = from b in db.BookReview where b.BookReviewID == Convert.ToInt16(Request["BookReviewID"]) select b;
        infolabel.Text = "作者" + br.FirstOrDefault().UserName + "/"
                         + "评价书籍" + br.FirstOrDefault().BookName + "/"
                         + br.FirstOrDefault().DateTime.Year+"."+br.FirstOrDefault().DateTime.Month+"."+br.FirstOrDefault().DateTime.Day+"/";
        scorelabel.Text = ((double)br.FirstOrDefault().Score).ToString("f1") + "分";
        titletextbox.Text = br.FirstOrDefault().Title;
        contenttextbox.Text = br.FirstOrDefault().Content;

        if (br.FirstOrDefault().UserID.Equals(Session["UserID"]))//如果书评作者和当前用户是同一个人
        {
            scorebutton.Visible = false;
            scoreselectlist.Visible = false;
        }
        else
        {
            editbutton.Visible = false;
            deletebutton.Visible = false;
        }
    }

    /// <summary>
    /// 初始化评论列表
    /// </summary>
    protected void InitCommentTable()
    {
        //从数据库初始化评论列表
        DataClassesDataContext db = new DataClassesDataContext();
        var brcs = from b in db.BookReviewComment where b.BookReviewID == Convert.ToInt16(Request["BookReviewID"]) select b;
        foreach (BookReviewComment brc in brcs)
        {
            TableCell cell1 = new TableCell();
            cell1.Text = brc.UserName + "说：" + brc.Content;
            cell1.HorizontalAlign = HorizontalAlign.Left;
            TableCell cell2 = new TableCell();
            cell2.Text = brc.DateTime.ToShortDateString();
            cell2.HorizontalAlign = HorizontalAlign.Right;
            TableRow row = new TableRow();
            row.Cells.Add(cell1);
            row.Cells.Add(cell2);
            commenttable.Rows.Add(row);
        }
    }

    /// <summary>
    /// 修改按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void editbutton_Click(object sender, EventArgs e)
    {
        Response.Redirect("EditBookReview.aspx?BookReviewID=" + Request["BookReviewID"]);
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

    /// <summary>
    /// 评分按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void scorebutton_Click(object sender, EventArgs e)
    {
        int score = 10 - scoreselectlist.SelectedIndex;//记录用户的评分
        //更新数据库中该书评评分，更新界面分数
        DataClassesDataContext db = new DataClassesDataContext();
        var br = from b in db.BookReview where b.BookReviewID == Convert.ToInt16(Request["BookReviewID"]) select b;
        int no = (int)br.FirstOrDefault().EvaluationNumbers;
        double oldscore = (double)br.FirstOrDefault().Score;
        double newscore = (oldscore * no + score) / (no + 1);
        br.FirstOrDefault().EvaluationNumbers ++;
        br.FirstOrDefault().Score = newscore;
        db.SubmitChanges();
        scorelabel.Text = newscore.ToString("f1") + "分";

        //如果和书评作者不是同一人在站内信中记录
        if (br.FirstOrDefault().UserID != Session["UserID"])
        {
            Letter letter = new Letter();
            letter.UserID = br.FirstOrDefault().UserID.ToString();
            letter.Title = Session["Name"].ToString() + " 给您的书评：" + br.FirstOrDefault().Title.ToString() + " 评分";
            letter.HyperLink = "~/BookWareHouse/CheckBookReview.aspx?BookReviewID=" + Request["BookReviewID"];
            letter.DateTime = DateTime.Now;
            db.Letter.InsertOnSubmit(letter);
            db.SubmitChanges();
        }

        Response.Write(" <script language=javascript>alert('评分成功');window.location.href=window.location.href;</script> ");
    }

    /// <summary>
    /// 发表评论按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void Button1_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)
        {
            //在数据库中添加评论记录，更新评论列表
            DataClassesDataContext db = new DataClassesDataContext();
            BookReviewComment brc = new BookReviewComment();
            brc.BookReviewID = Convert.ToInt16(Request["BookReviewID"]);
            brc.UserID = Session["UserID"].ToString();
            brc.Content = commenttextbox.Text;
            brc.DateTime = DateTime.Now;
            brc.UserName = Session["Name"].ToString();
            db.BookReviewComment.InsertOnSubmit(brc);
            db.SubmitChanges();

            //在新鲜事中记录
            var tempuser = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());
            if (tempuser.QuanZiID != null)
            {
                News n = new News();
                n.QuanZiID = tempuser.QuanZiID;
                n.Title = Session["Name"].ToString() + "评论书评：" + titletextbox.Text;
                n.UserID = Session["UserID"].ToString();
                n.DateTime = DateTime.Now;
                n.HyperLink = "~/BookWareHouse/CheckBookReview.aspx?BookReviewID=" + Request["BookReviewID"];
                db.News.InsertOnSubmit(n);
                db.SubmitChanges();
            }

            //如果和书评作者不是同一人在站内信中记录
            var tb = db.BookReview.SingleOrDefault<BookReview>(s => s.BookReviewID == Convert.ToInt16(Request["BookReviewID"]));
            if (tb.UserID != Session["UserID"])
            {
                Letter letter = new Letter();
                letter.UserID = tb.UserID.ToString();
                letter.Title = Session["Name"].ToString() + " 给您的书评：" + tb.Title.ToString() + " 评论：" + commenttextbox.Text;
                letter.HyperLink = "~/BookWareHouse/CheckBookReview.aspx?BookReviewID=" + Request["BookReviewID"];
                letter.DateTime = DateTime.Now;
                db.Letter.InsertOnSubmit(letter);
                db.SubmitChanges();
            }

            Response.Write(" <script language=javascript>alert('评论成功');window.location.href=window.location.href;</script> ");
        }
    }
}