<%@ Page Title="" Language="C#" MasterPageFile="~/QuanZi/圈子母版页.master" AutoEventWireup="true" CodeFile="ScanInfo.aspx.cs" Inherits="QuanZi_ScanInfo" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-window"></span>
                    </div>
                    <h1>我的导师</h1>
                </div>

                <div class="row-fluid typography">
                    <div><br \></div>
                    <div class="block">
                        <div class="head yellow">
                            <div class="icon"><i class="ico-grid"></i></div>
                            <h2>导师介绍</h2>
                        </div>
                        <div class="data">

                            
                            <div class="row-fluid">
                                <div class="span12">
                                   <div class="span4">
                                   <asp:Image ID="Image1" runat="server" class="img-polaroid" align="left" Width="200px"/> 
                                   </div>

                                   <div class="span8">
                                    <span>
                                        <div class="span6">
                                        <ul><font size="2px">
                                            <li>姓名:&nbsp;<asp:TextBox ID="name" runat="server" BackColor="White"></asp:TextBox></li><br \>
                                            <li>性别:&nbsp;<asp:TextBox ID="sex" runat="server" BackColor="White"></asp:TextBox></li><br \>
                                            <li>教授课程:&nbsp;<asp:TextBox ID="course" runat="server" BackColor="White"></asp:TextBox></li><br \>
                                            <li>手机号码:&nbsp;<asp:TextBox ID="tel" runat="server" BackColor="White"></asp:TextBox></li><br \>
                                            <li>联系地址:&nbsp;<asp:TextBox ID="address" runat="server" BackColor="White"></asp:TextBox></li><br \>
                                            <li>电子邮箱:&nbsp;<asp:TextBox ID="email" runat="server" BackColor="White"></asp:TextBox></li><br \>
                                     
                                            <asp:Button ID="Modify" CssClass="btn btn-success" runat="server" Text="修改信息" 
                                                    onclick="ModifyMessage_Click" />
                                            <asp:Button ID="Save" runat="server" Text="保存" CssClass="btn btn-success" />
                                                <br \>
                                        </ul>
                                        </div>

                                    </span> 
                                    </div>      
                                </div>
                                 
                            </div>
                           
                        </div>
                        
                    </div>

                    <div class="span12" align="right"> <button id="add" runat="Server" onserverclick="Add_onclick" class="btn btn-info"><font size="2">添加成员</font> <span class="ico-plus"></span></button></div>
                          
                     <div class="block">
                            
                            <div class="head blue">
                                <div class="icon"><span class="ico-pen-2"></span></div>
                                <h2>师出同门</h2>                             
                            </div>                
                            <div class="data-fluid">
                               <asp:GridView ID="GridView1" runat="server" cellpadding="0" width="100%" 
                                    class="table table-hover" AutoGenerateColumns="False" DataKeyNames="UserID"
                                    DataSourceID="SqlDataSource1" OnRowCommand="GridView1_RowCommand"
                                    GridLines="None" AllowPaging="True" PageSize="5">
                                    <Columns>
                                        <asp:HyperLinkField DataNavigateUrlFields="UserID" 
                                                 DataNavigateUrlFormatString="../PersonalWeb_other/ScanInfo.aspx?HostID={0}" 
                                                 DataTextField="UserID" HeaderText="账号"> 
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                            Width="30%"/>
                                        </asp:HyperLinkField>
                                        
                                        <asp:BoundField DataField="Name" HeaderText="姓名" 
                                            SortExpression="Name" >
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                            Width="30%"/>
                                        </asp:BoundField>
                                       
                                        <asp:BoundField DataField="Sex" HeaderText="性别" 
                                            SortExpression="Sex">
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                            Width="20%" />
                                        </asp:BoundField>

                                       
                                        <asp:TemplateField ShowHeader="True" HeaderText="操作">
                                             <ItemTemplate>  
                                                <asp:Button ID="LinkButton2" runat="server" CausesValidation="False" CommandName="Scan"  
                                                       Text="详细信息" CssClass="btn btn-success" CommandArgument= '<%#Eval("UserID")%>'></asp:Button>  
                                                </ItemTemplate>  
                                             <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                                 Width="10%"/>
                                        </asp:TemplateField>
                                         <asp:TemplateField ShowHeader="False">
                                             <ItemTemplate>  
                                                <asp:Button ID="LinkButton1" runat="server" CausesValidation="False" CommandName="Del"  
                                                      Text="删除" CssClass="btn btn-warning" CommandArgument= '<%#Eval("UserID")%>'></asp:Button>  
                                                </ItemTemplate>  
                                             <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                                 Width="10%"/>
                                        </asp:TemplateField>
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
           SelectCommand="SELECT * FROM [User] WHERE [User].[QuanZiID] = @QuanZiID AND [User].[Identity] != '教师'">
           <SelectParameters>
             <asp:SessionParameter Name="QuanZiID" SessionField="QuanZiID" Type="Int16" />
          </SelectParameters>
        </asp:SqlDataSource>
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

