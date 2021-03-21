<%@ Page Title="" Language="C#" MasterPageFile="~/QuanZi/圈子母版页.master" AutoEventWireup="true" CodeFile="QuanZiIndex.aspx.cs" Inherits="QuanZi_QuanZiIndex" %>

<%@ Register src="QuanZiRecommendBookList.ascx" tagname="QuanZiRecommendBookList" tagprefix="uc1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">

    <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-layout-7"></span>
                    </div>
                    <h1>圈子主页</h1>
                </div>
                
                <div class="row-fluid">
                     <div class="span12">
                        <div class="block">
                            <div class="head yellow">                        
                                <div class="icon"><i class="ico-grid"></i></div>
                                <h2>新鲜事</h2>
                            </div>  
                             
                            <div class="data-fluid">
                                <asp:GridView ID="GridView1" runat="server" cellpadding="0" width="100%" 
                                    class="table table-hover" AutoGenerateColumns="False" DataKeyNames="NewsID"
                                    DataSourceID="SqlDataSource1" OnRowCommand="GridView1_RowCommand"
                                    GridLines="None">
                                    <Columns>

                                        <asp:TemplateField ShowHeader="False">
                                             <ItemTemplate>
                                             <asp:Image ID="Image1" runat="server" ImageUrl='<%# Bind("UserImagePath") %>'
                                                  Width="120px" />
                                             </ItemTemplate>
                                        </asp:TemplateField>

                                        <asp:HyperLinkField DataNavigateUrlFields="HyperLink"
                                                 DataTextField="Title" HeaderText="新鲜事内容">
                                        </asp:HyperLinkField>

                                        <asp:BoundField DataField="DateTime" HeaderText="发布时间" >
                                        </asp:BoundField>
                                                                                
                                    </Columns>
                                    <PagerSettings Mode="NumericFirstLast" />
                                    <PagerTemplate>
         <br />
         <div class="span12">
         <div class="block">
         <asp:Label ID="lblPage" runat="server" CssClass="class3" Text='<%# "第" + (((GridView)Container.NamingContainer).PageIndex + 1)  + "页/共" + (((GridView)Container.NamingContainer).PageCount) + "页" %> '></asp:Label>
         <asp:LinkButton ID="lbnFirst" runat="Server" Text="首页"  Enabled='<%# ((GridView)Container.NamingContainer).PageIndex != 0 %>' CommandName="Page" CommandArgument="First" ></asp:LinkButton>
        <asp:LinkButton ID="lbnPrev" runat="server" Text="上一页" Enabled='<%# ((GridView)Container.NamingContainer).PageIndex != 0 %>' CommandName="Page" CommandArgument="Prev"  ></asp:LinkButton>
        <asp:LinkButton ID="lbnNext" runat="Server" Text="下一页" Enabled='<%# ((GridView)Container.NamingContainer).PageIndex != (((GridView)Container.NamingContainer).PageCount - 1) %>' CommandName="Page" CommandArgument="Next" ></asp:LinkButton>
         <asp:LinkButton ID="lbnLast" runat="Server" Text="尾页" Enabled='<%# ((GridView)Container.NamingContainer).PageIndex != (((GridView)Container.NamingContainer).PageCount - 1) %>' CommandName="Page" CommandArgument="Last" ></asp:LinkButton>
         到第
         
         <asp:TextBox runat="server" ID="inPageNum" CssClass="class2" Width="10%"></asp:TextBox>
         页<asp:Button ID="Button1" Text="Go" CssClass="btn" CommandName="go" runat="server" />
         </div>
         </div>
         </div>
         <br />
     </PagerTemplate>
     </asp:GridView>
       <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConnectionString="<%$ ConnectionStrings:BookSharingConnectionString %>" 
           SelectCommand="SELECT * FROM [User],[News] WHERE [User].[UserID] = [News].[UserID] AND [News].[QuanZiID] = @QuanZiID">
           <SelectParameters>
        <asp:SessionParameter Name="QuanZiID" SessionField="QuanZiID" Type="String" />
         </SelectParameters>
        </asp:SqlDataSource>
     <br />
                    </div>                
                </div>
                </div>
                
            </div>
            
        
</asp:Content>

