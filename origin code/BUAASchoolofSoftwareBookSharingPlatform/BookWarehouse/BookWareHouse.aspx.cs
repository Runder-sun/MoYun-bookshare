using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class 书库_BookWareHouse : System.Web.UI.Page
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
            InitHotBookTable();//初始化热门书籍列表
            
            InitRecommendTable();//初始化系统推荐图书列表
        }
    }

    /// <summary>
    /// 初始化热门图书列表
    /// </summary>
    protected void InitHotBookTable()
    {
        //通过数据库得到热门图书的图书id
        DataClassesDataContext db = new DataClassesDataContext();
        var books = db.ExecuteQuery<Book>("select * from Book order by Score DESC");
        int n = 0;
        foreach (Book book in books)
        {
            TableRow row = new TableRow();
            row.CssClass = "s_item";

            TableCell cell = new TableCell();
            cell.CssClass = "tdstyle";

            ImageButton img = new ImageButton();
            img.ImageUrl = book.CoverImagePath.ToString();
            img.Width = 150;
            img.PostBackUrl = "~/BookWareHouse/CheckBook.aspx?BookID=" + book.BookID.ToString();

            cell.Controls.Add(img);
            cell.HorizontalAlign = HorizontalAlign.Left;
            row.Cells.Add(cell);
           

            TableCell cell2 = new TableCell();
            cell2.CssClass = "td_pad";
            cell2.HorizontalAlign = HorizontalAlign.Left;
            
            
            Table celltable = new Table();
            //celltable.CssClass = "tbstyle";
            celltable.HorizontalAlign = HorizontalAlign.Left;

            TableRow rightrow1 = new TableRow();
            TableCell rightcell1 = new TableCell();
            //rightcell1.CssClass = "td_row";
            rightcell1.HorizontalAlign = HorizontalAlign.Left;

            HyperLink link = new HyperLink();
            link.NavigateUrl = "~/BookWareHouse/CheckBook.aspx?BookID=" + book.BookID.ToString();
            link.Text = book.Title.ToString();
            link.Font.Size = 12;
            link.CssClass = "h4";

            rightcell1.Controls.Add(link);
            rightrow1.Cells.Add(rightcell1);
            celltable.Rows.Add(rightrow1);

            TableRow rightrow2 = new TableRow();
            TableCell rightcell2 = new TableCell();
           // rightcell2.CssClass = "td_row";
            rightcell2.Text = book.Author + "/" + book.Publisher + "/" + book.ISBN;

            rightrow2.Cells.Add(rightcell2);
            celltable.Rows.Add(rightrow2);

            TableRow rightrow3 = new TableRow();
            TableCell rightcell3 = new TableCell();
            //rightcell3.CssClass = "td_row";
            rightcell3.Text = "类型：" + book.Category;

            rightrow3.Cells.Add(rightcell3);
            celltable.Rows.Add(rightrow3);

            TableRow rightrow4 = new TableRow();
            TableCell rightcell4 = new TableCell();
            //rightcell4.CssClass = "td_row";
            rightcell4.Text = "评分：" + book.Score.ToString();

            rightrow4.Cells.Add(rightcell4);
            celltable.Rows.Add(rightrow4);

            cell2.Controls.Add(celltable);
            row.Cells.Add(cell2);
            TableCell cell3 = new TableCell();
            cell3.Width = 200;
            row.Cells.Add(cell3);
            hotbooktable.Rows.Add(row);
            
            n++;
            if (n > 2)
                break;
        }
    }

    

    /// <summary>
    /// 初始化系统推荐图书列表
    /// </summary>
    protected void InitRecommendTable()
    {
        //通过数据库得到对应用户id喜欢类型的图书id
        DataClassesDataContext db = new DataClassesDataContext();
        var books = db.ExecuteQuery<Book>("select * from Book where Category in (select FavBookCate from [User] where UserID = '" + Session["UserID"] + "') order by Score DESC");
        int n = 0;
        foreach (Book book in books)
        {
            TableRow row = new TableRow();
            row.CssClass = "s_item";

            TableCell cell = new TableCell();
            cell.CssClass = "tdstyle";

            ImageButton img = new ImageButton();
            img.ImageUrl = book.CoverImagePath.ToString();
            img.Width = 150;
            img.PostBackUrl = "~/BookWareHouse/CheckBook.aspx?BookID=" + book.BookID.ToString();

            cell.Controls.Add(img);
            cell.HorizontalAlign = HorizontalAlign.Left;
            row.Cells.Add(cell);


            TableCell cell2 = new TableCell();
            cell2.CssClass = "td_pad";
            cell2.HorizontalAlign = HorizontalAlign.Left;


            Table celltable = new Table();
            //celltable.CssClass = "tbstyle";
            celltable.HorizontalAlign = HorizontalAlign.Left;

            TableRow rightrow1 = new TableRow();
            TableCell rightcell1 = new TableCell();
            //rightcell1.CssClass = "td_row";
            rightcell1.HorizontalAlign = HorizontalAlign.Left;

            HyperLink link = new HyperLink();
            link.NavigateUrl = "~/BookWareHouse/CheckBook.aspx?BookID=" + book.BookID.ToString();
            link.Text = book.Title.ToString();
            link.Font.Size = 12;
            link.CssClass = "h4";

            rightcell1.Controls.Add(link);
            rightrow1.Cells.Add(rightcell1);
            celltable.Rows.Add(rightrow1);

            TableRow rightrow2 = new TableRow();
            TableCell rightcell2 = new TableCell();
            // rightcell2.CssClass = "td_row";
            rightcell2.Text = book.Author + "/" + book.Publisher + "/" + book.ISBN;

            rightrow2.Cells.Add(rightcell2);
            celltable.Rows.Add(rightrow2);

            TableRow rightrow3 = new TableRow();
            TableCell rightcell3 = new TableCell();
            //rightcell3.CssClass = "td_row";
            rightcell3.Text = "类型：" + book.Category;

            rightrow3.Cells.Add(rightcell3);
            celltable.Rows.Add(rightrow3);

            TableRow rightrow4 = new TableRow();
            TableCell rightcell4 = new TableCell();
            //rightcell4.CssClass = "td_row";
            rightcell4.Text = "评分：" + book.Score.ToString();

            rightrow4.Cells.Add(rightcell4);
            celltable.Rows.Add(rightrow4);

            cell2.Controls.Add(celltable);
            row.Cells.Add(cell2);
            TableCell cell3 = new TableCell();
            cell3.Width = 200;
            row.Cells.Add(cell3);
            recommendtable.Rows.Add(row);

            n++;
            if (n > 2)
                break;
        }
    }
}