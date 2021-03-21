using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class 书库_SearchBook : System.Web.UI.Page
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
            /*
            
           
            
            RadioButtonList1.Items.Add("书名");
            RadioButtonList1.Items.Add("作者");
            RadioButtonList1.Items.Add("出版社");
            RadioButtonList1.Items.Add("ISBN");
            RadioButtonList1.Items.Add("类型");
            RadioButtonList1.Items[0].Selected = true;*/
            
        }
    }


    /// <summary>
    /// 搜索按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void searchbotton_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)
        {
            int n = sel.SelectedIndex;
            string[] type = { "Title", "Author", "Publisher", "ISBN", "Category" };

            DataClassesDataContext db = new DataClassesDataContext();
            var books = db.ExecuteQuery<Book>("select * from Book where " + type[n] + " like \'%" + inputtextbox.Text + "%\'");
            

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
                cell.HorizontalAlign = HorizontalAlign.Right;
                row.Cells.Add(cell);


                TableCell cell2 = new TableCell();
                cell2.CssClass = "td_pad";
                cell2.HorizontalAlign = HorizontalAlign.Left;
                Table celltable = new Table();
                celltable.CssClass = "tbstyle";
                celltable.HorizontalAlign = HorizontalAlign.Left;

                TableRow rightrow1 = new TableRow();
                TableCell rightcell1 = new TableCell();
                rightcell1.CssClass = "td_row";
                rightcell1.HorizontalAlign = HorizontalAlign.Left;

                HyperLink link = new HyperLink();
                link.NavigateUrl = "~/BookWareHouse/CheckBook.aspx?BookID=" + book.BookID.ToString();
                link.Text = book.Title.ToString();
                link.Font.Size = 18;
                link.CssClass = "h4";

                rightcell1.Controls.Add(link);
                rightrow1.Cells.Add(rightcell1);
                celltable.Rows.Add(rightrow1);

                TableRow rightrow2 = new TableRow();
                TableCell rightcell2 = new TableCell();
                rightcell2.CssClass = "td_row";
                rightcell2.Text = book.Author + "/" + book.Publisher + "/" + book.ISBN;

                rightrow2.Cells.Add(rightcell2);
                celltable.Rows.Add(rightrow2);

                TableRow rightrow3 = new TableRow();
                TableCell rightcell3 = new TableCell();
                rightcell3.CssClass = "td_row";
                rightcell3.Text = "类型：" + book.Category;

                rightrow3.Cells.Add(rightcell3);
                celltable.Rows.Add(rightrow3);

                TableRow rightrow4 = new TableRow();
                TableCell rightcell4 = new TableCell();
                rightcell4.CssClass = "td_row";
                rightcell4.Text = "评分：" + book.Score.ToString();

                rightrow4.Cells.Add(rightcell4);
                celltable.Rows.Add(rightrow4);

                cell2.Controls.Add(celltable);
                row.Cells.Add(cell2);
                Table1.Rows.Add(row);
            }
        }
        
    }

    

    /// <summary>
    /// coustomvalidator的判断函数
    /// </summary>
    /// <param name="source"></param>
    /// <param name="args"></param>
    protected void CustomValidator1_ServerValidate1(object source, ServerValidateEventArgs args)
    {
        if (sel.SelectedIndex == 4)
        {
            string temp = inputtextbox.Text;
            if (temp == "文学" || temp == "流行" || temp == "文化" || temp == "生活" || temp == "经营" || temp == "科技")
            {
                args.IsValid = true;
            }
            else
            {
                args.IsValid = false;
            }
        }
        else
        {
            args.IsValid = true;
        }
    }

    /// <summary>
    /// 搜索按钮事件
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void Button1_Click1(object sender, EventArgs e)
    {

        if (Page.IsValid)
        {
            int n = sel.SelectedIndex;
            string[] type = { "Title", "Author", "Publisher", "ISBN", "Category" };

            DataClassesDataContext db = new DataClassesDataContext();
            var books = db.ExecuteQuery<Book>("select * from Book where " + type[n] + " like \'%" + inputtextbox.Text + "%\'");


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
                Table1.Rows.Add(row);


            }
        }
        
    }
}