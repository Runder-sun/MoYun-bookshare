<%@ Page Title="" Language="C#" MasterPageFile="~/PersonalWeb_other/个人页面_other.master" AutoEventWireup="true" CodeFile="BlogList_other.aspx.cs" Inherits="PersonalWeb_Blog_other" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <style>
.class1
{
    border-top-style: none;
    border-bottom: blue 1px dashed;
}
.class2
{
    width:30%;
    height:10%;
}
.class3
{
    margin-left:250px;
}
</style>

                <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-layout-7"></span>
                    </div>
                    <h1>
                        <asp:Label ID="HostName" runat="server" Text="Label"></asp:Label>
                        的日志</h1>
                </div>

                <div class="row-fluid">
                    <div class="span12">
                        <div><br \></div>
                        <div class="block">
                            <div class="head green">
                                <div class="icon"><span class="ico-brush"></span></div>
                                <h2>日志列表</h2>    
                                <ul class="buttons">
                                    <li><a href="#" onClick="source('table_hover_check'); return false;"><div class="icon"><span class="ico-info"></span></div></a></li>
                                </ul>                                                          
                            </div>                
                            <div class="data-fluid">
                                <asp:GridView ID="GridView1" runat="server" cellpadding="0" width="100%" 
                                    class="table table-hover" AutoGenerateColumns="False" DataKeyNames="BlogID"
                                    DataSourceID="SqlDataSource1" AllowPaging="True"
                                    GridLines="None">
                                    <Columns>
                                        
                                        <asp:BoundField DataField="BlogID" InsertVisible="False" ReadOnly="True" 
                                            SortExpression="BlogID" HeaderText="BlogID" >
     
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1"/>
                                        </asp:BoundField>
                                       
                                        <asp:HyperLinkField DataNavigateUrlFields="BlogID" 
                                                 DataNavigateUrlFormatString="ScanBlog_other.aspx?BlogID={0}" 
                                                 DataTextField="Title" HeaderText="博客标题">
                                        
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1"/>
                                        </asp:HyperLinkField>
                                        
                                        <asp:BoundField DataField="DateTime" HeaderText="发布时间" 
                                            SortExpression="DateTime" >
                                        
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1"/>
                                        </asp:BoundField>
                                       
                                        <asp:BoundField DataField="VisitNumber" HeaderText="浏览量" 
                                            SortExpression="VisitNumber">
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" />
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
           SelectCommand="SELECT [BlogID], [Title], [DateTime], [VisitNumber] FROM [Blog] WHERE ([UserID] = @UserID)">
           <SelectParameters>
        <asp:SessionParameter Name="UserID" SessionField="HostID" Type="String" />
         </SelectParameters>
        </asp:SqlDataSource>
     <br />
                    </div>                
                </div>
                
            </div>
           
</asp:Content>

