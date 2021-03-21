using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class 书库_BookReview : System.Web.UI.Page
{
    /// <summary>
    /// 加载页面
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void Page_Load(object sender, EventArgs e)
    {
        InitBookReviewTable();//初始化书评列表
    }

    /// <summary>
    /// 初始化书评列表
    /// </summary>
    protected void InitBookReviewTable()
    {
        DataClassesDataContext db = new DataClassesDataContext();
        var brs = from b in db.BookReview where b.UserID == Session["UserID"].ToString() select b;
        TableCell cell1 = new TableCell();
        cell1.Text = "题目";
        cell1.Font.Bold = true;
        cell1.Font.Size = 3;
        TableCell cell2 = new TableCell();
        cell2.Text = "评论图书";
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
        TableCell cell4 = new TableCell();
        cell4.Text = "操作";
        cell4.Font.Bold = true;
        cell4.Font.Size = 3;
        TableRow row = new TableRow();
        row.Cells.Add(cell1);
        row.Cells.Add(cell2);
        row.Cells.Add(cell25);
        row.Cells.Add(cell3);
        row.Cells.Add(cell4);
        brt.Rows.Add(row);
        foreach (BookReview br in brs)
        {
            TableCell newcell1 = new TableCell();
            TableCell newcell2 = new TableCell();
            TableCell newcell25 = new TableCell();
            TableCell newcell3 = new TableCell();
            TableCell newcell4 = new TableCell();
            
            HyperLink link = new HyperLink();
            link.Text = br.Title;
            link.NavigateUrl = "~/BookWareHouse/CheckBookReview.aspx?BookReviewID=" + br.BookReviewID.ToString();
            newcell1.Controls.Add(link);
            newcell2.Text = br.BookName;
            newcell25.Text = br.DateTime.ToString();
            newcell3.Text = br.Score.ToString();
            HyperLink link2 = new HyperLink();
            link2.Text = "修改";
            link2.NavigateUrl = "~/BookWareHouse/EditBookReview.aspx?BookReviewID=" + br.BookReviewID.ToString();
            newcell4.Controls.Add(link2);
            TableRow temprow = new TableRow();
            temprow.Cells.Add(newcell1);
            temprow.Cells.Add(newcell2);
            temprow.Cells.Add(newcell25);
            temprow.Cells.Add(newcell3);
            temprow.Cells.Add(newcell4);
            brt.Rows.Add(temprow);
        }
    }

    /// <summary>
    /// 写书评按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void writebutton_Click(object sender, EventArgs e)
    {
        Response.Write(" <script language=javascript>alert('请先选择要评论的书籍');window.window.location.href='SearchBook.aspx'</script> ");
    }
}