using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;

public partial class PersonalWeb_ScanInfo : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            Init();
        }
        
    }
    protected void Modify_onclick(object sender, EventArgs e)
    {
        name.Enabled = true;
        birth.Enabled = true;
        email.Enabled = true;
        signa.Enabled = true;
    }
    protected void Save_onclick(object sender, EventArgs e)
    {
        if (pass1.Text != pass2.Text)
        {
            Response.Write("<script language=javascript>alert('两次输入的密码不一样~');</script> ");
            return;
        }
        else
        {
            using (DataClassesDataContext db = new DataClassesDataContext())
            {
                var user = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"]);
                if (pass1.Text != "")
                    user.Password = pass1.Text;
                user.Name = name.Text;
                user.Birthday = birth.Text;
                user.Email = email.Text;
                if(upload_Click()) user.UserImagePath = Session["ImageUrl"].ToString();
                user.Grade = sel.Items[sel.SelectedIndex].ToString();
                user.Signature = signa.Text;

                db.SubmitChanges();
            }

            name.Enabled = false;
            birth.Enabled = false;
            email.Enabled = false;
            signa.Enabled = false;
            //Response.Redirect("ScanInfo.aspx");
        }
        Response.Redirect("ScanInfo.aspx");
    }
  
    protected  new void Init()
    {
        using (DataClassesDataContext db = new DataClassesDataContext())
        {
            var user = db.User.SingleOrDefault<User>(s => s.UserID == Session["UserID"].ToString());
            acc.Text = user.UserID;
            opass.Text = user.UserID;
            name.Text = user.Name;
            iden.Text = user.Identity;
            birth.Text = user.Birthday;
            email.Text = user.Email;
            for (int i = 0; i < sel.Items.Count; i++)
            {
                if (sel.Items[i].ToString() == user.Grade)
                {
                    sel.SelectedIndex = i;
                    break;
                }
            }
            signa.Text = user.Signature;

            name.Enabled = false;
            birth.Enabled = false;
            email.Enabled = false;
            signa.Enabled = false;
        }
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
                Session["ImageUrl"] = "~/PersonalImage/" + pesImage.FileName;
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