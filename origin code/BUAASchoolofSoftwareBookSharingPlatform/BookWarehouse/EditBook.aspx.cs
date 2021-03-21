using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;

public partial class BookWareHouse_EditBook : System.Web.UI.Page
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
            DataClassesDataContext db = new DataClassesDataContext();
            var book = from bb in db.Book where bb.BookID == Convert.ToInt16(Request["BookID"]) select bb;
            headlabel.Text = book.FirstOrDefault().Title;
            titletextbox.Text = book.FirstOrDefault().Title;
            authortextbox.Text = book.FirstOrDefault().Author;
            publishertextbox.Text = book.FirstOrDefault().Publisher;
            isbntextbox.Text = book.FirstOrDefault().ISBN;
            doubanlinktextbox.Text = book.FirstOrDefault().DoubanLink;
            introtextbox.Text = book.FirstOrDefault().BriefIntroduction;
        }
    }

    /// <summary>
    /// customvalidator判断函数
    /// </summary>
    /// <param name="source"></param>
    /// <param name="args"></param>
    protected void CustomValidator1_ServerValidate(object source, ServerValidateEventArgs args)
    {
        DataClassesDataContext db = new DataClassesDataContext();
        var book = from bb in db.Book where bb.BookID == Convert.ToInt16(Request["BookID"]) select bb;
        string oldisbn = book.FirstOrDefault().ISBN;
        if (isbntextbox.Text == oldisbn)
        {
            args.IsValid = true;
        }
        else
        {
            var books = from b in db.Book where b.ISBN == isbntextbox.Text select b;
            if (books.Count() == 0)
            {
                args.IsValid = true;
            }
            else
            {
                args.IsValid = false;
            }

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
            
            string tempname = titletextbox.Text;
            if (tempname[0] != '《')
            {
                tempname = "《" + tempname + "》";
            }
            db.ExecuteCommand("UPDATE Book SET Title = '" + tempname + "' , Author = '" + authortextbox.Text +
                "' , ISBN = '" + isbntextbox.Text + "' , Publisher = '" + publishertextbox.Text +
                "' , DoubanLink = '" + doubanlinktextbox.Text + "' , BriefIntroduction = '" + introtextbox.Text + "' WHERE BookID = {0}", Convert.ToInt32(Request["BookID"]));
            db.SubmitChanges();
            Response.Write(" <script language=javascript>alert('修改成功');window.window.location.href='CheckBook.aspx?BookID=" + Request["BookID"] + "';</script> ");
        }
    }

    /// <summary>
    /// 上传封面图片按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void coverimageuploadbutton_Click(object sender, EventArgs e)
    {
        if (coverimageupload.HasFile)
        {
            string fileExt = System.IO.Path.GetExtension(coverimageupload.FileName);
            if (fileExt == ".jpg" || fileExt == ".bmp" || fileExt == ".JPG")
            {
                string path = Server.MapPath("../img/books_img/") + coverimageupload.FileName;
                if (!File.Exists(path))
                {
                    coverimageupload.PostedFile.SaveAs(path);
                    coverimageuploadinfolabel.Text = "上传图片：" + coverimageupload.FileName + "成功";

                    //写入数据库
                    path = @"../img/books_img/" + coverimageupload.FileName;

                    DataClassesDataContext db = new DataClassesDataContext();
                    db.ExecuteCommand("UPDATE Book SET CoverImagePath = '" + path + "' WHERE BookID = {0}", Convert.ToInt32(Request["BookID"]));
                    db.SubmitChanges();
                }
                else
                {
                    coverimageuploadinfolabel.Text = "服务器中已存在同名文件，不能上传！";
                }
            }
            else
            {
                coverimageuploadinfolabel.Text = "只允许上传jpg、bmp格式文件！";
            }
        }
        else
        {
            coverimageuploadinfolabel.Text = "没有选择要上传的文件！";
        }
    }

    /// <summary>
    /// 上传电子书按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void sourceuploadbutton_Click(object sender, EventArgs e)
    {
        if (bookupload.HasFile)
        {
            string fileExt = System.IO.Path.GetExtension(bookupload.FileName);
            if (fileExt == ".doc" || fileExt == ".txt" || fileExt == ".pdf")
            {
                string path = Server.MapPath("../BookWareHouse/book/") + bookupload.FileName;
                if (!File.Exists(path))
                {
                    bookupload.PostedFile.SaveAs(path);
                    bookuploadinfolabel.Text = "上传电子书：" + bookupload.FileName + "成功";

                    //写入数据库
                    path = @"../BookWareHouse/book/" + bookupload.FileName;
                    DataClassesDataContext db = new DataClassesDataContext();
                    db.ExecuteCommand("update Book set SourcePath = '" + path + "' where BookID = {0}", Convert.ToInt32(Request["BookID"]));
                    db.SubmitChanges();
                }
                else
                {
                    bookuploadinfolabel.Text = "服务器中已存在同名文件，不能上传！";
                }
            }
            else
            {
                bookuploadinfolabel.Text = "只允许上传doc、txt、pdf格式文件！";
            }
        }
        else
        {
            bookuploadinfolabel.Text = "没有选择要上传的文件！";
        }
    }
}