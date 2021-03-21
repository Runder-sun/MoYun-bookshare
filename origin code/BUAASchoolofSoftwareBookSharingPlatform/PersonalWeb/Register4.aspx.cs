using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Linq.Expressions;
using System.IO;

public partial class PersonalWeb_Register4 : System.Web.UI.Page
{
    private const string DefaultImageUrl = @"~/PersonalImage/Default.gif";

    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void liulan_onclick(object sender, EventArgs e)
    {/*
        if (File1.Value == "")
        {
            Span1.InnerHtml = "必须选择要上传的文件";
            return;
        }
        string filename = File1.PostedFile.FileName.Substring(File1.PostedFile.FileName.LastIndexOf(@"\")+1);
        if (File1.PostedFile.ContentLength > 0)
        {
            File1.PostedFile.SaveAs(Server.MapPath(filename));
            Response.Write("上传文件： "+ filename + "成功\n");
        }*/
    }
    protected void Next_onclick(object sender, EventArgs e)
    {
        if (!upload_Click()) return;
        Session["Signature"] = psl.Value;
        if(Session["ImageUrl"] == null)
            Session["ImageUrl"] = DefaultImageUrl;
        Session["FavBookCate"] = fav_book.Items[fav_book.SelectedIndex].ToString();
        Add_User();
        Response.Redirect("PersonalHome.aspx?HostID="+Session["UserID"]);  
    }
    protected void Return_onclick(object sender, EventArgs e)
    {
        if (Session["Signature"] != null) Session.Remove("Signature"); 
        Response.Redirect("Register3.aspx");
        
    }
    protected void Add_User()
    {
        User user = new User();

        user.UserID = Session["UserID"].ToString();
        user.Password = Session["Password"].ToString();
        user.Name = Session["Name"].ToString();
        user.Sex = Session["Sex"].ToString();
        if(Session["Grade"] != null)
        user.Grade = Session["Grade"].ToString();
        user.Birthday = Session["Birthday"].ToString();
        user.UserImagePath = Session["ImageUrl"].ToString();
        user.Email = Session["Email"].ToString();
        user.Identity = Session["Identity"].ToString();
        user.Signature = Session["Signature"].ToString();
        user.SecurityQ = Session["Secqu"].ToString();
        user.SecurityA = Session["Secans"].ToString();
        user.FavBookCate = Session["FavBookCate"].ToString();
        
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            db.User.InsertOnSubmit(user);
            db.SubmitChanges();
        }
        Session["UserID"] = user.UserID;
        Session["Identity"] = user.Identity;
        Session["Name"] = user.Name;
        Session["QuanZiId"] = user.QuanZiID;
        Session["HostId"] = user.UserID;
        Session["ImageUrl"] = user.UserImagePath;
    }

    protected bool upload_Click()
    {
        if (pesImage.HasFile)
        {
            string fileExt = System.IO.Path.GetExtension(pesImage.FileName);
            if (fileExt == ".jpg" || fileExt == ".bmp" || fileExt == ".JPG" || fileExt == ".gif")
            {
                string path = Server.MapPath("../PersonalImage/") + pesImage.FileName;
                //string path = "~PersonalImage/" + pesImage.FileName;
                Session["ImageUrl"] = "~/PersonalImage/"+pesImage.FileName;
                if (!File.Exists(path))
                {
                    pesImage.PostedFile.SaveAs(path);
                }
            }
            else
            {
                Response.Write("<script language=javascript>alert('只允许上传jpg、bmp、gif格式文件！');</script> ");
                return false;
            }
        }
        return true;
    }
}