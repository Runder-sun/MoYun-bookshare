<%@ Page Title="" Language="C#" MasterPageFile="~/BookWareHouse/书库母版页.master" AutoEventWireup="true" CodeFile="SearchBook.aspx.cs" Inherits="书库_SearchBook" %>

<%@ Register src="followbooktable.ascx" tagname="followbooktable" tagprefix="uc1" %>
 <asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
 <div class="content">
                <div class="page-header">
                     <div class="icon">
                        <span class="ico-address-book-2"></span>
                        </div>
                    <h1>检索图书</h1>
                </div>

   <div class="row-fluid">
    <div class="span12">
        <asp:Label ID="Label5" runat="server" Text="检索类型：" font="2px"></asp:Label>
        
                                        <select id="sel" runat="server" name="s_example" class="select" >
                                            <option value="0">书名</option>
                                            <option value="1">作者</option>
                                            <option value="2">出版社</option>
                                            <option value="3">ISBN</option>
                                            <option value="4">类型</option>                                                                     
                                        </select>
                                
        <div><br /></div>
        <asp:Label ID="Label6" runat="server" Text="检索内容：" font="2px"></asp:Label>
        <asp:TextBox ID="inputtextbox" runat="server" ValidationGroup="aaa"></asp:TextBox>
        <asp:Button ID="Button1" runat="server" CssClass="btn-danger active" 
            onclick="Button1_Click1" Text="检索" ValidationGroup="aaa" font="2px"/>
        <br />
        <asp:Label ID="Label7" runat="server" Width="100px"></asp:Label>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
            ControlToValidate="inputtextbox" Display="Dynamic" ErrorMessage="不能为空" 
            ForeColor="Red" ValidationGroup="aaa"></asp:RequiredFieldValidator>
        <asp:CustomValidator ID="CustomValidator1" runat="server" 
            ControlToValidate="inputtextbox" Display="Dynamic" 
            ErrorMessage="类型只能为文学、流行、文化、生活、经管、科技" ForeColor="Red" 
            onservervalidate="CustomValidator1_ServerValidate1" ValidationGroup="aaa"></asp:CustomValidator>
        <br />
        <br />
        <asp:Table ID="Table1" runat="server">
        </asp:Table>
                </div></div>
    </div>            
</asp:Content>

