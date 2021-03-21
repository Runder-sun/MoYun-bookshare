<%@ Page Title="" Language="C#" MasterPageFile="~/PersonalWeb/个人页面母版页.master" AutoEventWireup="true" CodeFile="BlogList.aspx.cs" Inherits="PersonalWeb_BlogList" %>

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
<script language="javascript">
        function SelectChecked() {
        var t = document.getElementsByTagName("input");

        for (var i = 0; i < t.length; i++) {
            if (t[i].type == "checkbox" && t[i].name.indexOf("cbChecked") != -1) {
                t[i].checked = document.all.item("cbHeaderChecked").checked;
            }
        }
    }
    </script>
                                        <script language="javascript" type="text/jscript">
                                            function CheckForm() {
                                                SelectChecked();
                                           var m = 0;
                                           var t = document.getElementsByTagName("input");    //获取页面中类型为input的元素个数

                                           for (var i = 0; i < t.length; i++) {
                                               //判断是不是CheckBox控件，并通过名称indexOf("cbChecked") != -1方法来判断是不是GridView中的CheckBox,还判断了是不处理选中状态
                                               if (t[i].type == "checkbox" && t[i].name.indexOf("cbChecked") != -1 && t[i].checked == true) {
                                                   m++;
                                               }
                                           }

                                           if (m == 0) {
                                               alert("请选择想要处理的项！");
                                               return false;
                                           }
                                           else {
                                               return confirm('您确定要处理选中的项吗？');
                                           }
                                       }
                                   </script>
                <div class="content">
                
                <div class="page-header">
                    <div class="icon">
                        <span class="ico-layout-7"></span>
                    </div>
                    <h1>我的日志</h1>
                </div>

                <div class="row-fluid">
                    <div class="span12">
                      
                        <div align="right"><button id="WriteBlog" runat="server" class="btn" type="button" onserverclick="WB_onclick"><font size="3">撰写日志</button>
                        <button id="DeleteALot" runat="server" class="btn btn-warning" type="button" onserverclick="DAL_onclick"><font size="3">批量删除</button>
                        </div>
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
                            <asp:ScriptManager ID="ScriptManager1" runat="server">
                            </asp:ScriptManager>
                            <asp:UpdatePanel ID="UpdatePanel1" runat="server">
                            <ContentTemplate>
                                <asp:GridView ID="GridView1" runat="server" cellpadding="0" width="100%" 
                                    class="table table-hover" AutoGenerateColumns="False" DataKeyNames="BlogID"
                                    DataSourceID="SqlDataSource1" OnRowCommand="GridView1_RowCommand"
                                    GridLines="None">
                                    <Columns>
                                        
                                        <asp:TemplateField HeaderText="测试">
                                            <HeaderTemplate>
                                               <input id="cbHeaderChecked" name="cbHeaderChecked" onclick="return SelectChecked()" type="checkbox" /><!--在头部增加CheckBox全选/全消选择框-->
                                            </HeaderTemplate>
                                            <ItemTemplate>
                                               <input id="cbChecked" runat="server" name="cbChecked" type="checkbox" /><!--为绑定的每一行增加选择框-->
                                               <input id="HiddenSysCode" runat="server" style="width: 193px" type="hidden" value='<%# Eval("BlogID")%>' /><!--这行很重要，它在一个隐藏控件里放置了一个字段的值，该字段的值将会在按钮事件处理CheckBox选中项的操作中用到-->
                                            </ItemTemplate>
                                            <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                                Width="5%" />
                                        </asp:TemplateField>
                                        
                                        <asp:BoundField DataField="BlogID" InsertVisible="False" ReadOnly="True" 
                                            SortExpression="BlogID" HeaderText="BlogID" >
                                         
                                       
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1"/>
                                        </asp:BoundField>
                                       
                                        <asp:HyperLinkField DataNavigateUrlFields="BlogID" 
                                                 DataNavigateUrlFormatString="ScanBlog.aspx?BlogID={0}" 
                                                 DataTextField="Title" HeaderText="博客标题">
                                        
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                            Width="35%"/>
                                        </asp:HyperLinkField>
                                        
                                        <asp:BoundField DataField="DateTime" HeaderText="发布时间" 
                                            SortExpression="DateTime" >
                                        
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                            Width="25%"/>
                                        </asp:BoundField>
                                       
                                        <asp:BoundField DataField="VisitNumber" HeaderText="浏览量" 
                                            SortExpression="VisitNumber">
                                        
                                        <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                            Width="15%" />
                                        </asp:BoundField>
                                        
                                        <asp:TemplateField HeaderText="操作">
                                             <ItemTemplate>  
                                                <asp:Button ID="LinkButton1" runat="server" CausesValidation="False" CommandName="Del"  
                                                     CssClass="btn btn-warning"  Text="删除" CommandArgument= '<%#Eval("BlogID")%>'></asp:Button>  
                                                </ItemTemplate>  
                                             <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" CssClass="class1" 
                                                 Width="10%"/>
                                        </asp:TemplateField>
                                        <asp:TemplateField ShowHeader="False">
                                             <ItemTemplate>  
                                                <asp:Button ID="LinkButton2" runat="server" CausesValidation="False" CommandName="edit" Text="编辑" CssClass="btn btn-info" CommandArgument= '<%#Eval("BlogID")%>'/>
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
           SelectCommand="SELECT [BlogID], [Title], [DateTime], [VisitNumber] FROM [Blog] WHERE ([UserID] = @UserID)">
           <SelectParameters>
        <asp:SessionParameter Name="UserID" SessionField="HostID" Type="String" />
         </SelectParameters>
        </asp:SqlDataSource></ContentTemplate>
        </asp:UpdatePanel>
    
     <br />    
                    </div>                
                </div>
                
            </div>
           
</asp:Content>

