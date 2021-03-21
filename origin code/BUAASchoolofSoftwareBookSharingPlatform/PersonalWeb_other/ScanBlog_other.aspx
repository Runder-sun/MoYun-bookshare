<%@ Page Title="" Language="C#" MasterPageFile="~/PersonalWeb_other/个人页面_other.master" AutoEventWireup="true" CodeFile="ScanBlog_other.aspx.cs" Inherits="PersonalWeb_ScanBlog_other" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <style>
 .TitleLable
 {
     font-size:15px;
     color:White;
     font-family:微软雅黑;
 }
.Hidlabel {    
    width:100%;
}
.t_area  
{
    height = 1000px;
    overflow:visible; 
}
</style>
<script language="javascript" type="text">
function BodyOnLoad() 
{ 
    var textarea= document.getElementById("textarea"); 
    textarea.Height = textare.scrollHeight;
    textarea.style.posHeight=textarea.scrollHeight; 
} 
</script>
<div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-window"></span>
                    </div>
                    <h1>日志浏览</h1>
                </div>

                <div class="row-fluid typography">
                    <div align="right">
                        <button id="recreate" runat="server" onserverclick="Recreate_onclick" class="btn btn-danger" type="button"><font size="3">转载日志</font></button>
                        <button id="return" runat="server" onserverclick="Return_onclick" class="btn btn-success" type="button"><font size="3">返回列表</font></button>
                        
                        </div>
                    <div><br \></div>
                    <div class="block">
                        <div class="head yellow">
                            <div class="icon"><i class="ico-grid"></i></div>
                            <asp:Label ID="title" runat="server" CssClass="TitleLable" ForeColor="#FF6600"></asp:Label>
                    </div>
                        <div class="data">
                            <div class="row-fluid">
                                <div class="span12">
                                   <asp:TextBox ID="content" runat="server" width="100%" Height="400px" 
                                        TextMode="MultiLine" BackColor="White" BorderStyle="None" ForeColor="#333333"></asp:TextBox>
                                </div>
                    
                       <div class="block">
                             <div class="head green">
                                
                                <div class="icon">
                                    <span class="ico-pen-2"></span></div>                              
                                
                                          <h2>评论日志</h2>                   
                          </div>
                          <div class="data-fluid editor">
                          <textarea id="comment" runat="server" style="height: 80px; width:100%" Height=80px>
                          </textarea>

                           </div>
                        </div> 
                            <asp:ScriptManager ID="ScriptManager1" runat="server">
                                </asp:ScriptManager>
                                <asp:UpdatePanel ID="UpdatePanel1" runat="server">
                                <ContentTemplate>    
                                

                        <div align="center"><button id="submit" runat="server" onserverclick="Submit_onclick" class="btn" type="button">
                        <font size="3">提交评论<span class="ico-pencil"></span></button>     
                    </div>
                            <div class="head blue">
                                <div class="icon"><span class="ico-pen-2"></span></div>
                                <h2>评论列表</h2>                             
                            </div>                
                            <div class="data-fluid">
                                <asp:GridView ID="GridView1" runat="server" cellpadding="0" width="100%" 
                                    class="table" DataSourceID="SqlDataSource1" AutoGenerateColumns="False" 
                                    AllowPaging="True" GridLines="None" PageSize="5">
                                    <Columns>
                                        <asp:BoundField HeaderText="CommenID" />
                                        <asp:HyperLinkField DataNavigateUrlFields="UserID" 
                                                 DataNavigateUrlFormatString="~/PersonalWeb_other/PersonalHome_other.aspx?HostID={0}" 
                                                 DataTextField="Name" HeaderText="姓名">
                                        </asp:HyperLinkField>
                                        <asp:BoundField HeaderText="评论" DataField="Content" />
                                        <asp:BoundField HeaderText="时间" DataField="DateTime" />
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
                                </asp:GridView >
                                <asp:SqlDataSource ID="SqlDataSource1" runat="server"
                                SelectCommand="SELECT * FROM [User], [BlogComment] WHERE
                                               [User].[UserID] = [BlogComment].[UserID] AND [BlogID] = @BlogID" 
                                Connectionstring="<%$ ConnectionStrings:BookSharingConnectionString %>">
                                <SelectParameters>
                                 <asp:QueryStringParameter Name="BlogID" QueryStringField="BlogID" Type="String" />
                                </SelectParameters>
          
                                </asp:SqlDataSource>
                                </ContentTemplate>
                                </asp:UpdatePanel>
                            </div>   
                         
                         <div><br \></div>
                        <div class="pagination pagination-centered pagination-small" align="center">
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

