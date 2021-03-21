using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Net.Mail;
using System.Net;
using System.Data;
using System.Data.SqlClient;

public partial class PersonalWeb_FrogotPassword : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void Return_onclick(object sender, EventArgs e)
    {
        Response.Redirect("Login.aspx");
    }

    protected void SEmail_onclick(object sender, EventArgs e)
    {
        using(DataClassesDataContext db = new DataClassesDataContext())
        {
            User user = db.User.SingleOrDefault<User>(s => s.UserID == acc.Value);

            if (user == null)
            {
                Response.Write("<script language=javascript>alert('账号不存在奥，赶紧去注册一个吧');</script> ");
                return;
            }
            if (user.Email != email.Value)
            {
                Response.Write("<script language=javascript>alert('此邮箱还没注册呢，再想想吧~');</script> ");
                return;
            }
            if (user.SecurityQ != ques.Items[ques.SelectedIndex].ToString() || user.SecurityA != ans.Value.ToString())
            {
                Response.Write("<script language=javascript>alert('验证问题和答案不否哦');</script> ");
                return;
            }
            sendMail(user.Name.ToString(),user.Password.ToString(),user.Email.ToString());
        }
    }

    protected void sendMail(string name, string pass, string email)
    {
        //name 是注册的用户名，pass 是注册的用户密码，email 是注册用的邮箱；     
        string address_from = "";
        string address_to = email;
        string body = "您好！您在软院读书会交流网站注册的密码已经找回，\n注册名为：" + name + "  密码为: " + pass + "\n" + "请妥善保管您的密码信息";
        string subject = "软院读书交流网密码找回邮件";

        SmtpClient mailClient = new SmtpClient("smtp.gmail.com", 587);
        mailClient.EnableSsl = true;
        NetworkCredential crendetial = new NetworkCredential("Athens311@gmail.com", "anran1314");
        mailClient.Credentials = crendetial;
        MailMessage message = new MailMessage("Athens311@gmail.com", email, subject, body);

        try
        {
            mailClient.Send(message);
            Response.Write("<script>alert('您的密码已发到您邮箱,请查收,点击返回O(∩_∩)O!');location.href='Login.aspx';</script>");///自动返回
            //Page.ClientScript.RegisterStartupScript(GetType(),"true", "<script>alert('您的密码已发到您邮箱,请查收,点击返回O(∩_∩)O!')</script>");
        }
        catch (Exception ex)
        {
            Response.Write("<script>alert('由于网络问题,您的邮件发送失败%>_<%');location.href='Login.aspx';</script>");///自动返回
        }
    }
}