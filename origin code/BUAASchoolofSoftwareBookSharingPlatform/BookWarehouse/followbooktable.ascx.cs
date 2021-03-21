using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;

public partial class BookWareHouse_followbooktable : System.Web.UI.UserControl
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
            InitFollowTable();//初始化我的关注列表
        }
    }

    /// <summary>
    /// 初始化我的关注列表
    /// </summary>
    protected void InitFollowTable()
    {
        //通过数据库得到对应用户id关注的图书id
        DataClassesDataContext db = new DataClassesDataContext();
        var books = db.ExecuteQuery<Book>("select * from BookWareHouse,Book where BookWareHouse.BookID = Book.BookID"
                                                + " and BookWareHouse.Type = 'follow' and BookWareHouse.UserID = '" + Session["UserID"].ToString() + "'");

        foreach (Book book in books)
        {
            TableRow row = new TableRow();
            TableCell cell = new TableCell();

            ImageButton img = new ImageButton();
            img.ImageUrl = book.CoverImagePath.ToString();
            img.Width = 120;
            img.PostBackUrl = "~/BookWareHouse/CheckBook.aspx?BookID=" + book.BookID.ToString();

            cell.Controls.Add(img);
            cell.HorizontalAlign = HorizontalAlign.Center;
            row.Cells.Add(cell);

            TableRow row2 = new TableRow();
            TableCell cell2 = new TableCell();

            HyperLink link = new HyperLink();
            link.NavigateUrl = "~/BookWareHouse/CheckBook.aspx?BookID=" + book.BookID.ToString();
            link.Text = book.Title.ToString();

            cell2.Controls.Add(link);
            cell2.HorizontalAlign = HorizontalAlign.Center;
            row2.Cells.Add(cell2);

            Table temptable = new Table();
            temptable.Rows.Add(row);
            temptable.Rows.Add(row2);

            TableRow temprow = new TableRow();
            TableCell tempcell = new TableCell();
            tempcell.Controls.Add(temptable);
            tempcell.HorizontalAlign = HorizontalAlign.Center;
            temprow.Cells.Add(tempcell);
            temprow.CssClass = "s_item";

            table1.Rows.Add(temprow);
        }
    }
}