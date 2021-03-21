using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;

public partial class 书库_UploadCoverImage : System.Web.UI.Page
{
    /// <summary>
    /// 加载页面
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// 上传封面图片
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
    /// 上传电子书
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void bookuploadbutton_Click(object sender, EventArgs e)
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

    /// <summary>
    /// 查看新书跳转链接
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void checkbookbutton_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/BookWareHouse/CheckBook.aspx?BookID=" + Request["BookID"].ToString());
    }
}