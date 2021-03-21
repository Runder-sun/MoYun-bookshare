<%@ Page Title="" Language="C#" MasterPageFile="~/PersonalWeb/个人页面母版页.master" AutoEventWireup="true" CodeFile="FriendList.aspx.cs" Inherits="PersonalWeb_FriendList" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-window"></span>
                    </div>
                    <h1>小伙伴们</h1>
                </div>

                <div class="row-fluid typography">
                    <div class="block" align="right"> 
                      <div class="span5">
                        <div class="input-append">
                         <input type="text" align="right">      
                         <button class="btn btn-warning" type="button" align="right"><font size="2">搜索好友</font><span class="ico-magnifier"></span></button>                                                    
                        </div>
                      </div>
                    </div>    
                    <div><br \></div>
                     <div class="block">
                            <div class="head blue">
                                <div class="icon"><span class="ico-pen-2"></span></div>
                                <h2>好友列表</h2>                             
                            </div>                
                            <div class="data-fluid">
                                    <asp:GridView ID="GridView1" runat="server" cellpadding="0" width="100%" 
                                    class="table table-hover" AutoGenerateColumns="False" DataKeyNames="UserID"
                                    DataSourceID="SqlDataSource1" AllowPaging="True"
                                    GridLines="None">
                                    <Columns>
                                        <asp:HyperLinkField DataNavigateUrlFields="UserID" 
                                                 DataNavigateUrlFormatString="../PersonalWeb_other/PersonalHome_other.aspx?HostID={0}" 
                                                 DataTextField="Name" HeaderText="姓名">
                                         <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1"/>
                                        </asp:HyperLinkField>
                                       
                                        <asp:BoundField DataField="UserID" HeaderText="学号" 
                                            SortExpression="Name" >
                                        
                                        </asp:BoundField>
                                       
                                        <asp:BoundField DataField="Sex" HeaderText="性别" 
                                            SortExpression="Sex">
                                        
                                        </asp:BoundField>
                                        <asp:BoundField DataField="Grade" HeaderText="年级" SortExpression="Grade" />
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
           
                                    
                                    
                                    SelectCommand="SELECT [Name], [UserID], [Sex], [Grade] FROM [User] WHERE (([QuanZiID] IS NOT NULL) AND ([QuanZiID] = @QuanZiID) AND ([UserID] NOT LIKE '%' + @UserID + '%'))">
           <SelectParameters>
               <asp:SessionParameter Name="QuanZiID" SessionField="QuanZiID" Type="Int16" />
               <asp:SessionParameter Name="UserID" SessionField="UserID" Type="String" />
           </SelectParameters>
        </asp:SqlDataSource>
     <br />
                    </div>                
                </div>
                
            </div>
                        </div>           

                </div>                  
                
            </div>
    
    <script>

        var ckeditor = CKEDITOR.replace('ckeditor');

        CKEDITOR.disableAutoInline = true;
        CKEDITOR.inline('editable');

    </script>                            
                                
</asp:Content>

