<%@ Page Title="" Language="C#" MasterPageFile="~/QuanZi/圈子母版页.master" AutoEventWireup="true" CodeFile="Forum.aspx.cs" Inherits="QuanZi_Forum_" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-arrow-right"></span>
                    </div>
                    <h1>论坛</h1>
                </div>
                <asp:ScriptManager ID="ScriptManager1" runat="server">
                </asp:ScriptManager>
                <asp:UpdatePanel ID="UpdatePanel1" runat="server">
                <ContentTemplate>
         
                <div class="block"> 
                            <div class="head blue">
                                <div class="icon"><span class="ico-user"></span></div>
                                <h2>讨论区</h2>                                                             
                            </div>              
                             
                            <div class="data-fluid">
                                  <asp:GridView ID="GridView1" runat="server" cellpadding="0" width="100%" 
                                    class="table table-hover" AutoGenerateColumns="False" DataKeyNames="ParticipantID"
                                    DataSourceID="SqlDataSource1" OnRowCommand="GridView1_RowCommand"
                                    GridLines="None" AllowPaging="True">
                                    <Columns>

                                        <asp:TemplateField ShowHeader="False">
                                             <ItemTemplate>
                                             <asp:Image ID="Image1" runat="server" ImageUrl='<%# Bind("UserImagePath") %>'
                                                  Width="120px" />
                                             </ItemTemplate>
                                        </asp:TemplateField>
                                        
                                        <asp:HyperLinkField DataNavigateUrlFields="UserID" 
                                                 DataNavigateUrlFormatString="../PersonalWeb_other/PersonalHome_other.aspx?HostID={0}" 
                                                 DataTextField="Name" HeaderText="姓名"> 
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1"/>
                                        </asp:HyperLinkField>

                                        <asp:BoundField DataField="Content" HeaderText="内容" 
                                            SortExpression="Content">
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" />
                                        </asp:BoundField>
                                        
                                        <asp:BoundField DataField="DateTime" HeaderText="时间" 
                                            SortExpression="DateTime">
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" />
                                        </asp:BoundField>

                                        <asp:TemplateField ShowHeader="False">
                                             <ItemTemplate>  
                                                <asp:Button ID="LinkButton2" runat="server" CausesValidation="False" CommandName="Reply"  
                                                       Text="回复" CssClass="btn btn-success" CommandArgument= '<%#Eval("ForumID")%>'></asp:Button>  
                                                </ItemTemplate>  
                                             <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1"/>
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
           SelectCommand="SELECT * FROM [User],[Forum],[Participant] WHERE [User].[UserID] = [Participant].[UserID] 
                          AND [Forum].[ForumID] = [Participant].[ForumID] AND [Forum].[ForumID] = @ForumID">
        <SelectParameters>
            <asp:QueryStringParameter Name="ForumID" runat="server" QueryStringField="ForumID" Type="String" />
        </SelectParameters>
        </asp:SqlDataSource>

        <div class="row-form">
        <div class="span9">
        <div class="head purple">
                                <div class="icon"><span class="ico-comment"></span></div>
                                <h2>回复</h2>                                                             
                </div> 
                        <textarea id="reply" runat="server" style="height: 80px; width:100%" Height=80px>
                          </textarea></div>
                    <div class="span12" align="center">
                        <br \>
                        <button id="reply1" runat="Server" onserverclick="Reply_onclick" class="btn btn-warning"><font size="2">回复帖子</font> </button>
                        <button id="Return" runat="server" onserverclick="Return_onclick" class="btn btn-info"><font size="2">返回列表</font> </button>
                    </div>
                
       </div>
                            </div>
                </ContentTemplate>
                </asp:UpdatePanel> 
                        
                        </div> 
                
            </div>

</asp:Content>

