<%@ Page Title="" Language="C#" MasterPageFile="~/QuanZi/圈子母版页.master" AutoEventWireup="true" CodeFile="ForumList.aspx.cs" Inherits="QuanZi_ForumList" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="content">
<div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-arrow-right"></span>
                    </div>
                    <h1>论坛</h1>
                </div>
                <div class="block">
                        <div class="span10">
                        <div align="right"><button id="create" runat="server" class="btn btn-success" type="button" onserverclick="WB_onclick"><font size="2">发起讨论</font></button>
                        </div>
                            <div class="head blue">
                                <div class="icon"><span class="ico-user"></span></div>
                                <h2>讨论列表</h2>                                                             
                            </div>              
                            <div class="data-fluid">
                                  <asp:GridView ID="GridView1" runat="server" cellpadding="0" width="100%" 
                                    class="table table-hover" AutoGenerateColumns="False" DataKeyNames="ForumID"
                                    DataSourceID="SqlDataSource1" OnRowCommand="GridView1_RowCommand"
                                    GridLines="None">
                                    <Columns>
                                        <asp:HyperLinkField DataNavigateUrlFields="ForumID" 
                                                 DataNavigateUrlFormatString="Forum.aspx?ForumID={0}" 
                                                 DataTextField="Theme" HeaderText="讨论主题"> 
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1"/>
                                        </asp:HyperLinkField>
                                        
                                        <asp:BoundField DataField="DateTime" HeaderText="时间" 
                                            SortExpression="DateTime" >
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1"/>
                                        </asp:BoundField>

                                        <asp:BoundField DataField="Name" HeaderText="发帖人" 
                                            SortExpression="Name" >
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1"/>
                                        </asp:BoundField>
                                        
                                    </Columns>
                                    <PagerSettings Mode="NumericFirstLast" />
                                    <PagerTemplate>
         <br />
         <div class="span10">
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
           SelectCommand="SELECT [Forum].[ForumID],[Forum].Theme,[Forum].[DateTime],[User].Name FROM
        [User],[Forum] WHERE [User].[UserID] = [Forum].[UserID]
        AND [Forum].[QuanZiID] = @QuanZiID">
        <SelectParameters>
             <asp:SessionParameter Name="QuanZiID" SessionField="QuanZiID" Type="Int16" />
        </SelectParameters>
        </asp:SqlDataSource>
                            </div> 
                        
                        </div> 
                
            </div>

</asp:Content>

