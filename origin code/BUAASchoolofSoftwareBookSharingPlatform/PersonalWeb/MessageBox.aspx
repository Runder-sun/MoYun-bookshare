<%@ Page Title="" Language="C#" MasterPageFile="~/PersonalWeb/个人页面母版页.master" AutoEventWireup="true" CodeFile="MessageBox.aspx.cs" Inherits="PersonalWeb_MessageBox" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-window"></span>
                    </div>
                    <h1>留言通讯</h1>
                </div>

                <div class="row-fluid typography">
                     <div><br \></div>

                    <div class="block">
                            <div class="head orange">
                                <div class="icon"><span class="ico-pen-2"></span></div>                              
                                <h2>撰写留言</h2>                   
                            </div>
                            <div class="data-fluid editor">

                                <asp:TextBox ID="reply" runat="server" width="100%" Height="80px" 
                                TextMode="MultiLine" BackColor="White" BorderStyle="NotSet" ForeColor="Black"></asp:TextBox>
                                
                                
                                <!--<asp:TextBox ID="content" runat="server" style="height: 300px;" 
                                    TextMode="MultiLine" Width="1060px"></asp:TextBox>-->
                            <div><br \></div>
                            </div>
                        <div align="center"><button id="submit" runat="server" onserverclick="Submit_onclick" class="btn btn-info" type="button"><font size="3">发表留言<span class="ico-pencil"></span></button></div>
                        </div> 
                    <div><br \><br \></div> 
                     <div class="block">
                            <div class="head green">
                                <div class="icon"><span class="ico-pen-2"></span></div>
                                <h2>留言列表</h2>                             
                            </div>                
                            <div class="data-fluid">
                                
                                <asp:GridView ID="GridView1" runat="server" cellpadding="0" width="100%" 
                                    class="table table-hover" AutoGenerateColumns="False" DataKeyNames="LeaveMessageID"
                                    DataSourceID="SqlDataSource1" OnRowCommand="GridView1_RowCommand"
                                    GridLines="None" AllowPaging="True" PageSize="5">
                                    <Columns>
                                        <asp:HyperLinkField DataNavigateUrlFields="UserID" 
                                                 DataNavigateUrlFormatString="~/PersonlaWeb_other/PersonalHome_other.aspx?" 
                                                 DataTextField="Name" HeaderText="姓名">
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                            Width="15%"/>
                                        </asp:HyperLinkField>

                                        <asp:BoundField DataField="Content" HeaderText="留言" 
                                            SortExpression="Content" >
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                            Width="35%"/>
                                        </asp:BoundField>
                                       
                                        <asp:BoundField DataField="DateTime" HeaderText="日期" 
                                            SortExpression="Datetime">
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                            Width="30%" />
                                        </asp:BoundField>
                                        
                                        <asp:TemplateField ShowHeader="True" HeaderText="操作">
                                             <ItemTemplate>  
                                                <asp:Button ID="LinkButton1" runat="server" CausesValidation="False" CommandName="Del"  
                                                       CssClass="btn" Text="删除" CommandArgument= '<%#Eval("LeaveMessageID")%>'></asp:Button>  
                                                </ItemTemplate>  
                                             <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                                 Width="10%"/>
                                        </asp:TemplateField>

                                        <asp:TemplateField ShowHeader="False">
                                             <ItemTemplate>  
                                                <asp:Button ID="LinkButton2" runat="server" CausesValidation="False" CommandName="Reply"  
                                                      CssClass="btn btn-primary" Text="回复" CommandArgument= '<%#Eval("Name")%>'></asp:Button>  
                                                </ItemTemplate>  
                                             <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                                 Width="10%"/>
                                        </asp:TemplateField>
           
                                    </Columns>
                                    <PagerSettings Mode="NumericFirstLast" />
                                    <PagerTemplate>
         <br />
         <div class="span10" align="right">
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
           SelectCommand="SELECT * FROM [User], [LeaveMessage] WHERE [User].[UserID] = [LeaveMessage].[UserID]
                          AND [LeaveMessage].[HostID] = @UserID">
           <SelectParameters>
        <asp:SessionParameter Name="UserID" SessionField="UserID" Type="String" />
         </SelectParameters>
        </asp:SqlDataSource>
     <br />
                                      
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

