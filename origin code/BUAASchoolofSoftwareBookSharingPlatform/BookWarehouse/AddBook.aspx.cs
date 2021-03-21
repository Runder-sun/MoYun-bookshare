using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class 书库_AddBook : System.Web.UI.Page
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
    protected void confirmbutton_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)//如果当前页面输入合法
        {
            //将图书信息添加进数据库
            DataClassesDataContext db = new DataClassesDataContext();
            Book book = new Book();
            string tempname = titletextbox.Text;
            if (tempname[0] == '《')
            {
                book.Title = tempname;
            }
            else
            {
                book.Title = "《" + tempname + "》";
            }
            book.Author = authortextbox.Text;
            book.ISBN = isbntextbox.Text;
            book.Publisher = publishertextbox.Value.ToString();
            book.DoubanLink = doubanlinktextbox.Value.ToString();
            book.BriefIntroduction = introtextbox.Value.ToString();
            book.UserID = Session["UserID"].ToString();
            book.Category = categoryselect.SelectedValue.ToString();
            book.Score = 1;
            book.EvaluationNumbers = 0;
            db.Book.InsertOnSubmit(book);
            db.SubmitChanges();
            Response.Write(" <script language=javascript>alert('添加成功');window.window.location.href='Upload.aspx?BookID=" + book.BookID + "';</script> ");

        }
    }

    /// <summary>
    /// coustomvalidator的判断函数
    /// </summary>
    /// <param name="source"></param>
    /// <param name="args"></param>
    protected void CustomValidator1_ServerValidate(object source, ServerValidateEventArgs args)
    {
        DataClassesDataContext db = new DataClassesDataContext();
        var books = from b in db.Book where b.ISBN == isbntextbox.Text select b;
        if (books.Count()==0)
        {
            args.IsValid = true;
        }
        else
        {
            args.IsValid = false;
        }
    }
}