using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;

public partial class 书库_CheckBook : System.Web.UI.Page
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
            //初始化评分选择框
            for (int i = 10; i >= 1; i--)
                scoreselectlist.Items.Add(i.ToString());
            scoreselectlist.Items[0].Selected = true;


            DataClassesDataContext db = new DataClassesDataContext();
            var book = from b in db.Book where b.BookID.ToString() == Request["BookID"] select b;
            //如果当前用户不是该书的上传者将编辑和删除按钮置为不可见
            if (book.FirstOrDefault().UserID.ToString() != Session["UserID"].ToString())
            {
                deletebutton.Visible = false;
                editbutton.Visible = false;
            }
            string bookname = book.FirstOrDefault().Title;
            deletebutton.Attributes["OnClick"] = "return confirm('确认删除 " + bookname + " 吗?')";//给删除按钮添加确认功能

            //初始化书籍信息
            titlelabel.Text = bookname;
            scorelabel.Text = "         /" + book.FirstOrDefault().Score.ToString() + "分";
            authortextbox.Text = book.FirstOrDefault().Author;
            isbntextbox.Text = book.FirstOrDefault().ISBN;
            categorytextbox.Text = book.FirstOrDefault().Category;
            publishertextbox.Text = book.FirstOrDefault().Publisher;
            coverimg.ImageUrl = book.FirstOrDefault().CoverImagePath;
            doubanlink.Text = book.FirstOrDefault().DoubanLink;
            doubanlink.NavigateUrl = book.FirstOrDefault().DoubanLink;
            introtextbox.Text = book.FirstOrDefault().BriefIntroduction;

            //如果没有电子书资源将下载按钮置为不可见
            if (book.FirstOrDefault().SourcePath == null)
                downloadbutton.Visible = false;
            else if(!File.Exists(book.FirstOrDefault().SourcePath))
                downloadbutton.Visible = false;

            //为写书评界面设置BookNameSession
            Session["BookName"] = bookname;

            //初始化推荐到圈子按钮
            var tempuser = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());
            if (tempuser.QuanZiID != null)//如果加入了圈子
            {
                var bkw = from b in db.BookWarehouse
                          where b.UserID == Session["UserID"].ToString()
                               && b.BookID == Convert.ToInt16(Request["BookID"])
                              && b.Type == "recommend"
                          select b;
                if (bkw.Count() == 0)//如果还没推荐过
                {
                    recommendbutton.Text = "推荐到圈子";
                }
                else //如果已经推荐过
                {
                    recommendbutton.Text = "取消推荐到圈子";
                }
            }
            else//如果还没加入圈子
            {
                recommendbutton.Visible = false;
            }

            //初始化关注按钮
            var bkw2 = from b in db.BookWarehouse 
                       where b.UserID == Session["UserID"].ToString() 
                            && b.BookID == Convert.ToInt16(Request["BookID"]) 
                            && b.Type == "follow" 
                       select b;
            if (bkw2.Count() != 0) //已经关注
            {
                followbutton.Text = "取消关注";
            }
            else
            {
                followbutton.Text = "关注此书";
            }

            InitBookReviewTable();
        }
    }

    /// <summary>
    /// 初始化书评列表
    /// </summary>
    protected void InitBookReviewTable()
    {
        DataClassesDataContext db = new DataClassesDataContext();
        var brs = from b in db.BookReview where b.BookID == Convert.ToInt16(Request["BookID"]) orderby b.Score descending  select b;
        TableCell cell1 = new TableCell();
        cell1.Text = "题目";
        cell1.Font.Bold = true;
        cell1.Font.Size = 3;
        TableCell cell2 = new TableCell();
        cell2.Text = "作者";
        cell2.Font.Bold = true;
        cell2.Font.Size = 3;
        TableCell cell25 = new TableCell();
        cell25.Text = "发布日期";
        cell25.Font.Bold = true;
        cell25.Font.Size = 3;
        TableCell cell3 = new TableCell();
        cell3.Text = "评分";
        cell3.Font.Bold = true;
        cell3.Font.Size = 3;
        TableRow row = new TableRow();
        row.Cells.Add(cell1);
        row.Cells.Add(cell2);
        row.Cells.Add(cell25);
        row.Cells.Add(cell3);
        
        bookreviewtable.Rows.Add(row);
        foreach (BookReview br in brs)
        {
            TableCell newcell1 = new TableCell();
            TableCell newcell2 = new TableCell();
            TableCell newcell25 = new TableCell();
            TableCell newcell3 = new TableCell();
            

            HyperLink link = new HyperLink();
            link.Text = br.Title;
            link.NavigateUrl = "~/BookWareHouse/CheckBookReview.aspx?BookReviewID=" + br.BookReviewID.ToString();
            newcell1.Controls.Add(link);
            newcell2.Text = br.UserName;
            newcell25.Text = br.DateTime.ToString();
            newcell3.Text = ((double)br.Score).ToString("f1");
            
            TableRow temprow = new TableRow();
            temprow.Cells.Add(newcell1);
            temprow.Cells.Add(newcell2);
            temprow.Cells.Add(newcell25);
            temprow.Cells.Add(newcell3);
            
            bookreviewtable.Rows.Add(temprow);
        }
    }

    /// <summary>
    /// 推荐按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void recommendbutton_Click(object sender, EventArgs e)
    {
        if (recommendbutton.Text == "推荐到圈子")
        {
            DataClassesDataContext db = new DataClassesDataContext();
            var tempuser = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());

            BookWarehouse bw = new BookWarehouse();
            bw.UserID = Session["UserID"].ToString();
            bw.BookID = Convert.ToInt16(Request["BookID"]);
            bw.Type = "recommend";
            bw.QuanZiID = tempuser.QuanZiID;
            db.BookWarehouse.InsertOnSubmit(bw);
            db.SubmitChanges();

            //在新鲜事中记录
            News n = new News();
            n.QuanZiID = tempuser.QuanZiID;
            n.Title = Session["Name"].ToString() + "向你推荐：" + Session["BookName"].ToString();
            n.UserID = Session["UserID"].ToString();
            n.DateTime = DateTime.Now;
            n.HyperLink = "~/BookWareHouse/CheckBook.aspx?BookID=" + Request["BookID"].ToString();
            db.News.InsertOnSubmit(n);
            db.SubmitChanges();

            Response.Write(" <script language=javascript>alert('推荐成功');window.location.href=window.location.href;</script> ");
        }
        else if (recommendbutton.Text == "已推荐到圈子，取消？")
        {
            DataClassesDataContext db = new DataClassesDataContext();
            db.ExecuteCommand("delete from BookWarehouse where BookID = '" + Request["BookID"].ToString() + "' and UserID = '" + Session["UserID"].ToString() + "' and Type = 'recommend'");
            db.SubmitChanges();
            Response.Write(" <script language=javascript>alert('已取消推荐');window.location.href=window.location.href;</script> ");
        }
    }

    /// <summary>
    /// 编辑按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void editbutton_Click(object sender, EventArgs e)
    {
        //跳转到编辑图书界面
        Response.Redirect("EditBook.aspx?BookID=" + Request["BookID"]);
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
        db.ExecuteCommand("delete from Book where BookID = '" + Request["BookID"].ToString() + "'");
        db.SubmitChanges();
        Response.Write(" <script language=javascript>alert('删除成功');window.window.location.href='SearchBook.aspx';</script> ");
    }

    /// <summary>
    /// 评分按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void scorebutton_Click(object sender, EventArgs e)
    {
        int score = 10 - scoreselectlist.SelectedIndex;//记录用户的评分
        //更新数据库中该书籍评分，更新界面分数
        DataClassesDataContext db = new DataClassesDataContext();
        var br = from b in db.Book where b.BookID == Convert.ToInt16(Request["BookID"]) select b;
        int no = (int)br.FirstOrDefault().EvaluationNumbers;
        double oldscore = (double)br.FirstOrDefault().Score;
        double newscore = (oldscore * no + score) / (no + 1);
        br.FirstOrDefault().EvaluationNumbers++;
        br.FirstOrDefault().Score = newscore;
        db.SubmitChanges();
        scorelabel.Text = "         /" + newscore.ToString("f1") + "分";

        //如果和书的上传者不是同一人在站内信中记录
        if (br.FirstOrDefault().UserID != Session["UserID"])
        {
            Letter letter = new Letter();
            letter.UserID = br.FirstOrDefault().UserID.ToString();
            letter.Title = Session["Name"].ToString() + " 给您上传的：" + br.FirstOrDefault().Title.ToString() + " 评分";
            letter.HyperLink = "~/BookWareHouse/CheckBook.aspx?BookID=" + Request["BookID"];
            letter.DateTime = DateTime.Now;
            db.Letter.InsertOnSubmit(letter);
            db.SubmitChanges();
        }

        Response.Write(" <script language=javascript>alert('评分成功');window.location.href=window.location.href;</script> ");
        
    }

    /// <summary>
    /// 写书评按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void writebookreviewbutton_Click(object sender, EventArgs e)
    {
        //跳转到写书评界面
        Response.Redirect("WriteBookReview.aspx?BookID=" + Request["BookID"]);
    }

    /// <summary>
    /// 下载电子书
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void downloadbutton_Click(object sender, EventArgs e)
    {
        DataClassesDataContext db = new DataClassesDataContext();
        var book = from b in db.Book where b.BookID.ToString() == Request["BookID"] select b;
        String filepath = book.FirstOrDefault().SourcePath.ToString();
        Page.Response.Clear();
        Page.Response.AddHeader("Content-Type", "doc/pdf/txt");
        Page.Response.AddHeader("Content-Disposition", "inline;filename=" + filepath);
        Page.Response.WriteFile(filepath);
        Page.Response.End();
    }

    /// <summary>
    /// 关注按钮推荐
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void followbutton_Click(object sender, EventArgs e)
    {
        if (followbutton.Text == "关注此书")
        {
            DataClassesDataContext db = new DataClassesDataContext();
            BookWarehouse bw = new BookWarehouse();
            bw.UserID = Session["UserID"].ToString();
            bw.BookID = Convert.ToInt16(Request["BookID"]);
            bw.Type = "follow";
            db.BookWarehouse.InsertOnSubmit(bw);
            db.SubmitChanges();

            //如果圈子不为空在新鲜事中记录
            var tempuser = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());
            if (tempuser.QuanZiID != null)
            {
                News n = new News();
                n.QuanZiID = tempuser.QuanZiID;
                n.Title = Session["Name"].ToString() + "关注了：" + Session["BookName"].ToString();
                n.UserID = Session["UserID"].ToString();
                n.DateTime = DateTime.Now;
                n.HyperLink = "~/BookWareHouse/CheckBook.aspx?BookID=" + Request["BookID"].ToString();
                db.News.InsertOnSubmit(n);
                db.SubmitChanges();
            }
            Response.Write(" <script language=javascript>alert('关注成功');window.location.href=window.location.href;</script> ");
        }
        else if (followbutton.Text == "已关注该书，取消？")
        {
            DataClassesDataContext db = new DataClassesDataContext();
            db.ExecuteCommand("delete from BookWarehouse where BookID = '" + Request["BookID"].ToString() + "' and UserID = '" + Session["UserID"].ToString() + "' and Type = 'follow'");
            db.SubmitChanges();
            Response.Write(" <script language=javascript>alert('已取消关注');window.location.href=window.location.href;</script> ");
        }
    }
}