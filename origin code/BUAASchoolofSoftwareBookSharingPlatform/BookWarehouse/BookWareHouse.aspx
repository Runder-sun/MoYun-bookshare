<%@ Page Title="" Language="C#" MasterPageFile="~/BookWareHouse/书库母版页.master" AutoEventWireup="true" CodeFile="BookWareHouse.aspx.cs" Inherits="书库_BookWareHouse" %>

<%@ Register src="followbooktable.ascx" tagname="followbooktable" tagprefix="uc1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">

 <div class="content_book">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-book"></span>
                    </div>
                    <h1>热门书籍</h1>
                </div>

                <asp:table id = "hotbooktable" runat = "server" class="row-fluid">

                </asp:table>

                

                

                <div class="page-header">
                    <div class="icon">
                        <span class="ico-book"></span>
                    </div>
                    <h1>为你推荐</h1>
                </div>

                <asp:table id = "recommendtable" runat = "server" class="row-fluid">

                </asp:table>
                </div>
          <div class="content_recommend">
                <uc1:followbooktable ID="followbooktable1" runat="server" />
          </div>      
              
    
    
</asp:Content>

